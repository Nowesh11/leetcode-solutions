class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        Stack<Integer> stack = new Stack<>();

        int max = 0;

        for(int i = 0; i <= n; i++){

            while(!stack.isEmpty() &&
                  (i == n || heights[stack.peek()] > heights[i])){

                int top = stack.pop();

                int height = heights[top];

                int pse = stack.isEmpty() ? -1 : stack.peek();

                int width = i - pse - 1;

                int area = height * width;

                max = Math.max(max, area);
            }

            stack.push(i);
        }

        return max;
    }
}