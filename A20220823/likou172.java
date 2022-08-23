package suanfa.likou.A20220823;

/**
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 */
public class likou172 {
    public static void main(String[] args) {
        System.out.println(new likou172().trailingZeroes(30));
    }

    /**
     * 思路: 在阶乘过程中记录5出现的次数,因此想要有尾随0,就必然需要某个偶数与5相乘
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }


}
