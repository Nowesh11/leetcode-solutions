class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> map.get(b) -map.get(a));
        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char c = pq.poll();
            sb.append(c);
            map.put(c,map.get(c)-1);

            while(map.get(c) != 0){
                sb.append(c);
                map.put(c, map.get(c) - 1);
            }
        }
        return sb.toString();
        
    }
}