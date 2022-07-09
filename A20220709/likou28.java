package suanfa.likou.A20220709;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 */
public class likou28 {
    public static void main(String[] args) {
        System.out.println(new likou28().strStr("hello", "ll"));
    }

    /**
     * 思路: 直接遍历
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int h = haystack.length(), n = needle.length();
        for (int i = 0; i < h; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int left = i + 1, right = 1;
                while (left < h && right < n && haystack.charAt(left) == needle.charAt(right)) {
                    left++;
                    right++;
                }
                if (right == n) {
                    return i;
                }
            }
        }
        return -1;
    }
}
