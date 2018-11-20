package com.datao.structure.g_set_map;

import com.datao.structure.f_binary_search_tree.TaoBST;

/**
 * 基于二分搜索树实现Set
 *
 * @author datao
 */
public class TaoBSTSet<E extends Comparable<E>> implements TaoSet<E> {

    private TaoBST<E> bst = new TaoBST<E>();

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean comtains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
