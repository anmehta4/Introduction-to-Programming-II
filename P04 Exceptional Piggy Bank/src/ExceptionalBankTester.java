//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Exceptional Bank
// Files: ExceptionalBank.java, Coin.java, ExceptionalTester.java
// Course: CS 300, Spring 2020
//
// Author: Arnav Mehta
// Email: anmehta4@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: N/A
// Partner Email: N/A
// Partner Lecturer's Name: N/A
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __ Write-up states that pair programming is allowed for this assignment.
// __ We have both read and understood the course Pair Programming Policy.
// __ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
/**
 * 
 * @author arnavmehta tests each method from ExceptionalBank
 *
 */
import java.io.File;
import java.util.zip.DataFormatException;

public class ExceptionalBankTester {

  /**
   * This method checks whether the ExceptionalBank constructor throws an IllegalArgumentException
   * with appropriate error message, when it is passed a zero or a negative capacity. This test must
   * fail if another kind of exception is thrown for such test scenario.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testExceptionalBankConstructor() {
    try {
      // create an exceptional bank with a negative capacity
      ExceptionalBank bank = new ExceptionalBank(-10);
      System.out
          .println("Problem detected. The constructor call of the ExceptionalBank class did not "
              + "throw an IllegalArgumentException when it is passed a negative capacity.");
      return false; // return false if no exception has been thrown
    } catch (IllegalArgumentException e1) {
      // check that the caught IllegalArgumentException includes
      // an appropriate error message
      if (e1.getMessage() == null // your test method should not throw
          // a NullPointerException,but must return false if e1.getMessage is null
          || !e1.getMessage().toLowerCase().contains("must be a non-zero positive integer")) {
        System.out
            .println("Problem detected. The IllegalArgumentException thrown by the constructor "
                + "call of the ExceptionalBank class when it is passed a negative capacity "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "constructor of the ExceptionalBank class with a negative argument. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true; // test passed
  }


  /**
   * This method checks whether the ExceptionalBank constructor doesn't throws an Exception when it
   * is passed a positive or a valid capacity. This test must fail if any kind of exception is
   * thrown for such test scenario.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGoodExceptionalBankConstructor() {
    try {
      ExceptionalBank bank = new ExceptionalBank(20);
      if (bank.capacity() == 20) {
        return true;
      }
    } catch (Exception e) {
      // any exception has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "constructor of the ExceptionalBank class with a positive argument. "
              + "No exception was expected to be thrown. " + "But, it was NOT the case.");
      e.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true;
  }

  /**
   * This method checks whether the testAddCoin() method throws an IllegalArgumentException with
   * appropriate error message, when it is passed a null reference. This test must fail if another
   * kind of exception is thrown for such test scenario.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoin() {
    try {
      ExceptionalBank bank = new ExceptionalBank(10);
      bank.addCoin(null);
      System.out
          .println("Problem detected. The addCoin() method of the ExceptionalBank class did not "
              + "throw an IllegalArgumentException when it is passed a null coin.");
      return false; // return false if no exception has been thrown
    } catch (IllegalArgumentException e1) {
      // check that the caught IllegalArgumentException includes
      // an appropriate error message
      if (e1.getMessage() == null // your test method should not throw
          // a NullPointerException,but must return false if e1.getMessage is null
          || !e1.getMessage().toLowerCase().contains("cannot add a null reference to this bank")) {
        System.out.println(
            "Problem detected. The IllegalArgumentException thrown by the method addCoin() "
                + "of the ExceptionalBank class when it is passed a null coin "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method addCoin() of the ExceptionalBank class when it is passed a null coin  "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // testAddCoin() method code.
      return false;
    }
    return true;
  }


  /**
   * This method checks whether the testRemoveCoinEmptyBank() method throws a NoSuchElementException
   * with an appropriate error message, when it is called on an empty bank. This test must fail if
   * another kind of exception is thrown for such test scenario.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveCoinEmptyBank() {
    try {
      ExceptionalBank bank = new ExceptionalBank(10);
      bank.removeCoin();
      System.out
          .println("Problem detected. The removeCoin() method of the ExceptionalBank class did not "
              + "throw an NoSuchElementException when it is passed on an empty bank");
      return false; // return false if no exception has been thrown
    } catch (java.util.NoSuchElementException e1) {
      // check that the caught NoSuchElementException includes
      // an appropriate error message
      if (e1.getMessage() == null // your test method should not throw
          // a NullPointerException,but must return false if e1.getMessage is null
          || !e1.getMessage().toLowerCase().contains("unable to remove a coin")) {
        System.out.println(
            "Problem detected. The NoSuchElementException thrown by the method removeCoin() "
                + "of the ExceptionalBank class when it is passed on an empty bank "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than NoSuchElementException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method removeCoin() of the ExceptionalBank class when it is on an empty bank  "
              + "An NoSuchElementException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // testRemoveCoinEmptyBank() method code.
      return false;
    }
    return true;
  }


  /**
   * This method checks whether the addCoins() method throws an IllegalArgumentException with
   * appropriate error message, when it is passed a null reference. This test must fail if another
   * kind of exception is thrown for such test scenario.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoinsIllegalArgument() {
    try {
      ExceptionalBank bank = new ExceptionalBank(10);
      bank.addCoins​(null);
      System.out
          .println("Problem detected. The addCoins() method of the ExceptionalBank class did not "
              + "throw an IllegalArgument when it is passed on null reference.");
      return false; // return false if no exception has been thrown
    } catch (IllegalArgumentException e1) {
      // check that the caught NoSuchElementException includes
      // an appropriate error message
      if (e1.getMessage() == null // your test method should not throw
          // a NullPointerException,but must return false if e1.getMessage is null
          || !e1.getMessage().toLowerCase().contains("does not accept a null reference")) {
        System.out.println(
            "Problem detected. The IllegalArgumentException thrown by the method removeCoin() "
                + "of the ExceptionalBank class when it is passed on an empty bank "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method removeCoin() of the ExceptionalBank class when it is passed on an empty bank "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true;

  }

  /**
   * This method checks whether the addCoins() method throws an DataFormatException with appropriate
   * error message, when it is passed a null reference. This test must fail if another kind of
   * exception is thrown for such test scenario.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoinsInvalidDataFormat() {
    try {
      ExceptionalBank bank = new ExceptionalBank(10);
      bank.addCoins​("quarter: five");
      System.out
          .println("Problem detected. The addCoins() method of the ExceptionalBank class did not "
              + "throw an DataFormatException when it is passed on an incorrectly formatted string.");
      return false; // return false if no exception has been thrown
    } catch (DataFormatException e1) {
      // check that the caught NoSuchElementException includes
      // an appropriate error message
      if (e1.getMessage() == null // your test method should not throw
          // a NullPointerException,but must return false if e1.getMessage is null
          || !e1.getMessage().toLowerCase().contains(" format of the command line")) {
        System.out
            .println("Problem detected. The DataFormatException thrown by the method addCoins() "
                + "of the ExceptionalBank class when it is passed on an incorrectly formatted string "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method addCoins() of the ExceptionalBank class when it is passed on an incorrectly formatted string. "
              + "An DataFormatException was expected to be thrown. " + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true;

  }

  /**
   * This method checks whether the addCoins() method throws an NoSuchElementException with
   * appropriate error message, when it is passed a null reference. This test must fail if another
   * kind of exception is thrown for such test scenario.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoinsNoSuchElement() {
    try {
      ExceptionalBank bank = new ExceptionalBank(10);
      bank.addCoins​("quarte: 5");
      System.out
          .println("Problem detected. The addCoins() method of the ExceptionalBank class did not "
              + "throw an NoSuchElementException when it is passed on an invalid denomination.");
      return false; // return false if no exception has been thrown
    } catch (java.util.NoSuchElementException e1) {
      // check that the caught NoSuchElementException includes
      // an appropriate error message
      if (e1.getMessage() == null // your test method should not throw
          // a NoSuchElementException,but must return false if e1.getMessage is null
          || !e1.getMessage().toLowerCase().contains("invalid")) {
        System.out
            .println("Problem detected. The NoSuchElementException thrown by the method addCoins() "
                + "of the ExceptionalBank class when it is passed on an invalid denomination. "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than NoSuchElementException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method addCoins() of the ExceptionalBank class when it is passed on an invalid denomination. "
              + "An NoSuchElementException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true;

  }

  /**
   * This method checks whether the addCoins() method works appropriately when it is passed a String
   * with a valid format.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoinsValidFormat() {
    ExceptionalBank bank = new ExceptionalBank(10);
    try {
      bank.addCoins​("quarter: 5");
    } catch (DataFormatException e) {
      System.out.println("The method addCoins() is not working with a valid format");
      e.printStackTrace();
      String test = bank.getSummary();
      if (!test.equalsIgnoreCase("QUARTER: 5")) {
        return false;
      }
    }

    return true;

  }

  /**
   * This method checks whether the loadCoins() loads appropriately without throwing any exception
   * when it is passed a found file.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLoadCoinsFileFound() {
    ExceptionalBank bank = new ExceptionalBank(10);
    try {
      File file = new File("sample3.txt");
      bank.loadCoins​(file);
    } catch (java.io.FileNotFoundException e1) {
      System.out.println("Problem detected. FileNotFoundException has been thrown when calling the "
          + "method loadCoins() of the ExceptionalBank class when a file does exist.");
      return false;
    } catch (Exception e2) {
      // an exception other than NoSuchElementException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method loadCoins() of the ExceptionalBank class when a file does exist."
              + "No exception was expected to be thrown. " + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true;

  }

  /**
   * This method checks whether the loadCoins() method throws a FileNotFoundException when it is
   * passed a non found file.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLoadCoinsFileNotFound() {
    try {
      ExceptionalBank bank = new ExceptionalBank(10);
      File found = new File("text.txt");
      bank.loadCoins​(found);
    } catch (java.io.FileNotFoundException e1) {
      // check that the caught NoSuchElementException
      return true;
    } catch (Exception e2) {
      // an exception other than NoSuchElementException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method loadCoins() of the ExceptionalBank class when it is passed on an invalid file. "
              + "An FileNotFoundException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true;

  }

  /**
   * This method checks whether the loadCoins() method throws a NullPointerException when it is
   * passed a null reference.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLoadCoinsNullReference() {
    try {
      ExceptionalBank bank = new ExceptionalBank(10);
      bank.loadCoins​(null);
      System.out
          .println("Problem detected. The loadCoins() method of the ExceptionalBank class did not "
              + "throw an NullPointerException when it is passed on a null reference.");
      return false; // return false if no exception has been thrown
    } catch (java.io.FileNotFoundException e1) {
      // check that the caught NoSuchElementException includes
      // an appropriate error message
      if (e1.getMessage() == null) {
        System.out.println(
            "Problem detected. The FileNotFoundException was thrown by the method loadCoins() "
                + "of the ExceptionalBank class when it is passed on a null reference.");
        return false;
      }
    } catch (NullPointerException e2) {

      return true;
    } catch (Exception e3) {
      // an exception other than NoSuchElementException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method addCoins() of the ExceptionalBank class when it is passed on an invalid denomination. "
              + "An NoSuchElementException was expected to be thrown. "
              + "But, it was NOT the case.");
      e3.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true;

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(testExceptionalBankConstructor());
    System.out.println(testAddCoin());
    System.out.println(testRemoveCoinEmptyBank());
    System.out.println(testAddCoinsIllegalArgument());
    System.out.println(testAddCoinsInvalidDataFormat());
    System.out.println(testAddCoinsNoSuchElement());
    System.out.println(testAddCoinsValidFormat());
    System.out.println(testLoadCoinsNullReference());
    System.out.println(testLoadCoinsFileNotFound());
    System.out.println(testLoadCoinsFileFound());
    System.out.println(testGoodExceptionalBankConstructor());


  }

}
