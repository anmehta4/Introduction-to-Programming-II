
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 File Finder
// Files: ShallowFileIterator.java DeepFileIterator.java FilteredFileIterator.java P07Tester.java
// Course: Comp Sci 300, Spring, 2020
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
import java.io.FileNotFoundException;

/**
 * This class tests the functionality of ShallowFileIterator.java ,
 * DeepFileIterator.java and FilteredFileIterator.java
 * 
 * @author arnavmehta
 *
 */
public class P07Tester {

	/**
	 * This method checks whether the shallowFileIterator
	 * 
	 * @param obj
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testShallowFileIterator(File obj) {
		try {
			ShallowFileIterator shallow = new ShallowFileIterator(obj); // assigns new FilteredFileIterator object with
																		// required parameters
			String result = "";
			while (shallow.hasNext()) {
				result = result + ((shallow.next()).getName()) + ", ";
			}
			String expectedResults = "assignments, exam preparation, lecture notes, " + "reading notes, todo.txt, ";
			if (expectedResults.equals(result)) { // checks if result and expected are the same
				return true;
			} else {
				return false;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	/**
	 * This method checks whether the deepFileIterator
	 * 
	 * @param folder
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testDeepFileIterator(File folder) {
		folder = new File(folder.getPath() + File.separator + "assignments");
		try {
			DeepFileIterator deep = new DeepFileIterator(folder); // assigns new FilteredFileIterator object with
																	// required parameters.
			String result = "";
			while (deep.hasNext()) {
				result = result + deep.next().getName() + ", ";
			}
			String expectedResults = "P01, PiggyBank.java, P02, CalendarPrinter.java, P03, "
					+ "ElasticBank.java, P04, ExceptionalPiggyBank.java, P05, ExtendedVersion, "
					+ "WinterCarnival.java, WinterCarnival.java, P06, AlphabetTrain.java, ";
			if (expectedResults.equals(result)) { // checks if result and expected are the same
				return true;
			} else {
				return false;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	/**
	 * This method checks whether the filteredFileIterator
	 * 
	 * @param folder
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testFilteredFileIterator(File folder) {
		try {
			FilteredFileIterator filter = new FilteredFileIterator(folder, ".java"); // assigns new FilteredFileIterator
																						// object with required
																						// parameters.
			String result = "";
			while (filter.hasNext()) {
				result = result + filter.next().getName() + ", ";
			}
			String expectedResults = "PiggyBank.java, CalendarPrinter.java, ElasticBank.java, "
					+ "ExceptionalPiggyBank.java, WinterCarnival.java, WinterCarnival.java, "
					+ "AlphabetTrain.java, codeSamples.java, ";
			if (expectedResults.equals(result)) { // checks if result and expected are the same
				return true;
			} else {
				return false;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File found1 = new File("filesystem");
		System.out.println(testShallowFileIterator(found1));
		System.out.println(testDeepFileIterator(found1));
		System.out.println(testFilteredFileIterator(found1));

	}

}
