import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        int depth = getDepth(candidates, target);
        List<List<Integer>> result = new ArrayList<>();
        storeCombinationSum(result, new ArrayList<>(), candidates, target, depth);
        return result;
    }

    private static void storeCombinationSum(List<List<Integer>> result, List<Integer> item, int[] candidates, int target, int depth) {
        if (depth >= 0) {
            if (target == 0) {
                List<Integer> maybeResultItem = new ArrayList<>(item);
                Collections.sort(maybeResultItem);
                if (!result.contains(maybeResultItem)) {
                    result.add(maybeResultItem);
                }
            } else if (target > 0) {
                for (int i = 0; i < candidates.length; i++) {
                    item.add(candidates[i]);
                    storeCombinationSum(result, item, candidates, target - candidates[i], depth - 1);
                    item.remove(item.size() - 1);
                }
            }
        }
    }

    private static int getDepth(int[] arr, int target) {
        int smallest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (smallest > arr[i])
                smallest = arr[i];
        }
        return target / smallest;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<List<Integer>> result = combinationSum(new int[]{4, 2, 7, 5, 6}, 16);
        System.out.println(result + "\n" + (System.currentTimeMillis() - start) + "ms");
    }
}
