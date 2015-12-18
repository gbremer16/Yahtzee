/**
 * Created by Geoffrey on 12/17/15.
 */
public class YahtzeeScorecard
{
    /* instance data given */
    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int threeKind;
    private int fourKind;
    private int fiveKind;
    private int chance;
    private int fullHouse;
    private int smStraight;
    private int lgStraight;
    private boolean bonus;

    /* Sets up a new game.  Sets all instance data to incomplete (-1). Sets bonus to false */
    public YahtzeeScorecard()
    {
        ones = -1;
        twos = -1;
        threes = -1;
        fours = -1;
        fives = -1;
        sixes = -1;
        threeKind = -1;
        fourKind = -1;
        fiveKind = -1;
        chance = -1;
        fullHouse = -1;
        smStraight = -1;
        lgStraight = -1;
        bonus = false;
    }

    /* 1. If the field is already full, return false
       2. Set data value ones equal to number of ones rolled multiplied by one.
       3. Update the bonus (call updateBonus())
       4. Return true   */
    public boolean markOnes(int die1, int die2, int die3, int die4, int die5)
    {
        if (ones > 0) {
            return false;
        }
        int num1 = 0;
        if (die1 == 1) {
            num1++;
        }
        if (die2 == 1) {
            num1++;
        }
        if (die3 == 1) {
            num1++;
        }
        if (die4 == 1) {
            num1++;
        }
        if (die5 == 1) {
            num1++;
        }
        num1 = ones;
        updateBonus();
        return true;
    }

    /* 1. If the field is already full, return false
       2. Set data value twos equal to number of twos rolled multiplied by two.
       3. Update the bonus (call updateBonus())
       4. Return true   */
    public boolean markTwos(int die1, int die2, int die3, int die4, int die5)
    {
        if (twos > 0) {
            return false;
        }
        int num2 = 0;
        if (die1 == 2) {
            num2++;
        }
        if (die2 == 2) {
            num2++;
        }
        if (die3 == 2) {
            num2++;
        }
        if (die4 == 2) {
            num2++;
        }
        if (die5 == 2) {
            num2++;
        }
        num2 = num2 * 2;
        num2 = twos;
        updateBonus();
        return true;
    }

    /* 1. If the field is already full, return false
       2. Set data value threes equal to number of threes rolled multiplied by three.
       3. Update the bonus (call updateBonus())
       4. Return true  */
    public boolean markThrees(int die1, int die2, int die3, int die4, int die5)
    {
        if (threes > 0) {
            return false;
        }
        int num3 = 0;
        if (die1 == 3) {
            num3++;
        }
        if (die2 == 3) {
            num3++;
        }
        if (die3 == 3) {
            num3++;
        }
        if (die4 == 3) {
            num3++;
        }
        if (die5 == 3) {
            num3++;
        }
        num3 = num3 * 3;
        num3 = threes;
        updateBonus();
        return true;
    }

    /* 1. If the field is already full, the method returns false
       2. Sets data value fours equal to number of fours rolled multiplied by four.
       3. Update the bonus (call updateBonus())
       4. Returns true   */
    public boolean markFours(int die1, int die2, int die3, int die4, int die5)
    {
        if (fours > 0) {
            return false;
        }
        int num4 = 0;
        if (die1 == 4) {
            num4++;
        }
        if (die2 == 4) {
            num4++;
        }
        if (die3 == 4) {
            num4++;
        }
        if (die4 == 4) {
            num4++;
        }
        if (die5 == 4) {
            num4++;
        }
        num4 = num4 * 4;
        num4 = fours;
        updateBonus();
        return true;
    }

    /* 1. If the field is already full, the method returns false
       2. Sets data value fives equal to number of fives rolled multiplied by five.
       3. Update the bonus (call updateBonus())
       4. Returns true   */
    public boolean markFives(int die1, int die2, int die3, int die4, int die5)
    {
        if (fives > 0) {
            return false;
        }
        int num5 = 0;
        if (die1 == 5) {
            num5++;
        }
        if (die2 == 5) {
            num5++;
        }
        if (die3 == 5) {
            num5++;
        }
        if (die4 == 5) {
            num5++;
        }
        if (die5 == 5) {
            num5++;
        }
        num5 = num5 * 5;
        num5 = fives;
        updateBonus();
        return true;
    }

