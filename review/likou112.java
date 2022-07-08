package suanfa.likou.review;

import suanfa.TreeNode;

public class likou112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
       if(root==null) return false;
       int sum=root.val;
       if(root.left==null||root.right==null){
           return targetSum==sum;
       }

       return hasPathSum(root.left,targetSum-sum)||hasPathSum(root.right,targetSum-sum);
    }
}
