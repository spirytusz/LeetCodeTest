/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/">154. Find Minimum in Rotated Sorted Array II</a>
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/167981/Beats-100-Binary-Search-with-Explanations/243702">Best Answers</a>
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/167981/Beats-100-Binary-Search-with-Explanations/1333918">Why high-- not low++</a>
 */
public class FindMinimumInRotatedSortedArray2 {

    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 1) nums[low] > nums[mid] <= nums[high], min ∈ (low, mid]
            // 2) nums[low] <= nums[mid] > nums[high], min ∈ (mid, high]
            // 3) nums[low] <= nums[mid] <= nums[high],
            //    intuitively min=low, but see [3, 3, 1, 1, 3, 3, 3, 3, 3]
            //    we can low++ step by step and find where nums[low] < nums[high].
            //    if found, low is the smallest.
            // 4) nums[low] > nums[mid] > nums[high], impossible
            if (nums[low] > nums[mid]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                if (nums[low] < nums[high]) {
                    return nums[low];
                } else {
                    low++;
                }
            }
        }
        System.out.println(low);
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArray2().findMin(new int[]{4, 5, 6, 7, 0, 1, 4}));
    }
}
