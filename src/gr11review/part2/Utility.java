package gr11review.part2;
import java.io.*;
import java.util.*;

public class Utility {

  /**
  *
  * Given a string, it returns the sum of all of the integers within the string
  *
  * @param str  The input string
  * @return an integer value representing the sum of the integers within the string
  * @author: Andy Guo
  *
  */

  public static int sumNumbers(String str) {

      // Declaring variables
      int runningSum = 0;
      String[] strArray = str.split("");
      String numbersToAdd = "";

      // Iterating through each char within the String
      for (String i : strArray) {

        // If that char in the string is a number
        if (i.equals("1") || i.equals("2") || i.equals("3") || i.equals("4") || i.equals("5") || i.equals("6") || i.equals("7") || i.equals("8") || i.equals("9") || i.equals("0")) {

          // Add that number to the end of the numbersToAdd string
          numbersToAdd = numbersToAdd + i;
        }

        // If that char is anything but a number
        else {
          // If the length of numbersToAdd is not 0, meaning the previous char was an int, add that number to the running total
          if (numbersToAdd.length() != 0) {
            runningSum += Integer.parseInt(numbersToAdd);
          }

          // Reset numbersToAdd to a blank String
          numbersToAdd = "";
        }

      }

      // If the last few chars were an int, add to the running total
      if (numbersToAdd.length() != 0) {
        runningSum += Integer.parseInt(numbersToAdd);
      }

      // Return the running total
      return runningSum;
  }


  /**
  *
  * Given the name of a file, retunrs the word that comes first alphabetically within the file
  *
  * @param filenametxt  The file name
  * @return a String that is the first word alphabetically within the file
  * @author: Andy Guo
  *
  */

  public static String alphaWord(String filenametxt) throws IOException{
    // File reader
    BufferedReader thefile = new BufferedReader(new FileReader(filenametxt));

    // Declaring variables
    String strStuff = "";

    // Arraylist for words in file to be sorted later
    ArrayList<String> fileWords = new ArrayList<String>();

    // Loading every word in file to arraylist
    while(strStuff != null){
			strStuff = thefile.readLine();
			if(strStuff != null){
				fileWords.add(strStuff);
			}
		}
		thefile.close();

    Collections.sort(fileWords);

    return fileWords.get(0);

  }


  /**
  *
  * Given an array, when the desired value appears, when that value is alone, it is replaced by whichever value to its left or right is greater
  *
  * @param nums  The input array
  * @param value  The value to be changed
  * @return an integer array containing the changes
  * @author: Andy Guo
  *
  */

  public static int[] notAlone(int[] nums, int value) {
    // Declaring variables
    int largeNum;
// Loops from 2nd index to 2nd last index
    for (int i = 1; i < nums.length - 1; i++) {

      // If that number is not the number we are looking for, continue
      if (nums[i] != value) {
        continue;
      }

      // If that number is not alone, continue
      else if (nums[i] == nums[i - 1] || nums[i] == nums[i + 1]){
        continue;
      }

      // If that number is alone, replace with the larger number that surrounds it
      else {
        largeNum = nums[i - 1];
        if (nums[i + 1] > largeNum) {
          largeNum = nums[i + 1];
        }

        nums[i] = largeNum;
      }

    }


    return nums;
  }


  /**
  *
  * Given an array, it returns a boolean that says whether or not the array can be split to where the sum of each side is equal
  *
  * @param nums  The input array
  * @return a boolean value that says whether or not the array can be split such that the sum of both sides are equal
  * @author: Andy Guo
  *
  */

  public static boolean canBalance(int[] nums) {
    
    // Declaring variables
    int sumLeft = 0;
    int sumRight = 0;

    // Setting the sum of the rigth side as the sum of the entire array
    for (int i : nums) {
      sumRight += i;
    }

    // This array shifts one number at a time in the sume from the right to left and checks to see if balanced
    for (int i : nums) {
      sumRight -= i;
      sumLeft += i;
      if (sumRight == sumLeft) {
        return true;
      }
    }

    // If it iterated through the entire array, and is deemed not to be balanced, reutrn false
    return false; //modify later
  }


  /**
  *
  * Given an integer n, it writes onto a file a 2D array, size n * n, where:
  *   The top right to bottom left is connected by a straight diagonal line of 1
  *   Anything below this diagonal line is a 2
  *   Anything above this diagonal line is a 0
  *   Each value is separated by only a comma
  * 
  * @param n  The size of the array
  * @author: Andy Guo
  *
  */

  public static void diagonal(int n) throws IOException{

    // PrintWriter
    PrintWriter theout = new PrintWriter(new FileWriter("src/gr11review/part2/diagonalOut.txt", false));

    // j counts down from the size of the square to 0; every time it moves down a row, j counts the index where the 1 should be
    for (int j = n - 1; j >= 0; j--) {

      // i counts the number of rows
      for (int i = 0; i < n; i++) {
        if (i < j) {
          theout.print("0");
        }
        else if (i == j) {
          theout.print("1");
        }
        else {
          theout.print("2");
        }

        // If its not the last column, print a comma
        if (i != n - 1) {
          theout.print(",");
        }

        // If it is the last column, print a new line
        else {
          theout.println("");
        }
      }
    }

    // Close the file
    theout.close();
  }

  
    /**
    * A method zipZap() that lets you specify a String parameter and that removes the middle 
    * letter of any instance where the string of length 3 z_p appears, where any letter can be found between z and p
    *
    * @param str The String in which the program searches for instances of "z_p" 
    * @return A String with the middle letter removed from instances of "z_p"
    * @author: Chloe Cheung
    *
    */ 
  
