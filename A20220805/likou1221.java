package suanfa.likou.A20220805;

/**
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的 最大数量
 */
public class likou1221 {
    public static void main(String[] args) {
        System.out.println(new likou1221().balancedStringSplit("RLLLLRRRLR"));
    }


    /**
     * 思路: 贪心+计数,L 和 R 相等即可
     *
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int l = 0, r = 0;
        int sum = 0, len = s.length(), index = 0;
        while (index < len) {
            if (s.charAt(index++) == 'R') {
                r++;
            } else {
                l++;
            }

            if (l == r) {
                sum++;
            }
        }
        return sum;
    }
}
