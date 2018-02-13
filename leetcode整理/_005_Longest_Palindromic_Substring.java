package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LongestPalindromicSubstring
 * Creator : Edward
 * Description : 5. Longest Palindromic Substring
 */

public class LongestPalindromicSubstring {
    /**
     Given a string s, find the longest palindromic substring in s.
     You may assume that the maximum length of s is 1000.

     Example:

     Input: "babad"

     Output: "bab"

     Note: "aba" is also a valid answer.
     Example:

     Input: "cbbd"

     Output: "bb"

     题意：
         给出一个字符串（假设长度最长为1000），求出它的最长回文子串，你可以假定只有一个满足条件的最长回文串。
     
     思路：
        方法1：
         1，动态规划
         2，用max标记是否为最长的回文串
         3，dp[i][j] 比较i，j当前是否回文 && j - i <= 2 时回文串不存在 || dp[i + 1][j - 1] 之前一个状态是否回文
         4，(j - i <= 2) || dp[i + 1][j - 1]) 顺序不能反，程序按先后执行
         
         方法2:
         1，中心扩散方法
         2，分两种情况奇数回文串或偶数回文串
     
     复杂度：
        方法1： 
        time : O(n^2) 
        space : O(n^2);

        方法2：
        time : O(n^2) 
        space : O(1)

     * @param s
     * @return
     */

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    String res = "";


    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }
    
    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }
}
