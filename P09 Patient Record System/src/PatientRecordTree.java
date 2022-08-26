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

/**
 * 
 * @author Arnav Mehta
 * 
 *         This class implements a binary search tree (BST) which stores a set of patient records.
 *         The left subtree contains the patient records of all the patients who are older than the
 *         patient who's PatientRecord is stored at a parent node. The right subtree contains the
 *         patient records of all the patients who are younger than the patient who's PatientRecord
 *         is stored at a parent node.
 *
 */

import java.util.NoSuchElementException;

public class PatientRecordTree {
  private PatientRecordNode root; // root of this binary search tree
  private int size; // total number of patient records stored in this tree.

  /**
   * Checks whether this binary search tree (BST) is empty
   * 
   * @return true if this PatientRecordTree is empty, false otherwise
   */
  public boolean isEmpty() {

    if (this.root == null) // if root is null there is no BST
      return true;
    else
      return false;
  }

  /**
   * Returns the number of patient records stored in this BST.
   * 
   * @return the size of this PatientRecordTree
   */
  public int size() {
    return this.size;
  }

  /**
   * Recursive helper method to add a new PatientRecord to a PatientRecordTree rooted at current.
   * 
   * @param current   The "root" of the subtree we are inserting newRecord into.
   * @param newRecord The PatientRecord to be added to a BST rooted at current.
   * @return true if the newRecord was successfully added to this PatientRecordTree, false otherwise
   */
  public static boolean addPatientRecordHelper(PatientRecord newRecord, PatientRecordNode current) {

    if (current.getPatientRecord().compareTo(newRecord) == 0) // checking is current and newRecord
                                                              // have the same birthday
      return false;

    if (newRecord.compareTo(current.getPatientRecord()) < 0) { // if newRecord is older than current
      if (current.getLeftChild() == null) { // if left node is empty
        current.setLeftChild(new PatientRecordNode(newRecord)); // add the node
        return true;
      } else {
        return addPatientRecordHelper(newRecord, current.getLeftChild());
      }
    } else if (newRecord.compareTo(current.getPatientRecord()) > 0) { // if newRecord is younger
                                                                      // than current
      if (current.getRightChild() == null) { // if right node is empty
        current.setRightChild(new PatientRecordNode(newRecord)); // add the node
        return true;
      } else {
        return addPatientRecordHelper(newRecord, current.getRightChild());
      }
    }
    return false;

  }

  /**
   * Adds a new PatientRecord to this PatientRecordTree
   * 
   * @param newRecord a new PatientRecord to add to this BST.
   * @return true if the newRecord was successfully added to this BST, and returns false if there is
   *         a match with this PatientRecord already already stored in this BST.
   */
  public boolean addPatientRecord(PatientRecord newRecord) {
    PatientRecordNode temp = new PatientRecordNode(newRecord);

    if (isEmpty()) { // Add newRecord to an empty PatientRecordTree
      this.root = temp;
      ++this.size;
      return true;
    } else { // Add newRecord to an non-empty PatientRecordTree
      if (addPatientRecordHelper(newRecord, this.root)) {
        ++this.size;
        return true;
      } else
        return false;
    }
  }

  /**
   * Recursive helper method which returns a String representation of the BST rooted at current. An
   * example of the String representation of the contents of a PatientRecordTree is provided in the
   * description of the above toString() method.
   * 
   * @param current reference to the current PatientRecordNode within this BST.
   * @return a String representation of all the PatientRecords stored in the sub-tree
   *         PatientRecordTree rooted at current in increasing order with respect to the patients
   *         dates of birth. Returns an empty String "" if current is null.
   */
  public static String toStringHelper(PatientRecordNode current) {

    if (current == null)
      return "";
    else { // implementing the in-order traversal to get the youngest to oldest patients
      return toStringHelper(current.getLeftChild()) + current.getPatientRecord().toString() + "\n"
          + toStringHelper(current.getRightChild());

    }
  }

