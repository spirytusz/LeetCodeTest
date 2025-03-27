import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/">108. Convert Sorted Array to Binary Search Tree</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code> where the elements are sorted in <strong>ascending order</strong>, convert <em>it to a </em><span data-keyword="height-balanced" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rt:"><div><strong><em>height-balanced</em></strong></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(176px, 204px);"></div></div></div></span> <em>binary search tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg" style="width: 302px; height: 222px;">
 * <pre><strong>Input:</strong> nums = [-10,-3,0,5,9]
 * <strong>Output:</strong> [0,-3,9,-10,null,5]
 * <strong>Explanation:</strong> [0,-10,5,null,-3,null,9] is also accepted:
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree2.jpg" style="width: 302px; height: 222px;">
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree.jpg" style="width: 342px; height: 142px;">
 * <pre><strong>Input:</strong> nums = [1,3]
 * <strong>Output:</strong> [3,1]
 * <strong>Explanation:</strong> [1,null,3] and [3,1] are both height-balanced BSTs.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>nums</code> is sorted in a <strong>strictly increasing</strong> order.</li>
 * </ul>
 * </div>
 */
public class ConvertSortedArrayToBinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @SuppressWarnings("ClassEscapesDefinedScope")
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTImpl(nums, 0, nums.length - 1);
    }

    /**
     * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solutions/6193065/java-beats-100">java beats 100%</a>
     */
    private static TreeNode sortedArrayToBSTImpl(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            int center = (start + end) / 2;
            return new TreeNode(
                    nums[center],
                    sortedArrayToBSTImpl(nums, start, center - 1),
                    sortedArrayToBSTImpl(nums, center + 1, end)
            );
        }
    }

    private static void test(int[] testCase) {
        TreeNode node = sortedArrayToBST(testCase);

        List<List<Integer>> layers = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int end = queue.size() - 1;
            while (end >= 0) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    layer.add(cur.val);
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else {
                    layer.add(null);
                }
                end--;
            }
            layers.add(layer);
        }

        for (List<Integer> layer: layers) {
            System.out.println(layer);
        }
    }

    public static void main(String[] args) {
        test(new int[]{-10, -3, 0, 5, 9});
    }
}
