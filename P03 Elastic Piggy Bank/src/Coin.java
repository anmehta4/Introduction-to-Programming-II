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

/**
 * 
 * @author arnav creates a coin object wuth accessor methods
 *
 */
public class Coin {

  private String name;
  private int value;

  /**
   * Initializes the coin with the given values
   * 
   * @param String - Name of the coin , int Value of the coin
   * @return void method
   * 
   */
  public Coin(String name, int value) {
    this.name = name;
    this.value = value;
  }

  /**
   * Returns the name of the coin
   * 
   * @param no parameter
   * @return String name of the coin
   * 
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the value of the coin
   * 
   * @param no parameter
   * @return int value of the coin
   * 
   */
  public int getValue() {
    return value;
  }
}
