package suanfa.likou.review;

import suanfa.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class likou617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        TreeNode left=null;TreeNode right=null;
        while(queue.size()>0){
            left=queue.poll();
            right=queue.poll();
            if(left.left!=null||left.left!=null){
                queue.offer(left.left);
                queue.offer(left.left);
            }

            if(right.right!=null||right.right!=null){
                queue.offer(right.right);
                queue.offer(right.right);
            }
            left.val= left.val+ right.val;
        }
        return left;
    }
}
