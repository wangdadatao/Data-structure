package com.datao.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 解题思路：
 * 1：HashMap记录每个字符串出现的次数
 * 2：封装一个内部类，先比较出现的次数，如果次数相同再比较字符串的顺序
 * 3：使用优先队列储存上述对象，能实现排序功能
 * 4：出队返回结果
 *
 * @author datao
 */
public class Solution692 {

    public static void main(String[] args) {
        String[] strs = {"d", "b", "c", "d", "a", "b", "a"};
        new Solution692().topKFrequent(strs, 1);

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(1);
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            Integer num = map.get(s);

            if (num == null) {
                map.put(s, 1);
            } else {
                map.put(s, num + 1);
            }
        }

        PriorityQueue<TempNum> priorityQueue = new PriorityQueue();
        for (String s : map.keySet()) {
            TempNum tempNum = new TempNum(s, map.get(s));
            priorityQueue.add(tempNum);
        }

        List<String> result = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            TempNum tempNum = priorityQueue.poll();
            result.add(tempNum.val);
            if (result.size() == k) {
                return result;
            }
        }

        return result;
    }

    private class TempNum implements Comparable<TempNum> {

        private String val;
        private Integer num;

        public TempNum(String val, Integer num) {
            this.val = val;
            this.num = num;
        }

        @Override
        public int compareTo(TempNum o) {
            if (this.num < o.num) {
                return 1;
            } else if (this.num.equals(o.num)) {
                return this.val.compareTo(o.val);
            } else {
                return -1;
            }
        }

    }
}
