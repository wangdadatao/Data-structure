package com.datao.structure.c_queue;

/**
 * 循环队列
 *
 * @param <E>
 * @author datao
 */
public class TaoLoopQueue<E> implements TaoQueue<E> {

    private E[] data;

    private int front, tail;

    /**
     * 可不声明，可通过 front与tail关系计算出来
     */
    private int size;

    public TaoLoopQueue(int capacity) {
        //浪费一元素，为了满足用户期望的容量，所以+1
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public TaoLoopQueue() {
        this(10);
    }

    public int getCapacity() {
        //真正的容量为数组长度-1
        return data.length - 1;
    }


    @Override
    public void enqueue(E e) {
        //判断队列是否是满的
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 队列扩容
     *
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];

        //从0开始循环
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue !");
        }

        E result = data[front];
        data[front] = null;

        front = (front + 1) % data.length;
        size--;

        //当使用容量为总容量的1/4时，容量缩小一半
        if (size == getCapacity() / 4 && (getCapacity() / 2 != 0)) {
            resize(getCapacity() / 2);
        }

        return result;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is null!");
        }

        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("Queue: size = %d , capacity = %d --> ", size, getCapacity()));

        //从front开始循环, i循环+1 但是不能等于tail
        for (int i = front; i != tail; i = ((i + 1) % data.length)) {
            stringBuffer.append(data[i]).append(",");
        }

        stringBuffer.append("]");

        String result = stringBuffer.toString();
        result = result.replace(",]", "]");
        return result;
    }

}
