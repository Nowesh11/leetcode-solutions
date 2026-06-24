class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // fill table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}

// class Solution {

//     public int uniquePaths(int m, int n) {
//         int[][] memo = new int[m][n];
//         return dfs(m - 1, n - 1, memo);
//     }

//     private int dfs(int i, int j, int[][] memo) {

//         // out of grid
//         if (i < 0 || j < 0) return 0;

//         // start cell
//         if (i == 0 && j == 0) return 1;

//         // already computed
//         if (memo[i][j] != 0) return memo[i][j];

//         // recursion
//         memo[i][j] = dfs(i - 1, j, memo) + dfs(i, j - 1, memo);

//         return memo[i][j];
//     }
// }