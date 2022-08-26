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
import java.util.ArrayList;

/**
 * @author Arnav Mehta This class extends Class SimulationEngine from P05.jar file and initializes
 *         all the objects on which the methods are called
 * 
 */
public class WinterCarnival extends SimulationEngine {

  private ArrayList<FrozenStatue> objects;

  /**
   * Constructor to initialize the variables of the class and add all objects to the array list
   * 
   * @param no parameter
   */
  public WinterCarnival() {
    objects = new ArrayList<FrozenStatue>(2);
    objects.add(new FrozenStatue(new float[] {600, 100})); // creating and adding the respective
                                                           // objects to the array list
    objects.add(new FrozenStatue(new float[] {200, 500}));
    objects.add(new StarshipRobot(new float[][] {{0, 0}, {600, 100}}));
    objects.add(new StarshipRobot(new float[][] {{800, 300}, {200, 500}}));
    DanceStep left = DanceStep.Left;
    DanceStep right = DanceStep.Right;
    DanceStep up = DanceStep.Up;
    DanceStep down = DanceStep.Down;
    DanceStep danceArr[] =
        new DanceStep[] {left, right, right, left, down, left, right, right, left, up};
    objects.add(new DancingBadger(new float[] {304, 268}, danceArr));
    objects.add(new DancingBadger(new float[] {368, 268}, danceArr));
    objects.add(new DancingBadger(new float[] {432, 268}, danceArr));
    objects.add(new DancingBadger(new float[] {496, 268}, danceArr));

  }


  public static void main(String[] args) {
    WinterCarnival WC = new WinterCarnival(); // creating a winter carnival object

  }

  /**
   * overrides the update method and calls update individually on each object in the array list
   * 
   * @param No parameter
   * @return void method
   */

  @Override
  public void update() {

    for (int i = 0; i < objects.size(); i++)
      objects.get(i).update(this); // calling the update method on all objects in the array list

  }

}
