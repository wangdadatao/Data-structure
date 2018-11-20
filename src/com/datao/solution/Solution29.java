package com.datao.solution;

public class Solution29 {

    public static void main(String[] args) {
        System.out.println(new Solution29().divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int num = 0;
        long sum;
        while (b <= a) {
            sum = b;
            int count = 1;
            while (sum + sum <= a) {
                count += count;
                sum += sum;
            }
            a = a - sum;
            num = num + count;
        }
        if ((dividend < 0 && divisor > 0) || dividend > 0 && divisor < 0) {
            num = -num;
        }
        return num;
    }
}
