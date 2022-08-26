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
 * @author Arnav Mehta This class creates Frozen Statue object and programs the display of the
 *         statues
 * 
 */
public class FrozenStatue {

  protected float x; // the horizontal position of this object in pixels from 0-left to 800-right
  protected float y; // the vertical position of this object in pixels from 0-top to 600-bottom
  protected boolean isFacingRight; // used to mirror image (flip left to right) only when this field
                                   // is false
  protected String imageName; // the relative path to the image file (from the working directory)

  /**
   * Constructor to initialize the variables of the class
   * 
   * @param array of the current position of the object
   * 
   */
  public FrozenStatue(float[] arr) {
    this.x = arr[0]; // Initializing the coordinates with values in the array
    this.y = arr[1];
    this.isFacingRight = true;
    this.imageName = "images" + File.separator + "frozenStatue.png";
  }

  /**
   * Calls the draw method to display the images as expected
   * 
   * @param SimulationEngine object to call the draw method on this object
   * @return void method
   */
  public void update(SimulationEngine engine) {
    engine.draw(imageName, x, y, isFacingRight); // calling the draw method to display the images
  }



}
