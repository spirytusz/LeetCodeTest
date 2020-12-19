package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&&tqId=11163&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * <p>
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 * ![exp](https://uploadfiles.nowcoder.com/images/20201028/59_1603852524038_7FBC41C976CACE07CB222C3B890A0995)
 */
public class RectCover {

    public int rectCover(int target) {
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
        System.out.println(new RectCover().rectCover(3));
    }
}
