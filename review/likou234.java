package suanfa.likou.review;

import suanfa.ListNode;

/**
 * @author cxj
 * @date 2022/6/2
 * @description
 */

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class likou234 {
    // 将链表截取成两半,对其中一个进行反转,在判断是否相等
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 判断若链表长度为奇数,移动慢指针一步
        if (fast != null) {
            slow = slow.next;
        }

        slow = reserve(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reserve(ListNode slow) {
        ListNode cur = null, head = slow;
        while (head != null) {
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }
}
