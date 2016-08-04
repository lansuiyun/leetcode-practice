package sky.practice.lettcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * $explain$
 *
 * @author fei
 */
public class StringToIntegerTest {

    @Test
    public void testMyAtoi() throws Exception {
        StringToInteger8 sti = new StringToInteger8();
        assertEquals(321,sti.myAtoi("321"));
        assertEquals(-321,sti.myAtoi("-321"));
        assertEquals(0,sti.myAtoi("-adb"));
        assertEquals(233,sti.myAtoi("+233"));
        assertEquals(0,sti.myAtoi("    0 10"));
        assertEquals(-12,sti.myAtoi("  -0012a42"));
        assertEquals(0,sti.myAtoi("   +0 123"));
        assertEquals(2147483647,sti.myAtoi("2147483647"));
        assertEquals(-2147483648,sti.myAtoi("-2147483648"));
        assertEquals(2147483647,sti.myAtoi("2147483648"));
        Integer.parseInt("-2147483648");
    }
}