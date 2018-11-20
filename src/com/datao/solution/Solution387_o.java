package com.datao.solution;

/**
 * 解题思路：
 * 1：创建一个长度26的数组与26个字母做映射
 * 2：遍历字符串中字符，判断数组中的数字是否为1
 *
 * @author datao
 */
public class Solution387_o {

    public static void main(String[] args) {
        System.out.println(new Solution387_o().firstUniqChar("aabbc"));

    }

    public int firstUniqChar(String s) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

}
