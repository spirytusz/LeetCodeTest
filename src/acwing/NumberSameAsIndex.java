package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/65/">69. 数组中数值和下标相等的元素</a>
 */
public class NumberSameAsIndex {

    public int getNumberSameAsIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] < mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low] == low ? low : -1;
    }

    public static void main(String[] args) {
        System.out.println(new NumberSameAsIndex().getNumberSameAsIndex(new int[]{-1, 0, 1, 2, 4}));
    }
}
