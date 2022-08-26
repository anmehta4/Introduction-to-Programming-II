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
 * @author Arnav Mehta This class extends Class StarshipRobot , creates the Dancing badger object
 *         and programs the motions and display of the badgers
 * 
 */

public class DancingBadger extends StarshipRobot {

  protected DanceStep[] danceSteps; // array to store all the dance steps
  protected int stepIndex; // variable to keep track of all which steps are completed


  /**
   * Constructor to initialize the variables of the class
   * 
   * @param float array[] of position DanceStep[] array of danceSteps
   * 
   */

  public DancingBadger(float[] arr, DanceStep[] danceArr) {

    super(new float[][] {arr, danceArr[0].getPositionAfter(arr)}); // calling the super constructor
                                                                   // with current and next
                                                                   // positions
    this.imageName = "images" + File.separator + "dancingBadger.png";
    this.speed = 2; // initializing all the variables to their initial values
    this.isFacingRight = true;
    this.stepIndex = 1;
    this.danceSteps = danceArr;

  }

  /**
   * Overrides the updateDestination method and updates the destination based on the current dance
   * step by calling the getPositionsAfter method updates the stepIndex as well
   * 
   * @param No parameter
   * @return void method
   */
  @Override
  public void updateDestination() {
    this.destination = danceSteps[stepIndex].getPositionAfter(new float[] {x, y}); // updating the
                                                                                   // destination
                                                                                   // and
                                                                                   // incrementing
                                                                                   // step index
    ++stepIndex;
    if (stepIndex > danceSteps.length - 1) {
      stepIndex = 0;
    }
  }


}
