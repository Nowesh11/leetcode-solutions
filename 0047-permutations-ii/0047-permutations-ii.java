class Solution {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];

         backtrack(new ArrayList<>(), nums);

        return result;
        
    }

    public void backtrack(List<Integer> current, int[] nums){
        if(current.size() == nums.length && !result.contains(current)){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i =0;i< nums.length;i++){

            if(visited[i])continue;
            
            visited[i] = true;
            current.add(nums[i]);

            backtrack(current,nums);

            current.remove(current.size() -1);
            visited[i] = false;
        }
    }
        
        
    
}