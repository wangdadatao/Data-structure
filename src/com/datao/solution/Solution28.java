package com.datao.solution;

public class Solution28 {

    public static void main(String[] args) {
        Integer i = new Solution28().strStr("aaaa", "aaaaa");
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }

        Integer result = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {

                boolean mark = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (i + j >= haystack.length()) {
                        return -1;
                    }

                    char char1 = haystack.charAt(i + j);
                    char char2 = needle.charAt(j);
                    if (char1 != char2) {
                        mark = false;
                        break;
                    }
                }

                if (mark) {
                    return i;
                }
            }
        }
        return result;
    }
}
