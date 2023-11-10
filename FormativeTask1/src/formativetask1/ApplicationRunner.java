package formativetask1;

import java.io.File;

public class ApplicationRunner {

    public static void main(String[] args) {
        
        //FilePathing Information
        String dataFile = System.getProperty("user.dir") + File.separator + "datafile.txt";
        String fileLocation = System.getProperty("user.dir");
        String dataPath = fileLocation + File.separator + "datafile.txt";
        //System.out.println("dataFile" + dataFile + "\nfileLocation" + fileLocation + "\ndataPath" + dataPath);

        WordGame wordGame = new WordGame();
        wordGame.start();
    }

}