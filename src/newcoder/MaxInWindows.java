package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11216&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * Status: AC
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 */

import java.util.ArrayList;

public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num.length < size || size == 0) return new ArrayList<>(0);
        ArrayList<Integer> result = new ArrayList<>(num.length - size + 1);
        for (int i = 0; i < num.length - size + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < size; j++) {
                if (num[i + j] > max) {
                    max = num[i + j];
                }
            }
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxInWindows().maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3));
    }
}
