class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count =0;

        for(int city =0;city < n;city++){

            if(!visited[city]){
                count++;

                dfs(city,visited,isConnected);
            }
        }
        return count;
        
    }
    public void dfs(int city,boolean[] visited,int[][] arr){
        visited[city] = true;

        for(int i =0;i<arr.length;i++){

            if(arr[city][i] == 1 && !visited[i]){
                dfs(i,visited,arr);
            }
        }
    }
}