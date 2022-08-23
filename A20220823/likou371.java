package suanfa.likou.A20220823;

/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 -，计算并返回两整数之和。
 */
public class likou371 {
    public static void main(String[] args) {
        new likou371().getSum(2, 3);
    }

    /**
     * 思路: 如果是一位数相加直接使用异或就可以得到相加的结果,但是两位数涉及到进位,就要记录进位
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        int forward = (a & b) << 1; // 记录进位
        int xor = a ^ b; // 执行加法
        return forward == 0 ? xor : getSum(xor, forward);
    }
}
