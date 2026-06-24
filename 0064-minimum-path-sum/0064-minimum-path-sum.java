class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        // first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // rest of grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}

// class Solution {

//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;

//         int[][] memo = new int[m][n];

//         // fill with -1 (uncomputed)
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 memo[i][j] = -1;
//             }
//         }

//         return dfs(m - 1, n - 1, grid, memo);
//     }

//     private int dfs(int i, int j, int[][] grid, int[][] memo) {

//         // out of bounds
//         if (i < 0 || j < 0) {
//             return Integer.MAX_VALUE;
//         }

//         // start cell
//         if (i == 0 && j == 0) {
//             return grid[0][0];
//         }

//         // already computed
//         if (memo[i][j] != -1) {
//             return memo[i][j];
//         }

//         int up = dfs(i - 1, j, grid, memo);
//         int left = dfs(i, j - 1, grid, memo);

//         memo[i][j] = Math.min(up, left) + grid[i][j];

//         return memo[i][j];
//     }
// }