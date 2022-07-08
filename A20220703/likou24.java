package suanfa.likou.A20220703;

import suanfa.ListNode;

public class likou24 {
    /**
     * temp next1 next2
     * 0 --> 1 --> 2  --> 3
     * 1  0 --> 2 --> 1  --> 3
     * 2  1 --> 3
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * <p>
     * 思路: 使用快慢指针,两者相差1个索引,交换指针对应的链表节点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        temp.next = head;

        while (temp.next != null && temp.next.next != null) {
            ListNode next1 = temp.next;
            ListNode next2 = temp.next.next;

            temp.next = next2;
            next2.next = next1;
            next1.next = next2.next;

            temp = next1;

        }
        return result.next;
    }
}
