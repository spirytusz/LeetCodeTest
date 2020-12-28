package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&&tqId=11176&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
public class OutTraverseSequence {
    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return verifySequenceOfBSTInternal(sequence, 0, sequence.length - 1);
    }

    private boolean verifySequenceOfBSTInternal(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int root = sequence[end];
        int leftTreeEndIndex = start;
        while (sequence[leftTreeEndIndex] < root) {
            leftTreeEndIndex++;
        }
        int rightTreeStartIndex = leftTreeEndIndex;
        while (rightTreeStartIndex < end) {
            if (sequence[rightTreeStartIndex++] < root) {
                return false;
            }
        }
        return verifySequenceOfBSTInternal(sequence, start, rightTreeStartIndex - 1) && verifySequenceOfBSTInternal(sequence, rightTreeStartIndex, end - 1);
    }

    public static void main(String[] args) {
        System.out.println(new OutTraverseSequence().verifySequenceOfBST(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }
}
