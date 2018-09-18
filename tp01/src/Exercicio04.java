public class Exercicio04 {

    public static void main(String[] args) {
        int[][] map = {
            {1,1,1,1,1,0,1,1,0,0,1,1},
            {1,0,0,0,1,0,1,1,1,1,1,0},
            {1,0,1,0,1,1,1,0,0,0,1,0},
            {1,1,1,0,1,0,1,1,1,1,1,1},
        };
        int[][] discoveredMap = findRoute(map, 0, 0);
        printMatrix(discoveredMap);
    }

    public static int[][] findRoute(int[][] map, int x, int y) {
        // verificar os 4 lados


        // caso esteja out of bounds - return false;

        // caso seja um 0 - return false

        return map;
    }








    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
