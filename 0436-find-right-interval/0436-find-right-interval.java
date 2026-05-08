class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n =intervals.length;
        

        TreeMap<Integer,Integer> map = new TreeMap<>();
        int[] res = new int[n];

        for(int i =0;i<n;i++){
            map.put(intervals[i][0],i);
        }

        for(int i =0;i<n;i++){
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key == null?-1:map.get(key);
        }
        return res;

        

        
        
    }
}