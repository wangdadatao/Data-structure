package com.datao.b_stack;

import com.datao.a_array.TaoArray;

public class TaoArrayStack<E> implements TaoStack<E> {

    private TaoArray<E> array;

    public TaoArrayStack(int capacity) {
        array = new TaoArray<>(capacity);
    }

    public TaoArrayStack() {
        array = new TaoArray<>();
    }

    /**
     * 查询栈的容量
     *
     * @return
     */
    public int getCapacity() {
        return array.getCapaticy();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("Stack: size = %d , capacity = %d --> [", array.getSize(), getCapacity()));

        int size = array.getSize();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(array.get(i)).append(",");
        }

        stringBuffer.append("]");

        String result = stringBuffer.toString();
        result = result.replace(",]", "]");
        return result;
    }
}
