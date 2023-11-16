package ba.unsa.etf.rpr;
import java.util.Objects;
public class MedunarodniBroj extends TelefonskiBroj{
    private String drzava;
    private String broj;
    public MedunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = broj;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MedunarodniBroj that = (MedunarodniBroj) o;
        return Objects.equals(drzava, that.drzava) && Objects.equals(broj, that.broj);
    }
    @Override
    public int hashCode() {
        return Objects.hash(drzava, broj);
    }
    public String getDrzava() {
        return drzava;
    }
    public String getBroj() {
        return broj;
    }
    @Override
    public String ispisi() {
        return getDrzava()+"/"+getBroj();
    }
}
