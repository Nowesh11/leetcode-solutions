class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length +1];

        for(int n :nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int key : map.keySet()){

            int freq = map.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<Integer>();
            }
            buckets[freq].add(key);
        }

        int[] res = new int[k];
        int count =0;

        for(int i =nums.length;i>=0 && count<k;i--){
            if(buckets[i] != null){
                for(int n : buckets[i]){
                    res[count++] = n;
                }
            }
        }
        return res;
        
    }
}