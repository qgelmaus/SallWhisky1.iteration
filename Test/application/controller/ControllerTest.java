package application.controller;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import application.model.Påfyldning;
import org.junit.jupiter.api.Test;

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
        Påfyldning påfyldning1 = new Påfyldning(LocalDate.of(2020, 10, 20), 300, fad1);

        //Act
        long TC1 = controller.tidPåFad(påfyldning1.getPåfyldningsDato(), fad1.getTappeDato());

        //Assert
        assertTrue(TC1 >= 1095);


        //TC2
        //Arrange
        Fad fad2 = new Fad("Sherry", 300, false, "2", LocalDate.of(2020, 7, 05), "Skotland");
        Påfyldning påfyldning2 = new Påfyldning(LocalDate.of(2019, 9, 10), 300, fad2);

        //Act
        long TC2 = controller.tidPåFad(påfyldning2.getPåfyldningsDato(), fad2.getTappeDato());

        //Assert
        assertTrue(TC2 >= 1095);


        //TC3
        //Arrange
        Fad fad3 = new Fad("Sherry", 300, false, "3", LocalDate.of(2023, 1, 20), "Skotland");
        Påfyldning påfyldning3 = new Påfyldning(LocalDate.of(2017, 12, 31), 300, fad3);

        //Act
        long TC3 = controller.tidPåFad(påfyldning3.getPåfyldningsDato(), fad3.getTappeDato());

        //Assert
        assertTrue(TC3 >= 1095);


        //TC3
        //Arrange
        Fad fad4 = new Fad("Sherry", 300, false, "4", LocalDate.of(2023, 9, 21), "Skotland");
        Påfyldning påfyldning4 = new Påfyldning(LocalDate.of(2016, 9, 21), 300, fad4);

        //Act
        long TC4 = controller.tidPåFad(påfyldning4.getPåfyldningsDato(), fad4.getTappeDato());

        //Assert
        assertTrue(TC4 >= 1095);

    }

    @Test
    void opretFad() {
        // TC1
        // Arrange
        Controller controller = new Controller();
        Fad expectedFad1 = new Fad("Sherry", 300, false, "1", LocalDate.of(2023, 11, 20), "Skotland");

        // Act
        Fad actualFad1 = controller.opretFad("Sherry", 300, false, "1", LocalDate.of(2023, 11, 20), "Skotland");

        // Assert
        assertEquals(expectedFad1.getFadType(), actualFad1.getFadType());
        assertEquals(expectedFad1.getFadstørrelse(), actualFad1.getFadstørrelse());
        assertEquals(expectedFad1.isBlended(), actualFad1.isBlended());
        assertEquals(expectedFad1.getFadId(), actualFad1.getFadId());
        assertEquals(expectedFad1.getTappeDato(), actualFad1.getTappeDato());
        assertEquals(expectedFad1.getOprindelse(), actualFad1.getOprindelse());

        // TC2
        // Arrange
        Fad expectedFad2 = new Fad("Sherry", 300, false, "2", LocalDate.of(2020, 7, 5), "Skotland");

        // Act
        Fad actualFad2 = controller.opretFad("Sherry", 300, false, "2", LocalDate.of(2020, 7, 5), "Skotland");

        // Assert
        assertEquals(expectedFad2.getFadType(), actualFad2.getFadType());
        assertEquals(expectedFad2.getFadstørrelse(), actualFad2.getFadstørrelse());
        assertEquals(expectedFad2.isBlended(), actualFad2.isBlended());
        assertEquals(expectedFad2.getFadId(), actualFad2.getFadId());
        assertEquals(expectedFad2.getTappeDato(), actualFad2.getTappeDato());
        assertEquals(expectedFad2.getOprindelse(), actualFad2.getOprindelse());
    }
}