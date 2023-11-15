package formativetask1;

// A Class which manages the game.
// This Class holds the key information of the game.
public class GameManager {

    private int gameEndValue = 200; // The value at which the game will end, if a player exceeds this.
    private char forfeitCharacter = '*'; // The forfeit character for the game. If entered the game will end. 
    private int gameScore = 0; // The starting score of the game.
    private Turn whoseTurn; // Initialising whoseTurn to be a enum from the Turn enum.

    public char inputWordLastChar = 'a'; // Initialising a char which will be changed with every last char from the users input word.
    public boolean playerOneInitalWord = false; // A boolean flag which when false initiates the firstword part of the game for player one.
    public boolean playerTwoInitalWord = false; // A boolean flag which when false initiates the firstword part of the game for player two.
    public boolean forfeit = false; // A boolean flag which when true tells the game a player has chosen to give up.

    // A function to check whether to game has ended
    // by checking the game score against the end value, and whether a player has forfieted.
    public boolean isGameOver() {
        return gameScore > gameEndValue || forfeit == true;
    }

    // A functon to add an integer score to the overall game score.
    public void addToGameScore(int score) {
        gameScore += score;
    }

    // A function to return the gameScore integer.
    public int checkGameScore() {
        return gameScore;
    }

    // /An enum containing the two players.
    public enum Turn {
        PLAYERONE,
        PLAYERTWO
    }

    // A constructor for the class to initialise the whoseTurn to PLAYERONE.
    public GameManager() {
        // setting the initial turn to PLAYERONE.
        this.whoseTurn = Turn.PLAYERONE;
    }

    // A function which returns the current players turn.
    public Turn retrieveFromTurn() {
        return whoseTurn;
    }
    
    public String getCurrentTurn() {
        if (retrieveFromTurn() == Turn.PLAYERONE) {
            return "Player One";
        } else {
            return "Player Two";
        }
    }

    // A function to change players turn.
    public void changeTurn() {
        // if its PLAYERONEs turn set turn as PLAYERTWO
        if (whoseTurn == Turn.PLAYERONE) {
            whoseTurn = Turn.PLAYERTWO;
        } else {
            // else set the turn as PLAYERONE
            whoseTurn = Turn.PLAYERONE;
        }
    }

    // A function which checks for the forfeit game character within the user string.
    public boolean forfeitGame(String word) {
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (character == forfeitCharacter) {
                return true;
            }
        }
        return false;

    }

    // A function which chekcs the first character of the players word
    // matches the last char from the last players word. 
    public boolean startingWordCharacter(String word) {
        return (inputWordLastChar == word.charAt(0));

    }

}
