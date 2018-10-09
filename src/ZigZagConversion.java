/**
 * Link: https://leetcode.com/problems/zigzag-conversion/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (s.length() == numRows || numRows == 1) {
            return s;
        }
        char[][] chars = getCharArray(s, numRows);
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < chars.length; x++) {
            for (int y = 0; y < chars[0].length; y++) {
                if (chars[x][y] != '\u0000') {
                    sb.append(chars[x][y]);
                }
            }
        }
        return sb.toString();
    }

    private static char[][] getCharArray(String s, int numRows) {
        char[] string = s.toCharArray();
        char[][] chars = new char[numRows][string.length];
        int step = numRows - 1;
        int i = 0;
        int j = 0;
        int index = 0;
        while (index < string.length) {
            while (index < string.length && i < step) {
                chars[i++][j] = string[index++];
            }
            while (index < string.length && i > 0) {
                chars[i--][j++] = string[index++];
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }
}