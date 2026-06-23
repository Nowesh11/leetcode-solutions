class Solution {
    public int jump(int[] nums) {
        int maxJump = 0;
        int totalJump = 0;
        int lastIndex = 0;

        if(nums.length == 1) return 0;

        for(int i = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);

            if(i == lastIndex) {
                totalJump++;
                lastIndex = maxJump;
            }
        }

        return totalJump;
    }
}