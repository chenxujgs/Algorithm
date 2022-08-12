package suanfa.likou.A20220811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class likou17 {
    List<String> list = new ArrayList<>();
    int length;
    Map<Character, String> map;

    public List<String> letterCombinations(String digits) {
        length = digits.length();
        if (length == 0) {
            return list;
        }
        map = new HashMap() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};


        combinations(digits, 0, new StringBuilder());
        return list;
    }

    private void combinations(String digits, int i, StringBuilder sb) {
        if (sb.length() == length) {
            list.add(sb.toString());
            return;
        }

        String s = map.get(digits.charAt(i));
        for (int j = 0; j < s.length(); j++) {
            sb.append(s.charAt(j));
            combinations(digits, i + 1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
