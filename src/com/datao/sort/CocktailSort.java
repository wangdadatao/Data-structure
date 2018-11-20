package com.datao.sort;

/**
 * 鸡尾酒排序
 *
 * @author datao
 */
public class CocktailSort {

    public static void main(String[] args) {
        sort(new int[]{1, 2, 3});
    }

    private static void sort(int[] nums) {
        nums = new int[]{39, 10, 218, 84, 392, 384, 573, 25, 431, 1, 99, 53, 42};

        Integer left = 0;
        Integer right = nums.length - 1;

        while (left < right) {
            for (int i = left; i < right; i++) {
                if (nums[i] > nums[i + 1]) {
                    Integer temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                }
            }
            right--;

            for (int i = right; i >= left + 1; i--) {
                if (nums[i] < nums[i - 1]) {
                    Integer temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                }
            }
            left++;
        }

        for (Integer i : nums) {
            System.out.println(i);
        }

    }

}
