class Solution {

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] f : flights){
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> a[0] - b[0]);

        // cost, node, stops
        pq.offer(new int[]{0, src, 0});

        // best[node] = minimum stops used so far
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        while(!pq.isEmpty()){

            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int stops = curr[2];

            if(node == dst){
                return cost;
            }

            if(stops > k || stops >= best[node]){
                continue;
            }

            best[node] = stops;

            for(int[] next : graph.get(node)){

                int nextNode = next[0];
                int nextPrice = next[1];

                pq.offer(new int[]{
                    cost + nextPrice,
                    nextNode,
                    stops + 1
                });
            }
        }

        return -1;
    }
}