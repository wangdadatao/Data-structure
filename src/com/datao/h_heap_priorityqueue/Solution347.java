package com.datao.h_heap_priorityqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 347. 前K个高频元素
 *
 * @author datao
 */
public class Solution347 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(topKFrequent(nums, k));

    }


    public static List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        //内部默认最小堆
        PriorityQueue<Freq> pq = new PriorityQueue<Freq>();
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        List<Integer> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.add(pq.remove().e);
        }

        return result;
    }

    private static class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            return Integer.compare(this.freq, o.freq);
        }
    }

}
