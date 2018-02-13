package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : IsSubsequence
 * Creator : Edward
 * Description : 392. IsSubsequence
 */
public class IsSubsequence {
    /**
     Given a string s and a string t, check if s is subsequence of t.
     You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
     A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

     Example 1:
     s = "abc", t = "ahbgdc"
     Return true.
     Example 2:
     s = "axc", t = "ahbgdc"
     Return false.

     Follow up:
     If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?  
     
     题意：
         给定字符串s与字符串t，判断s是否是t的子序列。
         你可以假设两字符串中都只包含小写字母。t的长度可能会很长（长度 ~= 500,000），s长度较短（<=100）
         某字符串的子序列是指从其中删除某些字母（也可以不删除），而剩余字符的相对顺序保持不变，得到的新字符串。（例如，"ace"是"abcde"的子序列，而"aec"则不是）。。
     
     思路：
         1，判断对应index的char是否相等
         2，相等i j同时增加
         3，不相等j++ 检查t的下一位
     
     复杂度：
         time : O(n)
         space : O(1)
     
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }
}
