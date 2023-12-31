package ba.unsa.etf.rpr.lv7_8_z4;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    ObservableList<Korisnik> listaKorisnika= FXCollections.observableArrayList();
    SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();
    boolean izmjenaKorisnika=false;
    public ObservableList<Korisnik> getListaKorisnika() {
        return listaKorisnika;
    }
    public void setListaKorisnika(ObservableList<Korisnik> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
    }
    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.izmjenaKorisnika= !trenutniKorisnik.equals(new Korisnik());
        this.trenutniKorisnik.set(new Korisnik(trenutniKorisnik));
    }
    public boolean podaciTrenutnogKorisnikaUneseni(){
        return  !this.getTrenutniKorisnik().getIme().isEmpty() &&
                !this.getTrenutniKorisnik().getPrezime().isEmpty() &&
                !this.getTrenutniKorisnik().getKorisnickoIme().isEmpty() &&
                !this.getTrenutniKorisnik().getEmail().isEmpty() &&
                !this.getTrenutniKorisnik().getLozinka().isEmpty();
    }
    public boolean trenutniKorisnikBezImenaE(){
        return this.getTrenutniKorisnik().getIme().isEmpty();
    }
    public boolean trenutniKorisnikBezPrezimenaE(){
        return this.getTrenutniKorisnik().getPrezime().isEmpty();
    }
    public boolean trenutniKorisnikBezEmailaE(){
        return this.getTrenutniKorisnik().getEmail().isEmpty();
    }
    public boolean trenutniKorisnikBezKorImenaE(){
        return this.getTrenutniKorisnik().getKorisnickoIme().isEmpty();
    }
    public boolean trenutniKorisnikBezLozinkeE(){
        return this.getTrenutniKorisnik().getLozinka().isEmpty();
    }
    public void dodajNovogKorisnikaBezPodataka(){
        this.trenutniKorisnik.set(new Korisnik());
    }
    public boolean dodajNovogKorisnikaUListu(){
        if(!this.listaKorisnika.contains(this.getTrenutniKorisnik())){
            return this.listaKorisnika.add(new Korisnik(this.getTrenutniKorisnik()));
        } return false;
    }
    public void napuni(){
        listaKorisnika.add(new Korisnik("Elma", "Elmić", "elmae@gmail.com","eelma1", "elminaloz"));
        listaKorisnika.add(new Korisnik("Kaan", "Kanić", "kaank@gmail.com", "kkanic1", "kaanovaloz"));
        listaKorisnika.add(new Korisnik("Kemo", "Kemić", "kemic@gmail.com", "kkemic1", "keekmdsk"));
        listaKorisnika.add(new Korisnik("Naida", "Naidić", "naidic@gmail.com", "nnaidic1", "nananna"));
    }
    public void ispisiListu(){
        for(Korisnik k:listaKorisnika){
            k.ispisiKorisnika();
        } System.out.println("    --------------      ");
    }

}