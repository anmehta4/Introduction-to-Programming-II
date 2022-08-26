
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
 *
 * This class iterates through the contents of a specified directory and will
 * also iterate through the contents of any directories contained within that
 * directory (no matter how deeply nested those contained folders might be).
 *
 * @author arnavmehta
 *
 */
public class DeepFileIterator implements java.util.Iterator<File> {

	private File folderContents[];// sorted array of File references which this iterator steps through
	private int nextIndex; // – the int index specifying the next File within folderContents that this
							// iterator’s next()method will return
	private DeepFileIterator contentsIterator; // a DeepFileIterator reference that is used to step through the contents
												// within any directory that is contained within this folder

	/**
	 * Adds all files of the folder in array which the iterator then steps through
	 * 
	 * @param obj the object that holds the folder
	 * @throws FileNotFoundException if the given file is not found
	 */
	public DeepFileIterator(java.io.File obj) throws FileNotFoundException {
		if (!obj.exists()) // checking if the file exists
			throw new FileNotFoundException("The file does not exist in the directory");
		else {
			nextIndex = 0;
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

		if (contentsIterator != null) { // checks if contentsIterator is not null
			if (contentsIterator.hasNext()) { // checks if contentsIterator has a next
				return true;
			} else if (nextIndex < folderContents.length) { // ensuring nextIndex is within the boundaries of
															// folderContents
				return true;
			} else
				return false;
		} else {
			if (nextIndex < folderContents.length) { // ensuring nextIndex is within the boundaries of folderContents
				return true;
			} else
				return false;
		}
	}

	/**
	 * Looks for directories and steps inside them should they be directories
	 * 
	 * @return the next element in the iteration.
	 * @throws NoSuchElementException
	 */
	@Override
	public File next() {
		if (hasNext()) {
			try {

				if (contentsIterator != null && contentsIterator.hasNext()) { // checks if contentsIterator is not null
																				// and has a next element
					return contentsIterator.next();
				} else {
					contentsIterator = null;
					if (folderContents[nextIndex].isDirectory()) { // checks if the next element is a directory
						contentsIterator = new DeepFileIterator(folderContents[nextIndex]); // contentsIterator holds
																							// the contents of the
																							// directory
						++nextIndex; // steps through the next element
						return folderContents[nextIndex - 1]; // returns the previous element because nextIndex was
																// incremented
					} else {
						++nextIndex;
						return folderContents[nextIndex - 1];
					}

				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

		} else {
			throw new NoSuchElementException("This directory no longer has remaining files.");
		}
	}
}
