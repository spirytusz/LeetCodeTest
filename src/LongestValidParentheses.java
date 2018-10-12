/**
 * Link: https://leetcode.com/problems/longest-valid-parentheses/
 * Status: AC
 * References: https://leetcode.com/problems/longest-valid-parentheses/discuss/14126/My-O(n)-solution-using-a-stack
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int top = 0;
        int[] stack = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && top != 0 && s.charAt(stack[top - 1]) == '(') {
                top--;
            } else {
                stack[top++] = i;
            }
        }
        if (top == 0) {
            return s.length();
        } else {
            int maxLength = 0;
            int low;
            int high = s.length();
            for (int i = top - 1; i >= 0; i--) {
                low = stack[i];
                if (maxLength < high - low - 1) {
                    maxLength = high - low - 1;
                }
                high = low;
            }
            return stack[0] > maxLength ? stack[0] : maxLength;
        }
    }

    public static void main(String[] args) {
        String testCase1 = "((())())(()))(()()(()(()))(()((((()))))))((()())()))()()(()(((((()()()())))()())(()()))((((((())))((()))()()))))(()))())))()))()())((()()))))(()(((((())))))()((()(()(())((((())(())((()()(()())))())(()(())()()))())(()()()))()(((()())(((()()())))(((()()()))(()()))()))()))))))())()()((()(())(()))()((()()()((())))()(((()())(()))())())))(((()))))())))()(())))()())))())()((()))((()))()))(((())((()()()(()((()((())))((()()))())(()()(()))))())((())))(()))()))))))()(()))())(()())))))(()))((())(()((())(((((()()()(()()())))(()())()((()(()()))(()(())((()((()))))))))(()(())()())()(()(()(()))()()()(()()())))(())(()((((()()))())))(())((()(())())))))())()()))(((())))())((()(()))(()()))((())(())))))(()(()((()((()()))))))(()()()(()()()(()(())()))()))(((()(())()())(()))())))(((()))())(()((()))(()((()()()(())()(()())()(())(()(()((((())()))(((()()(((()())(()()()(())()())())(()(()()((()))))()(()))))(((())))()()))(()))((()))))()()))))((((()(())()()()((()))((()))())())(()((()()())))))))()))(((()))))))(()())))(((()))((()))())))(((()(((())))())(()))))(((()(((((((((((((())(((()))((((())())()))())((((())(((())))())(((()))))()())()(())())(()))))()))()()()))(((((())()()((()))())(()))()()(()()))(())(()()))()))))(((())))))((()()(()()()()((())((((())())))))((((((()((()((())())(()((()))(()())())())(()(())(())(()((())((())))(())())))(()()())((((()))))((()(())(()(()())))))))))((()())()()))((()(((()((()))(((((()()()()()(()(()((()(()))(()(()((()()))))()(()()((((((()((()())()))((())()()(((((()(()))))()()((()())((()())()(())((()))()()(()))";
        String testCase2 = ")()";
        String testCase3 = "";
        String testCase4 = "(())())(()))((";
        test(testCase1);
        test(testCase2);
        test(testCase3);
        test(testCase4);
    }

    private static void test(String testCase) {
        long start = System.currentTimeMillis();
        int result = longestValidParentheses(testCase);
        System.out.println("result = " + result + "\t with using time = " + (System.currentTimeMillis() - start) + "ms");
    }
}