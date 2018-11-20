package com.datao.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 解题思路
 * HashSet储存所有的值，判断是否存在节点
 *
 * @author datao
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
