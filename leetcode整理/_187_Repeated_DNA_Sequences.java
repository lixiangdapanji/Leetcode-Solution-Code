package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RepeatedDNASequences
 * Creator : Edward
 * Description : 187. Repeated DNA Sequences
 */
public class RepeatedDNASequences {
    /**
     All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
     for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

     Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

     For example,

     Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

     Return:
     ["AAAAACCCCC", "CCCCCAAAAA"].
     
     题意：
         一个只包含四种字符的字符串，找出其所有长度为10的子字符串中出现次数超过1次的子字符串。最后的结果中不能有重复字串。
     
     思路：
         1，因为需要去重，所以用HashSet
         2，判断substring是否重复出现在seen中，如果出现则if条件返回false，如果没有出现则将substring加入seen中
         3，结果返回repeated中的元素即可
     
     复杂度：
         time : O(n)
         space : O(n)
     
     * @param s
     * @return
     */
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
