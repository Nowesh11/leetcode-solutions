class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int island =0;

        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i,j,grid,visited);
                    island++;
                }
            }
        }
        return island;
        
    }

    public void dfs(int i,int j ,char[][] arr,boolean[][] visited){
        visited[i][j] = true;

        for(int[] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(nr>=0 && nr< arr.length && nc>=0 && nc < arr[0].length && !visited[nr][nc] && arr[nr][nc] != '0'){
                dfs(nr,nc,arr,visited);
            }
        }
    }
}