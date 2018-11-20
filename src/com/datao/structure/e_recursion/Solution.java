package com.datao.structure.e_recursion;

/**
 * leetcode 203号问题
 *
 * @author datao
 */
public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(3);

        //node = removeElements(node, 3);
        //node = removeElements2(node, 3);
        node = removeElements3(node, 3);
        System.out.println(node);
    }

    public static ListNode removeElements1(ListNode head, int val) {

        while (head != null && head.val == val) {
            ListNode first = head;
            head = head.next;
            first.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 加入虚拟头部
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements2(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * 递归删除指定元素
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;

    }
}
