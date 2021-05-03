package gr11review.test2;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import gr11review.part2.Utility;
import java.io.*;

public class Array1Test {

    
    /**
     * Test general access to the file
     */
    @Test
    void testSignature() throws IOException{
        assertTrue((Utility.tenRun(new int[]{})) != null);
    }


    @Test
    void test1(){
        int[] inArray = {2, 10, 3, 4, 20, 5};
        int[] outArray = {2, 10, 10, 10, 20, 20};

        assertTrue(Arrays.equals(Utility.tenRun(inArray), outArray) );
    }

    @Test
    void test2(){
        int[] inArray = {10, 1, 20, 2};
        int[] outArray = {10, 10, 20, 20};

        assertTrue(Arrays.equals(Utility.tenRun(inArray), outArray) );
    }

    @Test
    void test3(){
        int[] inArray = {10, 1, 9, 20};
        int[] outArray = {10, 10, 10, 20};

        assertTrue(Arrays.equals(Utility.tenRun(inArray), outArray) );
    }

}



