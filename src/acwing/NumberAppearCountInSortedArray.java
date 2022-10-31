package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/63/">67. 数字在排序数组中出现的次数</a>
 */
@SuppressWarnings("DuplicatedCode")
public class NumberAppearCountInSortedArray {
    public int getNumberOfK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums[0] > k || nums[nums.length - 1] < k) {
            return 0;
        }
        if (nums[0] == k && nums[nums.length - 1] == k) {
            return nums.length;
        }

        int index = binarySearch(nums, k);
        if (nums[index] != k) {
            return 0;
        }

        int step = 1;
        int ret = 1;
        while (index - step >= 0 || index + step < nums.length) {
            boolean allNotMatch = true;
            if (index - step >= 0 && nums[index - step] == k) {
                ret++;
                allNotMatch = false;
            }
            if (index + step < nums.length && nums[index + step] == k) {
                ret++;
                allNotMatch = false;
            }
            step++;
            if (allNotMatch) {
                break;
            }
        }
        return ret;
    }

    private int binarySearch(int[] nums, int n) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == n) {
                return mid;
            } else if(nums[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4, 5, 6, 6, 6, 8, 9, 10};
        System.out.println(new NumberAppearCountInSortedArray().getNumberOfK(arr, 2));
    }
}
