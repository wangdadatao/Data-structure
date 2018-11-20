package com.datao.structure.g_set_map;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 349 两个数组的交集
 *
 * @author datao
 */
public class Solution349 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {1, 2, 2, 1};
        System.out.println(intersection(nums1, nums2));
    }


    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    nums.add(nums1[i]);
                }
            }
        }

        int[] result = new int[nums.size()];
        int i = 0;
        for (int num : nums) {
            result[i] = num;
            i++;
        }
        return result;

    }


}
