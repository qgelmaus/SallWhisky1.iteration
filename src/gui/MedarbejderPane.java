package gui;

import application.model.Medarbejder;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Scanner;

public class MedarbejderPane extends GridPane {

    private String vindueNavn = "Medarbejder";


    public MedarbejderPane(){
        setHgap(5);
        setVgap(10);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(30);

        Button lukButton = new Button("Luk");
        Button opretButton = new Button("Opret");


        Label idLabel = new Label("ID:");
        TextField idTxf = new TextField();
        idTxf.setPrefSize(50,50);
        idTxf.setStyle("-fx-font-size: 16px;");


        add(idLabel, 0, 0 );
        add(idTxf, 0, 1);
        gridPane.add(lukButton, 1, 2);
        gridPane.add(opretButton, 0, 2);
        add(gridPane, 0,2);

        lukButton.setOnAction(e -> lukVindue());
        opretButton.setOnAction(e -> opretObjekt(idTxf.getText()));
    }

    private void opretObjekt(String id) {
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
