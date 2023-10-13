/*
 * This program will let users to use a file and see how many, vowels, consonants, and words and even write that in a text file with that information
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
public class TextAnalyzer {
	/**
	 * This is a welcome banner that will be display once the user opens the program
	 */
	public static void printWelcomeBanner() {
		System.out.println("*".repeat(56));
		System.out.println(" ".repeat(17) + "Welcome to TextAnalyze");
		System.out.println("*".repeat(56));
		System.out.println();
	}
	/**
	 * This is the menu that the user will get once they put in there text file.
	 */
	public static void printMenu() {
		System.out.println("Here are your options:");
		System.out.println("1. Count the number of vowels.");
		System.out.println("2. Count the number of consonants.");
		System.out.println("3. Count the number of words.");
		System.out.println("4. Print a summary to a file.");
		System.out.println("5. Quit");
		
	}
	/**
	 * This program does this
	 * a) will the use a string to keep the file words in
	 * b) use a bufferedreader to read the file (also the file reader as well)
	 * c) then will use this string for each line
	 * d) while the program is reading every line it will look if it has words or no problems it will add the lines to the text string
	 * e) if there is any exception then it will return null and main will yell at the user to fix it
	 */
	public static String readFile(String fileName) {
		try {
			String fileText = " ";
			BufferedReader rsc = new BufferedReader(new FileReader(fileName));
			String fileLine;
			while ((fileLine = rsc.readLine()) != null) {
				fileText += fileLine + " ";
			}
			rsc.close();
			return fileText;
		} catch (Exception ex) {
			return null;
		}
		
	}
	/**
	 * This will:
	 * a) will the i is less than the length of the file will go through this 
	 * b) it will use a character c which is the file text and go though ever i character
	 * c) then if it is either aeiou it will add that to the int fileCountVowel
	 * d) and will return that value
	 */
	public static int countFilesVowels(String fileText) {
		int fileCountVowels = 0;
		for (int i = 0; i < fileText.length(); i++) {
			char c = fileText.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				fileCountVowels++;
			}
		}
		return fileCountVowels;
	}
	/**
	 * This will:
	 * a) will the i is less than the length of the file will go through this
	 * b) It will also use a character c which will the file text and go through every i characters
	 * c) the if the character is everything other then aeiou it will add that to the int fileCountConsoants
	 * d) and will return that value
	 */
	public static int countFilesConsonants(String fileText) {
		int fileCountConsonants = 0;
		for (int i = 0; i < fileText.length(); i++) {
			char c = fileText.charAt(i);
			if (c == 'b' || c == 'c' || c == 'd' || c == 'f' || c == 'g' || c == 'h' || c == 'j' || c == 'k' || c == 'l' || c == 'm' || c == 'n' || c == 'p' || c == 'q' || c == 'r' || c == 's' || c == 't' || c == 'v' || c == 'w' || c == 'x' || c == 'y' || c == 'z'|| c == 'B' || c == 'C' || c == 'D' || c == 'F' || c == 'G' || c == 'H' || c == 'J' || c == 'K' || c == 'L' || c == 'M' || c == 'N' || c == 'P' || c == 'Q' || c == 'R' || c == 'S' || c == 'T' || c == 'V' || c == 'W' || c == 'X' || c == 'Y' || c == 'Z') {
				fileCountConsonants++;
			}
		}
		return fileCountConsonants;
	}
	/**
	 * This will:
	 * a) will when the i is less than the length of the file will go through this
	 * b) will again us that character c as we have seen 
	 * c) this time it will look if the c is not a-z and if it isnt that i will add that as a word 
	 * d) else it will call it false and not add it 
	 * e) after going through all the values it will return that value as the int fileCountWord
	 */
	public static int countFilesWords(String fileText) {
		int fileCountWords = 0;
		boolean fileInWord = false;
		
		for(int i = 0; i < fileText.length(); i++) {
			char c = fileText.charAt(i);
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
					if(!fileInWord) {
						fileCountWords++;
						fileInWord = true;
					}
				} else {
					fileInWord = false;
				}
		}
		return fileCountWords;
	}
	/**
	 * This will:
	 * a) use a printwriter to print the writing into the file the user wants 
	 * b) will print the text and the all the numbers of vowels, consonants, and words
	 * then return as it worked to the main function
	 * if any exception it will go back to the main loop as it failed
	 */
	 public static boolean writeFileSummary(String fileName, String fileText) {
	 
		 try {
	            PrintWriter wsc = new PrintWriter(fileName);
	            wsc.println(fileText);
	            wsc.printf("There are %d vowels, %d consonants, and %d words" ,countFilesVowels(fileText), countFilesConsonants(fileText), countFilesWords(fileText));
	            wsc.close();
	            return true;
	        } catch (Exception ex) {
	            return false;
	        }
	  }
	 /**
	  * This will:
	  * A) print the banner
	  * b) ask the user to put in a file
	  * c)if it is a file it will go to the area if not then it will ask the user to put in another file 
	  * d) will print the menu and ask the user to put in what they want to do
	  * e) will computes the number of vowels if 1, number of consonants if 2 and number of words if 3
	  * f) if 4 it will ask the user to put in a file to put the summary in and if it works will put that into the file and if not will tell the user it didnt work
	  * g) 5 will close the program
	  * h) any number other then 1-5 will yell at the user to put in a number that is in the menu
	  * i) any spelling at all will yell at the user to type the number not the whole number out
	  */
	public static void main(String[] args) {
		printWelcomeBanner();
		Scanner sc = new Scanner(System.in);
		String fileText = " ";
		
		do {
			System.out.print("What text file would you like to analyze? ");
			String fileName = sc.nextLine();
			fileText = readFile(fileName);
		
			if (fileText == null){
				System.out.println("Unable to read the file. Make sure its the directory as well. ");
			}
		} while (fileText == null);
		
		int userChoice;
		do {
			printMenu();
			System.out.print("Enter the number of your choice: ");
				if (sc.hasNextInt()) {
					userChoice = sc.nextInt();
					sc.nextLine();
					if (userChoice == 1) {
						int filesVowels = countFilesVowels(fileText);
						System.out.printf("There are %d vowels.%n", filesVowels);
					} else if (userChoice == 2) {
						int filesConsonants = countFilesConsonants(fileText);
						System.out.printf("There are %d consonants.%n", filesConsonants);
					} else if (userChoice == 3) {
						int filesWords = countFilesWords(fileText);
						System.out.printf("There are %d words.%n", filesWords);
					} else if (userChoice == 4) {
						 System.out.print("Enter the name of the file to write the summary: ");
						 String fileSummary = sc.nextLine();
						 boolean fileSuccess = writeFileSummary(fileSummary, fileText);
						 if (fileSuccess) {
	                            System.out.println("The summary was written to a file.");
	                        } else {
	                            System.out.println("Failed to write the summary to the file. Remember has to be from your directory not just the file name");
	                        }
					} else if (userChoice == 5) {
						System.out.println("Thank you for using this program.");
					} else {
						System.out.println("Hey you have to type a number not type the whole number out");
					}
				}else {
					System.out.println("Hey you have to type a number not type the whole number out");
					sc.nextLine();
					userChoice = 0;
				}
		} while (userChoice != 5);
		
	}
}
