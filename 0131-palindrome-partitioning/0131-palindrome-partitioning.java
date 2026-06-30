import java.util.*;

class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int start, List<String> current) {
        
        if (start == s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }

        
        for (int end = start; end < s.length(); end++) {
            String sub = s.substring(start, end + 1);

            
            if (isPalindrome(sub)) {
                current.add(sub);
                backtrack(s, end + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}