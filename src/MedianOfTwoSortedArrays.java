/**
 * Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Status: AC
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int leftIndex = (len1 + len2 + 1) / 2;
        int rightIndex = (len1 + len2 + 2) / 2;
        int left = getKthElement(nums1, nums2, 0, 0, leftIndex);
        int right = getKthElement(nums1, nums2, 0, 0, rightIndex);
        return (left + right) / 2.0;
    }

    private int getKthElement(int[] a, int[] b, int aStart, int bStart, int k) {
        if (aStart >= a.length) {
            return b[bStart + k - 1];
        }
        if (bStart >= b.length) {
            return a[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }

        int aMid = aStart + k / 2 - 1 < a.length ? a[aStart + k / 2 - 1] : Integer.MAX_VALUE;
        int bMid = bStart + k / 2 - 1 < b.length ? b[bStart + k / 2 - 1] : Integer.MAX_VALUE;

        if (aMid < bMid) {
            return getKthElement(a, b, aStart + k / 2, bStart, k - k / 2);
        } else {
            return getKthElement(a, b, aStart, bStart + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2, 3};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(arr1, arr2));
    }
}
