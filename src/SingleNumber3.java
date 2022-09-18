/**
 * <a href="https://leetcode.com/problems/single-number-iii/">260. Single Number III</a>
 * <a href="https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C%2B%2BJava-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations">Accepted C++/Java O(n)-time O(1)-space Easy Solution with Detail Explanations</a>
 * <a href="https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C++Java-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations/263807">VISUALIZATION</a>
 * <p>
 * <br/>
 * 1. 一轮异或，得到 aXORb;
 * <br/>
 * 2. 使用Last Set Bit(LSB) 算法，获取aXORb二进制下（从低位到高位）第一个1，得到lsb
 * <br/>
 * &nbsp;&nbsp;&nbsp;&nbsp; lsb = aXORb & (-aXORb);
 * <br/>
 * &nbsp;&nbsp;&nbsp;&nbsp; 取负号实际上就是补码，LSB算法实际上就是与自己的补码按位与;
 * <br/>
 * &nbsp;&nbsp;&nbsp;&nbsp; 例如:
 * <br/>
 * &nbsp;&nbsp;&nbsp;&nbsp; 3 = 011
 * <br/>
 * &nbsp;&nbsp;&nbsp;&nbsp; 5 = 101
 * <br/>
 * &nbsp;&nbsp;&nbsp;&nbsp; 3 ^ 5 = 110
 * <br/>
 * &nbsp;&nbsp;&nbsp;&nbsp; lsb = 010
 * <br/>
 * 3. 所有数字和lsb按位与有：
 * <br/>
 * &nbsp;&nbsp;&nbsp;&nbsp; 3.1. 必然能分为两组（一组该位为1，另一组该位为0），且按位与的结果只可能是lsb或者0;
 * <br/>
 * &nbsp;&nbsp;&nbsp;&nbsp; 3.2. a和b在不同的组中（因为a和b在这个位上的异或结果为1，表明a和b在该位上不同）;
 * <br/>
 * &nbsp;&nbsp;&nbsp;&nbsp; 3.3.在两组中，除了a和b，其他数字都会出现两次以上;
 * <br/>
 * 4. 如果按位与的结果为lsb，为第一组，否则为第二组；
 * <br/>
 * 5. 第一组不断异或，剩下的结果就是a；
 * <br/>
 * 6. 第二组不断异或，剩下的结果就是b；
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int aXORb = 0;
        for (int num : nums) {
            aXORb ^= num;
        }
        int lastSetBit = aXORb & (-aXORb);
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & lastSetBit) == lastSetBit) {
                // group 1
                a ^= num;
            } else {
                // group 2
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 3, 4, 4, 6, 6, 2, 5};
        int[] res = new SingleNumber3().singleNumber(nums);
        System.out.println(res[0] + "\t" + res[1]);
    }
}
