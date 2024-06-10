package com.udit.soln.src.main.java.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the
 * following things:
 *     Change the array nums such that the first k elements of nums contain the elements which are not equal
 *     to val. The remaining elements of nums are not important as well as the size of nums.
 *     Return k.
 */
public class RemoveElement {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 2,3,3}; int val = 3;
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2}; int val = 2;
        int rex = new RemoveElement().removeElement(nums, val);
        System.out.println("output= "+rex);
        System.out.println(Arrays.toString(nums));
    }
    public int removeElement(int[] nums, int val) {
        int last = nums.length-1;
        int count = 0;
        for (int i = 0; i < nums.length ; i++) {
            while(nums[last]==val) {
                nums[last] = Integer.MAX_VALUE;
                last--;
                count++;
            }
            if(nums[i]== val) {
                int tmp = nums[last];
                nums[last]=Integer.MAX_VALUE;
                nums[i] = tmp;
                last--;
                count++;
            }
        }
        return nums.length - count;
    }
}
