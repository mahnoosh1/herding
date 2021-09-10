package massim.demoAgents;

import Messages.*;
import de.dailab.jiactng.agentcore.AbstractAgentBean;
import de.dailab.jiactng.agentcore.action.*;
import de.dailab.jiactng.agentcore.comm.ICommunicationBean;
import de.dailab.jiactng.agentcore.comm.IMessageBoxAddress;
import de.dailab.jiactng.agentcore.comm.message.JiacMessage;
import de.dailab.jiactng.agentcore.ontology.AgentDescription;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import sun.rmi.runtime.Log;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mahnoosh on 9/26/2017.
 */
public class Agent11Bean extends AbstractAgentBean {
    Agent1Bean A1=new Agent1Bean();
    Agent2Bean A2=new Agent2Bean();
    Agent3Bean A3=new Agent3Bean();
    Agent4Bean A4=new Agent4Bean();
    Agent5Bean A5=new Agent5Bean();
    Agent6Bean A6=new Agent6Bean();
    Agent7Bean A7=new Agent7Bean();
    Agent8Bean A8=new Agent8Bean();
    Agent9Bean A9=new Agent9Bean();
    Agent10Bean A10=new Agent10Bean();
    Agent12Bean A12=new Agent12Bean();
    ////////////////////////////////////
    Agent13Bean A13=new Agent13Bean();
    Agent14Bean A14=new Agent14Bean();
    Agent15Bean A15=new Agent15Bean();
    Agent16Bean A16=new Agent16Bean();
    Agent17Bean A17=new Agent17Bean();
    Agent18Bean A18=new Agent18Bean();
    Agent19Bean A19=new Agent19Bean();
    Agent20Bean A20=new Agent20Bean();
    Agent21Bean A21=new Agent21Bean();
    Agent22Bean A22=new Agent22Bean();
    private List<IAgentDescription> agentDescriptions1;
    private IActionDescription sendAction = null;
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
    PrintWriter f0 = null;

    public Agent22Bean getA22() {
        return A22;
    }

    public void setA22(Agent22Bean a22) {
        A22 = a22;
    }

    public Agent21Bean getA21() {
        return A21;
    }

    public void setA21(Agent21Bean a21) {
        A21 = a21;
    }

    public Agent20Bean getA20() {
        return A20;
    }

    public void setA20(Agent20Bean a20) {
        A20 = a20;
    }

    public Agent19Bean getA19() {
        return A19;
    }

    public void setA19(Agent19Bean a19) {
        A19 = a19;
    }

    public Agent18Bean getA18() {
        return A18;
    }

    public void setA18(Agent18Bean a18) {
        A18 = a18;
    }

    public Agent17Bean getA17() {
        return A17;
    }

    public Agent12Bean getA12() {
        return A12;
    }

    public void setA12(Agent12Bean a12) {
        A12 = a12;
    }

    public void setA17(Agent17Bean a17) {
        A17 = a17;
    }

    public Agent16Bean getA16() {
        return A16;
    }

    public void setA16(Agent16Bean a16) {
        A16 = a16;
    }

    public Agent15Bean getA15() {
        return A15;
    }

    public void setA15(Agent15Bean a15) {
        A15 = a15;
    }

    public Agent14Bean getA14() {
        return A14;
    }

    public void setA14(Agent14Bean a14) {
        A14 = a14;
    }

    public Agent13Bean getA13() {
        return A13;
    }

    public void setA13(Agent13Bean a13) {
        A13 = a13;
    }

