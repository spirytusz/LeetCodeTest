import java.util.HashMap;

/**
 * Link: https://leetcode.com/problems/valid-parentheses/
 * Status: AC
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    /*static HashMap<Character, Integer> mapper;

    static {
        mapper = new HashMap<>();
        mapper.put('{', 3);
        mapper.put('[', 2);
        mapper.put('(', 1);
        mapper.put(')', -1);
        mapper.put(']', -2);
        mapper.put('}', -3);
    }*/

    private static boolean isMatch(char c1, char c2) {
        return (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']') || (c1 == '(' && c2 == ')');
    }

    public static boolean isValid(String s) {
        char[] stack = new char[s.length() / 2 + 1];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            if (top > 0 && isMatch(stack[top - 1], s.charAt(i))) {
                stack[top--] = 0;
            } else if(top < s.length() / 2){
                stack[top++] = s.charAt(i);
            } else {
                return false;
            }
        }
        return top == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("({})"));
    }
}
