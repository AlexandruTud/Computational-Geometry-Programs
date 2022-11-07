package localizaretriunghi;
import javax.swing.*;
public class LocalizareTriunghi {
    //A(xA,yA) B(xB,yB) C(xC,yC) P(xP,yP)
    public static double area(int xA, int yA, int xB, int yB, int xC, int yC)
    {
        return Math.abs((xA*(yB-yC) + xB*(yC-yA)+ xC*(yA-yB))/2.0); //aflam aria triunghiului si returnam valoarea absoluta(distanta dintre numar si originea 0,care este mereu pozitiva)
    }
    public static boolean esteInauntru(int xA, int yA, int xB, int yB, int xC, int yC, int xP, int yP)
    {
        // Calcul ariile triunghiului ABC si cele formate cu punctul P
        double ArieABC = area (xA, yA, xB, yB, xC, yC);
        double AriePBC = area (xP, yP, xB, yB, xC, yC);
        double AriePAC = area (xA, yA, xP, yP, xC, yC);
        double AriePAB = area (xA, yA, xB, yB, xP, yP);
        return (ArieABC == AriePBC + AriePAC + AriePAB);
    }
    public static void main(String[] args) {
        String pxA;int xA;
        pxA = JOptionPane.showInputDialog("Introduceti xA:");
        xA = Integer.parseInt(pxA);
        String pyA;int yA;
        pyA = JOptionPane.showInputDialog("Introduceti yA:");
        yA = Integer.parseInt(pyA);
        String pxB;int xB;
        pxB = JOptionPane.showInputDialog("Introduceti xB:");
        xB = Integer.parseInt(pxB);
        String pyB;int yB;
        pyB = JOptionPane.showInputDialog("Introduceti yB:");
        yB = Integer.parseInt(pyB);
        String pxC;int xC;
        pxC = JOptionPane.showInputDialog("Introduceti xC:");
        xC = Integer.parseInt(pxC);
        String pyC;int yC;
        pyC = JOptionPane.showInputDialog("Introduceti yC:");
        yC = Integer.parseInt(pyC);
        String pxP;int xP;
        pxP = JOptionPane.showInputDialog("Introduceti xP:");
        xP = Integer.parseInt(pxP);
        String pyP;int yP;
        pyP = JOptionPane.showInputDialog("Introduceti yP:");
        yP = Integer.parseInt(pyP);
        
        int detPAB = xP * (yA - yB) + xA * (yB - yP) + xB * (yP - yA);
        int detPBC = xP * (yB - yC) + xB * (yC - yP) + xC * (yP - yB);
        int detPCA = xP * (yC - yA) + xC * (yA - yP) + xA * (yP - yC);
    
        if (esteInauntru(xA,yA,xB,yB,xC,yC,xP,yP))
            JOptionPane.showMessageDialog(null, "Punctul P se afla in triunghi!");
        else
            JOptionPane.showMessageDialog(null, "Punctul P nu se afla in triunghi!");
        
    if(detPAB > 0 && detPBC > 0 && detPCA > 0){
        JOptionPane.showMessageDialog(null, "Punctul se afla in zona 1!");}
    else if(detPAB < 0 && detPBC > 0 && detPCA < 0){
        JOptionPane.showMessageDialog(null, "Punctul se afla in zona 2!");}
    else if(detPAB < 0 && detPBC < 0 && detPCA > 0){
        JOptionPane.showMessageDialog(null, "Punctul se afla in zona 3!");}
    else if(detPAB > 0 && detPBC < 0 && detPCA < 0){
        JOptionPane.showMessageDialog(null, "Punctul se afla in zona 4!");}
    else if(detPAB > 0 && detPBC < 0 && detPCA > 0){
        JOptionPane.showMessageDialog(null, "Punctul se afla in zona 5!");}
    else if(detPAB > 0 && detPBC > 0 && detPCA < 0){
        JOptionPane.showMessageDialog(null, "Punctul se afla in zona 6!");}
    else if(detPAB < 0 && detPBC > 0 && detPCA > 0){
        JOptionPane.showMessageDialog(null, "Punctul se afla in zona 7!");}
    }
    
}
