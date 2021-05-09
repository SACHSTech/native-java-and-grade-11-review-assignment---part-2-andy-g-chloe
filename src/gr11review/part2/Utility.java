package gr11review.part2;
import java.io.*;
import java.util.*;

public class Utility {
  // For testing methods
  public static void main(String[] args) throws IOException{
    int[] test = new int[]{1, 2, 3, 2, 5, 2};
    int[] i = notAlone(test, 2);
    for (int j : i) {
      System.out.println(j);
    }
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
}
