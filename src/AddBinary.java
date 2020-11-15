/**
 * Link: https://leetcode.com/problems/add-binary/
 * <p>
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        String binary1 = insertZero(a, Math.abs(a.length() - length));
        String binary2 = insertZero(b, Math.abs(b.length() - length));
        StringBuilder builder = new StringBuilder();
        int shift = 0;
        for (int i = binary1.length() - 1; i >= 0; i--) {
            int item = shift + (binary1.charAt(i) - '0') + (binary2.charAt(i) - '0');
            System.out.println(item);
            if (item >= 2) {
                shift = 1;
                builder.append(item % 2);
            } else {
                builder.append(item);
                shift = 0;
            }
        }
        if (shift != 0) {
            builder.append(shift);
        }
        return builder.reverse().toString();
    }

    private static String insertZero(String str, int count) {
        StringBuilder builder = new StringBuilder();
        int i = count;
        while (i > 0) {
            builder.append(0);
            i--;
        }
        builder.append(str);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
