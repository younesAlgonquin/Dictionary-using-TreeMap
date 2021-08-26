
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * CET - CS Academic Level 3
 * <br>Declaration: I declare that this is my own original work and is free from Plagiarism
 * <br>Student Name: Younes Boutaleb
 * <br>Student Number: 041019068 
 * <br>Assignment number: Assignment 3
 * <br>Date: 8/1/2021
 * <br>purpose of class: This class builds a tree “dictionary” of words
 * <br>that were found in a piece of text and keep track of how many occurrences there were of each of the words.
 * <br>Section #: 303
 * <br>Course: CST8130 - Data Structures
 * <br>Professor: James Mwangi PhD.
 * @author Younes Boutaleb.
 * @version 1.0
 * 
 */
public class Dictionary {

	/**this is the TreeMap data structure that stores the text words*/
	private TreeMap <Integer, String> dictionary = new TreeMap <>();


	/**
	 * This method read word from a file and store it in the TreeMap 
	 * @param input This the scanner object defined in the main class
	 * @param ignoreArticles takes false to read all words and true to ignore articles
	 */
	public void readFiletoMap(Scanner input, boolean ignoreArticles) {

		//Prompt for the file name
		System.out.print("\nEnter the File name: ");
		input.nextLine();
		String file=input.nextLine();

		//counts the number of words read from the file
		int count=0;

		try {

			//Scanner object that open the file and read from it
			Scanner scanner = new Scanner(Paths.get(file));
			//The word read from the file
			String word;

			//Read all the words from the file
			if(ignoreArticles==false) {
				//check if there's more words in the file
				while (scanner.hasNext()) {
					//read words without punctuation and put in upper-case
					word = scanner.next().replaceAll("[^a-zA-Z0-9'_-]", "").toUpperCase();
					//increment the number of words
					count++;
					//add words to the TreeMap
					dictionary.put(count, word);

				}//end while

				System.out.println("Program has read the file");
				//Read all the words from the file except the articles
			}else {
				//check if there's more words in the file
				while (scanner.hasNext()) {

					//read words without punctuation and put in upper-case
					word = scanner.next().replaceAll("[^a-zA-Z0-9'_-]", "").toUpperCase();
					//ignore articles
					if(!word.equals("A")&&!word.equals("AN")&&!word.equals("THE")) {
						count++;
						//add words to the TreeMap
						dictionary.put(count, word);
					}//end if

				}//end while	

				System.out.println("Ignore definite and indefinite articles has been set to true");
			}//end if /else
			//close the file
			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("Invalid file name");
		}catch (SecurityException e) {
			System.out.println("Read permission denide");
		}catch (IOException e) {
			e.printStackTrace();
		}//end try statement
	}//end readFiletoMap



	/**
	 * This method search for a specific word in the dictionary TreeMap
	 * @param input This the scanner object defined in the main class
	 */
	public void serachWord(Scanner input) {

		//clear the standard input
		input.nextLine();
		//prompt for the word to search for
		System.out.print("Enter the word you want to search: ");
		String word = input.nextLine();

		//Check if there's no occurrences of the entered word in the dictionary
		if (!dictionary.containsValue(word.toUpperCase())) {

			System.out.println(word + " occurs 0 times");

		}//end if
		//if the dictionary contains the specified word, count the number of occurrences
		else {

			//this is the size of the TreeMap
			int size = dictionary.size();
			//This is a counter
			int count = 1;
			//This the number of occurrences
			int wordFrequency=0;

			//loop through all TreeMap values
			while (count <= size) {
				//increment occurency of the word if it equals to the current values in the TreeMap
				if(word.toUpperCase().equals(dictionary.get(count))) {

					wordFrequency++;
				}//end if
				//goe to the next element
				count++;
			}//end while

			System.out.println(word + " occurs " +  wordFrequency + " times");

		}//end if /else
	}//end serachWord



	/**
	 * This method counts the number of unique words in the text
	 */
	public void displayNumberOfUniqueWords() {

		//This is a TreeMap data structure which will store the swapped entries of the dictionary TreeMap
		TreeMap<String, Integer> unique = new TreeMap<String, Integer>();

		//Get the entries as key-value sets then swap the key and value 
		for (Map.Entry<Integer, String> entry : dictionary.entrySet() ) {

			//put the swapped entries in the unique TreeMap. The duplicate keys (words) will be overwritten
			unique.put(entry.getValue(), entry.getKey());

		}//end for

		//The number of unique elements is the size of unique TreeMap
		System.out.println("Dictionary has " + unique.size() + " unique words");	
	}//end displayNumberOfUniqueWords


	/**
	 * This method counts and prints the total number of words in the dictionary 
	 */
	public void displayNumberWords() {

		System.out.println("Dictionary has "+ dictionary.size() +" words");

	}//end displayNumberWords




	/**
	 * This method clears all entries in the dictionary
	 */
	public void resetDictionary() {

		dictionary.clear();

		System.out.println("Program has removed all the words");
	}//end resetDictionary

}//end class
