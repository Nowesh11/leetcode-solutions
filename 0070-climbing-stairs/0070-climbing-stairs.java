// class Solution {
//     public int climbStairs(int n) {

//         int[] memo = new int[n+1];

//         return dp(n,memo);
        
//     }
//     public int dp(int n, int[] memo){
//         if(n == 1 || n== 2)return n;

//         if(memo[n] != 0)return memo[n];

//         memo[n] = dp(n-1,memo) + dp(n-2,memo);

//         return memo[n];

//     }
// }

class Solution {
    public int climbStairs(int n) {

        if(n<= 2)return n;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i =3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
        
    }
  
}