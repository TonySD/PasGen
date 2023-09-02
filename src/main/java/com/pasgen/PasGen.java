package main.java.com.pasgen;

import main.java.com.pasgen.generators.NumberAddition;
import main.java.com.pasgen.generators.UpperLowerCase;

public class PasGen {
    public static void main(String[] args) {
        String test;
        NumberAddition generator = new NumberAddition("test", 5);
        String wtf;
        int counter = 0;
        while (!generator.isOver()) {
            wtf = generator.getNextVariation();
            System.out.println(wtf);
            System.out.println(counter++);
        }
    }
}
