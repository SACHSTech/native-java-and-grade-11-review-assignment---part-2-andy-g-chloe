package gr11review.test2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gr11review.part2.Utility;
import java.io.*;

public class FileIO2Test {

    private String filePath = new File("").getAbsolutePath();
    private final String absPath = filePath+ "/src/gr11review/test2/";

    /**
     * Test general access to the file
     */
    @Test
    void testSignature() throws IOException{
        assertTrue((Utility.alphaWord(absPath+"Review2_3Test_1.txt").length() >=0 ));
    }

    /**
     * Test general case, alpha word is somewhere in the middle
     */
    @Test
    void testGeneral()throws IOException{
        assertEquals(Utility.alphaWord(absPath+"Review2_3Test_1.txt"), "accompany");

    }

    /**
     * Test file only has one word
     */
    @Test
    void testSingle() throws IOException{
        assertEquals(Utility.alphaWord(absPath+"Review2_3Test_2.txt"), "x");
    }
    
    /**
     * Test more similar alphaWord, different at the end
     */
    @Test
    void testDouble() throws IOException{
        assertEquals(Utility.alphaWord(absPath+"Review2_3Test_3.txt"), "accompanyx");
    }

  
}



