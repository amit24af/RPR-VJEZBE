package ba.unsa.etf.rpr.prvizadatak;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class KorisniciController {
    public ListView listView;
    public Button dodajId;
    public Button krajId;
    public TextField emailId;
    public TextField korisnickoImeId;
    public TextField lozinkaId;
    public TextField prezimeId;
    public TextField imeId;
    public ListView listViewId;
    public ObservableList<String> lista= FXCollections.observableArrayList();
    public Button bttnKraj;

    public void onBttnDodaj(ActionEvent actionEvent) {
        if(imeId.getText().isEmpty() || prezimeId.getText().isEmpty() ||
           korisnickoImeId.getText().isEmpty() || lozinkaId.getText().isEmpty() || emailId.getText().isEmpty()){
            Alert upozorenje = new Alert(Alert.AlertType.ERROR);
            upozorenje.setHeaderText("Niste popunili sva polja forme!");
            upozorenje.showAndWait();
            if(lozinkaId.getText().isEmpty()){
                lozinkaId.getStyleClass().add("poljeNesipravno"); lozinkaId.requestFocus();
            }else{
                lozinkaId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(korisnickoImeId.getText().isEmpty()){
                korisnickoImeId.getStyleClass().add("poljeNesipravno"); korisnickoImeId.requestFocus();
            }else{
                korisnickoImeId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(emailId.getText().isEmpty()){
                emailId.getStyleClass().add("poljeNesipravno"); emailId.requestFocus();
            }else{
                emailId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(prezimeId.getText().isEmpty()){
                prezimeId.getStyleClass().add("poljeNesipravno"); prezimeId.requestFocus();
            }else{
                prezimeId.getStyleClass().removeAll("poljeNesipravno");
            }
            if(imeId.getText().isEmpty()){
                imeId.getStyleClass().add("poljeNesipravno"); imeId.requestFocus();
            }else{
                imeId.getStyleClass().removeAll("poljeNesipravno");
            }
        }else{
            if(!lista.contains(korisnickoImeId.getText())) {
                lista.add(korisnickoImeId.getText());
                listViewId.setItems(lista);
            }else{
                Alert upozorenje2=new Alert(Alert.AlertType.ERROR);
                upozorenje2.setTitle("Uneseni podaci nisu validni.");
                upozorenje2.setHeaderText("Korisnik "+korisnickoImeId.getText()+" vec postoji!");
                upozorenje2.showAndWait();
            }
            imeId.getStyleClass().removeAll("poljeNesipravno"); prezimeId.getStyleClass().removeAll("poljeNesipravno"); emailId.getStyleClass().removeAll("poljeNesipravno"); korisnickoImeId.getStyleClass().removeAll("poljeNesipravno"); lozinkaId.getStyleClass().removeAll("poljeNesipravno");
            imeId.setText(""); prezimeId.setText(""); emailId.setText(""); korisnickoImeId.setText(""); lozinkaId.setText("");
            imeId.requestFocus();
        }
    }

    public void onBttnKraj(ActionEvent actionEvent) {
        Stage stage=(Stage)bttnKraj.getScene().getWindow();
        stage.close();
    }
}
