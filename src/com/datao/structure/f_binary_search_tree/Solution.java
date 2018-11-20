package com.datao.structure.f_binary_search_tree;

import java.util.LinkedList;

/**
 * 解决 LeetCode 530号问题：二叉搜索树的最小绝对差
 *
 * @author datao
 */
public class Solution {


    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
        LinkedList<Integer> nums = new LinkedList<>();
        getMinimumDifference(root, nums);

        //有序的数组求任意两数差的最小值只需比较相邻的元素即可
        Integer result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            int min = Math.abs(nums.get(i) - nums.get(i + 1));
            result = Integer.min(result, min);
        }

        return result;
    }

    /**
     * 二分搜素树中序遍历的结果是按照从小到大排序的
     *
     * @param node
     * @param nums
     */
    private void getMinimumDifference(TreeNode node, LinkedList<Integer> nums) {
        if (node != null) {
            getMinimumDifference(node.left, nums);
            nums.add(node.val);
            getMinimumDifference(node.right, nums);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
