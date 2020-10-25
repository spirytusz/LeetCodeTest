/**
 * Link: https://leetcode.com/problems/length-of-last-word/
 * Status: AC
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int result = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                return result;
            }
            i--;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello "));
    }
}
