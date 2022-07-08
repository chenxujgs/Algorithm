package suanfa.likou.review;

import suanfa.ListNode;

/**
 * @author cxj
 * @date 2022/6/1
 * @description
 */

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class likou83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headNext = head;
        while (null != headNext) {
            if (headNext.val == headNext.next.val) {
                headNext.next=headNext.next.next;
            } else {
                headNext=headNext.next;
            }
        }
        return head;
    }
}
