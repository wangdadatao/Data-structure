package com.datao.solution;

import java.util.Stack;

/**
 * 解题思路:
 * <p>
 * 1：找到m的前一个节点，n的后一个节点
 * 2：用栈储存要反转的节点
 * 3：需要反转的节点储存新的链表
 * 4：组装链表
 * 5：返回结果
 *
 * @author datao
 */
public class Solution92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        Stack<Integer> stack = new Stack<>();

        ListNode curNode = head;
        ListNode mNode = null;
        ListNode nNode = null;

        Integer i = 0;

        while (curNode != null) {
            i++;

            if (i == m - 1) {
                mNode = curNode;
            } else if (i == n + 1) {
                nNode = curNode;
            } else if (i >= m && i <= n) {
                stack.push(curNode.val);
            }

            curNode = curNode.next;
        }

        ListNode dummyNode = new ListNode(-9999);
        ListNode sNode = dummyNode;
        while (!stack.isEmpty()) {
            sNode.next = new ListNode(stack.pop());
            sNode = sNode.next;
        }

        sNode.next = nNode;
        if (mNode == null) {
            return dummyNode.next;
        } else {
            mNode.next = dummyNode.next;
            return head;
        }

    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
