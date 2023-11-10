package formativetask1;

public class GameManagement {

    private int gameEndValue = 200;
    static int playerOneScore = 0;
    static int playerTwoScore = 0;
    private Turn whoseTurn;
    
    
    public boolean isGameOver() {
        return playerOneScore > gameEndValue || playerTwoScore > gameEndValue;
    }

    public void addToPlayerOneScore(int score) {
        playerOneScore += score;
    }

    public void addToPlayerTwoScore(int score) {
        playerTwoScore += score;
    }

    public enum Turn {
        PLAYERONE,
        PLAYERTWO
    }
    
    public GameManagement() {
        // setting the initial turn to PLAYERTWO
        this.whoseTurn = Turn.PLAYERONE;
    }
    
    public Turn getCurrentTurn() {
        // method to return the turn
        return whoseTurn;
    }
    
    public void changeTurn() {
        //if statement to change turn
        if (whoseTurn == Turn.PLAYERONE) {
            whoseTurn = Turn.PLAYERTWO;
        } else {
            whoseTurn = Turn.PLAYERONE;
        }
    }

}