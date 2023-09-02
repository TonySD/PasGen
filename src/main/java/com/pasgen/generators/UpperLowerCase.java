package main.java.com.pasgen.generators;

public class UpperLowerCase extends Generator {
    private int amountOfBits;  // amount of consonant letters
    private final int finalInt;
    private int bitArray = 0;

    public UpperLowerCase(String word) {
        super(word.toLowerCase());
        amountOfBits = 0;
        for (char c : baseWord.toCharArray()) {
            if (isConsonant(c)) amountOfBits++;
        }

        finalInt = 1 << amountOfBits;
    }

    private boolean[] getBits() {
        boolean[] bits = new boolean[amountOfBits];

        for (int i = amountOfBits - 1; i >= 0; i--) {
            bits[i] = (bitArray & (1 << i)) != 0;
        }

        return bits;
    }

    private boolean isConsonant(char c) {
        return 'a' <= c && c <= 'z';
    }

    public boolean isOver() {
        return bitArray >= finalInt;
    }

    @Override
    public String getNextVariation() {
        if (isOver()) return "";
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] bits = getBits();
        int consonantCounter = 0;
        char[] characters = baseWord.toCharArray();

        for (int i = 0; i < baseWord.length(); ++i) {
            if (!isConsonant(characters[i])) {
                stringBuilder.append(characters[i]);
                continue;
            }

            if (bits[consonantCounter]) stringBuilder.append(
                    Character.toUpperCase(characters[i])
            );
            else stringBuilder.append(characters[i]);

            consonantCounter++;
        }

        bitArray++;
        return stringBuilder.toString();
    }

}
