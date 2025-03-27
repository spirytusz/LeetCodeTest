import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/generate-parentheses/
 * Status: AC
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        traversalBinary(result, "", 0, 0, n);
        return result;
    }

    private static void traversalBinary(List<String> result, String str, int left, int right, int n) {
        if (left + right == 2 * n) {
            result.add(str);
        }
        if (left < n) {
            traversalBinary(result, str + "(", left + 1, right, n);
        }
        if (right < left) {
            traversalBinary(result, str + ")", left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}