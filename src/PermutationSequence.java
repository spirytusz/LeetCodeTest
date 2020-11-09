
/**
 * Link: https://leetcode.com/problems/permutation-sequence/
 * Status: AC
 *
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * Example 3:
 *
 * Input: n = 3, k = 1
 * Output: "123"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 */
public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        String[] ints = new String[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n ; i++) {
            ints[i] = (i + 1)+"";
            used[i] = false;
        }
        Counter counter = new Counter();
        counter.k = k;
        get(ints, counter, used, 0);
        return counter.result;
    }

    private static void get(String[] ints, Counter counter, boolean[] used, int layer) {
        if (layer == used.length && counter.result == null) {
            counter.count++;
            if (counter.count == counter.k) {
                counter.result = counter.builder.toString();
            }
        } else if (counter.result == null) {
            for (int i = 0;i < ints.length; i++) {
                if (used[i]) continue;
                if (counter.result != null) break;
                counter.builder.append(ints[i]);
                used[i] = true;
                get(ints, counter, used, layer + 1);
                used[i] = false;
                counter.builder.deleteCharAt(counter.builder.length() - 1);
            }
        }
    }

    private static class Counter {
        int count = 0;
        int k;
        StringBuilder builder = new StringBuilder();
        String result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(getPermutation(9, 37098));
        System.out.println(System.currentTimeMillis() - start);
    }
}
