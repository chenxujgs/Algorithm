package suanfa.likou.review;

import suanfa.ListNode;

/**
 * @author cxj
 * @date 2022/6/3
 * @description
 */

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class likou876 {
    // 使用快慢指针
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
