package com.datao.structure.d_linked;

/**
 * 双向链表
 *
 * @author datao
 */
public class TaoDoubluLinkedList<E> {

    private Node<E> dummyNode;

    private int size;

    private Node<E> tail;

    public TaoDoubluLinkedList() {
        dummyNode = new Node<>(null);
        size = 0;
        tail = null;
    }

    /**
     * 在尾部添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        if (tail == null) {
            tail = new Node<>(e, dummyNode, null);
            dummyNode.next = tail;
        } else {
            Node<E> addNode = new Node<>(e, tail, null);
            tail.next = addNode;
            tail = addNode;
        }
        size++;
    }

    /**
     * 首部添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        Node<E> addNode = new Node<>(e, dummyNode, dummyNode.next);

        if (dummyNode.next != null) {
            dummyNode.next.prev = addNode;
        }

        dummyNode.next = addNode;

        if (tail == null) {
            tail = addNode;
        }
        size++;
    }

    /**
     * 链表中添加元素，默认在尾部添加
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    /**
     * 索引为index的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        checkIndex(index);

        Node<E> cur = dummyNode.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的首个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表中第一个元素
     *
     * @return
     */
    public E getLast() {
        if (tail == null) {
            throw new IllegalArgumentException("Linked List Is Empty");
        } else {
            return tail.e;
        }
    }

    /**
     * 查询链表中第一个元素为e的索引
     *
     * @param e
     * @return
     */
    public int indexOf(E e) {
        Node<E> cur = dummyNode.next;
        for (int i = 0; cur != null; i++) {
            if (cur.e.equals(e)) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    /**
     * 判断链表中是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return indexOf(e) != -1;

    }

    /**
     * 删除下标为index的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        checkIndex(index);

        int i = 0;
        Node<E> cur = null;
        for (cur = dummyNode.next; i < index; cur = cur.next) {
            i++;
        }

        cur.prev.next = cur.next;
        if (cur.next != null) {
            cur.next.prev = cur.prev;
        }
        cur.prev = null;
        cur.next = null;

        size--;
        return cur.e;
    }

    /**
     * 设置下标index元素的值为e
     *
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e) {
        checkIndex(index);

        Node<E> cur = dummyNode.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
        return e;
    }

    /**
     * 删除链表的第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表的最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }


    private void checkIndex(int i) {
        if (i < 0 || i > size) {
            throw new IllegalArgumentException("Illegal index");
        }
    }

    /**
     * 获取链表元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node<E> cur = dummyNode.next;
        while (cur != null) {
            stringBuilder.append(cur.e).append(",");
            cur = cur.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString().replace(",]", "]");

    }

    private class Node<E> {
        public E e;

        /**
         * 左节点
         */
        public Node<E> prev;

        /**
         * 右节点
         */
        public Node<E> next;

        public Node(E e) {
            this.e = e;
            this.prev = null;
            this.next = null;
        }

        public Node(E e, Node<E> prev, Node<E> next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }


        @Override
        public String toString() {
            return e.toString();
        }

    }

}
