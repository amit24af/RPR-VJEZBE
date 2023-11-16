package ba.unsa.etf.rpr;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {
    public static Imenik imenik=new Imenik();
    @BeforeAll
    public static void setUp() {
        imenik.dodaj("Naida", new MobilniBroj(60, "400-693"));
        imenik.dodaj("Mesud", new MedunarodniBroj("+1", "780-9020"));
        imenik.dodaj("Namik", new FiksniBroj(Grad.TUZLA, "390-125"));
        imenik.dodaj("Emin", new FiksniBroj(Grad.LIVNO, "210-090"));
        imenik.dodaj("Lina", new MobilniBroj(61, "402-123"));
        imenik.dodaj("Asija", new FiksniBroj(Grad.LIVNO, "210-090"));
    }

    @Test
    void dajBrojFound() {
        String broj=imenik.dajBroj("Lina");
        assertEquals(broj,"061/402-123");
    }
/*
*pitati
    @Test
    void dajBrojNotFound() {
        String broj=imenik.dajBroj("Emina");
        assertNull(broj);
    }
*/
    @Test
    void testDodajException() {
        assertThrows(BrojException.class, ()-> {imenik.dodaj("Elma",
                new FiksniBroj(null, "343-223"));});
    }

    @Test
    void dajImeNotFound() {
        String ime = imenik.dajIme(new MobilniBroj(61, "402-123"));
        assertEquals("Lina", ime);
    }
    @Test
    void dajImeFound() {
        String ime = imenik.dajIme(new FiksniBroj(Grad.TUZLA, "390-825"));
        assertNull(ime);
    }
}