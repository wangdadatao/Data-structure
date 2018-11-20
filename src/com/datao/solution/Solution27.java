package com.datao.solution;

public class Solution27 {

    public static void main(String[] args) {
        int[] nums = {2,2,3};
        int num = new Solution27().removeElement(nums, 2);

        System.out.println(num);
    }

    public int removeElement(int[] nums, int val) {
        Integer step = 0;
        for (int i : nums) {
            if (i == val) {
                step++;
            }
        }


        for (int num = 0; num < step; num++) {

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    for (int j = i; j < nums.length - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                }
            }
        }

        return nums.length -step;
    }

}
