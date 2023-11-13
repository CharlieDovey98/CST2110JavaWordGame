package formativetask1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ValidityManager {

    // FilePathing Information
    public String dataFile = System.getProperty("user.dir") + File.separator + "datafile.txt";
    private ArrayList<String> wordsList;

    public ValidityManager() {
        wordsList = new ArrayList<>();
    }

    public boolean startingWordIsValid(String firstWord, int wordValue) {
        // player ones word must be lower than 20, and be a valid word within datafile.txt
        return (isValid(firstWord) && (wordValue <= 20) && containsString(dataFile, firstWord) && (checkInputList(firstWord)));
    }

    public boolean chosenWordIsValid(String word) {
        // players word must be a valid word within datafile.txt and not used previously, checking against wordsList
        return (isValid(word) && containsString(dataFile, word) && (checkInputList(word)));
    }

    public boolean containsString(String dataFile, String userWord) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dataFile));
            String fileWord;
            while ((fileWord = bufferedReader.readLine()) != null) {
                if (fileWord.trim().contains(userWord)) {
                    return true;
                }
            }
            bufferedReader.close();
        } catch (IOException e) { // Look into exeptions if there is time.
            e.printStackTrace();
        }
        return false;
    }

    public boolean isValid(String word) {
        // set of rules for the word. (a to z) and 3 characters long.
        String regex = "^[a-z]{3}$";

        // Compile the regex into a pattern.
        Pattern pattern = Pattern.compile(regex);

        // Check the word matches the pattern.
        return pattern.matcher(word).matches();

    }

    public void addUserInputToList(String word) {
        wordsList.add(word);
    }

    public boolean checkInputList(String word) {
        return !wordsList.contains(word);
    }

    public ArrayList<String> getUserInputList() {
        return wordsList;
    }

}
