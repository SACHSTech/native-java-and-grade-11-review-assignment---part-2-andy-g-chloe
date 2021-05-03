package gr11review.test2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gr11review.part2.Utility;
import java.io.*;

public class Array6Test {

    private final String absPath = "/Users/eric/ICS4U-native-gr11review-part2/src/gr11review/part2/";


    String getResultString()throws IOException{
        BufferedReader thefile = new BufferedReader(new FileReader(absPath+"diagonalOut.txt"));
        String currentLine;
        String fileStr = "";

        currentLine = thefile.readLine();
        
        while (currentLine != null){
            fileStr = fileStr + currentLine;
            currentLine = thefile.readLine();
        }
        thefile.close();
        return fileStr;

    }

    /**
     * Test general access to the file
     */
    @Test
    void testSignature() throws IOException{
        Utility.diagonal(1);

        BufferedReader thefile = new BufferedReader(new FileReader(absPath+"diagonalOut.txt"));
        assertTrue(thefile != null);
        thefile.close();

    }

    @Test
    void test1() throws IOException{
        Utility.diagonal(1);

        BufferedReader thefile = new BufferedReader(new FileReader(absPath+"diagonalOut.txt"));
        String line;
        line = thefile.readLine();

        assertEquals("1", line);
        thefile.close();

    }

    @Test
    void test2() throws IOException{
        Boolean result = true;

        Utility.diagonal(3);

        String results_str = 
        "0,0,1"+
        "0,1,2"+
        "1,2,2";
       
        assertEquals(results_str, getResultString());

    }


    @Test
    void test3() throws IOException{
        Boolean result = true;

        Utility.diagonal(8);

        String results_str = 
        "0,0,0,0,0,0,0,1"+
        "0,0,0,0,0,0,1,2"+
        "0,0,0,0,0,1,2,2"+
        "0,0,0,0,1,2,2,2"+
        "0,0,0,1,2,2,2,2"+
        "0,0,1,2,2,2,2,2"+
        "0,1,2,2,2,2,2,2"+
        "1,2,2,2,2,2,2,2";
       
        assertEquals(results_str, getResultString());

    }

    @Test
    void test4() throws IOException{
        Boolean result = true;

        Utility.diagonal(2);

        String results_str = 
        "0,1"+
        "1,2";
       
        assertEquals(results_str, getResultString());

    }

}



