package gr11review.test2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gr11review.part2.Utility;
import java.io.*;

public class Array5Test {

    private final String absPath = "/Users/eric/ICS4U-native-gr11review-part2/src/gr11review/part2/";


    String getResultString()throws IOException{
        BufferedReader thefile = new BufferedReader(new FileReader(absPath+"pascalOut.txt"));
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
        Utility.pascalTri(1, 1);

        BufferedReader thefile = new BufferedReader(new FileReader(absPath+"pascalOut.txt"));
        assertTrue(thefile != null);
        thefile.close();

    }

    @Test
    void test1() throws IOException{
        Utility.pascalTri(1, 1);

        BufferedReader thefile = new BufferedReader(new FileReader(absPath+"pascalOut.txt"));
        String line;
        line = thefile.readLine();

        assertEquals("1", line);
        thefile.close();

    }

    @Test
    void test2() throws IOException{
        Boolean result = true;

        Utility.pascalTri(4, 4);

        String results_str = 
            "1,1,1,1"+ 
            "1,2,3,4" +  
            "1,3,6,10"+
            "1,4,10,20";
       
        assertEquals(results_str, getResultString());

    }

    @Test
    void test3() throws IOException{

        Utility.pascalTri(1, 5);

        String results_str = "1,1,1,1,1";
       
        assertEquals(results_str, getResultString());

    }

    @Test
    void test4() throws IOException{

        Utility.pascalTri(0, 0);
       
        assertEquals("", getResultString());

    }

    @Test
    void test5() throws IOException{

        Utility.pascalTri(5, 1);

        String results_str = "11111";
       
        assertEquals(results_str, getResultString());

    }

    @Test
    void test6() throws IOException{
        Boolean result = true;

        Utility.pascalTri(4, 5);

        String results_str = 
        "1,1,1,1,1" +  
        "1,2,3,4,5" +  
        "1,3,6,10,15" +  
        "1,4,10,20,35";
       
        assertEquals(results_str, getResultString());

    }

}



