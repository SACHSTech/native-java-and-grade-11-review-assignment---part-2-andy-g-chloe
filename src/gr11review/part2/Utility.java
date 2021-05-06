package gr11review.part2;

public class Utility {

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

        // Declare variables
        char charLetter;
        char charLetter2;
        String returnStr;

        // Initialize a variable
        returnStr = "";

        /* 
        if the String parameter is less than length 3, 
        return the string parameter as no changes can be 
        made to the word 
        */ 
        if (str.length() < 3) {
            returnStr = str;
        }

        // if the length is greater than 3 
        else {

            // Loop the number of times as the length of the string parameter minus 2 as to not have any out of range errors
            for (int intCount = 0; intCount < (str.length() - 1); intCount++){
                
                /*
                let the first variable equal to a letter in str
                and the second variable equal to the letter after the next one
                */
                
                charLetter = str.charAt(intCount);
                charLetter2 = str.charAt(intCount + 2);
                
                // if the two letters follow the "z_p" structure
                if (charLetter == 'z' && charLetter2 == 'p') {
                    
                    // add "zp" (middle letter is absent) to the string to be returned
                    returnStr += "zp";
                    
                    // increase the value of intCount by 2 as to not reread them
                    intCount += 2;
                }

                else {
                    // add the read letter to the string to be returned
                    returnStr += charLetter;
                }

                // if the end of the loop is reached
                if (str.length() - 2 == intCount) {
                    charLetter = str.charAt(intCount + 1);
                    returnStr += charLetter;
                    charLetter = str.charAt(intCount + 2);
                    returnStr += charLetter;
                }
            }
        }
        
        return returnStr;
    
    }


       
    

    
}
