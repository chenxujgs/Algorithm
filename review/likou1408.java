package suanfa.likou.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxj
 * @date 2022/6/17
 * @description
 */
public class likou1408 {
    public static void main(String[] args) {
        // System.out.println(new likou1408().stringMatching(new String[]{"mass","as","hero","superhero"}));
        System.out.println(new likou1408().stringMatching(new String[]{"leetcode", "et", "code"}));
    }

    List<String> list = new ArrayList<>();

    public List<String> stringMatching(String[] words) {
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (words[i].length() > words[j].length()) {
                    matchBF(words[i], words[j]);
                } else {
                    matchBF(words[j], words[i]);
                }
            }
        }
        return list;
    }

    private void matchBF(String longStr, String shortStr) {
        for (int i = 0, j = 1, slen = shortStr.length(), llen = longStr.length();
             i < llen; i++) {
            if (longStr.charAt(i) == shortStr.charAt(0)) {
                int temp = i + 1;
                while (j < slen && temp < llen) {
                    if (longStr.charAt(j) == shortStr.charAt(temp)) {
                        j++;
                        temp++;
                    } else {
                        break;
                    }
                }

            } else {

            }
        }
    }

}
