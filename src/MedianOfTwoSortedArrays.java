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

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0) {
            return findMedianSortedArray(nums2);
        }
        if(n == 0) {
            return findMedianSortedArray(nums1);
        }
        int[] mergeArray = new int[m + n];
        int i = 0;
        int j = 0;
        for (int index = 0; index < mergeArray.length; index++) {
            int temp = 0;
            if(i < m && j< n) {
                if(nums1[i] <= nums2[j]) {
                    temp = nums1[i];
                    i++;
                } else {
                    temp = nums2[j];
                    j++;
                }
                mergeArray[index] = temp;
            } else if(i < m){
                mergeArray[index] = nums1[i++];
            } else if(j < n) {
                mergeArray[index] = nums2[j++];
            }
        }
        return findMedianSortedArray(mergeArray);
    }

    private static double findMedianSortedArray(int[] nums) {
        int length = nums.length;
        if (length % 2 == 1) {
            return nums[(length - 1) / 2];
        } else {
            return (double)(nums[length / 2] + nums[length / 2 - 1]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1};
        int[] arr2 = {};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
