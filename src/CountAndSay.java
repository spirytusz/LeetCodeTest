/**
 * Link: https://leetcode.com/problems/count-and-say/
 * Status: AC
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * <p>
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            StringBuilder sb = new StringBuilder();
            String s_n_1 = countAndSay(n - 1);
            int count = 0;
            char c = s_n_1.charAt(0);
            for (int i = 0; i < s_n_1.length(); i++) {
                if (s_n_1.charAt(i) == c) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    c = s_n_1.charAt(i);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(c);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "\t");
        System.out.println();
    }
}
