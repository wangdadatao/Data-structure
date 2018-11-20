package com.datao.structure.f_binary_search_tree;

public class Main {


    public static void main(String[] args) {
        TaoBST<Integer> bst = new TaoBST<>();
        int[] nums = {6, 3, 7, 2, 9, 4, 7, 1, 3, 8, 4};

        for (int i : nums) {
            bst.add(i);
            System.out.println(bst.contains(i));
        }

        bst.preOrder();
        System.out.println("^^^前序遍历^^^---------------------------------------");
        bst.preOrderNR();
        System.out.println("^^^非递归前序遍历^^^---------------------------------------");
        bst.inOrder();
        System.out.println("^^^中序遍历^^^----------------------------------------");
        bst.postOrder();
        System.out.println("^^^后序遍历^^^----------------------------------------");
        bst.levelOrder();
        System.out.println("^^^层序遍历^^^----------------------------------------");

        int size = bst.size;
        for (int i = 0; i < size; i++) {
            //System.out.println(bst.removeMin());
            System.out.println(bst.removeMax());
        }
    }

/*

              6
           /    \
         3       7
       /   \    /  \
     2      4       9
    / \    / \     / \
  1      3    4   7
                /  \
                    8

*/
}

