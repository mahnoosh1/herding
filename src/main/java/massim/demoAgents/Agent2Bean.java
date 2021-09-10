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
public class Agent2Bean  extends AbstractAgentBean{
    private String usname="2";
    private boolean H = true;
    private boolean T = true;
    private int posX = 0, posY = 0;
    public int getPosX() {return posX;}
    public int getPosY() {return posY;}
    public void setPosY(int posY) {this.posY = posY;}
    public void setPosX(int posX) {this.posX = posX;}
    /////////////////////////////////////////////////
    private String action="";
    public String getAction() {return action;}
    public void setAction(String action) {this.action = action;}
    ////////////////////////////////////////////////
    private double alpha = 0.3;
    private double gamma = 0.1;
    public double getAlpha(){return alpha;}
    public void setAlpha(double alpha){this.alpha = alpha;}
    public double getGamma(){return gamma;}
    public void setGamma(double gamma){this.gamma = gamma;}
    //////////////////////////////////////////////////
    public String[] getSim_start() {return sim_start;}
    public void setSim_start(String[] sim_start) {this.sim_start = sim_start;}
    /////////////////////////////////////////////////
    private HashMap<Integer,ArrayList<Integer>> Prev_Pos=new HashMap<Integer, ArrayList<Integer>>();
    public HashMap<Integer, ArrayList<Integer>> getPrev_Pos() {return Prev_Pos;}
    public void setPrev_Pos(HashMap<Integer, ArrayList<Integer>> prev_Pos) {Prev_Pos = prev_Pos;}
    //////////////////////////////////////////////////////////
    private HashMap<String,String> Q1HerdAlone = new HashMap<String, String>();
    private HashMap<String,String> Q1RandAlone = new HashMap<String, String>();
    private HashMap<String,String> Q1RandGroup = new HashMap<String, String>();
    private HashMap<String,String> Q1HerdGroupCentral = new HashMap<String, String>();
    public HashMap<String, String> getQ1RandAlone() {return Q1RandAlone;}
    public void setQ1RandAlone(HashMap<String, String> q1RandAlone) {Q1RandAlone = q1RandAlone;}
    public HashMap<String, String> getQ1RandGroup() {return Q1RandGroup;}
    public void setQ1RandGroup(HashMap<String, String> q1RandGroup) {Q1RandGroup = q1RandGroup;}
    public HashMap<String, String> getQ1HerdAlone() {return Q1HerdAlone;}
    public void setQ1HerdAlone(HashMap<String, String> q1HerdAlone) {Q1HerdAlone = q1HerdAlone;}
    public HashMap<String, String> getQ1HerdGroupCentral() {return Q1HerdGroupCentral;}
    public void setQ1HerdGroupCentral(HashMap<String, String> q1HerdGroupCentral) {Q1HerdGroupCentral = q1HerdGroupCentral;}
    //////////////////////////////////////////////////////////////////////////////////
    public ArrayList<String> perc1;
    public void setPerc1(ArrayList<String> perc1) {this.perc1 = perc1;}
    public ArrayList getPerc1() {return perc1;}
    ////////////////////////////////////////////////////////////////////////////////
    public ArrayList<String> perc11;
    public void setPerc11(ArrayList<String> perc11) {this.perc11 = perc11;}
    public ArrayList<String> getPerc11() {return perc11;}
    ////////////////////////////////////////////////////////////////////////////////
    public String sim_start[];
    private HashMap<Integer, ArrayList<Integer>> Step_SeenCows;
    public HashMap<Integer, ArrayList<Integer>> getStep_SeenCows() {return Step_SeenCows;}
    public void setStep_SeenCows(HashMap<Integer, ArrayList<Integer>> step_SeenCows) {Step_SeenCows = step_SeenCows;}
    ///////////////////////////////////////////////////////////////////////////
    ArrayList<ArrayList<Integer>> corral=new ArrayList<ArrayList<Integer>>();
    private double corral_min_x=0;
    private double corral_min_y=0;
    //////////////////////////////////////////////////////////////////////////
    private int step;
    public int getStep() {return step;}
    public void setStep(int step) {this.step = step;}
    ////////////////////////////////////////////
    private int GoAfterAlone=0;
    private int HerdAlone=0;
    private int HerdGroup=0;
    private int NoMode=0;
    public int GoAfterGroup=0;
    public int RandAlone=0;
    public int RandGroup=0;
    public int getRandAlone() {return RandAlone;}
    public void setRandAlone(int randAlone) {RandAlone = randAlone;}
    public int getRandGroup() {return RandGroup;}
    public void setRandGroup(int randGroup) {RandGroup = randGroup;}
    public int getGoAfterGroup() {return GoAfterGroup;}
    public void setGoAfterGroup(int goAfterGroup) {GoAfterGroup = goAfterGroup;}
    public int getNoMode() {return NoMode;}
    public void setNoMode(int noMode) {NoMode = noMode;}
    public int getGoAfterAlone(){return GoAfterAlone;}
    public void setGoAfterAlone(int goAfterAlone){GoAfterAlone = goAfterAlone;}
    public int getHerdAlone(){return HerdAlone;}
    public void setHerdAlone(int herdAlone) {HerdAlone = herdAlone;}
    public int getHerdGroup() {return HerdGroup;}
    public void setHerdGroup(int herdGroup){HerdGroup = herdGroup;}
    public Agent3Bean getAgent3() {
        return Agent3;
    }
    public void setAgent3(Agent3Bean agent3) {
        Agent3 = agent3;
    }
    public Agent4Bean getAgent4() {
        return Agent4;
    }
    public void setAgent4(Agent4Bean agent4) {
        Agent4 = agent4;
    }
    public Agent1Bean getAgent1() {
        return Agent1;
    }
    public void setAgent1(Agent1Bean agent1) {
        Agent1 = agent1;
    }
    public Agent5Bean getAgent5() {
        return Agent5;
    }
    public void setAgent5(Agent5Bean agent5) {
        Agent5 = agent5;
    }
    public Agent6Bean getAgent6() {
        return Agent6;
    }
    public void setAgent6(Agent6Bean agent6) {
        Agent6 = agent6;
    }
    public Agent7Bean getAgent7() {
        return Agent7;
    }
    public void setAgent7(Agent7Bean agent7) {
        Agent7 = agent7;
    }
    public Agent8Bean getAgent8() {
        return Agent8;
    }
    public void setAgent8(Agent8Bean agent8) {
        Agent8 = agent8;
    }
    public Agent9Bean getAgent9() {
        return Agent9;
    }
    public void setAgent9(Agent9Bean agent9) {
        Agent9 = agent9;
    }
    public Agent10Bean getAgent10() {
        return Agent10;
    }
    public void setAgent10(Agent10Bean agent10) {
        Agent10 = agent10;
    }
    public Agent1Bean Agent1;
    public Agent3Bean Agent3;
    public Agent4Bean Agent4;
    public Agent5Bean Agent5;
    public Agent6Bean Agent6;
    public Agent7Bean Agent7;
    public Agent8Bean Agent8;
    public Agent9Bean Agent9;
    public Agent10Bean Agent10;
    private IActionDescription sendAction = null;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private ArrayList<Double> cent=new ArrayList<Double>();
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    HashMap<String,String> QQ=new HashMap<String, String>();
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String ActionTotal="";
    public Element el_perception = null;
    public boolean goalstate=false;
    public int decider=0;
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public HashMap<Integer, ArrayList<Integer>> sheep=new HashMap<Integer, ArrayList<Integer>>();
    public HashMap<Integer, ArrayList<Integer>> newsheep=new HashMap<Integer, ArrayList<Integer>>();
    public HashMap<Integer, ArrayList<Integer>> getNewsheep() {return newsheep;}
    public void setNewsheep(HashMap<Integer, ArrayList<Integer>> newsheep) {this.newsheep = newsheep;}
    public HashMap<Integer, ArrayList<Integer>> getSheep() {return sheep;}
    public void setSheep(HashMap<Integer, ArrayList<Integer>> sheep) {this.sheep = sheep;}
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public PrintWriter fw=null;
    public int wfac=0;
    public int iu=0;
    public int header=0;
    public int uq=0;
    public FileWriter qr=null;
    PrintWriter log=null;
    PrintWriter pos=null;
    ///////////////////////////////////////////////////////////
    public ArrayList<Integer> N_n=new ArrayList<Integer>();
    public ArrayList<Integer> getN_n() {
        return N_n;
    }
    public void setN_n(ArrayList<Integer> n_n) {
        N_n = n_n;
    }
    ////////////////////////////////////////
    public int getIu() {
        return iu;
    }
    public void setIu(int iu) {
        this.iu = iu;
    }
    /////////////////////////////////////////
    public int getWfac() {
        return wfac;
    }
    public void setWfac(int wfac) {
        this.wfac = wfac;
    }
    int corral_x=0;
    int corral_y=0;
    //////////////////////////////////////////
    @Override
    public void doStart() throws Exception {
        HerdGroup herdGroup2 = new HerdGroup("WFAC");
        JiacMessage m1000 = new JiacMessage(herdGroup2);
        memory.attach(new HandleHerdGroup(), m1000);
        HerdGroup herdGroup1 = new HerdGroup("");
        JiacMessage m100 = new JiacMessage(herdGroup1);
        memory.attach(new HandleHerdGroup(), m100);
        for(int i1=1;i1<=10;i1++){
            HerdGroup herdGroup = new HerdGroup(i1+"");
            JiacMessage m10 = new JiacMessage(herdGroup);
            memory.attach(new HandleHerdGroup(), m10);
        }
        for(int i1=1;i1<=10;i1++){
            for(int i2=1;i2<=10;i2++) {
                if(i1!=Integer.parseInt(username) && i2!=Integer.parseInt(username)) {
                    HerdGroup herdGroup = new HerdGroup(i1 + "&" + i2);
                    JiacMessage m11 = new JiacMessage(herdGroup);
                    memory.attach(new HandleHerdGroup(), m11);
                }
            }
        }
        for(int i1=1;i1<=10;i1++){
            for(int i2=1;i2<=10;i2++) {
                for(int i3=1;i3<=10;i3++) {
                    if (i1 != Integer.parseInt(username) && i2 != Integer.parseInt(username) && i3 != Integer.parseInt(username)) {
                        HerdGroup herdGroup = new HerdGroup(i1 + "&" + i2+"&"+i3);
                        JiacMessage m12 = new JiacMessage(herdGroup);
                        memory.attach(new HandleHerdGroup(), m12);
                    }
                }
            }
        }
        for(int i1=1;i1<=10;i1++){
            for(int i2=1;i2<=10;i2++) {
                for(int i3=1;i3<=10;i3++) {
                    for(int i4=1;i4<=10;i4++) {
                        if (i1 != Integer.parseInt(username) && i2 != Integer.parseInt(username) && i3 != Integer.parseInt(username) && i4 != Integer.parseInt(username)) {
                            HerdGroup herdGroup = new HerdGroup(i1 + "&" + i2 + "&" + i3+"&"+i4);
                            JiacMessage m13 = new JiacMessage(herdGroup);
                            memory.attach(new HandleHerdGroup(), m13);
                        }
                    }
                }
            }
        }
        ///////////////////////////////////////////
        ArrayList<Integer> c1=new ArrayList<Integer>();c1.add(0, 48);c1.add(1, 36);
        ArrayList<Integer> c2=new ArrayList<Integer>();c2.add(0, 12);c2.add(1, 20);
        ArrayList<Integer> c3=new ArrayList<Integer>();c3.add(0, 55);c3.add(1, 25);
        corral.add(0,c1);
        corral.add(1,c2);
        corral.add(2,c3);
        corral_x=corral.get(0).get(0);
        corral_y=corral.get(0).get(1);
        ////////////
        String filename= "c:\\users\\rahma\\desktop\\Graphic1\\Agent"+username+".txt";
        FileWriter fw1 = new FileWriter(filename);
        fw1.write("");
        fw1.close();
        String filenameq= "c:\\users\\rahma\\desktop\\Graphic1\\Agent"+username+"q.txt";
        FileWriter q = new FileWriter(filenameq);
        q.write("");
        q.close();
        fw = new PrintWriter(new FileWriter(filename)); //the true will append the new dat
        qr = new FileWriter(filenameq,true); //the true will append the new dat
        //////////////////////////////////////////////////////
        String filenamelog= "c:\\users\\rahma\\desktop\\Graphic1\\log"+username+".txt";
        FileWriter fw111 = new FileWriter(filenamelog);
        fw111.write("");
        fw111.close();
        log = new PrintWriter(new FileWriter(filenamelog));
        //////////////////////////////////////////////////////
        String filenamepos= "c:\\users\\rahma\\desktop\\Graphic1\\pos"+username+".txt";
        FileWriter fw112 = new FileWriter(filenamepos);
        fw112.write("");
        fw112.close();
        pos = new PrintWriter(new FileWriter(filenamepos));
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
    public Agent2Bean() {
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
    public Agent2Bean(String host, String username, String pass, int port) {
        this.setUsername(username);
        this.setPassword(pass);
        this.setHost(host);
        this.setPort(port);
    }
    public double findis(ArrayList<Integer> a1,  ArrayList<Integer> a2) {
        return Math.sqrt(Math.pow(a1.get(0) - a2.get(0), 2) + Math.pow(a1.get(1) - a2.get(1), 2));
    }
    public ArrayList<HashMap<Integer, ArrayList<Integer>>> Cluster(HashMap<Integer, ArrayList<Integer>> CowA) {
        ArrayList<HashMap<Integer, ArrayList<Integer>>> C=new ArrayList<HashMap<Integer, ArrayList<Integer>>>();
        HashMap<Integer,Integer> S=new HashMap<Integer, Integer>();
        int thershold=3,m=0;
        for(int key1:CowA.keySet()) {
            if (!S.containsKey(key1)){
                S.put(key1,1);
                HashMap<Integer,ArrayList<Integer>> c=new HashMap<Integer, ArrayList<Integer>>();
                c.put(key1,CowA.get(key1));
                for (int key2 : CowA.keySet()) {
                    if (key1 != key2 && !S.containsKey(key2)) {
                        if (findis(CowA.get(key1), CowA.get(key2)) < thershold) {
                            S.put(key2,1);
                            c.put(key2,CowA.get(key2));
                        }
                    }
                }
                C.add(C.size(),c);
            }
        }
        return C;
    }
    public HashMap<Integer, ArrayList<Integer>> Sheep(ArrayList<HashMap<Integer, ArrayList<Integer>>> C) {
        HashMap<Integer, ArrayList<Integer>> p = new HashMap<Integer, ArrayList<Integer>>();
        int max=0;
        for(int i=0;i<C.size();i++){
            int n=C.get(i).size();
            if(n>max){
                p=C.get(i);
                max=n;
            }
        }
        return p;
    }
    public int p1(double d) {
        int r = 0;int n=0;int res=0;
        while(r<=10000){
            if(d>=n && d<n+10) {
                res = r;
                break;
            }
            n+=10;
            r++;
        }
        return res;
    }
    public int p2(double d) {
        int r = 0;int n=0;int res=0;
        while(r<=10000){
            if(d>=n && d<n+10) {
                res = r;
                break;
            }
            n+=10;
            r++;
        }
        return res;
    }
    public int p3(double d) {
        int r = 0;int n=0;int res=0;
        while(r<=10000){
            if(d>=n && d<n+10) {
                res = r;
                break;
            }
            n+=10;
            r++;
        }
        return res;
    }
    public int p4(double d) {
        int r = -10000;int n=-10000;int res=0;
        while(r>=-10000){
            if(d>=n && d<n+1) {
                res = r;
                break;
            }
            n+=1;
            r++;
        }
        return res;
    }
    public ArrayList<Integer> NextState(int posx,int posy,String action) {
        ArrayList<Integer> n = new ArrayList<Integer>();
        int nextx = 0, nexty = 0;
        if (action.equals( "west")) {
            nextx = posx - 1;
            nexty = posy;
        }
        if (action.equals(  "east")) {
            nextx = posx + 1;
            nexty = posy;
        }
        if (action .equals( "south")) {
            nextx = posx;
            nexty = posy + 1;
        }
        if (action.equals(  "north") ){
            nextx = posx;
            nexty = posy - 1;
        }
        if (action .equals( "southwest")) {
            nextx = posx - 1;
            nexty = posy + 1;
        }
        if (action .equals(  "northwest")) {
            nextx = posx - 1;
            nexty = posy - 1;
        }
        if (action .equals(  "southeast")) {
            nextx = posx + 1;
            nexty = posy + 1;
        }
        if (action .equals(  "northeast")) {
            nextx = posx + 1;
            nexty = posy - 1;
        }
        if (action .equals(  "skip")) {
            nextx = posx ;
            nexty = posy ;
        }
        n.add(0, nextx);
        n.add(1, nexty);
        return n;
    }
    public HashMap<String, String> QlHerdAlone(String s) {
        //log.println("h1:  "+getH1());log.flush();
        ////log.println("injam alan 7 "+s);log.flush();
        HashMap<String, String> Ql = new HashMap<String, String>();
        if (h1.size() == 0) {
            ////log.println("injam alan 8");log.flush();
            return Ql;
        }
        else {
            ////log.println("injam alan 9 "+h2);log.flush();
            for(Map.Entry<String, String> entry:h1.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                ////log.println("injam alan 10 "+key);log.flush();
                String f[]=key.split(",");
                ////log.println("f:  "+f[0]+","+f[1]+","+f[2]+"   s: "+s);log.flush();
                if(s.equals(f[0]+","+f[1]+","+f[2])) {
                    // //log.println("injam alan 11 " + key + "   " + value);
                    //log.flush();
                    Ql.put(key,value);
                }
                ////log.println("dore bad");log.flush();
            }
        }
        ////log.println("injam alan 12 ");log.flush();
        return Ql;
    }
    public HashMap<String, String> QlHerdGroupCentral(String s) {
        //log.println("h3:  "+getH3());log.flush();
        // //log.println("injam alan 13 "+s);log.flush();
        HashMap<String, String> Ql = new HashMap<String, String>();
        if (h3.size() == 0) {
            ////log.println("injam alan 14");log.flush();
            return Ql;
        }
        else {
            ////log.println("injam alan 15  "+h3);log.flush();
            for(Map.Entry<String, String> entry:h3.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                ////log.println("injam alan 16 "+key);log.flush();
                String f[]=key.split(",");
                ////log.println("f:    "+f[0]+","+f[1]+","+f[2]+"   s: "+s);log.flush();
                if(s.equals(f[0]+","+f[1]+","+f[2])){
                    ////log.println("injam alan 18 "+key+"   "+value);log.flush();
                    Ql.put(key,value);
                }
                ////log.println("dore bad");log.flush();
            }
        }
        ////log.println("injam alan 19 ");log.flush();
        return Ql;
    }
    public HashMap<String, String> QlRandAlone(String s) {
        //log.println("h5:  "+getH5());log.flush();
        // //log.println("injam alan 13 "+s);log.flush();
        HashMap<String, String> Ql = new HashMap<String, String>();
        if (h5.size() == 0) {
            ////log.println("injam alan 14");log.flush();
            return Ql;
        }
        else {
            ////log.println("injam alan 15  "+h3);log.flush();
            for(Map.Entry<String, String> entry:h5.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                ////log.println("injam alan 16 "+key);log.flush();
                String f[]=key.split(",");
                ////log.println("f:    "+f[0]+","+f[1]+","+f[2]+"   s: "+s);log.flush();
                if(s.equals(f[0]+","+f[1]+","+f[2])){
                    ////log.println("injam alan 18 "+key+"   "+value);log.flush();
                    Ql.put(key,value);
                }
                ////log.println("dore bad");log.flush();
            }
        }
        ////log.println("injam alan 19 ");log.flush();
        return Ql;
    }
    public HashMap<String, String> QlRandGroup(String s) {
        //log.println("h6:  "+getH6());log.flush();
        // //log.println("injam alan 13 "+s);log.flush();
        HashMap<String, String> Ql = new HashMap<String, String>();
        if (h6.size() == 0) {
            ////log.println("injam alan 14");log.flush();
            return Ql;
        }
        else {
            ////log.println("injam alan 15  "+h3);log.flush();
            for(Map.Entry<String, String> entry:h6.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                ////log.println("injam alan 16 "+key);log.flush();
                String f[]=key.split(",");
                ////log.println("f:    "+f[0]+","+f[1]+","+f[2]+"   s: "+s);log.flush();
                if(s.equals(f[0]+","+f[1]+","+f[2])){
                    ////log.println("injam alan 18 "+key+"   "+value);log.flush();
                    Ql.put(key,value);
                }
                ////log.println("dore bad");log.flush();
            }
        }
        ////log.println("injam alan 19 ");log.flush();
        return Ql;
    }
    public HashMap<String, String> QlGoAfterAlone(String s) {
        //log.println("h7:  "+getH7());log.flush();
        // //log.println("injam alan 13 "+s);log.flush();
        HashMap<String, String> Ql = new HashMap<String, String>();
        if (h7.size() == 0) {
            ////log.println("injam alan 14");log.flush();
            return Ql;
        }
        else {
            ////log.println("injam alan 15  "+h3);log.flush();
            for(Map.Entry<String, String> entry:h7.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                ////log.println("injam alan 16 "+key);log.flush();
                String f[]=key.split(",");
                ////log.println("f:    "+f[0]+","+f[1]+","+f[2]+"   s: "+s);log.flush();
                if(s.equals(f[0]+","+f[1]+","+f[2])){
                    ////log.println("injam alan 18 "+key+"   "+value);log.flush();
                    Ql.put(key,value);
                }
                ////log.println("dore bad");log.flush();
            }
        }
        ////log.println("injam alan 19 ");log.flush();
        return Ql;
    }
    public HashMap<String, String> QlGoAfterGroup(String s) {
        //log.println("h8:  "+getH8());log.flush();
        // //log.println("injam alan 13 "+s);log.flush();
        HashMap<String, String> Ql = new HashMap<String, String>();
        if (h8.size() == 0) {
            ////log.println("injam alan 14");log.flush();
            return Ql;
        }
        else {
            ////log.println("injam alan 15  "+h3);log.flush();
            for(Map.Entry<String, String> entry:h8.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                ////log.println("injam alan 16 "+key);log.flush();
                String f[]=key.split(",");
                ////log.println("f:    "+f[0]+","+f[1]+","+f[2]+"   s: "+s);log.flush();
                if(s.equals(f[0]+","+f[1]+","+f[2])){
                    ////log.println("injam alan 18 "+key+"   "+value);log.flush();
                    Ql.put(key,value);
                }
                ////log.println("dore bad");log.flush();
            }
        }
        ////log.println("injam alan 19 ");log.flush();
        return Ql;
    }
    public ArrayList<Double> centroid(HashMap<Integer, ArrayList<Integer>> knots) {
        ArrayList<Double> cent = new ArrayList<Double>();
        if(knots.size()>0) {
            double centroidX = 0, centroidY = 0;
            for (int key : knots.keySet()) {
                centroidX += knots.get(key).get(0);
                centroidY += knots.get(key).get(1);
            }
            cent.add(0, centroidX / knots.size());
            cent.add(1, centroidY / knots.size());
        }
        return cent;
    }
    public  double alpha1(double x0,double y0,double x1,double y1){
        double d=0;
        if(x0<x1 && y0<y1)
            d=findAngle(x0,y0,x1,y1,x1+1,y1);
        if(x0<x1 && y0>y1)
            d=90+findAngle(x0,y0,x1,y1,x1+1,y1);
        if(x0>x1 && y0<y1)
            d=findAngle(x0,y0,x1,y1,x1+1,y1);
        if(x0>x1 && y0>y1)
            d=360-findAngle(x0,y0,x1,y1,x1+1,y1);
        if(x0==x1 ){
            if(y0>y1)
                d=270;
            if(y0<y1)
                d=90;
        }
        if(y0==y1 ){
            if(x0>x1)
                d=0;
            if(x0<x1)
                d=180;
        }
        return d;
    }
    public String ToCentroid(ArrayList<Double> cent) {
        String  action="";
        double al = alpha1(cent.get(0), cent.get(1), posX, posY);
        if ((al >= 0 && al <= 22.5) || (al >= 337.5 && al <= 360)) {
            action = "east";
        }
        if (al > 22.5 && al < 67.5) {
            action = "northeast";
        }
        if (al >= 67.5 && al <= 112.5) {
            action = "north";
        }
        if (al > 112.5 && al <= 157.5) {
            action = "northwest";
        }
        if (al > 157.5 && al <= 202.5) {
            action = "west";
        }
        if (al > 202.5 && al <= 247.5) {
            action = "southwest";
        }
        if (al > 247.5 && al <= 292.5) {
            action = "south";
        }
        if (al > 292.5 && al < 337.5) {
            action = "southeast";
        }
        if(action.equals("")) {
            action = "skip";
        }
        return action;
    }
    public String random(int i){
        //System.out.println("Agent"+username+"  rrrr "+decider);
        String action="";
        if (i == 0)
            action = ExploreAndExploit0(QQ, cent);
        if (i == 1)
            action = ExploreAndExploit1(QQ, cent);
        if (i == 2)
            action = ExploreAndExploit2(QQ, cent);
        if (i == 3)
            action = ExploreAndExploit3(QQ, cent);
        return action;
    }
    public ArrayList<Double> R(){
        double Rmin=1000000000l;double Rmax=0;
        double dist=Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0))+(posY-cent.get(1))*(posY-cent.get(1)));
        if(dist>Rmax)
            Rmax=dist;
        if(dist<Rmin)
            Rmin=dist;
        for(int i=0;i<N_n.size();i++){
            Method method= null;
            try {
                method = this.getClass().getMethod("getAgent" + N_n.get(i));
                Object object = (Object) method.invoke(this);
                Method method1 = object.getClass().getMethod("getPosX");
                Method method2 = object.getClass().getMethod("getPosY");
                int posx = (Integer) method1.invoke(object);
                int posy = (Integer) method2.invoke(object);
                dist = Math.sqrt((posx - cent.get(0)) * (posx - cent.get(0)) + (posy - cent.get(1)) * (posy - cent.get(1)));
                if (dist > Rmax)
                    Rmax = dist;
                if (dist < Rmin)
                    Rmin = dist;

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        ArrayList<Double> result=new ArrayList<Double>();result.add(0,Rmax);result.add(1,Rmin);
        return result;
    }
    public String State(){
        double min=0,d=0,a=0;
        min = Math.sqrt((cent.get(0) - posX) * (cent.get(0) - posX) + (cent.get(1) - posY) * (cent.get(1) - posY));
        d = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
        a = findAngle(corral_x, corral_y,posX, posY, cent.get(0), cent.get(1));
        for(int i=0;i<N_n.size();i++) {
            Method method= null;
            try {
                method = this.getClass().getMethod("getAgent" + N_n.get(i));
                Object object = (Object) method.invoke(this);
                Method method1 = object.getClass().getMethod("getPosX");
                Method method2 = object.getClass().getMethod("getPosY");
                int posx = (Integer) method1.invoke(object);
                int posy = (Integer) method2.invoke(object);
                min += Math.sqrt((cent.get(0) - posx) * (cent.get(0) - posx) + (cent.get(1) - posy) * (cent.get(1) - posy));
                d += Math.sqrt((corral_x - posx) * (corral_x - posx) + (corral_y - posy) * (corral_y - posy));
                a += findAngle(corral_x, corral_y,posx, posy, cent.get(0), cent.get(1));


            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        int w1 = this.p1(min/N_n.size()+1);
        int w2 = this.p2(d/N_n.size()+1);
        int w3 = this.p3(a / N_n.size()+1);
        return w1+","+w2+","+w3;
    }
    public String Next(String ex){
        String s="";
        if(ex.equals("west"))
            s=(-1)+"#"+(0);
        if(ex.equals("east"))
            s=(1)+"#"+(0);
        if(ex.equals("south"))
            s=(0)+"#"+(1);
        if(ex.equals("north"))
            s=(0)+"#"+(-1);
        if(ex.equals("southwest"))
            s=(-1)+"#"+(1);
        if(ex.equals("northwest"))
            s=(-1)+"#"+(-1);
        if(ex.equals("southeast"))
            s=(1)+"#"+(1);
        if(ex.equals("northeast"))
            s=(1)+"#"+(-1);
        if(ex.equals("skip"))
            s=(0)+"#"+(0);
        return s;

    }
    public boolean CheckPlace (ArrayList<Double> R){
        boolean flag=true;
        ////////////
        double dist = Math.sqrt((cent.get(0) - posX) * (cent.get(0) - posX) + (cent.get(1) - posY) * (cent.get(1) - posY));
        if(dist<R.get(1) || dist>R.get(0))
            flag=false;
        if(flag==false)
            return flag;
        for(int i=0;i<N_n.size();i++) {
            Method method= null;
            try {
                method = this.getClass().getMethod("getAgent" + N_n.get(i));
                Object object = (Object) method.invoke(this);
                Method method1 = object.getClass().getMethod("getPosX");
                Method method2 = object.getClass().getMethod("getPosY");
                int posx = (Integer) method1.invoke(object);
                int posy = (Integer) method2.invoke(object);
                dist = Math.sqrt((cent.get(0) - posx) * (cent.get(0) - posx) + (cent.get(1) - posy) * (cent.get(1) - posy));
                if (dist < R.get(1) || dist > R.get(0)) {
                    flag = false;
                    if (flag == false)
                        return flag;
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        ///////////
        String h1=ToCentroid(cent);
        String h3=Next(h1);
        String h2[]=h3.split("#");
        int i=Integer.parseInt(h2[0]);int j=Integer.parseInt(h2[1]);
        for (int itr = 0; itr < N_n.size(); itr++) {
            Method method = null;
            try {
                method = this.getClass().getMethod("getAgent" + N_n.get(itr));
                Object object = (Object) method.invoke(this);
                ////////////////////
                Method method1 = object.getClass().getMethod("ToCentroid", ArrayList.class);
                String actionx = (String) method1.invoke(object, cent);
                h3=Next(actionx);
                h2=h3.split("#");
                i+=Integer.parseInt(h2[0]);
                j+=Integer.parseInt(h2[1]);

                //System.out.println("Agent" + N_n.get(itr) + " tocent action is: " + actionx);
                ////////////
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        String act=Direction(i,j);

        ////////////////

        double al = alpha1(corral_min_x,corral_min_y,cent.get(0), cent.get(1));
        if ((al >= 0 && al <= 22.5) || (al >= 337.5 && al <= 360)) {
            if(act.equals("east") || act.equals("northeast") || act.equals("southeast")) {
                flag = true;
                //log.println("act total is "+act +" and must be east too");log.flush();
            }
            else {
                flag = false;
                //log.println("act total is "+act +" but must be east");log.flush();
            }
        }
        if (al > 22.5 && al < 67.5) {
            if(act.equals("northeast") || act.equals("east") || act.equals("north")) {
                flag = true;
                //log.println("act total is "+act +" and must be northeast too");log.flush();
            }
            else {
                flag = false;
                //log.println("act total is "+act +" but must be northeast");log.flush();
            }
        }
        if (al >= 67.5 && al <= 112.5) {
            if(act.equals("north") || act.equals("northeast") || act.equals("northwest")) {
                flag = true;
                //log.println("act total is "+act +" and must be north too");log.flush();
            }
            else {
                flag = false;
                //log.println("act total is "+act +" but must be north");log.flush();
            }
        }
        if (al > 112.5 && al <= 157.5) {
            if(act.equals("northwest") || act.equals("north") || act.equals("west")) {
                flag = true;
                //log.println("act total is "+act +" and must be northwest too");log.flush();
            }
            else {
                flag = false;
                //log.println("act total is "+act +" but must be northwest");log.flush();
            }
        }
        if (al > 157.5 && al <= 202.5) {
            if(act.equals("west") || act.equals("northwest") || act.equals("southwest")) {
                flag = true;
                //log.println("act total is "+act +" and must be west too");log.flush();
            }
            else {
                flag = false;
                //log.println("act total is "+act +" but must be west");log.flush();
            }
        }
        if (al > 202.5 && al <= 247.5) {
            if(act.equals("southwest") || act.equals("west") || act.equals("south")) {
                flag = true;
                //log.println("act total is "+act +" and must be southwest too");log.flush();
            }
            else {
                flag = false;
                //log.println("act total is "+act +" but must be southwest");log.flush();
            }
        }
        if (al > 247.5 && al <= 292.5) {
            if(act.equals("south") || act.equals("southeast") || act.equals("southwest")) {
                flag = true;
                //log.println("act total is "+act +" and must be south too");log.flush();
            }
            else {
                flag = false;
                //log.println("act total is "+act +" but must be south");log.flush();
            }
        }
        if (al > 292.5 && al < 337.5) {
            if(act.equals("southeast") || act.equals("east") || act.equals("south")) {
                flag = true;
                //log.println("act total is "+act +" and must be southeast too");log.flush();
            }
            else {
                flag = false;
                //log.println("act total is "+act +" but must be southeast");log.flush();
            }
        }
        ///////////////
        return flag;
    }
    public String Direction(int i,int j ){
        String s="";
        if(j==0){
            if(i==0)
                s="skip";
            if(i>0)
                s="east";
            if(i<0)
                s="west";
        }
        if(i==0){
            if(j==0)
                s="skip";
            if(j>0)
                s="south";
            if(j<0)
                s="north";
        }
        if(i>0){
            if(j>0)
                s="southeast";
            if(j<0)
                s="northeast";
        }
        if(i<0){
            if(j>0)
                s="southwest";
            if(j<0)
                s="northwest";
        }
        return s;
    }
    public void NewSheep() {
        for(int i=0;i<N_n.size();i++) {
            //////////////
            Method method = null;
            try {
                method = this.getClass().getMethod("getAgent" + N_n.get(i));
                Object object = (Object) method.invoke(this);
                Method method1 = object.getClass().getMethod("getSheep");
                HashMap<Integer, ArrayList<Integer>> n_sheep = (HashMap<Integer, ArrayList<Integer>>) method1.invoke(object);
                for (int key : n_sheep.keySet()) {
                    if (!this.getSheep().containsKey(key))
                        this.sheep.put(key, n_sheep.get(key));
                }

                ////////////
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<N_n.size();i++) {
            Method methoda = null;
            try {
                methoda = this.getClass().getMethod("getAgent" + N_n.get(i));
                Object object = (Object) methoda.invoke(this);
                Method method2 = object.getClass().getMethod("setNs", int.class);
                method2.invoke(object, 1);
                Method method1 = object.getClass().getMethod("setNewsheep", HashMap.class);
                method1.invoke(object, sheep);
                ////////////
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //////////////
        }

    }
    public void ModeDetection() {
        ////////////////
        if (cent.size() == 0) {
            this.setGoAfterAlone(0);
            this.setHerdAlone(0);
            this.setHerdGroup(0);
            this.setGoAfterGroup(0);
            this.setRandAlone(0);
            this.setRandGroup(0);
            setNoMode(1);
            for (int i = 0; i < N_n.size(); i++) {
                Method method = null;
                try {
                    method = this.getClass().getMethod("getAgent" + N_n.get(i));
                    Object object = (Object) method.invoke(this);
                    ////////////
                    Method method10 = object.getClass().getDeclaredMethod("setGoAfterAlone", int.class);
                    method10.invoke(object, 0);
                    Method method11 = object.getClass().getDeclaredMethod("setHerdAlone", int.class);
                    method11.invoke(object, 0);
                    Method method12 = object.getClass().getDeclaredMethod("setHerdGroup", int.class);
                    method12.invoke(object, 0);
                    Method method13 = object.getClass().getDeclaredMethod("setNoMode", int.class);
                    method13.invoke(object, 1);
                    Method method14 = object.getClass().getDeclaredMethod("setGoAfterGroup", int.class);
                    method14.invoke(object, 0);
                    Method method15 = object.getClass().getDeclaredMethod("setRandAlone", int.class);
                    method15.invoke(object, 0);
                    Method method16 = object.getClass().getDeclaredMethod("setRandGroup", int.class);
                    method16.invoke(object, 0);
                    //////////////////
                    ////////////

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        else {
            ////////////////
            double a11 = findAngle(corral_min_x, corral_min_y, cent.get(0), cent.get(1), posX, posY);boolean f2=false;
            if(Double.isNaN(a11)){
                f2=true;
                this.setGoAfterAlone(0);
                this.setHerdAlone(0);
                this.setHerdGroup(0);
                this.setGoAfterGroup(0);
                this.setRandAlone(0);
                this.setRandGroup(0);
                setNoMode(1);
                //////////////////
                for (int i = 0; i < N_n.size(); i++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        ////////////
                        Method method10 = object.getClass().getDeclaredMethod("setGoAfterAlone", int.class);
                        method10.invoke(object, 0);
                        Method method11 = object.getClass().getDeclaredMethod("setHerdAlone", int.class);
                        method11.invoke(object, 0);
                        Method method12 = object.getClass().getDeclaredMethod("setHerdGroup", int.class);
                        method12.invoke(object, 0);
                        Method method13 = object.getClass().getDeclaredMethod("setNoMode", int.class);
                        method13.invoke(object, 1);
                        Method method14 = object.getClass().getDeclaredMethod("setGoAfterGroup", int.class);
                        method14.invoke(object, 0);
                        Method method15 = object.getClass().getDeclaredMethod("setRandAlone", int.class);
                        method15.invoke(object, 0);
                        Method method16 = object.getClass().getDeclaredMethod("setRandGroup", int.class);
                        method16.invoke(object, 0);
                        //////////////////

                        ////////////
                        ////////////

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                /////////////////
            }
            /////////////////
            else {
                ////////////////
                for (int i = 0; i < N_n.size(); i++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method1 = object.getClass().getMethod("getPosX");
                        Method method2 = object.getClass().getMethod("getPosY");
                        int posx = (Integer) method1.invoke(object);
                        int posy = (Integer) method2.invoke(object);
                        a11 = findAngle(corral_min_x, corral_min_y, cent.get(0), cent.get(1), posx, posy);
                        if (Double.isNaN(a11)) {
                            f2 = true;
                            break;
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                if (f2 == true) {
                    this.setGoAfterAlone(0);
                    this.setHerdAlone(0);
                    this.setHerdGroup(0);
                    this.setGoAfterGroup(0);
                    this.setRandAlone(0);
                    this.setRandGroup(0);
                    setNoMode(1);
                    //////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            ////////////
                            Method method10 = object.getClass().getDeclaredMethod("setGoAfterAlone", int.class);
                            method10.invoke(object, 0);
                            Method method11 = object.getClass().getDeclaredMethod("setHerdAlone", int.class);
                            method11.invoke(object, 0);
                            Method method12 = object.getClass().getDeclaredMethod("setHerdGroup", int.class);
                            method12.invoke(object, 0);
                            Method method13 = object.getClass().getDeclaredMethod("setNoMode", int.class);
                            method13.invoke(object, 1);
                            Method method14 = object.getClass().getDeclaredMethod("setGoAfterGroup", int.class);
                            method14.invoke(object, 0);
                            Method method15 = object.getClass().getDeclaredMethod("setRandAlone", int.class);
                            method15.invoke(object, 0);
                            Method method16 = object.getClass().getDeclaredMethod("setRandGroup", int.class);
                            method16.invoke(object, 0);
                            //////////////////

                            ////////////
                            ////////////

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                }
                ////////////////
                if (f2 == false){
                    if (cent.get(0) < 48) {
                        ///////////////////////////////////////////////////////////////////
                        boolean f1 = true;
                        double a1 = findAngle(corral_min_x, corral_min_y, cent.get(0), cent.get(1), posX, posY);
                        if (a1 <= 130) {
                            this.setGoAfterAlone(0);
                            this.setHerdAlone(0);
                            this.setHerdGroup(0);
                            this.setGoAfterGroup(1);
                            setNoMode(0);
                            setRandGroup(0);
                            setRandAlone(0);
                            ///////////////////////
                            for (int i = 0; i < N_n.size(); i++) {
                                Method method = null;
                                try {
                                    method = this.getClass().getMethod("getAgent" + N_n.get(i));
                                    Object object = (Object) method.invoke(this);
                                    ////////////
                                    Method method10 = object.getClass().getDeclaredMethod("setGoAfterAlone", int.class);
                                    method10.invoke(object, 0);
                                    Method method11 = object.getClass().getDeclaredMethod("setHerdAlone", int.class);
                                    method11.invoke(object, 0);
                                    Method method12 = object.getClass().getDeclaredMethod("setHerdGroup", int.class);
                                    method12.invoke(object, 0);
                                    Method method13 = object.getClass().getDeclaredMethod("setNoMode", int.class);
                                    method13.invoke(object, 0);
                                    Method method14 = object.getClass().getDeclaredMethod("setGoAfterGroup", int.class);
                                    method14.invoke(object, 1);
                                    Method method15 = object.getClass().getDeclaredMethod("setRandAlone", int.class);
                                    method15.invoke(object, 0);
                                    Method method16 = object.getClass().getDeclaredMethod("setRandGroup", int.class);
                                    method16.invoke(object, 0);
                                    //////////////////

                                    ////////////
                                    ////////////

                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }

                            }
                            ///////////////////////
                            f1 = false;
                        }
                        if (f1 != false) {
                            for (int i = 0; i < N_n.size(); i++) {
                                Method method = null;
                                try {
                                    method = this.getClass().getMethod("getAgent" + N_n.get(i));
                                    Object object = (Object) method.invoke(this);
                                    Method method1 = object.getClass().getMethod("getPosX");
                                    Method method2 = object.getClass().getMethod("getPosY");
                                    int posx = (Integer) method1.invoke(object);
                                    int posy = (Integer) method2.invoke(object);
                                    a1 = findAngle(corral_min_x, corral_min_y, cent.get(0), cent.get(1), posx, posy);
                                    if (a1 <= 130) {
                                        f1 = false;
                                        break;
                                    }
                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }

                            }
                            if (f1 == false) {
                                this.setGoAfterAlone(0);
                                this.setHerdAlone(0);
                                this.setHerdGroup(0);
                                this.setNoMode(0);
                                this.setGoAfterGroup(1);
                                setRandAlone(0);
                                setRandGroup(0);
                                ///////////////////////
                                for (int i = 0; i < N_n.size(); i++) {
                                    Method method = null;
                                    try {

                                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                                        Object object = (Object) method.invoke(this);
                                        ////////////
                                        Method method10 = object.getClass().getDeclaredMethod("setGoAfterAlone", int.class);
                                        method10.invoke(object, 0);
                                        Method method11 = object.getClass().getDeclaredMethod("setHerdAlone", int.class);
                                        method11.invoke(object, 0);
                                        Method method12 = object.getClass().getDeclaredMethod("setHerdGroup", int.class);
                                        method12.invoke(object, 0);
                                        Method method13 = object.getClass().getDeclaredMethod("setNoMode", int.class);
                                        method13.invoke(object, 0);
                                        Method method14 = object.getClass().getDeclaredMethod("setGoAfterGroup", int.class);
                                        method14.invoke(object, 1);
                                        Method method15 = object.getClass().getDeclaredMethod("setRandAlone", int.class);
                                        method15.invoke(object, 0);
                                        Method method16 = object.getClass().getDeclaredMethod("setRandGroup", int.class);
                                        method16.invoke(object, 0);
                                        //////////////////

                                        ////////////
                                        ////////////
                                    } catch (NoSuchMethodException e) {
                                        e.printStackTrace();
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }
                        }
                        ///////////////
                        if (f1 == true) {
                            this.setGoAfterAlone(0);
                            this.setHerdAlone(0);
                            this.setHerdGroup(0);
                            setNoMode(0);
                            this.setGoAfterGroup(0);
                            setRandAlone(0);
                            setRandGroup(1);
                            for (int i = 0; i < N_n.size(); i++) {
                                Method method = null;
                                try {
                                    method = this.getClass().getMethod("getAgent" + N_n.get(i));
                                    Object object = (Object) method.invoke(this);
                                    ////////////
                                    Method method10 = object.getClass().getDeclaredMethod("setGoAfterAlone", int.class);
                                    method10.invoke(object, 0);
                                    Method method11 = object.getClass().getDeclaredMethod("setHerdAlone", int.class);
                                    method11.invoke(object, 0);
                                    Method method12 = object.getClass().getDeclaredMethod("setHerdGroup", int.class);
                                    method12.invoke(object, 0);
                                    Method method13 = object.getClass().getDeclaredMethod("setNoMode", int.class);
                                    method13.invoke(object, 0);
                                    Method method14 = object.getClass().getDeclaredMethod("setGoAfterGroup", int.class);
                                    method14.invoke(object, 0);
                                    Method method15 = object.getClass().getDeclaredMethod("setRandAlone", int.class);
                                    method15.invoke(object, 0);
                                    Method method16 = object.getClass().getDeclaredMethod("setRandGroup", int.class);
                                    method16.invoke(object, 1);
                                    //////////////////

                                    ////////////
                                    ////////////
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                        ///////////////////////////////////////////////////////////////////
                    } else {
                        boolean f1 = true;
                        double a1 = findAngle(corral_min_x, corral_min_y, cent.get(0), cent.get(1), posX, posY);
                        if (a1 <= 130) {
                            this.setGoAfterAlone(0);
                            this.setHerdAlone(0);
                            this.setHerdGroup(0);
                            this.setGoAfterGroup(1);
                            setNoMode(0);
                            setRandGroup(0);
                            setRandAlone(0);
                            ///////////////////////
                            for (int i = 0; i < N_n.size(); i++) {
                                Method method = null;
                                try {
                                    method = this.getClass().getMethod("getAgent" + N_n.get(i));
                                    Object object = (Object) method.invoke(this);
                                    ////////////
                                    Method method10 = object.getClass().getDeclaredMethod("setGoAfterAlone", int.class);
                                    method10.invoke(object, 0);
                                    Method method11 = object.getClass().getDeclaredMethod("setHerdAlone", int.class);
                                    method11.invoke(object, 0);
                                    Method method12 = object.getClass().getDeclaredMethod("setHerdGroup", int.class);
                                    method12.invoke(object, 0);
                                    Method method13 = object.getClass().getDeclaredMethod("setNoMode", int.class);
                                    method13.invoke(object, 0);
                                    Method method14 = object.getClass().getDeclaredMethod("setGoAfterGroup", int.class);
                                    method14.invoke(object, 1);
                                    Method method15 = object.getClass().getDeclaredMethod("setRandAlone", int.class);
                                    method15.invoke(object, 0);
                                    Method method16 = object.getClass().getDeclaredMethod("setRandGroup", int.class);
                                    method16.invoke(object, 0);
                                    //////////////////

                                    ////////////
                                    ////////////

                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }

                            }
                            ///////////////////////
                            f1 = false;
                        }
                        if (f1 != false) {
                            for (int i = 0; i < N_n.size(); i++) {
                                Method method = null;
                                try {
                                    method = this.getClass().getMethod("getAgent" + N_n.get(i));
                                    Object object = (Object) method.invoke(this);
                                    Method method1 = object.getClass().getMethod("getPosX");
                                    Method method2 = object.getClass().getMethod("getPosY");
                                    int posx = (Integer) method1.invoke(object);
                                    int posy = (Integer) method2.invoke(object);
                                    a1 = findAngle(corral_min_x, corral_min_y, cent.get(0), cent.get(1), posx, posy);
                                    if (a1 <= 130) {
                                        f1 = false;
                                        break;
                                    }
                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }

                            }
                            if (f1 == false) {
                                this.setGoAfterAlone(0);
                                this.setHerdAlone(0);
                                this.setHerdGroup(0);
                                this.setNoMode(0);
                                this.setGoAfterGroup(1);
                                setRandAlone(0);
                                setRandGroup(0);
                                ///////////////////////
                                for (int i = 0; i < N_n.size(); i++) {
                                    Method method = null;
                                    try {

                                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                                        Object object = (Object) method.invoke(this);
                                        ////////////
                                        Method method10 = object.getClass().getDeclaredMethod("setGoAfterAlone", int.class);
                                        method10.invoke(object, 0);
                                        Method method11 = object.getClass().getDeclaredMethod("setHerdAlone", int.class);
                                        method11.invoke(object, 0);
                                        Method method12 = object.getClass().getDeclaredMethod("setHerdGroup", int.class);
                                        method12.invoke(object, 0);
                                        Method method13 = object.getClass().getDeclaredMethod("setNoMode", int.class);
                                        method13.invoke(object, 0);
                                        Method method14 = object.getClass().getDeclaredMethod("setGoAfterGroup", int.class);
                                        method14.invoke(object, 1);
                                        Method method15 = object.getClass().getDeclaredMethod("setRandAlone", int.class);
                                        method15.invoke(object, 0);
                                        Method method16 = object.getClass().getDeclaredMethod("setRandGroup", int.class);
                                        method16.invoke(object, 0);
                                        //////////////////

                                        ////////////
                                        ////////////
                                    } catch (NoSuchMethodException e) {
                                        e.printStackTrace();
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }
                        }
                        ///////////////
                        if (f1 == true) {
                            this.setGoAfterAlone(0);
                            this.setHerdAlone(0);
                            this.setHerdGroup(1);
                            setNoMode(0);
                            this.setGoAfterGroup(0);
                            setRandAlone(0);
                            setRandGroup(0);
                            for (int i = 0; i < N_n.size(); i++) {
                                Method method = null;
                                try {
                                    method = this.getClass().getMethod("getAgent" + N_n.get(i));
                                    Object object = (Object) method.invoke(this);
                                    ////////////
                                    Method method10 = object.getClass().getDeclaredMethod("setGoAfterAlone", int.class);
                                    method10.invoke(object, 0);
                                    Method method11 = object.getClass().getDeclaredMethod("setHerdAlone", int.class);
                                    method11.invoke(object, 0);
                                    Method method12 = object.getClass().getDeclaredMethod("setHerdGroup", int.class);
                                    method12.invoke(object, 1);
                                    Method method13 = object.getClass().getDeclaredMethod("setNoMode", int.class);
                                    method13.invoke(object, 0);
                                    Method method14 = object.getClass().getDeclaredMethod("setGoAfterGroup", int.class);
                                    method14.invoke(object, 0);
                                    Method method15 = object.getClass().getDeclaredMethod("setRandAlone", int.class);
                                    method15.invoke(object, 0);
                                    Method method16 = object.getClass().getDeclaredMethod("setRandGroup", int.class);
                                    method16.invoke(object, 0);
                                    //////////////////

                                    ////////////
                                    ////////////
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    }
                }
            }
        }
        ///////////////////
    }
    public void NewAction() throws IOException {
        if(NoMode==1){
            action=randomAction(cent);
            //log.println("my action nomode" + action + "    ");

            for (int itr = 0; itr < N_n.size(); itr++) {
                Method method = null;
                try {
                    method = this.getClass().getMethod("getAgent" + N_n.get(itr));
                    Object object = (Object) method.invoke(this);
                    ////////////////////
                    String actionx=action;
                    Method method2 = object.getClass().getMethod("setAction", String.class);
                    method2.invoke(object, actionx);
                    //System.out.println("Agent" + N_n.get(itr) + " nomode action is: " + actionx);
                    ////////////
                    //log.println("Agent" + N_n.get(itr) + "    nomode action is: " + actionx);

                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        if(getRandGroup()==1) {
            if (goalstate == true && T== true && this.step>ui2) {
                action = ToCentroid(cent);
                //log.println("my rand group action tocent " + action + "    ");

                for (int itr = 0; itr < N_n.size(); itr++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(itr));
                        Object object = (Object) method.invoke(this);
                        /////////////////////
                        Method method1 = object.getClass().getMethod("ToCentroid", ArrayList.class);
                        String actionx = (String) method1.invoke(object, cent);
                        Method method2 = object.getClass().getMethod("setAction", String.class);
                        method2.invoke(object, actionx);
                        //log.println("Agent" + N_n.get(itr) + "   my rand group  tocent action is: " + actionx);

                        //System.out.println("Agent" + N_n.get(itr) + " tocent action is: " + actionx);
                        ////////////
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            } else {
                action = this.random(decider);
                if (uq == 1) {
                    //log.println("my action decider " + action + " my rand group    with qtabe " + QQ);log.flush();
                    for (int itr = 0; itr < N_n.size(); itr++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(itr));
                            Object object = (Object) method.invoke(this);
                            /////////////////////
                            String actionx =action;
                            Method method2 = object.getClass().getMethod("setAction", String.class);
                            method2.invoke(object, actionx);
                            //log.println("Agent" + N_n.get(itr) + "    qtable action is: " + actionx);

                            // System.out.println("Agent" + N_n.get(itr) + " qtable action is: " + actionx1);
                            ////////////
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }

                } else {
                    //log.println("my action decider " + action + " my rand group    without qtabe ");log.flush();
                    String actionx =action;
                    for (int itr = 0; itr < N_n.size(); itr++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(itr));
                            Object object = (Object) method.invoke(this);
                            /////////////////////
                            Method method10 = object.getClass().getMethod("getPosX");
                            Method method20 = object.getClass().getMethod("getPosY");
                            int posx = (Integer) method10.invoke(object);
                            int posy = (Integer) method20.invoke(object);
                            ////////////////////
                            Method method2 = object.getClass().getMethod("setAction", String.class);
                            method2.invoke(object, actionx);
                            //log.println("Agent" + N_n.get(itr) + "    decider  action is: " + actionx);
                            // System.out.println("Agent" + N_n.get(itr) + " random action is: " + actionx);
                            ////////////
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        if (GoAfterGroup == 1) {
            if (H == true || (T == true && this.step > ui2)) {
                action=Circle(cent);
                //log.println("my action circle" + action + "    ");

                for (int itr = 0; itr < N_n.size(); itr++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(itr));
                        Object object = (Object) method.invoke(this);
                        ////////////////////
                        //Method method1 = object.getClass().getMethod("Circle", ArrayList.class);
                        //String actionx = (String) method1.invoke(object, cent);
                        String actionx=action;
                        Method method2 = object.getClass().getMethod("setAction", String.class);
                        method2.invoke(object, actionx);
                        //log.println("Agent" + N_n.get(itr) + "    circle action is: " + actionx);

                        //System.out.println("Agent" + N_n.get(itr) + " circle action is: " + actionx);
                        ////////////
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            } else {
                action = this.random(decider);
                if (uq == 1) {
                    //log.println("my action decider " + action + " my rand group    with qtabe " + QQ);log.flush();
                    for (int itr = 0; itr < N_n.size(); itr++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(itr));
                            Object object = (Object) method.invoke(this);
                            /////////////////////
                            String actionx =action;
                            Method method2 = object.getClass().getMethod("setAction", String.class);
                            method2.invoke(object, actionx);
                            //log.println("Agent" + N_n.get(itr) + "    qtable action is: " + actionx);

                            // System.out.println("Agent" + N_n.get(itr) + " qtable action is: " + actionx1);
                            ////////////
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }

                } else {
                    //log.println("my action decider " + action + " my rand group    without qtabe ");log.flush();
                    String actionx =action;
                    for (int itr = 0; itr < N_n.size(); itr++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(itr));
                            Object object = (Object) method.invoke(this);
                            /////////////////////
                            Method method10 = object.getClass().getMethod("getPosX");
                            Method method20 = object.getClass().getMethod("getPosY");
                            int posx = (Integer) method10.invoke(object);
                            int posy = (Integer) method20.invoke(object);
                            ////////////////////
                            Method method2 = object.getClass().getMethod("setAction", String.class);
                            method2.invoke(object, actionx);
                            //log.println("Agent" + N_n.get(itr) + "    decider  action is: " + actionx);
                            // System.out.println("Agent" + N_n.get(itr) + " random action is: " + actionx);
                            ////////////
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        if(getHerdGroup()==1){
            if (goalstate == true && T == true && this.step>ui2) {
                action = ToCentroid(cent);
                //log.println("my action tocent " + action + "    ");

                for (int itr = 0; itr < N_n.size(); itr++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(itr));
                        Object object = (Object) method.invoke(this);
                        /////////////////////
                        Method method1 = object.getClass().getMethod("ToCentroid", ArrayList.class);
                        String actionx = (String) method1.invoke(object, cent);
                        Method method2 = object.getClass().getMethod("setAction", String.class);
                        method2.invoke(object, actionx);
                        //log.println("Agent" + N_n.get(itr) + "    tocent action is: " + actionx);

                        //System.out.println("Agent" + N_n.get(itr) + " tocent action is: " + actionx);
                        ////////////
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            } else {
                action = this.random(decider);
                if (uq == 1) {
                    //log.println("my action decider " + action + "    with qtabe " + QQ);log.flush();
                    for (int itr = 0; itr < N_n.size(); itr++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(itr));
                            Object object = (Object) method.invoke(this);
                            /////////////////////
                            String actionx =action;
                            Method method2 = object.getClass().getMethod("setAction", String.class);
                            method2.invoke(object, actionx);
                            //log.println("Agent" + N_n.get(itr) + "    qtable action is: " + actionx);

                            // System.out.println("Agent" + N_n.get(itr) + " qtable action is: " + actionx1);
                            ////////////
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }

                } else {
                    //log.println("my action decider " + action + "    without qtabe ");log.flush();
                    String actionx =action;
                    for (int itr = 0; itr < N_n.size(); itr++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(itr));
                            Object object = (Object) method.invoke(this);
                            /////////////////////
                            Method method10 = object.getClass().getMethod("getPosX");
                            Method method20 = object.getClass().getMethod("getPosY");
                            int posx = (Integer) method10.invoke(object);
                            int posy = (Integer) method20.invoke(object);
                            ////////////////////
                            Method method2 = object.getClass().getMethod("setAction", String.class);
                            method2.invoke(object, actionx);
                            //log.println("Agent" + N_n.get(itr) + "    decider  action is: " + actionx);
                            // System.out.println("Agent" + N_n.get(itr) + " random action is: " + actionx);
                            ////////////
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    @SuppressWarnings("serial")
    private class HandleHerdGroup implements SpaceObserver<IFact>{
        @SuppressWarnings("unchecked")
        public void notify(SpaceEvent<? extends IFact> event) {
            if (event instanceof WriteCallEvent) {
                //if (iu != 1) {
                iu=0;
                N_n=new ArrayList<Integer>();
                ////////////////////////////
                Object object = ((WriteCallEvent) event).getObject();
                //if (object instanceof JiacMessage) {
                IFact msg = ((JiacMessage) object).getPayload();
                Method m = null;
                try {
                    m = msg.getClass().getDeclaredMethod("getMessage");
                    String returnVal = (String) m.invoke(msg);
                    //log.println("payame daryafti "+returnVal);log.flush();
                    if (returnVal.equals("WFAC")) {
                        wfac = 1;
                        header=0;
                    } else {
                        header=1;
                        wfac=0;
                        if (returnVal.equals("")) {
                            header=1;
                            wfac=0;
                        } else {
                            header=1;
                            wfac=0;
                            if(!returnVal.contains("&")) {
                                N_n.add(Integer.parseInt(returnVal));
                            }
                            else {
                                String[] g = returnVal.split("&");
                                for(int i=0;i<g.length;i++)
                                    N_n.add(Integer.parseInt(g[i]));
                            }
                            NewSheep();
                        }
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                ////////////////////////////
                //log.println("1 shod");

                iu=1;
                // }
            }
        }
    }
    public HashMap<String,String> h1=new HashMap<String, String>();
    public HashMap<String,String> h3=new HashMap<String, String>();
    public HashMap<String,String> h5=new HashMap<String, String>();
    public HashMap<String,String> h6=new HashMap<String, String>();
    public HashMap<String,String> h7=new HashMap<String, String>();
    public HashMap<String,String> h8=new HashMap<String, String>();
    public HashMap<String, String> getH7() {return h7;}
    public void setH7(HashMap<String, String> h7) {this.h7 = h7;}
    public HashMap<String, String> getH8() {return h8;}
    public void setH8(HashMap<String, String> h8) {this.h8 = h8;}
    public HashMap<Integer,ArrayList<Integer>> h4=new HashMap<Integer, ArrayList<Integer>>();
    public HashMap<String, String> getH1() {return h1;}
    public void setH1(HashMap<String, String> h1) {this.h1 = h1;}
    public HashMap<String, String> getH3() {return h3;}
    public HashMap<Integer, ArrayList<Integer>> getH4() {return h4;}
    public void setH4(HashMap<Integer, ArrayList<Integer>> h4) {this.h4 = h4;}
    public void setH3(HashMap<String, String> h3) {this.h3 = h3;}
    public HashMap<String, String> getH5() {return h5;}
    public void setH5(HashMap<String, String> h5) {this.h5 = h5;}
    public HashMap<String, String> getH6() {return h6;}
    public void setH6(HashMap<String, String> h6) {this.h6 = h6;}
    HashMap<Integer, ArrayList<Integer>> x1=new HashMap<Integer, ArrayList<Integer>>();
    HashMap<Integer, ArrayList<Integer>> last_sheep=new HashMap<Integer, ArrayList<Integer>>();
    public HashMap<Integer, ArrayList<Integer>> getLast_sheep() {return last_sheep;}
    public void setLast_sheep(HashMap<Integer, ArrayList<Integer>> last_sheep) {this.last_sheep = last_sheep;}
    public HashMap<Integer, ArrayList<Integer>> getX1() {return x1;}
    public void setX1(HashMap<Integer, ArrayList<Integer>> x1) {this.x1 = x1;}
    public HashMap<String,HashMap<Integer,ArrayList<Integer>>> UnRewarded=new HashMap<String, HashMap<Integer, ArrayList<Integer>>>();
    public HashMap<String,String> par2=new HashMap<String, String>();
    public HashMap<String,String> par3=new HashMap<String, String>();
    public HashMap<Integer,HashMap<Integer, ArrayList<Integer>>> stepedcow=new HashMap<Integer, HashMap<Integer, ArrayList<Integer>>>();
    public HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> getStepedcow() {return stepedcow;}
    public void setStepedcow(HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> stepedcow) {this.stepedcow = stepedcow;}
    public double Action(double x0,double y0,double x1,double y1){
        double d=(180/3.14)*Math.atan2(x0 * y1 - y0 * x1, x0 * x1 + y0 * y1);
        return d;
    }
    public int old_ha=0;
    public int old_hg=0;
    public int old_ga=0;
    public int old_gg=0;
    public int old_nm=0;
    public int old_ra=0;
    public int old_rg=0;
    String old_s = "";
    HashMap<String,ArrayList<Integer>> las_neighbor=new HashMap<String, ArrayList<Integer>>();
    HashMap<Integer,ArrayList<Integer>> catched=new HashMap<Integer, ArrayList<Integer>>();
    public HashMap<Integer, ArrayList<Integer>> getCatched() {return catched;}
    public void setCatched(HashMap<Integer, ArrayList<Integer>> catched) {this.catched = catched;}
    public int ns=0;
    public int getNs() {return ns;}
    public void setNs(int ns) {this.ns = ns;}
    public HashMap<String,ArrayList<Double>> last_cent=new HashMap<String, ArrayList<Double>>();
    public String DetermineAction(int x0,int y0,int x1,int y1){
        String act="";
        if(x0==x1 && y0==y1)
            act="skip";
        else {
            double al = alpha1(x1, y1, x0, y0);
            if ((al >= 0 && al <= 22.5) || (al > 337.5 && al <= 360)) {
                act = "east";
            }
            if (al > 22.5 && al <= 67.5) {
                act = "northeast";
            }
            if (al > 67.5 && al <= 112.5) {
                act = "north";
            }
            if (al > 112.5 && al <= 157.5) {
                act = "northwest";
            }
            if (al > 157.5 && al <= 202.5) {
                act = "west";
            }
            if (al > 202.5 && al <= 247.5) {
                act = "southwest";
            }
            if (al > 247.5 && al <= 292.5) {
                act = "south";
            }
            if (al > 292.5 && al <= 337.5) {
                act = "southeast";
            }
        }
        return act;
    }
    public String pre_action="";boolean prev_goal=false;
    public HashMap<Integer,ArrayList<Integer>> sheep_prev=new HashMap<Integer, ArrayList<Integer>>();
    public HashMap<Integer,ArrayList<Integer>> ses=new HashMap<Integer, ArrayList<Integer>>();
    public HashMap<Integer, ArrayList<Integer>> getSes() {return ses;}
    public void setSes(HashMap<Integer, ArrayList<Integer>> ses) {this.ses = ses;}
    public int es=0;
    public int getEs() {return es;}
    public void setEs(int es) {this.es = es;}
    public boolean Gs(String act){
        boolean gs=false;
        double al = alpha1(corral_min_x,corral_min_y,cent.get(0), cent.get(1));
        if ((al >= 0 && al <= 22.5) || (al >= 337.5 && al <= 360)) {
            if(act.equals("east") || act.equals("northeast") || act.equals("southeast")) {
                gs = true;
                //log.println("act tocent is "+act +" and must be east too");log.flush();
            }
            else {
                gs = false;
                //log.println("act tocent is "+act +" but must be east");log.flush();
            }
        }
        if (al > 22.5 && al < 67.5) {
            if(act.equals("northeast") || act.equals("east") || act.equals("north")) {
                gs = true;
                //log.println("act tocent is "+act +" and must be northeast too");log.flush();
            }
            else {
                gs = false;
                //log.println("act tocent is "+act +" but must be northeast");log.flush();
            }
        }
        if (al >= 67.5 && al <= 112.5) {
            if(act.equals("north") || act.equals("northeast") || act.equals("northwest")) {
                gs = true;
                //log.println("act tocent is "+act +" and must be north too");log.flush();
            }
            else {
                gs = false;
                //log.println("act tocent is "+act +" but must be north");log.flush();
            }
        }
        if (al > 112.5 && al <= 157.5) {
            if(act.equals("northwest") || act.equals("north") || act.equals("west")) {
                gs = true;
                //log.println("act tocent is "+act +" and must be northwest too");log.flush();
            }
            else {
                gs = false;
                //log.println("act tocent is "+act +" but must be northwest");log.flush();
            }
        }
        if (al > 157.5 && al <= 202.5) {
            if(act.equals("west") || act.equals("northwest") || act.equals("southwest")) {
                gs = true;
                //log.println("act tocent is "+act +" and must be west too");log.flush();
            }
            else {
                gs = false;
                //log.println("act tocent is "+act +" but must be west");log.flush();
            }
        }
        if (al > 202.5 && al <= 247.5) {
            if(act.equals("southwest") || act.equals("west") || act.equals("south")) {
                gs = true;
                //log.println("act tocent is "+act +" and must be southwest too");log.flush();
            }
            else {
                gs = false;
                //log.println("act tocent is "+act +" but must be southwest");log.flush();
            }
        }
        if (al > 247.5 && al <= 292.5) {
            if(act.equals("south") || act.equals("southeast") || act.equals("southwest")) {
                gs = true;
                //log.println("act tocent is "+act +" and must be south too");log.flush();
            }
            else {
                gs = false;
                //log.println("act tocent is "+act +" but must be south");log.flush();
            }
        }
        if (al > 292.5 && al < 337.5) {
            if(act.equals("southeast") || act.equals("east") || act.equals("south")) {
                gs = true;
                //log.println("act tocent is "+act +" and must be southeast too");log.flush();
            }
            else {
                gs = false;
                //log.println("act tocent is "+act +" but must be southeast");log.flush();
            }
        }
        return gs;
    }
    public int getGaurd() {return gaurd;}
    public void setGaurd(int gaurd) {this.gaurd = gaurd;}
    public int gaurd=0;
    //public HashMap<Integer,ArrayList<Integer>> gaurder=new HashMap<Integer, ArrayList<Integer>>();
    public HashMap<Integer,ArrayList<Integer>> gaurder_prev=new HashMap<Integer, ArrayList<Integer>>();
    public String Gd(){
        String action="";
        if(Math.sqrt((48-posX)*(48-posX)+(36-posY)*(36-posY))>2) {
            ArrayList<Double> d = new ArrayList<Double>();
            d.add(0, 48.0);
            d.add(1, 36.0);
            action = ToCentroid(d);
            //log.println(" gaurdner tocent action set shod");
            log.flush();
        }
        else {
            action = "skip";
            //log.println(" gaurdner skip action set shod");
            log.flush();
        }
        return action;
    }
    public void Gd2(){
        if(getGaurd()==1) {
            fw.print(posX + "#" + posY + "#gaurd&");
            fw.flush();
        }
        else
        {
            fw.print(posX + "#" + posY + "&");
            fw.flush();
        }
    }

    public HashMap<Integer,ArrayList<Integer>> cls(HashMap<Integer,ArrayList<Integer>> sheep,HashMap<Integer,ArrayList<Integer>> sheep_temp){
        HashMap<Integer,ArrayList<Integer>> cls2=new HashMap<Integer, ArrayList<Integer>>();
        for(int k1:sheep_temp.keySet()){
            cls2.put(k1,sheep_temp.get(k1));
        }
        for(int k1:sheep.keySet()){
            cls2.put(k1,sheep.get(k1));
        }
        ArrayList<HashMap<Integer,ArrayList<Integer>>> clsx=Cluster(cls2);
        HashMap<Integer,ArrayList<Integer>> cls1=this.Sheep(clsx);
        return cls1;
    }
    private HashMap<String,String> Q1GoAfterAlone = new HashMap<String, String>();
    private HashMap<String,String> Q1GoAfterGroup = new HashMap<String, String>();

    public HashMap<String, String> getQ1GoAfterGroup() {return Q1GoAfterGroup;}
    public void setQ1GoAfterGroup(HashMap<String, String> q1GoAfterGroup) {Q1GoAfterGroup = q1GoAfterGroup;}
    public HashMap<String, String> getQ1GoAfterAlone() {return Q1GoAfterAlone;}
    public void setQ1GoAfterAlone(HashMap<String, String> q1GoAfterAlone) {Q1GoAfterAlone = q1GoAfterAlone;}
    public void UnRew(){
        if (UnRewarded.containsKey(old_s)) {
            ///////////////
            //////////////
            x1=new HashMap<Integer, ArrayList<Integer>>();
            //log.println("hala bayad " + old_s + "   reward dade shavad last cent was "+last_cent.get(old_s));
            log.flush();
            //log.println("dar ghabl gavha " + UnRewarded.get(old_s));
            log.flush();
            //log.println("gav ha in curren step me step " + Step_SeenCows);
            log.flush();
            for (int key : UnRewarded.get(old_s).keySet()) {
                if (Step_SeenCows.containsKey(key))
                    x1.put(key, Step_SeenCows.get(key));
                else {
                    for (int i = 1; i <= 10; i++) {
                        if (i != Integer.parseInt(username)) {
                            Method method = null;
                            try {
                                method = this.getClass().getMethod("getAgent" + i);
                                Object object = (Object) method.invoke(this);
                                Method method1 = object.getClass().getDeclaredMethod("getStepedcow");
                                HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> nc = (HashMap) method1.invoke(object);
                                if (nc.containsKey(step)) {
                                    if (nc.get(step).containsKey(key)) {
                                        x1.put(key, nc.get(step).get(key));
                                        break;
                                    }
                                } else {
                                    int ux = 0;
                                    while (ux <= 9000000000000000000l) {
                                        method1 = object.getClass().getDeclaredMethod("getStepedcow");
                                        nc = (HashMap) method1.invoke(object);
                                        if (nc.containsKey(step)) {
                                            break;
                                        }
                                        ux++;
                                    }
                                    if (nc.get(step).containsKey(key)) {
                                        x1.put(key, nc.get(step).get(key));
                                        break;
                                    }
                                }
                                //log.println("Agent" + i + " gavha " + nc.get(step));
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }
            //log.println("alan gavha inja hastand " + x1);
            ///////////
            //log.println("old_ha:  "+old_ha+"  old_hg:  "+old_hg+"  old_ga:  "+old_ga+"  old_gg:  "+old_gg+"  old_nm:  "+old_nm +" old_ra: "+old_ra+"   old_rg: "+old_rg);log.flush();
            /////////////////
            if (x1.size() > 0){
                HashMap<String, String> QQ_next = new HashMap<String, String>();
                ArrayList<Double> next_cent = centroid(x1);int w1_next=0;int w2_next=0;int w3_next=0;
                if (old_ha == 1) {
                    double a1_next = Math.sqrt((posX - next_cent.get(0)) * (posX - next_cent.get(0)) + (posY - next_cent.get(1)) * (posY - next_cent.get(1)));
                    double a2_next = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
                    double a3_next = findAngle(corral_x, corral_y, posX, posY, next_cent.get(0), next_cent.get(1));
                    w1_next=this.p1(a1_next);
                    w2_next=this.p2(a2_next);
                    w3_next=this.p3(a3_next);
                    QQ_next = QlHerdAlone(w1_next + "," + w2_next + "," + w3_next);
                }
                if(old_ra==1){
                    double a1_next = Math.sqrt((posX - next_cent.get(0)) * (posX - next_cent.get(0)) + (posY - next_cent.get(1)) * (posY - next_cent.get(1)));
                    double a2_next = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
                    double a3_next = findAngle(corral_x, corral_y, posX, posY, next_cent.get(0), next_cent.get(1));
                    w1_next=this.p1(a1_next);
                    w2_next=this.p2(a2_next);
                    w3_next=this.p3(a3_next);
                    QQ_next = QlRandAlone(w1_next + "," + w2_next + "," + w3_next);
                }
                if(old_ga==1){
                    double a1_next = Math.sqrt((posX - next_cent.get(0)) * (posX - next_cent.get(0)) + (posY - next_cent.get(1)) * (posY - next_cent.get(1)));
                    double a2_next = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
                    double a3_next = findAngle(corral_x, corral_y, posX, posY, next_cent.get(0), next_cent.get(1));
                    w1_next=this.p1(a1_next);
                    w2_next=this.p2(a2_next);
                    w3_next=this.p3(a3_next);
                    QQ_next = QlGoAfterAlone(w1_next + "," + w2_next + "," + w3_next);
                }
                if (old_hg == 1) {
                    double a1_next = Math.sqrt((posX - next_cent.get(0)) * (posX - next_cent.get(0)) + (posY - next_cent.get(1)) * (posY - next_cent.get(1)));
                    double a2_next = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
                    double a3_next = findAngle(corral_x, corral_y, posX, posY, next_cent.get(0), next_cent.get(1));
                    for (int ii = 0; ii < N_n.size(); ii++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(ii));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            a1_next += Math.sqrt((prev1.get(step).get(0) - next_cent.get(0)) * (prev1.get(step).get(0) - next_cent.get(0)) + (prev1.get(step).get(1) - next_cent.get(1)) * (prev1.get(step).get(1) - next_cent.get(1)));
                            a2_next += Math.sqrt((prev1.get(step).get(0) - corral_x) * (prev1.get(step).get(0) - corral_x) + (prev1.get(step).get(1) - corral_y) * (prev1.get(step).get(1) - corral_y));
                            a3_next += findAngle(corral_x, corral_y, prev1.get(step).get(0), prev1.get(step).get(1), next_cent.get(0), next_cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    a1_next = a1_next / (N_n.size() + 1);
                    a2_next = a2_next / (N_n.size() + 1);
                    a3_next = a3_next / (N_n.size() + 1);
                    w1_next=this.p1(a1_next);
                    w2_next=this.p2(a2_next);
                    w3_next=this.p3(a3_next);
                    QQ_next = QlHerdGroupCentral(w1_next + "," + w2_next + "," + w3_next);

                }
                if (old_rg == 1) {
                    double a1_next = Math.sqrt((posX - next_cent.get(0)) * (posX - next_cent.get(0)) + (posY - next_cent.get(1)) * (posY - next_cent.get(1)));
                    double a2_next = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
                    double a3_next = findAngle(corral_x, corral_y, posX, posY, next_cent.get(0), next_cent.get(1));
                    for (int ii = 0; ii < N_n.size(); ii++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(ii));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            a1_next += Math.sqrt((prev1.get(step).get(0) - next_cent.get(0)) * (prev1.get(step).get(0) - next_cent.get(0)) + (prev1.get(step).get(1) - next_cent.get(1)) * (prev1.get(step).get(1) - next_cent.get(1)));
                            a2_next += Math.sqrt((prev1.get(step).get(0) - corral_x) * (prev1.get(step).get(0) - corral_x) + (prev1.get(step).get(1) - corral_y) * (prev1.get(step).get(1) - corral_y));
                            a3_next += findAngle(corral_x, corral_y, prev1.get(step).get(0), prev1.get(step).get(1), next_cent.get(0), next_cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    a1_next = a1_next / (N_n.size() + 1);
                    a2_next = a2_next / (N_n.size() + 1);
                    a3_next = a3_next / (N_n.size() + 1);
                    w1_next=this.p1(a1_next);
                    w2_next=this.p2(a2_next);
                    w3_next=this.p3(a3_next);
                    QQ_next = QlRandGroup(w1_next + "," + w2_next + "," + w3_next);

                }
                if (old_gg == 1) {
                    double a1_next = Math.sqrt((posX - next_cent.get(0)) * (posX - next_cent.get(0)) + (posY - next_cent.get(1)) * (posY - next_cent.get(1)));
                    double a2_next = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
                    double a3_next = findAngle(corral_x, corral_y, posX, posY, next_cent.get(0), next_cent.get(1));
                    for (int ii = 0; ii < N_n.size(); ii++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(ii));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            a1_next += Math.sqrt((prev1.get(step).get(0) - next_cent.get(0)) * (prev1.get(step).get(0) - next_cent.get(0)) + (prev1.get(step).get(1) - next_cent.get(1)) * (prev1.get(step).get(1) - next_cent.get(1)));
                            a2_next += Math.sqrt((prev1.get(step).get(0) - corral_x) * (prev1.get(step).get(0) - corral_x) + (prev1.get(step).get(1) - corral_y) * (prev1.get(step).get(1) - corral_y));
                            a3_next += findAngle(corral_x, corral_y, prev1.get(step).get(0), prev1.get(step).get(1), next_cent.get(0), next_cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    a1_next = a1_next / (N_n.size() + 1);
                    a2_next = a2_next / (N_n.size() + 1);
                    a3_next = a3_next / (N_n.size() + 1);
                    w1_next=this.p1(a1_next);
                    w2_next=this.p2(a2_next);
                    w3_next=this.p3(a3_next);
                    QQ_next = QlGoAfterGroup(w1_next + "," + w2_next + "," + w3_next);

                }
                //log.println("QQ_next is: " + QQ_next);
                double next_state = 0;
                double max_2 = 1000000000000000l;
                ////log.println("omadam inja34  "+QQ_next);log.flush();
                if (QQ_next.size() == 0) {
                    ////log.println("omadam inja35  ");log.flush();
                    next_state = 0;
                } else {
                    ////log.println("omadam inja36  ");log.flush();
                    if(old_ha==1 || old_hg==1 || old_ra==1 || old_rg==1 || old_ga==1 || old_gg==1){
                        for (String key1 : QQ_next.keySet()) {
                            String d = QQ_next.get(key1);
                            ////log.println("omadam inja37  ");log.flush();
                            String dx[]=d.split("#");
                            double d2 = Double.parseDouble(dx[0]);
                            if (d2 < max_2) {
                                //  //log.println("omadam inja38  ");log.flush();
                                max_2= d2;
                                next_state = d2;
                            }
                        }
                    }
                }
                //log.println("nextstate is "+next_state);log.flush();
                double rew = 0;
                if (old_ha == 1) {
                    ///////////////////////
                    if (Prev_Pos.size()>=2 && Prev_Pos.get(step).get(0)==Prev_Pos.get(step - 1).get(0) && Prev_Pos.get(step).get(1)==Prev_Pos.get(step - 1).get(1) && !pre_action.equals("skip")) {
                        //log.println("bad reward gained");log.flush();
                        rew=10000000000000l;
                    }
                    //////////////////////////////
                    else {
                        rew = -(Math.sqrt((last_cent.get(old_s).get(0) - corral_x) * (last_cent.get(old_s).get(0) - corral_x) + (last_cent.get(old_s).get(1) - corral_y) * (last_cent.get(old_s).get(1) - corral_y))-Math.sqrt((next_cent.get(0) - corral_x) * (next_cent.get(0) - corral_x) + (next_cent.get(1) - corral_y) * (next_cent.get(1) - corral_y)));
                    }
                    ///////////////
                    ///////////////
                    ArrayList<Integer> prev = Prev_Pos.get(step - 1);double ax1 =0,ax2=0;double ax3=0;
                    ax1=Math.sqrt((posX-last_cent.get(old_s).get(0))*(posX-last_cent.get(old_s).get(0))+(posY-last_cent.get(old_s).get(1))*(posY-last_cent.get(old_s).get(1)))-Math.sqrt((prev.get(0)-last_cent.get(old_s).get(0))*(prev.get(0)-last_cent.get(old_s).get(0))+(prev.get(1)-last_cent.get(old_s).get(1))*(prev.get(1)-last_cent.get(old_s).get(1)));
                    ax2=Math.sqrt((posX-corral_x)*(posX-corral_x)+(posY-corral_y)*(posY-corral_y))-Math.sqrt((prev.get(0)-corral_x)*(prev.get(0)-corral_x)+(prev.get(1)-corral_y)*(prev.get(1)-corral_y));
                    ax3=findAngle(corral_x,corral_y,posX,posY,last_cent.get(old_s).get(0),last_cent.get(old_s).get(1))-findAngle(corral_x,corral_y,prev.get(0),prev.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1));
                    if (this.Q1HerdAlone.containsKey(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3))) {
                        ////log.println("omadam inja44  "+this.Q1GoAfterAlone.get(s));log.flush();
                        String r0 = this.Q1HerdAlone.get(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3));
                        String r0x[]=r0.split("#");
                        double r3 = Double.parseDouble(r0x[0]);
                        double r2 = r3 + alpha * ((rew - r3) + gamma * next_state);
                        this.Q1HerdAlone.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2+"#"+ax1+"#"+ax2+"#"+ax3);
                        //log.println("old state is:  " +old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3)+ " man value update kardam  goafteralone ba meghdare "+r2 + "");
                        log.flush();
                        ////log.println("omadam inja45  ");log.flush();
                    } else {
                        ////log.println("omadam inja46  ");log.flush();
                        double r2 = ((alpha * (rew + gamma * next_state)));
                        //HashMap<Integer,String> r3= GetNeighborAction(perception,r2);
                        this.Q1HerdAlone.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2+"#"+ax1+"#"+ax2+"#"+ax3);
                        //this.Q1table_GoAfter.get(s).put(11, r2);
                        //log.println("old state is:  " + old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3)+ "   man value gharar dadam baraara goafteralone ba  meghdare " + r2);
                        log.flush();
                        ////log.println("omadam inja47  ");log.flush();
                    }
                    ////                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "//////////
                }
                if (old_ra == 1) {
                    ///////////////////////
                    if (Prev_Pos.size()>=2 && Prev_Pos.get(step).get(0)==Prev_Pos.get(step - 1).get(0) && Prev_Pos.get(step).get(1)==Prev_Pos.get(step - 1).get(1) && !pre_action.equals("skip")) {
                        //log.println("bad reward gained");log.flush();
                        rew=10000000000000l;
                    }
                    //////////////////////////////
                    else {
                        rew = -(alpha1(last_cent.get(old_s).get(0), last_cent.get(old_s).get(1), corral_x, corral_y)-alpha1(next_cent.get(0), next_cent.get(1), corral_x, corral_y));
                    }
                    ///////////////
                    ///////////////
                    ArrayList<Integer> prev = Prev_Pos.get(step - 1);double ax1 =0,ax2=0;double ax3=0;
                    ax1=Math.sqrt((posX-last_cent.get(old_s).get(0))*(posX-last_cent.get(old_s).get(0))+(posY-last_cent.get(old_s).get(1))*(posY-last_cent.get(old_s).get(1)))-Math.sqrt((prev.get(0)-last_cent.get(old_s).get(0))*(prev.get(0)-last_cent.get(old_s).get(0))+(prev.get(1)-last_cent.get(old_s).get(1))*(prev.get(1)-last_cent.get(old_s).get(1)));
                    ax2=Math.sqrt((posX-corral_x)*(posX-corral_x)+(posY-corral_y)*(posY-corral_y))-Math.sqrt((prev.get(0)-corral_x)*(prev.get(0)-corral_x)+(prev.get(1)-corral_y)*(prev.get(1)-corral_y));
                    ax3=findAngle(corral_x,corral_y,posX,posY,last_cent.get(old_s).get(0),last_cent.get(old_s).get(1))-findAngle(corral_x,corral_y,prev.get(0),prev.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1));
                    if (this.Q1RandAlone.containsKey(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3))) {
                        ////log.println("omadam inja44  "+this.Q1GoAfterAlone.get(s));log.flush();
                        String r0 = this.Q1RandAlone.get(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3));
                        String r0x[]=r0.split("#");
                        double r3 = Double.parseDouble(r0x[0]);
                        double r2 = r3 + alpha * ((rew - r3) + gamma * next_state);
                        this.Q1RandAlone.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2+"#"+ax1+"#"+ax2+"#"+ax3);
                        //log.println("old state is:  " +old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3)+ " man value update kardam  goafteralone ba meghdare "+r2 + "");
                        log.flush();
                        ////log.println("omadam inja45  ");log.flush();
                    } else {
                        ////log.println("omadam inja46  ");log.flush();
                        double r2 = ((alpha * (rew + gamma * next_state)));
                        //HashMap<Integer,String> r3= GetNeighborAction(perception,r2);
                        this.Q1RandAlone.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2+"#"+ax1+"#"+ax2+"#"+ax3);
                        //this.Q1table_GoAfter.get(s).put(11, r2);
                        //log.println("old state is:  " + old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3)+ "   man value gharar dadam baraara goafteralone ba  meghdare " + r2);
                        log.flush();
                        ////log.println("omadam inja47  ");log.flush();
                    }
                    ////                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "//////////
                }
                if (old_ga == 1) {
                    ///////////////////////
                    if (Prev_Pos.size()>=2 && Prev_Pos.get(step).get(0)==Prev_Pos.get(step - 1).get(0) && Prev_Pos.get(step).get(1)==Prev_Pos.get(step - 1).get(1) && !pre_action.equals("skip")) {
                        //log.println("bad reward gained");log.flush();
                        rew=10000000000000l;
                    }
                    //////////////////////////////
                    else {
                        rew = (findAngle(Prev_Pos.get(step-1).get(0),Prev_Pos.get(step-1).get(1), last_cent.get(old_s).get(0), last_cent.get(old_s).get(1),corral_min_x,corral_min_y)-(findAngle(posX,posY,next_cent.get(0),next_cent.get(1),corral_min_x,corral_min_y)));
                    }
                    ///////////////
                    ///////////////
                    ArrayList<Integer> prev = Prev_Pos.get(step - 1);double ax1 =0,ax2=0;double ax3=0;
                    ax1=Math.sqrt((posX-last_cent.get(old_s).get(0))*(posX-last_cent.get(old_s).get(0))+(posY-last_cent.get(old_s).get(1))*(posY-last_cent.get(old_s).get(1)))-Math.sqrt((prev.get(0)-last_cent.get(old_s).get(0))*(prev.get(0)-last_cent.get(old_s).get(0))+(prev.get(1)-last_cent.get(old_s).get(1))*(prev.get(1)-last_cent.get(old_s).get(1)));
                    ax2=Math.sqrt((posX-corral_x)*(posX-corral_x)+(posY-corral_y)*(posY-corral_y))-Math.sqrt((prev.get(0)-corral_x)*(prev.get(0)-corral_x)+(prev.get(1)-corral_y)*(prev.get(1)-corral_y));
                    ax3=findAngle(corral_x,corral_y,posX,posY,last_cent.get(old_s).get(0),last_cent.get(old_s).get(1))-findAngle(corral_x,corral_y,prev.get(0),prev.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1));
                    if (this.Q1GoAfterAlone.containsKey(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3))) {
                        ////log.println("omadam inja44  "+this.Q1GoAfterAlone.get(s));log.flush();
                        String r0 = this.Q1GoAfterAlone.get(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3));
                        String r0x[]=r0.split("#");
                        double r3 = Double.parseDouble(r0x[0]);
                        double r2 = r3 + alpha * ((rew - r3) + gamma * next_state);
                        this.Q1GoAfterAlone.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2+"#"+ax1+"#"+ax2+"#"+ax3);
                        //log.println("old state is:  " +old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3)+ " man value update kardam  goafteralone ba meghdare "+r2 + "");
                        log.flush();
                        ////log.println("omadam inja45  ");log.flush();
                    } else {
                        ////log.println("omadam inja46  ");log.flush();
                        double r2 = ((alpha * (rew + gamma * next_state)));
                        //HashMap<Integer,String> r3= GetNeighborAction(perception,r2);
                        this.Q1GoAfterAlone.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2+"#"+ax1+"#"+ax2+"#"+ax3);
                        //this.Q1table_GoAfter.get(s).put(11, r2);
                        //log.println("old state is:  " + old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3)+ "   man value gharar dadam baraara goafteralone ba  meghdare " + r2);
                        log.flush();
                        ////log.println("omadam inja47  ");log.flush();
                    }
                    ////                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "//////////
                }
                if (old_hg == 1) {
                    ArrayList<Integer> prev = Prev_Pos.get(step - 1);double ax1 =0,ax2=0;double ax3=0;
                    ArrayList<Integer> prevx = Prev_Pos.get(step);
                    String act1=DetermineAction(prev.get(0),prev.get(1),prevx.get(0),prevx.get(1));
                    //log.println("fahmidim Agent"+username+"  dar step ghabl actionesh "+act1+"  bode");log.flush();
                    String act2=Next(act1);
                    String act3[]=act2.split("#");
                    int i=Integer.parseInt(act3[0]);
                    int j=Integer.parseInt(act3[1]);
                    ////////////// ActionTotal determination
                    for (int u = 0; u < las_neighbor.get(old_s).size(); u++) {
                        ///////////
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + las_neighbor.get(old_s).get(u));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getDeclaredMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            ArrayList<Integer> prev2 = prev1.get(step - 1);
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                            ArrayList<Integer> prev3 = prev1.get(step);
                            act1=DetermineAction(prev2.get(0),prev2.get(1),prev3.get(0),prev3.get(1));
                            //log.println("fahmidim Agent"+las_neighbor.get(old_s).get(u)+"  dar step ghabl actionesh "+act1+"  bode");log.flush();
                            act2=Next(act1);
                            String act4[]=act2.split("#");
                            i+=Double.parseDouble(act4[0]);
                            j+=Double.parseDouble(act4[1]);
                            //////////////
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        ///////////
                    }
                    ActionTotal=Direction(i,j);
                    //log.println("and now act total is "+ActionTotal);log.flush();
                    /////////////
                    //rew = Math.sqrt((next_cent.get(0) - corral_min_x) * (next_cent.get(0) - corral_min_x) + (next_cent.get(1) - corral_min_y) * (next_cent.get(1) - corral_min_y));
                    ///////////////
                    ArrayList<Integer> P1=new ArrayList<Integer>();
                    ArrayList<Integer> prevxx = Prev_Pos.get(step - 1);
                    P1 = NextState(prevxx.get(0), prevxx.get(1), ActionTotal);
                    //log.println("Agent"+username+"  agar tebgh act total miraft "+ActionTotal+"  inja bod  "+P1);log.flush();
                    ax1=Math.sqrt((P1.get(0)-last_cent.get(old_s).get(0))*(P1.get(0)-last_cent.get(old_s).get(0))+(P1.get(1)-last_cent.get(old_s).get(1))*(P1.get(1)-last_cent.get(old_s).get(1)))-Math.sqrt((prevxx.get(0)-last_cent.get(old_s).get(0))*(prevxx.get(0)-last_cent.get(old_s).get(0))+(prevxx.get(1)-last_cent.get(old_s).get(1))*(prevxx.get(1)-last_cent.get(old_s).get(1)));
                    ax2=Math.sqrt((P1.get(0)-corral_x)*(P1.get(0)-corral_x)+(P1.get(1)-corral_y)*(P1.get(1)-corral_y))-Math.sqrt((prevxx.get(0)-corral_x)*(prevxx.get(0)-corral_x)+(prevxx.get(1)-corral_y)*(prevxx.get(1)-corral_y));
                    ax3=findAngle(corral_x,corral_y,P1.get(0),P1.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1))-findAngle(corral_x,corral_y,prevxx.get(0),prevxx.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1));
                    for (int u = 0; u < las_neighbor.get(old_s).size(); u++) {
                        ///////////
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + las_neighbor.get(old_s).get(u));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getDeclaredMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            prevxx =prev1.get(step - 1);
                            P1 = NextState(prevxx.get(0), prevxx.get(1), ActionTotal);
                            //log.println("Agent"+las_neighbor.get(old_s).get(u)+"  agar tebgh act total miraft "+ActionTotal+"  inja bod  "+P1);log.flush();
                            ax1+=Math.sqrt((P1.get(0)-last_cent.get(old_s).get(0))*(P1.get(0)-last_cent.get(old_s).get(0))+(P1.get(1)-last_cent.get(old_s).get(1))*(P1.get(1)-last_cent.get(old_s).get(1)))-Math.sqrt((prevxx.get(0)-last_cent.get(old_s).get(0))*(prevxx.get(0)-last_cent.get(old_s).get(0))+(prevxx.get(1)-last_cent.get(old_s).get(1))*(prevxx.get(1)-last_cent.get(old_s).get(1)));
                            ax2+=Math.sqrt((P1.get(0)-corral_x)*(P1.get(0)-corral_x)+(P1.get(1)-corral_y)*(P1.get(1)-corral_y))-Math.sqrt((prevxx.get(0)-corral_x)*(prevxx.get(0)-corral_x)+(prevxx.get(1)-corral_y)*(prevxx.get(1)-corral_y));
                            ax3+=findAngle(corral_x,corral_y,P1.get(0),P1.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1))-findAngle(corral_x,corral_y,prevxx.get(0),prevxx.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1));
                            //////////////
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        ///////////
                    }
                    ax1 = ax1 / (N_n.size() + 1);
                    ax2 = ax2 / (N_n.size() + 1);
                    ax3 = ax3 / (N_n.size() + 1);

                    rew = -(Math.sqrt((last_cent.get(old_s).get(0) - corral_x) * (last_cent.get(old_s).get(0) - corral_x) + (last_cent.get(old_s).get(1) - corral_y) * (last_cent.get(old_s).get(1) - corral_y))-Math.sqrt((next_cent.get(0) - corral_x) * (next_cent.get(0) - corral_x) + (next_cent.get(1) - corral_y) * (next_cent.get(1) - corral_y)));
                    if (this.Q1HerdGroupCentral.containsKey(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3))) {
                        ////log.println("omadam inja44  "+this.Q1GoAfterAlone.get(s));log.flush();
                        String r0 = this.Q1HerdGroupCentral.get(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3));
                        String r0x[]=r0.split("#");
                        double r3 = Double.parseDouble(r0x[0]);
                        double r2 = r3 + alpha * ((rew - r3) + gamma * next_state);
                        this.Q1HerdGroupCentral.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2 + "#"+ax1+"#"+ax2+"#"+ax3);
                        //log.println("old state is:  " +old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3)+ "     man value update kardam herdgroup ba  meghdare"+r2 + "#" + par3.get(old_s));
                        log.flush();
                        ////log.println("omadam inja45  ");log.flush();
                    } else {

                        double r2 = ((alpha * (rew + gamma * next_state)));
                        //HashMap<Integer,String> r3= GetNeighborAction(perception,r2);
                        this.Q1HerdGroupCentral.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2 + "#"+ax1+"#"+ax2+"#"+ax3);
                        //this.Q1table_GoAfter.get(s).put(11, r2);
                        //log.println("old state is:  " +old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3) + "   man value gharar dadam baraara herdgroup ba  meghdare"+r2 + "#" + par3.get(old_s));
                        log.flush();
                        ////log.println("omadam inja47  ");log.flush();
                    }
                }
                /////////////////
                if (old_rg == 1) {
                    ArrayList<Integer> prev = Prev_Pos.get(step - 1);double ax1 =0,ax2=0;double ax3=0;
                    ArrayList<Integer> prevx = Prev_Pos.get(step);
                    String act1=DetermineAction(prev.get(0),prev.get(1),prevx.get(0),prevx.get(1));
                    //log.println("fahmidim Agent"+username+"  dar step ghabl actionesh "+act1+"  bode");log.flush();
                    String act2=Next(act1);
                    String act3[]=act2.split("#");
                    int i=Integer.parseInt(act3[0]);
                    int j=Integer.parseInt(act3[1]);
                    ////////////// ActionTotal determination
                    for (int u = 0; u < las_neighbor.get(old_s).size(); u++) {
                        ///////////
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + las_neighbor.get(old_s).get(u));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getDeclaredMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            ArrayList<Integer> prev2 = prev1.get(step - 1);
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                            ArrayList<Integer> prev3 = prev1.get(step);
                            act1=DetermineAction(prev2.get(0),prev2.get(1),prev3.get(0),prev3.get(1));
                            //log.println("fahmidim Agent"+las_neighbor.get(old_s).get(u)+"  dar step ghabl actionesh "+act1+"  bode");log.flush();
                            act2=Next(act1);
                            String act4[]=act2.split("#");
                            i+=Double.parseDouble(act4[0]);
                            j+=Double.parseDouble(act4[1]);
                            //////////////
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        ///////////
                    }
                    ActionTotal=Direction(i,j);
                    //log.println("and now act total is "+ActionTotal);log.flush();
                    /////////////
                    //rew = Math.sqrt((next_cent.get(0) - corral_min_x) * (next_cent.get(0) - corral_min_x) + (next_cent.get(1) - corral_min_y) * (next_cent.get(1) - corral_min_y));
                    ///////////////
                    ArrayList<Integer> P1=new ArrayList<Integer>();
                    ArrayList<Integer> prevxx = Prev_Pos.get(step - 1);
                    P1 = NextState(prevxx.get(0), prevxx.get(1), ActionTotal);
                    //log.println("Agent"+username+"  agar tebgh act total miraft "+ActionTotal+"  inja bod  "+P1);log.flush();
                    ax1=Math.sqrt((P1.get(0)-last_cent.get(old_s).get(0))*(P1.get(0)-last_cent.get(old_s).get(0))+(P1.get(1)-last_cent.get(old_s).get(1))*(P1.get(1)-last_cent.get(old_s).get(1)))-Math.sqrt((prevxx.get(0)-last_cent.get(old_s).get(0))*(prevxx.get(0)-last_cent.get(old_s).get(0))+(prevxx.get(1)-last_cent.get(old_s).get(1))*(prevxx.get(1)-last_cent.get(old_s).get(1)));
                    ax2=Math.sqrt((P1.get(0)-corral_x)*(P1.get(0)-corral_x)+(P1.get(1)-corral_y)*(P1.get(1)-corral_y))-Math.sqrt((prevxx.get(0)-corral_x)*(prevxx.get(0)-corral_x)+(prevxx.get(1)-corral_y)*(prevxx.get(1)-corral_y));
                    ax3=findAngle(corral_x,corral_y,P1.get(0),P1.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1))-findAngle(corral_x,corral_y,prevxx.get(0),prevxx.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1));
                    for (int u = 0; u < las_neighbor.get(old_s).size(); u++) {
                        ///////////
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + las_neighbor.get(old_s).get(u));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getDeclaredMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            prevxx =prev1.get(step - 1);
                            P1 = NextState(prevxx.get(0), prevxx.get(1), ActionTotal);
                            //log.println("Agent"+las_neighbor.get(old_s).get(u)+"  agar tebgh act total miraft "+ActionTotal+"  inja bod  "+P1);log.flush();
                            ax1+=Math.sqrt((P1.get(0)-last_cent.get(old_s).get(0))*(P1.get(0)-last_cent.get(old_s).get(0))+(P1.get(1)-last_cent.get(old_s).get(1))*(P1.get(1)-last_cent.get(old_s).get(1)))-Math.sqrt((prevxx.get(0)-last_cent.get(old_s).get(0))*(prevxx.get(0)-last_cent.get(old_s).get(0))+(prevxx.get(1)-last_cent.get(old_s).get(1))*(prevxx.get(1)-last_cent.get(old_s).get(1)));
                            ax2+=Math.sqrt((P1.get(0)-corral_x)*(P1.get(0)-corral_x)+(P1.get(1)-corral_y)*(P1.get(1)-corral_y))-Math.sqrt((prevxx.get(0)-corral_x)*(prevxx.get(0)-corral_x)+(prevxx.get(1)-corral_y)*(prevxx.get(1)-corral_y));
                            ax3+=findAngle(corral_x,corral_y,P1.get(0),P1.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1))-findAngle(corral_x,corral_y,prevxx.get(0),prevxx.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1));
                            //////////////
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        ///////////
                    }
                    ax1 = ax1 / (N_n.size() + 1);
                    ax2 = ax2 / (N_n.size() + 1);
                    ax3 = ax3 / (N_n.size() + 1);

                    rew = -(alpha1(last_cent.get(old_s).get(0), last_cent.get(old_s).get(1), corral_x, corral_y) - alpha1(next_cent.get(0), next_cent.get(1), corral_x, corral_y));
                    if (this.Q1RandGroup.containsKey(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3))) {
                        ////log.println("omadam inja44  "+this.Q1GoAfterAlone.get(s));log.flush();
                        String r0 = this.Q1RandGroup.get(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3));
                        String r0x[]=r0.split("#");
                        double r3 = Double.parseDouble(r0x[0]);
                        double r2 = r3 + alpha * ((rew - r3) + gamma * next_state);
                        this.Q1RandGroup.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2 + "#"+ax1+"#"+ax2+"#"+ax3);
                        //log.println("old state is:  " +old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3)+ "     man value update kardam herdgroup ba  meghdare"+r2 + "#" + par3.get(old_s));
                        log.flush();
                        ////log.println("omadam inja45  ");log.flush();
                    } else {

                        double r2 = ((alpha * (rew + gamma * next_state)));
                        //HashMap<Integer,String> r3= GetNeighborAction(perception,r2);
                        this.Q1RandGroup.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2 + "#"+ax1+"#"+ax2+"#"+ax3);
                        //this.Q1table_GoAfter.get(s).put(11, r2);
                        //log.println("old state is:  " +old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3) + "   man value gharar dadam baraara herdgroup ba  meghdare"+r2 + "#" + par3.get(old_s));
                        log.flush();
                        ////log.println("omadam inja47  ");log.flush();
                    }
                }
                //                            rew = (findAngle(Prev_Pos.get(step-1).get(0),Prev_Pos.get(step-1).get(1), last_cent.get(old_s).get(0), last_cent.get(old_s).get(1),corral_min_x,corral_min_y)-(findAngle(posX,posY,next_cent.get(0),next_cent.get(1),corral_min_x,corral_min_y)));
                if (old_gg == 1) {
                    ArrayList<Integer> prev = Prev_Pos.get(step - 1);double ax1 =0,ax2=0;double ax3=0;
                    ArrayList<Integer> prevx = Prev_Pos.get(step);
                    String act1=DetermineAction(prev.get(0),prev.get(1),prevx.get(0),prevx.get(1));
                    //log.println("fahmidim Agent"+username+"  dar step ghabl actionesh "+act1+"  bode");log.flush();
                    String act2=Next(act1);
                    String act3[]=act2.split("#");
                    int i=Integer.parseInt(act3[0]);
                    int j=Integer.parseInt(act3[1]);
                    ////////////// ActionTotal determination
                    for (int u = 0; u < las_neighbor.get(old_s).size(); u++) {
                        ///////////
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + las_neighbor.get(old_s).get(u));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getDeclaredMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            ArrayList<Integer> prev2 = prev1.get(step - 1);
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                            ArrayList<Integer> prev3 = prev1.get(step);
                            act1=DetermineAction(prev2.get(0),prev2.get(1),prev3.get(0),prev3.get(1));
                            //log.println("fahmidim Agent"+las_neighbor.get(old_s).get(u)+"  dar step ghabl actionesh "+act1+"  bode");log.flush();
                            act2=Next(act1);
                            String act4[]=act2.split("#");
                            i+=Double.parseDouble(act4[0]);
                            j+=Double.parseDouble(act4[1]);
                            //////////////
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        ///////////
                    }
                    ActionTotal=Direction(i,j);
                    //log.println("and now act total is "+ActionTotal);log.flush();
                    /////////////
                    //rew = Math.sqrt((next_cent.get(0) - corral_min_x) * (next_cent.get(0) - corral_min_x) + (next_cent.get(1) - corral_min_y) * (next_cent.get(1) - corral_min_y));
                    ///////////////
                    ArrayList<Integer> P1=new ArrayList<Integer>();
                    ArrayList<Integer> prevxx = Prev_Pos.get(step - 1);
                    P1 = NextState(prevxx.get(0), prevxx.get(1), ActionTotal);
                    //log.println("Agent"+username+"  agar tebgh act total miraft "+ActionTotal+"  inja bod  "+P1);log.flush();
                    ax1=Math.sqrt((P1.get(0)-last_cent.get(old_s).get(0))*(P1.get(0)-last_cent.get(old_s).get(0))+(P1.get(1)-last_cent.get(old_s).get(1))*(P1.get(1)-last_cent.get(old_s).get(1)))-Math.sqrt((prevxx.get(0)-last_cent.get(old_s).get(0))*(prevxx.get(0)-last_cent.get(old_s).get(0))+(prevxx.get(1)-last_cent.get(old_s).get(1))*(prevxx.get(1)-last_cent.get(old_s).get(1)));
                    ax2=Math.sqrt((P1.get(0)-corral_x)*(P1.get(0)-corral_x)+(P1.get(1)-corral_y)*(P1.get(1)-corral_y))-Math.sqrt((prevxx.get(0)-corral_x)*(prevxx.get(0)-corral_x)+(prevxx.get(1)-corral_y)*(prevxx.get(1)-corral_y));
                    ax3=findAngle(corral_x,corral_y,P1.get(0),P1.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1))-findAngle(corral_x,corral_y,prevxx.get(0),prevxx.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1));
                    for (int u = 0; u < las_neighbor.get(old_s).size(); u++) {
                        ///////////
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + las_neighbor.get(old_s).get(u));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getDeclaredMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            prevxx =prev1.get(step - 1);
                            P1 = NextState(prevxx.get(0), prevxx.get(1), ActionTotal);
                            //log.println("Agent"+las_neighbor.get(old_s).get(u)+"  agar tebgh act total miraft "+ActionTotal+"  inja bod  "+P1);log.flush();
                            ax1+=Math.sqrt((P1.get(0)-last_cent.get(old_s).get(0))*(P1.get(0)-last_cent.get(old_s).get(0))+(P1.get(1)-last_cent.get(old_s).get(1))*(P1.get(1)-last_cent.get(old_s).get(1)))-Math.sqrt((prevxx.get(0)-last_cent.get(old_s).get(0))*(prevxx.get(0)-last_cent.get(old_s).get(0))+(prevxx.get(1)-last_cent.get(old_s).get(1))*(prevxx.get(1)-last_cent.get(old_s).get(1)));
                            ax2+=Math.sqrt((P1.get(0)-corral_x)*(P1.get(0)-corral_x)+(P1.get(1)-corral_y)*(P1.get(1)-corral_y))-Math.sqrt((prevxx.get(0)-corral_x)*(prevxx.get(0)-corral_x)+(prevxx.get(1)-corral_y)*(prevxx.get(1)-corral_y));
                            ax3+=findAngle(corral_x,corral_y,P1.get(0),P1.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1))-findAngle(corral_x,corral_y,prevxx.get(0),prevxx.get(1),last_cent.get(old_s).get(0),last_cent.get(old_s).get(1));
                            //////////////
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        ///////////
                    }
                    ax1 = ax1 / (N_n.size() + 1);
                    ax2 = ax2 / (N_n.size() + 1);
                    ax3 = ax3 / (N_n.size() + 1);

                    rew = (findAngle(Prev_Pos.get(step-1).get(0),Prev_Pos.get(step-1).get(1), last_cent.get(old_s).get(0), last_cent.get(old_s).get(1),corral_min_x,corral_min_y)-(findAngle(posX,posY,next_cent.get(0),next_cent.get(1),corral_min_x,corral_min_y)));
                    if (this.Q1GoAfterGroup.containsKey(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3))) {
                        ////log.println("omadam inja44  "+this.Q1GoAfterAlone.get(s));log.flush();
                        String r0 = this.Q1GoAfterGroup.get(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3));
                        String r0x[]=r0.split("#");
                        double r3 = Double.parseDouble(r0x[0]);
                        double r2 = r3 + alpha * ((rew - r3) + gamma * next_state);
                        this.Q1GoAfterGroup.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2 + "#"+ax1+"#"+ax2+"#"+ax3);
                        //log.println("old state is:  " +old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3)+ "     man value update kardam herdgroup ba  meghdare"+r2 + "#" + par3.get(old_s));
                        log.flush();
                        ////log.println("omadam inja45  ");log.flush();
                    } else {

                        double r2 = ((alpha * (rew + gamma * next_state)));
                        //HashMap<Integer,String> r3= GetNeighborAction(perception,r2);
                        this.Q1GoAfterGroup.put(old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3), r2 + "#"+ax1+"#"+ax2+"#"+ax3);
                        //this.Q1table_GoAfter.get(s).put(11, r2);
                        //log.println("old state is:  " +old_s+","+p4(ax1)+"#"+p4(ax2)+"#"+p4(ax3) + "   man value gharar dadam baraara herdgroup ba  meghdare"+r2 + "#" + par3.get(old_s));
                        log.flush();
                        ////log.println("omadam inja47  ");log.flush();
                    }
                }
            }
            UnRewarded.remove(old_s);
            last_cent.remove(old_s);
            las_neighbor.remove(old_s);
        }
    }
    private int ui1=3000;
    private int ui2=4000;
    private int ui3=6000;
    private int ui4=11000;
    @SuppressWarnings("static-access")
    public void processRequestAction(Element perception, Element target, long currenttime, long deadline) throws IOException {

        //gaurder=new HashMap<Integer, ArrayList<Integer>>();
        this.action = "";
        uq = 0;
        iu = 0;
        ns = 0;
        pos.println(posX+"#"+posY);pos.flush();
        QQ = new HashMap<String, String>();
        setNoMode(0);
        setHerdAlone(0);
        setHerdGroup(0);
        setGoAfterGroup(0);
        setGoAfterAlone(0);
        setRandAlone(0);
        setRandGroup(0);
        Step_SeenCows = new HashMap<Integer, ArrayList<Integer>>();
        perc1 = new ArrayList<String>();
        perc11 = new ArrayList<String>();
        int k = 2;
        this.step = Integer.parseInt(perception.getAttribute("step"));
        //log.println("step:" + step);
        log.flush();
        this.posX = Integer.parseInt(perception.getAttribute("posx"));
        this.posY = Integer.parseInt(perception.getAttribute("posy"));
        ArrayList<Integer> pos = new ArrayList<Integer>();
        //log.println("posx : " + posX + "  posy: " + posY);
        log.flush();
        pos.add(0, posX);
        pos.add(1, posY);
        this.Prev_Pos.put(step, pos);
        NodeList cells = perception.getElementsByTagName("cell");//array of cells for one percep
        perc1.add(0, perception.getAttribute("posx"));
        perc1.add(1, perception.getAttribute("posy"));
        Gd2();
        for (int i = 0; i < cells.getLength(); i++) {
            NodeList state = cells.item(i).getChildNodes();
            NamedNodeMap Attrib = cells.item(i).getAttributes();
            if (state.item(1).getNodeName().equals("agent")) {
                NamedNodeMap satr = state.item(1).getAttributes();
                int a = this.posX + Integer.parseInt(Attrib.item(0).getNodeValue());
                int b = this.posY + Integer.parseInt(Attrib.item(1).getNodeValue());
                this.perc1.add(k++, a + "#" + b + "#" + "agent#" + satr.item(0).getNodeValue());
                fw.print(a + "#" + b + "#" + "agent#" + satr.item(0).getNodeValue() + "&");
                fw.flush();
            } else {
                if (state.item(1).getNodeName().equals("cow")) {
                    NamedNodeMap satr = state.item(1).getAttributes();
                    int a = posX + Integer.parseInt(Attrib.item(0).getNodeValue());
                    int b = (posY + Integer.parseInt(Attrib.item(1).getNodeValue()));
                    ArrayList N = new ArrayList();
                    N.add(Integer.parseInt(Attrib.item(0).getNodeValue()) + this.posX);
                    N.add(Integer.parseInt(Attrib.item(1).getNodeValue()) + this.posY);
                    if (a >= 25 && a <= 48 && b >= 25 && b <= 48) {
                        if (!h4.containsKey(Integer.parseInt(satr.item(0).getNodeValue()))) {
                            catched.put(Integer.parseInt(satr.item(0).getNodeValue()), N);
                            fw.print(a + "#" + b + "#" + "catch" + "#" + satr.item(0).getNodeValue() + "&");
                            fw.flush();
                        }
                    } else {
                        this.perc1.add(k++, a + "#" + b + "#" + "cow" + "#" + satr.item(0).getNodeValue());
                        this.perc11.add(a + "#" + b + "#" + "cow" + "#" + satr.item(0).getNodeValue());
                        if (!h4.containsKey(Integer.parseInt(satr.item(0).getNodeValue())))
                            this.Step_SeenCows.put(Integer.parseInt(satr.item(0).getNodeValue()), N);
                        /*if(h4.containsKey(Integer.parseInt(satr.item(0).getNodeValue()))){
                            gaurder.put(Integer.parseInt(satr.item(0).getNodeValue()), N);
                            catched.remove(Integer.parseInt(satr.item(0).getNodeValue()));
                            for(int i1=1;i1<=10;i1++) {
                                if (i1!=Integer.parseInt(username)) {
                                    Method method = null;
                                    try {
                                        method = this.getClass().getMethod("getAgent" + i1);
                                        Object object = (Object) method.invoke(this);
                                        Method method4 = object.getClass().getDeclaredMethod("getCatched");
                                        HashMap<Integer, ArrayList<Integer>> Q1 = (HashMap<Integer, ArrayList<Integer>>) method4.invoke(object);
                                        Q1.remove(Integer.parseInt(satr.item(0).getNodeValue()));
                                        Method method6x = object.getClass().getDeclaredMethod("setCatched", HashMap.class);
                                        method6x.invoke(object, Q1);
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    } catch (NoSuchMethodException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }*/
                        fw.print(a + "#" + b + "#" + "cow" + "#" + satr.item(0).getNodeValue() + "&");
                        fw.flush();
                    }
                } else {
                    if (state.item(1).getNodeName().equals("obstacle")) {
                        int a = this.posX + Integer.parseInt(Attrib.item(0).getNodeValue());
                        int b = (this.posY + Integer.parseInt(Attrib.item(1).getNodeValue()));
                        this.perc1.add(k++, a + "#" + b + "#" + "obstacle#" + "obstacle");
                        fw.print(a + "#" + b + "#" + "obstacle#" + "obstacle" + "&");
                        fw.flush();
                    } else {
                        if (state.item(1).getNodeName().equals("corral")) {
                            int a = this.posX + Integer.parseInt(Attrib.item(0).getNodeValue());
                            int b = (this.posY + Integer.parseInt(Attrib.item(1).getNodeValue()));
                            this.perc1.add(k++, a + "#" + b + "#" + "corral#" + "corral");
                            fw.print(a + "#" + b + "#" + "corral#" + "corral&");
                            fw.flush();
                        } else {
                            int a = this.posX + Integer.parseInt(Attrib.item(0).getNodeValue());
                            int b = (this.posY + Integer.parseInt(Attrib.item(1).getNodeValue()));
                            this.perc1.add(k++, a + "#" + b + "#" + "empty#" + "empty");
                            fw.print(a + "#" + b + "#" + "empty#" + "empty&");
                            fw.flush();
                        }
                    }
                }

            }
        }
        stepedcow.put(step, Step_SeenCows);
        System.out.println("Agent" + username + "  inja1");
        //////////////////////////////////////check kon baghhiyam in gavaee ka man nadidamo nadidan
        ArrayList<HashMap<Integer, ArrayList<Integer>>> C = Cluster(Step_SeenCows);
        this.sheep = this.Sheep(C);
        this.cent = this.centroid(this.sheep);
        int cnt = 0;
        int cnt2 = 0;
        boolean f = false;
        while (cnt < 9000000000000000000l) {
            if (cnt <= 1) {
                System.out.print("");
            }
            //log.println("my iu is :" + iu + "  i am waiting to get one");
            log.flush();
            while (cnt2 < 9000000000000000000l) {
                if (cnt2 <= 1) {
                    System.out.print("");
                }
                if (iu == 1) {
                    iu = 0;
                    f = true;
                    break;
                }
                cnt2++;
            }
            if (f == true)
                break;
            cnt++;
        }
        iu = 0;
        ///////////////
        //////////////
        //log.println("payame a12 daryaft shod: N_n:  " + N_n + "    ");
        log.flush();
        ////////////////////////////////////////
        cnt = 0;
        cnt2 = 0;
        int cnt3 = 0;
        f = false;
        if (wfac == 1) {
            while (cnt < 9000000000000000000l) {
                if (cnt <= 1) {
                    System.out.print("");
                }
                while (cnt2 <= 9000000000000000000l) {
                    if (cnt2 <= 1) {
                        System.out.print("");
                    }
                    while (cnt3 <= 9000000000000000000l) {
                        if (ns == 1) {
                            ns = 0;
                            f = true;
                            sheep = newsheep;
                            break;
                        }
                        cnt3++;
                    }
                    if (f == true)
                        break;
                    cnt2++;
                }
                if (f == true)
                    break;
                cnt++;
            }
        }
        ns = 0;
        wfac = 0;
        //log.println("sss:  " + sheep);
        log.flush();
        HashMap<Integer, ArrayList<Integer>> sheep_temp = new HashMap<Integer, ArrayList<Integer>>();
        if (header == 1) {
            //////////////////////////////////////////
            for (int key : sheep_prev.keySet()) {
                //////////////////
                if (Step_SeenCows.containsKey(key))
                    sheep_temp.put(key, Step_SeenCows.get(key));
                else {
                    for (int i = 1; i <= 10; i++) {
                        if (i != Integer.parseInt(username)) {
                            Method method = null;
                            try {
                                method = this.getClass().getMethod("getAgent" + i);
                                Object object = (Object) method.invoke(this);
                                Method method1 = object.getClass().getDeclaredMethod("getStepedcow");
                                HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> nc = (HashMap) method1.invoke(object);
                                if (nc.containsKey(step)) {
                                    if (nc.get(step).containsKey(key)) {
                                        sheep_temp.put(key, nc.get(step).get(key));
                                        break;
                                    }
                                } else {
                                    int ux = 0;
                                    while (ux <= 9000000000000000000l) {
                                        method1 = object.getClass().getDeclaredMethod("getStepedcow");
                                        nc = (HashMap) method1.invoke(object);
                                        if (nc.containsKey(step)) {
                                            break;
                                        }
                                        ux++;
                                    }
                                    if (nc.get(step).containsKey(key)) {
                                        sheep_temp.put(key, nc.get(step).get(key));
                                        break;
                                    }
                                }
                                //log.println("Agent" + i + " sheep prev " + nc.get(step));
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
                /////////////////
            }
            //////////////////////////////////////////
            if (sheep_temp.size() != 0) {

                sheep = cls(sheep,sheep_temp);
                //log.println("sheep jadid ba sheep prev set shod    " + sheep);
                log.flush();

            }
        }
        if (header == 1) {
            for (int i = 0; i < N_n.size(); i++) {
                Method methoda = null;
                try {
                    methoda = this.getClass().getMethod("getAgent" + N_n.get(i));
                    Object object = (Object) methoda.invoke(this);
                    Method method1 = object.getClass().getMethod("setSes", HashMap.class);
                    method1.invoke(object, sheep);
                    Method method2 = object.getClass().getMethod("setEs", int.class);
                    method2.invoke(object, 1);
                    ////////////
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                //////////////
            }
        }
        cnt = 0;
        cnt2 = 0;
        boolean ff = false;
        if (header == 0) {
            while (cnt <= 9000000000000000000l) {
                while (cnt2 <= 9000000000000000000l) {
                    if (getEs() == 1) {
                        setEs(0);
                        ff = true;
                        sheep = getSes();
                        break;
                    }
                    cnt2++;
                }
                if (ff = true)
                    break;
                cnt++;
            }
        }
        es = 0;
        //////////////////////////
        /*if(getGaurd()==1 && gaurder.size()!=0){
            //////////////////
            sheep=gaurder;
            //log.println("sheep jadid set shod ba sheep farari  " + sheep);log.flush();
        }*/
        //log.println("sheep jadid set shod    " + sheep);log.flush();
        this.cent = this.centroid(this.sheep);//new cent or previous cent
        //log.println("cent: " + cent);
        log.flush();
        if (cent.size() == 0) {
            corral_min_x = corral.get(0).get(0);
            corral_min_y = corral.get(0).get(1);
        }
        else {
            if ((cent.get(0) >= 0 && cent.get(0) <= 25 && cent.get(1) >= 20 && cent.get(1) <= 99) || (cent.get(0) >= 25 && cent.get(0) <= 49 && cent.get(1) >= 49 && cent.get(1) <= 99)) {
                corral_min_x = corral.get(1).get(0);
                corral_min_y = corral.get(1).get(1);
            } else {
                if ((cent.get(0) >= 0 && cent.get(0) <= 25 && cent.get(1) >= 0 && cent.get(1) <20)||(cent.get(0) >= 25 && cent.get(0) <= 99 && cent.get(1) >= 0 && cent.get(1) <=25)) {
                    corral_min_x = corral.get(2).get(0);
                    corral_min_y = corral.get(2).get(1);
                } else {
                    corral_min_x = corral.get(0).get(0);
                    corral_min_y = corral.get(0).get(1);
                }
            }
        }
        //log.println("new sheep is:  " + sheep + "    " + "  new cent is :" + cent +"corral is "+corral_min_x+"   "+corral_min_y);log.flush();//log.println("header: "+header);log.flush();
        if(header==1 && N_n.size()==0){
            if(cent.size()>0) {
                double d1 = findAngle(corral_min_x, corral_min_y, cent.get(0), cent.get(1), posX, posY);
                if (Double.isNaN(d1)) {
                    setGoAfterAlone(0);
                    setHerdAlone(0);setHerdGroup(0);setGoAfterGroup(0);
                    setNoMode(1);setRandAlone(0);setRandGroup(0);
                } else {
                    if (cent.get(0) < 48) {
                        if (findAngle(corral_min_x, corral_min_y, cent.get(0), cent.get(1), posX, posY) > 130) {
                            setHerdAlone(0);
                            setHerdGroup(0);
                            setNoMode(0);
                            setGoAfterAlone(0);
                            setGoAfterGroup(0);
                            setRandAlone(1);
                            setRandGroup(0);
                        }
                        if (findAngle(corral_min_x, corral_min_y, cent.get(0), cent.get(1), posX, posY) <= 130) {
                            setGoAfterAlone(1);
                            setHerdAlone(0);
                            setHerdGroup(0);
                            setNoMode(0);
                            setGoAfterGroup(0);
                            setRandAlone(0);
                            setRandGroup(0);
                        }
                    } else {
                        if (findAngle(corral_min_x, corral_min_y, cent.get(0), cent.get(1), posX, posY) > 130) {
                            setHerdAlone(1);
                            setHerdGroup(0);
                            setNoMode(0);
                            setGoAfterAlone(0);
                            setGoAfterGroup(0);
                            setRandAlone(0);
                            setRandGroup(0);
                        }
                        if (findAngle(corral_min_x, corral_min_y, cent.get(0), cent.get(1), posX, posY) <= 130) {
                            setGoAfterAlone(1);
                            setHerdAlone(0);
                            setHerdGroup(0);
                            setNoMode(0);
                            setGoAfterGroup(0);
                            setRandAlone(0);
                            setRandGroup(0);
                        }
                    }
                }
            }
            else {
                setGoAfterAlone(0);
                setHerdAlone(0);setHerdGroup(0);setGoAfterGroup(0);
                setNoMode(1);setRandAlone(0);setRandGroup(0);
            }
        }
        ///mode detection
        else {
            if (header == 1 && N_n.size() > 0) {
                ModeDetection();
            }

        }
        if(header==0){
            cnt=0;int cx=0;boolean x=false;
            while(cnt<=9000000000000000000l){
                if(cnt<=1)
                    System.out.print("");
                while(cx<=9000000000000000000l){
                    if(cx<=1)
                        System.out.print("");
                    if(getHerdAlone()==1 || getHerdGroup()==1 || getGoAfterAlone()==1 || getGoAfterGroup()==1 || getNoMode()==1 || getRandAlone()==1 || getRandGroup()==1){
                        x=true;
                        break;
                    }
                    cx++;
                }
                if(x==true)
                    break;
                cnt++;
            }
        }
        //log.println("modes are :  herdalone: " + getHerdAlone() + "    herdgroup:  " + getHerdGroup() + "    goafteralone: " + getGoAfterAlone() + "   goaftergruop:  " + getGoAfterGroup() + "  NOMODE:  " + getNoMode()+"  RandAlone:  "+getRandAlone()+"   RandGroup: "+getRandGroup());
        log.flush();
        fw.println();fw.flush();
        //log.println("h1 :"+getH1());log.flush();
        //log.println("h3 :"+getH3());log.flush();
        //log.println("h5 :"+getH5());log.flush();
        //log.println("h6 :"+getH6());log.flush();
        //log.println("h7 :"+getH7());log.flush();
        //log.println("h8 :"+getH8());log.flush();
        ///////////
        if (step <= ui1) {
            decider = 0;
            /////////////////////////////////////////////////
            String s = "";
            QQ=new HashMap<String, String>();
            ////log.println("omadam inja3");log.flush();
            if (header == 1) {
                ////log.println("omadam inja4");log.flush();
                if (getHerdGroup() == 1) {
                    ////log.println("omadam inja5");log.flush();
                    s = State();
                    QQ = this.QlHerdGroupCentral(s);
                    ////log.println("omadam inja6  "+QQ);log.flush();
                } else {
                    if (getRandGroup()==1) {
                        s = State();
                        QQ = this.QlRandGroup(s);
                    } else {
                        if (getGoAfterGroup()==1) {
                            s = State();
                            QQ = this.QlGoAfterGroup(s);
                        } else {
                            if (cent.size() > 0) {
                                ////log.println("omadam inja7");log.flush();
                                double min = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                                double d = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
                                double a = findAngle(corral_x, corral_y, posX, posY, cent.get(0), cent.get(1));
                                int w1 = this.p1(min);
                                int w2 = this.p1(d);
                                int w3 = this.p1(a);
                                s = w1 + "," + w2 + "," + w3;
                                if (getHerdAlone() == 1) {
                                    ////log.println("omadam inja11 "+s+"   "+Q1HerdAlone);log.flush();
                                    QQ = this.QlHerdAlone(s);
                                    ////log.println("omadam inja12 "+QQ);log.flush();
                                }
                                if (getRandAlone() == 1) {
                                    QQ = this.QlRandAlone(s);
                                }
                                if (getGoAfterAlone() == 1) {
                                    QQ = this.QlGoAfterAlone(s);
                                }
                            }
                        }
                    }
                }
                //log.println("states are "+s);log.flush();
            }
            //log.println("QQ is :" + QQ);log.flush();
            /////////////////
            if (N_n.size() > 0 && header == 1) {
                /////////////////
                if(cent.size()>0 && getHerdGroup()==1 || getRandGroup()==1) {
                    ArrayList<Double> R = R();
                    //state definition
                    goalstate = CheckPlace(R);
                    //log.println("goal state :  " + goalstate + "    ");log.flush();
                }
                NewAction();///////////////////////////
                //RequestAction();
                /////////////////
                ////log.println("omadam inja6");log.flush();
            } else {
                ////log.println("omadam inja7");log.flush();
                if (header == 1) {
                    ///////////////////////
                    if(getRandAlone()==1){
                        String act=ToCentroid(cent);
                        boolean gs=Gs(act);
                        if(gs==true && (T==true || H == true) )
                            action=ToCentroid(cent);
                        else
                            action=random(decider);
                        //log.println("rand alone action  is: " + action);
                    }
                    if (getGoAfterAlone() == 1) {
                        if((T==true || H == true)) {
                            action = Circle(cent);

                        } else {
                            action=random(decider);
                        }
                        //log.println("circle action in  goafter alone is: " + action);

                    }
                    if (getHerdAlone() == 1) {
                        String act=ToCentroid(cent);
                        boolean gs=Gs(act);
                        if(gs==true && (T==true || H == true))
                            action=ToCentroid(cent);
                        else
                            action=random(decider);
                        //log.println("decider action in herd alone is: " + action);

                    }
                    if(getNoMode()==1){
                        action=randomAction(cent);
                        //log.println("random action is: " + action);

                    }
                }
            }
            cnt = 0;int cnt1=0;boolean ds=false;
            while (cnt < 9000000000000000000l) {
                if (cnt <= 4)
                    System.out.print("");
                while(cnt1<=9000000000000000000l) {
                    if (cnt1 <= 4)
                        System.out.print("");
                    if (!action.equals("")) {
                        ds=true;
                        break;
                    }
                    cnt1++;
                }
                if(ds==true)
                    break;
                cnt++;
            }
            //////////////////////
            boolean bie=false;
            //if(getGoAfterAlone()==1 || getGoAfterGroup()==1 || getNoMode()==1){
            if(posX>=25 && posX<=48 && posY>=25 && posY<=48){
                if(posY>=25 && posY<=27){
                    action="south";
                }
                if(posY>=46 && posY<=48){
                    action="north";
                }
                if(posY>27 && posY<46) {
                    action = "east";
                }
                //log.println("I am getting out");log.flush();
                bie=true;
            }
            if(posX>=50 && posX<=73 && posY>=50 && posY<=73){
                if(posY>=50 && posY<=52){
                    action="south";
                }
                if(posY>=71 && posY<=73){
                    action="north";
                }
                if(posY>52 && posY<71)
                    action="west";
                //log.println("I am getting out");log.flush();
                bie=true;
            }
            //}
            if (old_ga == 1 || old_gg == 1 || old_ha==1 || old_hg==1 || old_nm==1 || old_ra==1 || old_rg==1) {
                if(bie==false) {
                    if (Prev_Pos.size() >= 2 && Prev_Pos.get(step).get(0) == Prev_Pos.get(step - 1).get(0) && Prev_Pos.get(step).get(1) == Prev_Pos.get(step - 1).get(1) && !pre_action.equals("skip")) {
                        Random r1 = new Random();
                        // action generating by random number
                        int d = r1.nextInt(9);
                        //log.println("d: " + d);
                        log.flush();
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
                            case 8:
                                action = "skip";
                                break;
                        }
                        //log.println("new action detectede");
                        log.flush();

                    }
                }
            }
            UnRew();
            if (header == 1 && NoMode!=1) {
                if (getHerdGroup() == 1) {
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if (getHerdAlone() == 1) {
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getRandAlone()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getRandGroup()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getGoAfterAlone()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getGoAfterGroup()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                old_s=s;
                last_cent.put(s,cent);
                las_neighbor.put(s,N_n);
                old_ha=getHerdAlone();
                old_hg=getHerdGroup();
                old_ga=getGoAfterAlone();
                old_gg=getGoAfterGroup();
                old_nm=getNoMode();
                old_ra=getRandAlone();
                old_rg=getRandGroup();
                sheep_prev=sheep;
            }
            /*if(getGaurd()==1 && gaurder.size()==0){
                action=Gd();
            }*/
            pre_action=action;
            target.setAttribute("type", action);
            System.out.println("Agent"+username+"  action:  "+action+"  in step:"+step);
        }
        if (step >ui1 && step<=ui2) {
            ////log.println("omadam inja2");log.flush();
            decider = 1;
            /////////////////////////////////////////////////
            String s = "";
            QQ=new HashMap<String, String>();
            ////log.println("omadam inja3");log.flush();
            if (header == 1) {
                ////log.println("omadam inja4");log.flush();
                if (getHerdGroup() == 1) {
                    ////log.println("omadam inja5");log.flush();
                    s = State();
                    QQ = this.QlHerdGroupCentral(s);
                    ////log.println("omadam inja6  "+QQ);log.flush();
                } else {
                    if (getRandGroup()==1) {
                        s = State();
                        QQ = this.QlRandGroup(s);
                    } else {
                        if (getGoAfterGroup()==1) {
                            s = State();
                            QQ = this.QlGoAfterGroup(s);
                        } else {
                            if (cent.size() > 0) {
                                ////log.println("omadam inja7");log.flush();
                                double min = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                                double d = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
                                double a = findAngle(corral_x, corral_y, posX, posY, cent.get(0), cent.get(1));
                                int w1 = this.p1(min);
                                int w2 = this.p1(d);
                                int w3 = this.p1(a);
                                s = w1 + "," + w2 + "," + w3;
                                if (getHerdAlone() == 1) {
                                    ////log.println("omadam inja11 "+s+"   "+Q1HerdAlone);log.flush();
                                    QQ = this.QlHerdAlone(s);
                                    ////log.println("omadam inja12 "+QQ);log.flush();
                                }
                                if (getRandAlone() == 1) {
                                    QQ = this.QlRandAlone(s);
                                }
                                if (getGoAfterAlone() == 1) {
                                    QQ = this.QlGoAfterAlone(s);
                                }
                            }
                        }
                    }
                }
                //log.println("states are "+s);log.flush();
            }
            //log.println("QQ is :" + QQ);log.flush();
            /////////////////
            if (N_n.size() > 0 && header == 1) {
                /////////////////
                if(cent.size()>0 && getHerdGroup()==1 || getRandGroup()==1) {
                    ArrayList<Double> R = R();
                    //state definition
                    goalstate = CheckPlace(R);
                    //log.println("goal state :  " + goalstate + "    ");log.flush();
                }
                NewAction();///////////////////////////
                //RequestAction();
                /////////////////
                ////log.println("omadam inja6");log.flush();
            } else {
                ////log.println("omadam inja7");log.flush();
                if (header == 1) {
                    ///////////////////////
                    if(getRandAlone()==1){
                        String act=ToCentroid(cent);
                        boolean gs=Gs(act);
                        if(gs==true && (T==true || H == true) )
                            action=ToCentroid(cent);
                        else
                            action=random(decider);
                        //log.println("rand alone action  is: " + action);
                    }
                    if (getGoAfterAlone() == 1) {
                        if((T==true || H == true)) {
                            action = Circle(cent);

                        } else {
                            action=random(decider);
                        }
                        //log.println("circle action in  goafter alone is: " + action);

                    }
                    if (getHerdAlone() == 1) {
                        String act=ToCentroid(cent);
                        boolean gs=Gs(act);
                        if(gs==true && (T==true || H == true))
                            action=ToCentroid(cent);
                        else
                            action=random(decider);
                        //log.println("decider action in herd alone is: " + action);

                    }
                    if(getNoMode()==1){
                        action=randomAction(cent);
                        //log.println("random action is: " + action);

                    }
                }
            }
            cnt = 0;int cnt1=0;boolean ds=false;
            while (cnt < 9000000000000000000l) {
                if (cnt <= 4)
                    System.out.print("");
                while(cnt1<=9000000000000000000l) {
                    if (cnt1 <= 4)
                        System.out.print("");
                    if (!action.equals("")) {
                        ds=true;
                        break;
                    }
                    cnt1++;
                }
                if(ds==true)
                    break;
                cnt++;
            }
            //////////////////////
            boolean bie=false;
            //if(getGoAfterAlone()==1 || getGoAfterGroup()==1 || getNoMode()==1){
            if(posX>=25 && posX<=48 && posY>=25 && posY<=48){
                if(posY>=25 && posY<=27){
                    action="south";
                }
                if(posY>=46 && posY<=48){
                    action="north";
                }
                if(posY>27 && posY<46) {
                    action = "east";
                }
                //log.println("I am getting out");log.flush();
                bie=true;
            }
            if(posX>=50 && posX<=73 && posY>=50 && posY<=73){
                if(posY>=50 && posY<=52){
                    action="south";
                }
                if(posY>=71 && posY<=73){
                    action="north";
                }
                if(posY>52 && posY<71)
                    action="west";
                //log.println("I am getting out");log.flush();
                bie=true;
            }
            //}
            if (old_ga == 1 || old_gg == 1 || old_ha==1 || old_hg==1 || old_nm==1 || old_ra==1 || old_rg==1) {
                if(bie==false) {
                    if (Prev_Pos.size() >= 2 && Prev_Pos.get(step).get(0) == Prev_Pos.get(step - 1).get(0) && Prev_Pos.get(step).get(1) == Prev_Pos.get(step - 1).get(1) && !pre_action.equals("skip")) {
                        Random r1 = new Random();
                        // action generating by random number
                        int d = r1.nextInt(9);
                        //log.println("d: " + d);
                        log.flush();
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
                            case 8:
                                action = "skip";
                                break;
                        }
                        //log.println("new action detectede");
                        log.flush();

                    }
                }
            }
            UnRew();
            if (header == 1 && NoMode!=1) {
                if (getHerdGroup() == 1) {
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if (getHerdAlone() == 1) {
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getRandAlone()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getRandGroup()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getGoAfterAlone()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getGoAfterGroup()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                old_s=s;
                last_cent.put(s,cent);
                las_neighbor.put(s,N_n);
                old_ha=getHerdAlone();
                old_hg=getHerdGroup();
                old_ga=getGoAfterAlone();
                old_gg=getGoAfterGroup();
                old_nm=getNoMode();
                old_ra=getRandAlone();
                old_rg=getRandGroup();
                sheep_prev=sheep;
            }
            /*if(getGaurd()==1 && gaurder.size()==0){
                action=Gd();
            }*/
            pre_action=action;
            target.setAttribute("type", action);
            System.out.println("Agent"+username+"  action:  "+action+"  in step:"+step);
        }
        if (step > ui2 && step<=ui3) {
            /////log.println("omadam inja2");log.flush();
            decider = 2;
            /////////////////////////////////////////////////
            String s = "";
            QQ=new HashMap<String, String>();
            ////log.println("omadam inja3");log.flush();
            if (header == 1) {
                ////log.println("omadam inja4");log.flush();
                if (getHerdGroup() == 1) {
                    ////log.println("omadam inja5");log.flush();
                    s = State();
                    QQ = this.QlHerdGroupCentral(s);
                    ////log.println("omadam inja6  "+QQ);log.flush();
                } else {
                    if (getRandGroup()==1) {
                        s = State();
                        QQ = this.QlRandGroup(s);
                    } else {
                        if (getGoAfterGroup()==1) {
                            s = State();
                            QQ = this.QlGoAfterGroup(s);
                        } else {
                            if (cent.size() > 0) {
                                ////log.println("omadam inja7");log.flush();
                                double min = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                                double d = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
                                double a = findAngle(corral_x, corral_y, posX, posY, cent.get(0), cent.get(1));
                                int w1 = this.p1(min);
                                int w2 = this.p1(d);
                                int w3 = this.p1(a);
                                s = w1 + "," + w2 + "," + w3;
                                if (getHerdAlone() == 1) {
                                    ////log.println("omadam inja11 "+s+"   "+Q1HerdAlone);log.flush();
                                    QQ = this.QlHerdAlone(s);
                                    ////log.println("omadam inja12 "+QQ);log.flush();
                                }
                                if (getRandAlone() == 1) {
                                    QQ = this.QlRandAlone(s);
                                }
                                if (getGoAfterAlone() == 1) {
                                    QQ = this.QlGoAfterAlone(s);
                                }
                            }
                        }
                    }
                }
                //log.println("states are "+s);log.flush();
            }
            //log.println("QQ is :" + QQ);log.flush();
            /////////////////
            if (N_n.size() > 0 && header == 1) {
                /////////////////
                if(cent.size()>0 && getHerdGroup()==1 || getRandGroup()==1) {
                    ArrayList<Double> R = R();
                    //state definition
                    goalstate = CheckPlace(R);
                    //log.println("goal state :  " + goalstate + "    ");log.flush();
                }
                NewAction();///////////////////////////
                //RequestAction();
                /////////////////
                ////log.println("omadam inja6");log.flush();
            } else {
                ////log.println("omadam inja7");log.flush();
                if (header == 1) {
                    ///////////////////////
                    if(getRandAlone()==1){
                        String act=ToCentroid(cent);
                        boolean gs=Gs(act);
                        if(gs==true && (T==true || H == true) )
                            action=ToCentroid(cent);
                        else
                            action=random(decider);
                        //log.println("rand alone action  is: " + action);
                    }
                    if (getGoAfterAlone() == 1) {
                        if((T==true || H == true)) {
                            action = Circle(cent);

                        } else {
                            action=random(decider);
                        }
                        //log.println("circle action in  goafter alone is: " + action);

                    }
                    if (getHerdAlone() == 1) {
                        String act=ToCentroid(cent);
                        boolean gs=Gs(act);
                        if(gs==true && (T==true || H == true))
                            action=ToCentroid(cent);
                        else
                            action=random(decider);
                        //log.println("decider action in herd alone is: " + action);

                    }
                    if(getNoMode()==1){
                        action=randomAction(cent);
                        //log.println("random action is: " + action);

                    }
                }
            }
            cnt = 0;int cnt1=0;boolean ds=false;
            while (cnt < 9000000000000000000l) {
                if (cnt <= 4)
                    System.out.print("");
                while(cnt1<=9000000000000000000l) {
                    if (cnt1 <= 4)
                        System.out.print("");
                    if (!action.equals("")) {
                        ds=true;
                        break;
                    }
                    cnt1++;
                }
                if(ds==true)
                    break;
                cnt++;
            }
            //////////////////////
            boolean bie=false;
            //if(getGoAfterAlone()==1 || getGoAfterGroup()==1 || getNoMode()==1){
            if(posX>=25 && posX<=48 && posY>=25 && posY<=48){
                if(posY>=25 && posY<=27){
                    action="south";
                }
                if(posY>=46 && posY<=48){
                    action="north";
                }
                if(posY>27 && posY<46) {
                    action = "east";
                }
                //log.println("I am getting out");log.flush();
                bie=true;
            }
            if(posX>=50 && posX<=73 && posY>=50 && posY<=73){
                if(posY>=50 && posY<=52){
                    action="south";
                }
                if(posY>=71 && posY<=73){
                    action="north";
                }
                if(posY>52 && posY<71)
                    action="west";
                //log.println("I am getting out");log.flush();
                bie=true;
            }
            //}
            if (old_ga == 1 || old_gg == 1 || old_ha==1 || old_hg==1 || old_nm==1 || old_ra==1 || old_rg==1) {
                if(bie==false) {
                    if (Prev_Pos.size() >= 2 && Prev_Pos.get(step).get(0) == Prev_Pos.get(step - 1).get(0) && Prev_Pos.get(step).get(1) == Prev_Pos.get(step - 1).get(1) && !pre_action.equals("skip")) {
                        Random r1 = new Random();
                        // action generating by random number
                        int d = r1.nextInt(9);
                        //log.println("d: " + d);
                        log.flush();
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
                            case 8:
                                action = "skip";
                                break;
                        }
                        //log.println("new action detectede");
                        log.flush();

                    }
                }
            }
            UnRew();
            if (header == 1 && NoMode!=1) {
                if (getHerdGroup() == 1) {
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if (getHerdAlone() == 1) {
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getRandAlone()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getRandGroup()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getGoAfterAlone()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getGoAfterGroup()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                old_s=s;
                last_cent.put(s,cent);
                las_neighbor.put(s,N_n);
                old_ha=getHerdAlone();
                old_hg=getHerdGroup();
                old_ga=getGoAfterAlone();
                old_gg=getGoAfterGroup();
                old_nm=getNoMode();
                old_ra=getRandAlone();
                old_rg=getRandGroup();
                sheep_prev=sheep;
            }
            /*if(getGaurd()==1 && gaurder.size()==0){
                action=Gd();
            }*/
            pre_action=action;
            target.setAttribute("type", action);
            System.out.println("Agent"+username+"  action:  "+action+"  in step:"+step);
        }
        if (step > ui3 && step<=ui4) {
            ////log.println("omadam inja2");log.flush();
            decider = 3;
            /////////////////////////////////////////////////
            String s = "";
            QQ=new HashMap<String, String>();
            ////log.println("omadam inja3");log.flush();
            if (header == 1) {
                ////log.println("omadam inja4");log.flush();
                if (getHerdGroup() == 1) {
                    ////log.println("omadam inja5");log.flush();
                    s = State();
                    QQ = this.QlHerdGroupCentral(s);
                    ////log.println("omadam inja6  "+QQ);log.flush();
                } else {
                    if (getRandGroup()==1) {
                        s = State();
                        QQ = this.QlRandGroup(s);
                    } else {
                        if (getGoAfterGroup()==1) {
                            s = State();
                            QQ = this.QlGoAfterGroup(s);
                        } else {
                            if (cent.size() > 0) {
                                ////log.println("omadam inja7");log.flush();
                                double min = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                                double d = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
                                double a = findAngle(corral_x, corral_y, posX, posY, cent.get(0), cent.get(1));
                                int w1 = this.p1(min);
                                int w2 = this.p1(d);
                                int w3 = this.p1(a);
                                s = w1 + "," + w2 + "," + w3;
                                if (getHerdAlone() == 1) {
                                    ////log.println("omadam inja11 "+s+"   "+Q1HerdAlone);log.flush();
                                    QQ = this.QlHerdAlone(s);
                                    ////log.println("omadam inja12 "+QQ);log.flush();
                                }
                                if (getRandAlone() == 1) {
                                    QQ = this.QlRandAlone(s);
                                }
                                if (getGoAfterAlone() == 1) {
                                    QQ = this.QlGoAfterAlone(s);
                                }
                            }
                        }
                    }
                }
                //log.println("states are "+s);log.flush();
            }
            //log.println("QQ is :" + QQ);log.flush();
            /////////////////
            if (N_n.size() > 0 && header == 1) {
                /////////////////
                if(cent.size()>0 && getHerdGroup()==1 || getRandGroup()==1) {
                    ArrayList<Double> R = R();
                    //state definition
                    goalstate = CheckPlace(R);
                    //log.println("goal state :  " + goalstate + "    ");log.flush();
                }
                NewAction();///////////////////////////
                //RequestAction();
                /////////////////
                ////log.println("omadam inja6");log.flush();
            } else {
                ////log.println("omadam inja7");log.flush();
                if (header == 1) {
                    ///////////////////////
                    if(getRandAlone()==1){
                        String act=ToCentroid(cent);
                        boolean gs=Gs(act);
                        if(gs==true && (T==true || H == true) )
                            action=ToCentroid(cent);
                        else
                            action=random(decider);
                        //log.println("rand alone action  is: " + action);
                    }
                    if (getGoAfterAlone() == 1) {
                        if((T==true || H == true)) {
                            action = Circle(cent);

                        } else {
                            action=random(decider);
                        }
                        //log.println("circle action in  goafter alone is: " + action);

                    }
                    if (getHerdAlone() == 1) {
                        String act=ToCentroid(cent);
                        boolean gs=Gs(act);
                        if(gs==true && (T==true || H == true))
                            action=ToCentroid(cent);
                        else
                            action=random(decider);
                        //log.println("decider action in herd alone is: " + action);

                    }
                    if(getNoMode()==1){
                        action=randomAction(cent);
                        //log.println("random action is: " + action);

                    }
                }
            }
            cnt = 0;int cnt1=0;boolean ds=false;
            while (cnt < 9000000000000000000l) {
                if (cnt <= 4)
                    System.out.print("");
                while(cnt1<=9000000000000000000l) {
                    if (cnt1 <= 4)
                        System.out.print("");
                    if (!action.equals("")) {
                        ds=true;
                        break;
                    }
                    cnt1++;
                }
                if(ds==true)
                    break;
                cnt++;
            }
            //////////////////////
            boolean bie=false;
            //if(getGoAfterAlone()==1 || getGoAfterGroup()==1 || getNoMode()==1){
            if(posX>=25 && posX<=48 && posY>=25 && posY<=48){
                if(posY>=25 && posY<=27){
                    action="south";
                }
                if(posY>=46 && posY<=48){
                    action="north";
                }
                if(posY>27 && posY<46) {
                    action = "east";
                }
                //log.println("I am getting out");log.flush();
                bie=true;
            }
            if(posX>=50 && posX<=73 && posY>=50 && posY<=73){
                if(posY>=50 && posY<=52){
                    action="south";
                }
                if(posY>=71 && posY<=73){
                    action="north";
                }
                if(posY>52 && posY<71)
                    action="west";
                //log.println("I am getting out");log.flush();
                bie=true;
            }
            //}
            if (old_ga == 1 || old_gg == 1 || old_ha==1 || old_hg==1 || old_nm==1 || old_ra==1 || old_rg==1) {
                if(bie==false) {
                    if (Prev_Pos.size() >= 2 && Prev_Pos.get(step).get(0) == Prev_Pos.get(step - 1).get(0) && Prev_Pos.get(step).get(1) == Prev_Pos.get(step - 1).get(1) && !pre_action.equals("skip")) {
                        Random r1 = new Random();
                        // action generating by random number
                        int d = r1.nextInt(9);
                        //log.println("d: " + d);
                        log.flush();
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
                            case 8:
                                action = "skip";
                                break;
                        }
                        //log.println("new action detectede");
                        log.flush();

                    }
                }
            }
            UnRew();
            if (header == 1 && NoMode!=1) {
                if (getHerdGroup() == 1) {
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if (getHerdAlone() == 1) {
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getRandAlone()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getRandGroup()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getGoAfterAlone()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getGoAfterGroup()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                old_s=s;
                last_cent.put(s,cent);
                las_neighbor.put(s,N_n);
                old_ha=getHerdAlone();
                old_hg=getHerdGroup();
                old_ga=getGoAfterAlone();
                old_gg=getGoAfterGroup();
                old_nm=getNoMode();
                old_ra=getRandAlone();
                old_rg=getRandGroup();
                sheep_prev=sheep;
            }
            /*if(getGaurd()==1 && gaurder.size()==0){
                action=Gd();
            }*/
            pre_action=action;
            target.setAttribute("type", action);
            System.out.println("Agent"+username+"  action:  "+action+"  in step:"+step);
        }
        if (step>ui4) {
            ////log.println("omadam inja2");log.flush();
            decider = 3;
            /////////////////////////////////////////////////
            String s = "";
            QQ=new HashMap<String, String>();
            ////log.println("omadam inja3");log.flush();
            if (header == 1) {
                ////log.println("omadam inja4");log.flush();
                if (getHerdGroup() == 1) {
                    ////log.println("omadam inja5");log.flush();
                    s = State();
                    QQ = this.QlHerdGroupCentral(s);
                    ////log.println("omadam inja6  "+QQ);log.flush();
                } else {
                    if (getRandGroup()==1) {
                        s = State();
                        QQ = this.QlRandGroup(s);
                    } else {
                        if (getGoAfterGroup()==1) {
                            s = State();
                            QQ = this.QlGoAfterGroup(s);
                        } else {
                            if (cent.size() > 0) {
                                ////log.println("omadam inja7");log.flush();
                                double min = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                                double d = Math.sqrt((corral_x - posX) * (corral_x - posX) + (corral_y - posY) * (corral_y - posY));
                                double a = findAngle(corral_x, corral_y, posX, posY, cent.get(0), cent.get(1));
                                int w1 = this.p1(min);
                                int w2 = this.p1(d);
                                int w3 = this.p1(a);
                                s = w1 + "," + w2 + "," + w3;
                                if (getHerdAlone() == 1) {
                                    ////log.println("omadam inja11 "+s+"   "+Q1HerdAlone);log.flush();
                                    QQ = this.QlHerdAlone(s);
                                    ////log.println("omadam inja12 "+QQ);log.flush();
                                }
                                if (getRandAlone() == 1) {
                                    QQ = this.QlRandAlone(s);
                                }
                                if (getGoAfterAlone() == 1) {
                                    QQ = this.QlGoAfterAlone(s);
                                }
                            }
                        }
                    }
                }
                //log.println("states are "+s);log.flush();
            }
            //log.println("QQ is :" + QQ);log.flush();
            /////////////////
            if (N_n.size() > 0 && header == 1) {
                /////////////////
                if(cent.size()>0 && getHerdGroup()==1 || getRandGroup()==1) {
                    ArrayList<Double> R = R();
                    //state definition
                    goalstate = CheckPlace(R);
                    //log.println("goal state :  " + goalstate + "    ");log.flush();
                }
                NewAction();///////////////////////////
                //RequestAction();
                /////////////////
                ////log.println("omadam inja6");log.flush();
            } else {
                ////log.println("omadam inja7");log.flush();
                if (header == 1) {
                    ///////////////////////
                    if(getRandAlone()==1){
                        String act=ToCentroid(cent);
                        boolean gs=Gs(act);
                        if(gs==true && (T==true || H == true) )
                            action=ToCentroid(cent);
                        else
                            action=random(decider);
                        //log.println("rand alone action  is: " + action);
                    }
                    if (getGoAfterAlone() == 1) {
                        if((T==true || H == true)) {
                            action = Circle(cent);

                        } else {
                            action=random(decider);
                        }
                        //log.println("circle action in  goafter alone is: " + action);

                    }
                    if (getHerdAlone() == 1) {
                        String act=ToCentroid(cent);
                        boolean gs=Gs(act);
                        if(gs==true && (T==true || H == true))
                            action=ToCentroid(cent);
                        else
                            action=random(decider);
                        //log.println("decider action in herd alone is: " + action);

                    }
                    if(getNoMode()==1){
                        action=randomAction(cent);
                        //log.println("random action is: " + action);

                    }
                }
            }
            cnt = 0;int cnt1=0;boolean ds=false;
            while (cnt < 9000000000000000000l) {
                if (cnt <= 4)
                    System.out.print("");
                while(cnt1<=9000000000000000000l) {
                    if (cnt1 <= 4)
                        System.out.print("");
                    if (!action.equals("")) {
                        ds=true;
                        break;
                    }
                    cnt1++;
                }
                if(ds==true)
                    break;
                cnt++;
            }
            //////////////////////
            boolean bie=false;
            //if(getGoAfterAlone()==1 || getGoAfterGroup()==1 || getNoMode()==1){
            if(posX>=25 && posX<=48 && posY>=25 && posY<=48){
                if(posY>=25 && posY<=27){
                    action="south";
                }
                if(posY>=46 && posY<=48){
                    action="north";
                }
                if(posY>27 && posY<46) {
                    action = "east";
                }
                //log.println("I am getting out");log.flush();
                bie=true;
            }
            if(posX>=50 && posX<=73 && posY>=50 && posY<=73){
                if(posY>=50 && posY<=52){
                    action="south";
                }
                if(posY>=71 && posY<=73){
                    action="north";
                }
                if(posY>52 && posY<71)
                    action="west";
                //log.println("I am getting out");log.flush();
                bie=true;
            }
            //}
            if (old_ga == 1 || old_gg == 1 || old_ha==1 || old_hg==1 || old_nm==1 || old_ra==1 || old_rg==1) {
                if(bie==false) {
                    if (Prev_Pos.size() >= 2 && Prev_Pos.get(step).get(0) == Prev_Pos.get(step - 1).get(0) && Prev_Pos.get(step).get(1) == Prev_Pos.get(step - 1).get(1) && !pre_action.equals("skip")) {
                        Random r1 = new Random();
                        // action generating by random number
                        int d = r1.nextInt(9);
                        //log.println("d: " + d);
                        log.flush();
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
                            case 8:
                                action = "skip";
                                break;
                        }
                        //log.println("new action detectede");
                        log.flush();

                    }
                }
            }
            UnRew();
            if (header == 1 && NoMode!=1) {
                if (getHerdGroup() == 1) {
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if (getHerdAlone() == 1) {
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getRandAlone()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getRandGroup()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getGoAfterAlone()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                if(getGoAfterGroup()==1){
                    //log.println("state " + s + " dar unrewarded gharar gereft ta dar dore bad reward dade she");
                    log.flush();
                    UnRewarded.put(s, sheep);
                }
                old_s=s;
                last_cent.put(s,cent);
                las_neighbor.put(s,N_n);
                old_ha=getHerdAlone();
                old_hg=getHerdGroup();
                old_ga=getGoAfterAlone();
                old_gg=getGoAfterGroup();
                old_nm=getNoMode();
                old_ra=getRandAlone();
                old_rg=getRandGroup();
                sheep_prev=sheep;
            }
            /*if(getGaurd()==1 && gaurder.size()==0){
                action=Gd();
            }*/
            pre_action=action;
            target.setAttribute("type", action);
            System.out.println("Agent"+username+"  action:  "+action+"  in step:"+step);
        }

        System.out.println("Agent" + username + "  catched are: " + getCatched());
        ///////////////
        //System.out.println("Agent"+username+"  action: "+action+"  modes herdalone: "+getHerdAlone()+"  herdgroup: "+getHerdGroup()+"  goafter: "+getGoAfterAlone()+"  Nomode:  "+getNoMode()+"   tables HA: "+getQ1HerdAlone()+"   GA: "+getQ1GoAfterAlone() + " in "+step+": "+step);
        //System.out.println("Agent" + username + "  action: " + action +"  posx: "+posX+"  posy:"+posY+ "  in " + step + ": " + step);
        //log.println("Agent" + username + "  action: " + action  + " in " + step + ": " + step);log.flush();log.flush();
        //log.println("Agent" + username + "  catched are: " + catched  + " in " + step + ": " + step);log.flush();log.flush();

        //////////////
        //log.println("/////////////////////////////////////////////////////////////////////////////////////////////");
        log.flush();
        ////////////////////////////////////////

    }
    public String randomAction(ArrayList<Double> cent) {
        String action = "";
        if((getGoAfterAlone()==1|| getGoAfterGroup()==1) && (this.T ==true &&this.step>ui2)){
            String a1=ToCentroid(cent);
            ArrayList<String> actions=new ArrayList<String>();
            ArrayList<String> suit=new ArrayList<String>();
            actions.add(0,"east");
            actions.add(1,"northeast");
            actions.add(2,"north");
            actions.add(3,"northwest");
            actions.add(4,"west");
            actions.add(5,"southwest");
            actions.add(6,"south");
            actions.add(7,"southeast");
            actions.add(8,"skip");String max_act="";
            double dist=findAngle(posX, posY, cent.get(0), cent.get(1),corral_min_x,corral_min_y);
            for(int i=0;i<actions.size();i++) {
                ArrayList<Integer> NextPos=this.NextState(posX,posY,actions.get(i));
                double dd = findAngle(NextPos.get(0), NextPos.get(1), cent.get(0), cent.get(1), corral_min_x, corral_min_y);
                //log.println("dist: " + dist + "    " + "action:  " + actions.get(i));
                //if(!Double.isNaN(angle)) {
                if (dd > dist && !actions.get(i).equals(a1)) {
                    //suit.add(actions.get(i));
                    dist=dd;
                    max_act=actions.get(i);
                }
                //}
            }
            suit.add(max_act);
            if(suit.size()>0){
                //log.println("suits aaa:  "+suit);log.flush();
              /*  Random r1 = new Random();
                // action generating by random number
                int d = r1.nextInt(suit.size()-1-0+1);
                //log.println("d: "+d+"   "+suit.get(d));log.flush();
                action=suit.get(d);

            */
                action=max_act;
            }
            else {
                action = "skip";
                //log.println("circle function action khali bod  :" + action);
                log.flush();
            }
            if(action.equals(""))
                action="skip";
        }
        else {
            Random r1 = new Random();
            // action generating by random number
            int d = r1.nextInt(9);
            //log.println("d: " + d);
            log.flush();
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
                case 8:
                    action = "skip";
                    break;
            }
        }
        // return action
        return action;
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

    public String ExploreAndExploit0(HashMap<String, String> QQ,ArrayList<Double> cent){
        uq=0;String action="";
        Random r1 = new Random();
        if(QQ.size()>0) {
            switch (r1.nextInt(10)) {
                case 0:
                    action = randomAction(cent);
                    break;
                case 1:
                    action = randomAction(cent);
                    break;
                case 2:
                    action = randomAction(cent);
                    break;
                case 3:
                    action = randomAction(cent);
                    break;
                case 4:
                    action = randomAction(cent);
                    break;
                case 5:
                    action = randomAction(cent);
                    break;
                case 6:
                    action = randomAction(cent);
                    break;
                case 7:
                    action = randomAction(cent);
                    break;
                case 8:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 9:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
            }
        }
        else
            action=randomAction(cent);
        return action;
    }
    public String ExploreAndExploit1(HashMap<String, String> QQ,ArrayList<Double> cent){
        uq=0;String action="";
        Random r1 = new Random();
        // action generating by random number
        if(QQ.size()>0) {
            switch (r1.nextInt(10)) {
                case 0:
                    action = randomAction(cent);
                    break;
                case 1:
                    action = randomAction(cent);
                    break;
                case 2:
                    action = randomAction(cent);
                    break;
                case 3:
                    action = randomAction(cent);
                    break;
                case 4:
                    action = randomAction(cent);
                    break;
                case 5:
                    action = randomAction(cent);
                    break;
                case 6:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 7:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 8:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 9:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
            }
        }
        else
            action = randomAction(cent);
        return action;
    }
    public String ExploreAndExploit2( HashMap<String,String> QQ,ArrayList<Double> cent){
        uq=0;String action="";
        Random r1 = new Random();
        // action generating by random number
        if(QQ.size()>0){
            switch (r1.nextInt(10)) {
                case 0:
                    action = randomAction(cent);
                    break;
                case 1:
                    action = randomAction(cent);
                    break;
                case 2:
                    action = randomAction(cent);
                    break;
                case 3:
                    action = randomAction(cent);
                    break;
                case 4:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 5:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 6:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 7:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 8:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 9:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
            }
        }
        else
            action = randomAction(cent);
        return action;
    }
    public String ExploreAndExploit3( HashMap<String,String> QQ,ArrayList<Double> cent){
        uq=0;String action="";
        Random r1 = new Random();
        // action generating by random number
        if(QQ.size()>0) {
            switch (r1.nextInt(10)) {
                case 0:
                    action = randomAction(cent);
                    break;
                case 1:
                    action = randomAction(cent);
                    break;
                case 2:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 3:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 4:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 5:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 6:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 7:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 8:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
                case 9:
                    //log.println("your action is selected from qtable");log.flush();
                    action = ActionQ(QQ);
                    uq=1;
                    break;
            }
        }
        else
            action = randomAction(cent);
        return action;
    }
    public String ActionQ(HashMap<String,String> QQ) {
        //log.println("ActionQ  " + QQ);
        log.flush();
        String act = "";
        double min=0,d=0,a=0;
        if (getHerdAlone() == 1 || getHerdGroup() == 1 || getRandAlone()==1 || getRandGroup()==1 || getGoAfterAlone()==1 || getGoAfterGroup()==1) {
            double max = 1000000000000000000l*10000000;
            for (String key1 : QQ.keySet()) {
                String d1 = QQ.get(key1);
                String d1x[]=d1.split("#");
                double d3 = Double.parseDouble(d1x[0]);
                if (d3 <max) {
                    max = d3;
                    min=Double.parseDouble(d1x[1]);
                    d=Double.parseDouble(d1x[2]);
                    a=Double.parseDouble(d1x[3]);
                }
            }
        }
        //log.println("ActionQ  best best state found " + min+"  "+d+"   "+a);
        log.flush();
        //////////////
        ArrayList<String> actions = new ArrayList<String>();
        actions.add(0, "east");
        actions.add(1, "northeast");
        actions.add(2, "north");
        actions.add(3, "northwest");
        actions.add(4, "west");
        actions.add(5, "southwest");
        actions.add(6, "south");
        actions.add(7, "southeast");
        actions.add(8, "skip");
        /////////////////
        double max1=1000000000000000l;
        if(getHerdAlone()==1){
            ArrayList<String> acs=new ArrayList<String>();String a1="";
            ArrayList<String> acs1=new ArrayList<String>();String a2="";
            for(int u=0;u<actions.size();u++){
                ArrayList<Integer> NXT=NextState(posX,posY,actions.get(u));
                double m3=findAngle(corral_x,corral_y,posX,posY,cent.get(0),cent.get(1));
                double m6=findAngle(corral_x,corral_y,NXT.get(0),NXT.get(1),cent.get(0),cent.get(1));
                if(Math.abs((m6-m3)-a)<max1){
                    max1=Math.abs((m6-m3)-a);
                    a1=actions.get(u);
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if (!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3=findAngle(corral_x,corral_y,posX,posY,cent.get(0),cent.get(1));
                    double m6=findAngle(corral_x,corral_y,NXT.get(0),NXT.get(1),cent.get(0),cent.get(1));
                    if(Math.abs((m6-m3)-a)<max1){
                        max1=Math.abs((m6-m3)-a);
                        a1=actions.get(u);
                    }
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if (!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3=findAngle(corral_x,corral_y,posX,posY,cent.get(0),cent.get(1));
                    double m6=findAngle(corral_x,corral_y,NXT.get(0),NXT.get(1),cent.get(0),cent.get(1));
                    if(Math.abs((m6-m3)-a)<max1){
                        max1=Math.abs((m6-m3)-a);
                        a1=actions.get(u);
                    }
                }
            }
            acs.add(a1);
            ////////////////////////////////////////////////
            max1=1000000000;
            for(int u=0;u<acs.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                if(Math.abs((m5-m2)-min)<max1){
                    max1=Math.abs((m5-m2)-min);
                    a2=acs.get(u);
                }
            }
            acs1.add(a2);
            max1=1000000000;
            for(int u=0;u<acs.size();u++) {
                if (!acs1.contains(acs.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                    double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                    double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                    if (Math.abs((m5 - m2) - min) < max1) {
                        max1 = Math.abs((m5 - m2) - min);
                        a2=acs.get(u);
                    }
                }
            }
            acs1.add(a2);
            ////////////////////////////////////////////////
            max1=1000000000;
            for(int u=0;u<acs1.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs1.get(u));
                double m1 = Math.sqrt((posX - corral_x) * (posX - corral_x) + (posY - corral_y) * (posY - corral_y));
                double m4 = Math.sqrt((NXT.get(0) - corral_x) * (NXT.get(0) - corral_x) + (NXT.get(1) - corral_y) * (NXT.get(1) - corral_y));
                if (Math.abs((m4-m1)-d) < max1) {
                    max1 = Math.abs((m4-m1)-d);
                    act = acs1.get(u);
                }
            }
        }
        if(getRandAlone()==1){
            max1=1000000000000000l;
            ArrayList<String> acs=new ArrayList<String>();String a1="";
            ArrayList<String> acs1=new ArrayList<String>();String a2="";
            for(int u=0;u<actions.size();u++){
                ArrayList<Integer> NXT=NextState(posX,posY,actions.get(u));
                double m3=findAngle(corral_x,corral_y,posX,posY,cent.get(0),cent.get(1));
                double m6=findAngle(corral_x,corral_y,NXT.get(0),NXT.get(1),cent.get(0),cent.get(1));
                if(Math.abs((m6-m3)-a)<max1){
                    max1=Math.abs((m6-m3)-a);
                    a1=actions.get(u);
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if (!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3 = findAngle(corral_x,corral_y, posX, posY, cent.get(0), cent.get(1));
                    double m6 = findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));
                    if(Math.abs((m6-m3)-a)<max1){
                        max1=Math.abs((m6-m3)-a);
                        a1=actions.get(u);
                    }
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if (!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3 = findAngle(corral_x,corral_y, posX, posY, cent.get(0), cent.get(1));
                    double m6 = findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));
                    if(Math.abs((m6-m3)-a)<max1){
                        max1=Math.abs((m6-m3)-a);
                        a1=actions.get(u);
                    }
                }
            }
            acs.add(a1);
            ////////////////////////////////////////////////
            max1=1000000000;
            for(int u=0;u<acs.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                if(Math.abs((m5-m2)-min)<max1){
                    max1=Math.abs((m5-m2)-min);
                    a2=acs.get(u);
                }
            }
            acs1.add(a2);
            max1=1000000000;
            for(int u=0;u<acs.size();u++) {
                if (!acs1.contains(acs.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                    double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                    double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                    if (Math.abs((m5 - m2) - min) < max1) {
                        max1 = Math.abs((m5 - m2) - min);
                        a2=acs.get(u);
                    }
                }
            }
            acs1.add(a2);
            ////////////////////////////////////////////////
            max1=1000000000;
            for(int u=0;u<acs1.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs1.get(u));
                double m1 = Math.sqrt((posX - corral_x) * (posX - corral_x) + (posY - corral_y) * (posY - corral_y));
                double m4 = Math.sqrt((NXT.get(0) - corral_x) * (NXT.get(0) - corral_x) + (NXT.get(1) - corral_y) * (NXT.get(1) - corral_y));
                if (Math.abs((m4-m1)-d) < max1) {
                    max1 = Math.abs((m4-m1)-d);
                    act = acs1.get(u);
                }
            }
        }
        if(getGoAfterAlone()==1){
            max1=1000000000000000l;
            ArrayList<String> acs=new ArrayList<String>();String a1="";
            ArrayList<String> acs1=new ArrayList<String>();String a2="";
            for(int u=0;u<actions.size();u++){
                ArrayList<Integer> NXT=NextState(posX,posY,actions.get(u));
                double m3=findAngle(corral_x,corral_y,posX,posY,cent.get(0),cent.get(1));
                double m6=findAngle(corral_x,corral_y,NXT.get(0),NXT.get(1),cent.get(0),cent.get(1));
                if(Math.abs((m6-m3)-a)<max1){
                    max1=Math.abs((m6-m3)-a);
                    a1=actions.get(u);
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if (!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3 = findAngle(corral_x,corral_y, posX, posY, cent.get(0), cent.get(1));
                    double m6 = findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));
                    if(Math.abs((m6-m3)-a)<max1){
                        max1=Math.abs((m6-m3)-a);
                        a1=actions.get(u);
                    }
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if (!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3 = findAngle(corral_x,corral_y, posX, posY, cent.get(0), cent.get(1));
                    double m6 = findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));
                    if(Math.abs((m6-m3)-a)<max1){
                        max1=Math.abs((m6-m3)-a);
                        a1=actions.get(u);
                    }
                }
            }
            acs.add(a1);
            ////////////////////////////////////////////////
            max1=1000000000;
            for(int u=0;u<acs.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                if(Math.abs((m5-m2)-min)<max1){
                    max1=Math.abs((m5-m2)-min);
                    a2=acs.get(u);
                }
            }
            acs1.add(a2);
            max1=1000000000;
            for(int u=0;u<acs.size();u++) {
                if (!acs1.contains(acs.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                    double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                    double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                    if (Math.abs((m5 - m2) - min) < max1) {
                        max1 = Math.abs((m5 - m2) - min);
                        a2=acs.get(u);
                    }
                }
            }
            acs1.add(a2);
            ////////////////////////////////////////////////
            max1=1000000000;
            for(int u=0;u<acs1.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs1.get(u));
                double m1 = Math.sqrt((posX - corral_x) * (posX - corral_x) + (posY - corral_y) * (posY - corral_y));
                double m4 = Math.sqrt((NXT.get(0) - corral_x) * (NXT.get(0) - corral_x) + (NXT.get(1) - corral_y) * (NXT.get(1) - corral_y));
                if (Math.abs((m4-m1)-d) < max1) {
                    max1 = Math.abs((m4-m1)-d);
                    act = acs1.get(u);
                }
            }
        }
        if(getHerdGroup()==1){
            max1=1000000000;
            ArrayList<String> acs=new ArrayList<String>();String a1="";
            ArrayList<String> acs1=new ArrayList<String>();String a2="";
            for(int u=0;u<actions.size();u++){
                ArrayList<Integer> NXT=NextState(posX,posY,actions.get(u));
                double m3=findAngle(corral_x,corral_y,posX,posY,cent.get(0),cent.get(1));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        m3+=findAngle(corral_x,corral_y,prev1.get(step).get(0),prev1.get(step).get(1),cent.get(0),cent.get(1));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m3=m3/(N_n.size()+1);
                ///////////////////////////
                double m6=findAngle(corral_x,corral_y,NXT.get(0),NXT.get(1),cent.get(0),cent.get(1));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        NXT=NextState(prev1.get(step).get(0),prev1.get(step).get(1),actions.get(u));
                        m6+=findAngle(corral_x,corral_y,NXT.get(0),NXT.get(1),cent.get(0),cent.get(1));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m6=m6/(N_n.size()+1);
                ///////////////////////////
                if(Math.abs((m6-m3)-a)<max1){
                    max1=Math.abs((m6-m3)-a);
                    a1=actions.get(u);
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if(!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3 = findAngle(corral_x,corral_y, posX, posY, cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            m3 += findAngle(corral_x,corral_y, prev1.get(step).get(0), prev1.get(step).get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m3 = m3 / (N_n.size() + 1);
                    ///////////////////////////
                    double m6 = findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            NXT = NextState(prev1.get(step).get(0), prev1.get(step).get(1), actions.get(u));
                            m6 += findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m6 = m6 / (N_n.size() + 1);
                    ///////////////////////////
                    if(Math.abs((m6-m3)-a)<max1){
                        max1=Math.abs((m6-m3)-a);
                        a1=actions.get(u);
                    }
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if(!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3 = findAngle(corral_x,corral_y, posX, posY, cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            m3 += findAngle(corral_x,corral_y,prev1.get(step).get(0), prev1.get(step).get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m3 = m3 / (N_n.size() + 1);
                    ///////////////////////////
                    double m6 = findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            NXT = NextState(prev1.get(step).get(0), prev1.get(step).get(1), actions.get(u));
                            m6 += findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m6 = m6 / (N_n.size() + 1);
                    ///////////////////////////
                    if (Math.abs((m6-m3)-a) < max1) {
                        max1 = Math.abs((m6-m3)-a);
                        a1 = actions.get(u);
                    }
                }
            }
            acs.add(a1);
            /////////////////////
            max1=1000000000000000l;
            for(int u=0;u<acs.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        m2 += Math.sqrt((prev1.get(step).get(0) - cent.get(0)) * (prev1.get(step).get(0) - cent.get(0)) + (prev1.get(step).get(1) - cent.get(1)) * (prev1.get(step).get(1) - cent.get(1)));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m2=m2/(N_n.size()+1);
                ///////////////////////////
                double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        NXT=NextState(prev1.get(step).get(0),prev1.get(step).get(1),acs.get(u));
                        m5 += Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m5=m5/(N_n.size()+1);
                ///////////////////////////
                if(Math.abs((m5-m2)-min)<max1){
                    max1=Math.abs((m5-m2)-min);
                    a2=acs.get(u);
                }
            }
            acs1.add(a2);
            max1=1000000000;
            for(int u=0;u<acs.size();u++) {
                if(!acs1.contains(acs.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                    double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                    ///////////////////////////
                    for(int i=0;i<N_n.size();i++){
                        Method method= null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            m2 += Math.sqrt((prev1.get(step).get(0) - cent.get(0)) * (prev1.get(step).get(0) - cent.get(0)) + (prev1.get(step).get(1) - cent.get(1)) * (prev1.get(step).get(1) - cent.get(1)));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m2=m2/(N_n.size()+1);
                    ///////////////////////////
                    double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                    ///////////////////////////
                    for(int i=0;i<N_n.size();i++){
                        Method method= null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            NXT=NextState(prev1.get(step).get(0),prev1.get(step).get(1),acs.get(u));
                            m5 += Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m5=m5/(N_n.size()+1);
                    ///////////////////////////
                    if(Math.abs((m5-m2)-min)<max1){
                        max1=Math.abs((m5-m2)-min);
                        a2=acs.get(u);
                    }
                }
            }
            acs1.add(a2);
            ///////////////////
            // /////////////////\
            max1=1000000000;
            for(int u=0;u<acs1.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs1.get(u));
                double m1 = Math.sqrt((posX - corral_x) * (posX - corral_x) + (posY - corral_y) * (posY - corral_y));
                for (int i = 0; i < N_n.size(); i++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        m1 += Math.sqrt((prev1.get(step).get(0)- corral_x) * (prev1.get(step).get(0) - corral_x) + (prev1.get(step).get(1) - corral_y) * (prev1.get(step).get(1) - corral_y));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m1=m1/(N_n.size()+1);
                double m4 = Math.sqrt((NXT.get(0) - corral_x) * (NXT.get(0) - corral_x) + (NXT.get(1) - corral_y) * (NXT.get(1) - corral_y));
                for (int i = 0; i < N_n.size(); i++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        NXT = NextState(prev1.get(step).get(0), prev1.get(step).get(1), acs1.get(u));
                        m4 += Math.sqrt((NXT.get(0) - corral_x) * (NXT.get(0) - corral_x) + (NXT.get(1) - corral_y) * (NXT.get(1) - corral_y));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m4=m4/(N_n.size()+1);
                if (Math.abs((m4-m1)-d) < max1) {
                    max1 = Math.abs((m4-m1)-d);
                    act = acs1.get(u);
                }
            }
            ////////////////////
        }
        if(getRandGroup()==1){
            max1=1000000000;
            ArrayList<String> acs=new ArrayList<String>();String a1="";
            ArrayList<String> acs1=new ArrayList<String>();String a2="";
            for(int u=0;u<actions.size();u++){
                ArrayList<Integer> NXT=NextState(posX,posY,actions.get(u));
                double m3=findAngle(corral_x,corral_y,posX,posY,cent.get(0),cent.get(1));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        m3+=findAngle(corral_x,corral_y,prev1.get(step).get(0),prev1.get(step).get(1),cent.get(0),cent.get(1));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m3=m3/(N_n.size()+1);
                ///////////////////////////
                double m6=findAngle(corral_x,corral_y,NXT.get(0),NXT.get(1),cent.get(0),cent.get(1));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        NXT=NextState(prev1.get(step).get(0),prev1.get(step).get(1),actions.get(u));
                        m6+=findAngle(corral_x,corral_y,NXT.get(0),NXT.get(1),cent.get(0),cent.get(1));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m6=m6/(N_n.size()+1);
                ///////////////////////////
                if(Math.abs((m6-m3)-a)<max1){
                    max1=Math.abs((m6-m3)-a);
                    a1=actions.get(u);
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if(!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3 = findAngle(corral_x,corral_y, posX, posY, cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            m3 += findAngle(corral_x,corral_y, prev1.get(step).get(0), prev1.get(step).get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m3 = m3 / (N_n.size() + 1);
                    ///////////////////////////
                    double m6 = findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            NXT = NextState(prev1.get(step).get(0), prev1.get(step).get(1), actions.get(u));
                            m6 += findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m6 = m6 / (N_n.size() + 1);
                    ///////////////////////////
                    if(Math.abs((m6-m3)-a)<max1){
                        max1=Math.abs((m6-m3)-a);
                        a1=actions.get(u);
                    }
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if(!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3 = findAngle(corral_x,corral_y, posX, posY, cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            m3 += findAngle(corral_x,corral_y,prev1.get(step).get(0), prev1.get(step).get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m3 = m3 / (N_n.size() + 1);
                    ///////////////////////////
                    double m6 = findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            NXT = NextState(prev1.get(step).get(0), prev1.get(step).get(1), actions.get(u));
                            m6 += findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m6 = m6 / (N_n.size() + 1);
                    ///////////////////////////
                    if (Math.abs((m6-m3)-a) < max1) {
                        max1 = Math.abs((m6-m3)-a);
                        a1 = actions.get(u);
                    }
                }
            }
            acs.add(a1);
            max1=1000000000;
            /////////////////////
            for(int u=0;u<acs.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        m2 += Math.sqrt((prev1.get(step).get(0) - cent.get(0)) * (prev1.get(step).get(0) - cent.get(0)) + (prev1.get(step).get(1) - cent.get(1)) * (prev1.get(step).get(1) - cent.get(1)));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m2=m2/(N_n.size()+1);
                ///////////////////////////
                double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        NXT=NextState(prev1.get(step).get(0),prev1.get(step).get(1),acs.get(u));
                        m5 += Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m5=m5/(N_n.size()+1);
                ///////////////////////////
                if(Math.abs((m5-m2)-min)<max1){
                    max1=Math.abs((m5-m2)-min);
                    a2=acs.get(u);
                }
            }
            acs1.add(a2);
            max1=1000000000;
            for(int u=0;u<acs.size();u++) {
                if(!acs1.contains(acs.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                    double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                    ///////////////////////////
                    for(int i=0;i<N_n.size();i++){
                        Method method= null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            m2 += Math.sqrt((prev1.get(step).get(0) - cent.get(0)) * (prev1.get(step).get(0) - cent.get(0)) + (prev1.get(step).get(1) - cent.get(1)) * (prev1.get(step).get(1) - cent.get(1)));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m2=m2/(N_n.size()+1);
                    ///////////////////////////
                    double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                    ///////////////////////////
                    for(int i=0;i<N_n.size();i++){
                        Method method= null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            NXT=NextState(prev1.get(step).get(0),prev1.get(step).get(1),acs.get(u));
                            m5 += Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m5=m5/(N_n.size()+1);
                    ///////////////////////////
                    if(Math.abs((m5-m2)-min)<max1){
                        max1=Math.abs((m5-m2)-min);
                        a2=acs.get(u);
                    }
                }
            }
            acs1.add(a2);
            ///////////////////
            // /////////////////\
            max1=1000000000;
            for(int u=0;u<acs1.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs1.get(u));
                double m1 = Math.sqrt((posX - corral_x) * (posX - corral_x) + (posY - corral_y) * (posY - corral_y));
                for (int i = 0; i < N_n.size(); i++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        m1 += Math.sqrt((prev1.get(step).get(0)- corral_x) * (prev1.get(step).get(0) - corral_x) + (prev1.get(step).get(1) - corral_y) * (prev1.get(step).get(1) - corral_y));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m1=m1/(N_n.size()+1);
                double m4 = Math.sqrt((NXT.get(0) - corral_x) * (NXT.get(0) - corral_x) + (NXT.get(1) - corral_y) * (NXT.get(1) - corral_y));
                for (int i = 0; i < N_n.size(); i++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        NXT = NextState(prev1.get(step).get(0), prev1.get(step).get(1), acs1.get(u));
                        m4 += Math.sqrt((NXT.get(0) - corral_x) * (NXT.get(0) - corral_x) + (NXT.get(1) - corral_y) * (NXT.get(1) - corral_y));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m4=m4/(N_n.size()+1);
                if (Math.abs((m4-m1)-d) < max1) {
                    max1 = Math.abs((m4-m1)-d);
                    act = acs1.get(u);
                }
            }
            ////////////////////
        }
        if(getGoAfterGroup()==1){
            max1=1000000000;
            ArrayList<String> acs=new ArrayList<String>();String a1="";
            ArrayList<String> acs1=new ArrayList<String>();String a2="";
            for(int u=0;u<actions.size();u++){
                ArrayList<Integer> NXT=NextState(posX,posY,actions.get(u));
                double m3=findAngle(corral_x,corral_y,posX,posY,cent.get(0),cent.get(1));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        m3+=findAngle(corral_x,corral_y,prev1.get(step).get(0),prev1.get(step).get(1),cent.get(0),cent.get(1));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m3=m3/(N_n.size()+1);
                ///////////////////////////
                double m6=findAngle(corral_x,corral_y,NXT.get(0),NXT.get(1),cent.get(0),cent.get(1));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        NXT=NextState(prev1.get(step).get(0),prev1.get(step).get(1),actions.get(u));
                        m6+=findAngle(corral_x,corral_y,NXT.get(0),NXT.get(1),cent.get(0),cent.get(1));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m6=m6/(N_n.size()+1);
                ///////////////////////////
                if(Math.abs((m6-m3)-a)<max1){
                    max1=Math.abs((m6-m3)-a);
                    a1=actions.get(u);
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if(!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3 = findAngle(corral_x,corral_y, posX, posY, cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            m3 += findAngle(corral_x,corral_y, prev1.get(step).get(0), prev1.get(step).get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m3 = m3 / (N_n.size() + 1);
                    ///////////////////////////
                    double m6 = findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            NXT = NextState(prev1.get(step).get(0), prev1.get(step).get(1), actions.get(u));
                            m6 += findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m6 = m6 / (N_n.size() + 1);
                    ///////////////////////////
                    if(Math.abs((m6-m3)-a)<max1){
                        max1=Math.abs((m6-m3)-a);
                        a1=actions.get(u);
                    }
                }
            }
            acs.add(a1);
            max1=1000000000;
            for(int u=0;u<actions.size();u++) {
                if(!acs.contains(actions.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, actions.get(u));
                    double m3 = findAngle(corral_x,corral_y, posX, posY, cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            m3 += findAngle(corral_x,corral_y,prev1.get(step).get(0), prev1.get(step).get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m3 = m3 / (N_n.size() + 1);
                    ///////////////////////////
                    double m6 = findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));
                    ///////////////////////////
                    for (int i = 0; i < N_n.size(); i++) {
                        Method method = null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            NXT = NextState(prev1.get(step).get(0), prev1.get(step).get(1), actions.get(u));
                            m6 += findAngle(corral_x,corral_y, NXT.get(0), NXT.get(1), cent.get(0), cent.get(1));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m6 = m6 / (N_n.size() + 1);
                    ///////////////////////////
                    if (Math.abs((m6-m3)-a) < max1) {
                        max1 = Math.abs((m6-m3)-a);
                        a1 = actions.get(u);
                    }
                }
            }
            acs.add(a1);
            max1=1000000000;
            /////////////////////
            for(int u=0;u<acs.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        m2 += Math.sqrt((prev1.get(step).get(0) - cent.get(0)) * (prev1.get(step).get(0) - cent.get(0)) + (prev1.get(step).get(1) - cent.get(1)) * (prev1.get(step).get(1) - cent.get(1)));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m2=m2/(N_n.size()+1);
                ///////////////////////////
                double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                ///////////////////////////
                for(int i=0;i<N_n.size();i++){
                    Method method= null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        NXT=NextState(prev1.get(step).get(0),prev1.get(step).get(1),acs.get(u));
                        m5 += Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m5=m5/(N_n.size()+1);
                ///////////////////////////
                if(Math.abs((m5-m2)-min)<max1){
                    max1=Math.abs((m5-m2)-min);
                    a2=acs.get(u);
                }
            }
            acs1.add(a2);
            max1=1000000000;
            for(int u=0;u<acs.size();u++) {
                if(!acs1.contains(acs.get(u))){
                    ArrayList<Integer> NXT = NextState(posX, posY, acs.get(u));
                    double m2 = Math.sqrt((posX - cent.get(0)) * (posX - cent.get(0)) + (posY - cent.get(1)) * (posY - cent.get(1)));
                    ///////////////////////////
                    for(int i=0;i<N_n.size();i++){
                        Method method= null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            m2 += Math.sqrt((prev1.get(step).get(0) - cent.get(0)) * (prev1.get(step).get(0) - cent.get(0)) + (prev1.get(step).get(1) - cent.get(1)) * (prev1.get(step).get(1) - cent.get(1)));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m2=m2/(N_n.size()+1);
                    ///////////////////////////
                    double m5 = Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));
                    ///////////////////////////
                    for(int i=0;i<N_n.size();i++){
                        Method method= null;
                        try {
                            method = this.getClass().getMethod("getAgent" + N_n.get(i));
                            Object object = (Object) method.invoke(this);
                            Method method3 = object.getClass().getMethod("getPrev_Pos");
                            HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                            if(!prev1.containsKey(step)){
                                int o1=0;int o2=0;boolean o3=false;
                                while(o1<=9000000000000000000l){
                                    while(o2<=9000000000000000000l){
                                        method3 = object.getClass().getMethod("getPrev_Pos");
                                        prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                        if(prev1.containsKey(step)){
                                            o3=true;break;
                                        }
                                        o2++;
                                    }
                                    if(o3==true)
                                        break;
                                    o1++;
                                }
                            }
                            NXT=NextState(prev1.get(step).get(0),prev1.get(step).get(1),acs.get(u));
                            m5 += Math.sqrt((NXT.get(0) - cent.get(0)) * (NXT.get(0) - cent.get(0)) + (NXT.get(1) - cent.get(1)) * (NXT.get(1) - cent.get(1)));

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                    m5=m5/(N_n.size()+1);
                    ///////////////////////////
                    if(Math.abs((m5-m2)-min)<max1){
                        max1=Math.abs((m5-m2)-min);
                        a2=acs.get(u);
                    }
                }
            }
            acs1.add(a2);
            ///////////////////
            // /////////////////\
            max1=1000000000;
            for(int u=0;u<acs1.size();u++){
                ArrayList<Integer> NXT = NextState(posX, posY, acs1.get(u));
                double m1 = Math.sqrt((posX - corral_x) * (posX - corral_x) + (posY - corral_y) * (posY - corral_y));
                for (int i = 0; i < N_n.size(); i++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        m1 += Math.sqrt((prev1.get(step).get(0)- corral_x) * (prev1.get(step).get(0) - corral_x) + (prev1.get(step).get(1) - corral_y) * (prev1.get(step).get(1) - corral_y));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m1=m1/(N_n.size()+1);
                double m4 = Math.sqrt((NXT.get(0) - corral_x) * (NXT.get(0) - corral_x) + (NXT.get(1) - corral_y) * (NXT.get(1) - corral_y));
                for (int i = 0; i < N_n.size(); i++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getAgent" + N_n.get(i));
                        Object object = (Object) method.invoke(this);
                        Method method3 = object.getClass().getMethod("getPrev_Pos");
                        HashMap<Integer, ArrayList<Integer>> prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                        if(!prev1.containsKey(step)){
                            int o1=0;int o2=0;boolean o3=false;
                            while(o1<=9000000000000000000l){
                                while(o2<=9000000000000000000l){
                                    method3 = object.getClass().getMethod("getPrev_Pos");
                                    prev1 = (HashMap<Integer, ArrayList<Integer>>) method3.invoke(object);
                                    if(prev1.containsKey(step)){
                                        o3=true;break;
                                    }
                                    o2++;
                                }
                                if(o3==true)
                                    break;
                                o1++;
                            }
                        }
                        NXT = NextState(prev1.get(step).get(0), prev1.get(step).get(1), acs1.get(u));
                        m4 += Math.sqrt((NXT.get(0) - corral_x) * (NXT.get(0) - corral_x) + (NXT.get(1) - corral_y) * (NXT.get(1) - corral_y));

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                m4=m4/(N_n.size()+1);
                if (Math.abs((m4-m1)-d) < max1) {
                    max1 = Math.abs((m4-m1)-d);
                    act = acs1.get(u);
                }
            }
            ////////////////////
        }
        if(act.length()==0)
            act="skip";
        /////////////////
        //log.println("ActionQ  best action "+act);log.flush();
        //////////////
        return act;
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
    public String Circle(ArrayList<Double> cent){
        String action=random(decider);
        /*ArrayList<String> actions=new ArrayList<String>();
        actions.add(0,"east");
        actions.add(1,"northeast");
        actions.add(2,"north");
        actions.add(3,"northwest");
        actions.add(4,"west");
        actions.add(5,"southwest");
        actions.add(6,"south");
        actions.add(7,"southeast");
        actions.add(8,"skip");
        double angle_max=0;
        for(int i=0;i<actions.size();i++) {
            ArrayList<Integer> NextPos=this.NextState(posX,posY,actions.get(i));
            double angle = findAngle(NextPos.get(0), NextPos.get(1), cent.get(0), cent.get(1), corral_min_x, corral_min_y);
            //log.println("angle: " + angle + "    " + "action:  " + actions.get(i));
            if(!Double.isNaN(angle)) {
                if (angle > angle_max) {
                    action = actions.get(i);
                    angle_max = angle;
                }
            }
        }*/

        //log.println("decider is "+decider+"    circle function action is :"+action);log.flush();
        // System.out.println(posX+" "+posY+"  "+cent+"         "+action+"  yessssssssssssss"+corral_min_x+"   "+corral_min_y);
        return action;
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

