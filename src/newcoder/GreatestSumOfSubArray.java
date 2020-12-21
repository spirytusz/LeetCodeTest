package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11182&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * <p>
 * 解析：
 * 状态转移方程：max(n) = Math.max(arr[n], max(n - 1) + arr[n])
 * max(n)代表序列[0, n)的最大子序和，因为max(0..n)可能各有不同，
 * 因此最终结果为Math.max(arr[0..n])
 */
public class GreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
        int[] result = new int[array.length];
        result[0] = array[0];
        int max = result[0];
        for (int i = 1; i < result.length; i++) {
            result[i] = Math.max(array[i], result[i - 1] + array[i]);
            if (max < result[i]) max = result[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new GreatestSumOfSubArray().findGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }
}
