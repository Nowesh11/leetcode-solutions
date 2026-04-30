class Solution {
    public int longestSubarray(int[] nums) {
        int mostFreq=0;
        Map<Integer,Integer> map = new HashMap<>();
        int maxL=Integer.MIN_VALUE;
        int left=0;

        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            mostFreq=map.getOrDefault(0,0);

            while(mostFreq > 1){
                map.put(nums[left],map.get(nums[left])-1);
                if(nums[left]==0)mostFreq--;
                left++;

            }
            maxL=Math.max(maxL,right-left);
        }
        return maxL==Integer.MIN_VALUE?0:maxL;
        
    }
}