package test.java.com.pasgen.utils;

import main.java.com.pasgen.utils.ArgumentParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentParserTest {

    @Test
    void checkingParseArguments() {
        String[] customArguments = new String[] {
                "{userpath}/java",
                "-a",
                "something for argument a",
                "--b",
                "something for argument b: first item",
                "something for argument b: second item"
        };

        String arguments_parsed = ArgumentParser.parseArguments(customArguments).toString();

        // TODO: Fix it and make deep validation
        String expectedString = "{path=[{userpath}/java], a=[something for argument a], b=[something for argument b: first item, something for argument b: second item]}";

        assertEquals(arguments_parsed, expectedString);
    }
}