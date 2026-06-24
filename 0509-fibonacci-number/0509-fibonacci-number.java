class Solution {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        return dp(n, memo);
    }

    public int dp(int n, int[] memo) {
        if (n == 0 || n == 1) return n;

        if (memo[n] != 0) return memo[n];

        memo[n] = dp(n - 1, memo) + dp(n - 2, memo);
        return memo[n];
    }
}

// class Solution {
//     public int fib(int n) {
//         if (n <= 1) return n;

//         int[] dp = new int[n + 1];
//         dp[0] = 0;
//         dp[1] = 1;

//         for (int i = 2; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }

//         return dp[n];
//     }
// }

// class Solution {
//     public int fib(int n) {
//         if (n <= 1) return n;

//         int a = 0, b = 1;

//         for (int i = 2; i <= n; i++) {
//             int c = a + b;
//             a = b;
//             b = c;
//         }

//         return b;
//     }
// }