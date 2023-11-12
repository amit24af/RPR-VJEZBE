package ba.unsa.etf.rpr;
import java.util.Scanner;
public class SumaCifara {
    public static void main(String[] args) {
        int n;
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite broj: ");
        n = ulaz.nextInt();
        System.out.println("Brojevi između 1 i "+n +" koji su djeljivi sa sumom svojih cifara: ");
        for(int i=1; i<=n; i++){
            if(i% sumaCifara(i)==0){
                System.out.println(i);
            }
        }
    }

    private static int sumaCifara(int n){
        int suma=0, pom=n;
        for(int i=0; i<n; i++){
            suma+=pom%10;
            pom=pom/10;
        }
        return suma;
    }
}
