package com.kborid.jav.leetcode;

public class FanZhuanSolution {
    public static void main(String[] args) {
        int test = -1644444003;
        long start = System.nanoTime();
        System.out.println(reverse(test));
        long start2 = System.nanoTime();
        System.out.println(start2 - start);
        System.out.println(reverseReal(test));
        System.out.println(System.nanoTime() - start2);
    }

    public static int reverseReal(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int reverse(int x) {
        boolean isFlag = false;
        if (x < 0) {
            isFlag = true;
            x = Math.abs(x);
        }
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        //Integer.MAX_VALUE = 2147483647
        char[] charsMax = String.valueOf(Integer.MAX_VALUE).toCharArray();
        if (chars.length > 10) {
            return 0;
        } else if (chars.length == 10) {
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] > charsMax[i]) {
                    return 0;
                } else if (chars[i] < charsMax[i]) {
                    break;
                }
            }
        }
        x = Integer.parseInt(String.valueOf(chars));
        if (isFlag) {
            x = -x;
        }
        return x;
    }
}