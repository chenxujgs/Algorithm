package suanfa.likou.A20220807;

import suanfa.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 */
public class likou2 {
    /**
     * 思路:经典链表题目,记录好溢出的值即可
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode pre = new ListNode(-1);
        ListNode res = pre;

        while (l1 != null || l2 != null) {
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;

            int array = i1 + i2 + add;
            pre.next = new ListNode(array % 10);
            add = array / 10;
            pre = pre.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (add == 1) {
            pre.next = new ListNode(add);
        }
        return res;
    }
}
