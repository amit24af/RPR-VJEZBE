package ba.unsa.etf.rpr.lv7_8_z2;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class KorisniciController {
    public TextField emailId;
    public TextField korisnickoImeId;
    public TextField lozinkaId;
    public TextField prezimeId;
    public TextField imeId;
    public ListView listViewId;
    public Button bttnKraj;
    public Button bttnDodaj;
    private KorisniciModel model;
    //public KorisniciModel model=new KorisniciModel();
    @FXML
    public void initialize(){
        listViewId.setItems(model.getListaKorisnika());
        model.getTrenutniKorisnik().imeProperty().bindBidirectional(imeId.textProperty());
        model.getTrenutniKorisnik().prezimeProperty().bindBidirectional(prezimeId.textProperty());
        model.getTrenutniKorisnik().emailProperty().bindBidirectional(emailId.textProperty());
        model.getTrenutniKorisnik().korisnickoImeProperty().bindBidirectional(korisnickoImeId.textProperty());
        model.getTrenutniKorisnik().lozinkaProperty().bindBidirectional(lozinkaId.textProperty());
    }
    public void onBttnDodaj(ActionEvent actionEvent) {
        System.out.println(imeId.getText());
        try{
            System.out.println(model.getTrenutniKorisnik().getIme());
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        if(!model.podaciTrenutnogKorisnikaUneseni()){
            Alert upozorenje = new Alert(Alert.AlertType.ERROR);
            upozorenje.setHeaderText("Niste popunili sva polja forme!");
            upozorenje.showAndWait();
            if(model.trenutniKorisnikBezLozinke()){
                lozinkaId.getStyleClass().add("poljeNesipravno"); lozinkaId.requestFocus();
            }else{
                lozinkaId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(model.trenutniKorisnikBezKorImena()){
                korisnickoImeId.getStyleClass().add("poljeNesipravno"); korisnickoImeId.requestFocus();
            }else{
                korisnickoImeId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(model.trenutniKorisnikBezEmaila()){
                emailId.getStyleClass().add("poljeNesipravno"); emailId.requestFocus();
            }else{
                emailId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(model.trenutniKorisnikBezPrezimena()){
                prezimeId.getStyleClass().add("poljeNesipravno"); prezimeId.requestFocus();
            }else{
                prezimeId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(model.trenutniKorisnikBezImena()){
                imeId.getStyleClass().add("poljeNesipravno"); imeId.requestFocus();
            }else{
                imeId.getStyleClass().removeAll("poljeNesipravno");
            }
        }else{
            if(!model.listaKorisnika.contains(model.getTrenutniKorisnik())) {
                model.listaKorisnika.add(new Korisnik(model.getTrenutniKorisnik().getIme(),
                        model.getTrenutniKorisnik().getPrezime(),
                        model.getTrenutniKorisnik().getEmail(),
                        model.getTrenutniKorisnik().getKorisnickoIme(),
                        model.getTrenutniKorisnik().getLozinka()));
                listViewId.setItems(model.listaKorisnika);
            }else{
                Alert upozorenje2=new Alert(Alert.AlertType.ERROR);
                upozorenje2.setTitle("Uneseni podaci nisu validni.");
                upozorenje2.setHeaderText("Korisnik "+korisnickoImeId.getText()+" vec postoji!");
                upozorenje2.showAndWait();
            }
            imeId.getStyleClass().removeAll("poljeNesipravno"); prezimeId.getStyleClass().removeAll("poljeNesipravno"); emailId.getStyleClass().removeAll("poljeNesipravno"); korisnickoImeId.getStyleClass().removeAll("poljeNesipravno"); lozinkaId.getStyleClass().removeAll("poljeNesipravno");
            model.obrisiSvePodatkeTrenutnogKorisnika();
            imeId.requestFocus();
        }
    }
    public void onBttnKraj(ActionEvent actionEvent) {
        Stage stage=(Stage)bttnKraj.getScene().getWindow();
        stage.close();
    }

    public KorisniciController(KorisniciModel model) {
        this.model=model;
        model.trenutniKorisnik.set(new Korisnik());
    }
}
