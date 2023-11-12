package ba.unsa.etf.rpr;
import java.util.Random;
public class App {
    public static void main(String[] args){
        Banka novaBanka=new Banka();
        Korisnik prvi=novaBanka.kreirajNovogKorisnika("prvi", "korisnik1");
        Korisnik drugi=novaBanka.kreirajNovogKorisnika("drugi", "korisnik2");
        Korisnik treci=novaBanka.kreirajNovogKorisnika("treci", "korisnik3");
        System.out.println("Banka ima "+novaBanka.brojKorisnikaBanke()+" korisnika.");
        novaBanka.kreirajRacunZaSveKorisnike();
        novaBanka.kreirajRacunZaSveKorisnike();
        System.out.println(novaBanka);
        Banka NLB=new Banka();
        System.out.println(NLB);

    }
}