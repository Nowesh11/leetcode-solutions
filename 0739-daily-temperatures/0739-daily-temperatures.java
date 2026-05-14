 class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        stack.push(0);

        for(int i =1;i<n;i++){

            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                res[stack.peek()] = i-stack.peek();
                stack.pop();
                
            }
            stack.push(i);
            

            
        }
        return res;
      
        
    }
}