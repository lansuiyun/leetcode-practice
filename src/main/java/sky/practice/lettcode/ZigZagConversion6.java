package sky.practice.lettcode;

import java.util.HashMap;
import java.util.Map;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * <p>
 * A P L S I I G
 * <p>
 * Y   I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * @author fei
 */
public class ZigZagConversion6 {
    /**
     * 核心思路是对坐标的转换。
     * <p>
     * 确定真实行数：numRows * 2 - 2。
     * 观察可发现第N行的成员满足：索引%真实行数= 真实行数或（真实行数-索引）
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        int realNumRow = numRows * 2 - 2;
        Map<Integer, Row> rows = createRows(s.length(), realNumRow);
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int n = i % realNumRow;
            Row row = rows.get(n);
            result[row.addCount()] = s.charAt(i);
        }
        return new String(result);
    }

    public Map<Integer, Row> createRows(int len, int realRowNum) {
        int maxRow = realRowNum / 2;
        int fullColumn = len / realRowNum;
        int remainder = len % realRowNum - 1;
        int startPoint = 0;
        Map<Integer, Row> map = new HashMap<>(realRowNum, 1);
        for (int i = 0; i <= maxRow; i++) {
            int count = fullColumn;
            int[] remainders;
            if (i == 0 || i == realRowNum / 2) {
                remainders = new int[]{i};
                if (remainder >= i) {
                    count++;
                }
            } else {
                int r2 = realRowNum - i;
                remainders = new int[]{i, r2};
                count = fullColumn * 2;
                if (remainder >= r2) {
                    count += 2;
                } else if (remainder >= i) {
                    count++;
                }
            }
            Row row = new Row(i, remainders, startPoint);
            for (int remainder1 : remainders) {
                map.put(remainder1, row);
            }
            startPoint += count;
        }
        return map;
    }

    private class Row {
        public int rowIndex;
        public int[] remainder; //1、2个元素
        public int startPoint;
        public int count = -1;

        public Row(int rowIndex, int[] remainder, int startPoint) {
            this.rowIndex = rowIndex;
            this.remainder = remainder;
            this.startPoint = startPoint;
        }

        public int addCount() {
            count++;
            return startPoint + count;
        }
    }
}
