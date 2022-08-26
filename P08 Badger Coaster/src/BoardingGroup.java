//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 Badger Coaster
// Files: BGNode.java , BoardingGroup.java , QueueADT.java , RideQueue.java ,ThemeParkApp.java
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
 * To create a Boarding Group for the queue and initialize its necessary details
 * 
 * @author Arnav Mehta
 *
 */

public class BoardingGroup {

  private String name; // stores the name of the BoardingGroup
  private int numberOfPeople; // stores the number of people in the group
  private boolean isVIP; // stores if the group is a VIP or not


  /**
   * Constructor to initialize the Boarding Group
   * 
   * @param String name , int numberOfPeople
   */
  public BoardingGroup(String name, int numberOfPeople) {
    this.name = name; // initializing the contents of the group
    this.numberOfPeople = numberOfPeople;
    this.isVIP = false;
  }

  /**
   * Returns the name of the BoardingGroup
   * 
   * @return String - name of the BG
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the number of people of the BoardingGroup
   * 
   * @return int - number of people of the BG
   */
  public int getNumberOfPeople() {
    return this.numberOfPeople;
  }

  /**
   * Returns true if BG is VIP else false
   * 
   * @return boolean - true if BG is VIP else false
   */
  public boolean getVIP() {
    return isVIP;
  }

  /**
   * Changes the VIP status of the BG
   * 
   * @param boolean - the desired status of the BG
   */
  public void setVIP(boolean isVIP) {
    this.isVIP = isVIP;
  }
}
