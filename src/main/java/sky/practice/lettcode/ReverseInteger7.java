package sky.practice.lettcode;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * @author fei
 */
public class ReverseInteger7 {
    /**
     * 翻转int，保留符号
     * 需要注意int边界问题
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int factor = x >=0?1:-1;
        int num = Math.abs(x);
        int remainder = 0;
        int result = 0;
        while (true) {
            remainder = num % 10;
            num /= 10;
            if ((Integer.MAX_VALUE - remainder) / 10 < result) {
                return 0;
            }
            result = result * 10 + remainder;
            if (num == 0) {
                break;
            }
        }
        return result * factor;
    }
}
