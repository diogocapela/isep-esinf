public class Exercicio04 {

    public static void main(String[] args) {
        int[][] map = {
                { 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };
        int[][] discoveredMap = findRoute(map, 0, 0);
        printMatrix(discoveredMap);
    }

    public static int[][] findRoute(int[][] map, int x, int y) {

        // Place 9 on Arrival
        map[y][x] = 9;

        printMatrix(map);
        System.out.println("----------------------------------------------------");

        // Winning Condition
        if(y == map.length -1 && x == map[y].length - 1) {
            return map;
        }

        // Go TOP
        if(y - 1 >= 0 && map[y - 1][x] == 1) {
            if(findRoute(map, x, y - 1) != null) return map;
        }

        // Go RIGHT
        if(x + 1 < map[y].length && map[y][x + 1] == 1) {
            if(findRoute(map, x + 1, y) != null) return map;
        }

        // Go BOTTOM
        if(y + 1 < map.length && map[y + 1][x] == 1) {
            if(findRoute(map, x, y + 1) != null) return map;
        }

        // Go LEFT
        if(x - 1 >= 0 && map[y][x - 1] == 1) {
            if(findRoute(map, x - 1, y) != null) return map;
        }

        // Back-tracking
        map[y][x] = 2;
        return null;
    }


    public static int[][] findRouteOLDVERSIOn(int[][] map, int x, int y) {

        // Place 9 on Arrival
        map[y][x] = 9;

        printMatrix(map);
        System.out.println("----------------------------------------------------");

        // Winning Condition
        if(y == map.length -1 && x == map[y].length - 1) {
            return map;
        }

        // Go TOP
        if(y - 1 >= 0 && map[y - 1][x] == 1) {
            int[][] result = findRoute(map, x, y - 1);
            if(result != null) return result;
        }

        // Go RIGHT
        if(x + 1 < map[y].length && map[y][x + 1] == 1) {
            int[][] result = findRoute(map, x + 1, y);
            if(result != null) return result;
        }


        // Go BOTTOM
        if(y + 1 < map.length && map[y + 1][x] == 1) {
            int[][] result = findRoute(map, x, y + 1);
            if(result != null) return result;
        }

        // Go LEFT
        if(x - 1 >= 0 && map[y][x - 1] == 1) {
            int[][] result = findRoute(map, x - 1, y);
            if(result != null) return result;
        }

        // Back-tracking
        map[y][x] = 2;
        return null;
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
