package com.datao.structure.l_avl;

import com.datao.structure.a_array.TaoArray;

/**
 * @author datao
 */
public class TaoAvlTree<K extends Comparable<K>, V> {

    private Node root;

    private int size;


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

        //更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);

        //平衡维护
        //左子树高度大于右子树高度  LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        //左子树高度大于右子树高度  LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //右子树高度大于左子树高度  RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        //右子树高度大于左子树高度  RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }


        return node;
    }

    //
    //右旋转
    //
    //       y                                       X
    //     /  \                                   /    \
    //   T1    x                                 Y      Z
    //        / \         ------------>        /  \   /  \
    //      T2   z                           T1   T2 T3  T4
    //          / \
    //        T3  T4
    //@param y
    //@return
    //
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;

        //向左旋转
        x.left = y;
        y.right = t2;

        //更近节点的height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }


    //
    //右旋转
    //
    //            y                                   X
    //          /  \                               /    \
    //         x   T4                            Z       Y
    //       /  \         ------------>        /  \     /  \
    //     z    T3                           T1   T2   T3  T4
    //   /  \
    //  T1  T2
    //@param y
    //@return
    //
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;

        //向右旋转
        x.right = y;
        y.left = t3;

        //更新节点height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }


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

        Node retNode;
        if (k.compareTo(node.k) < 0) {
            node.left = remove(node.left, k);
            retNode = node;
        } else if (k.compareTo(node.k) > 0) {
            node.right = remove(node.right, k);
            retNode = node;
        } else {
            //待删除的元素左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            }

            //待删除的元素右子树为空
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            }

            //待删除的节点左右子树均不为空时
            //找到比待删除节点大的最小节点，即待删除节点右节点的最小节点
            //用这个节点顶替待删除节点的位置
            else {
                Node successor = minimum(node.right);
                successor.right = remove(node.right, successor.k);
                successor.left = node.left;

                node.left = node.right = null;
                retNode = node;
            }
        }

        if (retNode == null) {
            return retNode;
        }

        //更新height
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        //计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);

        //平衡维护
        //左子树高度大于右子树高度  LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }

        //左子树高度大于右子树高度  LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }

        //右子树高度大于左子树高度  RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }

        //右子树高度大于左子树高度  RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
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

    public boolean contains(K k) {
        return getNode(k) != null;
    }

    public V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.v;
    }

    public void set(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            throw new IllegalArgumentException(k + " doesn't exist!");
        }

        node.v = v;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回节点的高度值
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    /**
     * 计算平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }


    /**
     * 判断AVL是否是二分搜索树
     *
     * @return
     */
    public boolean isBst() {
        TaoArray<K> keys = new TaoArray<>();
        inOrder(root, keys);

        for (int i = 1; i < keys.getSize(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, TaoArray<K> keys) {
        if (node == null) {
            return;
        }

        inOrder(node.left, keys);
        keys.addLast(node.k);
        inOrder(node.right, keys);
    }


    /**
     * 是否是平衡二叉树
     * <p>
     * 判断左右两个子节点平衡因子差是否小于等于1
     *
     * @return
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);

    }

    private class Node {
        public K k;
        public V v;
        public Node left;
        public Node right;

        //当前节点所处的高度
        public int height;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
            height = 1;
        }
    }
}
