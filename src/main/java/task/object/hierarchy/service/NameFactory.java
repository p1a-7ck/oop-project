package task.object.hierarchy.service;

import java.util.Random;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
class NameFactory {
    static final int MIN_CHAR_UPPER = 65;
    static final int MAX_CHAR_UPPER = 90;
    static final int MIN_CHAR_LOWER = 97;
    static final int MAX_CHAR_LOWER = 122;
    static final int[] VOWEL_CHARS = {97, 101, 105, 111, 117, 121};

    private int length;
    private Random random = new Random();

    public NameFactory() {
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        if (length < 0)
            throw new IllegalArgumentException("Name's length should be more than or equal to zero");
        this.length = length;
    }

    private boolean isVowel(int charCode) {
        if (charCode > MAX_CHAR_UPPER) charCode += (MIN_CHAR_UPPER - MIN_CHAR_LOWER);
        return charCode == 65 || charCode == 69 || charCode == 73 || charCode == 79 || charCode == 85 || charCode == 89;
    }

    private char nextRandomChar(boolean firstChar, boolean lastVowel) {
        if (firstChar) return (char) (random.nextInt(MAX_CHAR_UPPER - MIN_CHAR_UPPER) + MIN_CHAR_UPPER);
        if (!lastVowel) return (char) VOWEL_CHARS[random.nextInt(6)];
        int intChar = random.nextInt(MAX_CHAR_LOWER - MIN_CHAR_LOWER) + MIN_CHAR_LOWER;
        while (isVowel(intChar)) intChar++;
        return (char) intChar;
    }

    public String createRandomName() {
        boolean lastVowel = false;
        char c;
        String name = "";

        for (int i = 0; i < this.length; i++) {
            c = nextRandomChar(i == 0, lastVowel);
            lastVowel = isVowel(c);
            name = String.format("%s%s", name, c);
        }
        return name;
    }
}