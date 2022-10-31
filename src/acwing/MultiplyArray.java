package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/82/">86. 构建乘积数组</a>
 * <a href="https://www.acwing.com/solution/content/759/">题解</a>
 */
public class MultiplyArray {

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        // left[i] = A[0] * A[1] * ... * A[i - 1]
        //         = left[i - 1] * A[i - 1]
        // right[i] = A[i + 1] * A[i + 2] * ... * A[A.length - 1]
        //          = A[i + 1] * right[i + 1];
        // ret[i] = left[i] * right[i];
        int[] leftMultiply = new int[A.length];
        int[] rightMultiply = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                leftMultiply[i] = 1;
            } else {
                leftMultiply[i] = leftMultiply[i - 1] * A[i - 1];
            }
        }
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1) {
                rightMultiply[i] = 1;
            } else {
                rightMultiply[i] = A[i + 1] * rightMultiply[i + 1];
            }
        }
        int[] ret = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ret[i] = leftMultiply[i] * rightMultiply[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        for (int i : new MultiplyArray().multiply(new int[]{1, 2, 3, 4, 5})) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
