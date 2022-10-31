package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/30/">32. 调整数组顺序使奇数位于偶数前面</a>
 */
public class AdjustNumberPosition {

    public void reOrderArray(int[] array) {
        if (array.length == 0) {
            return;
        }

        int p = 0;
        int q = array.length - 1;
        while (p < q) {
            while (p < q && (array[p] & 1) == 1) {
                p++;
            }
            while (p < q && (array[q] & 1) == 0) {
                q--;
            }
            if (p < q) {
                int temp = array[p];
                array[p] = array[q];
                array[q] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        new AdjustNumberPosition().reOrderArray(arr);
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }
}
