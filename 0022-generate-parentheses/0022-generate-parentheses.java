class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0)return res;

        backtrack(n,0,0,"");

        return res;
        
    }

    private void backtrack(int n, int open, int close, String str){

        if(str.length() == (2*n)){
            res.add(new String(str));
            return;
        }

        if(open < n){
            backtrack(n,open+1,close,str + "(");
        }

        if(close < open){
            backtrack(n,open,close+1,str + ")");
        }
    }
}