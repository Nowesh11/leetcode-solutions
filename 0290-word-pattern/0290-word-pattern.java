class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length)return false;

        for(int i =0;i<arr.length;i++){
            char c = pattern.charAt(i);
            String st = arr[i];

            if(!map.containsKey(c)){
                if(!map.containsValue(st)){
                    map.put(c,st);
                }else{
                    return false;
                }
            }else{
                String str = map.get(c);
                if(!str.equals(st)){
                    return false;
                }
            }
        }
        return true;
        
    }
}