public class Exercicio01B {

    public static void main(String[] args) {
        String word = invertString("ISEP");
        System.out.println(word);
    }

    public static String invertString(String word) {
        if(word.length() == 0) return "";
        return word.charAt(word.length() - 1) + invertString(word.substring(0, word.length() - 1));
    }

}
