package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&&tqId=11182&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */

import java.util.ArrayList;

public class MinK {
    public ArrayList<Integer> minK(int[] input, int k) {
        if (k > input.length) return new ArrayList<>(0);
        ArrayList<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < Math.min(k, input.length); i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    int t = input[i];
                    input[i] = input[j];
                    input[j] = t;
                }
            }
            result.add(input[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinK().minK(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 10));
    }
}
