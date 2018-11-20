package com.datao.solution;

import java.util.HashMap;

public class Solution389 {

    public static void main(String[] args) {
        System.out.println(new Solution389().findTheDifference("ae", "aea"));
    }


    public char findTheDifference(String s, String t) {

        HashMap<Character, Integer> characters = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            Integer num = characters.get(t.charAt(i));
            if (num == null) {
                characters.put(t.charAt(i), 1);
            } else {
                characters.put(t.charAt(i), num + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            Integer num = characters.get(s.charAt(i));
            if (num != null) {
                if (num == 1){
                    characters.remove(s.charAt(i));
                }else{
                    characters.put(s.charAt(i), num - 1);
                }
            }
        }

        char result = ' ';
        for (Character c : characters.keySet()) {
            result = c;
        }

        return result;
    }

}
