
/**
 * <a href="https://leetcode.com/problems/multiply-strings/description/">43. Multiply Strings</a>
 *
 * <p>Given two non-negative integers <code>num1</code> and <code>num2</code> represented as strings, return the product of <code>num1</code> and <code>num2</code>, also represented as a string.</p>
 *
 * <p><strong>Note:</strong>&nbsp;You must not use any built-in BigInteger library or convert the inputs to integer directly.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> num1 = "2", num2 = "3"
 * <strong>Output:</strong> "6"
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> num1 = "123", num2 = "456"
 * <strong>Output:</strong> "56088"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= num1.length, num2.length &lt;= 200</code></li>
 * 	<li><code>num1</code> and <code>num2</code> consist of digits only.</li>
 * 	<li>Both <code>num1</code> and <code>num2</code>&nbsp;do not contain any leading zero, except the number <code>0</code> itself.</li>
 * </ul>
 */
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String[] layers = new String[num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            int shift = 0;
            StringBuilder result = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int item = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + shift;
                result.append(item % 10);
                shift = item / 10;
            }
            if (shift != 0) {
                result.append(shift);
            }
            int index = Math.abs(i - num2.length() + 1);
            layers[i] = result.reverse().append("0".repeat(index)).toString();
        }
        return add(layers);
    }

    private static String add(String[] layers) {
        int maxSize = Integer.MIN_VALUE;
        for (String layer : layers) {
            maxSize = Math.max(maxSize, layer.length());
        }
        StringBuilder sb = new StringBuilder();
        int shift = 0;
        for (int start = 0; start < maxSize; start++) {
            int result = 0;
            for (String layer : layers) {
                int index = layer.length() - 1 - start;
                if (index < 0) {
                    continue;
                }
                result += layer.charAt(index) - '0';
            }
            result += shift;
            sb.append(result % 10);
            shift = result / 10;
        }
        if (shift != 0) {
            sb.append(shift);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
