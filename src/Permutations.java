import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/permutations/description
 * Status: AC
 *
 * Given an array nums of distinct integers, return all the possible
 * permutations
 * . You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length > 0) {
            permuteImpl(result, new ArrayList<>(), nums, new boolean[nums.length], 0);
        }
        return result;
    }

    private static void permuteImpl(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] useFlag, int layer) {
        if (layer == nums.length) {
            List<Integer> item = new ArrayList<>(temp);
            result.add(item);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (useFlag[i]) {
                    continue;
                }
                temp.add(nums[i]);
                useFlag[i] = true;

                permuteImpl(result, temp, nums, useFlag, layer + 1);

                useFlag[i] = false;
                temp.remove((Integer) nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
