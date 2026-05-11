class Solution {
    public int splitArray(int[] nums, int k) {
        int low = getMax(nums);
        int high = getSum(nums);
        int ans = high;

        while(low<=high){

            int mid = low + (high - low)/2;

            if(subArray(nums,k,mid)){
                ans=mid;
                high = mid -1;
            }else{
                low=mid+1;
            }
        }
        return ans;


        
    }
    public int getMax(int[] arr){
        int max=0;

        for(int w : arr){
            max=Math.max(max,w);
        }
        return max;
    }

    public boolean subArray(int[] arr,int k,int mid){
        int subArrayCount=1;
        int curr =0;
        for(int n:arr){

            if(curr + n > mid){
                subArrayCount++;
                curr =0;
            }
            curr+=n;

            if(subArrayCount > k)return false;
        }
        return true;
    }
    public int getSum(int[] arr){
        int sum=0;

        for(int w : arr){
            sum+=w;
        }
        return sum;
    }
}