    /* 1. If the field is already full, the method returns false
       2. Sets data value sixes equal to number of sixes rolled multiplied by six.
       3. Update the bonus (call updateBonus())
       4. Returns true */
    public boolean markSixes(int die1, int die2, int die3, int die4, int die5)
    {
        if (sixes > 0) {
            return false;
        }
        int num6 = 0;
        if (die1 == 6) {
            num6++;
        }
        if (die2 == 6) {
            num6++;
        }
        if (die3 == 6) {
            num6++;
        }
        if (die4 == 6) {
            num6++;
        }
        if (die5 == 6) {
            num6++;
        }
        num6 = num6 * 6;
        num6 = sixes;
        updateBonus();
        return true;
    }

    /* 	1. If the field is already full, return false
        2. Check to see if there are actually three of the same value.
           If there are, set the data value threeKind to the value of all five dice.
           If there aren?t set the value to 0.
              (Hint: use YahtzeeSortDice class!)
           4. Return true   */
    public boolean markThreeOfAKind(int die1, int die2, int die3, int die4, int die5)
    {
        YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
        int first = s.getFirst();
        int second = s.getSecond();
        int third  =s.getThird();
        int fourth = s.getFourth();
        int fifth = s.getFifth();
        if((threeKind == -1) && ((first == second && first == third) || (second == third && second == fourth) || (third == fourth && third == fifth))){
            threeKind = die1 + die2 + die3 + die4 + die5;
            return true;
        } else if(threeKind == -1){
            threeKind = 0;
            return true;
        } else {
            return false;
        }
    }

    /* 	1. If the field is already full, return false
        2. Check to see if there are actually four of the same value.
           If there are, set the data value fourKind to the value of all five dice.
           If there aren?t set the value to 0;
           (Hint: use YahtzeeSortDice class!)
        4. Return true  */
    public boolean markFourOfAKind(int die1, int die2, int die3, int die4, int die5)
    {
        YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
        int first = s.getFirst();
        int second = s.getSecond();
        int third  =s.getThird();
        int fourth = s.getFourth();
        int fifth = s.getFifth();
        if ((fourKind == -1) && ((first == second && first == third && first == fourth) || (second == third && second == fourth && second == fifth))){
            fourKind = die1 + die2 + die3 + die4 + die5;
            return true;
        } else if (fourKind == -1){
            fourKind = 0;
            return true;
        } else {
            return false;
        }
    }


    /* 1. If the field is already full, return false
       2. Check to see if there are actually three die with the same value, and two with another value.
          If there are, set the data value fullHouse to 25.
          If there aren?t set the value to 0.
          (Hint: Use YahtzeeSortedDice class!)
       3. Return true   */
    public boolean markFullHouse(int die1, int die2, int die3, int die4, int die5)
    {
        YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
        int first = s.getFirst();
        int second = s.getSecond();
        int third = s.getThird();
        int four = s.getFourth();
        int five = s.getFifth();
        if(fullHouse == -1){
            if((first == second && first == third && four == five) || (first == second && third == fours && third == fives)){
                fullHouse = 25;
                return true;
            } else {
                fullHouse = 0;
                return true;
            }
        } else {
            return false;
        }
    }


    /* 	1. If the field is already full, return false
        2. Check to see if there are actually four consecutive dice numbers.
           If there are, set the data value smStraight to 30.
           If there aren?t set the value to 0.
           (Hint: Use YahtzeeSortedDice class)
        4. Return true  */
    public boolean markSmallStraight(int die1, int die2, int die3, int die4, int die5)
    {
        YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
        int first = s.getFirst();
        int second = s.getSecond();
        int third = s.getThird();
        int fourth = s.getFourth();
        int fifth = s.getFifth();
        if(smStraight != -1){
            if((first == 1 && second == 2 && third == 3 && fourth == 4) || (second == 3 && third == 4  && fourth == 5 && fifth == 6) || (first == 2 && second == 3 && third == 4 && fourth == 5)){
                smStraight = 30;
                return true;
            } else {
                smStraight = 0;
                return true;
            }
        } else {
            return false;
        }
    }

