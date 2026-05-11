class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);

        while(low < high){

            int mid = low + (high - low)/2;

            int hoursNeeded = calculate(piles,mid);

            if(hoursNeeded > h){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
        
    }
    public int calculate(int[] piles,int mid){
        int hour=0;
        

        for(int b : piles){

            hour+=(int)Math.ceil((double)b/mid);

        }
        return hour;
    }

    public int getMax(int[] arr){
        int max=0;

        for(int b : arr){
            max=Math.max(max,b);

        }
        return max;
    }
}