import java.util.*;

/**
 * <a href="https://leetcode.com/problems/subsets/description/">78. Subsets</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code> of <strong>unique</strong> elements, return <em>all possible</em> <span data-keyword="subset" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rt:"><div><em>subsets</em></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(51px, 204px);"></div></div></div></span> <em>(the power set)</em>.</p>
 *
 * <p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [1,2,3]
 * <strong>Output:</strong> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [0]
 * <strong>Output:</strong> [[],[0]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
 * 	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
 * 	<li>All the numbers of&nbsp;<code>nums</code> are <strong>unique</strong>.</li>
 * </ul>
 * </div>
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return new ArrayList<>(result);
        }

        List<Integer> item = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsetsCount(nums, result, item, i, 0);
        }
        return new ArrayList<>(result);
    }

    private static void subsetsCount(int[] nums, Set<List<Integer>> result, List<Integer> item, int size, int iterativeStart) {
        if (size == 0) {
            result.add(new ArrayList<>(item));
        } else {
            for (int i = iterativeStart; i < nums.length; i++) {
                item.add(nums[i]);
                subsetsCount(nums, result, item, size - 1, i + 1);
                item.remove((Integer) nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }
}
