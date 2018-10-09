/**
 * Link: https://leetcode.com/problems/regular-expression-matching/
 * Status:
 * <p>
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        String[] coverts = convert(s, p, '/');
        String s1 = coverts[0];
        String p1 = coverts[1];
        return false;
    }

    private static String charArrayToString(char[] charArray, char ignore) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArray) {
            if (c != ignore) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private static String[] convert(String s, String p, final char deleteType) {
        int si = 0;
        int pj = 0;
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        while (si < sCharArray.length && pj < pCharArray.length) {

        }
        String s1 = charArrayToString(sCharArray, deleteType);
        String p1 = charArrayToString(pCharArray, deleteType);
        return new String[]{s1, p1};
    }

    public static void main(String[] args) {
        System.out.println("s1 = mississippi\np1 = mis*is*p*.");
        isMatch("mississippi","mis*is*p*.");
    }
}
