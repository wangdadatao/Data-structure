package com.datao.h_heap_priorityqueue;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int n = 1000000;
        TaoMaxHeap<Integer> maxHeap = new TaoMaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = maxHeap.extractMax();
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Success");

    }
}
