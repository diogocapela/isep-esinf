public class Exercicio01A {

    public static void main(String[] args) {
        String word = retrunString("ISEP");
        System.out.println(word);
    }

    public static String retrunString(String word) {
        if(word.length() == 0) return "";
        return word.charAt(0) + retrunString(word.substring(1));
    }

}
