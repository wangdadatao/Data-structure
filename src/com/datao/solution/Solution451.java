package com.datao.solution;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution451 {

    public static void main(String[] args) {
        System.out.println(new Solution451().frequencySort("a"));
    }


    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer num = map.get(s.charAt(i));
            if (num == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), num + 1);
            }
        }

        PriorityQueue<TempNum> priorityQueue = new PriorityQueue();
        for (Character c : map.keySet()) {
            TempNum tempNum = new TempNum(c, map.get(c));
            priorityQueue.add(tempNum);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            TempNum tempNum = priorityQueue.poll();
            for (int i = 0; i < tempNum.num; i++) {
                stringBuilder.append(tempNum.val.toString());
            }
        }

        return stringBuilder.toString();

    }

    private class TempNum implements Comparable<TempNum> {

        private Character val;
        private Integer num;

        public TempNum(Character val, Integer num) {
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
