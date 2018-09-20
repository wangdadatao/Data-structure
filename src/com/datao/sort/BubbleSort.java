package com.datao.sort;

/**
 * 冒泡排序
 *
 * @author datao
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {39, 10, 218,  84, 392, 384, 573, 25, 431,1, 99, 53, 42};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 -i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            System.out.println(nums.length);
        }

        for (int i : nums) {
            System.out.println(i);
        }


    }

}
