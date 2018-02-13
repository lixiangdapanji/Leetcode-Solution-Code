package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PalindromePairs
 * Creator : Edward
 * Description : 336. Palindrome Pairs
 */
public class PalindromePairs {
    /**
     Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
     so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

     Example 1:
     Given words = ["bat", "tab", "cat"]
     Return [[0, 1], [1, 0]]
     The palindromes are ["battab", "tabbat"]
     Example 2:
     Given words = ["abcd", "dcba", "lls", "s", "sssll"]
     Return [[0, 1], [1, 0], [3, 2], [2, 4]]
     The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

     "abcdc" "ab"

     ab"cdc ab"
     "a" a
     
     题意：
         给一独特的单词列表, 在给定列表中查找所有不同的索引（i，j）对, 使得两个单词的串联即 words[i] + words[j] 是回文串.
     
     思路：
         
         1，需要返回index并在words上做操作所以选用hashmap进行解题
         2，拆分单词及组成单词的char
         3，判断两个单词是否是回文串，并查看另一个是否在hashmap中
         4，将map中存在的解加入result
     
     复杂度：
         time : O(2^n)
         space : O(n)
     
     time : O(n * k^2)
     space : O(n)

     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        res.add(Arrays.asList(map.get(str2rvs), i));
                    }
                }
                if (str2.length() != 0 && isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i) {
                        res.add(Arrays.asList(i, map.get(str1rvs)));
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
