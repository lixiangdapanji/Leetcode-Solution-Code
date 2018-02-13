     题意：
         判断一个正整数是不是回文数。
     
     思路：
         1，比较新组成的数字与原数字是否相等，相等则返回true 
         2，
         3，
         4，for循环中注意去重
     
     复杂度：
         time : O(n)
         space : O(1)
         
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) return false;
        int palind = x;
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return palind == rev;
    }
}
