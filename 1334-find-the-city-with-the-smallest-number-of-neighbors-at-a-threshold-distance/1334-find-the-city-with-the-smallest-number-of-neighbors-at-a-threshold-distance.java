class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int city = -1;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int count = dijkstra(i, n, graph, distanceThreshold);

            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }

        return city;
    }

    private int dijkstra(int src, int n,
                         List<List<int[]>> graph,
                         int threshold) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];

            if (cost > dist[node]) continue;

            for (int[] nei : graph.get(node)) {

                int next = nei[0];
                int w = nei[1];

                if (cost + w < dist[next]) {
                    dist[next] = cost + w;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dist[i] <= threshold) {
                count++;
            }
        }

        return count;
    }
}