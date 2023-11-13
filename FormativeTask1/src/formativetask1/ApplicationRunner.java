package formativetask1;

public class ApplicationRunner {
    // FilePathing Information
    // private String dataFile = System.getProperty("user.dir") + File.separator + "datafile.txt";
    // System.out.println("dataFile: " + dataFile);

    public static void main(String[] args) {

        WordGame wordGame = new WordGame();
        wordGame.start();
    }

}
