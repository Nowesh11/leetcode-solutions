class Solution {
    String word;
    public boolean exist(char[][] board, String word) {
        this.word = word;
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j] == word.charAt(0)){

                    if(backtrack(i,j,visited,board,0)){
                        return true;
                    }

                }
            }
        }
        return false;
        
    }

    public boolean backtrack(int row, int col, boolean[][] visited, char[][] board, int index){
        if(index == word.length()){
            return true;
        }

        if(row < 0 || row >= board.length ||
           col < 0 || col >= board[0].length)
            return false;

        if(board[row][col] != word.charAt(index)){
            return false;
        }
        if(visited[row][col]){
            return false;
        }

        visited[row][col] = true;

        boolean found = backtrack(row+1,col,visited,board,index+1) || backtrack(row-1,col,visited,board,index+1) || backtrack(row,col +1,visited,board,index+1) || backtrack(row,col-1,visited,board,index+1);

        visited[row][col]=false;

        return found;

    }
}