package com.datao.structure.a_array;

public class Main {

    public static void main(String[] args) {
        TaoNumArray taoArray = new TaoNumArray();
        taoArray.addLast(1);
        taoArray.addLast(2);
        taoArray.addLast(3);
        taoArray.addLast(4);
        taoArray.addLast(5);
        taoArray.addLast(6);

        System.out.println(taoArray.removeElement(3));
        System.out.println(taoArray.getSize());
        System.out.println(taoArray.toString());
        System.out.println(taoArray.get(2));


        TaoArray<String> strArray = new TaoArray<>();
        strArray.addLast("1");
        strArray.addLast("2");
        strArray.addLast("3");

        strArray.removeFirst();
        System.out.println(strArray);

        for (int i = 0; i < 10; i++) {
            strArray.addLast(i + "");
        }

        System.out.println(strArray.toString());

        TaoArray<String> array = new TaoArray<>();
        System.out.println(array.getFirst());
    }

}
