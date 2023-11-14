package formativetask1;

public class ValueManager {

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public int characterValue(char character) {
        int indexvalue = alphabet.indexOf(character);
        return indexvalue + 1;
    }

    public int wordValue(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            int indexvalue = alphabet.indexOf(character);
            sum += indexvalue + 1;
        }

        return sum;
    }

}
