package suanfa.likou.review;

import java.util.Arrays;

public class likou740 {
    public static void main(String[] args) {
        System.out.println(new likou740().deleteAndEarn(new int[]{1}));
    }

    // 类似打家劫舍,需先转化数组,将偷与不偷的问题抽象为加与不加
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        // 排除数组只要一个元素的可能性
        if (len < 2) {
            return nums[0];
        }
        // 先排序,直接获取最大值
        Arrays.sort(nums);
        // 该值为数组最大值
        int n = nums[len - 1] + 1;
        // 初始化数组,长度为nums数组最大值
        int[] temp = new int[n];
        // 统计,将nums数组每个元素作为索引,在temp数组中该索引值作为每个元素出现的次数
        for (int i = 0; i < len; i++) {
            temp[nums[i]]++;
        }
        // 初始化数组
        int[] db = new int[n];
        // 取第一个数,该值为目前最大值
        db[1] = temp[1];
        // 抉择第二个数是否取,与前一个数进行比较
        db[2] = Math.max(db[1], temp[2] * 2);
        for (int i = 2; i < n; i++) {
            /**
             * 动态转移方程,前一个点数与目前的值和前第二个索引值相加(获取当前取值和不取值的最大点数)
             * 取值则代表抛弃前一个索引的值
             * 不取值代表放弃当前索引的值
             */
            db[i] = Math.max(db[i - 1], (temp[i] * i + db[i - 2]));
        }
        return db[n - 1];
    }
}

