package suanfa.likou.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxj
 * @date 2022/2/1
 * @description DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * <p>
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * <p>
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次
 * 长度为10的序列(子字符串)。你可以按 任意顺序 返回答案。
 */
public class likou187 {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences2("AAAAAAAAAAA"));
    }

    // 滑动窗口
    public static List<String> findRepeatedDnaSequences1(String s) {
        final int L = 10;
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n <= 10) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        // 滑动窗口
        for (int i = 0; i <= n - L; i++) {
            // 拿出十位字符
            String str = s.substring(i, i + L);
            // 放入map中
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) == 2) {
                res.add(str);
            }
        }
        return res;
    }

    // 位运算+滑动窗口
    public static List<String> findRepeatedDnaSequences2(String s) {
        Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};

        final int L = 10;
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n <= 10) {
            return res;
        }

        int x = 0;
        for (int i = 0; i < L - 1; i++) {
            // 滑动窗口存储九个字符
            x = (x << 2) | bin.get(s.charAt(i));
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n - L; i++) {
            // 将左边移出来一位,右边添加一位
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 2) {
                res.add(s.substring(i, i + L));
            }
        }
        return res;
    }
}
