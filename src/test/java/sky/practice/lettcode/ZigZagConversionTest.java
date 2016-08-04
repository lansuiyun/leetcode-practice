package sky.practice.lettcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * $explain$
 *
 * @author fei
 */
public class ZigZagConversionTest {

    @Test
    public void testConvert() throws Exception {
        ZigZagConversion6 z = new ZigZagConversion6();
        assertEquals(z.convert("PAYPALISHIRING", 3),"PAHNAPLSIIGYIR");
        assertEquals(z.convert("abc", 3),"abc");
    }
}