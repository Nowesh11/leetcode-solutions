class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        HashMap<Integer,Integer> dp = new HashMap<>();
        dp.put(0,1);

        for(int num : nums){

            HashMap<Integer,Integer> next = new HashMap<>();

            for(int sum : dp.keySet()){

                int ways = dp.get(sum);

                next.put(sum + num, next.getOrDefault(sum+num,0) + ways);

                next.put(sum -num, next.getOrDefault(sum - num, 0) + ways);

            }
            dp = next;
        }

        return dp.getOrDefault(target, 0);
        
    }
}