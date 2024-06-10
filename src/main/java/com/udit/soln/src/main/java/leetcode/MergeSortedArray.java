package com.udit.soln.src.main.java.leetcode;

import java.util.Arrays;

/**
 *  You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 *  and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, * nums1 has a length of m + n, where the first m elements denote the elements that should
 * be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2,4, 5, 6};
        int n = 4;

//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;
        new MergeSortedArray().merge(nums1,m,nums2,n);

        System.out.println(Arrays.toString(nums1));
    }
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int c = m+n-1;
            m--;
            n--;
                while(c>0 && m>=0 && n >=0){
                        if (nums1[m] > nums2[n]) {
                            nums1[c--] = nums1[m--];
                        } else {
                            nums1[c--] = nums2[n--];
                        }

                }
                if(m<0){
                    for (int i = n; i >=0 ; i--) {
                        nums1[c--] = nums2[n];
                    }
                }

        }
}
