/**
 * Created by Geoffrey on 12/17/15.
 */
import java.util.Random;
import java.util.Scanner;

public class YahtzeeGame
{
    /* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
    which should be set to six (the number of sides on a yahtzee die) */
    private YahtzeeDie dice1;
    private YahtzeeDie dice2;
    private YahtzeeDie dice3;
    private YahtzeeDie dice4;
    private YahtzeeDie dice5;
    private YahtzeeScorecard y;
    public static final int NUM_SIDES = 6;


    /* initializes the dice and scoreboard */
    public YahtzeeGame()
    {
        dice1 = new YahtzeeDie(NUM_SIDES);
        dice2 = new YahtzeeDie(NUM_SIDES);
        dice3 = new YahtzeeDie(NUM_SIDES);
        dice4 = new YahtzeeDie(NUM_SIDES);
        dice5 = new YahtzeeDie(NUM_SIDES);
        y = new YahtzeeScorecard();
    }

    /* check to see if the game is over, and while the game is not over call the method takeTurn()
    once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
    final scorecard and return the grand total */
    public int playGame()
    {
        int turns = 0;
        while (turns <= 13) {
            takeTurn();
            turns++;
        }
        return y.getGrandTotal();
    }

    /* 	1. call rollDice()
        2. call printDice()
        3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
           If they are not satisfied continue, otherwise call markScore()
        4. call chooseFrozen()
        5. call rollDice()
        6. call printDice()
        7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
           If they are not satisfied continue, otherwise call markScore()
        8. call chooseFrozen()
        9. call rollDice()
        10. call printDice()
        11. call markScore()
    */
    private void takeTurn()
    {
        int i = 0;
        String answer;
        Scanner s = new Scanner(System.in);
        boolean b = true;
        while (b == true) {
            rollDice();
            printDice();
            if (i == 2) {
                b = false;
                markScore();
            }
            if (i < 2) {
                System.out.println("Are you (s)atisfied or to you want to freeze dice and (r)oll again? (s/r):");
                answer = new String(s.nextLine());
                if (answer.indexOf("r") >= 0) {
                    chooseFrozen();
                } else {
                    b = false;
                    markScore();
                }
                i++;
            }
        }
    }

    /* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
    private void rollDice()
    {
        if (dice1.isFrozen() == false) {
            dice1.rollDie();
        }
        if (dice2.isFrozen() == false) {
            dice2.rollDie();
        }
        if (dice3.isFrozen() == false) {
            dice3.rollDie();
        }
        if (dice4.isFrozen() == false) {
            dice4.rollDie();
        }
        if (dice5.isFrozen() == false) {
            dice5.rollDie();
        }
    }

    /* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
    private void chooseFrozen()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("What dice would you like to freeze? (1-5) : ");
        String answer = new String (s.nextLine());
        if (answer.indexOf("1") >= 0) {
            dice1.freezeDie();
        }
        if (answer.indexOf("2") >= 0) {
            dice2.freezeDie();
        }
        if (answer.indexOf("3") >= 0) {
            dice3.freezeDie();
        }
        if (answer.indexOf("4") >= 0) {
            dice4.freezeDie();
        }
        if (answer.indexOf("5") >= 0) {
            dice5.freezeDie();
        }
    }

    /* Should print the value of all five dice separated by a tab (\t) to the console */
    private void printDice()
    {
        System.out.println(dice1.getValue() + "\t" + dice2.getValue() + "\t" + dice3.getValue() + "\t" + dice4.getValue() + "\t" + dice5.getValue() + "\t" );
    }

    /* 1. Print a scoreboard
       2. Ask the user where they would like to mark their score.
       3. Call appropriate function
       4. If false is returned the user entered an invalid number, so ask the user to try again	*/
    private void markScore()
    {
        boolean b = false;
        y.printScoreCard();
        Scanner r = new Scanner(System.in);
        while(b != true){
            System.out.println("Where would you like to place your score? \n 1. Ones 	7.  3 of Kind \n 2. Twos 	8.  4 of Kind \n 3. Threes 	9.  Full House \n 4. Fours 	10. Sm Straight \n 5. Fives 	11. Lg Straight \n 6. Sixes 	12. Yahtzee \n 		13. Chance");
            String again  = r.nextLine();
            switch(again){
                case "1":
                    b = y.markOnes(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "2":
                    b = y.markTwos(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "3":
                    b = y.markThrees(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "4":
                    b = y.markFours(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "5":
                    b = y.markFives(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "6":
                    b = y.markSixes(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "7":
                    b = y.markThreeOfAKind(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "8":
                    b = y.markFourOfAKind(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "9":
                    b = y.markFullHouse(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "10":
                    b = y.markSmallStraight(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "11":
                    b = y.markLargeStraight(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "12":
                    b = y.markYahtzee(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
                case "13":
                    b = y.markChance(dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue());
                    break;
            }
        }
    }
}