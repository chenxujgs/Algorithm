package suanfa.likou.review;

import java.util.Stack;

public class likou76 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.size()==0){
            while (stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        likou76 n=new likou76();
        n.push(1);
        n.push(2);
        n.push(3);
        n.push(4);
        n.push(5);
        n.push(6);
//       int size=n.stack1.size();
//        for (int i = 0; i <size ; i++) {
//            System.out.print(n.stack1.pop()+"="+i+" ");
//        }
        System.out.println();
        System.out.println("被删除的元素:"+n.pop());
        n.push(8);
        System.out.println("被删除的元素:"+n.pop());
    }
}