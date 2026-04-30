class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n =nums.length;
        int prev =0;
        int count =0;
        int l =0;
        

        for(int r =0;r<n;r++){
            if(nums[r]>=left && nums[r]<=right){
                prev=r-l+1;
                count+=prev;
            }else if(nums[r]<left){
                count+=prev;

            }
            else{
                prev=0;
                l=r+1;
            }
            
        
        
    }
    return count;
    }
}