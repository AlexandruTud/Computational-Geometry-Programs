package poligonsimplufinal;
import javax.swing.JOptionPane;
public class PoligonSimpluFinal {
    private static final double EPS = 1e-9;
    public static void main(String[] args) {
        String pn;int n;
        pn = JOptionPane.showInputDialog("Introduceti cate puncte are poligonul:");
        n = Integer.parseInt(pn);
        int[] x = new int[n];
        int[] y = new int[n];
        int x1,x2;
        int intersectii = 0;
        if(n<3){
            JOptionPane.showMessageDialog(null, "Figura dumneavoastra nu este poligon!");
        }
        else{
            for(int i=0;i<n;i++){
                x[i]=Integer.parseInt(JOptionPane.showInputDialog("Introduceti x["+i+"]="));
                y[i]=Integer.parseInt(JOptionPane.showInputDialog("Introduceti y["+i+"]="));
            }
            String pxP;int xP;
            pxP = JOptionPane.showInputDialog("Introduceti xP:");
            xP = Integer.parseInt(pxP);
            String pyP;int yP;
            pyP = JOptionPane.showInputDialog("Introduceti yP:");
            yP = Integer.parseInt(pyP);
            for(int i=0;i < n;i++){
                if(x[i] < x[(i+1) % n]){
                    x1 = x[i];
                    x2 = x[(i+1) % n];
                } else {
                    x1 = x[(i+1) % n];
                    x2 = x[i];
                }
                if( xP > x1 && xP <= x2 && (yP < y[i] || yP <= y[(i+1)%n]))
                {
                    double eps = 0.000001;
                    float dx = x[(i+1)%n] - x[i];
                    float dy = y[(i+1)%n] - y[i];
                    double inf = Double.POSITIVE_INFINITY;
                    int k;
                    if(Math.abs(dx) < EPS)
                        k = (int) inf;
                    else
                        k = (int) (dy/dx);
                    float m = y[i] - k * x[i];
                    float y2 = k * xP + m;
                    if(yP <= y2)
                        intersectii++;
                }
        }
        JOptionPane.showMessageDialog(null, "Se intersecteaza in "+intersectii+" linii!");
        if(intersectii % 2 == 1) //daca nr de intersectii e impar
            JOptionPane.showMessageDialog(null, "Punctul se afla in poligon!");
        else //daca nr de intersectii e par
            JOptionPane.showMessageDialog(null, "Punctul NU se afla in poligon!");
    }
    }
}
