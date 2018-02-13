     题意：
         给定一个字符串s，将s分割成一些子串，使每个子串都是回文。
         返回s符合要求的的最少分割次数。


     
     思路：
         1，用dp思想去判断回文串
         2，构造辅助数组 isPalindrome[][], cuts[] 
         3，判断 s.charAt(i), s.charAt(j) && isPalindrome[i + 1][j - 1]
         4，min 初始值 最大为char个数 - 1 
         5, cuts[j - 1]表示第j - 1项的substring为回文串
         6, 每次for循环更新cuts[j - 1]的值，直到遍历完整个string
     
     复杂度：
         time : O(n^2)
         space : O(n^2)

class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] cuts = new int[len];
        boolean[][] isPalindrome = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cuts[j - 1] + 1);
                }
            }
            cuts[i] = min;
        }
        return cuts[len - 1];
    }
}
