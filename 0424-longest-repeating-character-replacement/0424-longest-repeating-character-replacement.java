class Solution {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int right =0;
        int left = 0;
        int n = arr.length;
        int max=0;
        int mostFreq=0;

        while(right< n){
            //expand the window first
            map.put(arr[right],map.getOrDefault(arr[right],0) +1);
            mostFreq = Math.max(mostFreq,map.get(arr[right]));


            if(right-left+1 -mostFreq > k){
                map.put(arr[left],map.get(arr[left])-1);
                left++;
            }

            max=Math.max(max,right-left+1);
            
            
            
            
            right++;


        }
        return max;
    }
    
}