     题意：
         给出字符串S和字符串T，计算S的不同的子序列中T出现的个数。
         子序列字符串是原始字符串通过删除一些(或零个)产生的一个新的字符串，并且对剩下的字符的相对位置没有影响。(比如，“ACE”是“ABCDE”的子序列字符串,而“AEC”不是)。 


     
     思路：
         1，通过参数与返回值确定dp维度与参数
         2，判断S.charAt(i)与T.charAt(i)是否相等
         3，初始化dp的列为1，保证T为空时T一定是S的子序列字符串。
         4，状态转移公式 S.charAt(i) == S.charAt(j) -> dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]; 
                       S.charAt(i) != S.charAt(j) -> dp[i][j] = dp[i - 1][j]
     
     复杂度：
         time : O(m * n)
         space : O(m * n)

     错误：
        if (T == null || T.length() == 0) return 1
class Solution {
    public static int numDistinct(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
}
