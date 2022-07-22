package suanfa.likou.A20220722;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class likou76 {
    public static void main(String[] args) {
        System.out.println(new likou76().minWindow("ADOBECODEBANC", "ABC"));
    }

    /**
     * 思路: 滑动窗口,将匹配的上的子串放进窗口,匹配成功更新最小字符串,不断缩小左指针,更新最小字符串
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (tlen > slen) {
            return "";
        }

        char[] scur = new char[60];
        char[] tcur = new char[60];

        for (int i = 0; i < tlen; i++) {
            tcur[t.charAt(i) - 'A']++;
        }

        int left = 0, mark = slen;
        String str = "";
        for (int i = 0; i < slen; i++) {
            scur[s.charAt(i) - 'A']++;
            while (Cover(scur, tcur)) {
                if (i - left + 1 <= mark) {
                    mark = i - left + 1;
                    str = s.substring(left, i + 1);
                }
                scur[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return str;
    }

    private boolean Cover(char[] scur, char[] tcur) {
        for (int i = 0; i < 60; i++) {
            if (scur[i] < tcur[i]) {
                return false;
            }
        }
        return true;
    }
}
