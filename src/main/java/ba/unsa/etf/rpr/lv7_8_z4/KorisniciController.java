package ba.unsa.etf.rpr.lv7_8_z4;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class KorisniciController {
    public TextField imeId,prezimeId,emailId, korisnickoImeId,lozinkaId;
    public ListView<Korisnik> listViewId;
    public Button bttnKraj;
    public Button bttnDodaj;
    private KorisniciModel model;
    //public KorisniciModel model=new KorisniciModel();
    @FXML
    public void initialize(){
        listViewId.setItems(model.getListaKorisnika());
        model.trenutniKorisnikProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if(oldKorisnik!=null){
                imeId.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
                prezimeId.textProperty().unbindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
                emailId.textProperty().unbindBidirectional(model.getTrenutniKorisnik().emailProperty());
                korisnickoImeId.textProperty().unbindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
                lozinkaId.textProperty().unbindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
            }
            if(newKorisnik!=null) {
                imeId.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
                prezimeId.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
                emailId.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
                korisnickoImeId.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
                lozinkaId.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
            }
        });
        model.dodajNovogKorisnikaBezPodataka();
        listViewId.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik)-> {
            model.setTrenutniKorisnik(newKorisnik);
            listViewId.refresh();}
        );
    }

        //model.evidentirajNovogKorisnika();

    //    model.getListaKorisnika().add(new Korisnik());
     //   model.ispisiTrenutni();
      //  model.setTrenutniKorisnik(model.getListaKorisnika().getLast());*/

    public void onBttnDodaj(ActionEvent actionEvent) {
       /* model.ispisiTrenutni();*/
        //System.out.println("imeId.getText());
        if(!model.podaciTrenutnogKorisnikaUneseni()){
            Alert upozorenje = new Alert(Alert.AlertType.ERROR);
            upozorenje.setHeaderText("Niste popunili sva polja forme!");
            upozorenje.showAndWait();
            if(model.trenutniKorisnikBezLozinkeE()){
                lozinkaId.getStyleClass().add("poljeNesipravno"); lozinkaId.requestFocus();
            }else{
                lozinkaId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(model.trenutniKorisnikBezKorImenaE()){
                korisnickoImeId.getStyleClass().add("poljeNesipravno"); korisnickoImeId.requestFocus();
            }else{
                korisnickoImeId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(model.trenutniKorisnikBezEmailaE()){
                emailId.getStyleClass().add("poljeNesipravno"); emailId.requestFocus();
            }else{
                emailId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(model.trenutniKorisnikBezPrezimenaE()){
                prezimeId.getStyleClass().add("poljeNesipravno"); prezimeId.requestFocus();
            }else{
                prezimeId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(model.trenutniKorisnikBezImenaE()){
                imeId.getStyleClass().add("poljeNesipravno"); imeId.requestFocus();
            }else{
                imeId.getStyleClass().removeAll("poljeNesipravno");
            }
        }else{
            //model.getListaKorisnika().add(model.getTrenutniKorisnik());
            if(!model.izmjenaKorisnika){
                if(!model.dodajNovogKorisnikaUListu()){
                    Alert upozorenje2=new Alert(Alert.AlertType.ERROR);
                    upozorenje2.setHeaderText("Korisnik "+korisnickoImeId.getText()+" vec postoji!");
                    upozorenje2.showAndWait();
                }
            }else{
                listViewId.getSelectionModel().getSelectedItem().setKorisnik(model.getTrenutniKorisnik());
            }System.out.println("trenutni korisnik: "+model.getTrenutniKorisnik());
            listViewId.setItems(model.getListaKorisnika());
            model.ispisiListu();
            model.dodajNovogKorisnikaBezPodataka();
            imeId.getStyleClass().removeAll("poljeNesipravno"); prezimeId.getStyleClass().removeAll("poljeNesipravno"); emailId.getStyleClass().removeAll("poljeNesipravno"); korisnickoImeId.getStyleClass().removeAll("poljeNesipravno"); lozinkaId.getStyleClass().removeAll("poljeNesipravno");
            imeId.requestFocus();
        }
    }
    public void onBttnKraj(ActionEvent actionEvent) {
        Stage stage=(Stage)bttnKraj.getScene().getWindow();
        stage.close();
    }
    public KorisniciController(KorisniciModel model) {
        this.model=model;
    }
}