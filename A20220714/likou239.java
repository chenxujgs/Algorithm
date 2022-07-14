package suanfa.likou.A20220714;

import java.util.*;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 */
public class likou239 {
    public static void main(String[] args) {
        int[] ints = new likou239().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[0] - o2[0] : o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];
        res[0] = queue.peek()[0];
        for (int i = k; i < n; i++) {
            queue.offer(new int[]{nums[i], i});
            // 重点: 只需比较头元素,每次判断头元素是否为需要剔除的索引
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
        }
        return res;
    }
}
