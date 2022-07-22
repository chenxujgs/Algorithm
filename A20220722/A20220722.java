package suanfa.likou.A20220722;

import suanfa.ListNode;
import suanfa.likou.A20220721.likou234;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class A20220722 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(1, listNode1);
        ListNode listNode5 = new ListNode(6, listNode2);
        ListNode listNode3 = new ListNode(2, listNode5);
        ListNode listNode4 = new ListNode(8, listNode3);
        new A20220722().sortList(listNode4);
    }

    /**
     * 经典分治
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode secondNode = Split(head);
        secondNode = sortList(secondNode);
        head = sortList(head);
        return merge(head, secondNode);
    }

    private ListNode merge(ListNode head, ListNode secondNode) {
        ListNode cur = new ListNode(0);
        ListNode dim = cur;

        while (head != null && secondNode != null) {
            if (head.val < secondNode.val) {
                dim.next = head;
                head = head.next;
            } else {
                dim.next = secondNode;
                secondNode = secondNode.next;
            }
            dim = dim.next;

        }
        if (head != null) {
            dim.next = head;
        }
        if (secondNode != null) {
            dim.next = secondNode;
        }

        return cur.next;
    }

    private ListNode Split(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }
    // 采用这个无法断开之前的指针
//    private ListNode Split(ListNode head) {
//        ListNode fast = head, slow = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
}
