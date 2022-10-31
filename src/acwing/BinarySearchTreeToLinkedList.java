package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/87/">49. 二叉搜索树与双向链表</a>
 * <a href="https://www.acwing.com/solution/content/7465/">题解</a>
 */
public class BinarySearchTreeToLinkedList {
    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] pre = new TreeNode[1];
        convertInternal(root, pre);
        while (pre[0] != null && pre[0].left != null) {
            pre[0] = pre[0].left;
        }
        return pre[0];
    }

    private void convertInternal(TreeNode root, TreeNode[] pre) {
        if (root == null) {
            return;
        }

        convertInternal(root.left, pre);

        root.left = pre[0];
        if (pre[0] != null) {
            pre[0].right = root;
        }
        pre[0] = root;

        convertInternal(root.right, pre);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode n10 = new TreeNode(10);
        TreeNode n6 = new TreeNode(6);
        TreeNode n14 = new TreeNode(14);
        TreeNode n2 = new TreeNode(2);
        TreeNode n8 = new TreeNode(8);
        TreeNode n12 = new TreeNode(12);
        TreeNode n16 = new TreeNode(16);
        n10.left = n6;
        n10.right = n14;
        n6.left = n2;
        n6.right = n8;
        n14.left = n12;
        n14.right = n16;

        TreeNode listHead = new BinarySearchTreeToLinkedList().convert(n10);
        TreeNode listEnd = null;

        while (listHead != null) {
            System.out.print(listHead.val + "\t");
            if (listHead.right == null) {
                listEnd = listHead;
            }
            listHead = listHead.right;
        }
        System.out.println();

        while (listEnd != null) {
            System.out.print(listEnd.val + "\t");
            listEnd = listEnd.left;
        }

    }
}
