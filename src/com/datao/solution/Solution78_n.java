package com.datao.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution78_n {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new Solution78_n().subsets(nums));
    }


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> numsList = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            List<Integer> temp1 = new ArrayList<>();
            temp1.add(i);
            numsList.add(temp1);


            for (int j = i; j < nums.length; j++) {


            }
        }


        return null;
    }

}
