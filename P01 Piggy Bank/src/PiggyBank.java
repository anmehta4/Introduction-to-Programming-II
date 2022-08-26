//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P01 Piggy Bank
// Files: PiggyBank.java, PiggyBankDriver.java , PiggyBankTester.java
// Course: CS 300, Spring 2020
//
// Author: Arnav Mehta
// Email: anmehta4@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;

public class PiggyBank {
  public final static int[] COINS_VALUES = {1, 5, 10, 25}; // coins values in cents
  // coins names
  public final static String[] COINS_NAMES = {"PENNY", "NICKEL", "DIME", "QUARTER"};
  public final static String NO_SUCH_COIN = "N/A"; // N/A string
  private final static Random RAND_GEN = new Random(100); // generator of random integers

  /**
   * Returns the name of a specified coin value
   * 
   * @param coin represents a coin value in cents.
   * @return the String name of a specified coin value if it is valid and N/A if the coin value is
   *         not valid
   */
  public static String getCoinName(int coin) {

    if (coin == COINS_VALUES[0]) // checking the value of coin matches which denomination
      return COINS_NAMES[0];
    else if (coin == COINS_VALUES[1])
      return COINS_NAMES[1];
    else if (coin == COINS_VALUES[2])
      return COINS_NAMES[2];
    else if (coin == COINS_VALUES[3])
      return COINS_NAMES[3];
    else
      return NO_SUCH_COIN;

  }

  /**
   * Returns the balance of a piggy bank in cents
   * 
   * @param coins an oversize array which contains all the coins held in a piggy bank
   * @param size  the total number of coins stored in coins array
   * @return the total value of the coins held in a piggy bank in cents
   */
  public static int getBalance(int[] coins, int size) {
    int bal = 0;
    for (int i = 0; i < size; i++) {
      bal = bal + coins[i]; // adding all the values of the coins one by one to bal
    }
    return bal;
  }

