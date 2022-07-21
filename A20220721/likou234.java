package suanfa.likou.A20220721;

import suanfa.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
 */
public class likou234 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode5 = new ListNode(3, listNode2);
        ListNode listNode3 = new ListNode(2, listNode5);
        ListNode listNode4 = new ListNode(1, listNode3);
        System.out.println(new likou234().isPalindrome(listNode4));

    }

    /**
     * 思路: 将链表截断成两半,反转其中一个在判断是否相等
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }


        slow = reserve(slow);
        fast = head;

        while (fast != null && slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    // 链表反转
    private ListNode reserve(ListNode slow) {
        ListNode node = slow, pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
