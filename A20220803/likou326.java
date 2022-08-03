package suanfa.likou.A20220803;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 */
public class likou326 {
    /**
     * 思路:规定 -2^31 <= n <= 2^31 - 1
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new likou326().isPowerOfThree(45));
    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    /**
     * 超时
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree1(int n) {
        int temp = 1;
        while (temp <= n) {
            if (temp == n) {
                return true;
            }
            temp *= 3;
        }
        return n == 1 ? true : false;
    }
}
