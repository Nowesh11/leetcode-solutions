class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh =0;
        for(int i =0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int minutes=0;

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rotted = false;

            for(int i =0;i<size;i++){
                
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] dir : direction){

                    int nr = r + dir[0];
                    int nc = c + dir[1];


                    if(nr>=0 && nr< rows && nc>=0 && nc < cols && grid[nr][nc]==1){

                        grid[nr][nc]=2;//make it rot
                        queue.offer(new int[]{nr,nc});
                        fresh--;
                        rotted=true;
                    }
                }
            }
            if(rotted){
                minutes++;
            }
        }
        return fresh==0?minutes:-1;
    }
}