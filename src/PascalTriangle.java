import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pascals-triangle/">118. Pascal's Triangle</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>numRows</code>, return the first numRows of <strong>Pascal's triangle</strong>.</p>
 *
 * <p>In <strong>Pascal's triangle</strong>, each number is the sum of the two numbers directly above it as shown:</p>
 * <img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif" style="height: 240px; width: 260px;">
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> numRows = 5
 * <strong>Output:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> numRows = 1
 * <strong>Output:</strong> [[1]]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= numRows &lt;= 30</code></li>
 * </ul>
 * </div>
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> layer = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    layer.add(1);
                } else {
                    int top = result.get(i - 1).get(j);
                    int topLeft = result.get(i - 1).get(j - 1);
                    layer.add(top + topLeft);
                }
            }
            result.add(layer);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
