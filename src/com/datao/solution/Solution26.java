package com.datao.solution;

public class Solution26 {

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 3, 4, 4, 5, 6, 6};
        int num = new Solution26().removeDuplicates(nums);

        System.out.println(num);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == nums[length - 1]) {
                return i + 1;
            }

            for (int j = i + 1; j < length; j++) {
                if (nums[j] > nums[i]) {
                    nums[i + 1] = nums[j];
                    break;
                }
            }
        }

        return nums.length;
    }
}
