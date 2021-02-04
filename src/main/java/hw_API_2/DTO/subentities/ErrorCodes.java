package hw_API_2.DTO.subentities;

public enum ErrorCodes {
    ERROR_UNKNOWN_WORD      (1),
    ERROR_REPEAT_WORD       (2),
    ERROR_CAPITALIZATION    (3),
    ERROR_TOO_MANY_ERRORS	(4);

    private int value;

    ErrorCodes(int value) {
        this.value = value;
    }

    public int getValue(){return this.value;}
}


