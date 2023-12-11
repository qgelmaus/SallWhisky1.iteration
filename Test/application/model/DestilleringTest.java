package application.model;

import application.controller.Controller;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DestilleringTest {

    @Test
    void dateChecker() {
        //TC1
        //Arrange
        Controller controller = new Controller();
        Destillering destillering1 = new Destillering(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 12), 150, "Eg", "Stairway", "null", null);

        //Act
        boolean TC1 = Destillering.dateChecker(destillering1.getStartDato(), destillering1.getSlutDato());

        //Assert
        assertTrue(TC1);

        //TC2
        //Arrange
        // Destillering destillering2 = new Destillering(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1,9), 150, "Eg", "Irina", "null", null);

        //Act
        //boolean TC2 = Destillering.dateChecker(destillering2.getStartDato(), destillering2.getSlutDato());

        //Assert
        //assertTrue(TC2);

        //TC3
        //Arrange
        Destillering destillering3 = new Destillering(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 13), 200, "Eg", "Stairway", "null", null);

        //Act
        boolean TC3 = Destillering.dateChecker(destillering3.getStartDato(), destillering3.getSlutDato());

        //Assert
        assertTrue(TC3);

        //TC4
        //Arrange
        //Destillering destillering4 = new Destillering(LocalDate.of(2020, 1, 7), LocalDate.of(2020, 1,1), 150, "Eg", "Stairway", "null", null);

        //Act
        //boolean TC4 = Destillering.dateChecker(destillering4.getStartDato(), destillering4.getSlutDato());

        //Assert
        //assertTrue(TC4);
    }

    @Test
    void getStartDato() {

    }

    @Test
    void getSlutDato() {
    }

    @Test
    void getVæskeMængde() {
    }

    @Test
    void getRygeMateriale() {
    }

    @Test
    void getKornSort() {
    }

    @Test
    void getMaltBatch() {
    }

    @Test
    void getMængdeArrayList() {
    }

    @Test
    void addMængde() {
    }

    @Test
    void removeMængde() {
    }

    @Test
    void getMedarbejderList() {
    }

    @Test
    void addMedarbejder() {
    }

    @Test
    void removeMedarbejder() {
    }

    @Test
    void setEmpty() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void getBemærkning() {
    }
}