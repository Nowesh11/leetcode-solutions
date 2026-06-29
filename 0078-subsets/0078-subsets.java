class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        backtrack(new ArrayList<>(), nums, 0);

        return result;
        
    }
    public void backtrack(List<Integer> current, int[] nums, int index){
        result.add(new ArrayList<>(current));

        for(int i = index;i<nums.length;i++){
            current.add(nums[i]);

            backtrack(current, nums, i + 1);

            current.remove(current.size() -1);
        }
    }
}