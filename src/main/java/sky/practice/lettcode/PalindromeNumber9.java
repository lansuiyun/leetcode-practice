package sky.practice.lettcode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * @author fei
 */
public class PalindromeNumber9 {

    final static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE};

    static int stringSize(int x) {
        for (int i = 0; ; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }

    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int size = stringSize(x);
        if (size == 1){
            return true;
        }
        int left = (int) Math.pow(10, size - 1);
        int right = 10;
        int common = 1;
        while (true) {
            if (x / left % 10 != x % right / common) {
                return false;
            }
            if (left == right || left == right * 10) {
                return true;
            }
            left /= 10;
            right *= 10;
            common *= 10;

        }
    }
}
