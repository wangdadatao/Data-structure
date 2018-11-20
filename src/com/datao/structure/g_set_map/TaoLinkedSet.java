package com.datao.structure.g_set_map;

import com.datao.structure.d_linked.TaoLinkedList;

/**
 * 基于链表实现Set
 *
 * @author datao
 */
public class TaoLinkedSet<E> implements TaoSet<E> {

    private TaoLinkedList<E> linkedList;

    public TaoLinkedSet() {
        linkedList = new TaoLinkedList<>();
    }


    /**
     * 集合中不允许有重复元素，所以先要判断
     *
     * @param e
     */
    @Override
    public void add(E e) {
        if (!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean comtains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
