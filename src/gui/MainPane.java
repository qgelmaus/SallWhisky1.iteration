package gui;

import application.model.Destillering;
import application.model.Fad;
import application.model.Medarbejder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;
import javafx.geometry.Insets;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPane extends Application {

    private Stage primaryStage;
    private ObservableList<Destillering> destillerings;
    private ObservableList<Medarbejder> medarbejders;
    private ObservableList<Fad> fads;



    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hjem");

        BorderPane borderPane = createBorderPane();

        Scene scene = new Scene(borderPane, 550, 450);

        primaryStage.setScene(scene);


        primaryStage.show();


    }
    private BorderPane createBorderPane(){
        BorderPane borderPane = new BorderPane();
        GridPane gridPaneLeft = createGridPaneLeft();
        GridPane gridPaneRight = createGridPaneRight();
        borderPane.setLeft(gridPaneLeft);
        borderPane.setCenter(gridPaneRight);
        borderPane.setPadding(new Insets(50,50,50,50));


        return borderPane;
    }

    private GridPane createGridPaneLeft() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);



       //Buttons
        Button button1 = new Button("Opret destillering");
        Button button2 = new Button("Tilføj medarbejder");
        Button button3 = new Button("Opdater");
        Button button4 = new Button("Se bemærkninger");
        Button button5 = new Button("Fyld fad");
        Button button6 = new Button("Opret fad");

        gridPane.add(button1, 1, 3);
        gridPane.add(button2, 2, 3);
        gridPane.add(button3, 1, 4);
        gridPane.add(button4, 2, 4);
        gridPane.add(button5, 3, 4);
        gridPane.add(button6,3,3);
        button1.setOnAction(e -> openBigPane(new DestilleringPane()));
        button2.setOnAction(e -> openSmallPane(new MedarbejderPane()));
        button5.setOnAction(e -> openBigPane(new PåfyldningPane()));


        //Listview
        Label aktuelleDestilleringerLbl = new Label("Aktive destilleringer:");
        destillerings = FXCollections.observableArrayList();
        ListView<Destillering> destilleringLW = new ListView<>(destillerings);
        gridPane.add(aktuelleDestilleringerLbl, 1, 0);
        gridPane.add(destilleringLW, 1, 1);
//        button3.setOnAction(e -> updateList(destilleringLW, ));
        destilleringLW.setPrefSize(200,200);

        Label fadeLbl = new Label("Fade:");
        ListView<Fad> fadLw = new ListView<>(fads);


        Label aktuelleMedarbejderLbl = new Label("Aktive medarbejdere:");
        medarbejders = FXCollections.observableArrayList();
        ListView<Medarbejder> medarbejdersLW = new ListView<>(medarbejders);
        gridPane.add(aktuelleMedarbejderLbl, 2, 0);
        gridPane.add(medarbejdersLW, 2, 1);
        button3.setOnAction(e -> updateList( destilleringLW,medarbejdersLW));
        medarbejdersLW.setPrefSize(150,150);

        button4.setOnAction(e -> {
            Destillering destilleringSelect = destilleringLW.getSelectionModel().getSelectedItem();
        if(destilleringSelect != null) {
            openSmallPane(new InfoPane(destilleringSelect));
        } else {
            alertFejl().show();
        }
                });
        updateList(destilleringLW, medarbejdersLW);
        return gridPane;
    }

    private GridPane createGridPaneRight(){
        GridPane gridPane = new GridPane();

//        //Listview
//        Label aktuelleDestilleringerLbl = new Label("Aktive destilleringer:");
//        destillerings = FXCollections.observableArrayList();
//        ListView<Destillering> destilleringLW = new ListView<>(destillerings);
//        gridPane.add(aktuelleDestilleringerLbl, 1, 0);
//        gridPane.add(destilleringLW, 1, 1);

        return gridPane;
    }

    public void openBigPane(GridPane pane) {

        Stage newStage = new Stage();
        pane.setPadding(new Insets(20));
        Scene scene = new Scene(pane, 640, 480);
        newStage.setScene(scene);
        newStage.setTitle(pane.toString());
        newStage.show();
    }
    private void openSmallPane(GridPane pane) {
        Stage newStage = new Stage();
        pane.setPadding(new Insets(20));
        Scene scene = new Scene(pane, 350, 290);
        newStage.setScene(scene);
        newStage.setTitle(pane.toString());
        newStage.show();
    }
    public void updateList(ListView listView, ListView listView2){
        List<Destillering> updatedList = Storage.getInstance().getAllDestillerings();
        ObservableList<Destillering> observableList = FXCollections.observableArrayList(updatedList);
        listView.setItems(observableList);

        List<Medarbejder> updatedList2 = Storage.getInstance().getAllMedarbejders();
        ObservableList<Medarbejder> observableList2 = FXCollections.observableArrayList(updatedList2);
        listView2.setItems(observableList2);
    }

    public Alert alertFejl(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bemærkninger");
        alert.setHeaderText("Fejl");
        alert.setContentText("Vælg en destillering");
        return alert;
    }

    public void setOptagetFad(ListView<Fad> fadLw){


    }



}
