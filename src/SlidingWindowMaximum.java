import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum/">239. Sliding Window Maximum</a>
 * <a href="https://www.acwing.com/solution/content/853/">AcWing 79. 滑动窗口的最大值</a>
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return nums;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 1. 检查下标差值。如果 ≥ k，表明队首代表的元素不可能在当前窗口内，队首出队
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }

            // 2. 从队尾开始，检查队列中的元素与新来元素的大小，＜ 新来的元素就出队
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                // 3. 队首必定是窗口内的最大值
                ret[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ret = new SlidingWindowMaximum().maxSlidingWindow(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        for (int i : ret) {
            System.out.print(i + "\t");
        }
    }
}
