package massim.demoAgents;

import de.dailab.jiactng.agentcore.AbstractAgentBean;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mahnoosh on 12/4/2016.
 */
public class WriterBean extends AbstractAgentBean {
    static String s1="";
    static String s2="";
    static String s3="";
    static String s4="";
    static String s5="";
    static String s6="";
    static String s7="";
    static String s8="";
    static String s9="";
    static String s10="";
    static String s11="";
    static String s12="";
    static String s13="";
    static String s14="";
    static String s15="";
    static String s16="";
    static String s17="";
    static String s18="";
    static String s19="";
    static String s20="";
    JFrame frame=new JFrame(); //creates frame
    JButton[][] grid; //names the grid of buttons
    public Agent2Bean getA2() {
        return A2;
    }
    public void setA2(Agent2Bean a2) {
        A2 = a2;
    }
    public Agent1Bean getA1() {
        return A1;
    }
    public void setA1(Agent1Bean a1) {
        A1 = a1;
    }
    Agent1Bean A1=new Agent1Bean();
    Agent2Bean A2=new Agent2Bean();
    Agent3Bean A3=new Agent3Bean();
    Agent4Bean A4=new Agent4Bean();
    Agent5Bean A5=new Agent5Bean();
    Agent6Bean A6=new Agent6Bean();
    public Agent10Bean getA10() {
        return A10;
    }
    public void setA10(Agent10Bean a10) {
        A10 = a10;
    }
    public Agent9Bean getA9() {
        return A9;
    }
    public void setA9(Agent9Bean a9) {
        A9 = a9;
    }
    public Agent8Bean getA8() {
        return A8;
    }
    public void setA8(Agent8Bean a8) {A8 = a8;}
    public Agent7Bean getA7() {
        return A7;
    }
    public void setA7(Agent7Bean a7) {
        A7 = a7;
    }
    public Agent6Bean getA6() {
        return A6;
    }
    public void setA6(Agent6Bean a6) {
        A6 = a6;
    }
    public Agent5Bean getA5() {
        return A5;
    }
    public void setA5(Agent5Bean a5) {
        A5 = a5;
    }
    public Agent4Bean getA4() {
        return A4;
    }
    public void setA4(Agent4Bean a4) {
        A4 = a4;
    }
    public Agent3Bean getA3() {
        return A3;
    }
    public void setA3(Agent3Bean a3) {
        A3 = a3;
    }
    Agent7Bean A7=new Agent7Bean();
    Agent8Bean A8=new Agent8Bean();
    Agent9Bean A9=new Agent9Bean();

