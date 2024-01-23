package ba.unsa.etf.rpr.lv9z1;
import java.sql.*;
import java.util.ArrayList;
public class GeografijaDAO {
    private static GeografijaDAO instance=null;
    private Connection conn;
    private PreparedStatement pregledGradovaUpit, dajDrzavuUpit, pregledDrzavaUpit;

    public static GeografijaDAO getInstance() throws SQLException {
        if(instance==null){
            instance=new GeografijaDAO();
        }return instance;
    }
    private GeografijaDAO() {
        try {

            String url="jdbc:sqlite:baza.db";
           // Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        try{
            pregledGradovaUpit=conn.prepareStatement("SELECT * FROM grad WHERE id=13");
            if(pregledGradovaUpit==null){
                System.out.println("koncekcija null");
            }
            pregledDrzavaUpit=conn.prepareStatement("SELECT * FROM drzava");
            dajDrzavuUpit=conn.prepareStatement("SELECT * FROM drzava where id=?");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    Drzava dajDrzavu(int id, Grad g){
        try {

            dajDrzavuUpit.setInt(1, id);
            ResultSet rs=dajDrzavuUpit.executeQuery();
            if(!rs.next()) {
                return null;
            }
            return new Drzava(rs.getInt(1), g, rs.getString(3));
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    ArrayList<Grad> gradovi(){
        System.out.println("u metodi!");
        ArrayList<Grad> listaGradova=new ArrayList<>();
        try{
            if(pregledGradovaUpit!=null){
                System.out.println("case 1!");
            ResultSet rs=pregledGradovaUpit.executeQuery();
                if(rs.next()){
                    System.out.println("Zaista prazno!");
                }
            while(rs.next()){
                System.out.println("nije prazno");
                Grad g=new Grad(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), null);

                Drzava d=dajDrzavu(rs.getInt(4), g);
                g.setDrzava(d);
                listaGradova.add(g);
            }}else{
                System.out.println("case 1!");
                System.out.println("Nema gradova!");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        } System.out.println("ende!");
        return listaGradova;

    }
    ArrayList<Drzava> drzave(){
        ArrayList<Drzava> listaDrzava=new ArrayList<>();
        try{
            ResultSet rs=pregledDrzavaUpit.executeQuery();
            while(rs.next()){
                Drzava g=new Drzava(rs.getInt(1), null, rs.getString(3));
                listaDrzava.add(g);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        } return listaDrzava;
    }
}
