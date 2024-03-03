package helpers;

public class LetterSwitcher {
    private static final char[] LETTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static char doLetterSwitch(int i) {
        return LETTERS[i % 26];
    }
}
