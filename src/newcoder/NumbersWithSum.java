package newcoder;

import java.util.ArrayList;

/**
 * Link: https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11194&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class NumbersWithSum {

    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>(2);
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (sum > array[i] + array[j]) {
                i++;
            } else if (sum < array[i] + array[j]) {
                j--;
            } else {
                result.add(array[i]);
                result.add(array[j]);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 7, 11, 15};
        System.out.println(new NumbersWithSum().findNumbersWithSum(arr, 11));
    }
}
