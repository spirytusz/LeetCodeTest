/**
 * Link: https://leetcode.com/problems/regular-expression-matching/
 * Status: Have no idea
 *
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
        return isMatchInternal(s, p, 0, 0);
    }

    private static boolean isMatchInternal(String s, String p, int si, int pi) {
        if (si == s.length() && pi == p.length()) {
            return true;
        } else if (pi == p.length()) {
            return false;
        } else if (si == s.length()) {
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                return isMatchInternal(s, p, si, pi + 2);
            } else {
                return false;
            }
        } else {
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') {
                    return isMatchInternal(s, p, si, pi + 2) || isMatchInternal(s, p, si + 1, pi);
                } else {
                    return isMatchInternal(s, p, si, pi + 2);
                }
            } else if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') {
                return isMatchInternal(s, p, si + 1, pi + 1);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab",".*"));
    }
}
