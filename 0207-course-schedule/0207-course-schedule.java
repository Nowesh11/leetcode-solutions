class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] index = new int[numCourses];

        for(int i =0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
            index[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<index.length;i++){

            if(index[i] == 0){
                queue.add(i);
            }
        }
        int count =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i =0;i<size;i++){
                int curr = queue.poll();
                count++;

                for(int next : graph.get(curr)){
                    index[next]--;

                    if(index[next] == 0){
                        queue.offer(next);
                    }
                }
            }
        }
        return count == numCourses;
    }
}