package ba.unsa.etf.rpr.lv9z1;
public class Drzava {
    private int id;
    private String naziv;
    private Grad glavniGrad;
    public Drzava(int id, Grad glavniGrad, String naziv){
        this.id=id;
        this.naziv=naziv;
        this.glavniGrad=glavniGrad;
    }
    public Drzava(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public Grad getGlavniGrad() {
        return glavniGrad;
    }
    public void setGlavniGrad(Grad glavniGrad) {
        this.glavniGrad = glavniGrad;
    }
}
