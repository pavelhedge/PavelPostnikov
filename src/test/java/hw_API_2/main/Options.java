package hw_API_2.main;

import org.testng.annotations.Test;

public enum Options {
        IGNORE_DIGITS   (1),
        IGNORE_URLS     (2),
        FIND_REPEAT_WORDS(8),
        IGNORE_CAPITALIZATION	(512);

    private int value;

    Options(int value) {
        this.value = value;
    }

    public int getValue(){return this.value;}


    public static int getOptions(Options... options) {
        int result = 0;
        for (Options option : options) {
            result += option.value;
        }
        return result;
    }
}


