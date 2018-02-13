     题意：
         给一个字符串 S, 你可以通过在前面添加字符将其转换为回文串.找到并返回用这种方式转换的最短回文串。
     
     思路：
    
         1，用i, j表示头尾判断是否回文
         2，找到不需要架构的第一个点end
         3，从end + 1之后组合回文串
     
     复杂度：
         time : O(n^2)
         space : O(1)
     

class Solution {
    // time :  O(n^2) for aaaaabcaaaaa
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
