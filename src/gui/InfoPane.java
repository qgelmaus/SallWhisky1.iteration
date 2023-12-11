package gui;

import application.model.Destillering;
import application.model.Medarbejder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InfoPane extends GridPane {
    private String vindueNavn = "Info";
    private MainPane mainPane;
    private ListView<Medarbejder> medarbejderListView;

    public InfoPane(Destillering destillering) {
        setHgap(10);
        setVgap(10);

        this.mainPane = mainPane;
        //buttons
        Button lukButton = new Button("Luk");

        //textArea
        TextArea infoBox = new TextArea();
        infoBox.setWrapText(true);
        infoBox.setEditable(false);
        infoBox.setMaxSize(150,200);
        infoBox.setText(destillering.getBemærkning());

        //Labels
        Label bemærkningLabel = new Label("Bemærkning: ");
        Label startLabel = new Label("Start dato: " + destillering.getStartDato());
        Label slutLabel = new Label("Slut dato: " + destillering.getSlutDato());
        Label væskeLabel = new Label("Væske mængde: " + destillering.getVæskeMængde());
        Label rygeMateriale = new Label("Rygemateriale: " + destillering.getRygeMateriale());
        Label kornSortLabel = new Label("Kornsort: " + destillering.getKornSort());
        Label maltBatchLabel = new Label("Malt batch: " + destillering.getMaltBatch());
        ObservableList<Medarbejder> medarbejderObservableList = FXCollections.observableArrayList(destillering.getMedarbejderList());
        medarbejderListView = new ListView<>(medarbejderObservableList);
        Label medarbejdereLbl = new Label("Medarbejdere");
        medarbejderListView.setMaxWidth(150);
        medarbejderListView.setMaxHeight(200);

        VBox vBox1 = new VBox(5);
        VBox vBox2 = new VBox(10);
        VBox vBox3 = new VBox(5);

        vBox1.getChildren().addAll(bemærkningLabel, infoBox);
        vBox2.getChildren().addAll(startLabel, slutLabel, væskeLabel, rygeMateriale, kornSortLabel, maltBatchLabel);
        vBox3.getChildren().addAll(medarbejdereLbl, medarbejderListView);
//        add(bemærkningLabel,0,0);
//        add(infoBox, 0, 1);
        add(vBox1,0,0);
        add(vBox3,1 ,0);
        add(vBox2,2,0);
//        add(startLabel, 2, 0);
//        add(slutLabel,2,1);
//        add(væskeLabel,2,2);
//        add(rygeMateriale,2,3);
//        add(kornSortLabel,2,4);
//        add(maltBatchLabel,2,5);
        vBox2.setTranslateY(30);
        add(lukButton, 0, 1);
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
    }
