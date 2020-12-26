package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&&tqId=11219&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * <p>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {

    public int movingCount(int threshold, int rows, int cols) {
        int[][] mark = new int[rows][cols];
        int result = 0;
        for (int i = 0; i < mark.length; i++) {
            for (int j = 0; j < mark[i].length; j++) {
                if (!check(i, j - 1, rows, cols) && !check(i - 1, j, rows, cols)) {
                    if (sumOfShift(i) + sumOfShift(j) <= threshold) {
                        mark[i][j] = 1;
                        result++;
                    }
                } else if (check(i, j - 1, rows, cols) && mark[i][j - 1] == 1) {
                    if (sumOfShift(i) + sumOfShift(j) <= threshold) {
                        mark[i][j] = 1;
                        result++;
                    }
                } else if (check(i - 1, j, rows, cols) && mark[i - 1][j] == 1) {
                    if (sumOfShift(i) + sumOfShift(j) <= threshold) {
                        mark[i][j] = 1;
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private boolean check(int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }

    private int sumOfShift(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(10, 1, 100));
    }
}
