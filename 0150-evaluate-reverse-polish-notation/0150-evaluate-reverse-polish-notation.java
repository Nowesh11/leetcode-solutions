class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){

            if(token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/")) {

                int first = stack.pop();
                int second = stack.pop();

                switch(token){

                    case "+":
                        stack.push(second + first);
                        break;

                    case "-":
                        stack.push(second - first);
                        break;

                    case "*":
                        stack.push(second * first);
                        break;

                    case "/":
                        stack.push(second / first);
                        break;
                }

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}