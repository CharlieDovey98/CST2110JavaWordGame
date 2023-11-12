package formativetask1;

public class ScoreboardManager {

    GameManager gameManager = new GameManager();
    ValueManager valueManager = new ValueManager();
    
    public StringBuilder scoreboard = new StringBuilder(
            "------------------------------------------------------------\n"
            + "| word                  |     word total |   running total |\n");

    public String updateScoreboardRow(String firstWord) {
        String rowFirstWord = String.format("     | %s (%d + %d + %d) | %-14d | %-14d |%n",
                firstWord,
                valueManager.characterValue(firstWord.charAt(0)),
                valueManager.characterValue(firstWord.charAt(1)),
                valueManager.characterValue(firstWord.charAt(2)),
                valueManager.wordValue(firstWord),
                gameManager.checkGameScore());
        return rowFirstWord;
    }
}
