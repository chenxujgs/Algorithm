package suanfa.likou.A20220816;

import suanfa.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class likou23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            merge(res, lists[i]);
        }

        return res;
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null || right == null) {
            return left == null ? left : right;
        }

        ListNode res = new ListNode(-1);
        ListNode dist = res;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                dist.next = left;
                left = left.next;
            } else {
                dist.next = right;
                right = right.next;
            }
        }

        dist.next = left == null ? right : left;


        return res.next;
    }


}
