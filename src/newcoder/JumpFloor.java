package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&&tqId=11161&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {

    public int jumpFloor(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int[] result = new int[target];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < target; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[result.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloor().jumpFloor(2));
    }
}
