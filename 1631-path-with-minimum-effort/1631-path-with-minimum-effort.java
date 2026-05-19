class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b)->a[2]-b[2]);

        int[][] effort = new int[n][m];

        // FIX 1
        for(int[] row : effort){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.offer(new int[]{0,0,0});

        effort[0][0] = 0;

        while(!pq.isEmpty()){

            int[] curr = pq.poll();

            int row = curr[0];
            int col = curr[1];
            int val = curr[2];

            // reached end
            if(row == n-1 && col == m-1){
                return val;
            }

            for(int[] dir : dirs){

                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if(nrow >= 0 && nrow < n &&
                   ncol >= 0 && ncol < m){

                    // FIX 2
                    int diff = Math.abs(
                        heights[nrow][ncol] - heights[row][col]
                    );

                    int newVal = Math.max(val, diff);

                    if(newVal < effort[nrow][ncol]){

                        effort[nrow][ncol] = newVal;

                        pq.offer(new int[]{
                            nrow,
                            ncol,
                            newVal
                        });
                    }
                }
            }
        }

        return 0;
    }
}