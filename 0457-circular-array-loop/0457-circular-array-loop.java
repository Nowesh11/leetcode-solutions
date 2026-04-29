class Solution {
    public boolean circularArrayLoop(int[] nums) {

        int n = nums.length;
        if(n<=1)return false;
        
        for(int i = 0;i<n;i++){

            boolean forward = nums[i] > 0;

            int slow = i;
            int fast =i;

            while(true){

                slow = getNextIndex(nums,slow,forward);
                if(slow == -1)break;

                fast = getNextIndex(nums,fast,forward);
                if(fast == -1)break;

                fast = getNextIndex(nums,fast,forward);
                if(fast == -1)break;


                if(fast == slow)return true;
            }
            
        }
        return false;
        
    }

    public int getNextIndex(int nums[] , int index,boolean direction){
        boolean currentDirection = nums[index] >0;

        if(currentDirection != direction) return -1;

        int nextIndex = (index + nums[index])%nums.length;

        if(nextIndex < 0){
            nextIndex+=nums.length;
        }
        if(nextIndex == index)return -1;

        return nextIndex;
    }
}