import java.util.*;

class Solution {

    List<List<String>> result = new ArrayList<>();

    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> antiDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }

        backtrack(0, board, n);

        return result;
    }

    private void backtrack(int row, char[][] board, int n){

        // Found one solution
        if(row == n){

            List<String> solution = new ArrayList<>();

            for(char[] r : board){
                solution.add(new String(r));
            }

            result.add(solution);
            return;
        }

        // Try every column
        for(int col = 0; col < n; col++){

            // Check if safe
            if(cols.contains(col) ||
               diag.contains(row-col) ||
               antiDiag.contains(row+col))
                continue;

            // Place queen
            board[row][col] = 'Q';

            cols.add(col);
            diag.add(row-col);
            antiDiag.add(row+col);

            // Next row
            backtrack(row+1, board, n);

            // Backtrack
            board[row][col] = '.';

            cols.remove(col);
            diag.remove(row-col);
            antiDiag.remove(row+col);
        }
    }
}