package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&&tqId=11162&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloor2 {

    public int jumpFloor2(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        int[] result = new int[target];
        result[0] = 1;
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[j];
            }
            result[i]++;
        }
        return result[result.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloor2().jumpFloor2(3));
    }
}
