class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        int[] indegree = new int[numCourses];

        // Create graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph + indegree
        for (int[] sub : prerequisites) {

            int course = sub[0];
            int pre = sub[1];

            graph.get(pre).add(course);

            indegree[course]++;
        }

        // Add all indegree 0 courses
        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // BFS
        while (!queue.isEmpty()) {

            int curr = queue.poll();

            res.add(curr);

            for (int next : graph.get(curr)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // Cycle check
        if (res.size() != numCourses) {
            return new int[0];
        }

        // Convert List<Integer> -> int[]
        int[] ans = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}