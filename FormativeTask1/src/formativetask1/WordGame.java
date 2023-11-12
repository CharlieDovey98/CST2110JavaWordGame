package formativetask1;

import java.util.Scanner;

public class WordGame {

    GameManager gameManager = new GameManager();
    ScoreboardManager scoreManager = new ScoreboardManager();
    ValueManager valueManager = new ValueManager();  
    ValidityManager validityManager = new ValidityManager();

    public void start() {

        Scanner sc = new Scanner(System.in);

        System.out.println("This is a two player game,"
                + "\nplayers will take it in turns to input a 3 letter word and a score will be calculated from that word. The first player who exceeds 200 points loses!"
                + "\nKey: A = 1 point, B = 2 points... Z = 26 points, words can only be used once during the game!"
                + "\nPlayerOne to start");
        System.out.println("Let's play...");
        System.out.println(gameManager.getCurrentTurn());

        while (gameManager.isGameOver() == false) { // while loop as there are an unknown amount of rounds to be played

            // player one goes first, starting with their 'initial word'
            if (gameManager.playerOneInitalWord == false) {
                System.out.println(gameManager.getCurrentTurn());

                System.out.println("Enter a 3-letter word, which must have a value of 20 or less, or enter * to give up > ");// need to have a give up option via *
                String firstInputWord = sc.next();
                String firstWord = firstInputWord.toLowerCase();
                if (gameManager.forfeitGame(firstWord)) {
                    gameManager.forfeit = true;
                } else {
                    if (validityManager.StartingWordIsValid(firstWord)) {
                        System.out.println("word exists and is lower than 20");
                        //pass word to wordValue method to assertain the wordValue
                        System.out.println("the value of your word is: " + valueManager.wordValue(firstWord));
                        //add wordValue to the players score
                        gameManager.addToGameScore(valueManager.wordValue(firstWord));
                        //print scoreboard with the formatted scoreboardrow
                        String formattedScoreboardRowFirstWord = String.format("     | %s (%d + %d + %d) | %-14d | %-14d |%n",
                                firstWord,
                                valueManager.characterValue(firstWord.charAt(0)),
                                valueManager.characterValue(firstWord.charAt(1)),
                                valueManager.characterValue(firstWord.charAt(2)),
                                valueManager.wordValue(firstWord),
                                gameManager.checkGameScore());

                        scoreManager.scoreboard.append("------------------------------------------------------------\n")
                                .append(formattedScoreboardRowFirstWord);
                        System.out.println(scoreManager.scoreboard.toString());
                        // set the char playerOneInitialwordLastChar to the last index of player ones word for use in player twos turn
                        gameManager.playerOneInitialwordLastChar = (firstWord.charAt(2));
                        // change boolean expression playerOneInitalWord to true so their next words dont have to be < 20.
                        gameManager.playerOneInitalWord = true; // breaks the if (playerOneInitalWord == false){... statement
                        gameManager.changeTurn();
                        System.out.println("Player 2 to choose their first word ...");
                    } else {
                        System.out.println("word doesn't meet the criteria, please enter another 3 letter word");
                    }
                }
            } else if (gameManager.playerTwoInitalWord == false) {
                System.out.println(gameManager.getCurrentTurn());

                System.out.println("Enter a 3-letter word, which must have a value of 20 or less, and must start with the letter "
                        + gameManager.playerOneInitialwordLastChar + "\nor enter * to give up > ");// need to have a give up option via *
                String firstInputWord = sc.next();
                String firstWord = firstInputWord.toLowerCase();
                // Checking for the forfeit game character
                if (gameManager.forfeitGame(firstWord)) {
                    gameManager.forfeit = true;
                } else {
                    if (validityManager.StartingWordIsValid(firstWord) && gameManager.startingWordCharacter(firstWord, gameManager.playerOneInitialwordLastChar)) {
                        System.out.println("word exists and is lower than 20");
                        //pass word to wordValue method to assertain the wordValue
                        System.out.println("the value of your word is: " + valueManager.wordValue(firstWord));
                        //add wordValue to the players score
                        gameManager.addToGameScore(valueManager.wordValue(firstWord));
                        //print expression, string builder, eg. cat (3+1+20), word total, running total
                        String formattedScoreboardRowFirstWord = String.format("     | %s (%d + %d + %d) | %16d | %16d |%n",
                                firstWord,
                                valueManager.characterValue(firstWord.charAt(0)),
                                valueManager.characterValue(firstWord.charAt(1)),
                                valueManager.characterValue(firstWord.charAt(2)),
                                valueManager.wordValue(firstWord),
                                gameManager.checkGameScore());

                        scoreManager.scoreboard.append("------------------------------------------------------------\n")
                                .append(formattedScoreboardRowFirstWord);
                        System.out.println(scoreManager.scoreboard.toString());
                        // change boolean expression playerTwoInitalWord to true so their next words dont have to be < 20.
                        gameManager.playerTwoInitalWord = true; // breaks the if (playerTwoInitalWord == false){... statement
                        gameManager.changeTurn();
                    } else {
                        System.out.println("word doesn't meet the criteria, please enter another 3 letter word");
                    }
                }
            } else {

                System.out.println(gameManager.getCurrentTurn() + " choose a word ...");
                String inputword = sc.next();
                String word = inputword.toLowerCase();
                if (gameManager.forfeitGame(word)) {
                    gameManager.forfeit = true;
                } else {
                    if ((validityManager.containsString(validityManager.dataFile, word)) && (validityManager.isValid(word))) {
                        System.out.println("word exists");
                        //pass word to wordValue method to assertain the wordValue
                        System.out.println("the value of your word is: " + valueManager.wordValue(word));
                        gameManager.addToGameScore(valueManager.wordValue(word));
                        String formattedScoreboardRow = String.format("     | %s (%d + %d + %d) | %16d | %16d |%n",
                                word,
                                valueManager.characterValue(word.charAt(0)),
                                valueManager.characterValue(word.charAt(1)),
                                valueManager.characterValue(word.charAt(2)),
                                valueManager.wordValue(word),
                                gameManager.checkGameScore());

                        scoreManager.scoreboard.append("------------------------------------------------------------\n")
                                .append(formattedScoreboardRow);
                        System.out.println(scoreManager.scoreboard.toString());
                        gameManager.changeTurn();
                    } else {
                        System.out.println("word is not valid, please enter a 3 letter word");
                    }
                }

            }
        }
        if (gameManager.forfeit == true) {
            System.out.println("GameOver, You have chosen to give up. The final score board looks like this: \n"
                    + scoreManager.scoreboard.toString());
            gameManager.changeTurn();
            System.out.println(gameManager.getCurrentTurn() + " is the winner.");
        } else {
            gameManager.changeTurn();
            System.out.println("That word brings the score over 200... " + gameManager.getCurrentTurn() + " loses!");
            gameManager.changeTurn();
            System.out.println(gameManager.getCurrentTurn() + " Wins the game.");
        }
    }

}
