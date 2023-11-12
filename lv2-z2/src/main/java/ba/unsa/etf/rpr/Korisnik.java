package ba.unsa.etf.rpr;

import java.util.Objects;

public class Korisnik extends Osoba {
    private Racun racun;
    public Korisnik(String ime, String prezime) {
        super(ime, prezime);
    }
    void dodajRacun(Racun racun){
        this.racun=racun;
    }
    public Racun getRacun() {
        return racun;
    }
    public void setRacun(Racun racun) {
        this.racun = racun;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(racun, korisnik.racun);
    }

    @Override
    public String toString() {
        return super.toString()
                + ", broj racuna korisnika: " + (this.getRacun()).getBrojRacuna();
    }

}