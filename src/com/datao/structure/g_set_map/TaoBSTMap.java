package com.datao.structure.g_set_map;

public class TaoBSTMap<K extends Comparable<K>, V> implements TaoMap<K, V> {

    private Node root;

    private int size;


    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    /**
     * 向以Node为根节点的热分搜索树插入元素e
     * <p>
     * 递归算法
     * <p>
     * 返回插入新节点后二分搜索树的根
     *
     * @param node
     * @param k
     */
    private Node add(Node node, K k, V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }

        //进入递归
        //添加已有的k时更新改k的值
        if (k.compareTo(node.k) < 0) {
            node.left = add(node.left, k, v);
        } else if (k.compareTo(node.k) > 0) {
            node.right = add(node.right, k, v);
        } else if (k.compareTo(node.k) == 0) {
            node.v = v;
        }

        return node;
    }

    @Override
    public V remove(K k) {
        Node node = getNode(k);
        if (node != null) {
            root = remove(root, k);
            return node.v;
        }
        return null;
    }

    private Node remove(Node node, K k) {

        if (node == null) {
            return node;
        }

        if (k.compareTo(node.k) < 0) {
            node.left = remove(node.left, k);
        } else if (k.compareTo(node.k) > 0) {
            node.right = remove(node.right, k);
        } else {
            //待删除的元素左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //待删除的元素右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待删除的节点左右子树均不为空时
            //找到比待删除节点大的最小节点，即待删除节点右节点的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
        return node;
    }

    /**
     * 返回以Node为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除最小元素
     *
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public Node getNode(K k) {
        return getNode(root, k);
    }

    private Node getNode(Node node, K k) {

        if (node == null) {
            return null;
        }

        if (node.k.compareTo(k) == 0) {
            return node;
        } else if (node.k.compareTo(k) > 0) {
            return getNode(node.right, k);
        } else if (node.k.compareTo(k) < 0) {
            return getNode(node.left, k);
        }

        return node;

    }

    @Override
    public boolean contains(K k) {
        return getNode(k) != null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.v;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            throw new IllegalArgumentException(k + " doesn't exist!");
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
        public Node left;
        public Node right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
        }
    }
}