    /* 	1. If the field is already full, return false
        2. Check to see if there are actually five consecutive dice numbers.
           If there are, set the data value lgStraight to 40.
           If there aren?t set the value to 0;
           (Hint: use YahtzeeSortDice class!)
        3. Return true  */
    public boolean markLargeStraight(int die1, int die2, int die3, int die4, int die5)
    {
        YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
        int first = s.getFirst();
        int second = s.getSecond();
        int third = s.getThird();
        int fourth = s.getFourth();
        int fifth = s.getFifth();
        if(((lgStraight == -1) && (first == 1) && (second == 2) && (third == 3 )&& (fourth == 4) && (fifth == 5)) || ((lgStraight != -1) && (first == 2) && (second == 3) && (third == 4) && (fourth == 5) && (fifth == 6))){
            lgStraight = 40;
            return true;
        } else if(lgStraight == -1){
            lgStraight = 0;
            return true;
        } else {
            return false;
        }
    }

    /* 1. If the field is already full, return false
       2. Checks to see if there are actually five of the same value.  If there are, set the data value fiveKind to 50.  If there aren?t set the value to 0;
       3. Return true   */
    public boolean markYahtzee(int die1, int die2, int die3, int die4, int die5)
    {
        if(fiveKind != -1){
            return false;
        }else if(die1 == die2 && die1 == die3 && die1 == die4 && die1 == die5){
            fiveKind = 50;
            return true;
        } else {
            fiveKind = 0;
            return true;
        }
    }

    /* 1. If the field is already full, return false
       2. Set the data value chance to the value of all five dice.
       3. Return true  */
    public boolean markChance(int die1, int die2, int die3, int die4, int die5)
    {
        if(chance != -1){
            return false;
        }
        else {
            chance = die1 + die2 + die3 + die4 + die5;
            return true;
        }
    }

    /* 	1. If the bonus has already been assigned, do nothing
        2. If the upper section?s total is 63 or greater, set the data value bonus to true */
    private void updateBonus()
    {
        if(bonus == false){
            int i = 0;
            if(ones != -1){
                i += ones;
            }if(twos != -1){
                i += twos;
            }if(threes != -1){
                i += threes;
            }if(fours != -1){
                i += fours;
            }if(fives != -1){
                i += fives;
            }if(sixes != -1){
                i += sixes;
            }
            if(i >= 63){
                bonus = true;
            }
        }
    }

    /* 	returns the upper total, remember incompletes (-1s) should not be factored in! */
    public int getUpperTotal()
    {
        int total = 0;
        if (ones > 0) {
            total += ones;
        }
        if (twos > 0) {
            total += twos;
        }
        if (threes > 0) {
            total += threes;
        }
        if (fours > 0) {
            total += fours;
        }
        if (fives > 0) {
            total += fives;
        }
        if (sixes > 0) {
            total += sixes;
        }
        return total;
    }

    /* 	returns the lower total, remember incompletes (-1s) should not be factored in! */
    public int getLowerTotal()
    {
        int i = 0;
        if(threeKind != -1){
            i += threeKind;
        }if(fourKind != -1){
        i += fourKind;
    }if(fiveKind != -1){
        i += fiveKind;
    }if(chance != -1){
        i += chance;
    }if(fullHouse != -1){
        i += fullHouse;
    }if(smStraight != -1){
        i += smStraight;
    }if(lgStraight != -1){
        i += lgStraight;
    }
        return i;
    }

    /* 	returns the grand total, remember incompletes (-1s) should not be factored in! */
    public int getGrandTotal()
    {
        int i = 0;
        if(ones != -1){
            i += ones;
        }if(twos != -1){
        i += twos;
    }if(threes != -1){
        i += threes;
    }if(fours != -1){
        i += fours;
    }if(fives != -1){
        i += fives;
    }if(sixes != -1){
        i += sixes;
    }if(threeKind != -1){
        i += threeKind;
    }if(fourKind != -1){
        i += fourKind;
    }if(fiveKind != -1){
        i += fiveKind;
    }if(chance != -1){
        i += chance;
    }if(fullHouse != -1){
        i += fullHouse;
    }if(smStraight != -1){
        i += smStraight;
    }if(lgStraight != -1){
        i += lgStraight;
    }
        return i;
    }

