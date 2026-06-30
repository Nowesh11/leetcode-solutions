class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        nums = candidates;
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), 0, 0);
        return result;
    }
    private void backtrack(List<Integer> current, int index, int sum){
        if(sum > target)return;
        if(sum == target){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < nums.length; i++){

            if(index < i && nums[i] == nums[i-1])continue;
            current.add(nums[i]);
            backtrack(current, i + 1, sum + nums[i]);
            current.remove(current.size() -1);
        }
    }
}