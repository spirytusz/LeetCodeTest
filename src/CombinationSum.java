import java.util.*;

/**
 * Link: https://leetcode.com/problems/combination-sum/
 * Status: AC
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * 1. All numbers (including target) will be positive integers.
 * 2. The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        combinationSumImpl(candidates, result, new ArrayList<>(), target, getDepth(candidates, target));
        return new ArrayList<>(result);
    }

    private static void combinationSumImpl(int[] candidates, Set<List<Integer>> result, List<Integer> item, int target, int depth) {
        if (depth < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(item);
            Collections.sort(temp);
            result.add(temp);
            return;
        }
        for (Integer candidate : candidates) {
            int newTarget = target - candidate;
            if (newTarget < 0) {
                continue;
            }
            item.add(candidate);
            combinationSumImpl(candidates, result, item, newTarget, depth - 1);
            item.remove(candidate);
        }
    }

    private static int getDepth(int[] candidates, int target) {
        int min = Integer.MAX_VALUE;
        for (int candidate : candidates) {
            if (min > candidate) {
                min = candidate;
            }
        }
        return target / min;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<List<Integer>> result = combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(result + "\n" + (System.currentTimeMillis() - start) + "ms");
    }
}
