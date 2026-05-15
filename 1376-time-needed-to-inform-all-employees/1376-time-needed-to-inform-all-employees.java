class Solution {

    List<List<Integer>> graph = new ArrayList<>();

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(i);
            }
        }

        return dfs(headID, informTime);
    }

    private int dfs(int node, int[] informTime) {

        int maxTime = 0;

        for (int child : graph.get(node)) {
            maxTime = Math.max(maxTime, dfs(child, informTime));
        }

        return informTime[node] + maxTime;
    }
}