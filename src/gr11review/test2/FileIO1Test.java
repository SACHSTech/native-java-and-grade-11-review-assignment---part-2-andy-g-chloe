package gr11review.test2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gr11review.part2.Utility;
import java.io.*;

public class FileIO1Test {

    private final String absPath = "/Users/eric/ICS4U-native-gr11review-part2/src/gr11review/test2/";

    /**
     * Test general access to the file
     */
    @Test
    void testSignature() throws IOException{
        assertTrue((Utility.longestWord(absPath+"Review2_3Test_1.txt").length() >=0 ));
    }

    /**
     * Test general case, longest word is somewhere in the middle
     */
    @Test
    void testMiddle()throws IOException{
        assertEquals(Utility.longestWord(absPath+"Review2_3Test_1.txt"), "conservation");

    }

    /**
     * Test file only has one word
     */
    @Test
    void testSingle() throws IOException{
        assertEquals(Utility.longestWord(absPath+"Review2_3Test_2.txt"), "x");
    }
    
    /**
     * Test more than one occurrences of a longest word length, returns the last word
     */
    @Test
    void testDouble() throws IOException{
        assertEquals(Utility.longestWord(absPath+"Review2_3Test_3.txt"), "preservation");
    }

    /**
     * Test longest word is the last word in the file 
     */
    @Test
    void testEnd() throws IOException{
        assertEquals(Utility.longestWord(absPath+"Review2_3Test_4.txt"), "conservation");
    }

}



