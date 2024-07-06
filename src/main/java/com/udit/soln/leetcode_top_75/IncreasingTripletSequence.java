package com.udit.soln.leetcode_top_75;

/*
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and
nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.

Example 2:
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.

Example 3:
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.

Constraints:
    1 <= nums.length <= 5 * 105
    -231 <= nums[i] <= 231 - 1
 */
public class IncreasingTripletSequence {
    public static void main(String[] args) {
        IncreasingTripletSequence tripletSequence = new IncreasingTripletSequence();
//        int[] nums = {2,1,5,0,4,6};
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println("increasingTriplets = " + tripletSequence.increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        if(nums.length <3)
            return false;

        int[] maxR = new int[nums.length];
        int max =  Integer.MIN_VALUE;
        for (int l = nums.length-1; l >= 0 ; l--) {
            max = Math.max(max,nums[l]);
            maxR[l] = max;
        }

        int min = nums[0];
        for (int j = 1; j < nums.length ; j++) {
            if(nums[j]>min && nums[j]<maxR[j]){
                return true;
            } else {
                min = Math.min(min, nums[j]);
            }
        }
        return false;
    }
}
