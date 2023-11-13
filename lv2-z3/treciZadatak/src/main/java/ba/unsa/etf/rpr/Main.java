package ba.unsa.etf.rpr;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args){
        List<Double>lista=new ArrayList<Double>();
        Scanner unos=new Scanner(System.in);
        while(true){
            System.out.print("Unesite rijec ili stop: ");
            String s=unos.nextLine();
            if("stop".equalsIgnoreCase(s)){
                break;
            }
            try{
                Double broj=Double.parseDouble(s);
                lista.add(broj);
            }catch(NumberFormatException e){
                System.out.println("Niste unijeli broj. Ponovite unos! ");
                continue;
            }
        }
        System.out.print("Minimalna, maksimalna  i srednja vrijednost vrijednost uzorka (");
        for(int i=1; i<=lista.size(); i++){
            System.out.print(lista.get(i-1));
            if(i!=lista.size()){
                System.out.print(", ");
            }
        }System.out.println(") iznose ("+Ds.min(lista)+", "+Ds.max(lista)+", "+Ds.mean(lista)+"),");
        System.out.print("a standardna devijacija "+Ds.standardna_devijacija(lista)+".");
    }
}
