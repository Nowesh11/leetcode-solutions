class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.size();
        int[][] dist = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){

                if(grid.get(i).get(j) == 1){
                    queue.offer(new int[]{i,j});
                    dist[i][j] = 0;
                    visited[i][j] = true;
                }else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                int[] curr = queue.poll();

                for(int[] dir : dirs){
                    int r = curr[0]+ dir[0];
                    int c = curr[1]+ dir[1];

                    if(r>=0 && r<n && c>=0 && c<n && dist[r][c] == Integer.MAX_VALUE && !visited[r][c]){
                        dist[r][c] = dist[curr[0]][curr[1]] + 1;
                        visited[r][c] = true;
                        queue.offer(new int[]{r,c});
                    }
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] -a[2]);
        pq.offer(new int[]{0,0,dist[0][0]});
        boolean[][] vis = new boolean[n][n];
        vis[0][0]=true;

        while(!pq.isEmpty()){

            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int safe = current[2];

            if(x==n-1 && y == n-1){
                return safe;
            }
            
            for(int[] direc : dirs){
                int nx = x + direc[0];
                int ny = y + direc[1];

                if(nx>=0 && nx<n && ny>=0 && ny<n && !vis[nx][ny]){
                    vis[nx][ny]=true;
                    int newSafe = Math.min(safe,dist[nx][ny]);
                    pq.offer(new int[]{nx,ny,newSafe});
                }
            }
        }
        return 0;

       
    }
}