import java.io.*;
import java.math.*;

class Linear{
    public double mean(double x[], int n) throws IOException{
        double sum=0.0;
        for(int i=0;i<n;i++)
            sum=sum+x[i];
        double mean=sum/n;
        return (mean);
    }
    public double mean(int x[], int n) throws IOException{
        double sum=0.0;
        for(int i=0;i<n;i++)
            sum=sum+x[i];
        double mean=sum/n;
        return (mean);
    }
    public double var(int x[], int n) throws IOException{
        double var=0.0, z=0.0, sum=0.0;
        for(int i=0;i<n;i++)
            sum=sum+(x[i]*x[i]);
        var=((sum/n)-(mean(x,n)*mean(x,n)));
        return (var);
    }
    public double cov(int x[], double y[],int n) throws IOException{
        double var=0.0, sum=0.0;
        for(int i=0;i<n;i++)
            sum=sum+x[i]*y[i];
        double cov=(sum/n)-(mean(x,n)*mean(y,n));
        return (cov);
    }
    double slope=0.0, intercept=0.0;
    public void line_eqn(int x[], double y[], int n) throws IOException{
        slope=cov(x,y,n)/var(x,n);
        intercept=mean(y,n)-slope*mean(x,n);
        System.out.println(" Equation of the line is \n"+"Y = "+intercept+"+"+slope+"x");
    }
    public void mse(int x[], double y[], double y_est[], int n) throws IOException{
        double mse, sum=0.0;
        slope=cov(x,y,n)/var(x,n);
        intercept=mean(y,n)-slope*mean(x,n);
        for(int i=0;i<n;i++)
            y_est[i]=intercept+slope*x[i];
        System.out.println("\n");
        System.out.println("\n X\tY \tY^");
        for(int i=0;i<n;i++){
            System.out.println();
            System.out.print(x[i]+"\t"+y[i]+"\t"+y_est[i]);
        }
        for(int i=0;i<n;i++)
            sum=sum+((y[i]-y_est[i])*(y[i]-y_est[i]));
        mse=sum/(n-1);
        System.out.println("\nmse="+mse);
        System.out.println();
    }
}
class Line{
    public static void main (String args[]) throws IOException{
        Linear obj=new Linear();
        int n,per,x[];
        double y[],y_est[];
        InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String str,ch;
        do{
            System.out.println(" Enter the number of periods: ");
            str=br.readLine();
            n=Integer.parseInt(str);
            x=new int[n];
            y=new double[n];
            y_est=new double[n];
            System.out.println("Enter the value of the first period: ");
            str=br.readLine();
            x[0]=Integer.parseInt(str);
            System.out.println("Enter the interval between the two periods :");
            x[0]=Integer.parseInt(str);
            str=br.readLine();
            per=Integer.parseInt(str);
            for(int i = 1;i<n;i++ ){
                x[i]=x[i-1]+per;
            }
            System.out.println("Enter the observed values of time series data Y:");
            for(int i=0;i<n;i++ ){
                str=br.readLine();
                y[i]=Double.parseDouble(str);
            }
            System.out.println("Equation of the line to fit: y=ax+b, where x gives trend values and \n y the respective forecasted values");
            obj.line_eqn(x,y,n);
            obj.mse(x,y,y_est,n);
            System.out.println("Do you wish to continue (Y/N)");
            ch = br.readLine();
        }
        while(ch.equals("Y")||ch.equals("y"));
        System.out.println("See you soon");
    }
}
