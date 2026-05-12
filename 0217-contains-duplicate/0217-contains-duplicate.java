class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n : nums){

            if(map.containsKey(n))return true;
            else{map.put(n,map.getOrDefault(n,0)+1);}
        }
        return false;
        
    }
}