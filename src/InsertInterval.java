import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Link: https://leetcode.com/problems/insert-interval/
 * Status: AC
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * Example 3:
 * <p>
 * Input: intervals = [], newInterval = [5,7]
 * Output: [[5,7]]
 * Example 4:
 * <p>
 * Input: intervals = [[1,5]], newInterval = [2,3]
 * Output: [[1,5]]
 * Example 5:
 * <p>
 * Input: intervals = [[1,5]], newInterval = [2,7]
 * Output: [[1,7]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals is sorted by intervals[i][0] in ascending order.
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 */

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list1 = Arrays.stream(intervals).collect(Collectors.toList());
        list1.add(newInterval);
        return merge(list1.toArray(new int[list1.size()][]));
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(intervals[i][1], current[1]);
                System.out.println("[" + current[0] + ", " + current[1] + "]");
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                /*{1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
                {1, 3},
                {6, 9}*/
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] b = new int[]{4, 8};
        int[][] result = insert(a, b);
        System.out.println("length = " + result.length);
        for (int[] ints : result) {
            System.out.println(String.format("[%d, %d]", ints[0], ints[1]));
        }
    }
}
