package com.datao.solution;

/**
 * 解题思路：
 * 1：判断左子树的所有值是否比当前节点的值小
 * 2：判断右子树的所有值是否比当前值大
 * 3：交换过位置之后再次扫描所有的节点
 *
 * @author datao
 */
public class Solution99 {

    private TreeNode treeNode;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(4);
        new Solution99().recoverTree(root);
        System.out.println(root.val);
    }

    public void recoverTree(TreeNode root) {
        treeNode = treeNode;
        recoverTreeTwo(root);
    }

    public void recoverTreeTwo(TreeNode root) {
        if (root == null) {
            return;
        }

        leftComp(root.left, root);
        rightComp(root.right, root);

        recoverTreeTwo(root.left);
        recoverTreeTwo(root.right);
    }

    private void leftComp(TreeNode now, TreeNode node) {
        if (now == null) {
            return;
        }

        if (now.val > node.val) {
            Integer temp = node.val;
            node.val = now.val;
            now.val = temp;

            //每次换过位置后从头扫描下树
            //TOTO 待优化，如果下面代码运行后没有更换任何节点的位置，则这行代码之后的代码都没必要执行了，因为树已经完全正确了。
            recoverTreeTwo(treeNode);
            return;
        }

        leftComp(now.left, node);
        leftComp(now.right, node);
    }

    private void rightComp(TreeNode now, TreeNode node) {
        if (now == null) {
            return;
        }

        if (now.val < node.val) {
            Integer temp = node.val;
            node.val = now.val;
            now.val = temp;

            recoverTreeTwo(treeNode);
            return;
        }

        rightComp(now.left, node);
        rightComp(now.right, node);
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
