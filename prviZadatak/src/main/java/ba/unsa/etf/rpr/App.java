package ba.unsa.etf.rpr;
import java.util.Scanner;
public class App{
    public static long faktorijelF(int m){
        long fact=1;
        for(int i=1; i<=m; i++){fact=fact*i;}
        return fact;
    }
    public static double sinus(double n){
        double vrijednost=n;
        double stepen=n;
        double faktorijel=1;
        int znak=-1;
        for(int i=2; i<=17; i++){
            stepen*=(n);
            faktorijel=faktorijelF(i);
            if(i%2!=0){
                /*
                 *System.out.println("stepen: "+stepen);
                 *System.out.println("faktorijel: "+faktorijel);*/
                vrijednost=vrijednost+(znak)*(stepen/(faktorijel)); /*
                 *System.out.println("(stepen/(faktorijel)): "+(stepen/(faktorijel)));
                 *System.out.println("znak: "+znak); */
                /*System.out.println("Oduzima se;"+faktorijel+" :f, "+stepen+" :s, vrijednost:"+vrijednost);*/
                znak*=-1;
            }
        }return vrijednost;
    }
    public static void main(String[] args){
        System.out.print("Sinus "+(double)Double.parseDouble(args[0])+" iznosi: ");
        System.out.print("("+sinus((double)Double.parseDouble(args[0]))+").");
        System.out.println("  \\\\ ("+java.lang.Math.sin((double)Double.parseDouble(args[0]))+").");
        System.out.print("Faktorijel "+(args[0]).toString()+" iznosi: ");
        System.out.println("("+faktorijelF((int)Double.parseDouble(args[0]))+").");
    }
}