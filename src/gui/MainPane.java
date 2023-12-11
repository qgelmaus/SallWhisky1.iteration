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
    private ListView<Medarbejder> medarbejdersLW;
    private ListView<Destillering> destilleringsLW;
    private ListView<Fad> fadsLW;



    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hjem");

        BorderPane borderPane = createBorderPane();

        Scene scene = new Scene(borderPane, 800, 600);

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
        Button button4 = new Button("Åben destillering");
        Button button5 = new Button("Fyld fad");
        Button button6 = new Button("Opret fad");
        Button button7 = new Button("Se historik");
        Button button8 = new Button("Lager");
        Button button9 = new Button("Lav whisky");

        gridPane.add(button1, 1, 3);
        gridPane.add(button2, 2, 3);
        gridPane.add(button3, 1, 4);
        gridPane.add(button4, 2, 4);
        gridPane.add(button5, 3, 4);
        gridPane.add(button6,3,3);
        button1.setOnAction(e -> openBigPane(new DestilleringPane()));
        button5.setOnAction(e -> openBigPane(new PåfyldningPane()));
        button6.setOnAction(e -> openSmallPane(new FadPane()));

        VBox rightButtonBox = new VBox(5);
        rightButtonBox.getChildren().addAll(button7, button8, button9);
        gridPane.add(rightButtonBox,4 ,1);

        //Listview
        Label fyldteFade = new Label("Fade med indhold: ");
        fads = FXCollections.observableArrayList();
        Label aktuelleDestilleringerLbl = new Label("Aktive destilleringer:");
        destillerings = FXCollections.observableArrayList();
        fadsLW = new ListView<>(fads);
        destilleringsLW = new ListView<>(destillerings);
        gridPane.add(fyldteFade, 3, 0);
        gridPane.add(fadsLW, 3, 1);
        gridPane.add(aktuelleDestilleringerLbl, 1, 0);
        gridPane.add(destilleringsLW, 1, 1);
//        button3.setOnAction(e -> updateList(destilleringLW, ));
        destilleringsLW.setPrefSize(200,200);


        button7.setOnAction(e -> openBigPane(new HistorikPane(fadsLW.getSelectionModel().getSelectedItem())));

        Label fadeLbl = new Label("Fade:");
        ListView<Fad> fadLw = new ListView<>(fads);


        Label aktuelleMedarbejderLbl = new Label("Aktive medarbejdere:");
        medarbejders = FXCollections.observableArrayList();
        medarbejdersLW = new ListView<>(medarbejders);
        gridPane.add(aktuelleMedarbejderLbl, 2, 0);
        gridPane.add(medarbejdersLW, 2, 1);
        button3.setOnAction(e -> updateList());
        medarbejdersLW.setPrefSize(150,150);


        button8.setOnAction(e -> openBigPane(new LagerPane()));
        updateList();
        button2.setOnAction(e -> setMedarbejder(medarbejdersLW.getSelectionModel().getSelectedItem(),destilleringsLW.getSelectionModel().getSelectedItem()));
        button4.setOnAction(e -> openSmallPane(new InfoPane(destilleringsLW.getSelectionModel().getSelectedItem())));
        button9.setOnAction(e -> openBigPane(new WhiskyPane()));
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
        Scene scene = new Scene(pane, 800, 600);
        newStage.setScene(scene);
        newStage.setTitle(pane.toString());
        newStage.show();
    }
    private void openSmallPane(GridPane pane) {
        Stage newStage = new Stage();
        pane.setPadding(new Insets(20));
        Scene scene = new Scene(pane, 540, 280);
        newStage.setScene(scene);
        newStage.setTitle(pane.toString());
        newStage.show();
    }
    public void updateList(){
        medarbejdersLW.getItems().clear();
        destilleringsLW.getItems().clear();
        fadsLW.getItems().clear();
        List<Destillering> updatedList = Storage.getInstance().getAllDestillerings();
        ObservableList<Destillering> observableList = FXCollections.observableArrayList(updatedList);
        destilleringsLW.setItems(observableList);

        List<Medarbejder> updatedList2 = Storage.getInstance().getAllMedarbejders();
        ObservableList<Medarbejder> observableList2 = FXCollections.observableArrayList(updatedList2);
        medarbejdersLW.setItems(observableList2);

        List<Fad> updatedList3 = Storage.getInstance().getAllFads();
        List<Fad> fadMedIndhold = updatedList3;
        for (int i = 0; i < Storage.getInstance().getAllFads().size(); i++) {
            updatedList3.get(i).setAntalPåfyldteLiter();
            if(updatedList3.get(i).getAntalPåfyldteLiter() > 0){
                fadMedIndhold.add(i, updatedList3.get(i));
            }
        }
        ObservableList<Fad> fadList = FXCollections.observableArrayList(fadMedIndhold);
        fadsLW.setItems(fadList);
    }

    public Alert alertFejl(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("!- ALERT -!");
        alert.setHeaderText("Der er sket en fejl");
        alert.setContentText("Vælg en destillering og en medarbejder");
        return alert;
    }

    private void setMedarbejder(Medarbejder medarbejder, Destillering destillering){
        if (medarbejder != null && destillering != null) {
            destillering.addMedarbejder(medarbejder);
            updateList(); // Update the list directly
        }
        else
            alertFejl().showAndWait();
    }

   /* public void updateFadeMedIndholf(ListView<Fad> fadLW){
        ArrayList<Fad> fadMedFyld = new ArrayList<>();
        for (int i = 0; i < fads.size(); i++) {
            if(!fads.get(i).getEmptyStatus()){
                fadMedFyld.add(i, fads.get(i));
            }
        }
        ObservableList<Fad> fadList = FXCollections.observableArrayList(fadMedFyld);
        fadLW.setItems(fadList);
    } */



}
