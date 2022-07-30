package suanfa.likou.A20220729;

import java.util.HashMap;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 */
public class likou387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
             if(map.get(s.charAt(i))!=-1){
                 return i;
             }
        }
        return -1;
    }
}
