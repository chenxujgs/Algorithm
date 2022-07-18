package suanfa.likou.A20220718;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，
 * 请在该位置用 0 来代替。
 * <p>
 */
public class likou739 {
    public static void main(String[] args) {
        // System.out.println(new likou739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        System.out.println(new likou739().dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}));
    }

    /**
     * 典型的利用栈的先进先出特性
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = temperatures.length;
        int[] answer = new int[n];

        answer[n - 1] = 0;
        stack.addFirst(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.getFirst()] <= temperatures[i]) {
                stack.removeFirst();
            }

            answer[i] = stack.isEmpty() ? 0 : stack.getFirst() - i;

            stack.addFirst(i);
        }
        return answer;
    }
}