    public void setA10(Agent10Bean a10) {
        A10 = a10;
    }
    public static ArrayList<ArrayList<Integer>> DelDuplicate(HashMap<Integer,ArrayList<Integer>> Group){
        HashMap<Integer,ArrayList<Integer>> newGroup=new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> newGroup2=new HashMap<Integer, ArrayList<Integer>>();

        for(int t:Group.keySet()){
            if(!newGroup.containsValue(Group.get(t)))
                newGroup.put(t,Group.get(t));
        }
        //System.out.println("first:  "+newGroup);
        for(int g:newGroup.keySet()){
            if(newGroup.get(g).size()>5 && newGroup.get(g).size()<10){
                ArrayList<Integer> n1=new ArrayList<Integer>();
                ArrayList<Integer> n2=new ArrayList<Integer>();
                for(int g1=0;g1<5;g1++)
                    n1.add(newGroup.get(g).get(g1));
                for(int g2=5;g2<newGroup.get(g).size();g2++)
                    n2.add(newGroup.get(g).get(g2));
                if(n1.size()!=0)
                    newGroup2.put(newGroup2.size(), n1);
                if(n2.size()!=0)
                    newGroup2.put(newGroup2.size(), n2);
            }
            else{
                if(newGroup.get(g).size()<=5)
                    newGroup2.put(newGroup2.size(),newGroup.get(g));
                else{
                    if(newGroup.get(g).size()==10){
                        ArrayList<Integer> n1=new ArrayList<Integer>();
                        ArrayList<Integer> n2=new ArrayList<Integer>();
                        for(int g1=0;g1<5;g1++)
                            n1.add(newGroup.get(g).get(g1));
                        for(int g2=5;g2<10;g2++)
                            n2.add(newGroup.get(g).get(g2));
                        if(n1.size()!=0)
                            newGroup2.put(newGroup2.size(),n1);
                        if(n2.size()!=0)
                            newGroup2.put(newGroup2.size(),n2);
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> newGroup1=new ArrayList<ArrayList<Integer>>();
        for(int i:newGroup2.keySet()){
            ArrayList<Integer> arrayList=new ArrayList<Integer>();
            for(int j=0;j<newGroup2.get(i).size();j++){
                boolean f=false;
                for(int k=0;k<arrayList.size();k++){
                    if(arrayList.get(k)==newGroup2.get(i).get(j)){
                        f=true;
                        break;
                    }
                }
                if(f==false)
                    arrayList.add(newGroup2.get(i).get(j));
            }
            newGroup1.add(arrayList);
        }
        return newGroup1;
    }
    @Override
    public void doStart() throws Exception {

        super.doStart();

        f0 = new PrintWriter(new FileWriter("c:\\users\\rahma\\desktop\\Graphic1\\output.txt"),true);
        IActionDescription template = new de.dailab.jiactng.agentcore.action.Action(ICommunicationBean.ACTION_SEND);
        sendAction = memory.read(template);
        if (sendAction == null) {
            sendAction = thisAgent.searchAction(template);
        }

        if (sendAction == null)
            throw new RuntimeException("Send action not found.");

        System.out.println("manam 11");

    }
    int cc=0;int old_step = -1;
    @Override
    public void execute() {
        Method methodper = null;
        int step = A1.getStep();
        try {
            methodper = this.getClass().getMethod("getA12");
            Object object = (Object) methodper.invoke(this);
            Method method1 = object.getClass().getDeclaredMethod("getAgentDescriptions1");
            this.agentDescriptions1 = (List<IAgentDescription>) method1.invoke(object);

        }catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (this.agentDescriptions1.size() >= 10 &&  A1.getStep() == A2.getStep() && A1.getStep() == A3.getStep() && A1.getStep() == A4.getStep() && A1.getStep()==A5.getStep() && A1.getStep()== A6.getStep() && A1.getStep()==A7.getStep() && A1.getStep()==A8.getStep() && A1.getStep()==A9.getStep() && A1.getStep()== A10.getStep() && step!=old_step) {

//                synchronized (this) {
//                    try {
//                        wait(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            System.out.println("step changed to "+step);
            //////////////////////////////////
            HashMap<String,String> herd_alone=new HashMap<String, String>();
            HashMap<String,String> herd_group=new HashMap<String, String>();
            HashMap<String,String> random_alone=new HashMap<String, String>();
            HashMap<String,String> random_group=new HashMap<String, String>();
            HashMap<String,String> goafter_alone=new HashMap<String, String>();
            HashMap<String,String> goafter_group=new HashMap<String, String>();

            HashMap<Integer,ArrayList<Integer>> catched=new HashMap<Integer, ArrayList<Integer>>();
            for(int p=1;p<=10;p++){
                Method method = null;
                try {
                    method = this.getClass().getMethod("getA" + p);
                    Object object = (Object) method.invoke(this);
                    Method method1 = object.getClass().getDeclaredMethod("getQ1HerdAlone");
                    Method method3 = object.getClass().getDeclaredMethod("getQ1HerdGroupCentral");
                    Method method4 = object.getClass().getDeclaredMethod("getCatched");
                    Method method5 = object.getClass().getDeclaredMethod("getQ1RandAlone");
                    Method method6 = object.getClass().getDeclaredMethod("getQ1RandGroup");
                    Method method7 = object.getClass().getDeclaredMethod("getQ1GoAfterAlone");
                    Method method8 = object.getClass().getDeclaredMethod("getQ1GoAfterGroup");
                    HashMap<String, String> Q1 = new HashMap<String, String>();
                    HashMap<String, String> Q3 = new HashMap<String, String>();
                    HashMap<String, String> Q5 = new HashMap<String, String>();
                    HashMap<String, String> Q6 = new HashMap<String, String>();
                    HashMap<String, String> Q7 = new HashMap<String, String>();
                    HashMap<String, String> Q8 = new HashMap<String, String>();
                    HashMap<Integer, ArrayList<Integer>> Q4 = new HashMap<Integer, ArrayList<Integer>>();
                    Q1 = (HashMap<String, String>) method1.invoke(object);
                    Q3 = (HashMap<String, String>) method3.invoke(object);
                    Q5 = (HashMap<String, String>) method5.invoke(object);
                    Q6 = (HashMap<String, String>) method6.invoke(object);
                    Q7 = (HashMap<String, String>) method7.invoke(object);
                    Q8 = (HashMap<String, String>) method8.invoke(object);
                    Q4 =(HashMap<Integer, ArrayList<Integer>>)method4.invoke(object);
                    for(int k1:Q4.keySet()) {
                        if (!catched.containsKey(k1))
                            catched.put(k1, Q4.get(k1));
                    }
                    for(String k1:Q1.keySet()){
                        if(!herd_alone.containsKey(k1)) {
                            String s1[]=Q1.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                herd_alone.put(k1, Q1.get(k1));
                            }
                        }
                        if(herd_alone.containsKey(k1)) {
                            String s1[]=Q1.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                String a1 = herd_alone.get(k1);
                                String a2 = Q1.get(k1);
                                String a3[] = a1.split("#");
                                String a4[] = a2.split("#");
                                double a5 = Double.parseDouble(a3[0]);
                                double a6 = Double.parseDouble(a4[0]);
                                if (a6 < a5)
                                    herd_alone.put(k1, Q1.get(k1));
                            }
                        }
                    }
                    for(String k1:Q3.keySet()){
                        if(!herd_group.containsKey(k1)) {
                            String s1[]=Q3.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                herd_group.put(k1, Q3.get(k1));
                            }
                        }
                        if(herd_group.containsKey(k1)) {
                            String s1[]=Q3.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                String a1 = herd_group.get(k1);
                                String a2 = Q3.get(k1);
                                String a3[] = a1.split("#");
                                String a4[] = a2.split("#");
                                double a5 = Double.parseDouble(a3[0]);
                                double a6 = Double.parseDouble(a4[0]);
                                if (a6 < a5)
                                    herd_group.put(k1, Q3.get(k1));
                            }
                        }
                    }
                    for(String k1:Q5.keySet()){
                        if(!random_alone.containsKey(k1)) {
                            String s1[]=Q5.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                random_alone.put(k1, Q5.get(k1));
                            }
                        }
                        if(random_alone.containsKey(k1)) {
                            String s1[]=Q5.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                String a1 = random_alone.get(k1);
                                String a2 = Q5.get(k1);
                                String a3[] = a1.split("#");
                                String a4[] = a2.split("#");
                                double a5 = Double.parseDouble(a3[0]);
                                double a6 = Double.parseDouble(a4[0]);
                                if (a6 < a5)
                                    random_alone.put(k1, Q5.get(k1));
                            }
                        }
                    }
                    for(String k1:Q6.keySet()){
                        if(!random_group.containsKey(k1)) {
                            String s1[]=Q6.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                random_group.put(k1, Q6.get(k1));
                            }
                        }
                        if(random_group.containsKey(k1)) {
                            String s1[]=Q6.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                String a1 = random_group.get(k1);
                                String a2 = Q6.get(k1);
                                String a3[] = a1.split("#");
                                String a4[] = a2.split("#");
                                double a5 = Double.parseDouble(a3[0]);
                                double a6 = Double.parseDouble(a4[0]);
                                if (a6 < a5)
                                    random_group.put(k1, Q6.get(k1));
                            }
                        }

                    }
                    for(String k1:Q7.keySet()){
                        if(!goafter_alone.containsKey(k1)) {
                            String s1[]=Q7.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                goafter_alone.put(k1, Q7.get(k1));
                            }
                        }
                        if(goafter_alone.containsKey(k1)) {
                            String s1[]=Q7.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                String a1 = goafter_alone.get(k1);
                                String a2 = Q7.get(k1);
                                String a3[] = a1.split("#");
                                String a4[] = a2.split("#");
                                double a5 = Double.parseDouble(a3[0]);
                                double a6 = Double.parseDouble(a4[0]);
                                if (a6 < a5)
                                    goafter_alone.put(k1, Q7.get(k1));
                            }
                        }
                    }
                    for(String k1:Q8.keySet()){
                        if(!goafter_group.containsKey(k1)) {
                            String s1[]=Q8.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                goafter_group.put(k1, Q8.get(k1));
                            }
                        }
                        if(goafter_group.containsKey(k1)) {
                            String s1[]=Q8.get(k1).split("#");
                            double d1=Double.parseDouble(s1[3]);
                            if(!Double.isNaN(d1)) {
                                String a1 = goafter_group.get(k1);
                                String a2 = Q8.get(k1);
                                String a3[] = a1.split("#");
                                String a4[] = a2.split("#");
                                double a5 = Double.parseDouble(a3[0]);
                                double a6 = Double.parseDouble(a4[0]);
                                if (a6 < a5)
                                    goafter_group.put(k1, Q8.get(k1));
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
            }
            //////////////////////////////
//            for(int pp=1;pp<=10;pp++){
//                Method method = null;
//                try {
//                    method = this.getClass().getMethod("getA" + pp);
//                    Object object = (Object) method.invoke(this);
//                    Method method1a = object.getClass().getDeclaredMethod("setQ1HerdAlone", HashMap.class);
//                    Method method2a = object.getClass().getDeclaredMethod("setQ1HerdGroupCentral", HashMap.class);
//                    Method method3a = object.getClass().getDeclaredMethod("setQ1GoAfterAlone", HashMap.class);
//                    Method method4a = object.getClass().getDeclaredMethod("setQ1GoAfterGroup", HashMap.class);
//                    Method method5a = object.getClass().getDeclaredMethod("setQ1RandAlone", HashMap.class);
//                    Method method6a = object.getClass().getDeclaredMethod("setQ1RandGroup", HashMap.class);
//                    method1a.invoke(object, herd_alone);
//                    method2a.invoke(object, herd_group);
//                    method3a.invoke(object, goafter_alone);
//                    method4a.invoke(object, goafter_group);
//                    method5a.invoke(object, random_alone);
//                    method6a.invoke(object, random_group);
//                    System.out.println("ha"+ herd_alone);
//                    System.out.println("hg"+ herd_alone);
//                    System.out.println("ga"+ herd_alone);
//                    System.out.println("gg"+ herd_alone);
//                    System.out.println("ra"+ herd_alone);
//                    System.out.println("rg"+ herd_alone);
//                    System.out.println("ha"+ herd_alone);
//                    System.out.println("ha"+ herd_alone);
//                    System.out.println("step:" + step+" transfer shod vase a"+pp);
//                    ////////////
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("herd alone is: "+herd_alone);
//            System.out.println("goafter alone is: "+goafter_alone);
            //////////////////////////////////

            HashMap<Integer,ArrayList<Integer>> Group = new HashMap<Integer, ArrayList<Integer>>();int ic=1;
            HashMap<Integer,Integer> num=new HashMap<Integer, Integer>();
            ////////////////////
            /*boolean fgaurd=false;
            for(int i=1;i<=10;i++){
                Method method = null;
                try {
                    method = this.getClass().getMethod("getA" + i);
                    Object object = (Object) method.invoke(this);
                    Method method1 = object.getClass().getMethod("getGaurd");
                    int gaurd = (Integer) method1.invoke(object);
                    if (gaurd == 1){
                        ////////////////////
                        fgaurd=true;
                        break;
                        ////////////////////

                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            /////////////
            /////////////
            if(fgaurd==false){
                for(int i=1;i<=10;i++) {
                    Method method = null;
                    try {
                        method = this.getClass().getMethod("getA" + i);
                        Object object = (Object) method.invoke(this);
                        Method method1 = object.getClass().getMethod("getPosX");
                        Method method2 = object.getClass().getMethod("getPosY");
                        int posx = (Integer) method1.invoke(object);
                        int posy = (Integer) method2.invoke(object);
                        if(Math.sqrt((posx-48)*(posx-48)+(posy-36)*(posy-36))<=5){
                            /////////
                            Method method6xx = object.getClass().getDeclaredMethod("setGaurd", int.class);
                            method6xx.invoke(object, 1);
                            System.out.println("Agent"+i+"isssssssssssssssssss aaaaaaaaaaaaaaa gaurdddddddddd");
                            f0.println("Agent"+i+"isssssssssssssssssss aaaaaaaaaaaaaaa gaurdddddddddd");f0.flush();
                            break;
                            /////////
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }*/
            //////////////////////
            for(int y=1;y<=10;y++)
                num.put(y, 1);
            while(ic<=10) {
                if (num.get(ic) != 0){
                    int posx = 0;
                int posy = 0;
                ArrayList<Integer> m = new ArrayList<Integer>();
                m.add(m.size(), ic);
                num.put(ic, 0);
                Method method = null;
                try {
                    method = this.getClass().getMethod("getA" + ic);
                    Object object = (Object) method.invoke(this);
                    Method method1 = object.getClass().getMethod("getPosX");
                    Method method2 = object.getClass().getMethod("getPosY");
                    posx = (Integer) method1.invoke(object);
                    posy = (Integer) method2.invoke(object);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                for (int j = ic + 1; j <= 10; j++) {
                    Method method1 = null;
                    try {
                        method1 = this.getClass().getMethod("getA" + j);
                        Object object = (Object) method1.invoke(this);
                        Method method11 = object.getClass().getMethod("getPosX");
                        Method method21 = object.getClass().getMethod("getPosY");
                        int posx1 = (Integer) method11.invoke(object);
                        int posy1 = (Integer) method21.invoke(object);
                        if (Math.sqrt((posx - posx1) * (posx - posx1) + (posy - posy1) * (posy - posy1)) <= 6 && num.get(j)!=0) {
                            m.add(m.size(), j);
                            num.put(j, 0);
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }


                }
                Group.put(Group.size(),m);
            }
            ic++;

            }
            ArrayList<ArrayList<Integer>>G=new ArrayList<ArrayList<Integer>>();
            G= DelDuplicate(Group);
            /*ArrayList<Integer> mx1=new ArrayList<Integer>();mx1.add(0,1);
            ArrayList<Integer> mx2=new ArrayList<Integer>();mx2.add(0,2);
            ArrayList<Integer> mx3=new ArrayList<Integer>();mx3.add(0,3);
            ArrayList<Integer> mx4=new ArrayList<Integer>();mx4.add(0,4);
            ArrayList<Integer> mx5=new ArrayList<Integer>();mx5.add(0,5);
            ArrayList<Integer> mx6=new ArrayList<Integer>();mx6.add(0,6);
            ArrayList<Integer> mx7=new ArrayList<Integer>();mx7.add(0,7);
            ArrayList<Integer> mx8=new ArrayList<Integer>();mx8.add(0,8);
            ArrayList<Integer> mx9=new ArrayList<Integer>();mx9.add(0,9);
            ArrayList<Integer> mx10=new ArrayList<Integer>();mx10.add(0,10);
            G.add(0,mx1);
            G.add(1,mx2);
            G.add(2,mx3);
            G.add(3,mx4);
            G.add(4,mx5);
            G.add(5,mx6);
            G.add(6,mx7);
            G.add(7,mx8);
            G.add(8,mx9);
            G.add(9,mx10);*/
//            System.out.println(G);
            f0.println(A1.getStep());
            f0.println(G);
            f0.println("///////////////////////////////////////////////////////////");
                System.out.println(step);


            for (IAgentDescription agent : this.agentDescriptions1) {
                for (int itr = 0; itr < G.size(); itr++) {
                    String n = "";
                    if (G.get(itr).size() > 1) {
                        for (int i = 1; i < G.get(itr).size(); i++) {
                            n += G.get(itr).get(i) + "&";
                        }
                    }
                    if (n != "") {
                        n = n.substring(0, n.length() - 1);
                    }
                    A1.setIu(0);
                    A2.setIu(0);
                    A3.setIu(0);
                    A4.setIu(0);
                    A5.setIu(0);
                    A6.setIu(0);
                    A7.setIu(0);
                    A8.setIu(0);
                    A9.setIu(0);
                    A10.setIu(0);
                    if (n != "") {
                        for (int i = 1; i < G.get(itr).size(); i++) {

                            if (agent.getName().equals("Agent" + G.get(itr).get(i))) {
                                int cnt = 0;
                                while (cnt < 1) {
                                    /////////////
                                    Method method = null;
                                    try {
                                        method = this.getClass().getMethod("getA" + G.get(itr).get(i));
                                        Object object = (Object) method.invoke(this);
                                        Method method1 = object.getClass().getMethod("getStep");
                                        int st = (Integer) method1.invoke(object);
                                        //if(iu!=1) {
                                        JiacMessage message = new JiacMessage((new HerdGroup("WFAC")));
                                        IMessageBoxAddress receiver = agent.getMessageBoxAddress();
                                        System.out.println("Agent11 sending herd group to: " + agent.getName() + " at step " + (st) + " with value WFAC");
                                        invoke(sendAction, new Serializable[]{message, receiver});
                                        //////////////
                                        Method method1o = object.getClass().getDeclaredMethod("getQ1HerdAlone");
                                        Method method3o = object.getClass().getDeclaredMethod("getQ1HerdGroupCentral");
                                        Method method4o = object.getClass().getDeclaredMethod("getCatched");
                                        Method method5o = object.getClass().getDeclaredMethod("getQ1RandAlone");
                                        Method method6o = object.getClass().getDeclaredMethod("getQ1RandGroup");
                                        Method method7o = object.getClass().getDeclaredMethod("getQ1GoAfterAlone");
                                        Method method8o = object.getClass().getDeclaredMethod("getQ1GoAfterGroup");
                                        HashMap<String, String> Q1 = new HashMap<String, String>();
                                        HashMap<String, String> Q3 = new HashMap<String, String>();
                                        HashMap<String, String> Q5 = new HashMap<String, String>();
                                        HashMap<String, String> Q6 = new HashMap<String, String>();
                                        HashMap<String, String> Q7 = new HashMap<String, String>();
                                        HashMap<String, String> Q8 = new HashMap<String, String>();
                                        HashMap<Integer, ArrayList<Integer>> Q4 = new HashMap<Integer, ArrayList<Integer>>();
                                        Q1 = (HashMap<String, String>) method1o.invoke(object);
                                        Q3 = (HashMap<String, String>) method3o.invoke(object);
                                        Q5 = (HashMap<String, String>) method5o.invoke(object);
                                        Q6 = (HashMap<String, String>) method6o.invoke(object);
                                        Q7 = (HashMap<String, String>) method7o.invoke(object);
                                        Q8 = (HashMap<String, String>) method8o.invoke(object);
                                        Q4 =(HashMap<Integer, ArrayList<Integer>>)method4o.invoke(object);
                                        /////////////////////////////////
                                        Method method1x = object.getClass().getDeclaredMethod("setH1", HashMap.class);
                                        Method method3x = object.getClass().getDeclaredMethod("setH3", HashMap.class);
                                        Method method4x = object.getClass().getDeclaredMethod("setH4", HashMap.class);
                                        Method method5x = object.getClass().getDeclaredMethod("setH5", HashMap.class);
                                        Method method6x = object.getClass().getDeclaredMethod("setH6", HashMap.class);
                                        Method method7x = object.getClass().getDeclaredMethod("setH7", HashMap.class);
                                        Method method8x = object.getClass().getDeclaredMethod("setH8", HashMap.class);
                                        method1x.invoke(object,herd_alone);
                                        method3x.invoke(object, herd_group);
                                        method4x.invoke(object, catched);
                                        method5x.invoke(object, random_alone);
                                        method6x.invoke(object, random_group);
                                        method7x.invoke(object, goafter_alone);
                                        method8x.invoke(object, goafter_group);
                                        System.out.println("I am Agent11 setting qtables");
                                        //////////////
                                        //}
                                        //else
                                        //  break;
                                    } catch (NoSuchMethodException e) {
                                        e.printStackTrace();
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                    ////////////
                                    cnt++;
                                }
                            }
                        }
                    }
                    if (agent.getName().equals("Agent" + G.get(itr).get(0))) {
                        int cnt = 0;
                        while (cnt < 1) {
                            /////////////
                            Method method = null;
                            try {
                                method = this.getClass().getMethod("getA" + G.get(itr).get(0));
                                Object object = (Object) method.invoke(this);
                                Method method1 = object.getClass().getMethod("getStep");
                                int st = (Integer) method1.invoke(object);
                                //if(iu!=1) {
                                JiacMessage message = new JiacMessage((new HerdGroup(n)));
                                IMessageBoxAddress receiver = agent.getMessageBoxAddress();
                                System.out.println("Agent11 sending herd group to: " + agent.getName() + " at step " + (st) + " with value " + n);
                                invoke(sendAction, new Serializable[]{message, receiver});
                                //////////////
                                //////////////
                                Method method1o = object.getClass().getDeclaredMethod("getQ1HerdAlone");
                                Method method3o = object.getClass().getDeclaredMethod("getQ1HerdGroupCentral");
                                Method method4o = object.getClass().getDeclaredMethod("getCatched");
                                Method method5o = object.getClass().getDeclaredMethod("getQ1RandAlone");
                                Method method6o = object.getClass().getDeclaredMethod("getQ1RandGroup");
                                Method method7o = object.getClass().getDeclaredMethod("getQ1GoAfterAlone");
                                Method method8o = object.getClass().getDeclaredMethod("getQ1GoAfterGroup");
                                HashMap<String, String> Q1 = new HashMap<String, String>();
                                HashMap<String, String> Q3 = new HashMap<String, String>();
                                HashMap<String, String> Q5 = new HashMap<String, String>();
                                HashMap<String, String> Q6 = new HashMap<String, String>();
                                HashMap<String, String> Q7 = new HashMap<String, String>();
                                HashMap<String, String> Q8 = new HashMap<String, String>();
                                HashMap<Integer, ArrayList<Integer>> Q4 = new HashMap<Integer, ArrayList<Integer>>();
                                Q1 = (HashMap<String, String>) method1o.invoke(object);
                                Q3 = (HashMap<String, String>) method3o.invoke(object);
                                Q5 = (HashMap<String, String>) method5o.invoke(object);
                                Q6 = (HashMap<String, String>) method6o.invoke(object);
                                Q7 = (HashMap<String, String>) method7o.invoke(object);
                                Q8 = (HashMap<String, String>) method8o.invoke(object);
                                Q4 =(HashMap<Integer, ArrayList<Integer>>)method4o.invoke(object);
                                Method method1x = object.getClass().getDeclaredMethod("setH1", HashMap.class);
                                Method method3x = object.getClass().getDeclaredMethod("setH3", HashMap.class);
                                Method method4x = object.getClass().getDeclaredMethod("setH4", HashMap.class);
                                Method method5x = object.getClass().getDeclaredMethod("setH5", HashMap.class);
                                Method method6x = object.getClass().getDeclaredMethod("setH6", HashMap.class);
                                Method method7x = object.getClass().getDeclaredMethod("setH7", HashMap.class);
                                Method method8x = object.getClass().getDeclaredMethod("setH8", HashMap.class);
                                method1x.invoke(object, Q1);
                                method3x.invoke(object, Q3);
                                method4x.invoke(object, catched);
                                method5x.invoke(object, Q5);
                                method6x.invoke(object, Q6);
                                method7x.invoke(object, Q7);
                                method8x.invoke(object, Q8);
                                System.out.println("I am Agent11 setting qtables");
                                //////////////
                                //}
                                //else
                                //break;
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            ////////////
                            cnt++;
                        }
                    }
                }

            }
            ////////////////////
//            List<IAgentDescription> agentDescriptions2 = thisAgent
//                    .searchAllAgents(new AgentDescription());
//            A13.iu=0;
//            A14.iu=0;
//            A15.iu=0;
//            A16.iu=0;
//            A17.iu=0;
//            A18.iu=0;
//            A19.iu=0;
//            A20.iu=0;
//            A21.iu=0;
//            A22.iu=0;
//            for (IAgentDescription agent : this.agentDescriptions1) {
//                for (int itr = 13; itr <=22 ; itr++) {
//                    ////////////////
//                    if (agent.getName().equals("Agent" + itr)) {
//                        /////////////
//                        Method method = null;
//                        try {
//                            method = this.getClass().getMethod("getA" + itr);
//                            Object object = (Object) method.invoke(this);
//                            Method method1 = object.getClass().getMethod("getStep");
//                            int st = (Integer) method1.invoke(object);
//                            //if(iu!=1) {
//                            JiacMessage message = new JiacMessage((new HerdGroup("")));
//                            IMessageBoxAddress receiver = agent.getMessageBoxAddress();
//                            System.out.println("Agent11 sending herd group to: " + agent.getName() + " at step " + (st) + " with value " + "khali");
//                            invoke(sendAction, new Serializable[]{message, receiver});
//                        } catch (InvocationTargetException e) {
//                            e.printStackTrace();
//                        } catch (NoSuchMethodException e) {
//                            e.printStackTrace();
//                        } catch (IllegalAccessException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    ////////////////
//                }
//                }
            ///////////////////
            old_step = step;
            f0.flush();
            System.out.println("h4 is :"+catched+"   "+catched.size());
        }
        cc++;
    }
}
