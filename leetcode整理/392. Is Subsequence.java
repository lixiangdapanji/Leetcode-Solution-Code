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

class Solution {
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
