import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/4sum/
 * Status: AC
 * <p>
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 4, target, 0);
    }

    private static List<List<Integer>> kSum(int[] nums, int k, int target, int startIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        if (k == 1) {
            for (int i = startIndex; i < nums.length; i++) {
                if (nums[i] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(target);
                    lists.add(list);
                    break;
                }
            }
        } else if (k == 2) {
            int i = startIndex;
            int j = nums.length - 1;
            int memory = Integer.MIN_VALUE;
            while (i < j) {
                if (nums[i] + nums[j] == target && memory != nums[i]) {
                    memory = nums[i];
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i++]);
                    list.add(nums[j--]);
                    lists.add(list);
                } else if (nums[i] + nums[j] >= target) {
                    j--;
                } else {
                    i++;
                }
            }
        } else {
            for (int i = startIndex; i < nums.length; i++) {
                List<List<Integer>> kSumResult = kSum(nums, k - 1, target - nums[i], i + 1);
                for (int j = 0; j < kSumResult.size(); j++) {
                    kSumResult.get(j).add(nums[i]);
                    if(!lists.contains(kSumResult.get(j))) {
                        lists.add(kSumResult.get(j));
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] test1 = new int[1000];
        long start = System.currentTimeMillis();
        System.out.println(fourSum(test1, 0).toString().replaceAll(" ","").replaceAll(",",", "));
        long end = System.currentTimeMillis();
        System.out.println((end - start)+"ms");
    }

    private static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + "\t");
        System.out.println();
    }
}