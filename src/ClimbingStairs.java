/**
 * <a href="https://leetcode.com/problems/climbing-stairs/description/">70. Climbing Stairs</a>
 *
 * <div class="elfjS" data-track-load="description_content"><p>You are climbing a staircase. It takes <code>n</code> steps to reach the top.</p>
 *
 * <p>Each time you can either climb <code>1</code> or <code>2</code> steps. In how many distinct ways can you climb to the top?</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> n = 2
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> n = 3
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 45</code></li>
 * </ul>
 * </div>
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int f0 = 1;
        int f1 = 1;
        int way = 0;
        for (int i = 1; i < n; i++) {
            way = f1 + f0;
            f0 = f1;
            f1 = way;
        }
        return way;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }
}
