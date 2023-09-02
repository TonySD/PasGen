package main.java.com.pasgen.generators;

public abstract class Generator {
    protected final String baseWord;

    protected Generator(String baseWord) {
        this.baseWord = baseWord;
    }

    public abstract String getNextVariation();
    public abstract boolean isOver();
}
