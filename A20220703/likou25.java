package suanfa.likou.A20220703;

import suanfa.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class likou25 {
    /**
     * 思路: 由两两交换链表的思路而来,主要是要防止因为节点不够而溢出
     * 最后浓缩成k个链表内的链表反转
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 自定义头节点
        ListNode head1 = new ListNode(0);
        head1.next = head;
        ListNode curr = head1;

        while (curr != null) {
            ListNode pre = curr;
            ListNode next = curr.next;
            for (int i = 0; i < k; i++) {
                if (next == null) {
                    return head1.next;
                }
                next = next.next;
            }

            curr = curr.next;
            for (int i = 0; i < k - 1; i++) {
                next = curr.next;
                curr.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
        }
        return head1.next;
    }
}
