class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int low = 0;
        int minLen = Integer.MAX_VALUE;
        int bestStart = 0;

        for(int high = 0; high < s.length(); high++){

            char r = s.charAt(high);
            window.put(r, window.getOrDefault(r, 0) + 1);

            while(isContain(window, need)){

                // update answer BEFORE shrinking
                if(high - low + 1 < minLen){
                    minLen = high - low + 1;
                    bestStart = low;
                }

                char l = s.charAt(low);
                window.put(l, window.get(l) - 1);

                low++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" :
               s.substring(bestStart, bestStart + minLen);
    }

    public boolean isContain(HashMap<Character,Integer> window,
                             HashMap<Character,Integer> need){

        for(char c : need.keySet()){
            if(window.getOrDefault(c,0) < need.get(c))
                return false;
        }
        return true;
    }
}