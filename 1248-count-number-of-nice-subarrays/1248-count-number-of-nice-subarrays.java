class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int right =0;
        int left =0;
        int count =0;
        int result=0;
        int temp=0;

        while(right<nums.length){
            if(nums[right] % 2 !=0){
                count++;
                temp=0;
            }

            while(count==k){
                temp++;
                if(nums[left] % 2==1){
                    count--;
                    
                }
                left++;

            }
            result+=temp;
            right++;
        }






        return result;
        
    }

   
}