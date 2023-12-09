package gui;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MedarbejderPane extends GridPane {
    public MedarbejderPane(){
        setHgap(10);
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

        lukButton.setOnAction(e -> closeWindow());
    }

    private void closeWindow() {
        Stage stage = (Stage) getScene().getWindow();
        stage.close();
    }



}
