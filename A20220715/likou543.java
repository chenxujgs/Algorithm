package suanfa.likou.A20220715;

import suanfa.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class likou543 {

    /**
     * 思路: 经典深搜,把大的问题看成多个子问题解决就行
     */
    int sum;

    public int diameterOfBinaryTree(TreeNode root) {
        sum = 0;
        diameter(root);
        return sum;
    }

    private int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);

        sum = Math.max(sum, left + right);
        return Math.max(left, right) + 1;
    }
}
