package massim.demoAgents;



public class Start {
    public static double findAngle(double p0x,double p0y,double p1x,double p1y,double p2x,double p2y) {
        double a = Math.pow(p1x-p0x,2) + Math.pow(p1y-p0y,2),
                b = Math.pow(p1x-p2x,2) + Math.pow(p1y-p2y,2),
                c = Math.pow(p2x-p0x,2) + Math.pow(p2y - p0y, 2);
        return 57.2958*Math.acos( (a+b-c) / Math.sqrt(4*a*b) );
    }
    public static double alpha1(double x0,double y0,double x1,double y1){
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
	public static void main(String[] args) throws Exception {
        NodeStarter.startNode(
               "configuration.xml",
                "StartNode",
                2000000);
//double x = findAngle(-2,3,7,5,1,1)  ;
//System.out.println(x);

    }

 }


