package com.datao.d_linked;

public class Main {
    public static void main(String[] args) {
        TaoLinkedList<Integer> linkedList = new TaoLinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }

        System.out.println(linkedList.remove(3));
        System.out.println(linkedList.toString());

        linkedList.removeFirst();
        System.out.println(linkedList.toString());

        linkedList.removeLast();
        System.out.println(linkedList.toString());
    }
}
