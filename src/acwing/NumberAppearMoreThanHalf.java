package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/48/">52. 数组中出现次数超过一半的数字</a>
 */
public class NumberAppearMoreThanHalf {

    /**
     * <a href="https://www.acwing.com/solution/content/1156/">题解</a>
     *
     * 出现超过数组长度的一半，对当前指向的数字计数，最终count > 0 的必为结果
     */
    public int moreThanHalfNum_Solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == current) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                current = nums[i];
                count++;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(new NumberAppearMoreThanHalf().moreThanHalfNum_Solution(new int[]{1, 2, 1, 1, 3}));
    }
}
