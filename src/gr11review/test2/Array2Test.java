package gr11review.test2;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import gr11review.part2.Utility;
import java.io.*;

public class Array2Test {

    
    /**
     * Test general access to the file
     */
    @Test
    void testSignature() throws IOException{
        assertTrue((Utility.notAlone(new int[]{},0)) != null);
    }


    @Test
    void test1(){
        int[] inArray = {1, 2, 3};
        int[] outArray = {1, 3, 3};

        assertTrue(Arrays.equals(Utility.notAlone(inArray,2), outArray) );
    }

    @Test
    void test2(){
        int[] inArray = {1, 2, 3, 2, 5, 2};
        int[] outArray = {1, 3, 3, 5, 5, 2};

        assertTrue(Arrays.equals(Utility.notAlone(inArray,2), outArray) );
    }

    @Test
    void test3(){
        int[] inArray = {3, 4};
        int[] outArray = {3, 4};

        assertTrue(Arrays.equals(Utility.notAlone(inArray,3), outArray) );
    }

    @Test
    void test4(){
        int[] inArray = {1};
        int[] outArray = {1};

        assertTrue(Arrays.equals(Utility.notAlone(inArray,1), outArray) );
    }
}


