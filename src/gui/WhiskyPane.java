package gui;

import application.controller.Controller;
import application.model.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;

import java.time.LocalDate;

public class WhiskyPane extends GridPane {
    private Påfyldning påfyldning;
    private ListView<Whisky> whiskyListView;
    private ListView<Fad> fadListView;
    private String vindueNavn = "Lav whisky";


    public WhiskyPane() {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(20, 20, 20, 20));

        Label fadLbl = new Label("Fade:");
        Label whiskyLbl = new Label("Whiskies:");
        fadListView = new ListView<>();
        whiskyListView = new ListView<>();
        fadListView.getItems().addAll(Storage.getInstance().getAllFads());
        whiskyListView.getItems().addAll(Storage.getInstance().getAllWhiskys());

        Button whiskyButton = new Button("Lav whisky");
        Button lukButton = new Button("Luk");
        Button historikButton = new Button("Historik");

        VBox fadVBox = new VBox(5);
        VBox whiskyVBox = new VBox(5);
        VBox middleVBox = new VBox(5);
        Label volumen = new Label("Hældes fra fad(L):");
        TextField volumenTxf = new TextField();
        fadVBox.getChildren().addAll(fadLbl, fadListView);
        whiskyVBox.getChildren().addAll(whiskyLbl, whiskyListView);
        middleVBox.getChildren().addAll(volumen, volumenTxf, whiskyButton);
        add(fadVBox, 0, 0);
        add(middleVBox,1,0);
        add(whiskyVBox, 2, 0);
        add(historikButton, 3, 0);

        whiskyButton.setOnAction(e -> lavWhisky(fadListView.getSelectionModel().getSelectedItem(), Integer.parseInt(volumenTxf.getText())));
        historikButton.setOnAction(e -> openSmallPane(new WhiskyHistorikPane(whiskyListView.getSelectionModel().getSelectedItem())));
        updateLists();


    }

        private void lukVindue() {
            Stage stage = (Stage) getScene().getWindow();
            stage.close();
        }

        private void tilføjFadTilReol(Fad fad, Reol reol){
            reol.addFad(fad);
            updateLists();
        }

        private void updateLists(){
            fadListView.getItems().clear();
            whiskyListView.getItems().clear();
            fadListView.getItems().addAll(Storage.getInstance().getAllFads());
            whiskyListView.getItems().addAll(Storage.getInstance().getAllWhiskys());
        }

        public void lavWhisky(Fad fad, double liter){
            LocalDate dato = LocalDate.now();
            Påfyldning p = Controller.opretPåfyldning(dato, dato, fad);
            Whisky whisky = Controller.opretWhisky("Sall nr. 1", 1, 50,p, 1);
            WhiskyMængde whiskyMængde = whisky.createWhiskyMængde(liter, whisky);
            whiskyMængde.setPåfyldning(p);
            updateLists();
        }

    private void openSmallPane(GridPane pane) {
        Stage newStage = new Stage();
        pane.setPadding(new Insets(20));
        Scene scene = new Scene(pane, 540, 280);
        newStage.setScene(scene);
        newStage.setTitle(pane.toString());
        newStage.show();
    }


        @Override
        public String toString(){
            return vindueNavn;
        }



    }






