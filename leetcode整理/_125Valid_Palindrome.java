package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ValidPalindrome
 * Creator : Edward
 * Description : 125. Valid Palindrome
 */

public class ValidPalindrome {
    /**
     Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

     For example,
     "A man, a plan, a canal: Panama" is a palindrome.
     "race a car" is not a palindrome.

     Note:
     Have you consider that the string might be empty? This is a good question to ask during an interview.

     For the purpose of this problem, we define empty string as valid palindrome.

     case : "A man, a plan, a canal: Panama"
    
     题意：
         给定一个字符串，判断其是否为一个回文串。只包含字母和数字，忽略大小写。
     
     思路：
         
         1，two pointer
         2，判断s.charAt(left)和s.charAt(right)是否相等
         3，注意只考虑字母和数字
     
     复杂度：
         time : O(n)
         space : O(1)
     
     * @param s
     * @return
     */
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
