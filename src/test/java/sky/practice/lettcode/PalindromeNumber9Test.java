package sky.practice.lettcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * $explain$
 *
 * @author fei
 */
public class PalindromeNumber9Test {

    @Test
    public void testIsPalindrome() throws Exception {
        PalindromeNumber9 p = new PalindromeNumber9();
        assertTrue(p.isPalindrome(1));
        assertTrue(p.isPalindrome(2222222));
        assertTrue(p.isPalindrome(1221));
        assertTrue(p.isPalindrome(12321));
        assertFalse(p.isPalindrome(123));
        assertFalse(p.isPalindrome(-2147483648));
    }
}