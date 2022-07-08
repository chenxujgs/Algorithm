package suanfa.likou.A20220701;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class likou17 {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        getNum(map, digits.toCharArray());
        return null;
    }

    /**
     * 思路: 深搜,先遍历字符串,递归遍历字符
     *
     * @param map
     * @param str
     */
    private void getNum(Map<Character, String> map, char[] str) {
        String s = map.get(str[0]);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            StringBuffer append = new StringBuffer().append(s.charAt(i));
            getSort(map, str, 1, str.length - 1, append);
        }
    }

    private void getSort(Map<Character, String> map, char[] str, int nowIndex, int len, StringBuffer sb) {
        if (nowIndex > len) {
            return;
        }
        String s = map.get(str[nowIndex]);
        for (int i = 0; i < s.length(); i++) {
            StringBuffer append = new StringBuffer().append(sb).append(s.charAt(i));
            getSort(map, str, ++nowIndex, len - 1, append);
        }
    }


}
