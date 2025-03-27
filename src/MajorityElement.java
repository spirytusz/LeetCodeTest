/**
 * <a href="https://leetcode.com/problems/majority-element/description">169. Majority Element</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Given an array <code>nums</code> of size <code>n</code>, return <em>the majority element</em>.</p>
 *
 * <p>The majority element is the element that appears more than <code>⌊n / 2⌋</code> times. You may assume that the majority element always exists in the array.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [3,2,3]
 * <strong>Output:</strong> 3
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [2,2,1,1,1,2,2]
 * <strong>Output:</strong> 2
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow-up:</strong> Could you solve the problem in linear time and in <code>O(1)</code> space?</div>
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                candidate = num;
            }
            if (candidate == num) {
                vote++;
            } else {
                vote--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{3, 3, 1}));
        System.out.println(majorityElement(new int[]{3, 3, 1, 1, 1, 3, 3}));
    }
}
