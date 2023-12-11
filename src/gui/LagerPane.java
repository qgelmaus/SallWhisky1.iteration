package gui;

import application.model.Fad;
import application.model.Lager;
import application.model.Reol;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;

public class LagerPane extends GridPane {
    private String vindueNavn = "Historik";
    private MainPane mainPane;
    private Lager lager = Storage.getInstance().getAllLagers().get(0);
    private ListView<Reol> reolLW = new ListView<>();
    private ListView<Fad> fadLw = new ListView<>();

    public LagerPane() {
        setHgap(10);
        setVgap(10);
        this.mainPane = mainPane;

        VBox buttonBox = new VBox(5);
        VBox lwBox = new VBox(10);
        Button lukButton = new Button("Luk");
        Button tilføjButton = new Button("Tilføj til lager");
        Label lwLbl = new Label("Fade uden lager status:");
        Label reolLbl = new Label("Reoler:");





        buttonBox.getChildren().addAll(lukButton, tilføjButton);
        lwBox.getChildren().addAll(lwLbl,fadLw, reolLbl,reolLW);
        add(buttonBox,0,0);
        add(lwBox, 1, 0);

        tilføjButton.setOnAction(e -> tilføjFadTilReol(fadLw.getSelectionModel().getSelectedItem(), reolLW.getSelectionModel().getSelectedItem()));
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
        fadLw.getItems().clear();
        reolLW.getItems().clear();
        lager.setSamletAntalFade();
        fadLw.getItems().addAll(Storage.getInstance().getAllFads());
        reolLW.getItems().addAll(Storage.getInstance().getAllReols());
    }
    @Override
    public String toString(){
        return vindueNavn;
    }
}
