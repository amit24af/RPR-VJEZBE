package ba.unsa.etf.rpr;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class Banka {
    Long brojRacuna;
    private List<Korisnik> korisnici;
    private List<Uposlenik> uposlenici;
    public Banka() {
        korisnici=new ArrayList<Korisnik>();
        uposlenici=new ArrayList<Uposlenik>();
    }
    public Korisnik kreirajNovogKorisnika(String ime, String prezime){
        Korisnik k=new Korisnik(ime, prezime);
        korisnici.add(new Korisnik(ime, prezime));
        return k;
    }
    public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
        Uposlenik u=new Uposlenik(ime, prezime);
        uposlenici.add(u);
        return u;
    }
    public Racun kreirajRacunZaKorisnika(Korisnik korisnik){
        Racun r=null;
        for(int i=0; i<this.korisnici.size(); i++){
            if(this.korisnici.get(i).equals(korisnik)){
                Long brojRacuna=(new Random()).nextLong();
                r=new Racun(brojRacuna, this.korisnici.get(i));
                this.korisnici.get(i).setRacun(r);
                break;
            }
        }
        return r;
    }
    public void kreirajRacunZaSveKorisnike(){
        for(int i=0; i<this.korisnici.size(); i++){
            Long brojRacuna=(new Random()).nextLong();
            Racun r=new Racun(brojRacuna, this.korisnici.get(i));
            this.korisnici.get(i).setRacun(r);
        }
    }

    @Override
    public String toString() {
        String s=null;
        if(korisnici.size()!=0){
            s="Korisnici banke:\n";
            for(int i=0; i<korisnici.size(); i++) {
                s += korisnici.get(i) + "\n";
            }}else s+="\nBanka nema korisnika.\n";
        if(uposlenici.size()!=0){
            s+="Banka ima "+uposlenici.size()+" uposlenika.\n";
        }else s+="Trenutno nema uposlenika.";
        return s;
    }
    public int brojKorisnikaBanke(){
        return korisnici.size();
    }
}