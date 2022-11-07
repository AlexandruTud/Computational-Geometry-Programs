package solutia4;
import javax.swing.*;
import java.awt.*;
public class Solutia4 {
    public static void printeaza(Point[] M,int lungime){ 
        for(int i=0;i < lungime;i++)
            System.out.println(M[i]);
    }
    public static void ordoneaza(Point[] M,int lungime) { 
        Point temp = new Point(0,0);
        for (int i = 0; i < lungime; i++) {
            for (int j = 1; j < lungime ; j++) {
                if(M[j-1].x > M[j].x)
                {
                    temp.x =M[i].x;
                    M[i].x =M[j].x;
                    M[j].x =temp.x;
                }
            }
        }
    }
    public static int apartine(Point[] M,int n){ 
        for(int i=0;i < M.length;i++)
            if(M[i].x == n)
                return i;
        return -1;

    }
    public static void main(String[] args) {
        //cream multimile A,B,C
        String pxA0;int xA0;
        pxA0 = JOptionPane.showInputDialog("Introduceti xA0:");
        xA0 = Integer.parseInt(pxA0);
        String pxA1;int xA1;
        pxA1 = JOptionPane.showInputDialog("Introduceti xA1:");
        xA1 = Integer.parseInt(pxA1);
        String pxA2;int xA2;
        pxA2 = JOptionPane.showInputDialog("Introduceti xA2:");
        xA2 = Integer.parseInt(pxA2);
        
        String pxB0;int xB0;
        pxB0 = JOptionPane.showInputDialog("Introduceti xB0:");
        xB0 = Integer.parseInt(pxB0);
        String pxB1;int xB1;
        pxB1 = JOptionPane.showInputDialog("Introduceti xB1:");
        xB1 = Integer.parseInt(pxB1);
        String pxB2;int xB2;
        pxB2 = JOptionPane.showInputDialog("Introduceti xB2:");
        xB2 = Integer.parseInt(pxB2);
        
        String pxC0;int xC0;
        pxC0 = JOptionPane.showInputDialog("Introduceti xC0:");
        xC0 = Integer.parseInt(pxC0);
        String pxC1;int xC1;
        pxC1 = JOptionPane.showInputDialog("Introduceti xC1:");
        xC1 = Integer.parseInt(pxC1);
        
        Point[] A= new Point[3];
        A[0]=new Point(xA0,0);
        A[1]=new Point(xA1,0);
        A[2] =new Point(xA2,0);
        Point[] B= new Point[3];
        B[0]=new Point(xB0,1);
        B[1]=new Point(xB1,1);
        B[2] =new Point(xB2,1);
        Point[] C= new Point[2];
        C[0]=new Point(xC0,2);
        C[1]=new Point(xC1,2);
        //ordonam multimile B si C
        ordoneaza(B,B.length);
        ordoneaza(C,C.length);
        //formam o noua multime D = 2*B[i]
        Point[] D= new Point[B.length];
        for(int i=0;i<B.length;i++){
            D[i] = new Point(2*B[i].x,1);
        }
        
        boolean flag = false;
        for(int i=0;i < A.length;i++){ 
            for(int j=0;j < C.length;j++){
                if(apartine(D,A[i].x+C[j].x)!= -1) {
                    JOptionPane.showMessageDialog(null, "Exista puncte coliniare!");
                    flag = true;
                    return;
                }
            }
        }
        if(flag==false)
            JOptionPane.showMessageDialog(null,"Nu exista puncte coliniare!");
    } 
}
