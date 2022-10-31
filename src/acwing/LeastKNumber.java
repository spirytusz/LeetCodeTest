package acwing;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.acwing.com/problem/content/49/">53. 最小的k个数</a>
 */
@SuppressWarnings("DuplicatedCode")
public class LeastKNumber {
    public List<Integer> getLeastNumbers_Solution(int[] input, int k) {
        List<Integer> ret = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0) {
            return ret;
        }
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    int t = input[i];
                    input[i] = input[j];
                    input[j] = t;
                }
            }
            ret.add(input[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        for (int n : new LeastKNumber().getLeastNumbers_Solution(new int[]{8, 1, 7, 5, 4, 6, 3, 2}, 4)) {
            System.out.print(n + "\t");
        }
    }
}
