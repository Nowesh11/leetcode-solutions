import java.util.*;

class Solution {
    static class State {
        int city;
        int time;
        int cost;

        State(int city, int time, int cost) {
            this.city = city;
            this.time = time;
            this.cost = cost;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int t = e[2];

            graph[u].add(new int[]{v, t});
            graph[v].add(new int[]{u, t});
        }

        int[][] dp = new int[n][maxTime + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = passingFees[0];

        PriorityQueue<State> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.offer(new State(0, 0, passingFees[0]));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            int city = cur.city;
            int time = cur.time;
            int cost = cur.cost;

            if (city == n - 1) {
                return cost;
            }

            if (cost > dp[city][time]) {
                continue;
            }

            for (int[] next : graph[city]) {
                int nextCity = next[0];
                int travelTime = next[1];

                int newTime = time + travelTime;

                if (newTime > maxTime) {
                    continue;
                }

                int newCost = cost + passingFees[nextCity];

                if (newCost < dp[nextCity][newTime]) {
                    dp[nextCity][newTime] = newCost;

                    pq.offer(new State(
                            nextCity,
                            newTime,
                            newCost
                    ));
                }
            }
        }

        return -1;
    }
}