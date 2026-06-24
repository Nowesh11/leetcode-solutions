// class Solution {
//     public int rob(int[] nums) {

//         int n = nums.length;

//         if(n < 2){
//             return nums[0];
//         }
//         int[] dp = new int[n];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0],nums[1]);

//         for(int i =2;i<n;i++){

//             dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
//         }

//         return dp[n-1];
        
//     }
// }

class Solution {

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return dp(n - 1, nums, memo);
    }

    public int dp(int n, int[] nums, int[] memo) {

        if (n == 0) return nums[0];
        if (n == 1) return Math.max(nums[0], nums[1]);

        if (memo[n] != -1) return memo[n];

        memo[n] = Math.max(
            dp(n - 2, nums, memo) + nums[n],
            dp(n - 1, nums, memo)
        );

        return memo[n];
    }
}