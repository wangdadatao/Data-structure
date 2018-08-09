package com.datao.d_linked;

public class TaoLinkedList<E> {

    /**
     * 头结点
     */
    private Node head;

    private int size;

    /**
     * 虚拟头结点
     */
    private Node dummyHead;

    public TaoLinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 在链表头添加元素
     *
     * @param e
     */
    public void addFirst(E e) {

//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        //等同于上述三个步骤
//        head = new Node(e, head);

        add(0, e);
    }


    /**
     * 在链表的index(0~based)位置添加新的元素e
     *
     * @param index 索引位置
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }

/*        //判断知否加在了头结点
        if (index == 0) {
            addFirst(e);
        } else {

            //找到要加入的位置
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }

            prev.next = new Node(e, prev.next);
            size++;
        }*/

        //寻找index前一个位置的元素
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表末尾添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }


    /**
     * 获取链表中元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取链表的第index(0~based)个位置的元素
     * 在链表中不是一个常用操作，练习用
     *
     * @param index
     * @return
     */
    public E get(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, Illegal index");
        }

        //找到index位置的元素
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0~based)个位置的元素
     * 在链表中不是常用操作，练习用
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed, Illegal index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    /**
     * 查找链表中是否包含E
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除下标为index(0~based)的元素
     * 返回删除的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed, Illegal index");
        }

        //寻找index前一个位置的元素
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;

        size--;
        return delNode.e;

    }

    /**
     * 删除链表中第一个元素
     * 返回要删除的元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表中最后一个元素
     * 返回要删除的元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("LinkedList: size = %d --> [", size));

/*        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            stringBuffer.append(cur.e).append(",");
            cur = cur.next;
        }*/
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
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
