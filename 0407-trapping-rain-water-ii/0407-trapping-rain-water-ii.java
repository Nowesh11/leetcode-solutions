class Solution {
    //up/down/left/right
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        for(int i =0;i<row;i++){
            pq.offer(new int[]{i,0,heightMap[i][0]});
            visited[i][0]=true;
            pq.offer(new int[]{i,col-1,heightMap[i][col-1]});
            visited[i][col-1]=true;
        }
        for(int j =0;j<col;j++){
            pq.offer(new int[]{0,j,heightMap[0][j]});
            visited[0][j]=true;
            pq.offer(new int[]{row-1,j,heightMap[row-1][j]});
            visited[row-1][j]=true;
        }
        int water =0;
        while(!pq.isEmpty()){
            
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int height = curr[2];

            for(int[] dir : dirs){

                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr>=0 && nr<row && nc>=0 && nc<col && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    water+= Math.max(0,height - heightMap[nr][nc]);
                    pq.offer(new int[]{nr,nc,Math.max(height,heightMap[nr][nc])});
                }
            }

        }






        return water;
        
    }
}