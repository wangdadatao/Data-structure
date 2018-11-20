package com.datao.structure.l_avl;

import com.datao.structure.d_linked.TaoLinkedListQueue;
import com.datao.structure.d_linked.TaoLinkedListStack;

/**
 * 二分搜索树
 * 传入的泛型E必须继承Comparable(必须具有可比较性）
 *
 * @author datao
 */
public class TaoBST<E extends Comparable<E>, V> {

    /**
     * 根节点
     */
    public Node root;

    /**
     * 树中元素的个数
     */
    public int size;

    public TaoBST() {
        root = null;
        size = 0;
    }

    public void add(E e) {
        /*
            if (root == null) {
                root = new Node(e);
                size++;
            } else {
                add1(root, e);
            }
        */

        root = add2(root, e);
    }

    /**
     * 向以Node为根节点的二分搜索树插入元素e
     * <p>
     * 递归算法
     *
     * @param node
     * @param e
     */
    private void add1(Node node, E e) {

        //终止条件
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        //进入递归
        if (e.compareTo(node.e) < 0) {
            add1(node.left, e);
        } else {
            add1(node.right, e);
        }

    }

    /**
     * 向以Node为根节点的热分搜索树插入元素e
     * <p>
     * 递归算法
     * <p>
     * 返回插入新节点后二分搜索树的根
     *
     * @param node
     * @param e
     */
    private Node add2(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        //进入递归
        //判断条件中大于或等于0的回加入到右子树，所以可以包含重复元素
        if (e.compareTo(node.e) < 0) {
            node.left = add2(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add2(node.right, e);
        }

        return node;
    }

    /**
     * 判断二分搜索树中是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 判断以node为根的二分搜索树中是否包含元素e
     * <p>
     * 递归算法
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        return false;
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树
     * <p>
     * 递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {
        /*
                if (node == null) {
                    return;
                }
                System.out.println(node.e);
                preOrder(node.left);
                preOrder(node.right);
        */
        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    /**
     * 非递归前序遍历
     */
    public void preOrderNR() {
        TaoLinkedListStack<Node> stack = new TaoLinkedListStack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }

        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树
     * <p>
     * 递归算法
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树
     * <p>
     * 递归算法
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    /**
     * 层序遍历
     */
    public void levelOrder() {
        TaoLinkedListQueue<Node> queue = new TaoLinkedListQueue<>();

        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node cur = queue.dequeue();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.enqueue(cur.left);
            }

            if (cur.right != null) {
                queue.enqueue(cur.right);
            }
        }
    }


    /**
     * 寻找二分搜索树的最小节点
     *
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty！");
        }
        return minimum(root).e;
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
     * 寻找二分搜索树的最小节点
     *
     * @return
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty！");
        }
        return maximum(root).e;
    }


    /**
     * 返回以Node为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除最小元素
     *
     * @return
     */
    public E removeMin() {
        E result = minimum();
        root = removeMin(root);
        return result;
    }

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


    /**
     * 删除最大元素
     *
     * @return
     */
    public E removeMax() {
        E result = maximum();
        root = removeMax(root);
        return result;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    /**
     * 删除二分搜索树中任意元素e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {

        if (node == null) {
            return node;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
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


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }


}
