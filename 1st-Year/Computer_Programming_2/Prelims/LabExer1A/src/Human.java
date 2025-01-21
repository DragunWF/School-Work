public class Human {
    private int faveNumber;
    private String faveCartChar;
    private char mi;
    char[] nickNameArray;

    public Human(int faveNumber, String faveCartChar, char mi, char[] nickName) {
        this.faveNumber = faveNumber;
        this.faveCartChar = faveCartChar;
        this.mi = mi;
        this.nickNameArray = nickName;
    }

    // Getter methods (Encapsulation)
    public int getFaveNumber() {
        return this.faveNumber;
    }

    public char getMiddleInitial() {
        return this.mi;
    }

    public String getFavoriteCartoon() {
        return this.faveCartChar;
    }

    public String getNickName() {
        return String.valueOf(this.nickNameArray);
    }
}
