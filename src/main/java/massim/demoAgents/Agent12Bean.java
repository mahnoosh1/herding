package massim.demoAgents;

import Messages.*;
import de.dailab.jiactng.agentcore.AbstractAgentBean;
import de.dailab.jiactng.agentcore.comm.message.JiacMessage;
import de.dailab.jiactng.agentcore.knowledge.IFact;
import de.dailab.jiactng.agentcore.ontology.AgentDescription;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;
import org.sercho.masp.space.event.SpaceEvent;
import org.sercho.masp.space.event.SpaceObserver;
import org.sercho.masp.space.event.WriteCallEvent;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mahnoosh on 10/10/2017.
 */
public class Agent12Bean extends AbstractAgentBean {
    Agent1Bean A1 = new Agent1Bean();
    Agent2Bean A2 = new Agent2Bean();
    Agent3Bean A3 = new Agent3Bean();
    Agent4Bean A4 = new Agent4Bean();
    Agent5Bean A5 = new Agent5Bean();
    Agent6Bean A6 = new Agent6Bean();
    Agent7Bean A7 = new Agent7Bean();
    Agent8Bean A8 = new Agent8Bean();
    Agent9Bean A9 = new Agent9Bean();
    Agent10Bean A10 = new Agent10Bean();

    public Agent1Bean getA1() {
        return A1;
    }

    public void setA1(Agent1Bean a1) {
        A1 = a1;
    }

    public Agent2Bean getA2() {
        return A2;
    }

    public void setA2(Agent2Bean a2) {
        A2 = a2;
    }

    public Agent3Bean getA3() {
        return A3;
    }

    public void setA3(Agent3Bean a3) {
        A3 = a3;
    }

    public Agent4Bean getA4() {
        return A4;
    }

    public void setA4(Agent4Bean a4) {
        A4 = a4;
    }

    public Agent5Bean getA5() {
        return A5;
    }

    public void setA5(Agent5Bean a5) {
        A5 = a5;
    }

    public Agent6Bean getA6() {
        return A6;
    }

    public void setA6(Agent6Bean a6) {
        A6 = a6;
    }

    public Agent7Bean getA7() {
        return A7;
    }

    public void setA7(Agent7Bean a7) {
        A7 = a7;
    }

    public Agent8Bean getA8() {
        return A8;
    }

    public void setA8(Agent8Bean a8) {
        A8 = a8;
    }

    public Agent9Bean getA9() {
        return A9;
    }

    public void setA9(Agent9Bean a9) {
        A9 = a9;
    }

    public Agent10Bean getA10() {
        return A10;
    }

    public void setA10(Agent10Bean a10) {
        A10 = a10;
    }
    private List<IAgentDescription> agentDescriptions1 = null;

    public List<IAgentDescription> getAgentDescriptions1() {
        return agentDescriptions1;
    }

    public void setAgentDescriptions1(List<IAgentDescription> agentDescriptions1) {
        this.agentDescriptions1 = agentDescriptions1;
    }

    private int cnt=0;
    private ArrayList<Integer> HerdAlone=new ArrayList<Integer>();
    private ArrayList<Integer> GoAfterAlone=new ArrayList<Integer>();
    private HashMap<String,String> QHA=new HashMap<String, String>();
    private HashMap<String,String> QGA=new HashMap<String, String>();
    PrintWriter log=null;
    String filenamelog= "c:\\users\\rahma\\desktop\\Graphic1\\reach.txt";
    FileWriter fw111 = null;

