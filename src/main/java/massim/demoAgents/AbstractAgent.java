package massim.demoAgents;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import Messages.HerdGroup;
import de.dailab.jiactng.agentcore.AbstractAgentBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.comm.ICommunicationBean;
import de.dailab.jiactng.agentcore.comm.IMessageBoxAddress;
import de.dailab.jiactng.agentcore.comm.message.JiacMessage;
import de.dailab.jiactng.agentcore.knowledge.IFact;
import de.dailab.jiactng.agentcore.ontology.AgentDescription;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;
import org.sercho.masp.space.event.SpaceEvent;
import org.sercho.masp.space.event.SpaceObserver;
import org.sercho.masp.space.event.WriteCallEvent;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
/**
 * Created by mahnoosh on 10/28/2016.
 */
public abstract class AbstractAgent extends AbstractAgentBean {
    @SuppressWarnings("serial")
    class SocketClosedException extends Exception {}
    private int port;
    private String host;
    private InetSocketAddress socketaddress;
    private Socket socket;
    private InputStream inputstream;
    private OutputStream outputstream;
    public String username;
    private String password;
    private  String sim_start[];
    public Element getEl_root() {
        return el_root;
    }
    public void setEl_root(Element el_root) {
        this.el_root = el_root;
    }
    protected DocumentBuilderFactory documentbuilderfactory;
    private TransformerFactory transformerfactory;
    public  Element el_root;
    private IActionDescription sendAction = null;
    public String getDate() {
        Date dt = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH-mm-ss_dd-MM-yyyy");
        return df.format(dt);
    }
    public AbstractAgent() {

        host = "localhost";
        port = 12300;

        socket = new Socket();
        documentbuilderfactory=DocumentBuilderFactory.newInstance();
        transformerfactory = TransformerFactory.newInstance();
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port=port;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username=username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password=password;
    }
    public void sendAuthentication(String username, String password) throws IOException{

        try {
            Document doc = documentbuilderfactory.newDocumentBuilder().newDocument();
            Element root = doc.createElement("message");
            root.setAttribute("type","auth-request");
            doc.appendChild(root);

            Element auth = doc.createElement("authentication");
            auth.setAttribute("username",username);
            auth.setAttribute("password",password);
            root.appendChild(auth);
            this.sendDocument(doc);

        } catch (ParserConfigurationException e) {
            System.err.println("unable to create new document for authentication.");
            e.printStackTrace();
        }
    }
    public boolean receiveAuthenticationResult() throws IOException {

        try {
            Document doc = receiveDocument();
            Element root = doc.getDocumentElement();
            if (root==null) return false;
            if (!root.getAttribute("type").equalsIgnoreCase("auth-response")) return false;
            NodeList nl = root.getChildNodes();
            Element authresult = null;
            for (int i=0;i<nl.getLength();i++) {
                Node n = nl.item(i);
                if (n.getNodeType()==Element.ELEMENT_NODE && n.getNodeName().equalsIgnoreCase("authentication")) {
                    authresult = (Element) n;
                    break;
                }
            }
            if (!authresult.getAttribute("result").equalsIgnoreCase("ok")) return false;
        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return false;
        } catch (SocketClosedException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
    @SuppressWarnings("static-access")
    private class HandleHerdGroup implements SpaceObserver<IFact> {
        @SuppressWarnings("unchecked")
        public void notify(SpaceEvent<? extends IFact> event) {
            //if (event instanceof WriteCallEvent) {
            Object object = ((WriteCallEvent) event).getObject();
            if (object instanceof JiacMessage) {
                IFact msg = ((JiacMessage) object).getPayload();
                boolean flag=false;
                Method m = null;

                try {
                    if(msg.toString().contains("HerdGroup"))
                    {
                        m = msg.getClass().getMethod("getMessage");
                        String returnVal = (String) m.invoke(msg);
                    }
//
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (InvocationTargetException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (IllegalAccessException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (Exception e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }


            }//}
        }
    }
    public boolean doAuthentication(String username, String password) throws IOException {
        sendAuthentication(username, password);
        return receiveAuthenticationResult();
    }
    public byte[] receivePacket() throws IOException, SocketClosedException{

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int read = inputstream.read();
        while (read!=0) {
            if (read==-1) {
                throw new SocketClosedException();
            }
            buffer.write(read);
            read = inputstream.read();
        }
        String s = "Server -> Agent: AgentName " +this.username+"\n"+buffer.toString();
        //System.err.println(s);
        return buffer.toByteArray();
    }
    public Document receiveDocument() throws SAXException, IOException, ParserConfigurationException, SocketClosedException {

        byte[] raw = receivePacket();
        Document doc = documentbuilderfactory.newDocumentBuilder().parse(new ByteArrayInputStream(raw));
        return doc;
    }
    @Override
    public void doStart() throws Exception {
        super.doStart();


        IActionDescription template = new Action(ICommunicationBean.ACTION_SEND);
        sendAction = memory.read(template);
        if (sendAction == null) {
            sendAction = thisAgent.searchAction(template);
        }

        if (sendAction == null)
            throw new RuntimeException("Send action not found.");
        //////////////////////////////////////////////////////////////////////////////waiting for link

        socketaddress = new InetSocketAddress(host,port);
        socket.connect(socketaddress);
        inputstream = socket.getInputStream();
        outputstream = socket.getOutputStream();

        boolean auth = doAuthentication(username, password);
        if (!auth) {
            // System.err.println("Authentication failed");
            return;
        }

        try{
            Document doc = null;

            try {
                doc = receiveDocument();

            } catch (SAXException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            el_root = doc.getDocumentElement();
            if (el_root == null) {
                //   System.err.println("No document element found");

            }

            if (el_root == null) {
                // System.err.println("No document element found");

            }

            if (el_root.getNodeName().equals("message")) {
                //  processMessage(el_root);
            } else {
                //  System.err.println("Unknown document received");
            }
//
            //  System.out.println(getBeanName()+" OUT");
        } catch (IOException e) {
            // System.err.println("IOException");
            e.printStackTrace();
            return;
        }
    }

   @Override
    public void execute()  {
        while(true) {

            Document doc = null;
            try {
                doc = receiveDocument();
                //System.out.println(doc);
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SocketClosedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            el_root = doc.getDocumentElement();
            if (el_root == null) {
                // System.err.println("No document element found");

            }

            if (el_root == null) {
                // System.err.println("No document element found");

            }

            if (el_root.getNodeName().equals("message")) {
                //System.out.println(el_root);
                try {
                    if(!processMessage(el_root)) break;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                //  System.err.println("Unknown document received");
            }
        }


    }
    @SuppressWarnings("static-access")
    public boolean processMessage(Element el_message) throws IOException {

        String type = el_message.getAttribute("type");
        if (type.equals("request-action") || type.equals("sim-start") || type.equals("sim-end")) {
            //get perception
            Element el_perception = null;
            NodeList nl = el_message.getChildNodes();
            String infoelementname ="perception";

            if (type.equals("request-action")) {
                infoelementname = "perception";
            } else if (type.equals("sim-start")) {
                infoelementname = "simulation";
            } else if (type.equals("sim-end")) {
                infoelementname = "sim-result";
            }

            for (int i=0;i<nl.getLength();i++) {
                Node n = nl.item(i);
                if (n.getNodeType()==Element.ELEMENT_NODE && n.getNodeName().equalsIgnoreCase(infoelementname)) {
                    if (el_perception==null) el_perception = (Element) n; else {
                        //   System.err.println("perception message doesn't contain right number of perception elements");
                        return true;
                    }
                }
            }

            Document doc = null;
            try {
                doc = documentbuilderfactory.newDocumentBuilder().newDocument();
            } catch (ParserConfigurationException e) {
                //System.err.println("parser config error");
                e.printStackTrace();
                System.exit(1);
            }
            Element el_response = doc.createElement("message");

            doc.appendChild(el_response);
            Element el_action=doc.createElement("action");
            el_response.setAttribute("type","action");
            el_response.appendChild(el_action);

            long currenttime = 0;
            try {
                currenttime = Long.parseLong(el_message.getAttribute("timestamp"));
            } catch (NumberFormatException e) {
                //System.err.println("number format invalid");
                e.printStackTrace();
                return true;
            }

            long deadline = 0;

            if (type.equals("request-action")) {

                try {
                    deadline = Long.parseLong(el_perception.getAttribute("deadline"));
                } catch (NumberFormatException e) {
                    // System.err.println("number format invalid");
                    e.printStackTrace();
                    return true;
                }
                try {
                    processRequestAction(el_perception, el_action, currenttime, deadline);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (type.equals("sim-start")) {
                processSimulationStart(el_perception, currenttime);
            } else if (type.equals("sim-end")) {
                processSimulationEnd(el_perception, currenttime);
            }

            el_action.setAttribute("id",el_perception.getAttribute("id"));

			/*if(deadline > 0){

				Thread t = new Thread();
				random r = new random();
				System.out.println("Timestamp: " + currenttime);
				System.out.println("Deadline: " + deadline);

				double time = deadline - currenttime;
				System.out.println("Time: " + time);


				PNO, 21.03.2007, Simulation of the slow network removed!

				int random = r.nextInt((int)time + 200);

				System.out.println("random: " + random);

				t.start();

				try{

					t.sleep(random);
				}
				catch(Exception e) {};

				t.interrupt();

			}*/

            try {

                // sending of action only for request-action message!!!
                if(type.equals("request-action")) sendDocument(doc);

            } catch (IOException e) {
                // System.err.println("IO Exception while trying to send action");
                e.printStackTrace();
                System.exit(1);
            }

        } else if (type.equals("pong")) {
            NodeList nl = el_message.getChildNodes();
            for (int i=0;i<nl.getLength();i++) {
                Node n = nl.item(i);
                if (n.getNodeType()==Element.ELEMENT_NODE && n.getNodeName().equalsIgnoreCase("payload")) {
                    processPong(((Element)n).getAttribute("value"));
                    return true;
                }
            }
        }
        return true;
    }
    public void processRequestAction(Element perception, Element target, long currenttime, long deadline) throws IOException {
        //System.err.println("---#-#-#-#-#-#-- processPerception --#-#-#-#-#-#---");
    }
    public void processSimulationEnd(Element perception, long currenttime) {
        // System.err.println("---#-#-#-#-#-#-- processSimEnd --#-#-#-#-#-#---");
    }
    public void processSimulationStart(Element perception, long currenttime) {
        //System.err.println("---#-#-#-#-#-#-- processSimStart --#-#-#-#-#-#---");
    }
    public void processPong(String pong) {
        System.err.println("---#-#-#-#-#-#-- processPong("+pong+") --#-#-#-#-#-#---");
    }
    public void processLogIn() {
        //System.err.println("---#-#-#-#-#-#-- login --#-#-#-#-#-#---");
    }
    public void sendDocument(Document doc) throws IOException {
        try {
            transformerfactory.newTransformer().transform(new DOMSource(doc),new StreamResult(outputstream));
            ByteArrayOutputStream temp = new ByteArrayOutputStream();
            transformerfactory.newTransformer().transform(new DOMSource(doc),new StreamResult(temp));
            String s = "Agent -> Server:\n"+temp.toString();
            outputstream.write(0);
            outputstream.flush();
        } catch (TransformerConfigurationException e) {
            //System.err.println("transformer config error");
            e.printStackTrace();
            System.exit(1);
        } catch (TransformerException e) {
            //System.err.println("transformer error error");
            e.printStackTrace();
            System.exit(1);
        }
    }
    public void sendPing(String ping) throws IOException {

        Document doc = null;
        try {
            doc = documentbuilderfactory.newDocumentBuilder().newDocument();
            //doc.
        } catch (ParserConfigurationException e) {
            System.err.println("parser config error");
            e.printStackTrace();
            System.exit(1);
        }
        Element root = doc.createElement("message");
        doc.appendChild(root);
        root.setAttribute("type","ping");
        Element payload = doc.createElement("payload");

        payload.setAttribute("value",Long.toString(System.currentTimeMillis())); // sends the timestamp as a payload value. could also be anything else.

        root.appendChild(payload);
        sendDocument(doc);
    }
}


