package formativetask1;

import java.util.Scanner;

// This class holds the main game code and will call on other classes for their respective responsibilities.
public class WordGame {

    // The instantiation of objects to help the game run.
    GameManager gameManager = new GameManager();
    ScoreboardManager scoreManager = new ScoreboardManager();
    ValueManager valueManager = new ValueManager();
    ValidityManager validityManager = new ValidityManager();

    // A "start" function to hold the game itself.
    public void start() {

        Scanner sc = new Scanner(System.in);

        // Print out the rules and starting procedure 
        System.out.println("This is a two player game,"
                + "\nplayers will take it in turns to input a 3 letter word and a score will be calculated from that word. The first player who exceeds 200 points loses!"
                + "\nKey: A = 1 point, B = 2 points... Z = 26 points, words can only be used once during the game!"
                + "\nLet's play...");
        System.out.println("\nPlayer One to start");
        while (gameManager.isGameOver() == false) { // while loop as there are an unknown amount of rounds to be played

            // player one goes first, starting with their 'initial word'
            if (gameManager.playerOneInitalWord == false) {

                System.out.println("Enter a 3-letter word, which must have a value of 20 or less, or enter * to give up > ");// need to have a give up option via *
                String firstInputWord = sc.next();
                String firstWord = firstInputWord.toLowerCase();
                // If player one forfeits using "*" in their input, the game ends by changing the forfeit boolean to true
                if (gameManager.forfeitGame(firstWord)) {
                    gameManager.forfeit = true;
                } else {
                    // Pass the word to the managers to check its a valid starting input
                    if (validityManager.startingWordIsValid(firstWord, valueManager.wordValue(firstWord))) {
                        // Add word value to the players score
                        gameManager.addToGameScore(valueManager.wordValue(firstWord));
                        // Print scoreboard with the formatted scoreboardrow
                        scoreManager.updateScoreboardRow(firstWord, valueManager.characterValue(firstWord.charAt(0)),
                                valueManager.characterValue(firstWord.charAt(1)),
                                valueManager.characterValue(firstWord.charAt(2)), valueManager.wordValue(firstWord),
                                gameManager.checkGameScore());
                        System.out.println(scoreManager.scoreboard.toString());
                        // Set the char inputWordLastChar to the last index of player ones word for use in player two's turn
                        gameManager.inputWordLastChar = (firstWord.charAt(2));
                        // Change boolean expression playerOneInitalWord to true so their next words dont have to be < 20.
                        gameManager.playerOneInitalWord = true; // breaks the if (playerOneInitalWord == false){... statement
                        // Change turn.
                        gameManager.changeTurn();
                        // Add firstWord to the list of words used throughout the game.
                        validityManager.addUserInputToList(firstWord);
                    } else {
                        System.out.println("That word doesn't meet the criteria, please enter another 3 letter word");
                    }
                }
                // Player two's first turn starts with their 'initial word'
            } else if (gameManager.playerTwoInitalWord == false) {
                System.out.println("Player Two to choose their first word ...");
                System.out.println("Enter a 3-letter word which must start with the letter "
                        + gameManager.inputWordLastChar + "\nor enter * to give up > ");
                String firstInputWord = sc.next();
                String firstWord = firstInputWord.toLowerCase();
                // If player one forfeits using "*" in their input, the game ends by changing the forfeit boolean to true
                if (gameManager.forfeitGame(firstWord)) {
                    gameManager.forfeit = true;
                } else {
                    // Pass the word to the managers to check its a valid starting input
                    if (validityManager.chosenWordIsValid(firstWord)
                            && gameManager.startingWordCharacter(firstWord)) {
                        System.out.println("Your word exists, its value is: " + valueManager.wordValue(firstWord));
                        // Add wordValue to the players score.
                        gameManager.addToGameScore(valueManager.wordValue(firstWord));
                        // Update the scoreboard and print it.
                        scoreManager.updateScoreboardRow(firstWord, valueManager.characterValue(firstWord.charAt(0)),
                                valueManager.characterValue(firstWord.charAt(1)),
                                valueManager.characterValue(firstWord.charAt(2)), valueManager.wordValue(firstWord),
                                gameManager.checkGameScore());
                        System.out.println(scoreManager.scoreboard.toString());
                        // Set the char inputWordLastChar to the last index of player ones word for use in player two's turn
                        gameManager.inputWordLastChar = (firstWord.charAt(2));
                        // Change boolean expression playerTwoInitalWord to true so their next words dont have to be < 20.
                        gameManager.playerTwoInitalWord = true; // breaks the if (playerTwoInitalWord == false){... statement
                        // Change turn
                        gameManager.changeTurn();
                        // Add firstWord to the list of words used throughout the game.
                        validityManager.addUserInputToList(firstWord);
                    } else {
                        System.out.println("That word doesn't meet the criteria, please enter another 3 letter word");
                    }
                }
            } else {

                System.out.println(gameManager.getCurrentTurn() + " to now choose any 3-letter word that must start with the letter "
                        + gameManager.inputWordLastChar + "\nor enter * to give up > ");
                String inputword = sc.next();
                String word = inputword.toLowerCase();
                // If player one forfeits using "*" in their input, the game ends by changing the forfeit boolean to true
                if (gameManager.forfeitGame(word)) {
                    gameManager.forfeit = true;
                } else {
                    // Pass the word to the managers to check its a valid starting input
                    if (validityManager.chosenWordIsValid(word) && gameManager.startingWordCharacter(word)) {
                        System.out.println("Your word exists and isnt a duplicate, its value is " + valueManager.wordValue(word));
                        gameManager.addToGameScore(valueManager.wordValue(word));
                        // Update the scoreboard and print it.
                        scoreManager.updateScoreboardRow(word, valueManager.characterValue(word.charAt(0)),
                                valueManager.characterValue(word.charAt(1)),
                                valueManager.characterValue(word.charAt(2)), valueManager.wordValue(word),
                                gameManager.checkGameScore());
                        System.out.println(scoreManager.scoreboard.toString());
                        // set the char inputWordLastChar to the last index of player ones word for use in player twos turn
                        gameManager.inputWordLastChar = (word.charAt(2));
                        // switch turn every round.
                        gameManager.changeTurn();
                        // add word to the list of words used throughout the game.
                        validityManager.addUserInputToList(word);
                    } else {
                        System.out.println("word is not valid, please enter a 3 letter word that hasn't been previously used.");
                    }
                }

            }
        }
        // If a player has forfeited  this if statement will run.
        if (gameManager.forfeit == true) {
            System.out.println("GameOver, You have chosen to give up. The final score board looks like this: \n"
                    + scoreManager.scoreboard.toString());
            // A call to change turn and print that player as the winner.
            gameManager.changeTurn();
            System.out.println(gameManager.getCurrentTurn() + " is the winner.");
        } else {
            // if the game has ended but it has not been forfeited this clause will take effect.
            gameManager.changeTurn();
            System.out.println("That word brings the score over 200... " + gameManager.getCurrentTurn() + " loses!");
            // A call to change turn and print that player as the winner.
            gameManager.changeTurn();
            System.out.println(gameManager.getCurrentTurn() + " Wins the game.");
        }
    }

}
