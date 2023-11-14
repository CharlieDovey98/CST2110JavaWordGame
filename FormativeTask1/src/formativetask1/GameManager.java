package formativetask1;

public class GameManager {

    private int gameEndValue = 200;
    private char forfeitCharacter = '*';
    private int gameScore = 0;
    private Turn whoseTurn;

    public char playerOneInitialwordLastChar = 'a';
    public boolean playerOneInitalWord = false;
    public boolean playerTwoInitalWord = false;
    public boolean forfeit = false;

    public boolean isGameOver() {
        return gameScore > gameEndValue || forfeit == true;
    }

    public void addToGameScore(int score) {
        gameScore += score;
    }

    // Returns the gameScore int.
    public int checkGameScore() {
        return gameScore;
    }

    // enum containing the two players.
    public enum Turn {
        playerOne,
        playerTwo
    }

    // gives the ability to change who goes first.
    public GameManager() {
        // setting the initial turn to playerTwo.
        this.whoseTurn = Turn.playerOne;
    }

    // returns the current players turn
    public Turn getCurrentTurn() {
        return whoseTurn;
    }

    // method to change players turn.
    public void changeTurn() {
        if (whoseTurn == Turn.playerOne) {
            whoseTurn = Turn.playerTwo;
        } else {
            whoseTurn = Turn.playerOne;
        }
    }

    // method checking for the forfeit game character within the user string.
    public boolean forfeitGame(String word) {
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (character == forfeitCharacter) {
                return true;
            }
        }
        return false;

    }

    // checking the 2nd players word matches the last char from the 1st players initial word 
    public boolean startingWordCharacter(String firstWord) {
        return (playerOneInitialwordLastChar == firstWord.charAt(0));

    }

}
