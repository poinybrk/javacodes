import java.util.*;
import java.io.*;

class Revsum{
    public static void main(String[] args)throws IOException{
        Scanner scanner = new Scanner(System.in);
        int a,sum=0,d ;
        String str,str1="",str_d;
        System.out.println("Enter the number");
        str=scanner.nextLine();
        for(int i=str.length()-1;i>=0;i--)
            str1=str1+str.charAt(i);
        a=Integer.parseInt(str1);
        for(int i=0;i<str.length();i++){
            str_d=str.substring(i,i+1);
            d=Integer.parseInt(str_d);
            sum=sum+d;
        }
        System.out.println("Reverse = "+str1+" Sum = "+sum);
    }
}
