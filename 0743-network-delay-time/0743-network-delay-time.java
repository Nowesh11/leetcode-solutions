class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i =0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] t : times ){
            graph.get(t[0]).add(new int[]{t[1],t[2]});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] =0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            for(int[] next : graph.get(node)){
                int nextnode = next[0];
                int nexttime = next[1];

                if(time + nexttime < dist[nextnode]){
                    dist[nextnode] = time + nexttime;
                    pq.add(new int[]{nextnode,dist[nextnode]});
                }
            }
        }
        int ans =0;

        for(int i =1;i<=n;i++){

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans,dist[i]);
        }

        return ans;
        
    }
}