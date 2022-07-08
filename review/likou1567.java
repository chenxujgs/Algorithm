package suanfa.likou.review;

// 准备两个数组,分别存储当前最大值和最小值
public class likou1567 {
    public static void main(String[] args) {
        System.out.println(new likou1567().getMaxLen1(new int[]{
                0, 1, -2, -3, -4}));
    }

    public int getMaxLen(int[] nums) {
        int len = nums.length;
        // 存储负数的最大子集合的长度
        int[] minLen = new int[len];
        // 存储正数的最大子集合的长度
        int[] maxLen = new int[len];
        // 初始化0索引的值
        if (nums[0] > 0) {   //初始化正数组第一个为1
            maxLen[0] = 1;
        } else if (nums[0] < 0) {  //初始化负数组第一个为1
            minLen[0] = 1;
        }
        // 存储正数的最大长度
        int maxlen = maxLen[0];
        for (int i = 1; i < len; i++) {
            /**
             * >0
             * 正数数组最大长度＋1
             * 负数数组根据i-1索引的值分为两种状态:
             *    一. i-1>0 即之前存在相乘为负数的最大长度,＋1即可
             *    二. i-1<=0 不存在相乘为负数的最大长度,继续为0
             */
            if (nums[i] > 0) {
                // 值＞0 正数组长度+1
                maxLen[i] = maxLen[i - 1] + 1;
                // 防止不存在相减使该索引值为-1(总是保证有效索引的值记录的相乘数都为负数)
                minLen[i] = minLen[i - 1] > 0 ? minLen[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                /**
                 * <0
                 * 正数组: minLen[i - 1] > 0,说明负数组[i-1]存在相乘为负数的最大长度,乘上负数变为正数,即为正数的最大长度,
                 *        minLen[i - 1] <= 0,说明负数组不存在相乘为负数的最大长度,乘上负数依旧为负数
                 * 负数组: 正数组总为正数(无论是否有最大长度),相乘总是负数
                 */
                maxLen[i] = minLen[i - 1] > 0 ? minLen[i - 1] + 1 : 0;
                minLen[i] = maxLen[i - 1] + 1;
            } else {
                // 索引值为0,相乘总是0,不符合题意
                maxLen[i] = 0;
                minLen[i] = 0;
            }
            // 记录每个循环产生的最大值,因为存在索引值可能为0
            maxlen = Math.max(maxlen, maxLen[i]);
        }
        return maxlen;
    }

    public int getMaxLen1(int[] nums) {
        int len = nums.length;
        // 存储负数的最大子集合的长度
        int minLen =0;
        // 存储正数的最大子集合的长度
        int maxLen =0;

        if (nums[0] > 0) {   //初始化正数子长度第一个为1
            maxLen = 1;
        } else if (nums[0] < 0) {  //初始化负数子长度第一个为1
            minLen = 1;
        }
        // 存储正数的最大长度
        int marklen = maxLen;
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                // 最大正数子长度＋1
                maxLen = maxLen + 1;
                // 判断该集合是否存在负数最大子集合长度,存在即说明相乘依旧为正数,不存在相乘为正数,不符合
                minLen = minLen > 0 ? minLen + 1 : 0;
            } else if (nums[i] < 0) {
                /**
                 * 创建临时值存储的意义: 若不创建临时值,maxLen赋值后为新值,不能被minLen使用
                 */
                int tempmaxLen = minLen > 0 ? minLen + 1 : 0;
                int tempminLen = maxLen + 1;
                maxLen=tempmaxLen;
                minLen=tempminLen;
            } else {
                maxLen = 0;
                minLen = 0;
            }
            marklen = Math.max(marklen, maxLen);
        }
        return marklen;
    }
}
