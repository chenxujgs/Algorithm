package suanfa.likou.review;

import suanfa.ListNode;

public class likou82 {
    public ListNode deleteDuplicates(ListNode head) {
       ListNode cur=new ListNode(0,head);
       ListNode start=cur;
       while(start.next!=null&&start.next.next!=null){
            if(start.next.val==start.next.next.val){
               int x=start.next.val;
               while (start.next!=null&&start.next.val==x){
                   start.next=start.next.next;
               }
            }else{
                start=start.next;
            }
       }
        return cur.next;
    }
}
