package suanfa.likou.review;

import suanfa.TreeNode;

public class likou110 {
    /**
     * 每经过一个节点,遍历其左右子树高度
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
         if(root==null) return true;
        return Math.abs(MaxHight(root.right)-MaxHight(root.left))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    //遍历整棵树的高度
    private int MaxHight(TreeNode node) {
        if(node==null) return 0;
        return Math.max(MaxHight(node.left),MaxHight(node.right))+1;
    }
}
