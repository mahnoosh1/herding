package massim.demoAgents;

import com.sun.deploy.resources.Deployment_pt_BR;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by mahnoosh on 9/19/2017.
 */
public class maind {

    public static  void main(String args[]) throws Exception{
        for(int i=1;i<=50000;i++) {
            System.out.println(i);
        }
        HNoT d=new HNoT();
        //HT d=new HT();
       // NoHT d=new NoHT();
        //Display d=new Display();//no h no t
        d.draw(120,120);
        ///////////////////////////
//        BufferedReader br1 = null;
//        FileReader fr1 = null;
//        ///////////////////////////
//        BufferedReader br2 = null;
//        FileReader fr2 = null;
//        ///////////////////////////
//        BufferedReader br3 = null;
//        FileReader fr3 = null;
//        ///////////////////////////
//        BufferedReader br4 = null;
//        FileReader fr4 = null;
//        ///////////////////////////
//        BufferedReader br5 = null;
//        FileReader fr5 = null;
//        ///////////////////////////
//        BufferedReader br6 = null;
//        FileReader fr6= null;
//        ///////////////////////////
//        BufferedReader br7 = null;
//        FileReader fr7 = null;
//        ///////////////////////////
//        BufferedReader br8 = null;
//        FileReader fr8 = null;
//        ///////////////////////////
//        BufferedReader br9 = null;
//        FileReader fr9 = null;
//        ///////////////////////////
//        BufferedReader br10 = null;
//        FileReader fr10 = null;
//        /////////////////////////////////////////////////////////////////////////
//        fr1 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log1.txt");
//        br1 = new BufferedReader(fr1);
//        String sCurrentLine1;
//        String sCurrentLine1_prev="";
//        String sCurrentLine1_next="";
//        ////////////////////////////////////////////////////////////////////////
//        /////////////////////////////////////////////////////////////////////////
//        fr2 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log2.txt");
//        br2 = new BufferedReader(fr2);
//        String sCurrentLine2;
//        String sCurrentLine2_prev="";
//        String sCurrentLine2_next="";
//        ////////////////////////////////////////////////////////////////////////
//        /////////////////////////////////////////////////////////////////////////
//        fr3 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log3.txt");
//        br3 = new BufferedReader(fr3);
//        String sCurrentLine3;
//        String sCurrentLine3_prev="";
//        String sCurrentLine3_next="";
//        ////////////////////////////////////////////////////////////////////////
//        /////////////////////////////////////////////////////////////////////////
//        fr4 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log4.txt");
//        br4 = new BufferedReader(fr4);
//        String sCurrentLine4;
//        String sCurrentLine4_prev="";
//        String sCurrentLine4_next="";
//        ////////////////////////////////////////////////////////////////////////
//        /////////////////////////////////////////////////////////////////////////
//        fr5 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log5.txt");
//        br5 = new BufferedReader(fr5);
//        String sCurrentLine5;
//        String sCurrentLine5_prev="";
//        String sCurrentLine5_next="";
//        ////////////////////////////////////////////////////////////////////////
//        /////////////////////////////////////////////////////////////////////////
//        fr6 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log6.txt");
//        br6 = new BufferedReader(fr6);
//        String sCurrentLine6_prev="";
//        String sCurrentLine6_next="";
//        String sCurrentLine6;
//        ////////////////////////////////////////////////////////////////////////
//        /////////////////////////////////////////////////////////////////////////
//        fr7 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log7.txt");
//        br7 = new BufferedReader(fr7);
//        String sCurrentLine7_prev="";
//        String sCurrentLine7_next="";
//        String sCurrentLine7;
//        ////////////////////////////////////////////////////////////////////////
//        /////////////////////////////////////////////////////////////////////////
//        fr8 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log8.txt");
//        br8 = new BufferedReader(fr8);
//        String sCurrentLine8_prev="";
//        String sCurrentLine8_next="";
//        String sCurrentLine8;
//        ////////////////////////////////////////////////////////////////////////
//        /////////////////////////////////////////////////////////////////////////
//        fr9 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log9.txt");
//        br9 = new BufferedReader(fr9);
//        String sCurrentLine9_prev="";
//        String sCurrentLine9_next="";
//        String sCurrentLine9;
//        ////////////////////////////////////////////////////////////////////////
//        /////////////////////////////////////////////////////////////////////////
//        fr10 = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log10.txt");
//        br10 = new BufferedReader(fr10);
//        String sCurrentLine10_prev="";
//        String sCurrentLine10_next="";
//        String sCurrentLine10;
//        ////////////////////////////////////////////////////////////////////////
//
//        HashMap<Integer,HashMap<Integer,String>> covered=new HashMap<Integer, HashMap<Integer, String>>();
//        HashMap<Integer,HashMap<Integer,String>> reached=new HashMap<Integer, HashMap<Integer, String>>();
//        HashMap<Integer,String> bmp=new HashMap<Integer, String>();
//        HashMap<Integer,String> bmp1=new HashMap<Integer, String>();
//        ///////////////////////////////////
//        BufferedReader br1xx = null;
//        BufferedReader br2x = null;
//        BufferedReader br3x = null;
//        BufferedReader br4x = null;
//        BufferedReader br5x = null;
//        BufferedReader br6x = null;
//        BufferedReader br7x = null;
//        BufferedReader br8x = null;
//        BufferedReader br9x = null;
//        BufferedReader br10x = null;
//        FileReader fr1xx = null;
//        FileReader fr2x = null;
//        FileReader fr3x = null;
//        FileReader fr4x = null;
//        FileReader fr5x = null;
//        FileReader fr6x = null;
//        FileReader fr7x = null;
//        FileReader fr8x = null;
//        FileReader fr9x = null;
//        FileReader fr10x = null;
//        fr1xx = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log1.txt");
//        fr2x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log2.txt");
//        fr3x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log3.txt");
//        fr4x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log4.txt");
//        fr5x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log5.txt");
//        fr6x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log6.txt");
//        fr7x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log7.txt");
//        fr8x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log8.txt");
//        fr9x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log9.txt");
//        fr10x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log10.txt");
//        br1xx = new BufferedReader(fr1xx);
//        br2x = new BufferedReader(fr2x);
//        br3x = new BufferedReader(fr3x);
//        br4x = new BufferedReader(fr4x);
//        br5x = new BufferedReader(fr5x);
//        br6x = new BufferedReader(fr6x);
//        br7x = new BufferedReader(fr7x);
//        br8x = new BufferedReader(fr8x);
//        br9x = new BufferedReader(fr9x);
//        br10x = new BufferedReader(fr10x);
//        String sCurrentLine1xx;
//        String sCurrentLine2x;
//        String sCurrentLine3x;
//        String sCurrentLine4x;
//        String sCurrentLine5x;
//        String sCurrentLine6x;
//        String sCurrentLine7x;
//        String sCurrentLine8x;
//        String sCurrentLine9x;
//        String sCurrentLine10x;
//        int c2=0;
//        while((sCurrentLine1xx = br1xx.readLine()) != null){
//            if(sCurrentLine1xx.contains("//////////")){
//                reached.put(c2++,bmp1);
//            }
//            sCurrentLine2x = br2x.readLine();
//            sCurrentLine3x = br3x.readLine();
//            sCurrentLine4x = br4x.readLine();
//            sCurrentLine5x = br5x.readLine();
//            sCurrentLine6x = br6x.readLine();
//            sCurrentLine7x = br7x.readLine();
//            sCurrentLine8x = br8x.readLine();
//            sCurrentLine9x = br9x.readLine();
//            sCurrentLine10x = br10x.readLine();
//            if(sCurrentLine1xx!=null && sCurrentLine1xx.contains("catched are:")){
//                String t1[]=sCurrentLine1xx.split(":");
//                String t2=t1[1].replace(" ","");
//                for(int i=0;i<=110;i++){
//                    t2=t2.replace("in"+i,"");
//                    t2=t2.replace("{","");
//                    t2=t2.replace("}","");
//                }
//                String t3[]=t2.split("],");
//                for(int j=0;j<t3.length;j++){
//                    if(t3[j].length()>0 && t3[j].contains(",")) {
//                        String fpp[]=t3[j].split("=");
//                        bmp1.put(Integer.parseInt(fpp[0]),"");
//                    }
//                }
//
//            }
//            if(sCurrentLine2x!=null && sCurrentLine2x.contains("catched are:")){
//                String t1[]=sCurrentLine2x.split(":");
//                String t2=t1[1].replace(" ","");
//                for(int i=0;i<=110;i++){
//                    t2=t2.replace("in"+i,"");
//                    t2=t2.replace("{","");
//                    t2=t2.replace("}","");
//                }
//                String t3[]=t2.split("],");
//                for(int j=0;j<t3.length;j++){
//                    if(t3[j].length()>0 && t3[j].contains(",")) {
//                        String fpp[]=t3[j].split("=");
//                        bmp1.put(Integer.parseInt(fpp[0]),"");
//                    }
//                }
//
//            }
//            if(sCurrentLine3x!=null && sCurrentLine3x.contains("catched are:")){
//                String t1[]=sCurrentLine3x.split(":");
//                String t2=t1[1].replace(" ","");
//                for(int i=0;i<=110;i++){
//                    t2=t2.replace("in"+i,"");
//                    t2=t2.replace("{","");
//                    t2=t2.replace("}","");
//                }
//                String t3[]=t2.split("],");
//                for(int j=0;j<t3.length;j++){
//                    if(t3[j].length()>0 && t3[j].contains(",")) {
//                        String fpp[]=t3[j].split("=");
//                        bmp1.put(Integer.parseInt(fpp[0]),"");
//                    }
//                }
//
//            }
//            if(sCurrentLine4x!=null && sCurrentLine4x.contains("catched are:")){
//                String t1[]=sCurrentLine4x.split(":");
//                String t2=t1[1].replace(" ","");
//                for(int i=0;i<=110;i++){
//                    t2=t2.replace("in"+i,"");
//                    t2=t2.replace("{","");
//                    t2=t2.replace("}","");
//                }
//                String t3[]=t2.split("],");
//                for(int j=0;j<t3.length;j++){
//                    if(t3[j].length()>0 && t3[j].contains(",")) {
//                        String fpp[]=t3[j].split("=");
//                        bmp1.put(Integer.parseInt(fpp[0]),"");
//                    }
//                }
//
//            }
//            if(sCurrentLine5x!=null && sCurrentLine5x.contains("catched are:")){
//                String t1[]=sCurrentLine5x.split(":");
//                String t2=t1[1].replace(" ","");
//                for(int i=0;i<=110;i++){
//                    t2=t2.replace("in"+i,"");
//                    t2=t2.replace("{","");
//                    t2=t2.replace("}","");
//                }
//                String t3[]=t2.split("],");
//                for(int j=0;j<t3.length;j++){
//                    if(t3[j].length()>0 && t3[j].contains(",")) {
//                        String fpp[]=t3[j].split("=");
//                        bmp1.put(Integer.parseInt(fpp[0]),"");
//                    }
//                }
//
//            }
//            if(sCurrentLine6x!=null && sCurrentLine6x.contains("catched are:")){
//                String t1[]=sCurrentLine6x.split(":");
//                String t2=t1[1].replace(" ","");
//                for(int i=0;i<=110;i++){
//                    t2=t2.replace("in"+i,"");
//                    t2=t2.replace("{","");
//                    t2=t2.replace("}","");
//                }
//                String t3[]=t2.split("],");
//                for(int j=0;j<t3.length;j++){
//                    if(t3[j].length()>0 && t3[j].contains(",")) {
//                        String fpp[]=t3[j].split("=");
//                        bmp1.put(Integer.parseInt(fpp[0]),"");
//                    }
//                }
//
//            }
//            if(sCurrentLine7x!=null && sCurrentLine7x.contains("catched are:")){
//                String t1[]=sCurrentLine7x.split(":");
//                String t2=t1[1].replace(" ","");
//                for(int i=0;i<=110;i++){
//                    t2=t2.replace("in"+i,"");
//                    t2=t2.replace("{","");
//                    t2=t2.replace("}","");
//                }
//                String t3[]=t2.split("],");
//                for(int j=0;j<t3.length;j++){
//                    if(t3[j].length()>0 && t3[j].contains(",")) {
//                        String fpp[]=t3[j].split("=");
//                        bmp1.put(Integer.parseInt(fpp[0]),"");
//                    }
//                }
//
//            }
//            if(sCurrentLine8x!=null && sCurrentLine8x.contains("catched are:")){
//                String t1[]=sCurrentLine8x.split(":");
//                String t2=t1[1].replace(" ","");
//                for(int i=0;i<=110;i++){
//                    t2=t2.replace("in"+i,"");
//                    t2=t2.replace("{","");
//                    t2=t2.replace("}","");
//                }
//                String t3[]=t2.split("],");
//                for(int j=0;j<t3.length;j++){
//                    if(t3[j].length()>0 && t3[j].contains(",")) {
//                        String fpp[]=t3[j].split("=");
//                        bmp1.put(Integer.parseInt(fpp[0]),"");
//                    }
//                }
//
//            }
//            if(sCurrentLine9x!=null && sCurrentLine9x.contains("catched are:")){
//                String t1[]=sCurrentLine9x.split(":");
//                String t2=t1[1].replace(" ","");
//                for(int i=0;i<=110;i++){
//                    t2=t2.replace("in"+i,"");
//                    t2=t2.replace("{","");
//                    t2=t2.replace("}","");
//                }
//                String t3[]=t2.split("],");
//                for(int j=0;j<t3.length;j++){
//                    if(t3[j].length()>0 && t3[j].contains(",")) {
//                        String fpp[]=t3[j].split("=");
//                        bmp1.put(Integer.parseInt(fpp[0]),"");
//                    }
//                }
//
//            }
//            if(sCurrentLine10x!=null && sCurrentLine10x.contains("catched are:")){
//                String t1[]=sCurrentLine10x.split(":");
//                String t2=t1[1].replace(" ","");
//                for(int i=0;i<=110;i++){
//                    t2=t2.replace("in"+i,"");
//                    t2=t2.replace("{","");
//                    t2=t2.replace("}","");
//                }
//                String t3[]=t2.split("],");
//                for(int j=0;j<t3.length;j++){
//                    if(t3[j].length()>0 && t3[j].contains(",")) {
//                        String fpp[]=t3[j].split("=");
//                        bmp1.put(Integer.parseInt(fpp[0]),"");
//                    }
//                }
//
//            }
//        }
//        System.out.println(reached);
//        System.out.println("endeddddddddddddddddddd");
//        ///////////////////////////////////
//        int cnt=0;int c1=0;
//        while ((sCurrentLine1 = br1.readLine()) != null) {
//            ////////////////////////////////
//            sCurrentLine2 = br2.readLine();
//            sCurrentLine3 = br3.readLine();
//            sCurrentLine4 = br4.readLine();
//            sCurrentLine5 = br5.readLine();
//            sCurrentLine6 = br6.readLine();
//            sCurrentLine7 = br7.readLine();
//            sCurrentLine8 = br8.readLine();
//            sCurrentLine9 = br9.readLine();
//            sCurrentLine10 = br10.readLine();
//            if(sCurrentLine1.contains("////////////////")) {
//                if (c1 > 1){
//                    for (int id : reached.get(c1 - 1).keySet()) {
//                        if (bmp.containsKey(id))
//                            bmp.remove(id);
//                    }
//                }
//                covered.put(c1++,bmp);
////                System.out.println("step: "+(c1-1));
////                System.out.println(covered.get(c1-1));
//                bmp=new HashMap<Integer, String>();
//            }
//            if(sCurrentLine1.contains("header:")){
//                String header[]=sCurrentLine1.split(":");
//                String x=header[1].replace(" ","");
//                if(Integer.parseInt(x)==1){
//                    String x1[]=sCurrentLine1_prev.split(":");
//                    String x10=x1[1].replace(" ","");
//                    x10=x10.replace("newcentis","");
//                    x10=x10.replace("{","");
//                    x10=x10.replace("}","");
//                    String x01[]=x10.split("],");
//                    //////////////////////////////////
//                    BufferedReader br1x = null;
//                    FileReader fr1x = null;
//                    fr1x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log1.txt");
//                    br1x = new BufferedReader(fr1x);
//                    String sCurrentLine1x;int y=0;boolean f=false;
//                    while((sCurrentLine1x = br1x.readLine()) != null && y<=cnt){
//                        y++;
//                    }
//                    sCurrentLine1_next=sCurrentLine1x;
//                    ///////////////////////////
//                    String zx[]=sCurrentLine1_next.split("1");
//                    zx[0]=zx[0].replace(" ","");
//                    if(zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:0RandGroup:"))
//                    {
//                        for(int i=0;i<x01.length;i++){
//                            String zq[]=x01[i].split("=");
//                            int r=Integer.parseInt(zq[0].replace("=", ""));
//                            bmp.put(r, "");
//                        }
//
//                    }
//                    //////////////////////////
//                }
//
//            }
//            if(sCurrentLine2!=null && sCurrentLine2.contains("header:")){
//                String header[]=sCurrentLine2.split(":");
//                String x=header[1].replace(" ","");
//                if(Integer.parseInt(x)==1){
//                    String x1[]=sCurrentLine2_prev.split(":");
//                    String x10=x1[1].replace(" ","");
//                    x10=x10.replace("newcentis","");
//                    x10=x10.replace("{","");
//                    x10=x10.replace("}","");
//                    String x01[]=x10.split("],");
//                    //////////////////////////////////
//                    BufferedReader br1x = null;
//                    FileReader fr1x = null;
//                    fr1x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log2.txt");
//                    br1x = new BufferedReader(fr1x);
//                    String sCurrentLine1x;int y=0;boolean f=false;
//                    while((sCurrentLine1x = br1x.readLine()) != null && y<=cnt){
//                        y++;
//                    }
//                    sCurrentLine1_next=sCurrentLine1x;
//                    ///////////////////////////
//                    String zx[]=sCurrentLine1_next.split("1");
//                    zx[0]=zx[0].replace(" ","");
//                    if(zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:0RandGroup:"))
//                    {
//                        for(int i=0;i<x01.length;i++){
//                            String zq[]=x01[i].split("=");
//                            int r=Integer.parseInt(zq[0].replace("=", ""));
//                            bmp.put(r, "");
//                        }
//
//                    }
//                    //////////////////////////
//                }
//
//            }
//            if(sCurrentLine3!=null && sCurrentLine3.contains("header:")){
//                String header[]=sCurrentLine3.split(":");
//                String x=header[1].replace(" ","");
//                if(Integer.parseInt(x)==1){
//                    String x1[]=sCurrentLine3_prev.split(":");
//                    String x10=x1[1].replace(" ","");
//                    x10=x10.replace("newcentis","");
//                    x10=x10.replace("{","");
//                    x10=x10.replace("}","");
//                    String x01[]=x10.split("],");
//                    //////////////////////////////////
//                    BufferedReader br1x = null;
//                    FileReader fr1x = null;
//                    fr1x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log3.txt");
//                    br1x = new BufferedReader(fr1x);
//                    String sCurrentLine1x;int y=0;boolean f=false;
//                    while((sCurrentLine1x = br1x.readLine()) != null && y<=cnt){
//                        y++;
//                    }
//                    sCurrentLine1_next=sCurrentLine1x;
//                    ///////////////////////////
//                    String zx[]=sCurrentLine1_next.split("1");
//                    zx[0]=zx[0].replace(" ","");
//                    if(zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:0RandGroup:"))
//                    {
//                        for(int i=0;i<x01.length;i++){
//                            String zq[]=x01[i].split("=");
//                            int r=Integer.parseInt(zq[0].replace("=", ""));
//                            bmp.put(r, "");
//                        }
//
//                    }
//                    //////////////////////////
//                }
//
//            }
//            if(sCurrentLine4!=null && sCurrentLine4.contains("header:")){
//                String header[]=sCurrentLine4.split(":");
//                String x=header[1].replace(" ","");
//                if(Integer.parseInt(x)==1){
//                    String x1[]=sCurrentLine4_prev.split(":");
//                    String x10=x1[1].replace(" ","");
//                    x10=x10.replace("newcentis","");
//                    x10=x10.replace("{","");
//                    x10=x10.replace("}","");
//                    String x01[]=x10.split("],");
//                    //////////////////////////////////
//                    BufferedReader br1x = null;
//                    FileReader fr1x = null;
//                    fr1x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log4.txt");
//                    br1x = new BufferedReader(fr1x);
//                    String sCurrentLine1x;int y=0;boolean f=false;
//                    while((sCurrentLine1x = br1x.readLine()) != null && y<=cnt){
//                        y++;
//                    }
//                    sCurrentLine1_next=sCurrentLine1x;
//                    ///////////////////////////
//                    String zx[]=sCurrentLine1_next.split("1");
//                    zx[0]=zx[0].replace(" ","");
//                    if(zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:0RandGroup:"))
//                    {
//                        for(int i=0;i<x01.length;i++){
//                            String zq[]=x01[i].split("=");
//                            int r=Integer.parseInt(zq[0].replace("=", ""));
//                            bmp.put(r, "");
//                        }
//
//                    }
//                    //////////////////////////
//                }
//
//            }
//            if(sCurrentLine5!=null && sCurrentLine5.contains("header:")){
//                String header[]=sCurrentLine5.split(":");
//                String x=header[1].replace(" ","");
//                if(Integer.parseInt(x)==1){
//                    String x1[]=sCurrentLine5_prev.split(":");
//                    String x10=x1[1].replace(" ","");
//                    x10=x10.replace("newcentis","");
//                    x10=x10.replace("{","");
//                    x10=x10.replace("}","");
//                    String x01[]=x10.split("],");
//                    //////////////////////////////////
//                    BufferedReader br1x = null;
//                    FileReader fr1x = null;
//                    fr1x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log5.txt");
//                    br1x = new BufferedReader(fr1x);
//                    String sCurrentLine1x;int y=0;boolean f=false;
//                    while((sCurrentLine1x = br1x.readLine()) != null && y<=cnt){
//                        y++;
//                    }
//                    sCurrentLine1_next=sCurrentLine1x;
//                    ///////////////////////////
//                    String zx[]=sCurrentLine1_next.split("1");
//                    zx[0]=zx[0].replace(" ","");
//                    if(zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:0RandGroup:"))
//                    {
//                        for(int i=0;i<x01.length;i++){
//                            String zq[]=x01[i].split("=");
//                            int r=Integer.parseInt(zq[0].replace("=", ""));
//                            bmp.put(r, "");
//                        }
//
//                    }
//                    //////////////////////////
//                }
//
//            }
//            if(sCurrentLine6!=null && sCurrentLine6.contains("header:")){
//                String header[]=sCurrentLine6.split(":");
//                String x=header[1].replace(" ","");
//                if(Integer.parseInt(x)==1){
//                    String x1[]=sCurrentLine6_prev.split(":");
//                    String x10=x1[1].replace(" ","");
//                    x10=x10.replace("newcentis","");
//                    x10=x10.replace("{","");
//                    x10=x10.replace("}","");
//                    String x01[]=x10.split("],");
//                    //////////////////////////////////
//                    BufferedReader br1x = null;
//                    FileReader fr1x = null;
//                    fr1x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log6.txt");
//                    br1x = new BufferedReader(fr1x);
//                    String sCurrentLine1x;int y=0;boolean f=false;
//                    while((sCurrentLine1x = br1x.readLine()) != null && y<=cnt){
//                        y++;
//                    }
//                    sCurrentLine1_next=sCurrentLine1x;
//                    ///////////////////////////
//                    String zx[]=sCurrentLine1_next.split("1");
//                    zx[0]=zx[0].replace(" ","");
//                    if(zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:0RandGroup:"))
//                    {
//                        for(int i=0;i<x01.length;i++){
//                            String zq[]=x01[i].split("=");
//                            int r=Integer.parseInt(zq[0].replace("=", ""));
//                            bmp.put(r, "");
//                        }
//
//                    }
//                    //////////////////////////
//                }
//
//            }
//            if(sCurrentLine7!=null && sCurrentLine7.contains("header:")){
//                String header[]=sCurrentLine7.split(":");
//                String x=header[1].replace(" ","");
//                if(Integer.parseInt(x)==1){
//                    String x1[]=sCurrentLine7_prev.split(":");
//                    String x10=x1[1].replace(" ","");
//                    x10=x10.replace("newcentis","");
//                    x10=x10.replace("{","");
//                    x10=x10.replace("}","");
//                    String x01[]=x10.split("],");
//                    //////////////////////////////////
//                    BufferedReader br1x = null;
//                    FileReader fr1x = null;
//                    fr1x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log7.txt");
//                    br1x = new BufferedReader(fr1x);
//                    String sCurrentLine1x;int y=0;boolean f=false;
//                    while((sCurrentLine1x = br1x.readLine()) != null && y<=cnt){
//                        y++;
//                    }
//                    sCurrentLine1_next=sCurrentLine1x;
//                    ///////////////////////////
//                    String zx[]=sCurrentLine1_next.split("1");
//                    zx[0]=zx[0].replace(" ","");
//                    if(zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:0RandGroup:"))
//                    {
//                        for(int i=0;i<x01.length;i++){
//                            String zq[]=x01[i].split("=");
//                            int r=Integer.parseInt(zq[0].replace("=", ""));
//                            bmp.put(r, "");
//                        }
//
//                    }
//                    //////////////////////////
//                }
//
//            }
//            if(sCurrentLine8!=null && sCurrentLine8.contains("header:")){
//                String header[]=sCurrentLine8.split(":");
//                String x=header[1].replace(" ","");
//                if(Integer.parseInt(x)==1){
//                    String x1[]=sCurrentLine8_prev.split(":");
//                    String x10=x1[1].replace(" ","");
//                    x10=x10.replace("newcentis","");
//                    x10=x10.replace("{","");
//                    x10=x10.replace("}","");
//                    String x01[]=x10.split("],");
//                    //////////////////////////////////
//                    BufferedReader br1x = null;
//                    FileReader fr1x = null;
//                    fr1x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log8.txt");
//                    br1x = new BufferedReader(fr1x);
//                    String sCurrentLine1x;int y=0;boolean f=false;
//                    while((sCurrentLine1x = br1x.readLine()) != null && y<=cnt){
//                        y++;
//                    }
//                    sCurrentLine1_next=sCurrentLine1x;
//                    ///////////////////////////
//                    String zx[]=sCurrentLine1_next.split("1");
//                    zx[0]=zx[0].replace(" ","");
//                    if(zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:0RandGroup:"))
//                    {
//                        for(int i=0;i<x01.length;i++){
//                            String zq[]=x01[i].split("=");
//                            int r=Integer.parseInt(zq[0].replace("=", ""));
//                            bmp.put(r, "");
//                        }
//
//                    }
//                    //////////////////////////
//                }
//
//            }
//            if(sCurrentLine9!=null && sCurrentLine9.contains("header:")){
//                String header[]=sCurrentLine9.split(":");
//                String x=header[1].replace(" ","");
//                if(Integer.parseInt(x)==1){
//                    String x1[]=sCurrentLine9_prev.split(":");
//                    String x10=x1[1].replace(" ","");
//                    x10=x10.replace("newcentis","");
//                    x10=x10.replace("{","");
//                    x10=x10.replace("}","");
//                    String x01[]=x10.split("],");
//                    //////////////////////////////////
//                    BufferedReader br1x = null;
//                    FileReader fr1x = null;
//                    fr1x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log9.txt");
//                    br1x = new BufferedReader(fr1x);
//                    String sCurrentLine1x;int y=0;boolean f=false;
//                    while((sCurrentLine1x = br1x.readLine()) != null && y<=cnt){
//                        y++;
//                    }
//                    sCurrentLine1_next=sCurrentLine1x;
//                    ///////////////////////////
//                    String zx[]=sCurrentLine1_next.split("1");
//                    zx[0]=zx[0].replace(" ","");
//                    if(zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:0RandGroup:"))
//                    {
//                        for(int i=0;i<x01.length;i++){
//                            String zq[]=x01[i].split("=");
//                            int r=Integer.parseInt(zq[0].replace("=", ""));
//                            bmp.put(r, "");
//                        }
//
//                    }
//                    //////////////////////////
//                }
//
//            }
//            if(sCurrentLine10!=null && sCurrentLine10.contains("header:")){
//                String header[]=sCurrentLine10.split(":");
//                String x=header[1].replace(" ","");
//                if(Integer.parseInt(x)==1){
//                    String x1[]=sCurrentLine10_prev.split(":");
//                    String x10=x1[1].replace(" ","");
//                    x10=x10.replace("newcentis","");
//                    x10=x10.replace("{","");
//                    x10=x10.replace("}","");
//                    String x01[]=x10.split("],");
//                    //////////////////////////////////
//                    BufferedReader br1x = null;
//                    FileReader fr1x = null;
//                    fr1x = new FileReader("c:\\users\\rahma\\desktop\\Graphic\\mmm\\NOHEU\\log10.txt");
//                    br1x = new BufferedReader(fr1x);
//                    String sCurrentLine1x;int y=0;boolean f=false;
//                    while((sCurrentLine1x = br1x.readLine()) != null && y<=cnt){
//                        y++;
//                    }
//                    sCurrentLine1_next=sCurrentLine1x;
//                    ///////////////////////////
//                    String zx[]=sCurrentLine1_next.split("1");
//                    zx[0]=zx[0].replace(" ","");
//                    if(zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:") || zx[0].equals("modesare:herdalone:0herdgroup:0goafteralone:0goaftergruop:0NOMODE:0RandAlone:0RandGroup:"))
//                    {
//                        for(int i=0;i<x01.length;i++){
//                            String zq[]=x01[i].split("=");
//                            int r=Integer.parseInt(zq[0].replace("=", ""));
//                            bmp.put(r, "");
//                        }
//
//                    }
//                    //////////////////////////
//                }
//
//            }
//            sCurrentLine1_prev=sCurrentLine1;
//            sCurrentLine2_prev=sCurrentLine2;
//            sCurrentLine3_prev=sCurrentLine3;
//            sCurrentLine4_prev=sCurrentLine4;
//            sCurrentLine5_prev=sCurrentLine5;
//            sCurrentLine6_prev=sCurrentLine6;
//            sCurrentLine7_prev=sCurrentLine7;
//            sCurrentLine8_prev=sCurrentLine8;
//            sCurrentLine9_prev=sCurrentLine9;
//            sCurrentLine10_prev=sCurrentLine10;
//            cnt++;
//
//
//        }
//        //System.out.println("part 2 tamam shod");
//        /////////////////////////////////////////////////covered then reached
//        ArrayList<Integer> A1=new ArrayList<Integer>();
//        ArrayList<Integer> A2=new ArrayList<Integer>();
//        for(int id1:covered.keySet()){
//            A1.add(covered.get(id1).size());
//        }
//        for(int id1:reached.keySet()){
//            A2.add(reached.get(id1).size());
//        }
//        System.out.println("part 3 tamam shod");
//        System.out.println(A1);
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println(A2);
//        System.out.println();
//        System.out.println();
//        System.out.println(A1.size()+"                             "+A2.size());
//        /////////////////////////////////////////////////
    }
}



