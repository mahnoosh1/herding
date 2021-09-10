package massim.demoAgents;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mahnoosh on 9/19/2017.
 */
public class HT {
    static JFrame frame=new JFrame(); //creates frame
    static JButton[][] grid; //names the grid of buttons
    ///////////////////////////
    static BufferedReader br1 = null;
    static FileReader fr1 = null;
    ///////////////////////////
    static BufferedReader br2 = null;
    static FileReader fr2 = null;
    ///////////////////////////
    static BufferedReader br3 = null;
    static FileReader fr3 = null;
    ///////////////////////////
    static BufferedReader br4 = null;
    static FileReader fr4 = null;
    ///////////////////////////
    static BufferedReader br5 = null;
    static FileReader fr5 = null;
    ///////////////////////////
    static BufferedReader br6 = null;
    static FileReader fr6= null;
    ///////////////////////////
    static BufferedReader br7 = null;
    static FileReader fr7 = null;
    ///////////////////////////
    static BufferedReader br8 = null;
    static FileReader fr8 = null;
    ///////////////////////////
    static BufferedReader br9 = null;
    static FileReader fr9 = null;
    ///////////////////////////
    static BufferedReader br10 = null;
    static FileReader fr10 = null;
    static HashMap<Integer,String> c=new HashMap<Integer, String>();
    public HT(){}
    public  void draw(int width, int length){ //constructor
        frame.setLayout(new GridLayout(width,length)); //set layout
        grid=new JButton[width][length]; //allocate the size of grid
        for(int y=0; y<length; y++){
            for(int x=0; x<width; x++){
                JButton btn=new JButton();
                btn.setPreferredSize(new Dimension(2, 2));
                grid[x][y]=btn;
                grid[x][y].setBackground(Color.gray);
                frame.add(grid[x][y]); //adds button to grid
            }
        }
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                grid[i][j].setBackground(Color.darkGray);
            }
        }
        for(int i=25;i<=48;i++){
            for(int j=25;j<=48;j++){
                grid[i][j].setBackground(Color.yellow);
            }
        }
        for(int i=50;i<=73;i++){
            for(int j=50;j<=73;j++){
                grid[i][j].setBackground(Color.lightGray);
            }
        }
        grid[0][0].setBackground(Color.PINK);
        grid[0][100].setBackground(Color.PINK);
        grid[100][0].setBackground(Color.PINK);
        grid[100][100].setBackground(Color.PINK);
        /////////////////////////////
        try {
            /////////////////////////////////////////////////////////////////////////
            fr1 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\Q5\\Agent1.txt");
            br1 = new BufferedReader(fr1);
            String sCurrentLine1;
            ////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////
            fr2 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\Q5\\Agent2.txt");
            br2 = new BufferedReader(fr2);
            String sCurrentLine2;
            ////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////
            fr3 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\Q5\\Agent3.txt");
            br3 = new BufferedReader(fr3);
            String sCurrentLine3;
            ////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////
            fr4 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\Q5\\Agent4.txt");
            br4 = new BufferedReader(fr4);
            String sCurrentLine4;
            ////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////
            fr5 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\Q5\\Agent5.txt");
            br5 = new BufferedReader(fr5);
            String sCurrentLine5;
            ////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////
            fr6 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\Q5\\Agent6.txt");
            br6 = new BufferedReader(fr6);
            String sCurrentLine6;
            ////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////
            fr7 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\Q5\\Agent7.txt");
            br7 = new BufferedReader(fr7);
            String sCurrentLine7;
            ////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////
            fr8 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\Q5\\Agent8.txt");
            br8 = new BufferedReader(fr8);
            String sCurrentLine8;
            ////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////
            fr9 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\Q5\\Agent9.txt");
            br9 = new BufferedReader(fr9);
            String sCurrentLine9;
            ////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////
            fr10 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\Q5\\Agent10.txt");
            br10 = new BufferedReader(fr10);
            String sCurrentLine10;
            ////////////////////////////////////////////////////////////////////////
            int y=0;ArrayList<Integer> count1=new ArrayList<Integer>();ArrayList<Integer> count2=new ArrayList<Integer>();int count3=0;int count4=0;
            while ((sCurrentLine1 = br1.readLine()) != null) {
                //////////////////////
                for(int i=25;i<=48;i++){
                    for(int j=25;j<=48;j++){
                        grid[i][j].setBackground(Color.yellow);
                    }
                }
                for(int i=50;i<=73;i++){
                    for(int j=50;j<=73;j++){
                        grid[i][j].setBackground(Color.lightGray);
                    }
                }

                ////////////////////////////////
                sCurrentLine2=br2.readLine();
                sCurrentLine3=br3.readLine();
                sCurrentLine4=br4.readLine();
                sCurrentLine5=br5.readLine();
                sCurrentLine6=br6.readLine();
                sCurrentLine7=br7.readLine();
                sCurrentLine8=br8.readLine();
                sCurrentLine9=br9.readLine();
                sCurrentLine10=br10.readLine();

                /////////////////////
                String split1[]=sCurrentLine1.split("&");
                String split2[]=split1[0].split("#");
                String split3[]=sCurrentLine2.split("&");
                String split4[]=split3[0].split("#");
                String split5[]=sCurrentLine3.split("&");
                String split6[]=split5[0].split("#");
                String split7[]=sCurrentLine4.split("&");
                String split8[]=split7[0].split("#");
                String split9[]=sCurrentLine5.split("&");
                String split10[]=split9[0].split("#");
                String split11[]=sCurrentLine6.split("&");
                String split12[]=split11[0].split("#");
                String split13[]=sCurrentLine7.split("&");
                String split14[]=split13[0].split("#");
                String split15[]=sCurrentLine8.split("&");
                String split16[]=split15[0].split("#");
                String split17[]=sCurrentLine9.split("&");
                String split18[]=split17[0].split("#");
                String split19[]=sCurrentLine10.split("&");
                String split20[]=split19[0].split("#");
                //////////////////////////////////
                if(split2.length==3 && split2[2].equals("gaurd")){
                    grid[Integer.parseInt(split2[0])][Integer.parseInt(split2[1])].setBackground(Color.orange);
                }
                else {
                    grid[Integer.parseInt(split2[0])][Integer.parseInt(split2[1])].setBackground(Color.red);
                }
                if(split4.length==3 && split4[2].equals("gaurd"))
                    grid[Integer.parseInt(split4[0])][Integer.parseInt(split4[1])].setBackground(Color.orange);
                else
                    grid[Integer.parseInt(split4[0])][Integer.parseInt(split4[1])].setBackground(Color.red);
                if(split6.length==3 && split6[2].equals("gaurd"))
                    grid[Integer.parseInt(split6[0])][Integer.parseInt(split6[1])].setBackground(Color.orange);
                else
                    grid[Integer.parseInt(split6[0])][Integer.parseInt(split6[1])].setBackground(Color.red);
                if(split8.length==3 && split8[2].equals("gaurd"))
                    grid[Integer.parseInt(split8[0])][Integer.parseInt(split8[1])].setBackground(Color.orange);
                else
                    grid[Integer.parseInt(split8[0])][Integer.parseInt(split8[1])].setBackground(Color.red);
                if(split10.length==3 && split10[2].equals("gaurd"))
                    grid[Integer.parseInt(split10[0])][Integer.parseInt(split10[1])].setBackground(Color.orange);
                else
                    grid[Integer.parseInt(split10[0])][Integer.parseInt(split10[1])].setBackground(Color.red);
                if(split12.length==3 && split12[2].equals("gaurd"))
                    grid[Integer.parseInt(split12[0])][Integer.parseInt(split12[1])].setBackground(Color.orange);
                else
                    grid[Integer.parseInt(split12[0])][Integer.parseInt(split12[1])].setBackground(Color.red);
                if(split14.length==3 && split14[2].equals("gaurd"))
                    grid[Integer.parseInt(split14[0])][Integer.parseInt(split14[1])].setBackground(Color.orange);
                else
                    grid[Integer.parseInt(split14[0])][Integer.parseInt(split14[1])].setBackground(Color.red);
                if(split16.length==3 && split16[2].equals("gaurd"))
                    grid[Integer.parseInt(split16[0])][Integer.parseInt(split16[1])].setBackground(Color.orange);
                else
                    grid[Integer.parseInt(split16[0])][Integer.parseInt(split16[1])].setBackground(Color.red);
                if(split18.length==3 && split18[2].equals("gaurd"))
                    grid[Integer.parseInt(split18[0])][Integer.parseInt(split18[1])].setBackground(Color.orange);
                else
                    grid[Integer.parseInt(split18[0])][Integer.parseInt(split18[1])].setBackground(Color.red);
                if(split20.length==3 && split20[2].equals("gaurd"))
                    grid[Integer.parseInt(split20[0])][Integer.parseInt(split20[1])].setBackground(Color.orange);
                else
                    grid[Integer.parseInt(split20[0])][Integer.parseInt(split20[1])].setBackground(Color.red);
                ///////////////////////////////////////////////////////////////////////////////////
                HashMap<Integer,ArrayList<Integer>> n1=new HashMap<Integer, ArrayList<Integer>>();
                HashMap<Integer,ArrayList<Integer>> n2=new HashMap<Integer, ArrayList<Integer>>();
                HashMap<Integer,ArrayList<Integer>> n3=new HashMap<Integer, ArrayList<Integer>>();
                HashMap<Integer,ArrayList<Integer>> n4=new HashMap<Integer, ArrayList<Integer>>();
                HashMap<Integer,ArrayList<Integer>> n5=new HashMap<Integer, ArrayList<Integer>>();
                HashMap<Integer,ArrayList<Integer>> n6=new HashMap<Integer, ArrayList<Integer>>();
                HashMap<Integer,ArrayList<Integer>> n7=new HashMap<Integer, ArrayList<Integer>>();
                HashMap<Integer,ArrayList<Integer>> n8=new HashMap<Integer, ArrayList<Integer>>();
                HashMap<Integer,ArrayList<Integer>> n9=new HashMap<Integer, ArrayList<Integer>>();
                HashMap<Integer,ArrayList<Integer>> n10=new HashMap<Integer, ArrayList<Integer>>();

                for(int i=1;i<split1.length;i++){
                    String split30[]=split1[i].split("#");
                    if(split30.length>=3) {
                        if (split30[2].equals("empty"))
                            grid[Integer.parseInt(split30[0])][Integer.parseInt(split30[1])].setBackground(Color.green);
                        if (split30[2].equals("obstacle"))
                            grid[Integer.parseInt(split30[0])][Integer.parseInt(split30[1])].setBackground(Color.black);
                        if (split30.length == 4 && split30[3].equals("enemy")){
                            grid[Integer.parseInt(split30[0])][Integer.parseInt(split30[1])].setBackground(Color.blue);
                            ArrayList<Integer> n20=new ArrayList<Integer>();n20.add(0,Integer.parseInt(split30[0]));n20.add(1,Integer.parseInt(split30[1]));
                            n1.put(0, n20);
                        }
                        if (split30[2].equals("cow") && !c.containsKey(split30[3]))
                            grid[Integer.parseInt(split30[0])][Integer.parseInt(split30[1])].setBackground(Color.white);
                        if (split30[2].equals("catch")) {
                            if(!c.containsKey(Integer.parseInt(split30[3])))
                                count3++;
                            grid[Integer.parseInt(split30[0])][Integer.parseInt(split30[1])].setBackground(Color.PINK);
                            c.put(Integer.parseInt(split30[3]),"");
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////
                for(int i=1;i<split3.length;i++){
                    String split31[]=split3[i].split("#");
                    if(split31.length>=3) {
                        if (split31[2].equals("empty"))
                            grid[Integer.parseInt(split31[0])][Integer.parseInt(split31[1])].setBackground(Color.green);
                        if (split31[2].equals("obstacle"))
                            grid[Integer.parseInt(split31[0])][Integer.parseInt(split31[1])].setBackground(Color.black);
                        if (split31.length == 4 && split31[3].equals("enemy")){
                            grid[Integer.parseInt(split31[0])][Integer.parseInt(split31[1])].setBackground(Color.blue);
                            ArrayList<Integer> n20=new ArrayList<Integer>();n20.add(0,Integer.parseInt(split31[0]));n20.add(1,Integer.parseInt(split31[1]));
                            n2.put(0, n20);
                        }
                        if (split31[2].equals("cow")&& !c.containsKey(split31[3]))
                            grid[Integer.parseInt(split31[0])][Integer.parseInt(split31[1])].setBackground(Color.white);
                        if (split31[2].equals("catch")) {
                            if(!c.containsKey(Integer.parseInt(split31[3])))
                                count3++;
                            grid[Integer.parseInt(split31[0])][Integer.parseInt(split31[1])].setBackground(Color.PINK);
                            c.put(Integer.parseInt(split31[3]),"");
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////
                for(int i=1;i<split5.length;i++){
                    String split32[]=split5[i].split("#");
                    if(split32.length>=3) {
                        if (split32[2].equals("empty"))
                            grid[Integer.parseInt(split32[0])][Integer.parseInt(split32[1])].setBackground(Color.green);
                        if (split32[2].equals("obstacle"))
                            grid[Integer.parseInt(split32[0])][Integer.parseInt(split32[1])].setBackground(Color.black);
                        if (split32.length == 4 && split32[3].equals("enemy")){
                            grid[Integer.parseInt(split32[0])][Integer.parseInt(split32[1])].setBackground(Color.blue);
                            ArrayList<Integer> n20=new ArrayList<Integer>();n20.add(0,Integer.parseInt(split32[0]));n20.add(1,Integer.parseInt(split32[1]));
                            n3.put(0, n20);
                        }
                        if (split32[2].equals("cow") && !c.containsKey(split32[3]))
                            grid[Integer.parseInt(split32[0])][Integer.parseInt(split32[1])].setBackground(Color.white);
                        if (split32[2].equals("catch")) {
                            if(!c.containsKey(Integer.parseInt(split32[3])))
                                count3++;
                            grid[Integer.parseInt(split32[0])][Integer.parseInt(split32[1])].setBackground(Color.PINK);
                            c.put(Integer.parseInt(split32[3]),"");
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////
                for(int i=1;i<split7.length;i++){
                    String split33[]=split7[i].split("#");
                    if(split33.length>=3) {
                        if (split33[2].equals("empty"))
                            grid[Integer.parseInt(split33[0])][Integer.parseInt(split33[1])].setBackground(Color.green);
                        if (split33[2].equals("obstacle"))
                            grid[Integer.parseInt(split33[0])][Integer.parseInt(split33[1])].setBackground(Color.black);
                        if (split33.length == 4 && split33[3].equals("enemy")){
                            grid[Integer.parseInt(split33[0])][Integer.parseInt(split33[1])].setBackground(Color.blue);
                            ArrayList<Integer> n20=new ArrayList<Integer>();n20.add(0,Integer.parseInt(split33[0]));n20.add(1,Integer.parseInt(split33[1]));
                            n4.put(0, n20);
                        }
                        if (split33[2].equals("cow") && !c.containsKey(split33[3]))
                            grid[Integer.parseInt(split33[0])][Integer.parseInt(split33[1])].setBackground(Color.white);
                        if (split33[2].equals("catch")) {
                            if(!c.containsKey(Integer.parseInt(split33[3])))
                                count3++;
                            grid[Integer.parseInt(split33[0])][Integer.parseInt(split33[1])].setBackground(Color.PINK);
                            c.put(Integer.parseInt(split33[3]),"");
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////
                for(int i=1;i<split9.length;i++){
                    String split34[]=split9[i].split("#");
                    if(split34.length>=3) {
                        if (split34[2].equals("empty"))
                            grid[Integer.parseInt(split34[0])][Integer.parseInt(split34[1])].setBackground(Color.green);
                        if (split34[2].equals("obstacle"))
                            grid[Integer.parseInt(split34[0])][Integer.parseInt(split34[1])].setBackground(Color.black);
                        if (split34.length == 4 && split34[3].equals("enemy")){
                            grid[Integer.parseInt(split34[0])][Integer.parseInt(split34[1])].setBackground(Color.blue);
                            ArrayList<Integer> n20=new ArrayList<Integer>();n20.add(0,Integer.parseInt(split34[0]));n20.add(1,Integer.parseInt(split34[1]));
                            n5.put(0, n20);
                        }
                        if (split34[2].equals("cow") && !c.containsKey(split34[3]))
                            grid[Integer.parseInt(split34[0])][Integer.parseInt(split34[1])].setBackground(Color.white);
                        if (split34[2].equals("catch")) {
                            if(!c.containsKey(Integer.parseInt(split34[3])))
                                count3++;
                            grid[Integer.parseInt(split34[0])][Integer.parseInt(split34[1])].setBackground(Color.PINK);
                            c.put(Integer.parseInt(split34[3]),"");
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////
                for(int i=1;i<split11.length;i++){
                    String split35[]=split11[i].split("#");
                    if(split35.length>=3) {
                        if (split35[2].equals("empty"))
                            grid[Integer.parseInt(split35[0])][Integer.parseInt(split35[1])].setBackground(Color.green);
                        if (split35[2].equals("obstacle"))
                            grid[Integer.parseInt(split35[0])][Integer.parseInt(split35[1])].setBackground(Color.black);
                        if (split35.length == 4 && split35[3].equals("enemy")){
                            grid[Integer.parseInt(split35[0])][Integer.parseInt(split35[1])].setBackground(Color.blue);
                            ArrayList<Integer> n20=new ArrayList<Integer>();n20.add(0,Integer.parseInt(split35[0]));n20.add(1,Integer.parseInt(split35[1]));
                            n6.put(0, n20);
                        }
                        if (split35[2].equals("cow") && !c.containsKey(split35[3]))
                            grid[Integer.parseInt(split35[0])][Integer.parseInt(split35[1])].setBackground(Color.white);
                        if (split35[2].equals("catch")) {
                            if(!c.containsKey(Integer.parseInt(split35[3])))
                                count3++;
                            grid[Integer.parseInt(split35[0])][Integer.parseInt(split35[1])].setBackground(Color.PINK);
                            c.put(Integer.parseInt(split35[3]),"");
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////
                for(int i=1;i<split13.length;i++){
                    String split36[]=split13[i].split("#");
                    if(split36.length>=3) {
                        if (split36[2].equals("empty"))
                            grid[Integer.parseInt(split36[0])][Integer.parseInt(split36[1])].setBackground(Color.green);
                        if (split36[2].equals("obstacle"))
                            grid[Integer.parseInt(split36[0])][Integer.parseInt(split36[1])].setBackground(Color.black);
                        if (split36.length == 4 && split36[3].equals("enemy")){
                            grid[Integer.parseInt(split36[0])][Integer.parseInt(split36[1])].setBackground(Color.blue);
                            ArrayList<Integer> n20=new ArrayList<Integer>();n20.add(0,Integer.parseInt(split36[0]));n20.add(1,Integer.parseInt(split36[1]));
                            n7.put(0, n20);
                        }
                        if (split36[2].equals("cow") && !c.containsKey(split36[3]))
                            grid[Integer.parseInt(split36[0])][Integer.parseInt(split36[1])].setBackground(Color.white);
                        if (split36[2].equals("catch")) {
                            if(!c.containsKey(Integer.parseInt(split36[3])))
                                count3++;
                            grid[Integer.parseInt(split36[0])][Integer.parseInt(split36[1])].setBackground(Color.PINK);
                            c.put(Integer.parseInt(split36[3]),"");
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////
                for(int i=1;i<split15.length;i++){
                    String split37[]=split15[i].split("#");
                    if(split37.length>=3) {
                        if (split37[2].equals("empty"))
                            grid[Integer.parseInt(split37[0])][Integer.parseInt(split37[1])].setBackground(Color.green);
                        if (split37[2].equals("obstacle"))
                            grid[Integer.parseInt(split37[0])][Integer.parseInt(split37[1])].setBackground(Color.black);
                        if (split37.length == 4 && split37[3].equals("enemy")){
                            grid[Integer.parseInt(split37[0])][Integer.parseInt(split37[1])].setBackground(Color.blue);
                            ArrayList<Integer> n20=new ArrayList<Integer>();n20.add(0,Integer.parseInt(split37[0]));n20.add(1,Integer.parseInt(split37[1]));
                            n8.put(0, n20);
                        }
                        if (split37[2].equals("cow")&& !c.containsKey(split37[3]))
                            grid[Integer.parseInt(split37[0])][Integer.parseInt(split37[1])].setBackground(Color.white);
                        if (split37[2].equals("catch")) {
                            if(!c.containsKey(Integer.parseInt(split37[3])))
                                count3++;
                            grid[Integer.parseInt(split37[0])][Integer.parseInt(split37[1])].setBackground(Color.PINK);
                            c.put(Integer.parseInt(split37[3]),"");
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////
                for(int i=1;i<split17.length;i++){
                    String split38[]=split17[i].split("#");
                    if(split38.length>=3) {
                        if (split38[2].equals("empty"))
                            grid[Integer.parseInt(split38[0])][Integer.parseInt(split38[1])].setBackground(Color.green);
                        if (split38[2].equals("obstacle"))
                            grid[Integer.parseInt(split38[0])][Integer.parseInt(split38[1])].setBackground(Color.black);
                        if (split38.length == 4 && split38[3].equals("enemy")) {
                            grid[Integer.parseInt(split38[0])][Integer.parseInt(split38[1])].setBackground(Color.blue);
                            ArrayList<Integer> n20=new ArrayList<Integer>();n20.add(0,Integer.parseInt(split38[0]));n20.add(1,Integer.parseInt(split38[1]));
                            n9.put(0, n20);
                        }
                        if (split38[2].equals("cow")&& !c.containsKey(split38[3]))
                            grid[Integer.parseInt(split38[0])][Integer.parseInt(split38[1])].setBackground(Color.white);
                        if (split38[2].equals("catch")) {
                            if(!c.containsKey(Integer.parseInt(split38[3])))
                                count3++;
                            grid[Integer.parseInt(split38[0])][Integer.parseInt(split38[1])].setBackground(Color.PINK);
                            c.put(Integer.parseInt(split38[3]),"");
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////
                for(int i=1;i<split19.length;i++){
                    String split39[]=split19[i].split("#");
                    if(split39.length>=3) {
                        if (split39[2].equals("empty"))
                            grid[Integer.parseInt(split39[0])][Integer.parseInt(split39[1])].setBackground(Color.green);
                        if (split39[2].equals("obstacle"))
                            grid[Integer.parseInt(split39[0])][Integer.parseInt(split39[1])].setBackground(Color.black);
                        if (split39.length == 4 && split39[3].equals("enemy")) {
                            grid[Integer.parseInt(split39[0])][Integer.parseInt(split39[1])].setBackground(Color.blue);
                            ArrayList<Integer> n20 = new ArrayList<Integer>();
                            n20.add(0, Integer.parseInt(split39[0]));
                            n20.add(1, Integer.parseInt(split39[1]));
                            n10.put(0, n20);
                        }
                        if (split39[2].equals("cow")&& !c.containsKey(split39[3]))
                            grid[Integer.parseInt(split39[0])][Integer.parseInt(split39[1])].setBackground(Color.white);
                        if (split39[2].equals("catch")) {
                            if(!c.containsKey(Integer.parseInt(split39[3])))
                                count3++;
                            grid[Integer.parseInt(split39[0])][Integer.parseInt(split39[1])].setBackground(Color.PINK);
                            c.put(Integer.parseInt(split39[3]),"");
                        }
                    }

                }
                ////////////////////////////////////////////////////////////////////////////////////
                /////////////////
                frame.setPreferredSize(new Dimension(2000,1000));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack(); //sets appropriate size for frame
                frame.setVisible(true); //makes frame visible
                count1.add(count4++);
                count2.add(count3);
                System.out.println(y++);
                synchronized (this) {
                    try {
                        wait(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(n1.size()>0)
                    grid[n1.get(0).get(0)][n1.get(0).get(1)].setBackground(Color.green);
                if(n2.size()>0)
                    grid[n2.get(0).get(0)][n2.get(0).get(1)].setBackground(Color.green);
                if(n3.size()>0)
                    grid[n3.get(0).get(0)][n3.get(0).get(1)].setBackground(Color.green);
                if(n4.size()>0)
                    grid[n4.get(0).get(0)][n4.get(0).get(1)].setBackground(Color.green);
                if(n5.size()>0)
                    grid[n5.get(0).get(0)][n5.get(0).get(1)].setBackground(Color.green);
                if(n6.size()>0)
                    grid[n6.get(0).get(0)][n6.get(0).get(1)].setBackground(Color.green);
                if(n7.size()>0)
                    grid[n7.get(0).get(0)][n7.get(0).get(1)].setBackground(Color.green);
                if(n8.size()>0)
                    grid[n8.get(0).get(0)][n8.get(0).get(1)].setBackground(Color.green);
                if(n9.size()>0)
                    grid[n9.get(0).get(0)][n9.get(0).get(1)].setBackground(Color.green);
                if(n10.size()>0)
                    grid[n10.get(0).get(0)][n10.get(0).get(1)].setBackground(Color.green);


            }

            System.out.print("]");
            if(count2.size()<2500){
                for(int q=1210;q<=1500;q++)
                    count2.add(count2.size(), 63);


                System.out.print("[");
                for (int o = 0; o <= 1500; o++) {
                    System.out.print("," + 100*count2.get(o)/131);
                }
                System.out.print("]");
            }
            /*else {
                System.out.print("[");
                for (int o = 0; o < 2500; o++) {
                    System.out.print("," + 100*count2.get(o)/131);
                }
                System.out.print("]");
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
