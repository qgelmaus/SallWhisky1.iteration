package gui;

import application.controller.Controller;
import application.model.Destillering;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.awt.*;
import java.time.LocalDate;

import javafx.scene.control.Label;


class DestilleringPane extends GridPane {
    private String vindueNavn = "Destillering";
    private MainPane mainPane;

    public DestilleringPane() {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(20, 20, 20 ,20));


        this.mainPane = mainPane;
        //buttons
        Button lukButton = new Button("Luk");
        Button opretButton = new Button("Opret");

        //datepickers
        DatePicker startDatePicker = new DatePicker();
        DatePicker endDatePicker = new DatePicker();

        // textfields
        TextField væskeMængdeField = new TextField();
        TextField rygeMaterialeField = new TextField();
        TextField kornSortField = new TextField();
        TextField kommentarField = new TextField();

        //labels
        Label startDateLabel = new Label("Start dato:");
        Label endDateLabel = new Label("Slut dato:");
        Label væskeMængdeLabel = new Label("Væskemængde:");
        Label rygeMaterialeLabel = new Label("Rygemateriale:");
        Label kornSortLabel = new Label("Kornsort:");
        Label kommentarLabel = new Label("Kommentar:");
        Label maltBatchLabel = new Label("Maltbatch");

        //Combobox
        ComboBox maltBatchCbo = new ComboBox<String>();

        // Tilføj alt
        add(startDateLabel, 0, 0);
        add(startDatePicker, 1, 0);
        add(endDateLabel, 0, 1);
        add(endDatePicker, 1, 1);
        add(væskeMængdeLabel, 0, 2);
        add(væskeMængdeField, 1, 2);
        add(rygeMaterialeLabel, 0, 3);
        add(rygeMaterialeField, 1, 3);
        add(kornSortLabel, 0, 4);
        add(kornSortField, 1, 4);
        add(kommentarLabel, 0, 5);
        add(kommentarField, 1, 5);
        add(maltBatchLabel, 0, 6);
        add(maltBatchCbo, 1,6 );
        add(lukButton, 0, 8);
        add(opretButton, 1, 8);


        // Knap funktioner
        lukButton.setOnAction(e -> lukVindue());
        opretButton.setOnAction(e -> opretObjekt(
                startDatePicker.getValue(),
                endDatePicker.getValue(),
                Double.parseDouble(væskeMængdeField.getText()),
                rygeMaterialeField.getText(),
                kornSortField.getText(),
                kommentarField.getText()
        ));
    }

    private void lukVindue() {
        Stage stage = (Stage) getScene().getWindow();
        stage.close();
    }

    private void opretObjekt(LocalDate startDato, LocalDate slutDato, double væskeMængde, String rygeMateriale, String kornSort, String kommentar) {
        Controller.opretDestillering(startDato, slutDato, væskeMængde, rygeMateriale, kornSort, kommentar);
        lukVindue();
    }

    @Override
    public String toString(){
        return vindueNavn;
    }


}



