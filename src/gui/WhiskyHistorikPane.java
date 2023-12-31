package gui;

import application.model.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class WhiskyHistorikPane extends GridPane {
    private String vindueNavn = "Lav whisky";



    public WhiskyHistorikPane(Whisky whisky){
        Påfyldning påfyldning = whisky.getPåfyldning();
        Fad fad = påfyldning.getFad();
        List<Mængde> mængder = new ArrayList<>();
        List<Påfyldning> påfyldninger = new ArrayList<>();
        List<Destillering> destilleringer = new ArrayList<>();
        ListView<Destillering> destilleringerLw = new ListView<>();

        for (int i = 0; i < fad.getPåfyldningArrayList().size(); i++) {
            påfyldninger.add(i,fad.getPåfyldningArrayList().get(i));
        }

        for (int i = 0; i < påfyldninger.size(); i++) {
            for (int j = 0; j < påfyldninger.get(i).getMængdeArrayList().size(); j++) {
                mængder.add(i, påfyldninger.get(i).getMængdeArrayList().get(j));
            }
        }

        for (int i = 0; i < mængder.size(); i++) {
            destilleringer.add(i, mængder.get(i).getDestillering());
        }

        destilleringerLw = new ListView();
        destilleringerLw.getItems().addAll(destilleringer);

        add(destilleringerLw,0,0);

        Button lukButton = new Button("Luk");
        add(lukButton, 0, 1);

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


