package com.datao.solution;

/**
 * 解题思路：
 * 创建两个新的链表储存小于目标值与大于等于目标值
 * 合并两个链表
 *
 * @author datao
 */
public class Solution86 {


    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode = new ListNode(-9999);

        if (head == null || head.next == null) {
            return head;
        }

        ListNode afterNode = new ListNode(-8888);

        ListNode curNode = head;

        ListNode curBeforNode = dummyNode;
        ListNode curAfterNode = afterNode;
        while (curNode != null) {
            if (curNode.val < x) {
                curBeforNode.next = new ListNode(curNode.val);
                curBeforNode = curBeforNode.next;
            } else {
                curAfterNode.next = new ListNode(curNode.val);
                curAfterNode = curAfterNode.next;
            }
            curNode = curNode.next;
        }

        curBeforNode.next = afterNode.next;
        return dummyNode.next;
    }


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
