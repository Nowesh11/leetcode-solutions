class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums,right) -count(nums,left-1);
    }
    public int count(int[] nums,int bound){
        int current = 0;
        int total =0;

        for(int num:nums){
            if(num<=bound){
                current++;
            }else{
                current=0;
            }
            total+=current;
        }
        return total;
    }

}