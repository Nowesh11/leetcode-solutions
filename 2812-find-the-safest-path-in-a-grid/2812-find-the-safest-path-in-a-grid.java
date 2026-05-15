class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        // STEP 1: multi-source BFS to compute dist
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            for (int[] d : dirs) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if (x >= 0 && y >= 0 && x < n && y < n && dist[x][y] == -1) {
                    dist[x][y] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }

        // STEP 2: Dijkstra (max heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[2] - a[2]   // max safeness first
        );

        boolean[][] vis = new boolean[n][n];

        pq.offer(new int[]{0, 0, dist[0][0]});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], safe = cur[2];

            if (x == n-1 && y == n-1) {
                return safe;
            }

            if (vis[x][y]) continue;
            vis[x][y] = true;

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !vis[nx][ny]) {

                    int newSafe = Math.min(safe, dist[nx][ny]);

                    pq.offer(new int[]{nx, ny, newSafe});
                }
            }
        }

        return 0;
    }
}