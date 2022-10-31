package acwing;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.acwing.com/problem/content/88/">54. 数据流中的中位数</a>
 */
public class NumberStreamMedian {
    private final List<Integer> nums = new ArrayList<>();

    public void insert(Integer num) {
        if (nums.isEmpty()) {
            nums.add(num);
        } else {
            binaryInsert(num);
        }
    }

    public Double getMedian() {
        if (nums.size() == 0) {
            return 0.0;
        } else if ((nums.size() & 1) == 1) {
            return nums.get(nums.size() / 2) + 0.0;
        } else {
            int first = nums.get(nums.size() / 2);
            int second = nums.get(nums.size() / 2 - 1);
            return (first + second) / 2.0;
        }
    }

    private void binaryInsert(Integer num) {
        int low = 0;
        int high = nums.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) == num) {
                low = mid;
                break;
            } else if (nums.get(mid) > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (nums.get(low) < num) {
            nums.add(low + 1, num);
        } else {
            nums.add(low, num);
        }
    }

    public static void main(String[] args) {
        NumberStreamMedian numberStreamMedian = new NumberStreamMedian();
        numberStreamMedian.insert(1);
        System.out.println(numberStreamMedian.getMedian());
        numberStreamMedian.insert(2);
        System.out.println(numberStreamMedian.getMedian());
        numberStreamMedian.insert(3);
        System.out.println(numberStreamMedian.getMedian());
        numberStreamMedian.insert(5);
        System.out.println(numberStreamMedian.getMedian());
    }
}