  /**
   * Returns a String representation of all the PatientRecords stored within this BST in the
   * increasing order, separated by a newline "\n". For instance: "Sarah(1/2/1935)" + "\n" +
   * "George(5/27/1943)" + "\n" + "Adam(8/12/1972)" + "\n" + "Norah(11/23/1985)" + "\n" +
   * "William(6/4/1998)" + "\n" + "Nancy(9/12/2003)" + "\n" + "Sam(4/20/2019)" + "\n"
   * 
   * @return a String representation of all the PatientRecords stored within this BST sorted in an
   *         increasing order with respect to the dates of birth of the patients (i.e. from the
   *         oldest patient to the youngest patient). Returns an empty string "" if this BST is
   *         empty.
   */
  public String toString() {
    return toStringHelper(root); // calling the toString helper
  }



  /**
   * Search for a patient record (PatientRecord) given the date of birth as lookup key.
   * 
   * @param date a String representation of the date of birth of a patient in the format mm/dd/yyyy
   * @return the PatientRecord of the patient born on date.
   * @throws a NoSuchElementException with a descriptive error message if there is no PatientRecord
   *           found in this BST having the provided date of birth
   */
  public PatientRecord lookup(String date) {
    PatientRecord findRecord = new PatientRecord("", date);
    return this.lookupHelper(findRecord, root); // calling the lookup helper
  }

  /**
   * Recursive helper method to lookup a PatientRecord given a reference PatientRecord with the same
   * date of birth in the subtree rooted at current
   * 
   * @param findRecord a reference to a PatientRecord target we are lookup for a match in the BST
   *                   rooted at current.
   * @param current    "root" of the subtree we are looking for a match to findRecord within it.
   * @return reference to the PatientRecord stored stored in this BST which matches findRecord.
   * @throws NoSuchElementException with a descriptive error message if there is no patient record
   *                                whose date of birth matches date, stored in this BST.
   */
  private PatientRecord lookupHelper(PatientRecord findRecord, PatientRecordNode current) {

    if (current != null) {
      if (current.getPatientRecord().compareTo(findRecord) == 0) {
        return current.getPatientRecord(); // checking if the node is equal to the findRecord
      } else {
        if (findRecord.compareTo(current.getPatientRecord()) < 0) // determining which tree to
                                                                  // follow
          return lookupHelper(findRecord, current.getLeftChild()); // if newRecord is older then
                                                                   // left subtree
        else
          return lookupHelper(findRecord, current.getRightChild()); // else the right subtree
      }
    } else {
      throw new NoSuchElementException("No such Node found");
    }

  }

  /**
   * Computes and returns the height of this BST, counting the number of nodes (PatientRecordNodes)
   * from root to the deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    return heightHelper(root); // calling the height helper method
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current PatientRecordNode within a PatientRecordTree
   * @return height of the subtree rooted at current, counting the number of PatientRecordNodes
   */
  public static int heightHelper(PatientRecordNode current) {

    if (current == null)
      return 0;

    int leftHeight = heightHelper(current.getLeftChild()); // the height of the left subtree
    int rightHeight = heightHelper(current.getRightChild());// the height of the right subtree
    return 1 + Math.max(leftHeight, rightHeight); // total height as root is also included

  }


  /**
   * Returns the PatientRecord of the youngest patient in this BST.
   * 
   * @return the PatientRecord of the youngest patient in this BST and null if this tree is empty.
   */
  public PatientRecord getRecordOfYoungestPatient() {

    if (isEmpty())
      return null;
    else if (root.getRightChild() == null) // checking if root has a child or not
      return root.getPatientRecord();

    PatientRecordNode tempRight = this.root.getRightChild();
    while (tempRight.getRightChild() != null) // following the right subtree for youngest patient
      tempRight = tempRight.getRightChild();

    return tempRight.getPatientRecord();

  }

  /**
   * Returns the PatientRecord of the oldest patient in this BST.
   * 
   * @return the PatientRecord of the oldest patient in this BST, and null if this tree is empty.
   */
  public PatientRecord getRecordOfOldestPatient() {
    if (isEmpty())
      return null;
    else if (root.getLeftChild() == null) // checking if root has a left child
      return root.getPatientRecord();

    PatientRecordNode tempLeft = this.root.getLeftChild();
    while (tempLeft.getLeftChild() != null) // following the left subtree for youngest patient
      tempLeft = tempLeft.getLeftChild();

    return tempLeft.getPatientRecord();
  }

}
