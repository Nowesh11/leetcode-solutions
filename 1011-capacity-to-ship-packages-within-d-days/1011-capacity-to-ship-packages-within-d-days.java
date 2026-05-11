class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights);
        int high = getSum(weights);

        while(low < high){
            int mid = low + (high -low)/2;
            

            if(canShip(weights,days,mid)){
                high=mid;
            }else{
                low=mid+1;
            }

            
        }
        return low;
        
    }
    public int getMax(int[] arr){
        int max=0;
        for(int w:arr){
            max=Math.max(max,w);
        }
        return max;
    }
    public int getSum(int[] arr){
        int sum=0;
        for(int w: arr){
            sum+=w;
        }
        return sum;
    }
    public boolean canShip(int[] arr,int days,int mid){
        int daysCount=1;
        int curr =0;

        for(int w : arr){

            if(curr+w > mid){
                daysCount++;
                curr=0;
            }
            if(daysCount > days)return false;

            curr+=w;
        }
        return true;
    }
}