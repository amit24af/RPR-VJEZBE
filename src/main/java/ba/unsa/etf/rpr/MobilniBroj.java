package ba.unsa.etf.rpr;
import java.util.Objects;
public class MobilniBroj extends TelefonskiBroj{
    private int mobilnaMreza;
    private String broj;
    public MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza=mobilnaMreza;
        this.broj=broj;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilniBroj that = (MobilniBroj) o;
        return mobilnaMreza == that.mobilnaMreza && Objects.equals(broj, that.broj);
    }
    @Override
    public int hashCode() {
        return Objects.hash(mobilnaMreza, broj);
    }
    @Override
    public String ispisi() {
        return "0" + this.getMobilnaMreza() + "/" + broj;
    }
    public int getMobilnaMreza() {
        return mobilnaMreza;
    }
}
