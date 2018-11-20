package com.datao.structure.c_queue;

import com.datao.structure.d_linked.TaoLinkedListQueue;

public class Main {
    public static void main(String[] args) {
        //testArrayQueue();
        //testLoopQueue();

        //测试数组队列与循环队列的性能；
        int count = 100000;
        TaoArrayQueue<Integer> arrayQueue = new TaoArrayQueue<>();
        double time1 = testQueue(arrayQueue, count);
        System.out.println("数组队列耗时:" + time1);

        TaoLoopQueue<Integer> loopQueue = new TaoLoopQueue<>();
        double time2 = testQueue(loopQueue, count);
        System.out.println("循环队列耗时:" + time2);

        TaoLinkedListQueue<Integer> linkedListQueue = new TaoLinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, count);
        System.out.println("链表队列耗时：" + time3);

    }

    private static void testArrayQueue() {
        TaoArrayQueue<String> queue = new TaoArrayQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        System.out.println(queue.toString());

        queue.dequeue();
        System.out.println(queue.toString());

        System.out.println(queue.getSize());
        System.out.println(queue.getFront());
        queue.enqueue("6");
        System.out.println(queue.toString());
    }

    private static void testLoopQueue() {
        TaoLoopQueue<Integer> queue = new TaoLoopQueue<>();
        System.out.println(queue.toString());

        for (int i = 1; i <= 20; i++) {
            queue.enqueue(i);

            if (i % 3 == 0) {
                queue.dequeue();
            }
            System.out.println(queue.toString());
        }
    }

    /**
     * 测试使用queue 运行count个enqueue和dequeue操作所需要的时间
     *
     * @param queue
     * @param count
     */
    private static double testQueue(TaoQueue<Integer> queue, int count) {
        long startTime = System.nanoTime();

        //入队操作
        for (int i = 0; i < count; i++) {
            queue.enqueue(i);
        }

        //出队操作
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
