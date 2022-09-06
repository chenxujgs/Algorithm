package suanfa.likou.A20220906;

import suanfa.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class likou92 {
    /**
     * 思路: 相对比于传统的链表反转,只是增加了给定的起点和终点
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dist = new ListNode(-1);
        dist.next = head;
        ListNode pre = dist;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 反转代码
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dist.next;
    }
}
