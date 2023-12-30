package ba.unsa.etf.rpr.lv7_8_z2;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    ObservableList<Korisnik> listaKorisnika= FXCollections.observableArrayList();
    SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();
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
        this.trenutniKorisnik.set(trenutniKorisnik);
    }
    public boolean podaciTrenutnogKorisnikaUneseni(){
        return  !this.getTrenutniKorisnik().getIme().isEmpty() &&
                !this.getTrenutniKorisnik().getPrezime().isEmpty() &&
                !this.getTrenutniKorisnik().getKorisnickoIme().isEmpty() &&
                !this.getTrenutniKorisnik().getEmail().isEmpty() &&
                !this.getTrenutniKorisnik().getLozinka().isEmpty();
    }
    public boolean trenutniKorisnikBezImena(){
        return this.getTrenutniKorisnik().getIme().isEmpty();
    }
    public boolean trenutniKorisnikBezPrezimena(){
        return this.getTrenutniKorisnik().getPrezime().isEmpty();
    }
    public boolean trenutniKorisnikBezEmaila(){
        return this.getTrenutniKorisnik().getEmail().isEmpty();
    }
    public boolean trenutniKorisnikBezKorImena(){
        return this.getTrenutniKorisnik().getKorisnickoIme().isEmpty();
    }
    public boolean trenutniKorisnikBezLozinke(){
        return this.getTrenutniKorisnik().getLozinka().isEmpty();
    }
    public void obrisiSvePodatkeTrenutnogKorisnika(){
        getTrenutniKorisnik().obrisiSvePodatkeKorisnika();
    }
    public void napuni(){
        listaKorisnika.add(new Korisnik("Elma", "Elmić", "elmae@gmail.com","eelma1", "elminaloz"));
        listaKorisnika.add(new Korisnik("Kaan", "Kanić", "kaank@gmail.com", "kkanic1", "kaanovaloz"));
        listaKorisnika.add(new Korisnik("Kemo", "Kemić", "kemic@gmail.com", "kkemic1", "keekmdsk"));
        listaKorisnika.add(new Korisnik("Naida", "Naidić", "naidic@gmail.com", "nnaidic1", "nananna"));
    }

}
