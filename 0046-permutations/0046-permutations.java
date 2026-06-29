class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        backtrack(new ArrayList<>(), nums);

        return result;
        
    }

    public void backtrack(List<Integer> current, int[] nums){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int num : nums){

            if(current.contains(num)){
                continue;
            }
            current.add(num);

            backtrack(current,nums);

            current.remove(current.size() -1);
        }
    }
}