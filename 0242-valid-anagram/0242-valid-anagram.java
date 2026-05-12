class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        if(s.length() != t.length())return false;

        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i =0;i<t.length();i++){
            char c = t.charAt(i);

            if(!map.containsKey(c))return false;
            else{
                map.put(c,map.getOrDefault(c,0)-1);
            }
        }
        for(char c : map.keySet()){
            if(map.get(c) != 0)return false;
        }
        return true;
        
    }
}