class Solution {

    public boolean backspaceCompare(String s, String t) {

        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for(char c : s.toCharArray()){

            if(c == '#'){
                if(!sStack.isEmpty()){
                    sStack.pop();
                }
            } else {
                sStack.push(c);
            }
        }

        for(char c : t.toCharArray()){

            if(c == '#'){
                if(!tStack.isEmpty()){
                    tStack.pop();
                }
            } else {
                tStack.push(c);
            }
        }

        return sStack.equals(tStack);
    }
}