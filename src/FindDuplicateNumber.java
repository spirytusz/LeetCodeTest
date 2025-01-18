/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/description">287. Find the Duplicate Number</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>nums</code> containing&nbsp;<code>n + 1</code> integers where each integer is in the range <code>[1, n]</code> inclusive.</p>
 *
 * <p>There is only <strong>one repeated number</strong> in <code>nums</code>, return <em>this&nbsp;repeated&nbsp;number</em>.</p>
 *
 * <p>You must solve the problem <strong>without</strong> modifying the array <code>nums</code>&nbsp;and using only constant extra space.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [1,3,4,2,2]
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [3,1,3,4,2]
 * <strong>Output:</strong> 3
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [3,3,3,3,3]
 * <strong>Output:</strong> 3</pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>nums.length == n + 1</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= n</code></li>
 * 	<li>All the integers in <code>nums</code> appear only <strong>once</strong> except for <strong>precisely one integer</strong> which appears <strong>two or more</strong> times.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><b>Follow up:</b></p>
 *
 * <ul>
 * 	<li>How can we prove that at least one duplicate number must exist in <code>nums</code>?</li>
 * 	<li>Can you solve the problem in linear runtime complexity?</li>
 * </ul>
 * </div>
 */
public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        return fastSlowPointer(nums);
    }

    private static int bruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[j]) {
                    return target;
                }
            }
        }
        return -1;
    }

    private static int markVisitedAsNegative(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                return index;
            } else {
                nums[index] = -nums[index];
            }
        }
        return -1;
    }

    private static final int MAX_INPUT = (int) (1e5 + 1);

    private static int modMaxInput(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) % MAX_INPUT;
            if (nums[index] / MAX_INPUT > 0) {
                return index;
            } else {
                nums[index] += MAX_INPUT;
            }
        }
        return -1;
    }

    private static int fastSlowPointer(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int slow2 = nums[0];
        while (slow2 != slow) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findDuplicate(new int[]{3, 3, 3, 3, 3}));
    }
}
