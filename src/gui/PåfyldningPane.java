package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PåfyldningPane extends GridPane {

    private String vindueNavn = "Destillering";
    private MainPane mainPane;

    public PåfyldningPane() {
        setHgap(10);
        setVgap(10);

        this.mainPane = mainPane;

        Button lukButton = new Button("Luk");
        Button opretButton = new Button("Opret");

        add(lukButton, 0, 7);
        add(opretButton, 0, 8);





    }

}
