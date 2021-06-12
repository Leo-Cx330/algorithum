package com.leo.algorithm.数组;

/**
 * @Author leo
 * @Date 2021/6/7
 * @Desc 删除排序数组中重复项
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int i = removeDuplicates(new int[]{1, 1, 2});
        System.out.println(i);
    }


    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right++];
            }
        }
        return ++left;
    }
}
