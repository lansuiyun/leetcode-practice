package sky.practice.lettcode;

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * <p>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 *
 * @author fei
 */
public class StringToInteger8 {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        String sourceStr = str.trim();
        if (sourceStr.isEmpty()) {
            return 0;
        }
        int len = sourceStr.length();
        int result = 0;
        boolean negative = sourceStr.charAt(0) == '-';
        int start = negative ? 1 : sourceStr.charAt(0) == '+' ? 1 : 0;
        int factor = negative ? -1 : 1;
        final long maxInt = negative ? -1L * Integer.MIN_VALUE : 1L * Integer.MAX_VALUE;
        for (int i = start; i < len; i++) {
            char c = sourceStr.charAt(i);
            if (!Character.isDigit(c)) {
                return result * factor;
            }
            int value = Character.getNumericValue(c);
            if ((maxInt - value) / 10 < result) { //超过int范围
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + value;
        }
        return result * factor;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
