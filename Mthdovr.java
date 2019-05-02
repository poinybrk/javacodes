import java.io.*;
import java.util.*;
class Display{
    void disp(char c){
        System.out.println(c);
    }
    void disp(int c){
        System.out.println(c);
    }
    void disp(char c, int a){
        System.out.println(c+" "+a);
    }
    void disp(double d, int a){
        System.out.println("I am 4th one");
    }
    void disp(int a, char c){
        System.out.println("I am 5th one");
    }
}
class Mthdovr{
    public static void main(String[] args)throws IOException{
        Display o1 = new Display();
        o1.disp('a');
        o1.disp(10);
        o1.disp('a',7);
        o1.disp(1.25,1);
        o1.disp(1,'z');
    }
}