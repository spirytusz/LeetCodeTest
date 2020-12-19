package newcoder;

import Utils.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&&tqId=11166&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    public void reOrderArray(int[] array) {
        if (array.length <= 1) return;
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int j : array) {
            if (j % 2 == 0) odds.add(j);
            else evens.add(j);
        }
        for (int i = 0; i < array.length; i++) {
            if (!evens.isEmpty()) {
                array[i] = evens.remove(0);
            } else {
                array[i] = odds.remove(0);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        new ReOrderArray().reOrderArray(arr);
        ArrayUtil.printArray(arr);
    }
}
