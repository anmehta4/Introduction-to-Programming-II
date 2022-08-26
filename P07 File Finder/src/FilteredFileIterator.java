
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
import java.util.NoSuchElementException;

/**
 * This class iterates through the contents of a specified directory and will
 * also iterate through the contents of any directories contained within that
 * directory (no matter how deeply nested those contained folders might be) in
 * order to find the file(s) that contains the given string
 * 
 * @author arnavmehta
 *
 */
public class FilteredFileIterator implements java.util.Iterator<File> {

	private DeepFileIterator fileIterator; // – a DeepFileIterator that steps through all files within the initial
											// directory (and all contained sub directories).
	private String searchPattern; // a String that must be part of a file’s name in order for that file to be
									// returned from this iterator’s next method
	private File nextMatchingFile; // a File reference to the next file that this iterator will return

	/**
	 * Checks if the file exists and assigns a new DeepFileIterator object with a
	 * file argument and the specified string to the string variable.
	 * 
	 * @param obj           the folder that contains all the directories
	 * @param searchPattern the string that should be in the file name
	 * @throws FileNotFoundException
	 */
	public FilteredFileIterator(java.io.File obj, String searchPattern) throws FileNotFoundException {
		if (!obj.exists()) // checking if the file exists
			throw new FileNotFoundException("The file does not exist in the directory");
		else {
			fileIterator = new DeepFileIterator(obj); // stores the file into fileIterator
			this.searchPattern = searchPattern;
			nextMatchingFile = helper();
		}
	}

	/**
	 * This method checks to see if there is a file in the directory that contains
	 * the specified
	 * 
	 * @return nextMatchingFile if found else null
	 */
	private File helper() {
		while (fileIterator.hasNext()) { // iterates as long as there is a next file
			File next = fileIterator.next();
			if (next.getName().contains(searchPattern)) {
				nextMatchingFile = next; // if a file with searchPattern is found it gets stored in nextMatchingFile and
											// breaks out of the loop
				break;
			} else {
				nextMatchingFile = null; // if no searchPattern is found store null in nextMatchingFile
			}
		}
		return nextMatchingFile;
	}

	/**
	 * Checks if the iterator is at the end of the array
	 * 
	 * @return true if the iteration has more elements and false otherwise
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub

		if (nextMatchingFile != null) {// returns true only if there is a file in the directory with the searchPattern
			return true;
		}
		return false;
	}

	/**
	 * Returns the nextMatchingFile if fileIterator has a next.
	 * 
	 * @throws java.util.NoSuchElementException - with the following error message,
	 *                                          "This directory no longer has
	 *                                          remaining files." If there is no
	 *                                          next index.
	 * 
	 * @return tempNextFile - if the directory has remaining files.
	 */
	@Override
	public File next() {
		// TODO Auto-generated method stub
		if (fileIterator.hasNext()) { // iterates as long as there is a next file
			File tempNextFile = nextMatchingFile; // temporary storing the next file with string pattern before calling
													// helper
			helper(); // steps through the folder to find the nextMatchingFile
			return tempNextFile;
		} else {
			throw new NoSuchElementException("This directory no longer has remaining files.");
		}

	}

}
