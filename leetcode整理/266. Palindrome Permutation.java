     题意：
         判断一个字符串的全排列有没有回文字符串。
     
     思路：
        方法1:
         1，回文必要条件为有且仅有一个元素出现单数次
         2，用hashset判定出现奇数次或偶数次
         3，如果操作完成后hashset中元素个数小于等于1则可以判定为回文串

        方法2:
         1，用数组表示hashset
     
     复杂度：
        方法1:
         time : O(n)
         space : O(n)

        方法2:
         time : O(n)
         space : O(1) 

class Solution {
    //space : O(n)
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    //space : O(1)
    public boolean canPermutePalindrome2(String s) {
        char[] count = new char[256];
        int res = 0;
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) res++;
        }
        return res <= 1;
    }
}
