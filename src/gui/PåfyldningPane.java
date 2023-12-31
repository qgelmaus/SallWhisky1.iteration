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

import java.util.ArrayList;
import java.util.List;

public class PåfyldningPane extends GridPane {

    private String vindueNavn = "Påfyldning";
    private ObservableList<Destillering> destillerings;
    private ObservableList<Fad> fads;
    private MainPane mainPane;
    private ListView<Destillering> destilleringLW;
    private ListView<Fad> fadListView;

    public PåfyldningPane() {
        setHgap(10);
        setVgap(10);

        this.mainPane = mainPane;

        Button lukButton = new Button("Luk");
        Button fyldButton = new Button("Fyld fad");
        Button updateButton = new Button("Opdater liste");
        Button opretFadbutton = new Button("Nyt fad");
        Label mængdeLbl = new Label("Indtast mængde(L):");
        TextField mængdeTxf = new TextField();
        //Listview destilleringer
        Label aktuelleDestilleringerLbl = new Label("Aktive destilleringer:");
        destillerings = FXCollections.observableArrayList();
        destilleringLW = new ListView<>(destillerings);




        //Listview fad
        Label aktuelleFadLbl = new Label("Mulige fade");
        fads = FXCollections.observableArrayList();
        fadListView = new ListView<>(fads);


        VBox buttonBox = new VBox();
        VBox mængdeBox = new VBox();
        buttonBox.getChildren().addAll(updateButton, opretFadbutton, fyldButton, lukButton);
        buttonBox.setSpacing(15);
        add(aktuelleFadLbl, 1, 0);
        add(fadListView, 1, 1);
        add(buttonBox, 0 , 1);
        add(mængdeBox,1,2);
        mængdeBox.getChildren().addAll(mængdeLbl, mængdeTxf);
        add(aktuelleDestilleringerLbl, 2, 0);
        add(destilleringLW, 2, 1);


        opretFadbutton.setOnAction(e -> openNewPane(new FadPane()));
        lukButton.setOnAction(e -> lukVindue());
        updateButton.setOnAction(e -> updateList());
        fyldButton.setOnAction(e -> fyldDestPåFad(destilleringLW.getSelectionModel().getSelectedItem(), fadListView.getSelectionModel().getSelectedItem(), Double.parseDouble(mængdeTxf.getText()), destilleringLW, fadListView));
        updateList();


    }


    private void updateList(){
        fadListView.getItems().clear();
        destilleringLW.getItems().clear();
        ArrayList<Fad> avaiableFadList = new ArrayList<>();
        ArrayList<Destillering> avaiableDestilleringList = new ArrayList<>();
        for (int i = 0; i < Storage.getInstance().getAllFads().size(); i++) {
            if(Storage.getInstance().getAllFads().get(i).getAntalPåfyldteLiter() < Storage.getInstance().getAllFads().get(i).getFadstørrelse()){
                avaiableFadList.add(i, Storage.getInstance().getAllFads().get(i));
            }
        }
        for(int i = 0; i < Storage.getInstance().getAllDestillerings().size(); i++){
            if(!Storage.getInstance().getAllDestillerings().get(i).isEmpty()){
                avaiableDestilleringList.add(i, Storage.getInstance().getAllDestillerings().get(i));
            }
        }
        List<Fad> updatedFadList = avaiableFadList;
        List<Destillering> updatedDestilleringList = avaiableDestilleringList;
        ObservableList<Fad> observableFadList = FXCollections.observableArrayList(updatedFadList);
        ObservableList<Destillering> observableDestilleringList = FXCollections.observableArrayList(updatedDestilleringList);
       destilleringLW.setItems(observableDestilleringList);
       fadListView.setItems(observableFadList);
    }

    private void lukVindue() {
        Stage stage = (Stage) getScene().getWindow();
        stage.close();
    }

    private void fyldDestPåFad(Destillering destillering, Fad fad, double volume,ListView listView1, ListView listview2 ){
       Påfyldning p = Controller.opretTomPåfyldning();
        fad.setAntalPåfyldteLiter();
        p.setFad(fad);
       p.createMængde(volume, destillering);
       p.setAntalLiter(p.samletAntalLiter());

       destillering.setLeftOverVæske();
       updateList();

    }

    private void updateStuff(){

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
