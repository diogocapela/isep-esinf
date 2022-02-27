package esinf;

/**
 *
 * @author DEI-ESINF
 */
public class Labirinth {

    /**
     *
     * @param actual the labirinth in its actual (marked) form
     * @param y coordinate y in the labirinth
     * @param x coordinate x in the labirinth
     * @return the marked labirinth or null if there is no way
     */
    public static int[][] check(int[][] grid, int row, int column) {

        int[][] result;
        if (isPath(grid, row, column)) {

            grid[row][column] = 9;  // cell has been tried

            if (row == grid.length - 1 && column == grid[0].length - 1) {
                return grid;
            }
            result = check(grid, row, column + 1);  // right

            if (result != null) {
                return result;
            }
            result = check(grid, row - 1, column);  // up

            if (result != null) {
                return result;
            }

            result = check(grid, row + 1, column);  // down
            if (result != null) {
                return result;
            }

            result = check(grid, row, column - 1);  // left

            if (result != null) {
                return result;
            }
            grid[row][column] = 2;

        }

        return null;

    }

    private static boolean isPath(int[][] grid, int row, int column) {

        if (row >= 0 && row < grid.length
                && column >= 0 && column < grid[0].length) {
            if (grid[row][column] == 1) {
                return true;
            }
        }
        return false;

    }

}
