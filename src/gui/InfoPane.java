package gui;

import application.model.Destillering;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class InfoPane extends GridPane {
    private String vindueNavn = "Info";
    private MainPane mainPane;

    public InfoPane(Destillering destillering) {
        setHgap(10);
        setVgap(10);

        this.mainPane = mainPane;
        //buttons
        Button lukButton = new Button("Luk");
        Button opretButton = new Button("Opret");
        TextArea infoBox = new TextArea();
        infoBox.setText(destillering.getKommentar());

        add(infoBox, 0, 0);

        add(lukButton, 0, 8);
        add(opretButton, 1, 8);

    }

    @Override
    public String toString(){
        return vindueNavn;
    }
    }
