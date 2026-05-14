class Solution {

    public String decodeString(String s) {

        Stack<Integer> number = new Stack<>();
        Stack<StringBuilder> string = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');

            } else if (c == '[') {
                number.push(num);
                string.push(current);

                current = new StringBuilder();
                num = 0;
            } else if (c == ']') {

                int repeat = number.pop();

                StringBuilder temp = string.pop();

                for (int j = 0; j < repeat; j++) {
                    temp.append(current);
                }
                current = temp;
            } else {
                current.append(c);
            }

        }
        return current.toString();
    }
}