package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FadPane extends GridPane {

    private MainPane mainPane;
    private String vindueNavn = "Fad";
    public FadPane() {
        setHgap(10);
        setVgap(10);
        this.mainPane = mainPane;

        Button lukButton = new Button("Luk");
        Button opretButton = new Button("Opret");





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
