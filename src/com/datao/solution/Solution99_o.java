package com.datao.solution;

/**
 * 解题思路：
 * 1：判断左子树的所有值是否比当前节点的值小
 * 2：判断右子树的所有值是否比当前值大
 * 3：交换过位置之后再次扫描所有的节点
 *
 * @author datao
 */
public class Solution99_o {

    private TreeNode treeNode;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(1);

        new Solution99_o().recoverTree(root);
        System.out.println(root.val);
    }

    public void recoverTree(TreeNode root) {
        treeNode = root;
        if (!recoverTreeTwo(root)) {
            recoverTree(treeNode);
        }
    }

    public boolean recoverTreeTwo(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean bl = leftComp(root.left, root);
        if (!bl) {
            return bl;
        }

        boolean br = rightComp(root.right, root);
        if (!br) {
            return br;
        }

        return recoverTreeTwo(root.left) && recoverTreeTwo(root.right);

    }

    private boolean leftComp(TreeNode now, TreeNode node) {
        if (now == null) {
            return true;
        }

        if (now.val > node.val) {
            Integer temp = node.val;
            node.val = now.val;
            now.val = temp;
            return false;
        }

        return leftComp(now.left, node) && leftComp(now.right, node);
    }

    private boolean rightComp(TreeNode now, TreeNode node) {
        if (now == null) {
            return true;
        }

        if (now.val < node.val) {
            Integer temp = node.val;
            node.val = now.val;
            now.val = temp;
            return false;
        }
        return rightComp(now.left, node) && rightComp(now.right, node);
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
