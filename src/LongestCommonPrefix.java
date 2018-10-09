/**
 * Link: https://leetcode.com/problems/longest-common-prefix/
 * Status: AC
 *
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].isEmpty()) {
                    return "";
                } else {
                    if(strs[0].length() > strs[i].length()) {
                        String temp = strs[0];
                        strs[0] = strs[i];
                        strs[i] = temp;
                    }
                }
            }
        }
        for (int column = 0; column < strs[0].length(); column++) {
            for (int row = 1; row < strs.length; row++) {
                if (strs[row].charAt(column) != strs[row - 1].charAt(column)) {
                    return strs[0].substring(0, column > 0 ? column : 0);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aa", "a"}));
    }
}
