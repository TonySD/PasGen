package test.java.com.pasgen.generators;

import main.java.com.pasgen.generators.NumberAddition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberAdditionTest {
    static String testingString = "test";

    @Test
    void isOver() {

        NumberAddition generator = new NumberAddition(testingString, 2);
        for (int i = 0; i <= 110; i++) {
            generator.getNextVariation();
        }
        System.out.println(generator.getNextVariation());
        assertTrue(generator.isOver());
    }

    @Test
    void getNextVariation() {
        for (int i = 1; i < 4; i++) {
            NumberAddition generator = new NumberAddition(testingString, i);
            assertEquals(testingString + "0", generator.getNextVariation());
            assertEquals(testingString + "1", generator.getNextVariation());

            for (int j = 0; j < 7; j++) {
                generator.getNextVariation();
            }

            assertEquals(testingString + "9", generator.getNextVariation());

            while (!generator.isOver()) generator.getNextVariation();

            assertEquals("", generator.getNextVariation());
        }
    }

    @Test
    void testFind() {
        String stringToFind = testingString + "1337";
        NumberAddition generator = new NumberAddition(testingString, 4);
        String current = "";
        while (!generator.isOver()) {
            current = generator.getNextVariation();
            if (current.equals(stringToFind)) break;
        }
        assertEquals(stringToFind, current);
    }
}