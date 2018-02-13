package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PalindromePartitioning
 * Creator : Edward
 * Description : 131. Palindrome Partitioning
 */
public class PalindromePartitioning {
    /**
     Given a string s, partition s such that every substring of the partition is a palindrome.
     Return all possible palindrome partitioning of s.

     For example, given s = "aab",
     Return

     [
     ["aa","b"],
     ["a","a","b"]
     ]
     
     题意：
         给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
         返回s所有可能的回文串分割方案。


     
     思路：
         典型的backtracking题。
         1，进行helper函数backtracking调用
         2，helper考虑边界条件 -> 何时返回结果 -> for循环递归
         3, 判断是否回文
         4, 注意substring取值范围
     
     复杂度：
         time : O(2^n)
         space : O(n)
     
     * @param s
     * @return
     */

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(res, new ArrayList<>(), s);
        return res;
    }

    public void helper(List<List<String>> res, List<String> list, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                list.add(s.substring(0, i + 1));
                helper(res, list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
