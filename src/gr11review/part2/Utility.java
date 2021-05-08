package gr11review.part2;
import FileReader;
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

    





       
    

    
}
