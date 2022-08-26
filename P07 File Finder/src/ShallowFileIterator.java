
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
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This class allows one to iterate through a provided directory
 * 
 * @author arnavmehta
 *
 */
public class ShallowFileIterator implements java.util.Iterator<File> {

	private File folderContents[]; // sorted array of File references which this iterator steps through
	private int nextIndex; // – the int index specifying the next File within folderContents that this
							// iterator’s next(method will return

	/**
	 * Add files to an array which is then stepped through to retrieve contained
	 * directories
	 * 
	 * @param obj the folder that contains other files and folders
	 * @throws FileNotFoundException
	 */
	public ShallowFileIterator(java.io.File obj) throws FileNotFoundException {
		nextIndex = 0;
		if (!obj.exists()) // checking if the file exists
			throw new FileNotFoundException("The file does not exist in the directory");
		else {

			folderContents = obj.listFiles(); // stores the contents of the directory
			Arrays.sort(folderContents);

		}
	}

	/**
	 * Checks if the iterator is at the end of the array
	 * 
	 * @return true if the iteration has more elements and false otherwise
	 */
	@Override
	public boolean hasNext() {
		if (nextIndex < folderContents.length) { // ensuring nextIndex is within the boundaries of folderContents
			if (folderContents[nextIndex] == null) { // checking if its the last file in the directory
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * Steps through the main folder and returns all elements
	 * 
	 * @return the next element in the iteration.
	 */
	@Override
	public File next() {
		if (hasNext()) { // iterates as long as there is a next file
			++nextIndex;
			return folderContents[nextIndex - 1];
		} else {
			throw new NoSuchElementException("This directory no longer has remaining files.");
		}
	}

}
