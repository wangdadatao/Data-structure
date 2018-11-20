package com.datao.structure.d_linked;

import com.datao.structure.b_stack.TaoStack;

/**
 * @author datao
 */
public class TaoLinkedListStack<E> implements TaoStack<E> {

    private TaoLinkedList<E> list;

    public TaoLinkedListStack() {
        list = new TaoLinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack: top -->");
        stringBuilder.append(list.toString());

        return stringBuilder.toString();
    }
}
