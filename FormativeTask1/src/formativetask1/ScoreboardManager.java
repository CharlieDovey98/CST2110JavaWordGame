package formativetask1;

public class ScoreboardManager {
    // This class is to format and update the scoreboard 
    public StringBuilder scoreboard = new StringBuilder(
            "------------------------------------------------------------\n"
            + "| word                  |     word total |   running total |\n"
            + "------------------------------------------------------------\n");

    public void updateScoreboardRow(String word, int char0, int char1, int char2, int wordValue, int gameScore) {
        String characterValuesString = String.format("(%d + %d + %d)", char0, char1, char2);
        String rowFirstWord = String.format("| %-4s %-16s | %14d | %15d |%n"
                + "------------------------------------------------------------\n",
                word, characterValuesString, wordValue, gameScore);
        scoreboard.append(rowFirstWord);
        
    }
}
