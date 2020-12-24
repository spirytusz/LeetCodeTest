package newcoder;

import Utils.ArrayUtil;

/**
 * Link: https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11199&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 */
public class Multiply {

    public int[] multiply(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
            for (int j = 0;j<result.length;j++) {
                result[i] *= i == j ? 1 : arr[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] result = new Multiply().multiply(a);
        ArrayUtil.printArray(result);
    }
}
