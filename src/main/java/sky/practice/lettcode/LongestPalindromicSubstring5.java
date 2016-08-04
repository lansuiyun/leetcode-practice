package sky.practice.lettcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 最长回文：abba,aba
 *
 * @author fei
 */
public class LongestPalindromicSubstring5 {

    /**
     * 官网答案
     *
     * @param s
     * @return
     */
    public String standard(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * 先找到最小回文结构：aa,aba，之后以其为中心向两边扩展，直到不满足回文结构。最后通过长度获取最大回文。
     * <p>
     * 注意边界问题
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        if (s == null) {
            return null;
        }
        int length = s.length();
        if (length == 1) {
            return s;
        }
        List<Indexes> list = new ArrayList<>();
        for (int i = 0; i < length - 1; i++) {
            if (palindromic(s.substring(i, i + 2))) {
                list.add(new Indexes(i, i + 1));
            }
            if (i + 3 <= length) {
                if (palindromic(s.substring(i, i + 3))) {
                    list.add(new Indexes(i, i + 2));
                }
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        int maxLen = 0;
        Indexes max = null;
        for (Indexes indexes : list) {
            int min = Math.min(indexes.start, length - 1 - indexes.end);
            while (min > 0) {
                if (s.charAt(indexes.start - 1) == s.charAt(indexes.end + 1)) {
                    indexes.expand();
                    min--;
                } else {
                    break;
                }
            }

            if (indexes.length() > maxLen) {
                maxLen = indexes.length();
                max = indexes;
            }
            if (indexes.length() == length) {
                break;
            }
        }

        return max == null ? null : s.substring(max.start, max.end + 1);
    }

    /**
     * s的长度必须是2或者3
     *
     * @param s
     * @return
     */
    public static boolean palindromic(String s) {
        return s.charAt(0) == s.charAt(s.length() - 1);
    }

    /**
     * 回文索引
     */
    public static class Indexes {
        public int start;

        public int end;

        public Indexes(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void expand() {
            this.start--;
            this.end++;
        }

        public int length() {
            return end - start + 1;
        }
    }
}
