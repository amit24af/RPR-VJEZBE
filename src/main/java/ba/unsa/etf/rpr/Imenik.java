package ba.unsa.etf.rpr;
import java.util.*;
public class Imenik {
    private Map<String, TelefonskiBroj>brojevi;
    public Imenik(){
        brojevi=new HashMap<String, TelefonskiBroj>();
    }
    public Map<String, TelefonskiBroj> getBrojevi() {
        return brojevi;
    }
    /*upisivanje u mapu*/
    public void dodaj(String ime, TelefonskiBroj telefonskiBr){
        this.brojevi.put(ime, telefonskiBr);
    }
    public String dajBroj(String ime){
        return (this.brojevi.get(ime)).ispisi();
    }
    /*vlasnik telefonskog broja*/
    public String dajIme(TelefonskiBroj telefonskiBr){
        for(Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()){
            if(entry.getValue().equals(telefonskiBr)){
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     *
     * @param slovo
     * @return
     */
    public String naSlovo(char slovo){
        String s=null; int i=1;
        /*klasu Map.Entry koja predstavlja jedan član mape tj. uređeni par ključ-vrijednost*/
        for(Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()){
            String ime=entry.getKey();
            TelefonskiBroj telefonskiBroj=entry.getValue();
            if((entry.getKey()).charAt(0) == slovo){
                s+=i+". " +ime+" - "+ entry.getValue()+"\n"; i=i+1;

            }
        }
        return s;
    }
    public Set<String> izGrada(Grad g){
        Set<String> set = new TreeSet<String>();
        for(Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()){

            if(entry.getValue() instanceof FiksniBroj) {
                FiksniBroj fiksniBroj = (FiksniBroj) entry.getValue();
                if(fiksniBroj.getGrad().equals(g)){
                    set.add(entry.getKey());
                }
            }

        } return set;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> setBrojeva = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });
        for(Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()){
            if(entry.getValue() instanceof FiksniBroj){
                if(((FiksniBroj) entry.getValue()).getGrad().equals(g)){
                    setBrojeva.add(entry.getValue());
                }
            }
        }
        return setBrojeva;
    }

    public void ispisiImenik() {
        int i=1;
        for(Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()){
            System.out.println(i+entry.getKey()+" - "+entry.getValue());
        }
    }
    private int brojBrojevaUImeniku(){
        return this.brojevi.size();
    }

    public void formirajPocetniImenik(){
        if(brojBrojevaUImeniku()==0) {
            this.dodaj("Naida", new MobilniBroj(60, "400-693"));
            this.dodaj("Emin", new MobilniBroj( 62, "282-053"));
            this.dodaj("Mesud", new MedunarodniBroj("+1", "780-9020"));
            this.dodaj("Emina", new FiksniBroj(Grad.ZENICA, "210-090"));
            this.dodaj("Emin", new MobilniBroj( 62, "282-053"));
            this.dodaj("Haris", new MedunarodniBroj("+387", "531-993"));
            this.dodaj("Esma", new FiksniBroj(Grad.MOSTAR, "531-993"));
            this.dodaj("Alija", new MobilniBroj(61, "402-123"));
            this.dodaj("Lena", new FiksniBroj(Grad.LIVNO, "422-129"));
        }else{
            System.out.println("Imenik nije prazan!");
        }
    }
}
