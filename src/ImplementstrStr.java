/**
 * Link: https://leetcode.com/problems/implement-strstr/
 * Status: AC
 *
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementstrStr {

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        } else {
            int i = 0;
            int maybeIndex = -1;
            int lengthOfSubString = 0;
            while (i < haystack.length()) {
                if (lengthOfSubString < needle.length() && haystack.charAt(i) == needle.charAt(lengthOfSubString)) {
                    if (lengthOfSubString == 0) {
                        maybeIndex = i;
                    }
                    lengthOfSubString++;
                    i++;
                } else if (lengthOfSubString == needle.length()) {
                    return i - lengthOfSubString;
                } else {
                    lengthOfSubString = 0;
                    if (maybeIndex != -1) {
                        i = maybeIndex + 1;
                        maybeIndex++;
                    } else {
                        i++;
                    }
                }
            }
            if (lengthOfSubString == needle.length()) {
                return maybeIndex;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(strStr("abbb", "bbb"));
    }

}