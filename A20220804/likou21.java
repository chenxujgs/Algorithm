package suanfa.likou.A20220804;

import suanfa.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class likou21 {
    /**
     * 直接使用迭代法
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(0);
        ListNode res = list;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                list.next = list1;
                list1 = list1.next;
            } else {
                list.next = list2;
                list2 = list2.next;
            }
            list = list.next;
        }

        list.next = list1 == null ? list2 : list1;

        return res.next;
    }
}
