package acwing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://www.acwing.com/problem/content/54/">58. 把数组排成最小的数</a>
 */
public class CombineNumbersAsSmallest {

    public String printMinNumber(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }

        Collections.sort(numbers, new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        String ret = "";
        for (int num : numbers) {
            ret += num;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new CombineNumbersAsSmallest().printMinNumber(new int[]{3, 32, 321}));
    }
}
