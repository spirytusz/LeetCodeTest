package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&&tqId=11154&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
 * 个整数，判断数组中是否含有该整数。
 * <p>
 * 示例1
 * Input: 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * Output: true
 */
public class BinarySearchTwoDimensArray {

    public static boolean find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) return false;
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (array[low][0] == target) {
            return true;
        }
        int arch = low;
        for (int i = 0; i <= arch; i++) {
            low = 0;
            high = array[i].length - 1;
            while (low < high) {
                int mid = (low + high) / 2;
                if (array[i][mid] > target) {
                    high = mid - 1;
                } else if (array[i][mid] < target) {
                    low = mid + 1;
                } else {
                    return true;
                }
            }
            if (array[i][low] == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {}
        };
        System.out.println(find(9, array));
    }
}
