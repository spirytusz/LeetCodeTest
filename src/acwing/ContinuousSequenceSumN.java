package acwing;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.acwing.com/problem/content/72/">76. 和为S的连续正数序列</a>
 * <a href="https://www.acwing.com/solution/content/1180/">题解</a>
 */
public class ContinuousSequenceSumN {
    public List<List<Integer>> findContinuousSequence(int sum) {
        int i = 1;
        int j = 2;
        List<List<Integer>> ret = new ArrayList<>();
        while (i < j) {
            int s = (i + j) * (j - i + 1) / 2;
            if (s == sum) {
                List<Integer> item = new ArrayList<>();
                for (int x = i; x <= j; x++) {
                    item.add(x);
                }
                ret.add(item);
                j++;
            } else if (s < sum) {
                j++;
            } else {
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new ContinuousSequenceSumN().findContinuousSequence(15));
    }
}
