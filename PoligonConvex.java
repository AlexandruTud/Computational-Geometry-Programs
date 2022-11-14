package poligonconvex;
import java.awt.Point;
import javax.swing.JOptionPane;
public class PoligonConvex {
    
    public static int produsVectorial(int A[][])
    {
        return (A[1][0] - A[0][0]) * (A[2][1] - A[0][1]) - (A[1][1] - A[0][1]) * (A[2][0] - A[0][0]);
    }
    
    public static boolean verificareConvex(int puncte[][])
    {
        int n = puncte.length;
        int inainte = 0;
        int dupa = 0;
        for (int i = 0; i < n; i++) {
            int temp[][]= { puncte[i], puncte[(i + 1) % n], puncte[(i + 2) % n] };
            dupa = produsVectorial(temp);
            if (dupa != 0) 
            {
                if (dupa * inainte < 0) {
                    return false;
                }
                else 
                {
                    inainte = dupa;
                }
            }
        }
        return true;
    }
    
    public static boolean esteInauntru(Point[] puncte, int n, Point p) {
	int i;
	boolean inauntru = false;
	for (i = 0; i < n; i++) {
            if ((puncte[i].y < p.y && puncte[(i + 1) % n].y >= p.y || puncte[(i + 1) % n].y < p.y && puncte[i].y >= p.y)) 
                if (puncte[i].x + (p.y - puncte[i].y) / (puncte[(i + 1)].x - puncte[i].x)* (puncte[(i + 1)].x - puncte[i].x) < p.x )  
                    return !inauntru;
        } 
        return inauntru;
    }  
    
    public static void main(String [] args)
    {
        //introducem aceleasi puncte pentru metoda verificareConvex si pentru metoda esteInauntru 
        int puncte[][] = { {4,0}, {8,7}, {5,10}, {1,10}, {-2,3} };
        Point[] P= {new Point(4,0), new Point(8,7),new Point(5,10),new Point(1,10), new Point(-2,3)};
        int n=P.length;
        String pxP;int xP;
        pxP = JOptionPane.showInputDialog("Introduceti xP:");
        xP = Integer.parseInt(pxP);
        String pyP;int yP;
        pyP = JOptionPane.showInputDialog("Introduceti yP:");
        yP = Integer.parseInt(pyP);
        Point p = new Point(xP,yP);
        if (!verificareConvex(puncte))
        {
            JOptionPane.showMessageDialog(null, "Poligon nu este convex!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Poligon este convex!");
            JOptionPane.showMessageDialog(null, "Punctul P("+xP+","+yP+") este in poligon: "+esteInauntru(P,n,p));
        }
    }
}
