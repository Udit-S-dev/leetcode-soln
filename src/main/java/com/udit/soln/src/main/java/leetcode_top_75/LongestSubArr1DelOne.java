package leetcode_top_75;
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
//        int[] nums = {1,1,0,1}; // 3
//        int[] nums = {0, 1, 0, 1, 0, 1, 1, 0, 0}; // 3
//        int[] nums = {1, 0, 1, 1, 0, 1, 1, 0, 0}; // 4
//        int[] nums = {1,1,1}; // 2
//        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1}; // 5
//        int[] nums = {0, 0, 1, 1}; // 2
         int[] nums = {0,1,1,1,1,1}; // 5
        System.out.println("REs= "+ arr1DelOne.longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int len = nums.length;
        boolean oneRem = false;
        int maxLen=0;
        int countZero = 0;
        int OnesSartIdx = 0 ;
        int tempLen= 0; //nums[0] == 1 ? 1 : 0 ;
        OnesSartIdx = getOnesSartIdx(nums, len, 0);

        for(int i = OnesSartIdx; i < len ; i++) {
            if(nums[i] ==0 ) {
                countZero++;
                if(i==(len-1)) {
                    maxLen = calMaxLen(tempLen,maxLen,countZero,OnesSartIdx,nums);
                }
                continue;
           }
            if(nums[i] == 1 && countZero <= 1) {
                tempLen++;
                if(i==(len-1)) {
                    maxLen = calMaxLen(tempLen,maxLen,countZero,OnesSartIdx,nums);
                }
            } else if(countZero > 1){
                    maxLen = calMaxLen(tempLen,maxLen,countZero,OnesSartIdx,nums);
                    tempLen =0;
                    countZero = 0;
                    OnesSartIdx = getOnesSartIdx(nums, len, OnesSartIdx+1);
                    i = OnesSartIdx-1;
            } else {
                maxLen = calMaxLen(tempLen, maxLen, countZero,OnesSartIdx,nums);
            }
        }
        return maxLen;
    }
    private int getOnesSartIdx(int[] nums, int len, int OnesSartIdx) {
        for (int i = OnesSartIdx; i < len; i++) {
            if( nums[i] == 0) {
                continue;
            }
            OnesSartIdx = i;
            break;
        }
        return OnesSartIdx;
    }
    private int calMaxLen(int tmpLen, int maxLen, int countZero,int OneStartIdx, int[] nums) {
        int max = Math.max(tmpLen, maxLen);
        max = countZero >0 ? max : max -1;
        if(countZero==0 && OneStartIdx-1 >=0 && nums[OneStartIdx-1]==0)
            max++;
        return max;
    }
}
