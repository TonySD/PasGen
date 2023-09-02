package test.java.com.pasgen.generators;

import main.java.com.pasgen.generators.UpperLowerCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpperLowerCaseTest {

    @Test
    void isOver() {
        String testingString = "test";
        UpperLowerCase generator = new UpperLowerCase(testingString);
        for (int i = 0; i < Math.pow(2, testingString.length()); i++) {
            generator.getNextVariation();
        }
        assertTrue(generator.isOver());
    }

    @Test
    void getNextVariation() {
        String testingString = "test";
        UpperLowerCase generator = new UpperLowerCase(testingString);

        assertEquals(generator.getNextVariation(), testingString);
        assertNotEquals(generator.getNextVariation(), testingString);

        for (int i = 2; i < Math.pow(2, testingString.length()) - 1; i++) {
            generator.getNextVariation();
        }

        assertEquals(testingString.toUpperCase(), generator.getNextVariation());
    }
}