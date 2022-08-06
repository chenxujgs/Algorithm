package suanfa.likou.A20220806;

/**
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * <p>
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * <p>
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * <p>
 * 返回规则如下：
 * <p>
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 */
public class likou165 {
    public static void main(String[] args) {
       // new likou165().compareVersion("1.01", "1.001");
        new likou165().compareVersion("0.1", "1.1");
    }

    /**
     * 第一个修订号不存在前导0,可理解成求两个版本号转化成数字的大小,排除前导0
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        int l1 = 0, l2 = 0;
        int m = version1.length(), n = version2.length();

        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();

        while (l1 < m || l2 < n) {
            int sum1 = 0, sum2 = 0;
            while (l1 < m && v1[l1] != '.') {
                sum1 = sum1 * 10 + v1[l1++] - '0';
            }
            while (l2 < n && v2[l2] != '.') {
                sum2 = sum2 * 10 + v2[l2++] - '0';
            }
            if (sum1 > sum2) {
                return 1;
            }
            if (sum1 < sum2) {
                return -1;
            }
            l1++;
            l2++;
        }
        return 0;
    }
}
