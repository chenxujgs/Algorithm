package suanfa.likou.A20220726;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class likou69 {
    public static void main(String[] args) {
        System.out.println(new likou69().mySqrt(8));
    }

    public int mySqrt(int x) {
        return newtow(x);
    }

    /**
     * 牛顿迭代
     *
     * @param x
     * @return
     */
    private int newtow(int x) {
        return (int) sqrt(x, x);
    }

    // x=n^2 x/n=n
    private double sqrt(double i, int x) {
        // 逼近平均值
        double res = (i + x / i) / 2;
        if (res == i) {
            return res;
        } else {
            return sqrt(res, x);
        }
    }

    /**
     * 可使用二分法
     *
     * @param x
     * @return
     */
    public int binarySearch(int x) {
        int index = -1, l = 0, r = x;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (mid * mid <= x) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }
}
