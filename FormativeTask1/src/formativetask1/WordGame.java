package formativetask1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordGame {

    static boolean playerOneInitalWord = false;
    static boolean playerTwoInitalWord = false;
    static String playerOneInitialwordLastChar = "";

    public void start() {
        GameManagement gameManager = new GameManagement();
        Scanner sc = new Scanner(System.in);
        System.out.println("This is a two player game,"
                + "\nplayers will take it in turns to input a 3 letter word and a score will be calculated from that word. first to above 200 points loses!"
                + "\nKey: A = 1 point, B = 2 points... Z = 26 points"
                + "\nPlayer One to start");
        System.out.println("Let's play...");

        while (gameManager.isGameOver() == false) {

            // player one goes first, starting with their 'initial word'
            if (playerOneInitalWord == false) {

                System.out.println("Enter a 3-letter word, which must have a value of 20 or less, or enter * to give up > ");// need to have a give up option via *
                String firstInputWord = sc.next();
                String firstWord = firstInputWord.toLowerCase();

                if (StartingWordIsValid(firstWord)) {
                    System.out.println("word exists and is lower than 20");
                    //pass word to value method to assertain the value
                    System.out.println("the value of your word is: " + value(firstWord)); // string builder here
                    //add value to the players score
                    gameManager.addToPlayerOneScore(value(firstWord));

                    //print expression, string builder, eg. cat (3+1+20), word total, running total
                    // change boolean expression playerOneInitalWord to true so their next words dont have to be < 20
                    playerOneInitalWord = true;
                    System.out.println("Player 2 to choose their first word ...");
                } else {
                    System.out.println("word doesn't meet the criteria, please enter another 3 letter word");
                }
            } else if (playerTwoInitalWord == false) {

                System.out.println("Enter a 3-letter word, which must have a value of 20 or less, and must start with " /*+ lastletter*/ + " or enter * to give up > ");// need to have a give up option via *
                String firstInputWord = sc.next();
                String firstWord = firstInputWord.toLowerCase();

                if (StartingWordIsValid(firstWord)) {
                    System.out.println("word exists and is lower than 20");
                    //pass word to value method to assertain the value
                    System.out.println("the value of your word is: " + value(firstWord)); // string builder here
                    //add value to the players score
                    gameManager.addToPlayerOneScore(value(firstWord));

                    //print expression, string builder, eg. cat (3+1+20), word total, running total
                    // change boolean expression playerOneInitalWord to true so their next words dont have to be < 20
                    playerOneInitalWord = true;
                } else {
                    System.out.println("word doesn't meet the criteria, please enter another 3 letter word");
                }
            } else {

                System.out.println("Player 1 to choose a word ...");
                String inputword = sc.next();
                String word = inputword.toLowerCase();

                if ((containsString("datafile.txt", word)) && (isValid(word))) {
                    System.out.println("word exists");
                    //pass word to value method to assertain the value
                    //add value to the players score
                    //print expression eg. cat (3+1+20), word total, running total
                    //change turn

                } else {
                    System.out.println("word is not valid, please enter a 3 letter word");
                }

            }
        }
    }

    public boolean gameStart() {
        return playerOneInitalWord;
    }

    // This method checks if the word exists in the datafile
    public boolean containsString(String fileName, String word) {
        try {
            BufferedReader buff = new BufferedReader(new FileReader(fileName));
            String s;
            while ((s = buff.readLine()) != null) {
                if (s.trim().contains(word)) {
                    return true;
                }
            }
            buff.close();
        } catch (Exception e) { // changing exeptions 
            e.printStackTrace();
        }
        return false;
    }

    public boolean isValid(String word) {
        // set of rules for the word. a to z and 3 characters long
        String regex = "^[a-z]{3}$";

        // Compile the regex into a pattern.
        Pattern pattern = Pattern.compile(regex);

        // Check the word matches the pattern.
        return pattern.matcher(word).matches();

    }

    public boolean StartingWordIsValid(String firstWord) {
        // player ones word must be lower than 20, and be a valid word within datafile.txt
        // set game start to true

        return (isValid(firstWord) && ((value(firstWord)) <= 20) && containsString("datafile.txt", firstWord));
    }

    public int value(String word) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            int indexvalue = alphabet.indexOf(character);
            sum += indexvalue + 1;
        }

        return sum;
    }
}