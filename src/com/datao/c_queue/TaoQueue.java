package com.datao.c_queue;

public interface TaoQueue<E> {

    /**
     * 入列
     */
    void enqueue(E e);

    /**
     * 出列
     *
     * @return
     */
    E dequeue();

    /**
     * 查询队首元素
     *
     * @return
     */
    E getFront();

    /**
     * 查询队列元素数量
     *
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

}
