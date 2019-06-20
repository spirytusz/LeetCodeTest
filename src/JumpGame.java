import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/jump-game/
 * Status: AC
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        return canJumpInner(nums, nums.length - 1, new ArrayList<>());
    }

    public static boolean canJumpInner(int[] nums, int position, List<Integer> path) {
        if (position == 0) {
            return true;
        } else {
            path.add(position);
            for (int i = 0; i < nums.length; i++) {
                int left = position - i;
                int right = position + i;
                if (left >= 0 && left < nums.length && nums[left] >= i && !path.contains(left)) {
                    return canJumpInner(nums, left, path);
                }
                if (right >= 0 && right < nums.length && nums[right] >= i && !path.contains(right)) {
                    return canJumpInner(nums, right, path);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
