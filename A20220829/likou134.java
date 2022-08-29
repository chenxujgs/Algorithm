package suanfa.likou.A20220829;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */
public class likou134 {
    public static void main(String[] args) {
        System.out.println(new likou134().canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    /**
     * 思路: 记录两个数组的差,记录每一次相减的最小值,最后判断
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, ans = 0, min = Integer.MAX_VALUE, min_index = 0;
        for (int i = 0; i < n; i++) {
            ans += gas[i] - cost[i];
            if (ans < min) {
                min_index = i;
                min = ans;
            }
        }
        return ans < 0 ? -1 : (min_index + 1) % n;
    }
}
