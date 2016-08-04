package sky.practice.lettcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * $explain$
 *
 * @author fei
 */
public class ReverseInteger7Test {

    @Test
    public void testReverse() throws Exception {
        ReverseInteger7 reverse = new ReverseInteger7();
        assertTrue(reverse.reverse(123) == 321);
        assertEquals(reverse.reverse(-123), -321);
        assertTrue(reverse.reverse(-100000) == -1);
    }
}