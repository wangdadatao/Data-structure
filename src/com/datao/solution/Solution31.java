package com.datao.solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution31 {

    public static void main(String[] args) {
        new ArrayList<Integer>(10);

        int[] nums = {1, 2, 3};
        new Solution31().nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {


        Arrays.sort(nums);

        for (int i : nums) {
            System.out.print(i + "");
        }

        if (nums.length <= 1) {
            return;
        } else {
            int temp = nums[nums.length - 1];
            nums[nums.length - 1] = nums[nums.length - 2];
            nums[nums.length - 2] = temp;
        }

        for (int i : nums) {
            System.out.print(i + "");
        }
    }
}
