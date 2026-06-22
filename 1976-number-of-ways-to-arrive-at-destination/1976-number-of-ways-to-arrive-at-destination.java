import java.util.*;

class Solution {

    private static final long INF = Long.MAX_VALUE;
    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {

        List<long[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph[u].add(new long[]{v, time});
            graph[v].add(new long[]{u, time});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        long[] ways = new long[n];

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();

            int node = (int) cur[0];
            long d = cur[1];

            if (d > dist[node]) continue;

            for (long[] next : graph[node]) {

                int neigh = (int) next[0];
                long weight = next[1];

                long newDist = d + weight;

                if (newDist < dist[neigh]) {

                    dist[neigh] = newDist;
                    ways[neigh] = ways[node];

                    pq.offer(new long[]{neigh, newDist});
                }
                else if (newDist == dist[neigh]) {

                    ways[neigh] =
                            (ways[neigh] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}