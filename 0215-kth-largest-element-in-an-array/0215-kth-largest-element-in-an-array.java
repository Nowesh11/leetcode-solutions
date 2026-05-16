class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i =0;i<nums.length;i++){
            min.offer(nums[i]);
            if(min.size() > k){
                min.poll();
            }
        }

        return min.peek();
        
    }
}