package formativetask1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

// A Class which holds the validity checks on the user input words.
// This Class also holds an array list with all the user input words.
public class ValidityManager {

    // FilePathing Information
    public String dataFile = System.getProperty("user.dir") + File.separator + "datafile.txt";
    private ArrayList<String> wordsList;

    public ValidityManager() {
        wordsList = new ArrayList<>();
    }

    // A function that returns a boolean, checking whether the first word is valid, below 20 points, 
    // is within the datafile.txt and hasnt been used yet.
    // checkInputList is irrelevant for this function however if players wanted to black list words
    // they could be added to the array and would affect the boolean result of this function.
    public boolean startingWordIsValid(String firstWord, int wordValue) {
        // player ones word must be lower than 20, and be a valid word within datafile.txt
        return (isValid(firstWord) && (wordValue <= 20) && containsString(dataFile, firstWord) && (checkInputList(firstWord)));
    }

    // A function to check whether the word chosen is a valid word, within the datafile and hasnt been used before.
    public boolean chosenWordIsValid(String word) {
        // players word must be a valid word within datafile.txt and not used previously, checking against wordsList
        return (isValid(word) && containsString(dataFile, word) && (checkInputList(word)));
    }

    
    // A function that returns true if the chosen word is within the datafile.txt
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

    
    // A function which holds a regex to specify that the chosen word should be in the english alphabet a-z,
    // and three letters long. This will return a true if the chosen word meets this criteria.
    public boolean isValid(String word) {
        // set of rules for the word. (a to z) and 3 characters long.
        String regex = "^[a-z]{3}$";

        // Compile the regex into a pattern.
        Pattern pattern = Pattern.compile(regex);

        // Check the word matches the pattern.
        return pattern.matcher(word).matches();

    }

    // A function to add the chosen word to the Arraylist "wordsList".
    public void addUserInputToList(String word) {
        wordsList.add(word);
    }

    // aA function which returns a boolean, checking whether the chosen word is not within the wordsList array.
    public boolean checkInputList(String word) {
        return !wordsList.contains(word);
    }

    // A function to return the wrodsList array.
    public ArrayList<String> getUserInputList() {
        return wordsList;
    }

}
