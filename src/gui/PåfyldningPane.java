package gui;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import application.model.Mængde;
import application.model.Påfyldning;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

import java.time.LocalDate;
import java.util.List;

public class PåfyldningPane extends GridPane {

    private String vindueNavn = "Påfyldning";
    private ObservableList<Destillering> destillerings;
    private ObservableList<Fad> fads;
    private MainPane mainPane;

    public PåfyldningPane() {
        setHgap(10);
        setVgap(10);

        this.mainPane = mainPane;

        Button lukButton = new Button("Luk");
        Button opretButton = new Button("Opret");
        Button updateButton = new Button("Opdater liste");
        Button opretFadbutton = new Button("Opret fad");
        Label mængdeLbl = new Label("Indtast mængde:");
        TextField mængdeTxf = new TextField();
        //Listview destilleringer
        Label aktuelleDestilleringerLbl = new Label("Aktive destilleringer:");
        destillerings = FXCollections.observableArrayList();
        ListView<Destillering> destilleringLW = new ListView<>(destillerings);
        add(aktuelleDestilleringerLbl, 1, 0);
        add(destilleringLW, 1, 1);


        //Listview fad
        Label aktuelleFadLbl = new Label("Mulige fade");
        fads = FXCollections.observableArrayList();
        ListView<Fad> fadListView = new ListView<>(fads);
        add(aktuelleFadLbl, 1, 1);
        add(fadListView, 2, 2);


        opretButton.setOnAction(e -> fyldFadFraMængde(
                destilleringLW.getSelectionModel().getSelectedItem(),
                Double.parseDouble(mængdeTxf.getText()),
                fadListView.getSelectionModel().getSelectedItem()));

        add(updateButton, 0, 1);
        add(lukButton, 0, 8);
        add(opretButton, 0, 7);
        add(opretFadbutton, 0, 9);

        opretFadbutton.setOnAction(e -> openNewPane(new FadPane()));
        updateButton.setOnAction(e -> updateList(destilleringLW, fadListView));

       /* if(!Storage.getInstance().getAllFads().isEmpty()){
            opretFadbutton.setDisable(true);
        } */

    }

    private void fyldFadFraMængde(Destillering destillering, double volume, Fad fad){
//        Påfyldning påfyldning = Controller.opretPåfyldning(LocalDate.of(2020,19,10), 123, true);
//        Mængde mængde = Controller.opretMængde(volume, påfyldning);
        lukVindue();
    }

    public void updateList(ListView listView1, ListView listView2){
        List<Destillering> updatedDestilleringList = Storage.getInstance().getAllDestillerings();
        ObservableList<Destillering> observableDestilleringList = FXCollections.observableArrayList(updatedDestilleringList);
        List<Fad> updatedFadList = Storage.getInstance().getAllFads();
        ObservableList<Fad> observableFadList = FXCollections.observableArrayList(updatedFadList);
        listView1.setItems(observableDestilleringList);
        listView2.setItems(observableFadList);
    }

    private void lukVindue() {
        Stage stage = (Stage) getScene().getWindow();
        stage.close();
    }

    private void openNewPane(GridPane pane) {
        Stage newStage = new Stage();
        Scene scene = new Scene(pane, 800, 600);
        newStage.setScene(scene);
        newStage.setTitle(pane.toString());
        newStage.show();
    }


    @Override
    public String toString(){
        return vindueNavn;
    }
}
