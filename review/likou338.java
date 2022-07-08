package suanfa.likou.review;

/**
 * @author cxj
 * @date 2022/6/16
 * @description
 */
//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
// 返回一个长度为 n + 1 的数组 ans 作为答案
public class likou338 {
    public static void main(String[] args) {

    }

    //x=x&(x-1)
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }

    //利用奇偶性
    public int[] countBits1(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = (i & 1) == 1 ? bits[i - 1] + 1 : bits[i >> 1];
        }
        return bits;
    }
}
