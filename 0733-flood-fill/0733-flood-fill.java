class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old = image[sr][sc];
        int n = image.length;
        int m = image[0].length;

        if(color != old)dfs(image,sr,sc,old,color);

        return image;

        
    }
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(int[][] arr,int sr,int sc,int old,int color){
        if(sr <0 || sr >= arr.length || sc<0 || sc >= arr[0].length || arr[sr][sc] != old){
            return;
        }
        arr[sr][sc] = color;

        for(int[] dir : dirs){
            int nsr = sr + dir[0];
            int nsc = sc + dir[1];

            dfs(arr,nsr,nsc,old,color);
        }
        
        
    }
}