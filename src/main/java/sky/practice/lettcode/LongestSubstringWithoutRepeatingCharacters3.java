package sky.practice.lettcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author fei
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    /**
     * 官方解答
     *
     * @param s
     * @return
     */
    public int standard(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int tempLen = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>(len, 1);
        int removeFrom = 0;//include
        int removeTo = 0; // exclude
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index == null) {
                map.put(c, i);
                tempLen++;
            } else {
                maxLen = Math.max(maxLen, tempLen);
                tempLen = i - index;
                removeFrom = removeTo;
                removeTo = index + 1;
                for (int j = removeFrom; j < removeTo; j++) {
                    map.remove(s.charAt(j));
                }
                map.put(c, i);
            }
        }
        return Math.max(maxLen, tempLen);
    }
}
