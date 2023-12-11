package Test;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import application.model.Påfyldning;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void tidPåFad() {

        //TC1
        //Arrange
        Controller controller = new Controller();
        Fad fad1 = new Fad("Sherry", 300, false, "1", LocalDate.of(2023, 11, 20), "Skotland");
        Påfyldning påfyldning1 = new Påfyldning(LocalDate.of(2020, 10, 20), 300, false, fad1);

        //Act
        long TC1 = controller.tidPåFad(påfyldning1.getPåfyldningsDato(), fad1.getTappeDato());

        //Assert
        assertTrue(TC1 >= 1095);


        //TC2
        //Arrange
        //Fad fad2 = new Fad("Sherry", 300, false, "2", LocalDate.of(2020, 7, 05), "Skotland");
        //Påfyldning påfyldning2 = new Påfyldning(LocalDate.of(2019, 9, 10), 300, false, fad2);

        //Act
        //long TC2 = controller.tidPåFad(påfyldning2.getPåfyldningsDato(), fad2.getTappeDato());

        //Assert
        //assertTrue(TC2 >= 1095);


        //TC3
        //Arrange
        Fad fad3 = new Fad("Sherry", 300, false, "3", LocalDate.of(2023, 1, 20), "Skotland");
        Påfyldning påfyldning3 = new Påfyldning(LocalDate.of(2017, 12, 31), 300, false, fad3);

        //Act
        long TC3 = controller.tidPåFad(påfyldning3.getPåfyldningsDato(), fad3.getTappeDato());

        //Assert
        assertTrue(TC3 >= 1095);


        //TC3
        //Arrange
        Fad fad4 = new Fad("Sherry", 300, false, "4", LocalDate.of(2023, 9, 21), "Skotland");
        Påfyldning påfyldning4 = new Påfyldning(LocalDate.of(2016, 9, 21), 300, false, fad4);

        //Act
        long TC4 = controller.tidPåFad(påfyldning4.getPåfyldningsDato(), fad4.getTappeDato());

        //Assert
        assertTrue(TC4 >= 1095);

    }
}