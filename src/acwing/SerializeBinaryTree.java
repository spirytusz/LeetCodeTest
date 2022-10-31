package acwing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://www.acwing.com/problem/content/46/">50. 序列化二叉树</a>
 */
public class SerializeBinaryTree {
    // Encodes a tree to a single string.
    String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();

        List<String> preOrder = new ArrayList<>();
        preOrder(root, preOrder);
        for (String s : preOrder) {
            builder.append(s);
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("|");

        List<String> inOrder = new ArrayList<>();
        inOrder(root, inOrder);
        for (String s : inOrder) {
            builder.append(s);
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] split = data.split("\\|");
        String[] preOrderStr = split[0].split(",");
        String[] inOrderStr = split[1].split(",");
        int[] preOrder = new int[preOrderStr.length];
        int[] inOrder = new int[inOrderStr.length];

        for (int i = 0; i < preOrder.length; i++) {
            preOrder[i] = Integer.parseInt(preOrderStr[i]);
        }
        for (int i = 0; i < inOrder.length; i++) {
            inOrder[i] = Integer.parseInt(inOrderStr[i]);
        }
        return reStruct(preOrder, inOrder);
    }

    private void preOrder(TreeNode node, List<String> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(node.val + "");
        preOrder(node.left, nodes);
        preOrder(node.right, nodes);
    }

    private void inOrder(TreeNode node, List<String> nodes) {
        if (node == null) {
            return;
        }
        inOrder(node.left, nodes);
        nodes.add(node.val + "");
        inOrder(node.right, nodes);
    }

    private int index = 0;

    private TreeNode reStruct(int[] preOrder, int[] inOrder) {
        index = 0;
        HashMap<Integer, Integer> inOrderNumIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderNumIndexMap.put(inOrder[i], i);
        }
        return reStructInternal(preOrder, inOrder, 0, inOrder.length - 1, inOrderNumIndexMap);
    }

    private TreeNode reStructInternal(
            int[] preOrder,
            int[] inOrder,
            int inOrderStart,
            int inOrderEnd,
            HashMap<Integer, Integer> inOrderNumIndexMap
    ) {
        if (index >= preOrder.length || inOrderStart > inOrderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[index++]);
        int inOrderIndex = inOrderNumIndexMap.get(root.val);
        root.left = reStructInternal(preOrder, inOrder, inOrderStart, inOrderIndex - 1, inOrderNumIndexMap);
        root.right = reStructInternal(preOrder, inOrder, inOrderIndex + 1, inOrderEnd, inOrderNumIndexMap);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode n8 = new TreeNode(8);
        TreeNode n12 = new TreeNode(12);
        TreeNode n2 = new TreeNode(2);
        TreeNode n6 = new TreeNode(6);
        TreeNode n14 = new TreeNode(14);

        n8.left = n12;
        n8.right = n2;
        n2.left = n6;
        n2.right = n14;

        TreeNode root = new SerializeBinaryTree().deserialize(new SerializeBinaryTree().serialize(n8));
        System.out.println(new SerializeBinaryTree().serialize(root));
    }
}
