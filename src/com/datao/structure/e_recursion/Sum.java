package com.datao.structure.e_recursion;

/**
 * 递归计算数组的和
 *
 * @author datao
 */
public class Sum {

    public static void main(String[] args) {

        System.out.println(sum(new int[]{1, 2, 3, 4, 5}));

    }

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 计算arr[l~n]这个区间内所有数字的和；
     *
     * @param arr   数组
     * @param index 开始计算的索引
     * @return 和
     */
    private static int sum(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sum(arr, index + 1);
    }

}
