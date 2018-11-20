package com.datao.solution;

public class Solution9 {

    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(1000));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String str = String.valueOf(x);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        String str2 = stringBuilder.toString();
        return str.equals(str2);
    }
}
