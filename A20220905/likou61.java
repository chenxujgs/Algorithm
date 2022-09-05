package suanfa.likou.A20220905;

import suanfa.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class likou61 {
    /**
     * 思路: 根据题意思路直接破解即可
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int n = 1;
        ListNode right = head;
        while (right.next != null) {
            n++;
            right = right.next;
        }


        int add = n - k % n;
        if (add == n) {
            return head;
        }

        right.next = head;
        while (add-- > 0) {
            right = right.next;
        }

        ListNode node = right.next;
        right.next = null;

        return node;
    }
}
