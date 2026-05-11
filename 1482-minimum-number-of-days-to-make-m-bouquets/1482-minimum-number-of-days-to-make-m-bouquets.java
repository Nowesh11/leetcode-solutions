class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = getMin(bloomDay);
        int high = getMax(bloomDay);

        if((long)m*k > bloomDay.length)return -1;
        int ans=0;

        while(low < high){
            int mid = low + (high - low)/2;

            if(makeBouquet(bloomDay,m,k,mid)){
                
                high=mid;
            }else{
                low=mid+1;
            }

        }
        return low;
        
    }
    public boolean makeBouquet(int[] arr,int bouquet,int flower,int mid){
        int bouquetCount=0;
        int flowerCount=0;

        for(int f : arr){

            if(f <= mid){
                flowerCount++;
            }else{
                flowerCount=0;
            }

            if(flowerCount==flower){
                bouquetCount++;
                flowerCount=0;
            }

            if(bouquetCount >= bouquet)return true;


        }
        return false;
        
    }
    public int getMax(int[] arr){
        int max=0;
        for(int b : arr){
            max=Math.max(max,b);
        }
        return max;
    }
    public int getMin(int[] arr){
        int min= Integer.MAX_VALUE;
        for(int b : arr){
            min=Math.min(min,b);
        }
        return min;
    }
}