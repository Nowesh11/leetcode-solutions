class Solution {
    public int reverse(int x) {
        boolean negative = x < 0;

        String s = String.valueOf(Math.abs(x));
        String reversed = new StringBuilder(s).reverse().toString();

        try {
            int result = Integer.parseInt(reversed);
            return negative ? -result : result;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}