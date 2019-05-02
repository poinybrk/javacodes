import java.io.*; 
import java.util.*;

class Calc{
    static double mean(int a[],int n){		
        double sum = 0;
        for (int i=0; i<n; i++){	
            sum = sum + a[i];
        }
        double average = (sum/n);
        return average;
    }
    static double variance(int a[], int n){
        int sum1 = 0;
        for (int j=0; j<n; j++){
            sum1 = sum1 + a[j]*a[j];
        }
        double  Variance = (sum1/n) - mean(a, n)*mean(a, n);
        return Variance;
    }
    static double geometric_mean(int a[],int n){
        int prod = 1;
        for (int i=0; i<n; i++){
            prod = prod * a[i];}
        double average = Math.pow(prod,1.0/n);
        return average;
    }
    static double harmonic_mean(int a[],int n){
        double sum = 0.0;
        for (int i=0; i<n; i++){
            sum = sum + (1.0/a[i]);
        }
        double average = (sum/n);
        double average1 = (1.0/average);
        return average1;
    }
    static double covariance(int a[],int b[],int n){
        double covariance = 0.0;
        for (int j=0; j<n; j++){
            covariance = (covariance +((a[j] - mean(a,n))*(b[j] - mean(b,n))));
        }
        return covariance;
    }
    static double moment1(int a[], int n){
        double sum2 = 0,sum3=0;
        for (int j=0; j<n; j++){
            sum2 = sum2 + a[j]*a[j];
            sum3 = sum3 + Math.pow(a[j],3);
        }
        double  mu2 = sum2/n;
        double  mu3 = sum3/n;
        double mo3=mu3-(3*mu2*mean(a,n))+(2*Math.pow(mean(a,n),3));
        return mo3;
    }
    static double moment2(int a[], int n){
        double sum2 = 0,sum3=0,sum4=0;
        for (int j=0; j<n; j++){
            sum2 = sum2 + a[j]*a[j];
            sum3 = sum3 + Math.pow(a[j],3);
            sum4 = sum4 + Math.pow(a[j],4);
        }
        double  mu2 = sum2/n;
        double  mu3 = sum3/n;
        double  mu4 = sum4/n;
        double mo4=mu4-(4*mu3*mean(a,n))+(6*mu2*Math.pow(mean(a,n),2))-(3*Math.pow(mean(a,n),4));
        return mo4;
    }
    static double skewness(int a[], int n){
        double m3=moment1(a, n);
        double skew = (Math.pow(m3,2))/(Math.pow(variance(a,n),3));
        return skew;
    }
    static double kurtosis(int a[], int n){
        double m4=moment2(a,n);
        double kurt=m4/(Math.pow(variance(a,n),2));
        return kurt;
    }
    static double th_mu(int a[], int n){
        double sum3=0;
        for (int j=0; j<n; j++){
            sum3 = sum3 + Math.pow(a[j],3);
        }
        double  mu3 = sum3/n;
        return mu3;
    }
    public static void main(String [] args) throws IOException {
        System.out.println("Enter the number of observations ");
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        int ch = 0;
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        System.out.println("Enter the values for the first dataset ");
        for(int k = 0; k<n; k++){
            a[k] = sc.nextInt();
        }
        // taking the first dataset
        System.out.println("Enter the values for second dataset ");
        for(int k = 0; k<n; k++){
            b[k] = sc.nextInt();
            // taking the second dataset
        }
        int choice;
        do{
            System.out.println("Menu driven Statistical Calculator");
            System.out.println();
            System.out.println("1.Mean");
            System.out.println("2.Harmonic Mean");
            System.out.println("3.Geometric Mean");
            System.out.println("4.Variance");
            System.out.println("5.Standard Error");
            System.out.println("6.Skewness");
            System.out.println("7.Kurtosis");
            System.out.println("8.Covariance");
            System.out.println("9.Regression Coefficient");
            System.out.println("10.3rd moment about origin");
            System.out.println();
            System.out.println("Choose any of the above options");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    double mean1 = mean(a,n);
                    double mean2 = mean(b,n);
                    System.out.println("The mean of the first set of entered numbers is " + mean1);
                    System.out.println("The mean of the second set of entered numbers is " + mean2);
                    break;
                case 2:
                    double harm1= harmonic_mean(a,n);
                    double harm2= harmonic_mean(b,n);
                    System.out.println("The harmonic mean of the first set of entered numbers is " + harm1);
                    System.out.println("The harmonic mean of the second set of entered numbers is " + harm2);
                    break;
                case 3:
                    double geom1= geometric_mean(a,n);
                    double geom2= geometric_mean(b,n);
                    System.out.println("The geometric mean of the first set of entered numbers is " + geom1);
                    System.out.println("The geometric mean of the second set entered numbers is " + geom2);
                    break;
                case 4:
                    double variance1= variance(a,n);
                    double variance2= variance(b,n);
                    System.out.println("The variance of the first set of entered numbers is " + variance1);
                    System.out.println("The variance of the second set of entered numbers is " + variance2);
                    break;
                case 5:
                    double sd1= variance(a,n);
                    double sd2= variance(b,n);
                    System.out.println("The standard error of the first set of entered numbers is " + Math.sqrt(sd1));
                    System.out.println("The standard error of the second set of entered numbers is " + Math.sqrt(sd2));
                    break;
                case 6:
                    double skew1 = skewness(a,n);
                    double skew2 = skewness(b,n);
                    System.out.println("The skewness of the first set of entered numbers is " + skew1);
                    System.out.println("The skewness of the second set of entered numbers is " + skew2);
                    break;
                case 7:
                    double kurt1= kurtosis(a,n);
                    double kurt2= kurtosis(b,n);
                    System.out.println("The kurtosis of the first set of entered numbers is " + kurt1);
                    System.out.println("The kurtosis of the second set of entered numbers is " + kurt2);
                    break;
                case 8:
                    double covar1 = covariance(a,b,n);
                    System.out.println("The covariance of the given data is " + covar1);
                    break;
                case 9:
                    double regression1= covariance(a,b,n)/variance(a,n);
                    double regression2= covariance(a,b,n)/variance(b,n);
                    System.out.println("The regression coefficient of  X on Y is " + regression2);
                    System.out.println("The regression coefficient of  Y on X is " + regression1);
                    break;
                case 10:
                    double m31 = th_mu(a,n);
                    double m32 = th_mu(b,n);
                    System.out.println("The third moment about origin of the first set of entered numbers is " + m31);
                    System.out.println("The third moment about origin of the second set of entered numbers is " + m32);
                case 11:
                    System.out.println("Thank You for Using the Calculator");
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break;
            }
            System.out.println("Do you wish to perform anyother calculation? (1/2) ");
            System.out.println("Press 1- Continue");
            System.out.println("Press 2- End");
            ch = sc.nextInt();
        }
        while(ch == 1);
        System.out.println("See You Soon :* ");
    }
}
