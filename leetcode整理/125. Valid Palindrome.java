     题意：
         给定一个字符串，判断其是否为一个回文串。只包含字母和数字，忽略大小写。
     
     思路：
         
         1，two pointer
         2，判断s.charAt(left)和s.charAt(right)是否相等
         3，注意只考虑字母和数字
     
     复杂度：
         time : O(n)
         space : O(1)
         
class Solution {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
