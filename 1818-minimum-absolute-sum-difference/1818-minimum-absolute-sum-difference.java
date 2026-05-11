class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long total=0;
        long mod = 1000000007;


        for(int i=0;i<nums1.length;i++){
            total+=Math.abs(nums1[i]-nums2[i]);
        }
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        int low = 0;
        int high = sorted.length-1;
        long currDiff=0;
        long bestDiff=0;
        long gain =0;
        long bestGain=0;

        for(int i =0;i<nums2.length;i++){

            int target = nums2[i];
            currDiff = Math.abs(nums1[i] - target);

            int idx = BinarySearchClosest(sorted,target);

            bestDiff = Math.abs(sorted[idx] - target);

            if(idx +1 < nums1.length){
                bestDiff= Math.min(bestDiff,Math.abs(sorted[idx+1]-target));
            }
            if(idx -1 >=0){
                bestDiff= Math.min(bestDiff,Math.abs(sorted[idx-1]-target));

            }
            gain = currDiff - bestDiff;
            bestGain = Math.max(bestGain,gain);

            
            
        }
        return (int)((total-bestGain) % mod);
        
    }

    public int BinarySearchClosest(int[] arr,int target){
        int low =0;
        int high = arr.length-1;


        while(low < high){
            int mid = low + (high -low)/2;

            if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}