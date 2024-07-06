package com.udit.soln.leetcode_top_75;

import java.util.*;

/*
You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.

Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.

Constraints:
    1 <= nums.length <= 105
    1 <= nums[i] <= 109
    1 <= k <= 109
 */
public class MaxNumKSumParis {
    public static void main(String[] args) {
        MaxNumKSumParis paris = new MaxNumKSumParis();
//       int[] nums = {1, 2, 3, 4};
//       int k = 5;
//        int[] nums = {3, 1, 3, 4, 3}; int k = 6;
        int[] nums = {2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2}; int k = 3;
//        int[] nums = {2,1,1,1,2,1,2,2,2}; int k = 3;

        System.out.println("OPS="+ paris.maxOperations(nums, k));
    }

    public int maxOperations(int[] nums, int k) {
       Set<Integer> idxRm = new HashSet<>();
       Map<Integer, List<Integer>> numIdxSeen = new HashMap<>();
       
        int opK = 0;
        for (int i = 0; i < nums.length ; i++) {
            int n = nums[i];
            numIdxSeen.putIfAbsent(n,new ArrayList<>());
            int t = k-n;
            if(numIdxSeen.containsKey(t) && !numIdxSeen.get(t).isEmpty()){
                int idx = numIdxSeen.get(t).get(0);
                if( !idxRm.contains(idx)) {
                    idxRm.add(i);
                    idxRm.add(idx);
                    numIdxSeen.get(t).remove(0);
                    opK++;
                } else {
                    numIdxSeen.get(n).add(i);
                }
            } else {
                numIdxSeen.get(n).add(i);
            }
        }
        return opK;
    }

}
