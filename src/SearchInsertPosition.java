/**
 * Link: https://leetcode.com/problems/search-insert-position/
 * Status: AC
 * <p>
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * <p>
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        if (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return binarySearch(arr, low, mid - 1, target);
            } else {
                return binarySearch(arr, mid + 1, high, target);
            }
        } else {
            return arr[low] >= target ? low : low + 1;
        }
    }

    public static void main(String[] args) {
        test(new int[]{1, 3, 5, 6}, 5);
        test(new int[]{1, 3, 5, 6}, 2);
        test(new int[]{1, 3, 5, 6}, 7);
        test(new int[]{1, 3, 5, 6}, 0);
    }

    private static void test(int[] arr, int target) {
        System.out.println(searchInsert(arr, target));
    }

}
