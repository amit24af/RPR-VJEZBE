package ba.unsa.etf.rpr;
import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj implements Comparable{

    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj) {
        if(null == grad) throw new BrojException("Nije moguce kreirati fiksni broj. ");
        this.grad=grad;
        this.broj=broj;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiksniBroj that = (FiksniBroj) o;
        return grad == that.grad && Objects.equals(broj, that.broj);
    }
    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }
    @Override
    public String ispisi() {
        return grad.getPozivniBroj()+"/"+broj;
    }

    public Grad getGrad() {
        return grad;
    }

    @Override
    public int compareTo(Object o) {
        if(this == o) return 1;
        if(o instanceof FiksniBroj){
            var fb=(FiksniBroj)o;
            return (this.ispisi()).compareTo(fb.ispisi());
        }
        return 0;
    }
}
