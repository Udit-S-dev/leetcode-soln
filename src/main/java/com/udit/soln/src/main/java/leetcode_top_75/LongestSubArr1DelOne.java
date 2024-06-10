package com.udit.soln.src.main.java.leetcode_top_75;
/*
Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's in the resulting array.
Return 0 if there is no such subarray.
Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.

Constraints:
 1 <= nums.length <= 105
 nums[i] is either 0 or 1.
 */
public class LongestSubArr1DelOne {
    public static void main(String[] args) {
        LongestSubArr1DelOne arr1DelOne = new LongestSubArr1DelOne();
//        int[] nums = {1,1,0,1};
//        int[] nums = {0, 1, 0, 1, 0, 1, 1, 0, 0};
        int[] nums = {1, 0, 1, 1, 0, 1, 1, 0, 0};
//        int[] nums = {1,1,1};
        System.out.println("REs= "+ arr1DelOne.longestSubarray(nums));
    }
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        boolean oneRem = false;
        int startIdx = 0;
        int maxLen=0;
        int tempLen= nums[0] == 1 ? 1 : 0 ;
        for(int i = 1; i < len ; i++) {
            if(nums[i] == 1) {
                tempLen++;
            }
           else if ( nums[i]==0 ) {
                if (nums[i - 1] == 1 && nums[i + 1] == 1 && !oneRem) {
                    oneRem = true;
                } else {
                    if(maxLen < tempLen){
                        maxLen = oneRem ? tempLen : tempLen -1;
                        oneRem = false;
                    }
                    if(nums[i-1]==1 && i+1<len && nums[i+1]==1 ){
                        i = i-2;
                        oneRem = false;
                    }
                    tempLen = 0;
                }
            }
            if(maxLen < tempLen){
                maxLen = oneRem ? tempLen : tempLen -1;
            }
        }
        return maxLen;
    }
}
