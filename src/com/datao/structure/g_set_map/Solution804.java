package com.datao.structure.g_set_map;

import java.util.TreeSet;

/**
 * leetCode 804 唯一摩尔斯密码词
 *
 * @author datao
 */
public class Solution804 {

    public static void main(String[] args) {
        String[] strs = {"gin", "zen", "gig", "msg"};
        System.out.println(new Solution804().uniqueMorseRepresentations(strs));

    }


    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        TreeSet<String> result = new TreeSet<>();
        for (String s : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(code[s.charAt(i) - 'a']);
            }

            result.add(stringBuilder.toString());
        }


        return result.size();
    }

}
