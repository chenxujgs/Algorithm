package suanfa.likou.review;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxj
 * @date 2022/2/10
 * @description 共有 n 名小伙伴一起做游戏。小伙伴们围成一圈
 * 按 顺时针顺序 从 1 到 n 编号。确切地说，
 * 从第 i 名小伙伴顺时针移动一位会到达第 (i+1) 名小伙伴的位置，
 * 其中 1 <= i < n ，从第 n 名小伙伴顺时针移动一位会回到第 1 名小伙伴的位置。
 */
public class likou1823 {
    public static void main(String[] args) {
        System.out.println(new likou1823().findTheWinner1(5, 2));
    }

    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }

    public int findTheWinner1(int n, int k) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res=(res+k-1)%i+1;
        }
        return res;
    }
}















