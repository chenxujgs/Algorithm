package suanfa.likou.review;

public class likou918 {
    public static void main(String[] args) {
        System.out.println(new likou918().maxSubarraySumCircular(new int[]{-2, 1, 2, 3, -5}));
    }

    /**
     * 可参考力扣53题的最大子数组和
     * 分为三种情况
     * 1. 数组都是正数 [+ + + + +]   minSum>0  直接返回MaxSum
     * 2. 数组都是负数 [- - - - -]   maxSum<0  直接返回MaxSum
     * 3. 数组最大子段和在中间出现  [- - + + + - - -]  正数仅出现在中间  直接返回MaxSum 类似53题,可与第四种情况结合
     * 4. 数组最大子段和为环形数组  [+ - - - - + + +]  正数仅出现在开头和结尾或者中间,且中间必定有连续的负数,该段为最小子段和
     * <p>
     * 环形数组的情况: 数组之和=最大子段和+最小子段和
     * 最大子段和=数组之和-最小子段和
     *
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        // 前一个状态的最大子段和和最小子段和
        int preMax = 0, preMin = 0;
        // 存储最大子段和和最小子段和
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        // 存储数组之和
        int sum = 0;
        for (int num : nums) {
            preMax += num;
            preMin += num;
            // 更改前一个状态的最大子段和和目前值的最大值
            preMax = Math.max(preMax, num);
            // 更改前一个状态的最小子段和和目前值的最大值
            preMin = Math.min(preMin, num);
            // 更改前一个状态的最大子段和和目前最大子段和的最大值
            maxSum = Math.max(maxSum, preMax);
            // 更改前一个状态的最小子段和和目前最小子段和的最大值
            minSum = Math.min(minSum, preMin);
            // 统计数组之和
            sum += num;
        }

        // 三种状态
        if (maxSum < 0) {   //数组都是负数
            return maxSum;
        } else if (minSum > 0) {  //数组都是正数
            return maxSum;
        } else {  //最大子段和出现且为正数/环形数组
            return Math.max(maxSum, sum - minSum);
        }

    }
}
