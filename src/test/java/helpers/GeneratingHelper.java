package helpers;

import java.util.Random;

public class GeneratingHelper {

    public static String generatedFirstName(String postCode) {
        int[] ints = new int[5];
        StringBuilder postCodeBuilder = new StringBuilder(postCode);
        StringBuilder newFirstName = new StringBuilder();

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(postCodeBuilder.substring(i, i + 2));
            postCodeBuilder.delete(i, i + 1);
            newFirstName.append(LetterSwitcher.doLetterSwitch(i));
        }
        return newFirstName.toString();
    }

    public static String generatedPostCode() {
        StringBuilder postCodeBuilder = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            postCodeBuilder.append(new Random().nextInt(10));
        }
        return postCodeBuilder.toString();
    }

}
