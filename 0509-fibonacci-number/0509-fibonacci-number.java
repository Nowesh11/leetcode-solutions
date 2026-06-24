class Solution {
    public int fib(int n) {

        
        int[] memo = new int[n+1];
        if(n == 0 || n ==1)return n;
        memo[0] = 0;
        memo[1] = 1;

        return dp(n,memo);
        
    }

    public int dp(int n, int[] memo){
        if(n == 0 || n== 1)return n;

        memo[n] = dp(n-1,memo) + dp(n-2,memo);

        return memo[n];

    }
}