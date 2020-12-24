package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11190&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

import java.util.Arrays;

public class NumsAppearOnce {

    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Arrays.sort(array);
        boolean flag = false;
        int x = 0;
        int y = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[x] == array[i]) {
                y++;
            } else {
                if (y - x == 0) {
                    if (!flag) {
                        num1[0] = array[y];
                        flag = true;
                    } else {
                        num2[0] = array[y];
                    }
                }
                x = i;
                y = i;
            }
        }
        if (x == y) num2[0] = array[x];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3};
        int[] i1 = new int[1];
        int[] i2 = new int[1];
        new NumsAppearOnce().findNumsAppearOnce(arr, i1, i2);
        System.out.println(i1[0] + "\t" + i2[0]);
    }
}
