
public class Labyrinth {

    public static void main(String[] args) {

        int[][] grid = {
            {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        printGrid(grid);

        printGrid(solve(grid, 0, 0));

    }

    public static void printGrid(int[][] grid) {

        System.out.println();

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                System.out.print(grid[row][column]);
            }
            System.out.println();
        }

        System.out.println();

    }

    public static int[][] solve(int[][] grid, int row, int column) {

        int[][] result;
        if (isPath(grid, row, column)) {

            grid[row][column] = 9;  // cell has been tried

            if (row == grid.length - 1 && column == grid[0].length - 1) {
                return grid;
            }
            result = solve(grid, row, column + 1);  // right

            if (result != null) {
                return result;
            }
            result = solve(grid, row - 1, column);  // up

            if (result != null) {
                return result;
            }

            result = solve(grid, row + 1, column);  // down
            if (result != null) {
                return result;
            }

            result = solve(grid, row, column - 1);  // left

            if (result != null) {
                return result;
            }
            grid[row][column] = 2;

        }

        return null;

    }

    private static boolean isPath(int[][] grid, int row, int column) {

        boolean result = false;

        if (row >= 0 && row < grid.length
                && column >= 0 && column < grid[0].length) {
            if (grid[row][column] == 1) {
                result = true;
            }
        }

        return result;

    }

}
