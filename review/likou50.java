package suanfa.likou.review;

import suanfa.ListNode;

public class likou50 {
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */

    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode right=head;
        for (int i = 0; i <k ; i++) {
            if(right==null) return head;
            right=right.next;
        }
        ListNode res = reverseKGroupForm(head, right);
        head.next = reverseKGroup(right, k);
        return res;

    }

    private ListNode reverseKGroupForm(ListNode left, ListNode right) {
        ListNode pre=right;
        while(left!=right){
            ListNode next=left.next;
            left.next=pre;
            pre=left;
            left=next;
        }
        return pre;
    }
    public static void main(String[] args) {
    ListNode listNode=new ListNode(-1);
   // ListNode listNode=head;
        for (int i = 0; i <6 ; i++) {
            listNode.val=i;
            listNode=listNode.next;
        }
        likou50 l=new likou50();
        ListNode listNode1 = l.reverseKGroup(listNode, 2);
        for (int i = 0; i <6 ; i++) {
            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }
    }
}