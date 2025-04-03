
/**
 * <a href="https://leetcode.com/problems/sort-colors/">75. Sort Colors</a>
 *
 * <p>Given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>
 *
 * <p>We will use the integers <code>0</code>, <code>1</code>, and <code>2</code> to represent the color red, white, and blue, respectively.</p>
 *
 * <p>You must solve this problem without using the library&#39;s sort function.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [2,0,2,1,1,0]
 * <strong>Output:</strong> [0,0,1,1,2,2]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [2,0,1]
 * <strong>Output:</strong> [0,1,2]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 300</code></li>
 * 	<li><code>nums[i]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>
 */
public class SortColors {

    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    public static void sortColors(int[] nums) {
        int indexRed = 0;
        int indexBlue = nums.length - 1;
        for (int i = 0; i < indexBlue; i++) {
            switch (nums[i]) {
                case RED:
                    nums[indexRed++] = RED;
                    break;
                case BLUE:
                    nums[indexBlue--] = BLUE;
                    break;
            }
        }
        System.out.println("red: " + indexRed + " blue: " + indexBlue);
        for (int i = indexRed + 1; i < Math.min(indexBlue + 1, nums.length); i++) {
            nums[i] = WHITE;
        }
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase1() {
        int[] colors = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(colors);
        for (int color : colors) {
            System.out.print(color + "\t");
        }
        System.out.println();
    }

    private static void testCase2() {
        int[] colors = new int[]{2, 0, 1};
        sortColors(colors);
        for (int color : colors) {
            System.out.print(color + "\t");
        }
        System.out.println();
    }
}
