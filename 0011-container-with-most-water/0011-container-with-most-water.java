class Solution {
    public int maxArea(int[] height) {
        int mArea =0;
        int cArea=0;
        int i = 0;
        int j = height.length -1;


        while(i<j){

            int minHeight = Math.min(height[i],height[j]);
            cArea = minHeight * (j-i);
            mArea = Math.max(mArea,cArea);

            if(height[i] < height[j]){

                i++;
            }else{

                j--;
            }

        }
        return mArea;
        
    }
}