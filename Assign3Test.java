import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * CET - CS Academic Level 3
 * <br>Declaration: I declare that this is my own original work and is free from Plagiarism
 * <br>Student Name: Younes Boutaleb
 * <br>Student Number: 041019068 
 * <br>Assignment number: Assignment 3
 * <br>Date: 8/1/2021
 * <br>purpose of class: This class creates a menu of actions 
 * <br>then calls the appropriate method from the dictionary class to accomplish the chosen action 
 * <br>Section #: 303
 * <br>Course: CST8130 - Data Structures
 * <br>Professor: James Mwangi PhD.
 * @author Younes Boutaleb.
 * @version 1.0
 * 
 */
public class Assign3Test {

	/**
	 * This is the main method which tests the program
	 * @param args
	 */
	public static void main(String[] args) {

		//This is the main scanner object declared in this program
		Scanner input = new Scanner(System.in).useDelimiter("\r\n");
		//This is an Dictionary object which defines an TreeMap object and calls Dictionary methods on it
		Dictionary dic = new Dictionary();
		//This is the menu option chosen by the use
		int option = 0;
		//Input validation state(true/false)
		boolean valid ;

		//This loop continues until the user chose to exit the program
		while(option != 7) {

			valid=false;
			//if the user enters a non integer value the program displays an error message and loops back
			while(!valid) {

				displayMenu();
				//validates integer input
				try {
					option = input.nextInt();
					valid=true;
				}catch(InputMismatchException ex) {
					System.out.println("Input Mismatch Exception while reading user's option from main menu");
					input.nextLine();
				}//end catch
			}//end while

			//This switch structure executes the user's choice when it's valid otherwise it displays an error message
			switch(option) {

			//Prompt for a file name then read all words from it
			case 1:
				dic.readFiletoMap(input, false);

				break;

				//Search for a specific word in the dictionary 
			case 2:
				dic.serachWord(input);
				break;

				//Counts the number of unique words in the dictionary
			case 3:
				dic.displayNumberOfUniqueWords();
				break;

				//counts the total number of words
			case 4:
				dic.displayNumberWords();
				break;
				//clear all entries from the dictionary
			case 5:

				dic.resetDictionary();
				break;

				//Prompt for a file name then read all words from it except articles
			case 6:
				dic.readFiletoMap(input, true);
				break;

				//Exits the program	
			case 7:
				System.out.print("Good bye.... hope to see you soon");
				break;

				//displays an error message in case of invalid option
			default:
				System.out.println("Invalid option");
				break;

			}//end switch
		}//end while

		//Close the scanner object
		if(input != null)
			input.close();


	}//end main


	/**
	 * This method displays the menu
	 */
	public static void displayMenu() {

		//This stores the menu options 
		String formatSring="\n*********************************************";
		formatSring+="\nDICTIONARY";
		formatSring+="\n*********************************************";
		formatSring+="\n%d. Add words to the Dictionary from file";
		formatSring+="\n%d. Search a word in the Dictionar";
		formatSring+="\n%d. Display number of unique words in the Dictionary)";
		formatSring+="\n%d. Display number of unique words in the Dictionary";
		formatSring+="\n%d. Reset Dictionary";
		formatSring+="\n%d. Ignore definite and indefinite articles (false)";
		formatSring+="\n%d. Exit";
		formatSring+="\n\nEnter your option: ";


		System.out.print(String.format(formatSring, 1,2,3,4,5,6,7)); 	

	}//end displayMenu

}//end class





