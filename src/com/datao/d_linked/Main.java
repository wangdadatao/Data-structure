package com.datao.d_linked;

import com.datao.b_stack.TaoStack;

public class Main {
    public static void main(String[] args) {
        //testLinkedList();
        //testLinkedListStack();

        //测试数组队列与循环队列的性能；
       /* int count = 10000000;
        TaoArrayStack<Integer> taoArrayStack = new TaoArrayStack<>();
        double time1 = testStack(taoArrayStack, count);
        System.out.println("数组栈耗时:" + time1);

        TaoLinkedListStack<Integer> taoLinkedListStack = new TaoLinkedListStack<>();
        double time2 = testStack(taoLinkedListStack, count);
        System.out.println("链表栈耗时:" + time2);*/

        testTaoLinkedListQueue();

    }

    /**
     * 测试LinkedList基本操作
     */
    private static void testLinkedList() {
        TaoLinkedList<Integer> linkedList = new TaoLinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }

        System.out.println(linkedList.remove(3));
        System.out.println(linkedList.toString());

        linkedList.removeFirst();
        System.out.println(linkedList.toString());

        linkedList.removeLast();
        System.out.println(linkedList.toString());
    }

    /**
     * 测试LinkedListStack基本操作
     */
    private static void testLinkedListStack() {
        TaoLinkedListStack<Integer> linkedList = new TaoLinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            linkedList.push(i);
            System.out.println(linkedList.toString());
        }

        System.out.println(linkedList.pop());
        System.out.println(linkedList.toString());

        System.out.println(linkedList.peek());

        linkedList.pop();
        System.out.println(linkedList.toString());
    }

    /**
     * 测试栈的性能
     *
     * @return
     */
    private static double testStack(TaoStack<Integer> stack, int numCount) {
        long startTime = System.nanoTime();

        //入队操作
        for (int i = 0; i < numCount; i++) {
            stack.push(i);
        }

        //出队操作
        for (int i = 0; i < numCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }

    /**
     * 测试链表队列
     */
    private static void testTaoLinkedListQueue() {
        TaoLinkedListQueue<Integer> queue = new TaoLinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i % 3 == 0) {
                queue.dequeue();
            }
            System.out.println(queue.toString());
        }
    }
}
