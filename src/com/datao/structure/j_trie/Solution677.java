package com.datao.structure.j_trie;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 677. 键值映射
 *
 * @author datao
 */
public class Solution677 {

    public static void main(String[] args) {
        Solution677 mapSum = new Solution677();
        System.out.println(mapSum.sum(""));
        mapSum.insert("apple",3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app",2);
        System.out.println(mapSum.sum("ap"));
    }


    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Solution677() {
        root = new Node();
    }

    public void insert(String key, int val) {

        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            cur.val = val;
        }
    }

    public int sum(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        List<Integer> vals = new ArrayList<>();
        match(cur, vals);

        int result = 0;
        for (int i : vals) {
            result += i;
        }

        return result;
    }

    private void match(Node node, List<Integer> vals) {
        if (node.isWord) {
            vals.add(node.val);
        }

        for (char c : node.next.keySet()) {
            match(node.next.get(c), vals);
        }
    }


    private class Node {
        public boolean isWord;
        public int val;
        public TreeMap<Character, Node> next;

        public Node() {
            this.isWord = false;
            val = 0;
            next = new TreeMap<>();
        }

        public Node(int val) {
            this.isWord = false;
            this.val = val;
            next = new TreeMap<>();
        }
    }
}


/**
 * Your Solution677 object will be instantiated and called as such:
 * Solution677 obj = new Solution677();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
