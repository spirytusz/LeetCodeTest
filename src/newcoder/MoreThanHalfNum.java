package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&&tqId=11181&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {

    private static class Memory {
        public int val;
        public int count = 0;
    }

    public int moreThanHalfNum(int[] array) {
        Memory[] memories = new Memory[array.length / 2 + 1];
        for (int val : array) {
            for (int j = 0; j < memories.length; j++) {
                if (memories[j] == null) {
                    Memory memory = new Memory();
                    memory.val = val;
                    memory.count++;
                    memories[j] = memory;
                    break;
                } else if (memories[j].val == val) {
                    memories[j].count++;
                }
            }
        }
        for (Memory memory : memories) {
            if ((double)(memory.count) > array.length / 2.0) return memory.val;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{4, 2, 1, 4, 2, 4/*1, 2, 3, 2, 4, 2, 5, 2, 3*/};
        System.out.println(new MoreThanHalfNum().moreThanHalfNum(ints));
    }
}
