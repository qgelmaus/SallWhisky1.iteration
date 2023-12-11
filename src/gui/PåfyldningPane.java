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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;

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
        Button fyldButton = new Button("Fyld fad");
        Button updateButton = new Button("Opdater liste");
        Button opretFadbutton = new Button("Nyt fad");
        Label mængdeLbl = new Label("Indtast mængde:");
        TextField mængdeTxf = new TextField();
        //Listview destilleringer
        Label aktuelleDestilleringerLbl = new Label("Aktive destilleringer:");
        destillerings = FXCollections.observableArrayList();
        ListView<Destillering> destilleringLW = new ListView<>(destillerings);



        //Listview fad
        Label aktuelleFadLbl = new Label("Mulige fade");
        fads = FXCollections.observableArrayList();
        ListView<Fad> fadListView = new ListView<>(fads);



       /* opretButton.setOnAction(e -> fyldFadFraMængde(
                destilleringLW.getSelectionModel().getSelectedItem(),
                Double.parseDouble(mængdeTxf.getText()),
                fadListView.getSelectionModel().getSelectedItem()));
*/
        VBox buttonBox = new VBox();
        buttonBox.getChildren().addAll(updateButton, opretFadbutton, fyldButton, lukButton);
        buttonBox.setSpacing(15);
        //add(updateButton, 0, 0);
        add(aktuelleFadLbl, 1, 0);
        add(fadListView, 1, 1);
        add(buttonBox, 0 , 1);
        //add(lukButton, 1, 5);
        //add(opretFadbutton, 0, 1);
        //add(fyldButton, 0, 2);
        add(aktuelleDestilleringerLbl, 2, 0);
        add(destilleringLW, 2, 1);


        opretFadbutton.setOnAction(e -> openNewPane(new FadPane()));
        lukButton.setOnAction(e -> lukVindue());
        updateButton.setOnAction(e -> updateList(destilleringLW, fadListView));

       /* if(!Storage.getInstance().getAllFads().isEmpty()){
            opretFadbutton.setDisable(true);
        } */

    }

   private void fyldFadFraMængde(Destillering destillering, double volume, Fad fad){
        Påfyldning påfyldning = Controller.opretPåfyldning(volume, destillering.getStartDato(), destillering.getSlutDato(), volume, true, fad);
        Mængde mængde = Controller.opretMængde(volume, påfyldning);
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
