class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftSum=0;
        int total=0;

        for(int x:nums){
            total+=x;
        }
        int rightSum;
        for(int i =0;i<n;i++){
            
            if(i==0){
                leftSum=0;
                rightSum=total-leftSum-nums[i];
                if(rightSum==leftSum){
                    return i;
                }
            }else{
                leftSum+=nums[i-1];
                rightSum=total-leftSum-nums[i];
                if(rightSum==leftSum){
                    return i;
                }
            }
            

        }
        return -1;
        
    }
}