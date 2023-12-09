package gui;

import application.model.Destillering;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.time.LocalDate;

import javafx.scene.control.Label;


class DestilleringPane extends GridPane {
    public DestilleringPane() {
        // Set the gaps between grid elements
        setHgap(10);
        setVgap(10);

        // Create buttons
        Button lukButton = new Button("Luk");
        Button opretButton = new Button("Opret");

        // Create date pickers
        DatePicker startDatePicker = new DatePicker();
        DatePicker endDatePicker = new DatePicker();

        // Create text fields
        TextField væskeMængdeField = new TextField();
        TextField rygeMaterialeField = new TextField();
        TextField kornSortField = new TextField();
        TextField kommentarField = new TextField();

        // Create labels
        Label startDateLabel = new Label("Start dato:");
        Label endDateLabel = new Label("Slut dato:");
        Label væskeMængdeLabel = new Label("Væskemængde:");
        Label rygeMaterialeLabel = new Label("Rygemateriale:");
        Label kornSortLabel = new Label("Kornsort:");
        Label kommentarLabel = new Label("Kommentar:");
        Label maltBatchLabel = new Label("Maltbatch");

        //Combobox
        ComboBox maltBatchCbo = new ComboBox<String>();

        // Add components to the grid
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

        // Set padding for the entire pane


        // Set event handlers for the buttons
        lukButton.setOnAction(e -> closeWindow());
        opretButton.setOnAction(e -> submitData(
                startDatePicker.getValue(),
                endDatePicker.getValue(),
                Double.parseDouble(væskeMængdeField.getText()),
                rygeMaterialeField.getText(),
                kornSortField.getText(),
                kommentarField.getText()
        ));
    }

    private void closeWindow() {
        Stage stage = (Stage) getScene().getWindow();
        stage.close();
    }

    private void submitData(LocalDate startDato, LocalDate slutDato, double væskeMængde, String rygeMateriale, String kornSort, String kommentar) {
        // Create an instance of the Destillering class with the provided data
        Destillering destillering = new Destillering(startDato, slutDato, væskeMængde, rygeMateriale, kornSort, kommentar);

        // Do something with the destillering object, e.g., pass it to another method or class
        // ...

        // Close the current window
        closeWindow();
    }


}



