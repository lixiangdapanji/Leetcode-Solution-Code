     题意：
         给出一个字符串，返回所有不重复的回文串数字。如果没有回文串返回空。
     
     思路：
         典型的backtracking题。
         1，判断回文串需要两种情况aabb和aba
         2，如果奇数个字符出现2个或两个以上直接返回null
         3，只将回文串的一半放入hashmap 
         4，执行backtracking过程，注意保证遵循之前的条件，reverse string builder，revise boolean
     
     复杂度：
         time : 不知道
         space : O(n)

class Solution {
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }
        if (odd > 1) return res;

        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) mid += key;
            for (int i = 0; i < val / 2; i++) {
                list.add(key);
            }
        }
        helper(list, mid, new boolean[list.size()], new StringBuilder(), res);
        return res;
    }

    private void helper(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                helper(list, mid, used, sb, res);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
