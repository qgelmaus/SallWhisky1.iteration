package gui;

import application.model.Destillering;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class MainPane extends Application {

    private Stage primaryStage;
    private ObservableList<Destillering> destillerings;



    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hjem");

        BorderPane borderPane = createBorderPane();

        Scene scene = new Scene(borderPane, 640, 480);

        primaryStage.setScene(scene);


        primaryStage.show();


    }
    private BorderPane createBorderPane(){
        BorderPane borderPane = new BorderPane();
        GridPane gridPaneLeft = createGridPaneLeft();
        GridPane gridPaneRight = createGridPaneRight();
        borderPane.setLeft(gridPaneLeft);
        borderPane.setCenter(gridPaneRight);


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
        gridPane.add(button1, 0, 0);
        gridPane.add(button2, 0, 1);
        gridPane.add(button3, 0, 2);
        gridPane.add(button4, 0, 3);
        button1.setOnAction(e -> openNewPane(new DestilleringPane()));
        button2.setOnAction(e -> openNewPane(new MedarbejderPane()));



        //Listview
        Label aktuelleDestilleringerLbl = new Label("Aktive destilleringer:");
        destillerings = FXCollections.observableArrayList();
        ListView<Destillering> destilleringLW = new ListView<>(destillerings);
        gridPane.add(aktuelleDestilleringerLbl, 1, 0);
        gridPane.add(destilleringLW, 1, 1);
        button3.setOnAction(e -> updateList(destilleringLW));

        button4.setOnAction(e -> openNewPane(new InfoPane(destilleringLW.getSelectionModel().getSelectedItem())));
        return gridPane;
    }

    private GridPane createGridPaneRight(){
        GridPane gridPane = new GridPane();

        //Listview
        Label aktuelleDestilleringerLbl = new Label("Aktive destilleringer:");
        destillerings = FXCollections.observableArrayList();
        ListView<Destillering> destilleringLW = new ListView<>(destillerings);
        gridPane.add(aktuelleDestilleringerLbl, 1, 0);
        gridPane.add(destilleringLW, 1, 1);

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
