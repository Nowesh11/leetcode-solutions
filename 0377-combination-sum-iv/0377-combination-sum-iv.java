class Solution {
    int[] dp;
    int[] nums;

    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        dp = new int[target + 1];

        Arrays.fill(dp, -1);

        return dfs(target);
    }

    private int dfs(int remain) {
        if (remain < 0) return 0;
        if (remain == 0) return 1;

        if (dp[remain] != -1)
            return dp[remain];

        int total = 0;

        for (int num : nums) {
            total += dfs(remain - num);
        }

        dp[remain] = total;
        return total;
    }
}