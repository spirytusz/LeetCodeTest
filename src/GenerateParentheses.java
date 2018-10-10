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

    static char[] chars = new char[]{'(', ')'};

    public static List<String> generateParenthesis(int n) {
        char[][] charss = new char[n * 2][];
        for (int i = 0; i < n * 2; i++)
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
            String s = stringBuilder.toString();
            System.out.println(s);
            if (isValid(s)) {
                result.add(s);
            }
        }
    }

    private static boolean isMatch(char c1, char c2) {
        return (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']') || (c1 == '(' && c2 == ')');
    }

    private static boolean isValid(String s) {
        char[] stack = new char[s.length() / 2 + 1];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            if (top > 0 && isMatch(stack[top - 1], s.charAt(i))) {
                stack[top--] = 0;
            } else if (top < s.length() / 2) {
                stack[top++] = s.charAt(i);
            } else {
                return false;
            }
        }
        return top == 0;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}