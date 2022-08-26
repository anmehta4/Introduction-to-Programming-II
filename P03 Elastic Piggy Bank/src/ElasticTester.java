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
 * @author arnavmehta tests each method from ElasticBank
 *
 */
public class ElasticTester {

  public static boolean testCoinInstantiableClass() {
    Coin penny = new Coin("PENNY", 1); // creating a coin
    Coin quarter = new Coin("QUARTER", 25); // creating another coin
    if (!penny.getName().equals("PENNY"))
      return false;
    if (penny.getValue() != 1) // testing if the coins value is the same
      return false;
    if (!quarter.getName().equals("QUARTER"))
      return false;
    if (quarter.getValue() != 25) // testing if the coin value is the same
      return false;

    return true;
  }

  /**
   * Checks whether ElasticBank.getBalance() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBalanceAccessors() {
    ElasticBank one = new ElasticBank(5); // creating a bank
    ElasticBank two = new ElasticBank(7); // creating another bank
    one.addCoin(new Coin("PENNY", 1)); // adding a coin to one bank
    two.addCoin(new Coin("NICKEL", 5)); // adding a coin to the other bank

    if (one.getBalance() != 1) // testing the balances for both banks
      return false;
    if (two.getBalance() != 5)
      return false;

    return true;
  }

  /**
   * Checks whether ElasticBank.getCapacity() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCapacity() {
    ElasticBank one = new ElasticBank(5);// creating a bank
    ElasticBank two = new ElasticBank(7); // creating another bank
    one.addCoin(new Coin("PENNY", 1)); // adding a coin to one bank
    two.addCoin(new Coin("NICKEL", 5)); // adding 2 coins to the other bank
    two.addCoin(new Coin("NICKEL", 5));

    if (one.capacity() != 5) // testing the capacity for both the banks
      return false;
    if (two.capacity() != 7)
      return false;

    return true;

  }

  /**
   * Checks whether ElasticBank.getExpansions() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetExpansions() {

    ElasticBank one = new ElasticBank(1); // creating bank 1
    ElasticBank two = new ElasticBank(1); // creating bank 2
    ElasticBank three = new ElasticBank(2); // creating bank 3
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("PENNY", 1)); // adding a coin beyond size only once using one expansion

    if (one.getExpansions() != 1) // testing for bank 1
      return false;

    two.addCoin(new Coin("NICKEL", 1)); // adding one coin and then 11 consecutively
    for (int i = 0; i < 11; i++) {
      two.addCoin(new Coin("NICKEL", 1));
    }
    if (two.getExpansions() != 0) // testing for bank 2
    {
      System.out.println(two.getExpansions());
      return false;
    }

    three.addCoin(new Coin("PENNY", 1)); // adding only one coin
    if (three.getExpansions() != 2) // testing for bank 3
      return false;

    return true;

  }

  /**
   * Checks whether ElasticBank.getSize() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetSize() {

    ElasticBank one = new ElasticBank(5);// creating a bank
    ElasticBank two = new ElasticBank(7); // creating another bank
    one.addCoin(new Coin("PENNY", 1)); // adding a coin to one bank
    two.addCoin(new Coin("NICKEL", 5)); // adding 2 coins to the other bank
    two.addCoin(new Coin("NICKEL", 5));

    if (one.getSize() != 1) // testing for bank 1
      return false;

    if (two.getSize() != 2) // testing for bank 2
      return false;

    return true;
  }

  /**
   * Checks whether ElasticBank.getCoins() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testGetCoins() {

    ElasticBank one = new ElasticBank(5);// creating a bank
    ElasticBank two = new ElasticBank(2); // creating another bank
    one.addCoin(new Coin("PENNY", 1)); // adding a coin to one bank
    two.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("DIME", 10)); // adding 3 coins to the other bank
    two.addCoin(new Coin("NICKEL", 5));

    if (!(one.getCoins()).equals("(PENNY, 1) ")) // testing for bank 1
      return false;

    if (!two.getCoins().equals("(PENNY, 1) (DIME, 10) (NICKEL, 5) ")) // testing for bank 2
      return false;

    return true;
  }

  /**
   * Checks whether ElasticBank.removeCoin() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveCoin() {

    ElasticBank one = new ElasticBank(5);// creating a bank
    ElasticBank two = new ElasticBank(7); // creating another bank
    one.addCoin(new Coin("PENNY", 1)); // adding a coin to one bank
    two.addCoin(new Coin("NICKEL", 5)); // adding a coin to the other bank
    two.removeCoin(); // removing the only coin from bank 2

    if (one.removeCoin().getValue() != (new Coin("PENNY", 1).getValue())) // testing for bank 1
    {
      return false;
    }

    Coin c = two.removeCoin(); // removing a coin from empty bank 2
    if (!(c == null)) // checking if the returned coin is null
      return false;

    return true;
  }

  /**
   * Checks whether ElasticBank.addCoin() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testAddCoin() {
    // Creating a bank
    ElasticBank one = new ElasticBank(5);
    // Adding a coin to bank
    one.addCoin(new Coin("PENNY", 1));
    // Adding another coin to the bank
    one.addCoin(new Coin("NICKEL", 5));
    // Checks if a coin was added to bank 1
    if (!(one.getCoins()).equals("(PENNY, 1) (NICKEL, 5)")) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether ElasticBank.empty() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testEmpty() {
    // Creating a bank
    ElasticBank one = new ElasticBank(5);
    // Creating another bank
    ElasticBank two = new ElasticBank(7);
    // Adding a coin to bank 1
    one.addCoin(new Coin("PENNY", 1));
    // Adding a coin to bank 2
    two.addCoin(new Coin("NICKEL", 5));
    // Adding a coin to bank 1
    one.addCoin(new Coin("QUARTER", 25));
    // Adding a coin to bank 2
    two.addCoin(new Coin("PENNY", 1));
    // Empty bank 1
    one.empty();
    // Empty bank 2
    two.empty();
    // Checks if bank 1 is empty
    if (one.getBalance() != 0 && one.getSize() != 0) {
      return false;
    }
    // Checks if bank 2 is empty
    if (two.getBalance() != 0 && two.getSize() != 0) {
      return false;
    }
    return true;
  }


  public static void main(String args[]) {

    // calling all the test methods
    testCoinInstantiableClass();
    testBalanceAccessors();
    testCapacity();
    testGetExpansions();
    testGetSize();
    testGetCoins();
    testRemoveCoin();
  }

}
