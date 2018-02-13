     题意：
         一个只包含四种字符的字符串，找出其所有长度为10的子字符串中出现次数超过1次的子字符串。最后的结果中不能有重复字串。
     
     思路：
         1，因为需要去重，所以用HashSet
         2，判断substring是否重复出现在seen中，如果出现则if条件返回false，如果没有出现则将substring加入seen中
         3，结果返回repeated中的元素即可
     
     复杂度：
         time : O(n)
         space : O(n)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);
            if (!seen.add(temp)) {
                repeated.add(temp);
            }
        }
        return new ArrayList<>(repeated);
    }
}
