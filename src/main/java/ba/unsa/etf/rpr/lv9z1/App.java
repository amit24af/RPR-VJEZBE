package ba.unsa.etf.rpr.lv9z1;
import java.sql.SQLException;
import java.util.ArrayList;
public class App {
    public static GeografijaDAO dao;
    public static void main(String[] args) {
        try {
            dao = GeografijaDAO.getInstance();
            ArrayList<Grad> gradovi = new ArrayList<>();
            gradovi = dao.gradovi();

            for (Grad g : gradovi) {
                System.out.println("- "+g.getNaziv() + ", " + g.getDrzava().getNaziv() + " " +
                        "[broj stanovnika: " + g.getBrojStanovnika()+"]");
            }

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }



    }
}
