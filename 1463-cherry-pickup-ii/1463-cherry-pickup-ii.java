class Solution {

    private int[][][] dp;
    private int rows, cols;

    public int cherryPickup(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        dp = new int[rows][cols][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(grid, 0, 0, cols - 1);
    }

    private int dfs(int[][] grid, int row, int col1, int col2) {

        // Out of bounds
        if (col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return Integer.MIN_VALUE;
        }

        // Reached the last row
        if (row == rows) {
            return 0;
        }

        // Already computed
        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        // Collect cherries
        int cherries;
        if (col1 == col2) {
            cherries = grid[row][col1];
        } else {
            cherries = grid[row][col1] + grid[row][col2];
        }

        int max = 0;

        // Try all 9 possible moves
        for (int move1 = -1; move1 <= 1; move1++) {
            for (int move2 = -1; move2 <= 1; move2++) {

                max = Math.max(max,
                        dfs(grid,
                            row + 1,
                            col1 + move1,
                            col2 + move2));
            }
        }

        dp[row][col1][col2] = cherries + max;
        return dp[row][col1][col2];
    }
}