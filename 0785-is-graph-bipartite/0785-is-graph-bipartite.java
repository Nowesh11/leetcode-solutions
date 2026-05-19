class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];//blue/red/no color = -1,1,0

        for(int i =0;i<n;i++){

            if(color[i] == 0){

                if(!dfs(color,graph,i,1))return false;
            }
        }
        return true;
        
        
    }
    public boolean dfs(int[] color ,int[][] graph, int node,int colors){

        color[node] = colors;

        for(int n : graph[node]){

            if(color[n]== colors){
                return false;
                
            }
            if(color[n] == 0){
                if(!dfs(color,graph,n,-colors)){
                    return false;
                }
            }
        }
        return true;
    }
}