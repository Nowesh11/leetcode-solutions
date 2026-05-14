class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision happens only when:
            // stack top is moving right (+)
            // current asteroid moving left (-)

            while (!stack.isEmpty() &&
                   stack.peek() > 0 &&
                   asteroid < 0) {

                // Top asteroid is bigger
                if (stack.peek() > Math.abs(asteroid)) {
                    destroyed = true;
                    break;
                }

                // Both are same size
                else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                    destroyed = true;
                    break;
                }

                // Current asteroid is bigger
                else {
                    stack.pop();
                }
            }

            // Current asteroid survives
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        // Convert stack to array
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}