    /*	Prints a scorecard with the current total, using "__" to mark uncompleted fields and a number to mark filled fields
        Sample:
        **********************************
        *  	    Yahtzee Score Card		 *
        *  					`		  	 *
        * 	Ones:				__		 *
        * 	Twos:				__		 *
        * 	Threes:				__		 *
        * 	Fours:				__		 *
        * 	Fives:				25		 *
        * 	Sixes:				__		 *
        *								 *
        *	Upper Bonus:		 0		 *
        * 	Upper Total:   		25		 *
        *								 *
        *	3 of Kind:			__		 *
        * 	4 of Kind:			__		 *
        * 	Full House:			25		 *
        * 	Sm Straight:		__		 *
        * 	Lg  Straight:		__		 *
        * 	Yahtzee:	  		 0		 *
        * 	Chance:				__		 *
        *								 *
        * 	Lower Total:		25		 *
        *								 *
        * 	Grand Total:		50		 *
        **********************************
        already implemented
    */
    public void printScoreCard()
    {
        System.out.println();
        System.out.println("*********************************");
        System.out.println("*      Yahtzee Score Card       *");
        System.out.println("*                               *");
        System.out.print("*  Ones:\t\t");
        if(ones==-1)System.out.print("__");
        else System.out.print(ones);
        System.out.println("\t*");
        System.out.print("*  Twos:\t\t");
        if(twos==-1)System.out.print("__");
        else System.out.print(twos);
        System.out.println("\t*");
        System.out.print("*  Threes:\t\t");
        if(threes==-1)System.out.print("__");
        else System.out.print(threes);
        System.out.println("\t*");
        System.out.print("*  Fours:\t\t");
        if(fours==-1)System.out.print("__");
        else System.out.print(fours);
        System.out.println("\t*");
        System.out.print("*  Fives:\t\t");
        if(fives==-1)System.out.print("__");
        else System.out.print(fives);
        System.out.println("\t*");
        System.out.print("*  Sixes:\t\t");
        if(sixes==-1)System.out.print("__");
        else System.out.print(sixes);
        System.out.println("\t*");
        System.out.println("*\t\t\t\t*");
        System.out.print("*  Upper Bonus:\t\t");
        if(bonus)System.out.print("35");
        else System.out.print("0");
        System.out.println("\t*");
        System.out.print("*  Upper Total:\t\t");
        System.out.print(this.getUpperTotal());
        System.out.println("\t*");
        System.out.println("*                               *");
        System.out.print("*  3 of Kind:\t\t");
        if(threeKind==-1)System.out.print("__");
        else System.out.print(threeKind);
        System.out.println("\t*");
        System.out.print("*  4 of Kind:\t\t");
        if(fourKind==-1)System.out.print("__");
        else System.out.print(fourKind);
        System.out.println("\t*");
        System.out.print("*  Full House:\t\t");
        if(fullHouse==-1)System.out.print("__");
        else System.out.print(fullHouse);
        System.out.println("\t*");
        System.out.print("*  Sm Straight:\t\t");
        if(smStraight==-1)System.out.print("__");
        else System.out.print(smStraight);
        System.out.println("\t*");
        System.out.print("*  Lg Straight:\t\t");
        if(lgStraight==-1)System.out.print("__");
        else System.out.print(lgStraight);
        System.out.println("\t*");
        System.out.print("*  Yahtzee:\t\t");
        if(fiveKind==-1)System.out.print("__");
        else System.out.print(fiveKind);
        System.out.println("\t*");
        System.out.print("*  Chance:\t\t");
        if(chance==-1)System.out.print("__");
        else System.out.print(chance);
        System.out.println("\t*");
        System.out.println("*                               *");
        System.out.print("*  Lower Total:\t\t");
        System.out.print(this.getLowerTotal());
        System.out.println("\t*");
        System.out.println("*                               *");
        System.out.print("*  Grand Total:\t\t");
        System.out.print(this.getGrandTotal());
        System.out.println("\t*");
        System.out.println("**********************************");
        System.out.println();
    }


}