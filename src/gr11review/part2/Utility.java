package gr11review.part2;
import java.io.*;
import java.util.*;

public class Utility {
  // For testing methods
  public static void main(String[] args) throws IOException{
    String i = alphaWord("words.txt");
    System.out.println(i);
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
    BufferedReader thefile = new BufferedReader(new FileReader("src/gr11review/part2/" + filenametxt));

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

    
}
