package com.datao.b_stack;

/**
 * void push(E)
 * E pop()
 * E peek()
 * int getSize()
 * boolean isEmpty()
 * <p>
 * - 从用户角度看，支持上述操作就好
 * - 具体底层实现，用户不关心
 * - 实际底层有多种实现方式
 *
 * @param <E>
 */
public interface TaoStack<E> {

    /**
     * 添加元素
     *
     * @param e
     */
    void push(E e);

    /**
     * 取出元素
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();

    int getSize();

    boolean isEmpty();

}
