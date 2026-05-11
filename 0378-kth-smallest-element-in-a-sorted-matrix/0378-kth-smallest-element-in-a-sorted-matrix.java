class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int ans=0;

        while(low < high){

            int mid = low + (high - low)/2;

            int count = countOrLess(matrix,k,mid);
            if(count >= k){
                high=mid;
            }else{
                low = mid+1;
            }
        }
        return low;
        
    }

    public int countOrLess(int[][] matrix,int k,int mid){
        int n = matrix.length;

        int row=0;
        int coloum = n-1;
        int count=0;

        while(row < n && coloum >=0 ){

            if(matrix[row][coloum] <= mid){
                count+=coloum+1;
                row++;
            }else{
                coloum--;
            }
        }
        return count;
    }
}