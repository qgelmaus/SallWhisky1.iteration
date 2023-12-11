package gui;

import application.model.Destillering;
import application.model.Fad;
import application.model.Mængde;
import application.model.Påfyldning;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HistorikPane extends GridPane {
    private String vindueNavn = "Historik";
    private MainPane mainPane;

    public HistorikPane(Fad fad) {
        setHgap(10);
        setVgap(10);

        this.mainPane = mainPane;
        //buttons
        Button lukButton = new Button("Luk");
        ArrayList<Påfyldning> historikListe = new ArrayList<>();

        for (int i = 0; i < fad.getPåfyldningArrayList().size(); i++) {
            historikListe.add(i, fad.getPåfyldningArrayList().get(i));
        }

        ObservableList<Påfyldning> destObsList = FXCollections.observableArrayList(historikListe);


        //listview
        ListView<Påfyldning> infoLW = new ListView<>();
        ListView<Påfyldning> påfyldningListView = new ListView();
        ListView<Destillering> destilleringListView = new ListView();
        VBox listviewBox = new VBox(5);
        listviewBox.getChildren().addAll(destilleringListView);
        infoLW.setItems(destObsList);
        add(infoLW, 0, 1);

        //Labels
        Label fadIndholdLbl = new Label("Det valgte fad indeholder disse destilleringer:");
        add(fadIndholdLbl, 0, 0);


        //Textarea



       Button pilBtn = new Button("->");
       add(pilBtn,1, 1);
       pilBtn.setOnAction(e -> displayHistory(infoLW.getSelectionModel().getSelectedItem(), destilleringListView));
        add(lukButton, 0, 2);
        add(listviewBox, 2, 1);
        lukButton.setOnAction(e -> lukVindue());

    }

    private void lukVindue() {
        Stage stage = (Stage) getScene().getWindow();
        stage.close();
    }
    @Override
    public String toString(){
        return vindueNavn;
    }

    private void displayHistory(Påfyldning påfyldning, ListView listview){
        List<Destillering> obsMængde = new ArrayList<>();
        for (int i = 0; i < påfyldning.getMængdeArrayList().size(); i++) {
            obsMængde.add(i, påfyldning.getMængdeArrayList().get(i).getDestillering());
        }
        ObservableList<Destillering> destilleringObservableList = FXCollections.observableArrayList(obsMængde);

        listview.setItems(destilleringObservableList);




    }
}

