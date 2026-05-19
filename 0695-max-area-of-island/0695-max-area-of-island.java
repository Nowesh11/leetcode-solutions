class Solution {
    
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int max = Integer.MIN_VALUE;

        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    max = Math.max(dfs(i,j,grid,visited),max);
                    
                }
            }
        }
        return max==Integer.MIN_VALUE?0:max;
        

    }

    public int dfs(int i, int j, int[][] arr, boolean[][] visited) {
        
        visited[i][j] = true;
        int area =1;

        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            if (nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length && !visited[nr][nc] && arr[nr][nc] != 0) {
                area += dfs(nr, nc, arr, visited);
            }
        }
        return area;
    }
}