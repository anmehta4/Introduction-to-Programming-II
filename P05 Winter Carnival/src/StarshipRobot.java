//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 Winter Carnival
// Files: DancingBadger.java , FrozenStatue.java , StarshipRobot.java , WinterCarnival.java
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

import java.io.File;

/**
 * @author Arnav Mehta This class extends Class FrozenStatue, creates the Starship robot object and
 *         programs the motion and display of the robot
 * 
 */
public class StarshipRobot extends FrozenStatue {

  protected float[][] beginAndEnd;// array of two positions, that this robot moves back and forth
                                  // between
  // the contents of this 2d array are organized as follows: { { beginX, beginY }, { endX, endY }}
  protected float[] destination; // the position that this robot is currently moving towards
  protected float speed; // the speed in pixels that this robot moves during each update

  /**
   * Constructor to initialize the variables of the class
   * 
   * @param 2D float array of the current and final position
   */
  public StarshipRobot(float arr[][]) {
    super(arr[0]); // calling the super constructor with the initial position array
    this.beginAndEnd = arr;
    this.speed = 6;
    super.imageName = "images" + File.separator + "starshipRobot.png";
    this.destination = beginAndEnd[1];
    this.isFacingRight = true;

  }

  /**
   * Calculates and makes the object move the specified units towards the destination
   * 
   * @param No parameter
   * @return boolean value of the destination is reached or not
   */

  protected boolean moveTowardDestination() {

    float x1 = x; // creating variables to perform calculations easily (x1 and y1 are initial
                  // positions and x2 and y2 are final positions
    float x2 = destination[0];
    float y1 = y;
    float y2 = destination[1];
    float distance = (float) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); // calculating
                                                                                     // distance


    float numX = (speed * (x2 - x1)); // calculating new X
    float newX = x1 + numX / distance;
    super.x = newX;

    if (x2 > newX) {
      isFacingRight = false;
    } else {
      isFacingRight = true;
    }

    float numY = (speed * (y2 - y1)); // calculating new Y
    float newY = y1 + numY / distance;
    super.y = newY;

    if (distance < (2 * speed))
      return true;
    else
      return false;

  }

  /**
   * Updates the final destination
   * 
   * @param No parameter
   * @return void method
   */
  protected void updateDestination() {

    if (destination == beginAndEnd[0]) { // switching the beginning and destination coordiantes
                                         // every cycle
      destination = beginAndEnd[1];
    } else if (destination == beginAndEnd[1]) {
      destination = beginAndEnd[0];
    }

  }

  /**
   * Overrides the update method
   * 
   * @param SimulationEngine object
   * @return void method
   */
  @Override
  public void update(SimulationEngine engine) {
    if (moveTowardDestination()) { // moving and updating the destination accordingly
      updateDestination();
    }
    super.update(engine); // displaying the images using the super class method
  }
}
