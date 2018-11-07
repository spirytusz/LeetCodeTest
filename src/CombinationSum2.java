import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/combination-sum-ii/
 * Status: AC
 * <p>
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * 1. All numbers (including target) will be positive integers.
 * 2. The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSum2 {

    private static List<Integer> item = new ArrayList<>();
    private static int[] memory;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int depth = getDepth(candidates, target);
        memory = new int[candidates.length];
        List<List<Integer>> result = new ArrayList<>();
        storeCombinationSum2(result, candidates, target, depth);
        return result;
    }

    private static void storeCombinationSum2(List<List<Integer>> result, int[] candidates, int target, int depth) {
        if (depth >= 0) {
            if (target == 0) {
                List<Integer> maybeResultItem = new ArrayList<>(item);
                Collections.sort(maybeResultItem);
                if (!result.contains(maybeResultItem)) {
                    result.add(maybeResultItem);
                }
            } else if (target > 0) {
                for (int i = 0; i < candidates.length; i++) {
                    if (memory[i] == 0) {
                        memory[i] = 1;
                        item.add(candidates[i]);
                        storeCombinationSum2(result, candidates, target - candidates[i], depth - 1);
                        item.remove(item.size() - 1);
                        memory[i] = 0;
                    }
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
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
