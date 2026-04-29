import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int maxlen = 0;

        for (int j = 0; j < s.length(); j++) {

            // fix window FIRST
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }

            // then add current char
            set.add(s.charAt(j));

            // then update max
            maxlen = Math.max(maxlen, j - i + 1);
        }

        return maxlen;
    }
}
