package main.java.com.practice.dsa.graphs;

public class NumberOfIsland {

    public static int noOfIsland(char[][] grid) {
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int row, int col) {

        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0) {
            return;
        }

        if(grid[row][col] == '0') return;

        grid[row][col] = '0';

        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
    }

    static void main() {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int result = noOfIsland(grid);

        System.out.println("Number of islands: " + result);
    }
}
