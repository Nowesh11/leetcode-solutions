class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int n = num.length();
        if(k==n)return "0";

        for(int i =0;i<n;i++){

            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
        }
        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            char c = stack.pop();
            sb.append(c);

        }
        sb.reverse();
        while(sb.length() >1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
        
    }
}