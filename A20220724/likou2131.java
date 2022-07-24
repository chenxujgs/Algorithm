package suanfa.likou.A20220724;

import java.util.HashMap;

/**
 * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
 * <p>
 * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
 * <p>
 * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
 * <p>
 * 回文串 指的是从前往后和从后往前读一样的字符串。
 */
public class likou2131 {
    public static void main(String[] args) {
        //System.out.println(new likou2131().longestPalindrome(new String[]{"lc", "cl", "gg"}));
        System.out.println(new likou2131().longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}));
    }

    public int longestPalindrome(String[] words) {
        int ans = 0;
        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(words[i]);
            sb = sb.reverse();
            String s = sb.toString();
            if (map.getOrDefault(s, 0) > 0) {
                ans += 4;
                map.put(s, map.get(s) - 1);
            } else map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) > 0 && key.charAt(0) == key.charAt(1)) {
                ans += 2;
                break;
            }
        }
        return ans;

    }
}
