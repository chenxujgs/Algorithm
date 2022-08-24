package suanfa.likou.A20220824;

import suanfa.ListNode;

/**
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * <p>
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * <p>
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * <p>
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 */
public class likou328 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(4, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(2, n3);
        ListNode n5 = new ListNode(1, n4);

        new likou328().oddEvenList(n5);
    }

    /**
     * 标记两个指针移动即可
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode left = head, right = head.next, tmp = right;
        while (right != null && right.next != null) {
            left.next = right.next;
            right.next = right.next.next;
            left = left.next;
            right = right.next;
        }

        left.next = tmp;

        return head;
    }
}
