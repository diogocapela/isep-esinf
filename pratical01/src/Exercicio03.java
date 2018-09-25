public class Exercicio03 {

    public static void main(String[] args) {
        int number = greatestCommonDivisor(48, 30);
        System.out.println(number);
    }

    public static int greatestCommonDivisor(int maior, int menor) {
        int resto = maior % menor;
        if(resto == 0) return menor;
        return greatestCommonDivisor(menor, resto);
    }
}
