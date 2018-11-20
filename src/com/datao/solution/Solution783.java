package com.datao.solution;

import java.util.ArrayList;

public class Solution783 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(71);

        root.left = new TreeNode(62);
        root.left.left = new TreeNode(14);

        root.right = new TreeNode(84);
        root.right.right = new TreeNode(88);

        System.out.println(new Solution783().minDiffInBST(root));
    }

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ArrayList<Integer> set = new ArrayList<>();
        min(root, set);

        Integer result = 999999;
        for (int i = 0; i < set.size() - 1; i++) {
            result = Math.min(result, Math.abs(set.get(i) - set.get(i + 1)));
        }
        return result;

    }

    private void min(TreeNode node, ArrayList<Integer> set) {
        if (node == null) {
            return;
        }

        min(node.left, set);
        set.add(node.val);
        min(node.right, set);
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
