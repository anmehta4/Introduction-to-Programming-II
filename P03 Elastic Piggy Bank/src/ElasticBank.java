//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P03 Elastic Piggy Bank
// Files: ElasticBank.java, Coin.java , ElasticTester.java
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
// Persons: No help from anybody
// Online Sources: No online help
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;

/**
 * 
 * @author arnavmehta works like the piggybank with the exception of being able to expand twice
 *         before bursting
 *
 */
public class ElasticBank {

  private Coin[] coins; // array holding coins
  private int size; // number of coins in the array
  private int expansionsLeft; // number of expansions left
  private final static Random rand = new Random(100); // generator of random integers

  public ElasticBank() {
    size = 0;
    coins = new Coin[10]; // Initializing array coins
    expansionsLeft = 2;
  }

  public ElasticBank(int initialCapacity) {
    expansionsLeft = 2;
    size = 0;
    coins = new Coin[initialCapacity]; // Initializing array coins with initial capacity
  }

  /**
   * Returns the capacity of the coins array
   * 
   * @param no parameter
   * @return the capacity of the coins array
   */
  public int capacity() {
    return coins.length; // returning the capacity
  }

  /**
   * Returns the number of expansions left
   *
   * @param no parameter
   * @return the number of expansions left
   */
  public int getExpansions() {
    return this.expansionsLeft; // returning expansions left
  }

  /**
   * Returns the size of the coins array
   * 
   * @param no parameter
   * @return the number of coins in the array or the size of the array
   */
  public int getSize() {
    return size; // returning size
  }

  /**
   * Returns the total value of all coins in the array
   * 
   * @param no parameter
   * @return the sum total of all the coins in the array
   * 
   */
  public int getBalance() {
    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum = sum + coins[i].getValue(); // adding all the values of the coins in the array
    }
    return sum;
  }

  /**
   * Returns all the coins in the array in the string format
   * 
   * @param no parameter
   * @return the String name of a specified coin value if it is valid and N/A if the coin value is
   *         not valid
   */
  public String getCoins() {
    String coinsValues = "";
    for (int i = 0; i < size; i++) {
      coinsValues = coinsValues + "(" + coins[i].getName() + ", " + coins[i].getValue() + ") ";
    } // printing all the coins as per the format
    return coinsValues;
  }

  /**
   * Removed the coin from the array and returns the coin removed from the array
   * 
   * @param no parameter
   * @return the removed coin
   * 
   */
  public Coin removeCoin() {

    Coin removed;
    if (size == 0) { // if there are no coins then no coin is removed
      System.out.println("Tried to remove a coin, but could not because the piggy bank is empty");
      return null;
    } else {
      int randInd = rand.nextInt(size); // generating random index from 0 to "size"
      removed = new Coin(coins[randInd].getName(), coins[randInd].getValue());
      System.out.println("Removed a " + removed.getName() + ".");
      coins[randInd] = null; // making the coin at the index null
      for (int i = randInd; i < size - 1; i++) {
        coins[i] = coins[i + 1]; // shifting each digit to an index lower than its current index
      }
      coins[size] = null;// making the value null of the coins array where the last coin was
      size--;
      return removed; // returning the removed coin
    }
  }

  /**
   * Adds the coin to the array and also checks for expansions
   * 
   * @param Coin c to be added to the array
   * @return nothing is returned as its a void method
   * 
   */
  public void addCoin(Coin c) {
    if (size < coins.length) { // if space is there then coin is added
      coins[size] = c;
      size++; // incrementing size after coin is added
    } else if (size == coins.length && expansionsLeft > 0) {
      expansionsLeft = expansionsLeft - 1; // decrementing the number of expansions left
      Coin[] newCoins = new Coin[coins.length + 10];// creating a new array with the increased
                                                    // length
      for (int i = 0; i < coins.length; i++) { // copying all the values from old to the new array
        newCoins[i] = coins[i];
      }
      newCoins[coins.length] = c; // adding the new coin to be added
      coins = newCoins;
      size++; // incrementing size
    } else if (size == coins.length && expansionsLeft == 0) { // if all expansions are exhausted
      empty(); // calling empty
      coins[0] = c; // adding the new coin at the first index ( index 0 )
      size++; // incrementing size
    }
  }


  /**
   * Empties the entire array
   * 
   * @param no parameter
   * @return nothing is returned as its a void method
   * 
   */
  public void empty() {
    if (size == 0)
      System.out.println("Zero coin removed. The elastic piggy bank is already empty.");
    else {
      for (int i = 0; i < size; i++) {
        System.out.println("Removed a " + coins[i].getName() + ".");
        coins[i] = null; // making all the elements of the array null
      }
      size = 0; // making the size 0
    }
  }
}


