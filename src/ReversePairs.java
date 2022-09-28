/**
 * <a href="https://leetcode.com/problems/reverse-pairs/#/description">493. Reverse Pairs</a>
 * <a href="https://leetcode.com/problems/reverse-pairs/discuss/97280/Very-Short-and-Clear-MergeSort-and-BST-Java-Solutions">Very Short and Clear MergeSort & BST Java Solutions</a>
 */
public class ReversePairs {

    private int[] shadow;

    public int reversePairs(int[] nums) {
        shadow = new int[nums.length];
        int ret = mergeSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();
        return ret;
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int result = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) j++;
            result += j - mid - 1;
        }
        mergeSortImpl(nums, start, mid, end);
        return result;
    }

    private void mergeSortImpl(int[] nums, int start, int mid, int end) {
        System.arraycopy(nums, start, shadow, start, end + 1 - start);

        int i = start;
        int j = mid + 1;
        int step = start;
        while (i <= mid && j <= end) {
            if (shadow[i] > shadow[j]) {
                nums[step++] = shadow[j++];
            } else {
                nums[step++] = shadow[i++];
            }
        }
        if (i <= mid) {
            System.arraycopy(shadow, i, nums, step, mid + 1 - i);
        } else {
            System.arraycopy(shadow, j, nums, step, end + 1 - j);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 34, 7, 53, 57, 3, 6, 8, 64, 2, 0, 37, 3, 5};
        System.out.println(new ReversePairs().reversePairs(nums));

    }
}
