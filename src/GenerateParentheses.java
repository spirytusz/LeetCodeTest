import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/generate-parentheses/
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

    static char[] chars = new char[]{'(', ')'};

    public static List<String> generateParenthesis(int n) {
        char[][] charss = new char[n][];
        for (int i = 0; i < n; i++)
            charss[i] = chars;
        List<String> result = new ArrayList<>();
        generateParenthesis(result, new StringBuilder(), charss, 0);
        return result;
    }

    private static void generateParenthesis(List<String> result, StringBuilder stringBuilder, char[][] charss, int depth) {
        if (depth < charss.length) {
            for (int i = 0; i < charss[depth].length; i++) {
                stringBuilder.append(charss[depth][i]);
                generateParenthesis(result, stringBuilder, charss, depth + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        } else {
            result.add(stringBuilder.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}