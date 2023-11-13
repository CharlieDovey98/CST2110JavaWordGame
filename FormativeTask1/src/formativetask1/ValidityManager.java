package formativetask1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;

public class ValidityManager {

    public String dataFile = System.getProperty("user.dir") + File.separator + "datafile.txt";

    public boolean StartingWordIsValid(String firstWord, int wordValue) {
        // player ones word must be lower than 20, and be a valid word within datafile.txt
        return (isValid(firstWord) && (wordValue <= 20) && containsString(dataFile, firstWord));
    }

    public boolean isValid(String word) {
        // set of rules for the word. (a to z) and 3 characters long.
        String regex = "^[a-z]{3}$";

        // Compile the regex into a pattern.
        Pattern pattern = Pattern.compile(regex);

        // Check the word matches the pattern.
        return pattern.matcher(word).matches();

    }

    public boolean containsString(String dataFile, String word) {
        try {
            BufferedReader buff = new BufferedReader(new FileReader(dataFile));
            String s;
            while ((s = buff.readLine()) != null) {
                if (s.trim().contains(word)) {
                    return true;
                }
            }
            buff.close();
        } catch (Exception e) { // Look at changing exeption if there is time.
            e.printStackTrace();
        }
        return false;
    }

}
