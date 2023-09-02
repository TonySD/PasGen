package test.java.com.pasgen.generators;

import main.java.com.pasgen.generators.UpperLowerCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpperLowerCaseTest {
    static String testingString = "test";

    @Test
    void isOver() {
        UpperLowerCase generator = new UpperLowerCase(testingString);
        for (int i = 0; i < Math.pow(2, testingString.length()); i++) {
            generator.getNextVariation();
        }
        assertTrue(generator.isOver());
    }

    @Test
    void getNextVariation() {
        UpperLowerCase generator = new UpperLowerCase(testingString);

        assertEquals(generator.getNextVariation(), testingString);
        assertNotEquals(generator.getNextVariation(), testingString);

        for (int i = 2; i < Math.pow(2, testingString.length()) - 1; i++) {
            generator.getNextVariation();
        }

        assertEquals(testingString.toUpperCase(), generator.getNextVariation());
    }

    @Test
    void findTest() {
        UpperLowerCase generator = new UpperLowerCase(testingString);
        String stringToFind = "TeST";
        String current = "";
        while (!generator.isOver()) {
            current = generator.getNextVariation();
            if (current.equals(stringToFind)) break;
        }

        assertEquals(stringToFind, current);
    }
}