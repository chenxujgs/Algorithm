package suanfa.likou.review;

/**
 * @author cxj
 * @date 2022/6/2
 * @description
 */

import suanfa.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class likou160 {
    /**
     * 双指针(O(m+n))
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode la = headA, lb = headB;
        while (la != lb) {
            // 往相反位置可以加快步伐
            la = la == null ? headB : la.next;
            lb = lb == null ? headA : lb.next;
        }
        return la;
    }

    /**
     * 先得出两个链表长度的差,在从同一个相对起点开始找出共同的节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode la = headA, lb = headB;
        int diff = 0, l1 = 0, l2 = 0;
        while (la != null) {
            ++l1;
            la = la.next;
        }
        while (lb != null) {
            ++l2;
            lb = lb.next;
        }

        if (l1 > l2) {
            diff = l1 - l2;
            la = headA;
            lb = headB;
        } else {
            diff = l2 - l1;
            la = headB;
            lb = headA;
        }

        while (diff-- > 0) {
            la = la.next;
        }

        while (la != null) {
            if (la == lb) {
                return la;
            }
            la = la.next;
            lb = lb.next;
        }
        return lb;
    }

}
