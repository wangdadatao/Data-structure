package com.datao.structure.h_heap_priorityqueue;

import com.datao.structure.c_queue.TaoQueue;

/**
 * 优先队列
 * <p>
 * 最大堆实现
 *
 * @author datao
 */
public class TaoPriorityQueue<E extends Comparable<E>> implements TaoQueue<E> {

    private TaoMaxHeap<E> taoMaxHeap;

    @Override
    public void enqueue(E e) {
        taoMaxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return taoMaxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return taoMaxHeap.findMax();
    }

    @Override
    public int getSize() {
        return taoMaxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return taoMaxHeap.isEmpty();
    }
}
