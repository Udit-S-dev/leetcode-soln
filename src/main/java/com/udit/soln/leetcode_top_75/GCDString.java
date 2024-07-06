package com.udit.soln.leetcode_top_75;

/*
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t
(i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""

Constraints:
    1 <= str1.length, str2.length <= 1000
    str1 and str2 consist of English uppercase letters.
 */
public class GCDString {
    public static void main(String[] args) {
        GCDString gcdString = new GCDString();
        String s1,s2;
        s2 = "ABCABC"; s1 ="ABC";
        String gcd = gcdString.gcdOfStrings(s1,s2);
        System.out.println("GCD = " + gcd);
    }
    public String gcdOfStrings(String str1, String str2) {
        String smallerStr ;

        if(str1.length() < str2.length()) {
            smallerStr = str1;
        } else {
            smallerStr =str2;
        }

        StringBuilder gcd = new StringBuilder();
        String finalGcd = "";
        for (int i = 0; i < smallerStr.length(); i++) {
                gcd.append(smallerStr.charAt(i));
               if("".equals(str1.replaceAll(gcd.toString(),"")) &&
                  "".equals(str2.replaceAll(gcd.toString(),"")) ){
                   finalGcd = gcd.toString();
               }
        }
        return finalGcd;
    }
}
