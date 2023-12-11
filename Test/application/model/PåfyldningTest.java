import application.model.*;
;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PåfyldningTest {

    @Test
    void createMængdeTest() {


        Fad fad = new Fad("Sherry", 300, false, "1", LocalDate.of(2023, 11, 20), "Skotland");
        Påfyldning påfyldning = new Påfyldning(LocalDate.now(), 100, fad);
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now().plusDays(10), 200, "Malt", "Rye", "Test", "Batch123");

        Mængde mængde = påfyldning.createMængde(50, destillering);

        assertNotNull(mængde);
        assertTrue(påfyldning.getMængdeArrayList().contains(mængde));
    }

    @Test
    void removeMængdeTest() {

        Fad fad = new Fad("Sherry", 300, false, "1", LocalDate.of(2023, 11, 20), "Skotland");
        Påfyldning påfyldning = new Påfyldning(LocalDate.now(), 100, fad);
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now().plusDays(10), 200, "Malt", "Rye", "Test", "Batch123");
        Mængde mængde = påfyldning.createMængde(50, destillering);

        påfyldning.removeMængde(mængde);

        assertFalse(påfyldning.getMængdeArrayList().contains(mængde));
    }

    @Test
    void setAntalLiterTest() {

        Fad fad = new Fad("Sherry", 300, false, "1", LocalDate.of(2023, 11, 20), "Skotland");
        Påfyldning påfyldning = new Påfyldning(LocalDate.now(), 100, fad);
        Destillering destillering = new Destillering(LocalDate.now(), LocalDate.now().plusDays(10), 200, "Malt", "Rye", "Test", "Batch123");
        Mængde mængde = påfyldning.createMængde(50, destillering);

        påfyldning.setAntalLiter(0);

        assertEquals(50, påfyldning.getAntalLiter());
    }
}