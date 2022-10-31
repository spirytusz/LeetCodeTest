package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/64/">68. 0到n-1中缺失的数字</a>
 * <a href="https://www.acwing.com/solution/content/1261/">题解</a>
 */
public class MissingNumberBetween1ToN {

    public int getMissingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[nums.length - 1] + 1;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // nums[low] == low 说明没缺
        // 如 [0, 1, 2, 3]，返回 low + 1
        return nums[low] == low ? low + 1 : low;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumberBetween1ToN().getMissingNumber(new int[]{0, 1, 2, 4}));
    }
}
