package com.udit.soln.src.main.java.leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove some duplicates in-place such that each unique element appears
 * --> at most twice.
 *
 * The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages, you must instead have
 * the result be placed in the first part of the array nums. More formally, if there are k elements after
 * removing the duplicates, then the first k elements of nums should hold the final result.
 *
 * It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1)
 * extra memory.
 */
public class RemoveDuplicatesSortedArr {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2,2, 3, 3, 3};
        int res = new RemoveDuplicatesSortedArr().removeDuplicates(nums);
        System.out.println("nums= "+Arrays.toString(nums));
        System.out.println("res= " + res);
    }
    public int removeDuplicates(int[] nums) {
        int j = 0;
        int count =0;
        LinkedHashMap<Integer,Integer> elementCount = new LinkedHashMap<>();
        
        for (int i = 0; i < nums.length-2 ; i++) {
            if(elementCount.containsKey(nums[i])){
                int x = elementCount.get(nums[i]) +1;
                elementCount.put(nums[i],x);
                if(x>3) count++;
            } else {
                elementCount.put(nums[i],1);
            }
        }
        for (int i = 0; i < nums.length ; i++) {
           int c = elementCount.get(nums[i]);
           if (c > 2) {

           }
        }
        return nums.length - count;
    }
}
