class Solution {

    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(n);
        visited[n] = true;
        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            level++;

            for (int j = 0; j < size; j++) {
                int curr = queue.poll();

                for (int i = 1; i * i <=curr; i++) {
                    int next = curr - i * i;

                    if (next == 0)
                        return level;

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return level;
    }
}
