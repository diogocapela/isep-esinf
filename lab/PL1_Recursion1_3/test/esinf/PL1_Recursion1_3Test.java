package esinf;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose
 */
public class PL1_Recursion1_3Test {

    public PL1_Recursion1_3Test() {
    }

    @Test
    public void exercice1A_ReturnSameStringTest() {
        String data = "valueToCompare";

        String result = PL1_Recursion1_3.exercice1A_ReturnSameString(data);
        assertEquals(data, result);
        assertNotEquals("valueToCompere", result);

    }

    @Test
    public void exercice1B_ReturnReverseStringTest() {
        String data = "valueToCompare";
        String expectedData = "erapmoCoTeulav";

        String result = PL1_Recursion1_3.exercice1B_ReturnReverseString(data);
        assertEquals(expectedData, result);

    }

    @Test
    public void exercice2_CheckIsPalindromeTest() {

        assertTrue(PL1_Recursion1_3.exercice2_CheckIsPalindrome(1001));
        assertTrue(PL1_Recursion1_3.exercice2_CheckIsPalindrome(1045401));
        assertFalse(PL1_Recursion1_3.exercice2_CheckIsPalindrome(10012));

    }

    @Test
    public void exercice3_GetGreatestCommonDivisorTest() {

        assertEquals(PL1_Recursion1_3.exercice3_GetGreatestCommonDivisor(48, 30), 6);
        assertNotEquals(PL1_Recursion1_3.exercice3_GetGreatestCommonDivisor(48, 31), 6);
        assertEquals(PL1_Recursion1_3.exercice3_GetGreatestCommonDivisor(50, 25), 25);
        assertEquals(PL1_Recursion1_3.exercice3_GetGreatestCommonDivisor(27, 48), 3);

    }

}
