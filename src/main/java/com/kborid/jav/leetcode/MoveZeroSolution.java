package com.kborid.jav.leetcode;

import java.util.Arrays;

public class MoveZeroSolution {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1};
        int[] arr1 = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        moveZeroes(arr1);
        moveZeroes2(arr);
        moveZeroes2(arr1);
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes2(int[] nums) {
        for (int i = 0, j = 0; i < nums.length;) {
            if (nums[i] == 0) {

            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
