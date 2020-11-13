package com.kborid.jav.leetcode;

public class HuiWenShuSolution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(3));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x > 0 && x % 10 == 0) {
            return false;
        }

        int ret = 0;
        while (x > ret) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }

        return x == ret || x == ret / 10;
    }
}
