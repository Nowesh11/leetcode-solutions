class Solution {
    public void sortColors(int[] nums) {

        int i = 0;
        int j = nums.length-1;
        int m = 0;



        while(m<=j){

            if(nums[m] == 0){
                int temp = nums[m];
                nums[m] =nums[i];
                nums[i] =temp;

                m++;
                i++;
            }else if(nums[m] == 1){
                m++;
            }else{

                int temp = nums[m];
                nums[m] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
    }
}