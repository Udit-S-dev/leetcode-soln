package com.udit.soln.src.main.java.leetcode_top_75;
/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged
string. Return the merged string.

Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d
 */
public class MergeStrings {

    public static void main(String[] args) {
        MergeStrings ms = new MergeStrings();
//        String s1 = "abc" ; String s2 ="def";
//        String s1 = "abcdefg" ; String s2 ="pq";
//        String s1 = "ab" ; String s2 ="pqrst";
//        String s1 = "" ; String s2 ="pqr";
        String s1 = "dajmknzgidixqgt" ; String s2 ="nahamebx";
        String res  = ms.mergeAlternately(s1,s2);
        System.out.println( "res == " + res);
    }
    public String mergeAlternately(String word1, String word2) {
        StringBuilder op = new StringBuilder();
        int word1Len = word1.length();
        int word2Len = word2.length();
        if(word1Len<1)
            return word2;
        if (word2Len<1)
            return word1;
        int maxLen = word1Len + word2Len;
        int w1 =1,w2=0;
        op.append(word1.charAt(0));
        for (int i = 1; i <= maxLen; i++) {
            if( i%2 == 0 && w1 < word1Len) {
                op.append(word1.charAt(w1++));
            } else if ( w2 < word2Len) {
                op.append(word2.charAt(w2++));
            }
        }
            op.append(word1, w1, word1Len);
            op.append(word2, w2, word2Len);
        return op.toString();
    }
}
