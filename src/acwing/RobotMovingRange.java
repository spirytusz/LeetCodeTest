package acwing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://www.acwing.com/problem/content/22/">24. 机器人的运动范围</a>
 */
public class RobotMovingRange {

    public int movingCount(int threshold, int rows, int cols) {
        if (rows == 0 || cols == 0) {
            return 0;
        }
        return bfs(rows, cols, threshold);
    }

    private final int[][] direction = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private int bfs(int rows, int cols, int threshold) {
        int ret = 0;
        Queue<Position> queue = new LinkedList<>();
        boolean[][] reach = new boolean[rows][cols];
        queue.offer(new Position(0, 0));
        reach[0][0] = true;
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            ret++;
            for (int[] ints : direction) {
                int newR = pos.r + ints[0];
                int newC = pos.c + ints[1];
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && !reach[newR][newC] && match(newR, newC, threshold)) {
                    queue.offer(new Position(newR, newC));
                    reach[newR][newC] = true;
                }
            }
        }
        new ArrayList<Integer>();
        return ret;
    }

    private boolean match(int r, int c, int threshold) {
        return (sumOfDigit(r) + sumOfDigit(c)) <= threshold;
    }

    private int sumOfDigit(int num) {
        int ret = 0;
        while (num != 0) {
            ret += num % 10;
            num /= 10;
        }
        return ret;
    }

    private static class Position {
        int r;
        int c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(new RobotMovingRange().movingCount(3, 13, 14));
    }
}
