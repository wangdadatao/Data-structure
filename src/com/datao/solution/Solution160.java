package com.datao.solution;

public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode rootA = headA;
        ListNode rootB = headB;

        if (headA == null || headB == null) {
            return null;
        }

        int numA = 0;
        while (rootA.next != null) {
            numA++;
            rootA = rootA.next;
        }

        int numB = 0;
        while (rootB.next != null) {
            numB++;
            rootB = rootB.next;
        }


        int beginIndex = Math.abs(numA - numB);

        rootA = headA;
        rootB = headB;

        int temp = 0;
        if (numA >= numB) {

            while (rootA != null) {
                if (temp >= beginIndex) {

                    if (rootA.val == rootB.val) {
                        return rootA;
                    }
                    rootB = rootB.next;

                }
                rootA = rootA.next;
                temp++;
            }
        } else {

            while (rootB != null) {
                if (temp >= beginIndex) {

                    if (rootA.val == rootB.val) {
                        return rootA;
                    }
                    rootA = rootA.next;

                }
                rootB = rootB.next;
                temp++;
            }

        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
