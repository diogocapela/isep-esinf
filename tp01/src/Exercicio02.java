public class Exercicio02 {

    public static void main(String[] args) {

    }

    public static boolean isPalindrome(String word) {
        if(word.length() < 2) return true;
        if(word.charAt(0) != word.charAt(word.length() - 1 )) return false;
        return isPalindrome(word.substring(1, word.length() - 1));
    }

    public static boolean isPalindromeWithNumbers(int number) {
        if(number < 10) return true;
        return number == resverseNumber(number, 0);
    }


    public static int resverseNumber(int initNumber, int reverseNumber) {
        if(initNumber <= 0) return reverseNumber;
        int lastDigit = initNumber % 10;
        reverseNumber = (reverseNumber * 10) + lastDigit;
        return resverseNumber(initNumber / 10, reverseNumber);
    }

}
