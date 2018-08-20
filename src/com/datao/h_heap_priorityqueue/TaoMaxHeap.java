package com.datao.h_heap_priorityqueue;

import com.datao.a_array.TaoArray;

/**
 * 最大堆
 *
 * @author datao
 */
public class TaoMaxHeap<E extends Comparable<E>> {

    private TaoArray<E> data;

    /**
     * Heapify
     * 将数组转为堆
     *
     * @param arr
     */
    public TaoMaxHeap(E[] arr) {
        data = new TaoArray<>(arr);

        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public TaoMaxHeap(int capacity) {
        data = new TaoArray<>(capacity);
    }

    public TaoMaxHeap() {
        data = new TaoArray<>();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't hava parent.");
        }
        return (index - 1) / 2;
    }


    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);

        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮操作
     *
     * @param k
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Heap is empty");
        }
        return data.get(0);
    }

    /**
     * 取出堆中的最大元素
     *
     * @return
     */
    public E extractMax() {
        E result = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return result;
    }

    /**
     * 下沉操作
     *
     * @param k 要下沉的索引
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            //data[j] 是 leftChild 和 rightChild 中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E result = findMax();

        data.set(0, e);

        siftDown(0);
        return result;
    }

}
