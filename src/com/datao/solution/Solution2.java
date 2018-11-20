package com.datao.solution;

public class Solution2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(8);

        System.out.println(addTwoNumbers(l1, l2));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode temp = new ListNode(-999);
        ListNode result = temp;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        Integer cacheNum = 0;
        while (temp1 != null || temp2 != null) {
            if (temp1 == null && temp2 != null) {
                Integer allNum = temp2.val + cacheNum;

                if (allNum >= 10) {
                    cacheNum = 1;
                    temp.next = new ListNode(allNum - 10);
                    temp = temp.next;
                } else {
                    cacheNum = 0;
                    temp.next = new ListNode(allNum);
                    temp = temp.next;
                }

                temp2 = temp2.next;
            } else if (temp1 != null && temp2 == null) {

                Integer allNum = temp1.val + cacheNum;

                if (allNum >= 10) {
                    cacheNum = 1;
                    temp.next = new ListNode(allNum - 10);
                    temp = temp.next;
                } else {
                    cacheNum = 0;
                    temp.next = new ListNode(allNum);
                    temp = temp.next;
                }

                temp1 = temp1.next;
            } else {
                Integer allNum = cacheNum + temp1.val + temp2.val;
                if (allNum >= 10) {
                    cacheNum = 1;
                    temp.next = new ListNode(allNum - 10);
                    temp = temp.next;
                } else {
                    cacheNum = 0;
                    temp.next = new ListNode(allNum);
                    temp = temp.next;
                }

                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

        if (cacheNum == 1){
            temp.next = new ListNode(1);
            temp = temp.next;
        }

        return result.next;
    }


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
