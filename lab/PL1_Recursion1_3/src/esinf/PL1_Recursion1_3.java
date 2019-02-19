/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

/**
 *
 * @author jose
 */
public class PL1_Recursion1_3 {

    public static String exercice1A_ReturnSameString(String value) {

        if (value.length() == 0) {
            return "";
        }

        return value.charAt(0) + exercice1A_ReturnSameString(value.substring(1));
    }

    public static String exercice1B_ReturnReverseString(String value) {

        if (value.length() == 0) {
            return "";
        }
        return value.charAt(value.length() - 1) + exercice1B_ReturnReverseString(value.substring(0, value.length() - 1));
    }

    static int reverseInt(int n, int reversedNumber) {
        if (n == 0) {
            return reversedNumber;
        }

        reversedNumber = (reversedNumber * 10) + (n % 10);

        return reverseInt(n / 10, reversedNumber);
    }

    public static boolean exercice2_CheckIsPalindrome(int number) {
        return number == reverseInt(number, 0);
    }

    public static int exercice3_GetGreatestCommonDivisor(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            return getGreatestCommonDivisor(firstNumber, secondNumber);
        }

        return getGreatestCommonDivisor(secondNumber, firstNumber);
    }

    public static int getGreatestCommonDivisor(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return exercice3_GetGreatestCommonDivisor(secondNumber, firstNumber % secondNumber);
    }
}
