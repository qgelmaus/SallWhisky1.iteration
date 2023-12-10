package gui;

import application.model.Destillering;
import application.model.Medarbejder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;
import javafx.geometry.Insets;


import java.util.ArrayList;
import java.util.List;

public class MainPane extends Application {

    private Stage primaryStage;
    private ObservableList<Destillering> destillerings;
    private ObservableList<Medarbejder> medarbejders;



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
        Button button3 = new Button("Opdater destilleringer");
        Button button4 = new Button("Se bemærkninger");
        Button button5 = new Button("Fyld fad");

        gridPane.add(button1, 1, 3);
        gridPane.add(button2, 2, 3);
        gridPane.add(button3, 1, 5);
        gridPane.add(button4, 2, 5);
        gridPane.add(button5, 3, 3);
        button1.setOnAction(e -> openNewPane(new DestilleringPane()));
        button2.setOnAction(e -> openNewPane(new MedarbejderPane()));
        button5.setOnAction(e -> openNewPane(new PåfyldningPane()));

        VBox vBox1 = new VBox();



        //Listview

        Label aktuelleDestilleringerLbl = new Label("Aktive destilleringer:");
        destillerings = FXCollections.observableArrayList();
        ListView<Destillering> destilleringLW = new ListView<>(destillerings);
        gridPane.add(aktuelleDestilleringerLbl, 1, 0);
        gridPane.add(destilleringLW, 1, 1);
        button3.setOnAction(e -> updateList(destilleringLW));
        destilleringLW.setPrefSize(200,200);

        Label aktuelleMedarbejderLbl = new Label("Aktive medarbejdere:");
        medarbejders = FXCollections.observableArrayList();
        ListView<Medarbejder> medarbejdersLW = new ListView<>(medarbejders);
        gridPane.add(aktuelleMedarbejderLbl, 2, 0);
        gridPane.add(medarbejdersLW, 2, 1);
        button3.setOnAction(e -> updateList(medarbejdersLW));
        medarbejdersLW.setPrefSize(150,150);



        button4.setOnAction(e -> openNewPane(new InfoPane(destilleringLW.getSelectionModel().getSelectedItem())));
        updateList(destilleringLW);
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

    private void openNewPane(GridPane pane) {
        Stage newStage = new Stage();
        Scene scene = new Scene(pane, 800, 600);
        newStage.setScene(scene);
        newStage.setTitle(pane.toString());
        newStage.show();
    }

    public void updateList(ListView listView){
        List<Destillering> updatedList = Storage.getInstance().getAllDestillerings();
        ObservableList<Destillering> observableList = FXCollections.observableArrayList(updatedList);
        listView.setItems(observableList);
    }






}
