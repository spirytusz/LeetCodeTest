import java.util.LinkedList;

/**
 * Link: https://leetcode.com/problems/plus-one/
 * Status: AC
 *
 * <p>
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 * <p>
 * Input: digits = [0]
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        LinkedList<Integer> result = new LinkedList<>();
        int[] add = new int[digits.length];
        add[add.length - 1] = 1;
        int shift = 0;
        for (int i = add.length - 1; i >= 0; i--) {
            int addItem = digits[i] + add[i] + shift;
            int item;
            if (addItem >= 10) {
                item = addItem % 10;
                shift = 1;
            } else {
                item = addItem;
                shift = 0;
            }
            result.add(0, item);
        }
        if (shift != 0) {
            result.add(0, shift);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] result = plusOne(new int[]{9, 9, 9});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}
