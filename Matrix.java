import java.io.*;
import java.util.*;
class Matrix{
    void mat_read(int[][] x, int r, int c){
        Scanner sc  = new Scanner(System.in);
        int i,j;
        System.out.println("Enter the matrix row wise");
        for(i=0;i<r;i++){
            for(j=0;j<c;j++)
                x[i][j] = sc.nextInt();
        }
    }
    void mat_write(int[][] z, int r, int c){
        int i,j;
        for(i=0;i<r;i++){
            for(j=0;j<c;j++)
                System.out.print(z[i][j] +"\t");
            System.out.println();
        }
    }
    void mat_add(int[][] x, int[][] y, int[][] z, int r,int c){
        int i,j;
        for(i=0;i<r;i++){
            for(j=0;j<c;j++)
                z[i][j]=x[i][j]+y[i][j];
        }
    }
    void mat_sub(int[][] x, int[][] y, int[][] z, int r,int c){
        int i,j;
        for(i=0;i<r;i++){
            for(j=0;j<c;j++)
                z[i][j]=x[i][j]-y[i][j];
        }
    }
    void mat_mul(int[][] x, int[][] y, int[][] z, int r1,int c2,int c1){
        int i,j,k;
        for(i=0;i<r1;i++)
            for(j=0;j<c2;j++){
                z[i][j]=0;
                for(k=0;k<c1;k++)
                    z[i][j]=z[i][j]+(x[i][k]*y[k][j]);
            }
    }
    void mat_transpose(int[][] a,int[][] z,int r,int c){
        int i,j;
        for(i=0;i<r;i++)
            for(j=0;j<c;j++){
                z[j][i]=a[i][j];
            }
    }
    void symmetric(int[][] a,int r,int c){
        int i,j;
        int count = 0;
        for(i=0;i<r;i++)
            for(j=0;j<c;j++){
                if(a[i][j]!=a[j][i])
                    count++;
            }
        if(count>0)
            System.out.println("Not Symmetric");
        else
            System.out.println("Symmetric");
    }
    void skew_symmetric(int[][] a,int r,int c){
        int i,j;
        int count = 0;
        int count1 = 0;
        for(i=0;i<r;i++)
            for(j=0;j<c;j++){
                if(a[i][j]!= -a[j][i])
                    count++;
                if(a[i][i] != 0)
                    count1++;
            }
        if(count ==0 && count1==0)
            System.out.println("skew-Symmetric");
        else
            System.out.println("not skew-Symmetric");
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Matrix obj = new Matrix();
        int x[][] = new int[50][50];
        int y[][] = new int[50][50];
        int z[][]  = new int[50][50];
        int row1,col1,row2,col2,ch,s,s1;
        int ch1;
        System.out.println("Enter no of rows for first matrix:");
        row1 = sc.nextInt();
        System.out.println("Enter no of columns for first matrix:");
        col1 = sc.nextInt();
        System.out.println("Enter no of rows for second matrix:");
        row2 = sc.nextInt();
        System.out.println("Enter no of columns for second matrix:");
        col2 = sc.nextInt();
        System.out.println("Enter elements of first matrix:");
        obj.mat_read(x,row1,col1);
        System.out.println("Enter elements of second matrix:");
        obj.mat_read(y,row2,col2);
        System.out.println("First matrix entered by user is :");
        obj.mat_write(x,row1,col1);
	System.out.println("Second matrix entered by user is :");
	obj.mat_write(y,row2,col2);
        do{
            System.out.println("Now enter your choice of operations to be performed on matrices :\n 1) Addition\n 2)Subtraction \n 3) Multiplication\n 4) Transpose\n 5) Symmetric Matrix \n 6) Skew Symmetric Matrix");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    if(row1==row2 && col1==col2){
                        obj.mat_add(x,y,z,row1,col1);
                        System.out.println("Sum of two matrices is :");
                        obj.mat_write(z,row1,col1);
                    }
                    else
                        System.out.println("matrices are not compatible for addition");
                    break;
                case 2:
                    if(row1==row2 && col1==col2){
                        obj.mat_sub(x,y,z,row1,col1);
                        System.out.println("Difference of two matrices is :");
                        obj.mat_write(z,row1,col1);
                    }
                    else
                        System.out.println("\nmatrices are not compatible for subtraction");
                    break;
                case 3:
                    if(col1==row2){
                        obj.mat_mul(x,y,z,row1,col2,col1);
                        System.out.println("Multiplication of two matrices is :");
                        obj.mat_write(z,row1,col2);
                    }
                    else
                        System.out.println("matrices are not compatible for multiplication");
                    break;
                case 4:
                    obj.mat_transpose(x,z,row1,col1);
                    System.out.println("Transpose of first matrix is:");
                    obj.mat_write(z,col1,row1);
                    obj.mat_transpose(y,z,row2,col2);
                    System.out.println("Transpose of second matrix is :");
                    obj.mat_write(z,col2,row2);
                    break;
		case 5:
                    System.out.println("The fisrt matrix is:");
                    if(row1==col1){
                        obj.symmetric(x,row1,col1);
                    }
                    else
                        System.out.println("Cannot be checked");
                    System.out.println("The second matrix is:");
                    if(row2==col2){
                        obj.symmetric(y,row2,col2);
                    }
                    else
                        System.out.println("Cannot be checked");
                    break;
                case 6:
                    System.out.println("The fisrt matrix is:");
                    if(row1==col1){
                        obj.skew_symmetric(x,row1,col1);
                    }
                    else
                        System.out.println("Cannot be checked");
                    System.out.println("The second matrix is:");
                    if(row2==col2){
                        obj.skew_symmetric(y,row2,col2);
                    }
                    else
                        System.out.println("Cannot be checked");
                    break;
                default:
                    System.out.println("Wrong choice entered");
                    break;
            }
            System.out.println("1: Continue    2: Exit");
            ch1 = sc.nextInt();
        }
        while(ch1==1);
    }
}
