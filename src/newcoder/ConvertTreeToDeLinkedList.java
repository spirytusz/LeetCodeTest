package newcoder;

import Utils.TreeNode;

/**
 * Link: https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&&tqId=11179&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 解析： 二叉搜索树：
 *      	     4
 *       	   /  \
 *       	  2    6
 *       	 / \  / \
 *       	1  3 5   7
 *
 *  先走到7，继续向下看看7的right，为空返回；
 *  返回后看看if分支，此时pre为空，不走if分支；
 *  然后给pre赋值为7；
 *  继续遍历7的left，为空返回；
 *  返回后直接return pre 即为7，所以走完一个小的二叉搜索树，在这里是  7（只有一个节点，他的孩子都是空的）
 *  会返回这个子节点自己；（结论1）
 *  然后往回退到6，此时pre为7，pRootOfTree为6，走if分支，把6 和 7链接起来；
 *  然后pre赋值为6；
 *  然后向下遍历6的left，到了5，此时pre为6，pRootOfTree为5，5 和 6链接起来；
 *  然后开始对5进行操作，根据结论1，最终会返回5，此时，子树 6
 *                                               /  \
 *                                              5    7
 *  已经操作完毕，可以看出，操作顺序是7，6，5是降序操作（结论2）；
 *  并且对于一个有left孩子的节点组成的子树，一波操作后最终会返回这个子树的最左下的节点（结论3）；
 *  根据结论1，结论2，结论3一起，可以推测，这个程序会：
 *  1. 先把4和5链接起来；
 *  2. 然后把3和4链接起来；
 *  3. 然后把2和3链接起来；
 *  4. 然后把1和2链接起来；
 *  5. 最终返回1；
 *
 *  跑了一遍，证明了这个结论；
 */
public class ConvertTreeToDeLinkedList {
    TreeNode pre = null;

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        convert(pRootOfTree.right);
        if (pre != null) {
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
        }
        pre = pRootOfTree;
        convert(pRootOfTree.left);
        return pre;
    }

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        t2.left = t1;
        t2.right = t3;
        t6.left = t5;
        t6.right = t7;
        t4.left = t2;
        t4.right = t6;
        TreeNode convert = new ConvertTreeToDeLinkedList().convert(t4);
        System.out.println();
        System.out.println();
        while (convert.right != null) {
            System.out.println(convert.val);
            convert = convert.right;
        }
        System.out.println(convert.val);
        System.out.println();
        System.out.println();
        while (convert != null) {
            System.out.println(convert.val);
            convert = convert.left;
        }
    }
}
