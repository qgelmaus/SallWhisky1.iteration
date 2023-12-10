package gui;

import application.model.Medarbejder;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class MedarbejderPane extends GridPane {

    private String vindueNavn = "Medarbejder";


    public MedarbejderPane(){
        setHgap(5);
        setVgap(10);


        Button lukButton = new Button("Luk");
        Button opretButton = new Button("Opret");


        Label navnLabel = new Label("Navn:");
        Label idLabel = new Label("ID:");
        TextField navnTxF = new TextField();
        TextField idTxf = new TextField();


        add(navnLabel, 0, 0);
        add(navnTxF,1 ,0);
        add(idLabel, 0, 1 );
        add(idTxf, 1, 1);
        add(lukButton, 0, 8);
        add(opretButton, 1, 8);

        lukButton.setOnAction(e -> lukVindue());
        opretButton.setOnAction(e -> opretObjekt(navnTxF.getText(), idTxf.getText()));
    }

    private void opretObjekt(String navn, String id) {
        //TODO Brug controller til at oprette objekter
        lukVindue();
    }

    private void lukVindue() {
        Stage stage = (Stage) getScene().getWindow();
        stage.close();
    }
    @Override
    public String toString(){
        return vindueNavn;
    }



}
