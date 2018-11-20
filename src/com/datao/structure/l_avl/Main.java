package com.datao.structure.l_avl;

public class Main {
    public static void main(String[] args) {
        TaoAvlTree<Integer, Integer> avlTree = new TaoAvlTree<>();
        avlTree.add(1, 1);
        System.out.println(avlTree.get(1));
    }
}
