package newcoder;

import java.util.ArrayList;

/**
 * Link: https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&&tqId=11194&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class ContinuousSequence {

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= sum / 2; i++) {
            int mySum = 0;
            int j = i;
            for (; mySum < sum; j++) {
                mySum += j;
            }
            if (mySum == sum) {
                ArrayList<Integer> item = new ArrayList<>();
                for (int x = i; x < j; x++) {
                    item.add(x);
                }
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ContinuousSequence().findContinuousSequence(1000));
    }
}
