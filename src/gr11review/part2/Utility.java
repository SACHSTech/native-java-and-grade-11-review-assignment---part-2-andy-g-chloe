package gr11review.part2;
import java.io.*;
import java.util.*;

public class Utility {
  // For testing methods
  public static void main(String[] args) throws IOException{
    int[] test = new int[]{2, 1, 1, 2, 1};
    boolean i = canBalance(test);
    System.out.println(i);

    diagonal(12);
  }

  

  /**
    *
    *
    *
    * @param str
    * @return
    * @author: Andy Guo
    *
    */
  public static int sumNumbers(String str) {

      // Declaring variables
      int runningSum = 0;
      String[] strArray = str.split("");
      String numbersToAdd = "";

      for (String i : strArray) {

        // If that char in the string is a number
        if (i.equals("1") || i.equals("2") || i.equals("3") || i.equals("4") || i.equals("5") || i.equals("6") || i.equals("7") || i.equals("8") || i.equals("9") || i.equals("0")) {

          // Add that number to the end of the numbersToAdd string
          numbersToAdd = numbersToAdd + i;
        }

        // If that char is anything but a number
        else {
          if (numbersToAdd.length() != 0) {
            runningSum += Integer.parseInt(numbersToAdd);
          }
          numbersToAdd = "";
        }

      }
      if (numbersToAdd.length() != 0) {
        runningSum += Integer.parseInt(numbersToAdd);
      }
      return runningSum;
  }

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

  public static void diagonal(int n) throws IOException{

    // PrintWriter
    PrintWriter theout = new PrintWriter(new FileWriter("src/gr11review/part2/diagonalOut.txt", true));

    for (int j = n - 1; j >= 0; j--) {
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
        // If its the last row, don't print a new line
        else if (j != 0){
          theout.println("");
        }
      }
    }

    theout.close();
  }
}
