package ba.unsa.etf.rpr;

public class Racun {
    private Long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private Double stanjeRacuna;
    private Double prekoracenje;
    public Racun(Long brojRacuna, Osoba korisnikRacuna){
        this.brojRacuna=brojRacuna;
        this.korisnikRacuna=korisnikRacuna;
    }

    public boolean izvrsiUplatu(Double iznos){
        if(iznos>0) {
            this.stanjeRacuna += iznos;
            return true;
        } return false;
    }
    public void odobrenjePrekoracenja(Double iznos){
        this.prekoracenje=prekoracenje;
    }
    public boolean provjeriOdobrenjePrekoracenja(Double iznos){
        return this.prekoracenje>iznos;
    }
    public boolean izvrsiIsplatu(Double iznos){
        if(iznos<stanjeRacuna+prekoracenje) {
            this.stanjeRacuna -= iznos;
            return true;
        }
        return false;
    }

    public Double getPrekoracenje() {
        return prekoracenje;
    }
    public void setPrekoracenje(Double prekoracenje) {
        this.prekoracenje = prekoracenje;
    }
    public Long getBrojRacuna() {
        return brojRacuna;
    }
    public void setBrojRacuna(Long brojRacuna) {
        this.brojRacuna = brojRacuna;
    }
    public Osoba getKorisnikRacuna() {
        return korisnikRacuna;
    }
    public void setKorisnikRacuna(Osoba korisnikRacuna) {
        this.korisnikRacuna = korisnikRacuna;
    }
    public boolean isOdobrenjePrekoracenja() {
        return odobrenjePrekoracenja;
    }
    public void setOdobrenjePrekoracenja(boolean odobrenjePrekoracenja) {
        this.odobrenjePrekoracenja = odobrenjePrekoracenja;
    }
    public Double getStanjeRacuna() {
        return stanjeRacuna;
    }
    public void setStanjeRacuna(Double stanjeRacuna) {
        this.stanjeRacuna = stanjeRacuna;
    }

    @Override
    public String toString() {
        return "Racun{" +
                "brojRacuna=" + brojRacuna +
                ", korisnikRacuna=" + korisnikRacuna +
                ", odobrenjePrekoracenja=" + odobrenjePrekoracenja +
                ", stanjeRacuna=" + stanjeRacuna +
                ", prekoracenje=" + prekoracenje +
                '}';
    }

}