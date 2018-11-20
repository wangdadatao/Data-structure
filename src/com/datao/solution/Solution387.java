package com.datao.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路：
 * 1：遍历字符串中每个字符出现的次数存在Map中
 * 2：便利字符串查找到第一个出现次数为1的下标
 *
 * @author datao
 */
public class Solution387 {

    public static void main(String[] args) {


    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer num = map.get(s.charAt(i));
            if (num == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), num + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            Integer num = map.get(s.charAt(i));
            if (num == 1) {
                return i;
            }
        }

        return -1;

    }

}