    @Override
    public void doStart() throws Exception{
//        for(int i1=1;i1<=10;i1++){
//            HA ha = new HA(i1);
//            JiacMessage m10 = new JiacMessage(ha);
//            memory.attach(new HandleHA(), m10);
//        }
//        for(int i1=1;i1<=10;i1++){
//            HG hg = new HG(i1);
//            JiacMessage m10 = new JiacMessage(hg);
//            memory.attach(new HandleHG(), m10);
//        }
//        for(int i1=1;i1<=10;i1++){
//            GA ga = new GA(i1);
//            JiacMessage m10 = new JiacMessage(ga);
//            memory.attach(new HandleGA(), m10);
//        }
//        for(int i1=1;i1<=10;i1++){
//            GAN ga = new GAN(i1);
//            JiacMessage m10 = new JiacMessage(ga);
//            memory.attach(new HandleGAN(), m10);
//        }
//        for(int i1=1;i1<=10;i1++){
//            NM nm = new NM(i1);
//            JiacMessage m10 = new JiacMessage(nm);
//            memory.attach(new HandleNM(), m10);
//        }
        try {
            fw111 = new FileWriter(filenamelog);
            fw111.write("");
            fw111.close();
            log = new PrintWriter(new FileWriter(filenamelog));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void generator(){
        for(int j=0;j<HerdAlone.size();j++){
            ///////////
            Method method= null;
            try {
                method = this.getClass().getMethod("getA" + HerdAlone.get(j));
                Object obj = (Object) method.invoke(this);
                Method method1 = obj.getClass().getMethod("getQ1HerdAlone");
                HashMap<String,String> q = (HashMap<String,String>) method1.invoke(obj);
                if(QHA.size()==0){
                    for(String key:q.keySet()){
                        QHA.put(key,q.get(key));
                    }
                }
                else {
                        if(q.size()>0) {
                            for (String key1 : q.keySet()) {
                                String m1 = q.get(key1);
                                String m2[] = m1.split("#");
                                double m3 = Double.parseDouble(m2[0]);
                                for (String key2 : QHA.keySet()) {
                                    String m4 = QHA.get(key1);
                                    String m5[] = m1.split("#");
                                    double m6 = Double.parseDouble(m2[0]);
                                    if (key1.equals(key2)) {
                                        if (m3 > m6) {
                                            QHA.put(key2, QHA.get(key2));
                                        }
                                    } else {
                                        QHA.put(key2, QHA.get(key2));
                                    }
                                }
                            }
                        }
                    }

            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            ///////////
        }
        for(int j=0;j<GoAfterAlone.size();j++){
            ///////////
            Method method= null;
            try {
                method = this.getClass().getMethod("getA" + GoAfterAlone.get(j));
                Object obj = (Object) method.invoke(this);
                Method method1 = obj.getClass().getMethod("getQ1GoAfterAlone");
                HashMap<String,String> q = (HashMap<String,String>) method1.invoke(obj);
                if(QGA.size()==0){
                    for(String key:q.keySet()){
                        QGA.put(key,q.get(key));
                    }
                }
                else {
                    if(q.size()>0) {
                        for (String key1 : q.keySet()) {
                            String m1 = q.get(key1);
                            String m2[] = m1.split("#");
                            double m3 = Double.parseDouble(m2[0]);
                            for (String key2 : QGA.keySet()) {
                                String m4 = QGA.get(key1);
                                String m5[] = m1.split("#");
                                double m6 = Double.parseDouble(m2[0]);
                                if (key1.equals(key2)) {
                                    if (m3 > m6) {
                                        QGA.put(key2, QGA.get(key2));
                                    }
                                } else {
                                    QGA.put(key2, QGA.get(key2));
                                }
                            }
                        }
                    }
                }

            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            ///////////
        }

    }
    public void sign(){
        for(int j=0;j<HerdAlone.size();j++){
            ///////////
            Method method = null;
            try {
                method = this.getClass().getMethod("getA" +HerdAlone.get(j));
                Object object = (Object) method.invoke(this);
                Method method1 = object.getClass().getDeclaredMethod("setQ1HerdAlone", HashMap.class);
                method1.invoke(object, QHA);
                ////////////
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            ///////////
        }
        for(int j=0;j<GoAfterAlone.size();j++){
            ///////////
            Method method = null;
            try {
                method = this.getClass().getMethod("getA" +GoAfterAlone.get(j));
                Object object = (Object) method.invoke(this);
                Method method1 = object.getClass().getDeclaredMethod("setQ1GoAfterAlone", HashMap.class);
                method1.invoke(object, QGA);
                ////////////
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            ///////////
        }
    }
    ////////////////////
    @SuppressWarnings("serial")
    private class HandleHA implements SpaceObserver<IFact>{
        public void notify(SpaceEvent<? extends IFact> event) {
            if (event instanceof WriteCallEvent) {
                ////////////////////////////
                Object object = ((WriteCallEvent) event).getObject();
                //if (object instanceof JiacMessage) {
                IFact msg = ((JiacMessage) object).getPayload();
                Method m = null;
                try {
                    m = msg.getClass().getDeclaredMethod("getMessage");
                    int returnVal = (Integer) m.invoke(msg);
                    HerdAlone.add(returnVal);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                cnt++;
                System.out.println(cnt);
                if(cnt==10){
                    generator();
                    sign();
                    System.out.println("manam 12 "+QHA+"        oo"+QGA);
                    cnt=0;
                }
            }
        }
    }
    private class HandleHG implements SpaceObserver<IFact>{
        public void notify(SpaceEvent<? extends IFact> event) {
            if (event instanceof WriteCallEvent) {
                ////////////////////////////
                Object object = ((WriteCallEvent) event).getObject();
                //if (object instanceof JiacMessage) {
                IFact msg = ((JiacMessage) object).getPayload();
                Method m = null;
                try {
                    m = msg.getClass().getDeclaredMethod("getMessage");
                    int returnVal = (Integer) m.invoke(msg);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                cnt++;
                System.out.println(cnt);
                if(cnt==10){
                    generator();
                    sign();
                    System.out.println("manam 12 "+QHA+"        oo"+QGA);
                    cnt=0;
                }
            }
        }
    }
    private class HandleGAN implements SpaceObserver<IFact>{
        public void notify(SpaceEvent<? extends IFact> event) {
            if (event instanceof WriteCallEvent) {
                ////////////////////////////
                Object object = ((WriteCallEvent) event).getObject();
                //if (object instanceof JiacMessage) {
                IFact msg = ((JiacMessage) object).getPayload();
                Method m = null;
                try {
                    m = msg.getClass().getDeclaredMethod("getMessage");
                    int returnVal = (Integer) m.invoke(msg);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                cnt++;
                System.out.println(cnt);
                if(cnt==10){
                    generator();
                    sign();
                    System.out.println("manam 12 "+QHA+"        oo"+QGA);
                    cnt=0;
                }
            }
        }
    }
    private class HandleGA implements SpaceObserver<IFact> {
        public void notify(SpaceEvent<? extends IFact> event) {
            if (event instanceof WriteCallEvent) {
                ////////////////////////////
                Object object = ((WriteCallEvent) event).getObject();
                //if (object instanceof JiacMessage) {
                IFact msg = ((JiacMessage) object).getPayload();
                Method m = null;
                try {
                    m = msg.getClass().getDeclaredMethod("getMessage");
                    int returnVal = (Integer) m.invoke(msg);
                    GoAfterAlone.add(returnVal);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                cnt++;
                System.out.println(cnt);
                if(cnt==10){
                    generator();
                   sign();
                    System.out.println("manam 12 "+QHA+"        oo"+QGA);
                    cnt=0;
                }
            }
        }
    }
    private class HandleNM implements SpaceObserver<IFact>{
        public void notify(SpaceEvent<? extends IFact> event) {
            if (event instanceof WriteCallEvent) {
                ////////////////////////////
                Object object = ((WriteCallEvent) event).getObject();
                //if (object instanceof JiacMessage) {
                IFact msg = ((JiacMessage) object).getPayload();
                Method m = null;
                try {
                    m = msg.getClass().getDeclaredMethod("getMessage");
                    int returnVal = (Integer) m.invoke(msg);

                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                cnt++;
                System.out.println(cnt);
                if(cnt==10){
                  generator();
                   sign();
                   System.out.println("manam 12 "+QHA+"        oo"+QGA);
                cnt=0;}
            }
        }
    }
    public boolean meghdardehi = false;
    private int step = -1;
    ArrayList<Integer> all=new ArrayList<Integer>();

    @Override
    public void execute() {
        if(!this.meghdardehi) {
            System.out.println("meghdar dadam");
            this.agentDescriptions1 = thisAgent
                    .searchAllAgents(new AgentDescription());
    this.meghdardehi = true;
        }
        if((A1.getStep() == A2.getStep() && A1.getStep() == A3.getStep()&&A1.getStep() == A4.getStep()&&A1.getStep() == A5.getStep()&&A1.getStep() == A6.getStep()&&A1.getStep() == A7.getStep()&&A1.getStep() == A8.getStep()&&A1.getStep() == A9.getStep()&&A1.getStep() == A10.getStep()) && A1.getStep()!=this.step) {
            HashMap<Integer,String> reached=new HashMap<Integer, String>();
            for (int id : A1.getCatched().keySet()) {
                if (!reached.containsKey(id))
                    reached.put(id, "");
            }
            for (int id : A2.getCatched().keySet()) {
                if (!reached.containsKey(id))
                    reached.put(id, "");
            }
            for (int id : A3.getCatched().keySet()) {
                if (!reached.containsKey(id))
                    reached.put(id, "");
            }
            for (int id : A4.getCatched().keySet()) {
                if (!reached.containsKey(id))
                    reached.put(id, "");
            }
            for (int id : A5.getCatched().keySet()) {
                if (!reached.containsKey(id))
                    reached.put(id, "");
            }
            for (int id : A6.getCatched().keySet()) {
                if (!reached.containsKey(id))
                    reached.put(id, "");
            }
            for (int id : A7.getCatched().keySet()) {
                if (!reached.containsKey(id))
                    reached.put(id, "");
            }
            for (int id : A8.getCatched().keySet()) {
                if (!reached.containsKey(id))
                    reached.put(id, "");
            }
            for (int id : A9.getCatched().keySet()) {
                if (!reached.containsKey(id))
                    reached.put(id, "");
            }
            for (int id : A10.getCatched().keySet()) {
                if (!reached.containsKey(id))
                    reached.put(id, "");
            }
            this.step = A1.getStep();
            this.all.add(reached.size());
            if(this.step == 49998) {
                log.println(this.all);
                log.println("/////////////");
                log.flush();
                System.out.println("resid");
            }
            if(this.step == 49999) {
                log.println(this.all);
                log.flush();
                System.out.println("resid");
            }

        }

    }
}