  /**
   * Returns the total number of coins of a specific coin value held in a piggy bank
   *
   * @param coinValue the value of a specific coin
   * @param coins     an oversize array which contains all the coins held in a piggy bank
   * @param size      the total number of coins stored in coins array
   * @return the number of coins of value coinValue stored in the array coins
   */
  public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
    int count = 0; // variable to keep count
    for (int i = 0; i < size; i++) {
      if (coins[i] == coinValue)
        count++; // incrementing count if one more coin with same denomination is encountered
    }
    return count;
  }

  /**
   * Displays information about the content of a piggy bank
   *
   * @param coins an oversize array storing the coins held in a piggy bank
   * @param size  number of coin held array coins
   */
  public static void printPiggyBank(int[] coins, int size) {
    System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
    System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
    System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
    System.out.println("PENNIES: " + getSpecificCoinCount(1, coins, size));
    System.out.println("Balance: $" + getBalance(coins, size) * 0.01);
  }

  /**
   * Adds a given coin to a piggy bank. This operation can terminate successfully or unsuccessfully.
   * For either cases, this method displays a descriptive message for either cases.
   *
   * @param coin  the coin value in cents to be added to the array coins
   * @param coins an oversize array storing the coins held in a piggy bank
   * @param size  the total number of coins contained in the array coins before this addCoin method
   *              is called.
   * @return the new size of the coins array after trying to add coin.
   */

  public static int addCoin(int coin, int[] coins, int size) {
    if (size == coins.length) {
      System.out
          .println("Tried to add a " + coin + ", but could not because the piggy bank is full");
      return size;
    } else {
      if (coin == COINS_VALUES[0]) {
        coins[size] = coin; // adding coin to the last index of the array
        size++; // increasing the size of the array by one since one coin is added
        System.out.println("Added a " + COINS_NAMES[0] + ".");
        return size;
      } else if (coin == COINS_VALUES[1]) {
        coins[size] = coin;
        size++;
        System.out.println("Added a " + COINS_NAMES[1] + ".");
        return size;
      } else if (coin == COINS_VALUES[2]) {
        coins[size] = coin;
        size++;
        System.out.println("Added a " + COINS_NAMES[2] + ".");
        return size;
      } else if (coin == COINS_VALUES[3]) {
        coins[size] = coin;
        size++;
        System.out.println("Added a " + COINS_NAMES[3] + ".");
        return size;
      } else {
        System.out.println(coin + " cents is not a valid US currency coin.");
        return size;
      }
    }

  }

  /**
   * Removes an arbitrary coin from a piggy bank. This method may terminate successfully or
   * unsuccessfully. In either cases, a descriptive message is displayed.
   *
   * @param coins an oversize array which contains the coins held in a piggy bank
   * @param size  the number of coins held in the coins array before this method is called
   * @return the size of coins array after this method returns successfully
   */

  public static int removeCoin(int[] coins, int size) {

    if (size == 0) {
      System.out.println("Tried to remove a coin, but could not because the piggy bank is empty");
      return size;
    } else {
      int randInd = RAND_GEN.nextInt(size); // generating random index from 0 to "size"
      if (coins[randInd] == COINS_VALUES[0]) {
        System.out.println("Removed a " + COINS_NAMES[0] + ".");
      } else if (coins[randInd] == COINS_VALUES[1]) {
        System.out.println("Removed a " + COINS_NAMES[1] + ".");
      } else if (coins[randInd] == COINS_VALUES[2]) {
        System.out.println("Removed a " + COINS_NAMES[2] + ".");
      } else if (coins[randInd] == COINS_VALUES[3]) {
        System.out.println("Removed a " + COINS_NAMES[3] + ".");
      }

      for (int i = randInd; i < size - 1; i++) {
        coins[i] = coins[i + 1]; // shifting each digit to an index lower than its current index
      }
      return --size;

    }
  }

  /**
   * Removes all the coins in a piggy bank. It also displays the total value of the removed coins
   *
   * @param coins an oversize array storing the coins held in a piggy bank application
   * @param size  number of coins held in coins array before this method is called
   * @return the new size of the piggy bank after removing all its coins.
   */

  public static int emptyPiggyBank(int[] coins, int size) {
    if (size == 0) {
      System.out.println("Zero coin removed. The piggy bank is already empty");
    } else {
      int totalMon = 0;
      for (int i = 0; i < size; i++) {
        totalMon = totalMon + coins[i];
        coins[i] = 0;
      }
      System.out.println("All done. " + totalMon + " cents removed.");
      size = 0;
    }
    return size;
  }

  /**
   * Removes the least number of coins needed to fulfill a withdrawal request
   *
   * @param amount amount to withdraw given in cents
   * @param coins  an oversize array storing the coins held in a piggy bank
   * @param size   number of coins stored in coins array before this method is called
   * @return perfect size array of 5 elements, index 0 stores the new size of the piggy bank after
   *         this method returns. Indexes 1, 2, 3, and 4 store respectively the number of removed
   *         quarters, dimes, nickels, and pennies.
   */

  public static int[] withdraw(int amount, int[] coins, int size) {

    int[] arr = new int[5]; // declaring an array to be returned
    int tempAmount = amount; // storing the amount in a temporary variable for method call later
    if (getBalance(coins, size) < amount) {
      System.out.println(
          "Unable to withdraw " + amount + " cents." + " Not enough money in the piggy bank");
      arr[0] = size;
      return arr;

    } else {

      if ((getSpecificCoinCount(COINS_VALUES[3], coins, size) * COINS_VALUES[3]) >= amount) {
        arr[1] = amount / COINS_VALUES[3];
        amount = amount % COINS_VALUES[3];
      } else {
        arr[1] = getSpecificCoinCount(COINS_VALUES[3], coins, size);
        amount = amount - (COINS_VALUES[3] * getSpecificCoinCount(COINS_VALUES[3], coins, size));
      } // determines the number of quarters required and assigns it to arr[1]


      if ((getSpecificCoinCount(COINS_VALUES[2], coins, size) * COINS_VALUES[2]) >= amount) {
        arr[2] = amount / COINS_VALUES[2];
        amount = amount % COINS_VALUES[2];
      } else {
        arr[2] = getSpecificCoinCount(COINS_VALUES[2], coins, size);
        amount = amount - (COINS_VALUES[2] * getSpecificCoinCount(COINS_VALUES[2], coins, size));
      }

      if ((getSpecificCoinCount(COINS_VALUES[1], coins, size) * COINS_VALUES[1]) >= amount) {
        arr[3] = amount / COINS_VALUES[1];
        amount = amount % COINS_VALUES[1];
      } else {
        arr[3] = getSpecificCoinCount(COINS_VALUES[1], coins, size);
        amount = amount - (COINS_VALUES[1] * getSpecificCoinCount(5, coins, size));
      }

      if ((getSpecificCoinCount(COINS_VALUES[0], coins, size) * COINS_VALUES[0]) >= amount) {
        arr[4] = amount / COINS_VALUES[0];
        amount = amount % COINS_VALUES[0];
      } else {
        arr[4] = getSpecificCoinCount(COINS_VALUES[0], coins, size);
        amount = amount - (COINS_VALUES[0] * getSpecificCoinCount(1, coins, size));

      }

      /**
       * checks if the total value of the denominations determined above matches the amount to be
       * withdrawn or calls the method with an amount incremented by 1
       * 
       * if it matches then the equivalent denominations and number of coins are removed from the
       * piggy bank and made equal to 0.
       **/

      if (((arr[1] * COINS_VALUES[3]) + (arr[2] * COINS_VALUES[2]) + (arr[3] * COINS_VALUES[1])
          + (arr[4] * COINS_VALUES[0])) != tempAmount) {
        return withdraw(tempAmount + 1, coins, size);
      } else {

        for (int m = 1; m <= 4; m++) { // 4 tokens = 4 iterations
          for (int n = 0; n < arr[m]; n++) { // the number of tokens of a particular denomination
            for (int k = 0; k < size; k++) // finding them in the array and changing the value to 0;
              if (coins[k] == COINS_VALUES[4 - m]) {
                coins[k] = 0;
                break;
              }
          }
        }

        /*
         * Shifting Array
         *Shifts array to remove all non zero digits and creates the condensed array
         *eg {25,0,5,10,0,0,1} becomes {25,5,10,1,0,0,0} ad size remains 4
         *
         */
        int index = 0;
        int a = 0;
        for (a = 0; a < size;a++) { // going through all the indices of the array
          for (int b = index; b < size; b++) { // searching for non zero values and shifting
            if (coins[b] != 0) {
              coins[a] = coins[b]; // putting the value in the beginning of the array
              if (a != b) {// if not the same index-shift the number and make the current position 0
                coins[b] = 0;
              }
              index = b + 1;
              break;// after shifting number to position 'a' outer loop must go to next iteration
            }
          }
        }

          arr[0] = size - (arr[1] + arr[2] + arr[3] + arr[4]);

          for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < arr[i]; j++) {
              System.out.println("REMOVED A " + COINS_NAMES[4 - i] + " .");
            }
          }
        
          return arr;
        }
      }
    }
  }



