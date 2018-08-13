package com.datao.d_linked;

/**
 * 双向循环链表
 *
 * @author datao
 */
public class TaoCircularLinkedList<E> {

    private Node<E> dummyNode;

    private int size;


    public TaoCircularLinkedList() {
        size = 0;
        dummyNode = new Node<>(null, null, null);
    }

    /**
     * 在索引为index的位置插入元素
     * 原位置的元素后移
     *
     * @param index
     * @param e
     * @return
     */
    public E add(int index, E e) {
        checkIndex(index);

        Node<E> cur = dummyNode.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        if (cur == null) {
            Node<E> addNode = new Node<>(e, dummyNode, dummyNode);
            dummyNode.prev = addNode;
            dummyNode.next = addNode;

        } else {
            Node<E> addNode = new Node<>(e, cur.prev, cur);
            cur.prev.next = addNode;
            cur.prev = addNode;
        }

        size++;

        return e;
    }


    /**
     * 链表最前边添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 链表最前边添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 删除索引为index的元素
     *
     * @param index
     */
    public E removeIndex(int index) {
        checkIndex(index);

        Node<E> cur = dummyNode.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;

        cur.prev = null;
        cur.next = null;

        size--;
        return cur.e;
    }

    /**
     * 删除链表中值为e的元素
     *
     * @param e
     * @return 删除的元素所在的索引
     */
    public int remove(E e) {
        Node<E> cur = dummyNode.next;
        for (int i = 0; i < size; i++) {
            if (cur.e.equals(e)) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;

                cur.prev = null;
                cur.next = null;
                size--;
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    /**
     * 删除链表中的第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return removeIndex(0);
    }

    /**
     * 删除链表中的最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return removeIndex(size - 1);
    }


    /**
     * 设置索引为index的值为e
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

        E oldVal = cur.e;
        cur.e = e;

        return oldVal;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int i) {
        if (i < 0 || i > size) {
            throw new IllegalArgumentException("Illegal index");
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("["));

        int i = 0;
        for (Node cur = dummyNode.next; i < size; cur = cur.next) {
            stringBuffer.append(cur.e).append(",");
            i++;
        }

        stringBuffer.append("]");

        String result = stringBuffer.toString();
        result = result.replace(",]", "]");
        return result;
    }

    private class Node<E> {
        public E e;
        public Node<E> prev;
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
    }

}
