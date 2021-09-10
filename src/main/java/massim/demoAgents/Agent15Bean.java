package massim.demoAgents;
import Messages.*;

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

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;
public class Agent15Bean  extends AbstractAgentBean{
    private String usname="13";
    private int posX = 0, posY = 0;
    public int getPosX() {return posX;}
    public int getPosY() {return posY;}
    public void setPosY(int posY) {this.posY = posY;}
    public void setPosX(int posX) {this.posX = posX;}
    private IActionDescription sendAction = null;
    private String action="";
    private int step=0;
    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public PrintWriter fw=null;
    public FileWriter qr=null;
    PrintWriter log=null;
    public HashMap<Integer,ArrayList<Integer>> catched=new HashMap<Integer, ArrayList<Integer>>();

    public HashMap<Integer, ArrayList<Integer>> getCatched() {
        return catched;
    }

    public void setCatched(HashMap<Integer, ArrayList<Integer>> catched) {
        this.catched = catched;
    }
    public HashMap<Integer,ArrayList<Integer>> h4=new HashMap<Integer, ArrayList<Integer>>();
    public HashMap<Integer, ArrayList<Integer>> getH4() {return h4;}
    public void setH4(HashMap<Integer, ArrayList<Integer>> h4) {this.h4 = h4;}
    //////////////////////////////////////////
    public int iu=1;
    @Override
    public void doStart() throws Exception {
        ////////////
        HerdGroup herdGroup2 = new HerdGroup("");
        JiacMessage m1000 = new JiacMessage(herdGroup2);
        memory.attach(new HandleHerdGroup(), m1000);
        String filename= "c:\\users\\rahma\\desktop\\Graphic\\Agent"+username+".txt";
        FileWriter fw1 = new FileWriter(filename);
        fw1.write("");
        fw1.close();
        String filenameq= "c:\\users\\rahma\\desktop\\Graphic\\Agent"+username+"q.txt";
        FileWriter q = new FileWriter(filenameq);
        q.write("");
        q.close();
        fw = new PrintWriter(new FileWriter(filename)); //the true will append the new dat
        qr = new FileWriter(filenameq,true); //the true will append the new dat
        //////////////////////////////////////////////////////
        String filenamelog= "c:\\users\\rahma\\desktop\\Graphic\\log"+username+".txt";
        FileWriter fw111 = new FileWriter(filenamelog);
        fw111.write("");
        fw111.close();
        log = new PrintWriter(new FileWriter(filenamelog));
        /////////////////////////////////////////////////////
        super.doStart();
        IActionDescription template = new Action(ICommunicationBean.ACTION_SEND);
        sendAction = memory.read(template);
        if (sendAction == null) {
            sendAction = thisAgent.searchAction(template);
        }

        if (sendAction == null)
            throw new RuntimeException("Send action not found.");
        int port = 12300;
        String host = "localhost";
        String username = usname;
        String pass = "1";
        socketaddress = new InetSocketAddress(host,port);
        socket.connect(socketaddress);
        inputstream = socket.getInputStream();
        outputstream = socket.getOutputStream();
        //////////////////////////
        boolean auth = doAuthentication(username, password);
        if (!auth) {
            System.err.println("Authentication failed");
            return;
        }

        try{
            Document doc = null;

            try {
                doc = receiveDocument();
                System.out.println(doc);

            } catch (SAXException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            el_root = doc.getDocumentElement();
            if (el_root == null) {
                System.err.println("No document element found");

            }

            if (el_root == null) {
                System.err.println("No document element found");

            }

            if (el_root.getNodeName().equals("message")) {
                //  processMessage(el_root);
            } else {
                System.err.println("Unknown document received");
            }
//
            //  System.out.println(getBeanName()+" OUT");
        } catch (IOException e) {
            // System.err.println("IOException");
            e.printStackTrace();
            return;
        }

    }
    @SuppressWarnings("serial")
    private class HandleHerdGroup implements SpaceObserver<IFact>{
        @SuppressWarnings("unchecked")
        public void notify(SpaceEvent<? extends IFact> event) {
            if (event instanceof WriteCallEvent) {
                //if (iu != 1) {
log.println("yek shodam" +" "+action+" in step "+step);
                log.flush();
                fw.flush();;
                iu=1;
                // }
            }
        }
    }
    public Agent15Bean() {
        socket = new Socket();
        documentbuilderfactory=DocumentBuilderFactory.newInstance();
        transformerfactory = TransformerFactory.newInstance();
    }
    public double findAngle(double p0x,double p0y,double p1x,double p1y,double p2x,double p2y) {
        double a = Math.pow(p1x-p0x,2) + Math.pow(p1y-p0y,2),
                b = Math.pow(p1x-p2x,2) + Math.pow(p1y-p2y,2),
                c = Math.pow(p2x-p0x,2) + Math.pow(p2y - p0y, 2);
        return 57.2958*Math.acos( (a+b-c) / Math.sqrt(4*a*b) );
    }
    public Agent15Bean(String host, String username, String pass, int port) {
        this.setUsername(username);
        this.setPassword(pass);
        this.setHost(host);
        this.setPort(port);
    }
    @SuppressWarnings("static-access")
    public void processRequestAction(Element perception, Element target, long currenttime, long deadline) throws IOException {
        this.action = "";

        this.step = Integer.parseInt(perception.getAttribute("step"));


        action=randomAction();
        log.println("action Agent"+username+"  "+action +" "+action+" in step "+step);
        log.flush();
        fw.flush();;
        target.setAttribute("type", action);
    }
    public String processPerception(Element a) {
        int i;
        NodeList nl = a.getElementsByTagName("cell");
        Map<String, Integer> dir_point = new HashMap<String, Integer>();
        dir_point.put("west", 0);
        dir_point.put("east", 0);
        dir_point.put("south", 0);
        dir_point.put("north", 0);
        dir_point.put("northeast", 0);
        dir_point.put("southeast", 0);
        dir_point.put("northwest", 0);
        dir_point.put("southwest", 0);
        dir_point.put("skip", 0);
        for (i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            Element ne = (Element) n;
            NodeList nnl = n.getChildNodes();
            String content = nnl.item(1).getNodeName();
            int directionX = Integer.parseInt(ne.getAttribute("x"));
            int directionY = Integer.parseInt(ne.getAttribute("y"));
            if (content.equalsIgnoreCase("cow")) {
                String dir = convertDir(directionX, directionY);
                int p = dir_point.get(dir);
                p = p + 1;
                dir_point.put(dir, p);
            }
        }
        String movedir = findMaxPointDir(dir_point);
        return movedir;
    }
    private String findMaxPointDir(Map<String, Integer> dir_point) {
        String d = "skip";

        Vector<String> dir = new Vector<String>();
        dir.add("west");
        dir.add("east");
        dir.add("north");
        dir.add("south");
        dir.add("northwest");
        dir.add("northeast");
        dir.add("southwest");
        dir.add("southeast");

        Collections.shuffle(dir);
        d = dir.get(0);

        int point = 0;

        if (dir_point.get("west") > point) {
            point = dir_point.get("west");
            d = "west";
        }
        if (dir_point.get("east") > point) {
            point = dir_point.get("east");
            d = "east";
        }
        if (dir_point.get("north") > point) {
            point = dir_point.get("north");
            d = "north";
        }
        if (dir_point.get("south") > point) {
            point = dir_point.get("south");
            d = "south";
        }
        if (dir_point.get("northeast") > point) {
            point = dir_point.get("northeast");
            d = "northeast";
        }
        if (dir_point.get("southeast") > point) {
            point = dir_point.get("southeast");
            d = "southeast";
        }
        if (dir_point.get("northwest") > point) {
            point = dir_point.get("northwest");
            d = "northwest";
        }
        if (dir_point.get("southwest") > point) {
            point = dir_point.get("southwest");
            d = "southwest";
        }

        return d;
    }
    private String convertDir(int directionX, int directionY) {
        String dir = "";
        if (directionY > 0)
            dir += "south";
        else if (directionY < 0)
            dir += "north";
        if (directionX > 0)
            dir += "west";
        else if (directionX < 0)
            dir += "east";
        return dir;
    }
    public String randomAction() {
        Random r1 = new Random();
        String action = "";
        // action generating by random number
        int d=r1.nextInt(7);
        switch (d) {
            case 0:
                action = "east";
                break;
            case 1:
                action = "northeast";
                break;
            case 2:
                action = "north";
                break;
            case 3:
                action = "northwest";
                break;
            case 4:
                action = "west";
                break;
            case 5:
                action = "southwest";
                break;
            case 6:
                action = "south";
                break;
            case 7:
                action = "southeast";
                break;
        }
        // return action
        return action;
    }
    public String surround() {
        return "south";
    }
    public String push() {
        return "west";
    }
    public String determineDirection(int north, int west, int south, int east) {

        String direction = "skip";

        // "north"
        if (north <= west && north <= south && north <= east) {

            direction = "north";
        }

        // "west"
        else if (west <= north && west <= south && west <= east) {

            direction = "west";
        }

        // "south"
        else if (south <= north && south <= west && south <= east) {

            direction = "south";
        }

        // "east"
        else if (east <= north && east <= west && east <= south) {

            direction = "east";
        }

        // return action
        return direction;
    }
    public void processLogIn() {
        // called as soon as agent logged in successfully
        // TODO: insert code here
        // Note: This is a good place to do a ping
    }
    public void processPong(String pong) {
        // react on incoming pong
        // TODO: insert code here
    }
    public void processSimulationEnd(Element perception, long currenttime) {
        // react on simulation end
        // TODO: insert code here
    }
    ////////////////////////////////////////
    //////////////////////////////
    private int port;
    private String host;
    private InetSocketAddress socketaddress;
    private Socket socket;
    private InputStream inputstream;
    private OutputStream outputstream;
    protected String username;
    private String password;
    public Element getEl_root() {
        return el_root;
    }
    public void setEl_root(Element el_root) {
        this.el_root = el_root;
    }
    protected DocumentBuilderFactory documentbuilderfactory;
    private TransformerFactory transformerfactory;
    public  Element el_root;
    public String getDate() {
        Date dt = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH-mm-ss_dd-MM-yyyy");
        return df.format(dt);
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
        }

        return true;
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
    public void processSimulationStart(Element perception, long currenttime) {
        //System.err.println("---#-#-#-#-#-#-- processSimStart --#-#-#-#-#-#---");
    }
    @SuppressWarnings("serial")
    class SocketClosedException extends Exception {}
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
    public void execute()  {

        Document doc = null;
        try {
            doc = receiveDocument();

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (SocketClosedException e) {
            e.printStackTrace();
        }
        el_root = doc.getDocumentElement();
        if (el_root == null) {
            System.err.println("No document element found");

        }

        if (el_root == null) {
            System.err.println("No document element found");

        }

        if (el_root.getNodeName().equals("message")) {
            try {
                if(!processMessage(el_root)) System.out.println("mmmmm");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Unknown document received");
        }

    }
}
