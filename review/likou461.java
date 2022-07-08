package suanfa.likou.review;

/**
 * @author cxj
 * @date 2022/6/17
 * @description
 */

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 */
public class likou461 {
    public int hammingDistance(int x, int y) {
        int distance=0;
        for (int xor = x ^ y; xor != 0; xor = xor & (xor - 1)) {
             distance++;
        }
        return distance;
    }
}
