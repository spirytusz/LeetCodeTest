package newcoder;

import Utils.ArrayUtil;

/**
 * Link: https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&&tqId=11216&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class IntStreamMedium {

    private int[] arr = null;

    public void insert(Integer num) {
        if (arr == null) {
            arr = new int[]{num};
        } else {
            arr = insertNum(num);
        }
    }

    private int[] insertNum(int num) {
        int[] array = new int[arr.length + 1];
        int index = findIndex(num);
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                array[i] = num;
            } else {
                if (i < index) {
                    array[i] = arr[i];
                } else {
                    array[i] = arr[i - 1];
                }
            }
        }
        return array;
    }

    private int findIndex(int num) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == num) return mid;
            else if (arr[mid] > num) high = low - 1;
            else low = mid + 1;
        }
        return arr[low] < num ? low + 1 : low;
    }

    public Double getMedian() {
        return arr != null ? arr.length % 2 == 1 ? (double) arr[arr.length / 2] : (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0 : 0.0;
    }

    public static void main(String[] args) throws InterruptedException {
        IntStreamMedium intStreamMedium = new IntStreamMedium();
        intStreamMedium.insert(6);
        System.out.println(intStreamMedium.getMedian());
        intStreamMedium.insert(5);
        System.out.println(intStreamMedium.getMedian());
        intStreamMedium.insert(4);
        System.out.println(intStreamMedium.getMedian());
        intStreamMedium.insert(3);
        System.out.println(intStreamMedium.getMedian());
        intStreamMedium.insert(2);
        System.out.println(intStreamMedium.getMedian());
        intStreamMedium.insert(1);
        System.out.println(intStreamMedium.getMedian());
    }
}
