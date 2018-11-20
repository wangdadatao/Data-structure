package com.datao.structure.b_stack;

public class Main {
    public static void main(String[] args) {
        TaoArrayStack<String> stack = new TaoArrayStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        System.out.println(stack.toString());

        stack.pop();
        System.out.println(stack.toString());

        System.out.println(stack.peek());

    }
}
