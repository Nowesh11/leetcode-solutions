class Solution {

    List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) {

        if (num == null || num.length() == 0)
            return result;

        backtrack(num, target, 0, "", 0, 0);

        return result;
    }

    private void backtrack(String num, int target,
                           int index,
                           String expression,
                           long currentValue,
                           long previousValue) {

        
        if (index == num.length()) {

            if (currentValue == target) {
                result.add(expression);
            }

            return;
        }

        
        for (int i = index; i < num.length(); i++) {

            
            if (i != index && num.charAt(index) == '0')
                break;

            String currentString = num.substring(index, i + 1);
            long currentNumber = Long.parseLong(currentString);

            
            if (index == 0) {

                backtrack(num,
                          target,
                          i + 1,
                          currentString,
                          currentNumber,
                          currentNumber);

            } else {

                // +
                backtrack(num,
                          target,
                          i + 1,
                          expression + "+" + currentString,
                          currentValue + currentNumber,
                          currentNumber);

                // -
                backtrack(num,
                          target,
                          i + 1,
                          expression + "-" + currentString,
                          currentValue - currentNumber,
                          -currentNumber);

                // *
                backtrack(num,
                          target,
                          i + 1,
                          expression + "*" + currentString,
                          currentValue - previousValue + previousValue * currentNumber,
                          previousValue * currentNumber);
            }
        }
    }
}