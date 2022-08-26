//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Patient Record System
// Files: PatientRecord.java , PatientRecordNode.java , PatientRecordTree.java ,
//////////////// PatientRecordTreeTester.java
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

import java.util.NoSuchElementException;

// File Header comes here

/**
 * 
 * @author Arnav Mehta This class checks the correctness of the implementation of the methods
 *         defined in the class PatientRecordTree.
 *
 */

public class PatientRecordTreeTester {

  /**
   * Checks the correctness of the implementation of both addPatientRecord() and toString() methods
   * implemented in the PatientRecordTree class. This unit test considers at least the following
   * scenarios. (1) Create a new empty PatientRecordTree, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one patient record and
   * then check that the addPatientRecord() method call returns true, the tree is not empty, its
   * size is 1, and the .toString() called on the tree returns the expected output. (3) Try adding
   * another patientRecord which is older that the one at the root, (4) Try adding a third patient
   * Record which is younger than the one at the root, (5) Try adding at least two further patient
   * records such that one must be added at the left subtree, and the other at the right subtree.
   * For all the above scenarios, and more, double check each time that size() method returns the
   * expected value, the add method call returns true, and that the .toString() method returns the
   * expected string representation of the contents of the binary search tree in an ascendant order
   * from the oldest patient to the youngest one. (6) Try adding a patient whose date of birth was
   * used as a key for a patient record already stored in the tree. Make sure that the
   * addPatientRecord() method call returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordToStringSize() {
    int count = 0;// count how many tests are true

    // test 1 - checks size for empty BST
    PatientRecordTree P = new PatientRecordTree();
    if (P.size() == 0 && P.isEmpty() == true && P.toString().equals(""))
      count++;

    // test 2
    PatientRecord patient1 = new PatientRecord("Sarah", "1/2/1935");
    if (P.addPatientRecord(patient1) == true && P.size() == 1 && P.isEmpty() == false
        && P.toString().equals("Sarah(1/2/1935)" + "\n"))
      count++;

    // test 3
    PatientRecord patient2 = new PatientRecord("George", "5/27/1943");
    if (P.addPatientRecord(patient2) == true && P.size() == 2
        && P.toString().equals("Sarah(1/2/1935)" + "\n" + "George(5/27/1943)" + "\n"))
      count++;


    // test 4
    PatientRecord patient3 = new PatientRecord("Anna", "3/18/1928");
    if (P.addPatientRecord(patient3) == true && P.size() == 3 && P.toString()
        .equals("Anna(3/18/1928)" + "\n" + "Sarah(1/2/1935)" + "\n" + "George(5/27/1943)" + "\n"))
      count++;

    // test 5
    PatientRecord patient4 = new PatientRecord("Tom", "5/14/1926");
    if (P.addPatientRecord(patient4) == true && P.size() == 4
        && P.toString().equals("Tom(5/14/1926)" + "\n" + "Anna(3/18/1928)" + "\n"
            + "Sarah(1/2/1935)" + "\n" + "George(5/27/1943)" + "\n"))
      count++;


    // test 6
    PatientRecord patient5 = new PatientRecord("Han", "7/21/1951");
    if (P.addPatientRecord(patient5) == true && P.size() == 5
        && P.toString().equals("Tom(5/14/1926)" + "\n" + "Anna(3/18/1928)" + "\n"
            + "Sarah(1/2/1935)" + "\n" + "George(5/27/1943)" + "\n" + "Han(7/21/1951)" + "\n"))
      count++;

    // test 7 - checks for addition of patient with the same Birthday as an existing patient
    if (P.addPatientRecord(patient2) == false && P.size() == 5)
      count++;

    if (count == 7) // if all tests return true
      return true;
    else
      return false;


  }

  /**
   * This method checks mainly for the correctness of the PatientRecordTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new PatientRecordTree. Then, check
   * that calling the lookup() method with any valid date must throw a NoSuchElementException. (2)
   * Consider a PatientRecordTree of height 3 which consists of at least 5 PatientRecordNodes. Then,
   * try to call lookup() method to search for the patient record at the root of the tree, then a
   * patient records at the right and left subtrees at different levels. Make sure that the lookup()
   * method returns the expected output for every method call. (3) Consider calling .lookup() method
   * on a non-empty PatientRecordTree with a date of birth not stored in the tree, and ensure that
   * the method call throws a NoSuchElementException.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordAndLookup() {

    int count = 0; // count how many tests are true

    // test 1 - find a patient with the given birth date in an empty BST
    PatientRecordTree P = new PatientRecordTree();
    try {
      P.lookup("04/25/2001");
    } catch (NoSuchElementException e) {
      if (e.getMessage().equals("No such Node found"))
        count++;
    }

    // test 2 -
    PatientRecord patient1 = new PatientRecord("Sarah", "1/2/1935");
    P.addPatientRecord(patient1);
    PatientRecord patient2 = new PatientRecord("George", "5/27/1943");
    P.addPatientRecord(patient2);
    PatientRecord patient3 = new PatientRecord("Anna", "3/18/1928");
    P.addPatientRecord(patient3);
    PatientRecord patient4 = new PatientRecord("Tom", "5/14/1926");
    P.addPatientRecord(patient4);
    PatientRecord patient5 = new PatientRecord("Han", "7/21/1951");
    P.addPatientRecord(patient5);

    if (P.lookup("1/2/1935").compareTo(patient1) == 0
        && P.lookup("5/27/1943").compareTo(patient2) == 0
        && P.lookup("5/14/1926").compareTo(patient4) == 0)
      count++;

    // test 3
    try {
      P.lookup("04/25/2001");
    } catch (Exception e) {
      if (e.getMessage().equals("No such Node found")) // checks if the exception is thrown
        count++;
    }

    if (count == 3) // if all tests return true
      return true;
    else
      return false;


  }

  /**
   * Checks for the correctness of PatientRecordTree.height() method. This test must consider
   * several scenarios such as, (1) ensures that the height of an empty patient record tree is zero.
   * (2) ensures that the height of a tree which consists of only one node is 1. (3) ensures that
   * the height of a PatientRecordTree with the following structure for instance, is 4. (*) / \ (*)
   * (*) \ / \ (*) (*) (*) / (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    int count = 0; // count how many tests are true
    // test 1 - checks if the height of an empty BST is 0
    PatientRecordTree P = new PatientRecordTree();
    if (P.height() == 0)
      count++;

    // test 2 - checks if the height of a BST with one patient is 1
    PatientRecord patient1 = new PatientRecord("Sarah", "1/2/1935");
    P.addPatientRecord(patient1);
    if (P.height() == 1)
      count++;

    PatientRecord patient2 = new PatientRecord("George", "5/27/1943");
    P.addPatientRecord(patient2);
    PatientRecord patient3 = new PatientRecord("Anna", "3/18/1928");
    P.addPatientRecord(patient3);
    PatientRecord patient4 = new PatientRecord("Tom", "5/14/1926");
    P.addPatientRecord(patient4);
    PatientRecord patient5 = new PatientRecord("Han", "7/21/1951");
    P.addPatientRecord(patient5);
    PatientRecord patient6 = new PatientRecord("Arnav", "11/12/1919");
    P.addPatientRecord(patient6);

    // test 3
    if (P.height() == 4)
      count++;

    if (count == 3) // if all tests return true
      return true;
    else
      return false;


  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfYoungestPatient() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfYoungestPatient() {

    PatientRecordTree P = new PatientRecordTree();

    PatientRecord patient1 = new PatientRecord("Sarah", "1/2/1935");
    P.addPatientRecord(patient1);
    PatientRecord patient2 = new PatientRecord("George", "5/27/1943");
    P.addPatientRecord(patient2);
    PatientRecord patient3 = new PatientRecord("Anna", "3/18/1928");
    P.addPatientRecord(patient3);
    PatientRecord patient4 = new PatientRecord("Tom", "5/14/1926");
    P.addPatientRecord(patient4);
    PatientRecord patient5 = new PatientRecord("Han", "7/21/1951");
    P.addPatientRecord(patient5);

    // test 1
    if (P.getRecordOfYoungestPatient().getName().equals("Han")) // checks if it returns youngest
                                                                // patient - Han
      return true;
    else
      return false;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfOldestPatient() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfOldestPatient() {

    PatientRecordTree P = new PatientRecordTree();

    PatientRecord patient1 = new PatientRecord("Sarah", "1/2/1935");
    P.addPatientRecord(patient1);
    PatientRecord patient2 = new PatientRecord("George", "5/27/1943");
    P.addPatientRecord(patient2);
    PatientRecord patient3 = new PatientRecord("Anna", "3/18/1928");
    P.addPatientRecord(patient3);
    PatientRecord patient4 = new PatientRecord("Tom", "5/14/1926");
    P.addPatientRecord(patient4);
    PatientRecord patient5 = new PatientRecord("Han", "7/21/1951");
    P.addPatientRecord(patient5);

    // test 1
    if (P.getRecordOfOldestPatient().getName().equals("Tom")) // checks if it returns the oldest
                                                              // patient - Tom
      return true;
    else
      return false;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {

    // calling all the test methods
    System.out.println(testAddPatientRecordToStringSize());
    System.out.println(testAddPatientRecordAndLookup());
    System.out.println(testHeight());
    System.out.println(testGetRecordOfYoungestPatient());
    System.out.println(testGetRecordOfOldestPatient());


  }

}
