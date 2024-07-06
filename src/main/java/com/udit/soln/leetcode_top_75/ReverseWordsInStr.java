package com.udit.soln.leetcode_top_75;

import java.util.ArrayList;
import java.util.List;

/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseWordsInStr {
    public static void main(String[] args) {
        ReverseWordsInStr rev = new ReverseWordsInStr();
        String s = "a good   example ";
        System.out.println("REVERSE = " +  rev.reverseWords(s));
    }
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) == ' ') {
               if(!word.isEmpty()) {
                   words.add(word.toString());
                   word.delete(0, word.length());
               }
            } else {
                word.append(s.charAt(i));
            }
        }
        if(!word.isEmpty()) {
            words.add(word.toString());
        }
        StringBuilder res = new StringBuilder();
        for (int i = words.size()-1; i >= 0 ; i--) {
            res.append(words.get(i) + " ");
        }
        return res.delete(res.length()-1, res.length()).toString();
    }
}
