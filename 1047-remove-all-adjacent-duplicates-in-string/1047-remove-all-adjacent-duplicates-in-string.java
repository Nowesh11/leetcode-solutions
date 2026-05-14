class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(char c : s.toCharArray()){

            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        for(char c : stack){
            res.append(c);
        }
        return res.toString();
        
    }
}