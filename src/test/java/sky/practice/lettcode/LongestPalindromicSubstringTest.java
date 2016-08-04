package sky.practice.lettcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * $explain$
 *
 * @author fei
 */
public class LongestPalindromicSubstringTest {

    @Test
    public void testLongestPalindrome() throws Exception {
        String s = "acbeffebgsd";
        assertEquals(LongestPalindromicSubstring5.longestPalindrome(s),"beffeb");
        s = "a";
        assertEquals(LongestPalindromicSubstring5.longestPalindrome(s),"a");
    }
}