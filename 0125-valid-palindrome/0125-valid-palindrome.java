class Solution {
    public boolean isPalindrome(String s) {

        String res = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        

        int left = 0;
        int right= res.length()-1;
        

        while(left<=right){

            if(res.charAt(left)!=res.charAt(right))return false;
            left++;
            right--;



            
        }
        return true;

        
    }
    
}