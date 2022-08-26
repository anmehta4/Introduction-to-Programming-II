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
 * To implement the methods and other details of the queue and ensure it functions as desired
 * 
 * @author Arnav Mehta
 *
 */

public class RideQueue implements QueueADT<BoardingGroup> {

  private BGNode front; // the first group in the queue
  private BGNode back; // the last group in the queue
  private int capacity; // to store the capacity of the queue ( the no. of groups in the queue )
  private int numOfPeople; // to store the number of people in the queue
  private int numOfGroups; // to store the number of people in the queue


  /**
   * Constructor to initialize the queue
   * 
   * @param capacity
   */
  RideQueue(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Returns true if the queue is empty else returns false
   * 
   * @return boolean - true if queue is empty
   */
  @Override
  public boolean isEmpty() {

    if (front == null && back == null) { // if front and back are null the queue is empty
      return true;
    }

    return false;
  }

  /**
   * Returns the size of the queue ( number of groups)
   * 
   * @return int - the size of the queue
   */
  @Override
  public int size() {

    return this.numOfGroups; // returning the number of groups in the queue which is the size
  }

  /**
   * Adds the new Group to the list or displays a message if unable to do so
   * 
   * @param BoardingGroup object
   * @throws java.lang.IllegalStateException - If the newGroup cannot fit into the queue. The
   *                                         exception should have a meaningful message.
   */
  @Override
  public void enqueue(BoardingGroup newGroup) {

    if (newGroup.getNumberOfPeople() > (this.capacity - this.numOfPeople)) { 
      throw new java.lang.IllegalStateException(
          " Cannot accomodate the group due to insufficient space");
    } else {
      
      BGNode newBG = new BGNode(newGroup); // storing the newGroup in a new node

      if (this.numOfGroups == 0) { // if its the first node make front = back = newBG
        this.front = newBG;
        this.back = newBG;
      } else if (this.numOfGroups == 1 && newGroup.getVIP() == false) { // if its the second node
                                                                        // and not a VIP then add it
                                                                        // normal and change front
                                                                        // and back

        front.setNext(newBG);
        this.back = newBG;
      } else if (this.numOfGroups == 1 && newGroup.getVIP() == true) { // if its the second node and
                                                                       // VIP then add to queue and
                                                                       // change front and
                                                                       // back accordingly
        BGNode temp = front;
        front = newBG;
        front.setNext(temp);
        this.back = temp;
      } else if (newGroup.getVIP() == true) { // any other node add it to the front of the queue
        newBG.setNext(front);
        front = newBG;
      } else { // if not VIP add it to the end of the queue
        back.setNext(newBG);
        this.back = newBG;
      }

      ++this.numOfGroups; // increment the number of groups
      this.numOfPeople = this.numOfPeople + newGroup.getNumberOfPeople(); // modify no. of people
    }

  }

  /**
   * Clears the queue. Removes all groups from this queue. This queue will become empty.
   * 
   */
  @Override
  public void clear() {

    this.front = null; // making front and back if the queue null
    this.back = null;
    this.numOfPeople = 0; // making no. of people and groups 0
    this.numOfGroups = 0;

  }

  /**
   * Returns the BoardingGroup at the front of this queue without removing it.
   * 
   * @throws java.util.NoSuchElementException - If this queue is empty. The exception should have a
   *                                          meaningful message.
   * @return BoardingGroup - The Group at the front of the line.
   */
  @Override
  public BoardingGroup peek() {

    if (this.isEmpty()) { // throwing the exception if the queue is empty
      throw new java.util.NoSuchElementException("The queue is empty");
    } else { // returning the front of the queue
      return this.front.getGroup();
    }
  }

  /**
   * Returns the BoardingGroup at the front of this queue and removes it.
   * 
   * @throws java.util.NoSuchElementException - If this queue is empty. The exception should have a
   *                                          meaningful message.
   * @return BoardingGroup - The BoardingGroup that was removed from this queue.
   */
  @Override
  public BoardingGroup dequeue() {

    if (this.isEmpty() == true) { // throwing the exception if the queue is null
      throw new java.util.NoSuchElementException(
          " Cannot remove the boarding group as the queue is empty");
    } else if (front == back) { // checking if only one node is left
      BGNode temp = front;
      front = null; // making necessary changes to the queue
      back = null;
      --this.numOfGroups;
      this.numOfPeople = 0;
      return temp.getGroup();
    } else {
      --this.numOfGroups; // making necessary changes to the queue
      this.numOfPeople = this.numOfPeople - this.front.getGroup().getNumberOfPeople();
      BGNode temp = front;
      front = front.getNext();
      return temp.getGroup();
    }

  }

  /**
   * Returns a string representation of this queue.
   * 
   * @return String s- string representation of the queue
   */
  public String toString() {
    String s = "Number of People in Queue: " + numOfPeople + "\n";
    s += "Number of Groups in Queue: " + numOfGroups + "\n";
    s += "Group Names in Queue: ";
    BGNode current = front;
    while (current != null) {
      String groupName = current.getGroup().getName(); // adding each group string to the string
      s += groupName + " ";
      current = current.getNext();
    }
    return s;
  }



}
