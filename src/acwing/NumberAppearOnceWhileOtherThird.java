package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/70/">74. 数组中唯一只出现一次的数字</a>
 * <a href="https://www.acwing.com/solution/content/2618/">题解</a>
 */
public class NumberAppearOnceWhileOtherThird {
    public int findNumberAppearingOnce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] digitRecord = new int[32];
        for (int num : nums) {
            int digitIndex = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    digitRecord[digitIndex]++;
                }
                num /= 2;
                digitIndex++;
            }
        }
        int ret = 0;
        for (int i = 0; i < digitRecord.length; i++) {
            if (digitRecord[i] % 3 == 1) {
                ret += (int) Math.pow(2, i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new NumberAppearOnceWhileOtherThird().findNumberAppearingOnce(new int[]{1, 1, 1, 2, 2, 2, 3, 4, 4, 4}));
    }
}
