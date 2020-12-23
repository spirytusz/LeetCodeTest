package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&&tqId=11190&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 统计一个数字在升序数组中出现的次数。
 */
public class GetNumberOfK {

    public int getNumberOfK(int[] array, int k) throws InterruptedException {
        int low = 0;
        int high = array.length - 1;
        int index = -1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] < k) {
                low = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        if (index == -1) index = low;
        int count = 0;
        int backIndex = index - 1;
        while (index < array.length && array[index++] == k) {
            count++;
        }
        while (backIndex >= 0 && array[backIndex--] == k) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new GetNumberOfK().getNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 5));
    }
}
