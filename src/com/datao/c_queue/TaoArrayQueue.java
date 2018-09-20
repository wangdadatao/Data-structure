package com.datao.c_queue;

import com.datao.a_array.TaoArray;

/**
 * 数组队列
 *
 * @author datao
 */
public class TaoArrayQueue<E extends  Comparable<E>> implements TaoQueue<E> {

    private TaoArray<E> data;

    public TaoArrayQueue(int capacity) {
        data = new TaoArray<>(capacity);
    }

    public TaoArrayQueue() {
        data = new TaoArray<>();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("Queue: size = %d , capacity = %d --> ", data.getSize(), data.getCapaticy()));

        int size = data.getSize();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(data.get(i)).append(",");
        }

        stringBuffer.append("]");

        String result = stringBuffer.toString();
        result = result.replace(",]", "]");
        return result;
    }


}
