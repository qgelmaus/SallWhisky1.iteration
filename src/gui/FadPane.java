package gui;

import application.controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.time.LocalDate;

public class FadPane extends GridPane {

    private MainPane mainPane;
    private String vindueNavn = "Fad";
    public FadPane() {
        setHgap(10);
        setVgap(10);
        this.mainPane = mainPane;

        Label fadTypeLbl = new Label("Fydtype:");
        ComboBox<String> fadTypeCbo = new ComboBox<>();
        Label fadStørrelseLbl = new Label("Fadstørrelse:");
        ComboBox<Double> fadStørrelseCbo = new ComboBox<Double>();
        Label fadIdLbl = new Label("Fad ID:");
        TextField fadIdTxf = new TextField();
        Label oprindelseLbl = new Label("Oprindelsesland:");
        TextField oprindelseTxf = new TextField();



        Button lukButton = new Button("Luk");
        Button opretButton = new Button("Opret fad");

        add(fadTypeLbl,0,0);
        add(fadTypeCbo,1, 0);

        add(fadStørrelseLbl,0, 1);
        add(fadStørrelseCbo,1, 1);

        add(fadIdLbl,0,2);
        add(fadIdTxf,1,2);

        add(oprindelseLbl, 0, 3);
        add(oprindelseTxf, 1, 3);


        add(lukButton, 0, 4);
        add(opretButton, 1, 4);

        fadTypeCbo.getItems().addAll("Eg", "Ask");
        fadStørrelseCbo.getItems().addAll(150.0, 200.0, 280.0
        );

        opretButton.setOnAction(e -> opretFadButton(
                fadTypeCbo.getSelectionModel().getSelectedItem(),
                fadStørrelseCbo.getSelectionModel().getSelectedItem(),
                fadIdTxf.getText(),
                oprindelseTxf.getText()

        ));



    }

    public void lukVindue() {
        Stage stage = (Stage) getScene().getWindow();
        stage.close();
    }

    @Override
    public String toString(){
        return vindueNavn;
    }

    public void opretFadButton(String fadType, double fadstørrelse, String fadId, String oprindelse){
        Controller.opretFad(fadType, fadstørrelse, false, fadId, null, oprindelse);
        lukVindue();
    }


}
