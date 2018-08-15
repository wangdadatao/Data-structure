package com.datao.g_set_map;

public class TaoLinkedMap<K, V> implements TaoMap<K, V> {

    private Node dummyNode;

    private int size;

    public TaoLinkedMap() {
        dummyNode = new Node(null, null, null);
        size = 0;
    }

    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        //如果没有查找到对应的k，则在node头部新加节点
        //如果已经有改节点更新改及诶单
        if (node == null) {
            dummyNode.next = new Node(k, v, dummyNode.next);
            size++;
        } else {
            node.v = v;
        }
    }

    @Override
    public V remove(K k) {

        Node pre = dummyNode;
        while (pre.next != null) {
            if (pre.next.k == null && k == null) {
                break;
            }

            if (pre.next.k.equals(k)) {
                break;
            }
            pre = pre.next;
        }

        if (pre.next != null) {
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.v;
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        return getNode(k) != null;
    }

    public Node getNode(K k) {

        Node cur = dummyNode.next;
        while (cur != null) {
            //判断当k为null的情况
            if (cur.k == null) {
                if (k == null) {
                    return cur;
                }
            } else if (cur.k.equals(k)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }


    @Override
    public V get(K k) {
        return getNode(k).v;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);

        if (node == null) {
            throw new IllegalArgumentException(k + " doen't exist!");
        }

        node.v = v;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public K k;
        public V v;
        public Node next;

        public Node(K k) {
            this(k, null, null);
        }

        public Node(K k, V v) {
            this(k, v, null);
        }

        public Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }
}
