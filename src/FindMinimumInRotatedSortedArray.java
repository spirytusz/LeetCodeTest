/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/">153. Find Minimum in Rotated Sorted Array</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>Suppose an array of length <code>n</code> sorted in ascending order is <strong>rotated</strong> between <code>1</code> and <code>n</code> times. For example, the array <code>nums = [0,1,2,4,5,6,7]</code> might become:</p>
 *
 * <ul>
 * 	<li><code>[4,5,6,7,0,1,2]</code> if it was rotated <code>4</code> times.</li>
 * 	<li><code>[0,1,2,4,5,6,7]</code> if it was rotated <code>7</code> times.</li>
 * </ul>
 *
 * <p>Notice that <strong>rotating</strong> an array <code>[a[0], a[1], a[2], ..., a[n-1]]</code> 1 time results in the array <code>[a[n-1], a[0], a[1], a[2], ..., a[n-2]]</code>.</p>
 *
 * <p>Given the sorted rotated array <code>nums</code> of <strong>unique</strong> elements, return <em>the minimum element of this array</em>.</p>
 *
 * <p>You must write an algorithm that runs in&nbsp;<code>O(log n) time</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [3,4,5,1,2]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The original array was [1,2,3,4,5] rotated 3 times.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [4,5,6,7,0,1,2]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> nums = [11,13,15,17]
 * <strong>Output:</strong> 11
 * <strong>Explanation:</strong> The original array was [11,13,15,17] and it was rotated 4 times.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 5000</code></li>
 * 	<li><code>-5000 &lt;= nums[i] &lt;= 5000</code></li>
 * 	<li>All the integers of <code>nums</code> are <strong>unique</strong>.</li>
 * 	<li><code>nums</code> is sorted and rotated between <code>1</code> and <code>n</code> times.</li>
 * </ul>
 * </div>
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;

            int midNum = nums[mid];
            int endNum = nums[end];

            if (midNum > endNum) {
                // if num[mid] > num[end], then we can know that the min value will appear at (mid, end]
                // move start pointer to ** mid + 1 **
                start = mid + 1;
            } else {
                // else, num[mid] <= num[end], [mid, end] is increasing, so the min value will appear at [start, mid]
                // it is possible that the value at pointer mid is min, so we should move the end pointer to ** mid **!!
                end = mid;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
        System.out.println(findMin(new int[]{2, 1}));
        System.out.println(findMin(new int[]{3, 2, 1}));
        System.out.println(findMin(new int[]{1}));
        System.out.println(findMin(new int[]{1, 2, 3, 4, 5}));
        System.out.println(findMin(new int[]{3, 1, 2}));
    }
}
