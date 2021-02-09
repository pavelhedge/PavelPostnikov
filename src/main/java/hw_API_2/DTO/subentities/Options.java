package hw_API_2.DTO.subentities;

public enum Options {
        IGNORE_DIGITS   (2),
        IGNORE_URLS     (4),
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


