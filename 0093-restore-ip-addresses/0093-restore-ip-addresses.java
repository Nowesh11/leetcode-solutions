class Solution {
    List<String> res = new ArrayList<>();
    String s;
    public List<String> restoreIpAddresses(String s) {
        this.s =s;
        if(s.length() == 0)return res;
        backtrack(0,new ArrayList<>());
        return res;
        
    }

    private void backtrack(int index, List<String> parts){

        if(parts.size() == 4 ){

            if(index == s.length()){
                res.add(String.join(".",parts));
            }
            return;
        }

        for(int len =1;len <= 3; len++){

            if(index + len > s.length())break;

            String segment = s.substring(index,index + len);

            if(isValid(segment)){
                parts.add(segment);
                backtrack(index + len, parts);
                parts.remove(parts.size() - 1);
            }
        }
    }

    private boolean isValid(String segment){

        if(segment.length() > 1 && segment.charAt(0) == '0')return false;

        int val = Integer.parseInt(segment);

        return val >= 0 && val <= 255;
    }
}