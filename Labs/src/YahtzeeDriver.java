/**
 * Created by Geoffrey on 12/18/15.
 */
import java.util.Scanner;


public class YahtzeeDriver
{
    /*
    1. Creates a new instance of the YahtzeeGame class
    2. Calls the playGame method on the Yahtzee object
    3. Asks user if they would like to play again
    4. When the user is done playing, prints the number of games played, min, max, and average score
    */
    public static void main(String [] args)
    {
        Scanner s = new Scanner(System.in);
        int score;
        int numGames = 0;
        int minScore = 9999;
        int maxScore = -9999;
        int allScore = 0;
        String answer;
        YahtzeeGame myGame=new YahtzeeGame();
        System.out.println("Welcome to Geoffrey's APCSA Yahtzee Game!");
        do {
            score=myGame.playGame();
            System.out.print("Do you want to play again? (yes/no):  ");
            answer = s.nextLine();
            numGames++;
            if (minScore > score) {
                minScore = maxScore;
            }
            if (maxScore < score) {
                maxScore = score;
            }
            allScore += score;
        } while (answer.indexOf("yes") >= 0);
        System.out.println("Number of Games Played: " + numGames);
        System.out.println("Min Score: " + minScore);
        System.out.println("Max Score: " + maxScore);
        System.out.println("Average Score: " + (allScore / numGames));
    }

}