    JFrame frame1 = new JFrame ();
    Agent10Bean A10=new Agent10Bean();
    void draw(int width, int length){ //constructor
        frame.setLayout(new GridLayout(width,length)); //set layout
        grid=new JButton[width][length]; //allocate the size of grid
        for(int y=0; y<length; y++){
            for(int x=0; x<width; x++){
                grid[x][y]=new JButton(); //creates new button
                grid[x][y].setBackground(Color.gray);
                frame.add(grid[x][y]); //adds button to grid
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setVisible(true); //makes frame visible

    }

    void Draw1(){
        /*JPanel middlePanel = new JPanel ();
        JTextArea display = new JTextArea ( 100, 100 );
        middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display Area" ) );
        display.setEditable ( false ); // set textArea non-editable
        display.append(getA1().getQ());
        display.append(getA2().getQ());
        display.append(getA3().getQ());
        display.append(getA4().getQ());
        display.append(getA5().getQ());
        display.append(getA6().getQ());
        display.append(getA7().getQ());
        display.append(getA8().getQ());
        display.append(getA9().getQ());
        display.append(getA10().getQ());
        JScrollPane scroll = new JScrollPane ( display );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        middlePanel.add ( scroll );
        frame1.add ( middlePanel );
        frame1.pack ();
        frame1.setLocationRelativeTo ( null );
        frame1.setVisible (true);*/
    }

    @Override
    public void doStart() throws Exception {
        super.doStart();
        System.out.println("i am writer");
        draw(120,120);
        for(int i=25;i<=48;i++){
            for(int j=25;j<=48;j++){
                grid[i][j].setBackground(Color.yellow);
            }
        }
        s1 = (String) getA1().getPerc1().get(0);
        s2 = (String) getA1().getPerc1().get(1);
        s3 = (String) getA2().getPerc1().get(0);
        s4 = (String) getA2().getPerc1().get(1);
        s5 = (String) getA3().getPerc1().get(0);
        s6 = (String) getA3().getPerc1().get(1);
        s7 = (String) getA4().getPerc1().get(0);
        s8 = (String) getA4().getPerc1().get(1);
        s9 = (String) getA5().getPerc1().get(0);
        s10 = (String) getA5().getPerc1().get(1);
        s11 = (String) getA6().getPerc1().get(0);
        s12= (String) getA6().getPerc1().get(1);
        s13 = (String) getA7().getPerc1().get(0);
        s14 = (String) getA7().getPerc1().get(1);
        s15 = (String) getA8().getPerc1().get(0);
        s16 = (String) getA8().getPerc1().get(1);
        s17= (String) getA9().getPerc1().get(0);
        s18 = (String) getA9().getPerc1().get(1);
        s19 = (String) getA10().getPerc1().get(0);
        s20= (String) getA10().getPerc1().get(1);
    }
    @Override
    public void execute() {
        //System.out.println(getA2().g+" "+getA2().getPerc2().get(0)+"llll");
        if(getA1().getPerc11().size()!=0) {
            for (int i = 0; i < getA1().getPerc11().size(); i++) {
                String p = (String) getA1().getPerc11().get(i);
                String[] pp = p.split("#");
                if(pp[2].equals("empty"))
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
                if(pp[2].equals("cow")) {
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
                }
            }
        }
        if(getA2().getPerc11().size()!=0) {
            for (int i = 0; i < getA2().getPerc11().size(); i++) {
                String p = (String) getA2().getPerc11().get(i);
                String[] pp = p.split("#");
                if(pp[2].equals("empty"))
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
                if(pp[2].equals("cow")) {
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);

                }
            }
        }
        if(getA3().getPerc11().size()!=0) {
            for (int i = 0; i < getA3().getPerc11().size(); i++) {
                String p = (String) getA3().getPerc11().get(i);
                String[] pp = p.split("#");
                if(pp[2].equals("empty"))
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
                if(pp[2].equals("cow")) {
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
                }
            }
        }
        if(getA4().getPerc11().size()!=0) {
            for (int i = 0; i < getA4().getPerc11().size(); i++) {
                String p = (String) getA4().getPerc11().get(i);
                String[] pp = p.split("#");
                if(pp[2].equals("empty"))
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
                if(pp[2].equals("cow")) {
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
                }
            }
        }
        if(getA5().getPerc11().size()!=0) {
            for (int i = 0; i < getA5().getPerc11().size(); i++) {
                String p = (String) getA5().getPerc11().get(i);
                String[] pp = p.split("#");
                if(pp[2].equals("empty"))
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
                if(pp[2].equals("cow")) {
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
                }
            }
        }
        if(getA6().getPerc11().size()!=0) {
            for (int i = 0; i < getA6().getPerc11().size(); i++) {
                String p = (String) getA6().getPerc11().get(i);
                String[] pp = p.split("#");
                if(pp[2].equals("empty"))
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
                if(pp[2].equals("cow")) {
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
                }
            }
        }
        if(getA7().getPerc11().size()!=0) {
            for (int i = 0; i < getA7().getPerc11().size(); i++) {
                String p = (String) getA7().getPerc11().get(i);
                String[] pp = p.split("#");
                if(pp[2].equals("empty"))
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
                if(pp[2].equals("cow")) {
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
                }
            }
        }
        if(getA8().getPerc11().size()!=0) {
            for (int i = 0; i < getA8().getPerc11().size(); i++) {
                String p = (String) getA8().getPerc11().get(i);
                String[] pp = p.split("#");
                if(pp[2].equals("empty"))
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
                if(pp[2].equals("cow")) {
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
                }
            }
        }
        if(getA9().getPerc11().size()!=0) {
            for (int i = 0; i < getA9().getPerc11().size(); i++) {
                String p = (String) getA9().getPerc11().get(i);
                String[] pp = p.split("#");
                if(pp[2].equals("empty"))
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
                if(pp[2].equals("cow")) {
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
                }
            }
        }
        if(getA10().getPerc11().size()!=0) {
            for (int i = 0; i < getA10().getPerc11().size(); i++) {
                String p = (String) getA10().getPerc11().get(i);
                String[] pp = p.split("#");
                if(pp[2].equals("empty"))
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
                if(pp[2].equals("cow")) {
                    grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
                }
            }
        }
        for(int i=2;i<getA1().getPerc1().size();i++){
            String p=(String)getA1().getPerc1().get(i);
            String []pp=p.split("#");
            if(pp[2].equals("empty"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
            if(pp[2].equals("cow")) {
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
            }
            if(pp[2].equals("obstacle"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.black);
            if(pp[2].equals("corral"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.yellow);
            if(pp[2].equals("agent") && pp[3].equals("enemy"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.blue);
        }
        ///////////////

        for(int i=2;i<getA2().getPerc1().size();i++){
            String p=(String)getA2().getPerc1().get(i);
            String []pp=p.split("#");
            if(pp[2].equals("empty"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
            if(pp[2].equals("cow"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
            if(pp[2].equals("obstacle"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.black);
            if(pp[2].equals("agent") && pp[3].equals("enemy"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.blue);
        }
        for(int i=2;i<getA3().getPerc1().size();i++){
            String p=(String)getA3().getPerc1().get(i);
            String []pp=p.split("#");
            if(pp[2].equals("empty"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
            if(pp[2].equals("cow"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
            if(pp[2].equals("obstacle"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.black);
            if(pp[2].equals("agent") && pp[3].equals("enemy"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.blue);
        }
        for(int i=2;i<getA4().getPerc1().size();i++){
            String p=(String)getA4().getPerc1().get(i);
            String []pp=p.split("#");
            if(pp[2].equals("empty"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
            if(pp[2].equals("cow"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
            if(pp[2].equals("obstacle"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.black);
            if(pp[2].equals("agent") && pp[3].equals("enemy"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.blue);
        }
        for(int i=2;i<getA5().getPerc1().size();i++){
            String p=(String)getA5().getPerc1().get(i);
            String []pp=p.split("#");
            if(pp[2].equals("empty"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
            if(pp[2].equals("cow"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
            if(pp[2].equals("obstacle"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.black);
            if(pp[2].equals("agent") && pp[3].equals("enemy"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.blue);
        }
        for(int i=2;i<getA6().getPerc1().size();i++){
            String p=(String)getA6().getPerc1().get(i);
            String []pp=p.split("#");
            if(pp[2].equals("empty"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
            if(pp[2].equals("cow"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
            if(pp[2].equals("obstacle"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.black);
            if(pp[2].equals("agent") && pp[3].equals("enemy"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.blue);
        }
        for(int i=2;i<getA7().getPerc1().size();i++){
            String p=(String)getA7().getPerc1().get(i);
            String []pp=p.split("#");
            if(pp[2].equals("empty"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
            if(pp[2].equals("cow"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
            if(pp[2].equals("obstacle"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.black);
            if(pp[2].equals("agent") && pp[3].equals("enemy"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.blue);
        }
        for(int i=2;i<getA8().getPerc1().size();i++){
            String p=(String)getA8().getPerc1().get(i);
            String []pp=p.split("#");
            if(pp[2].equals("empty"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
            if(pp[2].equals("cow"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
            if(pp[2].equals("obstacle"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.black);
            if(pp[2].equals("agent") && pp[3].equals("enemy"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.blue);
        }
        for(int i=2;i<getA9().getPerc1().size();i++){
            String p=(String)getA9().getPerc1().get(i);
            String []pp=p.split("#");
            if(pp[2].equals("empty"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
            if(pp[2].equals("cow"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
            if(pp[2].equals("obstacle"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.black);
            if(pp[2].equals("agent") && pp[3].equals("enemy"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.blue);
        }
        for(int i=2;i<getA10().getPerc1().size();i++){
            String p=(String)getA10().getPerc1().get(i);
            String []pp=p.split("#");
            if(pp[2].equals("empty"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.green);
            if(pp[2].equals("cow"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.white);
            if(pp[2].equals("obstacle"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.black);
            if(pp[2].equals("agent") && pp[3].equals("enemy"))
                grid[Integer.parseInt(pp[0])][Integer.parseInt(pp[1])].setBackground(Color.blue);
        }
// Draw1();

        try {
            while(true) {
                if (getA1().getPerc1().size()>=2 && getA1().getPerc1().get(0).equals(s1) && getA1().getPerc1().get(1).equals(s2)) {
                    // if(this.getA1().getExplore()==1)
                    grid[Integer.parseInt(s1)][Integer.parseInt(s2)].setBackground(Color.orange);
                    /*else{
                      if(this.getA1().getGoAfterAlone()==1 || this.getA1().getGoAfterGroup()==1)
                          grid[Integer.parseInt(s1)][Integer.parseInt(s2)].setBackground(Color.orange);
                        else
                          grid[Integer.parseInt(s1)][Integer.parseInt(s2)].setBackground(Color.PINK);
                    }*/
                } else{
                    grid[Integer.parseInt(s1)][Integer.parseInt(s2)].setBackground(Color.green);
                    //   System.out.println("green" + s1 + " " + s2);
                    s1 = (String) getA1().getPerc1().get(0);
                    s2 = (String) getA1().getPerc1().get(1);

                }
                if (getA2().getPerc1().size()>=2 && getA2().getPerc1().get(0).equals(s3) && getA2().getPerc1().get(1).equals(s4)) {
                    // if(this.getA1().getExplore()==1)
                    grid[Integer.parseInt(s3)][Integer.parseInt(s4)].setBackground(Color.red);
                   /* else{
                        if(this.getA1().getGoAfterAlone()==1 || this.getA1().getGoAfterGroup()==1)
                            grid[Integer.parseInt(s3)][Integer.parseInt(s4)].setBackground(Color.orange);
                        else
                            grid[Integer.parseInt(s3)][Integer.parseInt(s4)].setBackground(Color.PINK);
                    }*/

                } else {
                    grid[Integer.parseInt(s3)][Integer.parseInt(s4)].setBackground(Color.green);
                    //System.out.println("vared" + s1 + " " + s2);
                    s3 = (String) getA2().getPerc1().get(0);
                    s4 = (String) getA2().getPerc1().get(1);
                }

                if (getA3().getPerc1().size()>=2 && getA3().getPerc1().get(0).equals(s5) && getA3().getPerc1().get(1).equals(s6)) {
                    //if(this.getA1().getExplore()==1)
                    grid[Integer.parseInt(s5)][Integer.parseInt(s6)].setBackground(Color.red);
                    /*else{
                        if(this.getA1().getGoAfterAlone()==1 || this.getA1().getGoAfterGroup()==1)
                            grid[Integer.parseInt(s5)][Integer.parseInt(s6)].setBackground(Color.orange);
                        else
                            grid[Integer.parseInt(s5)][Integer.parseInt(s6)].setBackground(Color.PINK);
                    }*/
                } else {

                    grid[Integer.parseInt(s5)][Integer.parseInt(s6)].setBackground(Color.green);
                    //System.out.println("vared" + s1 + " " + s2);
                    s5 = (String) getA3().getPerc1().get(0);
                    s6 = (String) getA3().getPerc1().get(1);

                }

                if (getA4().getPerc1().size()>=2 &&getA4().getPerc1().get(0).equals(s7) && getA4().getPerc1().get(1).equals(s8)) {
                    //if(this.getA4().getExplore()==1)
                    grid[Integer.parseInt(s7)][Integer.parseInt(s8)].setBackground(Color.red);
                    /*else{
                        if(this.getA4().getExploit()==1)
                            grid[Integer.parseInt(s7)][Integer.parseInt(s8)].setBackground(Color.orange);
                        else
                            grid[Integer.parseInt(s7)][Integer.parseInt(s8)].setBackground(Color.PINK);
                    }*/

                } else {

                    grid[Integer.parseInt(s7)][Integer.parseInt(s8)].setBackground(Color.green);
                    //System.out.println("vared" + s1 + " " + s2);
                    s7 = (String) getA4().getPerc1().get(0);
                    s8 = (String) getA4().getPerc1().get(1);

                }

                if (getA5().getPerc1().size()>=2 &&getA5().getPerc1().get(0).equals(s9) && getA5().getPerc1().get(1).equals(s10)) {
                    //if(this.getA5().getExplore()==1)
                    grid[Integer.parseInt(s9)][Integer.parseInt(s10)].setBackground(Color.red);
                    /*else{
                        if(this.getA5().getExploit()==1)
                            grid[Integer.parseInt(s9)][Integer.parseInt(s10)].setBackground(Color.orange);
                        else
                            grid[Integer.parseInt(s9)][Integer.parseInt(s10)].setBackground(Color.PINK);
                    }*/

                } else {

                    grid[Integer.parseInt(s9)][Integer.parseInt(s10)].setBackground(Color.green);
                    //System.out.println("vared" + s1 + " " + s2);
                    s9 = (String) getA5().getPerc1().get(0);
                    s10 = (String) getA5().getPerc1().get(1);

                }

                if (getA6().getPerc1().size()>=2 &&getA6().getPerc1().get(0).equals(s11) && getA6().getPerc1().get(1).equals(s12)) {
                    //if(this.getA6().getExplore()==1)
                    grid[Integer.parseInt(s11)][Integer.parseInt(s12)].setBackground(Color.red);
                    /*else{
                        if(this.getA6().getExploit()==1)
                            grid[Integer.parseInt(s11)][Integer.parseInt(s12)].setBackground(Color.orange);
                        else
                            grid[Integer.parseInt(s11)][Integer.parseInt(s12)].setBackground(Color.PINK);
                    }*/

                } else {

                    grid[Integer.parseInt(s11)][Integer.parseInt(s12)].setBackground(Color.green);
                    //System.out.println("vared" + s1 + " " + s2);
                    s11 = (String) getA6().getPerc1().get(0);
                    s12 = (String) getA6().getPerc1().get(1);

                }

                if (getA7().getPerc1().size()>=2 &&getA7().getPerc1().get(0).equals(s13) && getA7().getPerc1().get(1).equals(s14)) {
                    // if(this.getA7().getExplore()==1)
                    grid[Integer.parseInt(s13)][Integer.parseInt(s14)].setBackground(Color.red);
                    /*else{
                        if(this.getA7().getExploit()==1)
                            grid[Integer.parseInt(s13)][Integer.parseInt(s14)].setBackground(Color.orange);
                        else
                            grid[Integer.parseInt(s13)][Integer.parseInt(s14)].setBackground(Color.PINK);
                    }*/

                } else {

                    grid[Integer.parseInt(s13)][Integer.parseInt(s14)].setBackground(Color.green);
                    //System.out.println("vared" + s1 + " " + s2);
                    s13 = (String) getA7().getPerc1().get(0);
                    s14 = (String) getA7().getPerc1().get(1);

                }

                if (getA8().getPerc1().size()>=2 &&getA8().getPerc1().get(0).equals(s15) && getA8().getPerc1().get(1).equals(s16)) {
                    //if(this.getA8().getExplore()==1)
                    grid[Integer.parseInt(s15)][Integer.parseInt(s16)].setBackground(Color.red);
                    /*else{
                        if(this.getA8().getExploit()==1)
                            grid[Integer.parseInt(s15)][Integer.parseInt(s16)].setBackground(Color.orange);
                        else
                            grid[Integer.parseInt(s15)][Integer.parseInt(s16)].setBackground(Color.PINK);
                    }*/

                } else {

                    grid[Integer.parseInt(s15)][Integer.parseInt(s16)].setBackground(Color.green);
                    //System.out.println("vared" + s1 + " " + s2);
                    s15 = (String) getA8().getPerc1().get(0);
                    s16 = (String) getA8().getPerc1().get(1);

                }

                if (getA9().getPerc1().size()>=2 &&getA9().getPerc1().get(0).equals(s17) && getA9().getPerc1().get(1).equals(s18)) {
                    // if(this.getA9().getExplore()==1)
                    grid[Integer.parseInt(s17)][Integer.parseInt(s18)].setBackground(Color.red);
                   /* else{
                        if(this.getA9().getExploit()==1)
                            grid[Integer.parseInt(s17)][Integer.parseInt(s18)].setBackground(Color.orange);
                        else
                            grid[Integer.parseInt(s17)][Integer.parseInt(s18)].setBackground(Color.PINK);
                    }*/

                } else {

                    grid[Integer.parseInt(s17)][Integer.parseInt(s18)].setBackground(Color.green);
                    //System.out.println("vared" + s1 + " " + s2);
                    s17 = (String) getA9().getPerc1().get(0);
                    s18 = (String) getA9().getPerc1().get(1);

                }


                if (getA10().getPerc1().size()>=2 &&getA10().getPerc1().get(0).equals(s19) && getA10().getPerc1().get(1).equals(s20)) {
                    //if(this.getA10().getExplore()==1)
                    grid[Integer.parseInt(s19)][Integer.parseInt(s20)].setBackground(Color.red);
                    /*else{
                        if(this.getA10().getExploit()==1)
                            grid[Integer.parseInt(s19)][Integer.parseInt(s20)].setBackground(Color.orange);
                        else
                            grid[Integer.parseInt(s19)][Integer.parseInt(s20)].setBackground(Color.PINK);
                    }*/

                } else {

                    grid[Integer.parseInt(s19)][Integer.parseInt(s20)].setBackground(Color.green);
                    //System.out.println("vared" + s1 + " " + s2);
                    s19 = (String) getA10().getPerc1().get(0);
                    s20 = (String) getA10().getPerc1().get(1);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
