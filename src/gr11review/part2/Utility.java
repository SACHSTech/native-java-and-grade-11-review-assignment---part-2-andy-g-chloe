package gr11review.part2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Utility {

    /**
    * A method zipZap() that lets you specify a String parameter and that removes the middle 
    *==== letter of any instance where the string of length 3 z_p appears, where any letter can be found between z and p
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

    public static String longestWord(String filenametxt) {
        BufferedReader br = null; 
        
        String result = "";
        try {
            File file = new File(filenametxt);
            br = new BufferedReader(new FileReader(file));

            String s;
            while ((s = br.readLine()) != null) {
                if (result.length() <= s.length()) {
                    result = s;
                }
            } 
        } catch (IOException e) {
            System.err.println("Cannot read file: " + e.getLocalizedMessage());
        } finally {
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

    

    public static int[] tenRun(int[] nums) {
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

public static boolean linearIn(int[] outer, int[] inner) {
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

public static void pascalTri(int i, int j) {
    int[][] p = new int[i][j];

    try {
        File file = new File("pascalOut.txt");
        FileWriter myWriter = null;
        for (int intCount = 0; intCount < i; intCount++) {
            p[intCount][0] = 1;
        }
        for (int intCount = 0; intCount < j; intCount++) {
            p[0][intCount] = 1;
        }
        for (int intCount = 1; intCount < i; intCount++) {
            for (int intCount2 = 1; intCount2 < j; intCount++) {
                p[intCount][intCount2] = p[intCount - 1][intCount2] + p[intCount][intCount2 - 1];
            }

        }
        myWriter = new FileWriter(file);

        myWriter.write(Arrays.deepToString(p));
        System.out.println(Arrays.deepToString(p));
        myWriter.close();

    } 
    catch (IOException e) {
        e.printStackTrace();
    }


    
    

}

    
}
