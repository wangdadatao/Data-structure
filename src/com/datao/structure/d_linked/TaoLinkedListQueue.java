package com.datao.structure.d_linked;

import com.datao.structure.c_queue.TaoQueue;

/**
 * 单向链表队列
 *
 * @author datao
 */
public class TaoLinkedListQueue<E> implements TaoQueue<E> {

    /**
     * 队首指针
     */
    private Node head;

    /**
     * 队首指针
     */
    private Node tail;


    private int size;

    public TaoLinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        //当队尾为空时，说明现在是空队列，此时head、tail指向同一个元素
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is Empty!");
        }

        Node delNode = head;
        head = head.next;
        delNode.next = null;

        //如果仅有一个元素删除后 tail指引的也被删除了
        if (head == null) {
            tail = null;
        }

        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is Empty!");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("LinkedListQueue: size = %d --> [", size));

        for (Node cur = head; cur != null; cur = cur.next) {
            stringBuffer.append(cur.e).append(",");
        }

        stringBuffer.append("]");

        String result = stringBuffer.toString();
        result = result.replace(",]", "]");
        return result;
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
