package ba.unsa.etf.rpr.lv7_8_z2;

import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class Korisnik {
    private SimpleStringProperty ime, prezime, email, korisnickoIme, lozinka;

    public Korisnik() {
        this.ime=new SimpleStringProperty("");
        this.prezime=new SimpleStringProperty("");
        this.email=new SimpleStringProperty("");
        this.korisnickoIme=new SimpleStringProperty("");
        this.lozinka=new SimpleStringProperty("");
    }
    public Korisnik(String ime, String prezime, String email, String korisnickoIme, String lozinka){
        this.ime=new SimpleStringProperty(ime);
        this.prezime=new SimpleStringProperty(prezime);
        this.email=new SimpleStringProperty(email);
        this.korisnickoIme=new SimpleStringProperty(korisnickoIme);
        this.lozinka=new SimpleStringProperty(lozinka);
    }

    public String getIme() {
        return ime.get();
    }
    public SimpleStringProperty imeProperty() {
        return ime;
    }
    public void setIme(String ime) {
        this.ime.set(ime);
    }
    public String getPrezime() {
        return prezime.get();
    }
    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }
    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }
    public String getEmail() {
        return email.get();
    }
    public SimpleStringProperty emailProperty() {
        return email;
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
    public String getKorisnickoIme() {
        return korisnickoIme.get();
    }
    public SimpleStringProperty korisnickoImeProperty() {
        return korisnickoIme;
    }
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme.set(korisnickoIme);
    }
    public String getLozinka() {
        return lozinka.get();
    }
    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }
    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            System.out.println("nije ta instanca");
            return false;
        };
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(getKorisnickoIme(), korisnik.getKorisnickoIme());
    }
    public String toString(){
        return this.getKorisnickoIme();
    }
    public void obrisiSvePodatkeKorisnika(){
        this.ime.set("");
        this.prezime.set("");
        this.email.set("");
        this.korisnickoIme.set("");
        this.lozinka.set("");
    }

}