    public static String zipZap(String str) {

        // Declare Variables
        char charLetter;
        String returnStr;
        
        // Initialize variable
        returnStr = "";
        
        // if the string parameter is less than length 3
        if (str.length() < 3) {
            returnStr = str;
        }
        else {
            // Add the first letter
            returnStr += str.charAt(0);

            /* 
            Loops two times less than the length of str.
            intCount starts on the index of the second letter
            and ends on the index of the second last letter. 
            */
            
            for (int intCount = 1; intCount < (str.length() - 1); intCount++) {
                
                charLetter = str.charAt(intCount);
                
                // if the previous letter is not z or the letter after is not p
                if ((str.charAt(intCount - 1) != 'z') || (str.charAt(intCount + 1) != 'p')) {
                    returnStr += charLetter;
                }
            }

            // Add the last letter
            returnStr += str.charAt(str.length() - 1);
        }
        
    
        // return the new string 
        return returnStr;
        
    
    }

  /**
  * A method longestWord() that reads a text file and retuns the longest word
  *
  * @param filenametxt The text file from which the words are read
  * @return A String with longest word in the file
  * @author: Chloe Cheung
  *
  */
    public static String longestWord(String filenametxt) {

        // Buffered Reader
        BufferedReader br = null; 
        
        // Initalize result variable 
        String result = "";

        // try statement
        try {

            // Create buffered reader
            File file = new File(filenametxt);
            br = new BufferedReader(new FileReader(file));

            // Create string variable
            String strWord;


            while ((strWord = br.readLine()) != null) {
                // If the variable holding the longest word is shorter than the word it read
                if (result.length() <= strWord.length()) {
                    // The read word becomes the longest word
                    result = strWord;
                }
            } 

        // catch statement
        } 
        catch (IOException e) {
            System.err.println("Cannot read file: " + e.getLocalizedMessage());
        } 

        // finally statement
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
    
/**
* a method tenRun() that takes an array of numbers
* and returns an array that converts all non-multiples of 10
* to the most recent multiple of 10
*
* @param filenametxt the filename  
* @return a string; the longest word in the file
* @author: Chloe Cheung
*
*/


    public static int[] tenRun(int[] nums) {


        // A for loop that loops from the second to the last element in the array
        for (int intCount = 1; intCount < nums.length; intCount++) {
            
            // if the number is not a multiple of 10
            if (nums[intCount] % 10 != 0){

                // if the previous number is a multiple of 10, assume its value
                if (nums[intCount - 1] % 10 == 0){
                    nums[intCount] = nums[intCount - 1];
                }
            }
                
        }

        return nums;
    }

/**
* a method linearIn() that takes two arrays
* and returns true or false on whether the elements
* of the inner array all appear in the outer 
*
* @param outer array in which is checked for the elements of the inner array
* @param inner array in which its elements are searched for in outer array
* @return boolean value 
* @author: Chloe Cheung
*
*/

public static boolean linearIn(int[] outer, int[] inner) {
    
    /** 
     * Declare variables 
     * intResumeCount is used for the linear reading of the outer array
     * intCheck is used for checking if all elements of inner appear in outer
     */
    int intResumeCount;
    int intCheck;

    // initialize variables
    intCheck = 0;
    intResumeCount = 0;

    // Loop through every element of inner
    for (int intCount = 0; intCount < inner.length; intCount++) {

        // Loop through every element of outer
        for (int intCount2 = intResumeCount; intCount2 < outer.length; intCount2++) {
            
            // if element in inner is found in outer
            if (inner[intCount] == outer[intCount2]){
                
                // Variable holds the counter value 
                intResumeCount = intCount2;
                
                // Success counter goes up
                intCheck += 1;  
                
                // exit out of for loop
                break;
            }
        }
    }

    // if every element in inner is found in outer
    if (intCheck == inner.length) {
        
        // return statement
        return true;
    }
    
    // Otherwise
    else {

        // return statement
        return false;
    }
    

}

/**
    * a method pascalTri() that takes the row and column dimensions
    * and writes the pascal triangle of those dimensions to a file called
    * pascalOut.txt
    *
    * @param i row integer
    * @param j column integer
    * @author: Chloe Cheung
    *
    */

public static void pascalTri(int i, int j) throws IOException {
    
    // Create array
    int[][] p = new int[i][j];

    // For writing to file
    PrintWriter file = new PrintWriter(new FileWriter("C:\\Users\\chloe\\Desktop\\native-java-and-grade-11-review-assignment---part-2-andy-g-chloe\\src\\gr11review\\test2\\pascalOut.txt", false));
    
    // Add 1's to the entire first row
    for (int intCount = 0; intCount < i; intCount++) {
        p[intCount][0] = 1;
    }

    // Add 1's to the entire first column
    for (int intCount = 0; intCount < j; intCount++) {
        p[0][intCount] = 1;
    }

    // Add loop through every column
    for (int intCount = 1; intCount < j; intCount++) {
        // Loop through every row
        for (int intCount2 = 1; intCount2 < i; intCount2++) {
            // each element is the sum of the element on the row on top and the column on the left
            p[intCount2][intCount] = p[intCount2 - 1][intCount] + p[intCount2][intCount - 1];
        }

    }

    // loop through each row
    for (int intCount = 0; intCount < i; intCount++) {
    
        // loop through each column
        for (int intCount2 = 0; intCount2 < j; intCount2++) {
    
            // Write each element to file    
            file.print(p[intCount][intCount2]);

            // Elements in the same row are seperated by commas
            if (intCount2 != j - 1) {
                file.print(",");
            }
            
        }
        // Rows are seperated into the next line
        file.println("");

    }
    // Close the printwriter file
    file.close();
    
    
    

}
