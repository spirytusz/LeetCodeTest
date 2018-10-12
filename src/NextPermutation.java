/**
 * Link: https://leetcode.com/problems/next-permutation/description/
 * Status: AC
 * References: https://leetcode.com/articles/next-permutation/
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        if (i > 0) {
            int j = i;
            while (j < nums.length && nums[j] - nums[i - 1] > 0) {
                j++;
            }
            swap(nums, i - 1, j - 1);
        }
        reserveFromLowToHigh(nums, i, nums.length - 1);
    }

    private static void swap(int[] nums, int p, int q) {
        int t = nums[p];
        nums[p] = nums[q];
        nums[q] = t;
    }

    private static void reserveFromLowToHigh(int[] nums, int low, int high) {
        while (low < high) {
            int t = nums[low];
            nums[low] = nums[high];
            nums[high] = t;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] testCase1 = new int[]{5, 4, 3, 2, 1};
        int[] testCase2 = new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1};
        nextPermutation(testCase2);
        printArray(testCase2, 0, testCase2.length - 1);
    }

    private static void printArray(int[] nums, int low, int high) {
        for (int i = low; i <= high; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }

}