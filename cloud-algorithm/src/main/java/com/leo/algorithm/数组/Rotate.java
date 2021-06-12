package com.leo.algorithm.数组;

import java.util.Arrays;

/**
 * @Author leo
 * @Date 2021/6/9
 * @Desc 旋转数组
 */
public class Rotate {

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int temp[] = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
        Arrays.stream(nums).forEach(s -> System.out.println(s));
    }


}
