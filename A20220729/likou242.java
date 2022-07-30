package suanfa.likou.A20220729;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 *  
 */
public class likou242 {
    public boolean isAnagram(String s, String t) {
        char[] s1 = new char[26];
        char[] t1 = new char[26];

        for (int i = 0; i < s.length(); i++) {
            s1[s.charAt(i) - '0']++;
        }
        for (int i = 0; i < t.length(); i++) {
            t1[t.charAt(i) - '0']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1[i] != t1[i]) {
                return false;
            }
        }
        return true;
    }
}
