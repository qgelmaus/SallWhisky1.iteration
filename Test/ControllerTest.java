package Test;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import application.model.Påfyldning;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void tidPåFad() {
        Controller controller = new Controller();
        Destillering destillering = new Destillering(LocalDate.of(2020, 12, 9), LocalDate.of(2023, 12, 20), 300, "Birk", "Byg", "Første destillering", "MaltBatch1");
        Fad fad = new Fad("Sherry", 300, false, 1, LocalDate.of(2023, 12, 25), "Skotland", 0);
        Påfyldning påfyldning = new Påfyldning(LocalDate.of(2020, 12, 25), 300, false, fad);
        long dage = controller.tidPåFad(påfyldning.getPåfyldningsDato(), fad.getTappeDato());
        assertEquals(1095,dage);





    }
}