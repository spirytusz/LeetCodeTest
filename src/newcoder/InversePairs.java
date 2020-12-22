package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&&tqId=11188&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status:
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * <p>
 * 解析：
 * 只需求得arr[i] > arr[j] && i < j的个数即可
 * <p>
 * 归并排序中，递归到最深时，数组会被分为多个size为1的小区间
 * 比如[4, 2, 3, 1] 会被分为 [4], [2], [3], [1]这四个小区间
 * 先[4], [2]比，因为4 > 2 && 0 < 1
 * [4], [2] 合并为[2, 4]
 * 再[3], [1]比，因为3 > 1 && 2 < 3
 * [3], [1] 合并为 [1, 3]
 * 最终[2, 4]和[1, 3]比
 * 定义两个指针i, j同时遍历这两个区间
 * 2 > 1 && 0 < 2
 * 4 > 3 && 1 < 3
 * 最终合成为[1, 2, 3, 4]
 * <p>
 * 在这个排序中，合并有序区间[2, 4] 和 [1, 3]时
 * 两个区间是有序的
 * 因为 arr[0] = 2 > arr[2] = 1，且第一个区间是有序的，
 * 因此可以知道，1和第一个区间的2以及2以后的元素，都可以组成逆序对，
 * 设2的index = i, 1的index = j, 中心点为mid，
 * 对于任意的j，当arr[i] > arr[j]时，它对应的元素与第一个区间所组成的逆序对个数
 * n = mid - i + 1
 * 代入当前数据可知，1和第一个区间的元素所组成的逆序对个数为 n = 1 - 0 - 1 = 2
 */
public class InversePairs {

    private static final int MOD = 1000000007;

    public int inversePairs(int[] array) {
        long[] result = new long[1];
        mergeSort(array, 0, array.length - 1, new int[array.length], result);
        return (int) (result[0] % MOD);
    }

    private void mergeSort(int[] array, int low, int high, int[] tmp, long[] result) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(array, low, mid, tmp, result);
            mergeSort(array, mid + 1, high, tmp, result);
            mergeSortPartition(array, low, mid, high, tmp, result);
        }
    }

    private void mergeSortPartition(int[] array, int low, int mid, int high, int[] tmp, long[] result) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (array[i] > array[j]) {
                tmp[k++] = array[j++];
                result[0] += mid - i + 1;
            } else {
                tmp[k++] = array[i++];
            }
        }
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        while (j <= high) {
            tmp[k++] = array[j++];
        }
        for (k = 0, i = low; i <= high; i++, k++) {
            array[i] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, 1};
    }

}
