package main.java.com.pasgen.generators;

public class NumberAddition extends Generator {
    public final int depth; // how many numbers will be brute
    private int currentLength = 1;
    private int currentInt = 0;

    public NumberAddition(String word, int depth) {
        super(word);
        this.depth = depth;
    }

    private boolean isOverCurrentDegree(int degree) {
        return Math.pow(10, degree) <= currentInt;
    }

    @Override
    public boolean isOver() {
        return isOverCurrentDegree(depth) || currentLength > depth;
    }

    @Override
    public String getNextVariation() {
        if (isOverCurrentDegree(currentLength)) {
            currentInt = 0;
            currentLength++;
        }
        if (isOver()) return "";
        String format = "%0" + currentLength + "d";

        return baseWord + String.format(format, currentInt++);
    }
}
