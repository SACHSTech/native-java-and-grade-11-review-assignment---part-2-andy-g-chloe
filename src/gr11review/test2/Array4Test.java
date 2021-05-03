package gr11review.test2;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import gr11review.part2.Utility;
import java.io.*;

public class Array4Test {

    
    /**
     * Test general access to the file
     */
    @Test
    void testSignature() throws IOException{
        assertTrue(!(Utility.canBalance(new int[]{})));
    }


    @Test
    void test1(){
        assertTrue((Utility.canBalance(new int[]{1, 1, 1, 2, 1})));
    }

    @Test
    void test2(){
        assertTrue(!(Utility.canBalance(new int[]{2, 1, 1, 2, 1})));
    }

    @Test
    void test3(){
        assertTrue((Utility.canBalance(new int[]{10, 10})));
    }

    @Test
    void test4(){
        assertTrue(!(Utility.canBalance(new int[]{1})));
    }
}


