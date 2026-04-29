class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left =0;
        int n =nums.length;
        int max=0;
        int current=0;
        Set<Integer> set = new HashSet<>();

        for(int right =0;right<n;right++){

            while(set.contains(nums[right])){
                set.remove(nums[left]);
                current-=nums[left];
                left++;
            }
            current+=nums[right];
            set.add(nums[right]);
            max=Math.max(max,current);
        }
        return max;
        
    }
}