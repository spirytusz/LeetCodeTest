package acwing;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.acwing.com/problem/content/47/">51. 数字排列</a>
 */
public class Permutation {

    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        permutationInternal(nums, ret, new ArrayList<>());
        return ret;
    }

    private void permutationInternal(int[] nums, List<List<Integer>> ret, List<Integer> index) {
        if (index.size() == nums.length) {
            List<Integer> item = new ArrayList<>();
            for (int i : index) {
                item.add(nums[i]);
            }
            if (!ret.contains(item)) {
                ret.add(item);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!index.contains(i)) {
                index.add(i);
                permutationInternal(nums, ret, index);
                index.remove((Integer) i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutation().permutation(new int[]{1, 1, 2}));
    }
}
