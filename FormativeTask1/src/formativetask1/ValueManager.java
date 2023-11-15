package formativetask1;

// A class which holds the alphabet and functoins to accertain the value
// of each user input word and each character within that word.
public class ValueManager {

    // the string alphabet allows the index of each character to be found.
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // A function to attain the value of a character by checking index through the alphabet string
    public int characterValue(char character) {
        int indexvalue = alphabet.indexOf(character);
        return indexvalue + 1;
    }

    // A function to get the value of each input word by adding the value of each character within the word
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
