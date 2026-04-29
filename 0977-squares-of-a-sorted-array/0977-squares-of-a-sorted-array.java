class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int n = nums.length;
        int[] res = new int[n];
        int j =n-1;
        int k = n-1;

        while(i<=j){

            int left= nums[i] * nums[i];
            int right = nums[j] * nums[j];


            if(left > right){

                res[k--] = left;
                i++;
            }else{

                res[k--] = right;
                j--;
            }
        }
        return res;

        
    }

}