class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int n =nums.length;
        int maxL=0;
        int mostFreqZero=0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int right=0;right<n;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            mostFreqZero = map.getOrDefault(0,0);

            if(mostFreqZero > k){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
            maxL=Math.max(maxL,right-left+1);
        }
        return maxL;
        
    }
}