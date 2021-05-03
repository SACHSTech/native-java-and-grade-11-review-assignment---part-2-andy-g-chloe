package gr11review.test2;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import gr11review.part2.Utility;
import java.io.*;

public class Array3Test {

    
    /**
     * Test general access to the file
     */
    @Test
    void testSignature() throws IOException{
        assertTrue(Utility.linearIn(new int[]{}, new int[]{}));
    }


    @Test
    void test1(){
        assertTrue(Utility.linearIn(new int[]{1,3,5,7,9}, new int[]{5,7}));
    }

    @Test
    void test2(){
        assertTrue(!(Utility.linearIn(new int[]{1,3,5,7,9}, new int[]{5, 6, 7})));
    }

    @Test
    void test3(){
        assertTrue(Utility.linearIn(new int[]{1, 3, 5, 7, 9}, new int[]{7, 9}));
    }

    @Test
    void test4(){
        assertTrue(Utility.linearIn(new int[]{1}, new int[]{1}));
    }
}


