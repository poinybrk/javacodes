import java.io.*;
import java.lang.*;

class quadratic{
	public static void main (String args[]){
		double a=Double.parseDouble(args[0]);
		double b=Double.parseDouble(args[1]);
		double c=Double.parseDouble(args[2]);
		double d=0.0;
		d= (b*b)-(4*a*c);
		if (d>0){
			double x=0.0,y=0.0;
			x=((-b - Math.sqrt(d))/(2*a));
			y=((-b + Math.sqrt(d))/(2*a));
			System.out.println(x +","+y);
		}
		else if (d<0){
			System.out.println("the roots are imaginary ");
			double x=(-b/(2*a));
			double y= Math.sqrt(-d)/(2*a);		
			System.out.println(x +" + i" +y);
			System.out.println(x +" - i" +y);
		}
		else{
		System .out.println ("the roots are equal ");
		double x=(-b/(2*a));
		System.out.print("it is "+ x);
		}
	}
}
