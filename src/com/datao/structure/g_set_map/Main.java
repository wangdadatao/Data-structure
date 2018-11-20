package com.datao.structure.g_set_map;

public class Main {

    public static void main(String[] args) {
        //testSet();

        //testLinkedMap();

        testBSTMap();
    }

    private static void testSet() {
        TaoBSTSet<Integer> set = new TaoBSTSet<>();
        TaoLinkedSet<Integer> linkedSet = new TaoLinkedSet<>();
        int[] phoneNum = {1, 7, 6, 8, 2, 3, 0, 3, 2, 6, 5, 1, 2, 34, 7, 5, 4, 3, 8, 7, 5, 0};
        for (int i = 0; i < phoneNum.length; i++) {
            set.add(phoneNum[i]);
            linkedSet.add(phoneNum[i]);
        }

        System.out.println(set.getSize() + "  --  " + linkedSet.getSize());

        set.remove(1);
        set.remove(2);
        linkedSet.remove(1);
        linkedSet.remove(2);
        System.out.println(set.getSize() + "  --  " + linkedSet.getSize());
    }

    private static void testLinkedMap() {
        TaoLinkedMap<Integer, Integer> map = new TaoLinkedMap<>();
        //
        map.add(null, 11);
        map.add(1, 1);
        map.add(2, 1);
        map.add(null, 1);
        map.add(1, 11);
        System.out.println(map.getSize());
        System.out.println(map.get(1));
        map.add(null, 2);
        System.out.println(map.get(null));
        System.out.println(map.contains(null));
        map.remove(null);
        System.out.println(map.getSize());
    }

    private static void testBSTMap() {
        TaoLinkedMap<Integer, Integer> map = new TaoLinkedMap<>();
        //
        map.add(null, 11);
        map.add(2, 1);
        map.add(1, 1);
        map.add(null, 1);
        map.add(11, 11);
        System.out.println(map.getSize());
        System.out.println(map.get(1));
        map.add(null, 2);
        System.out.println(map.get(null));
        System.out.println(map.contains(null));
        map.remove(null);
        System.out.println(map.getSize());
    }
}
