package suanfa.likou.A20220712;

import suanfa.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class likou124 {
    /**
     * 思路: 最大值有可能是左子节点+右子节点+根节点或 max(左子节点,右子节点)+根节点
     * 左子节点+右子节点+根节点 又可细分为
     * 左子节点(max(左子子节点,右子子节点)+左子节点)+右子节点(max(左子子节点,右子子节点)+右子节点)+根节点
     * 递归返回的最大值总是 max(左子节点,右子节点)+根节点作为子节点的最大值,方便上层树进行判断
     * 在此之前需要对有可能造成的第一种情况的最大值进行判断
     */
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftVal = Math.max(0, dfs(root.left));
        int rightVal = Math.max(0, dfs(root.right));

        int sum = root.val + leftVal + rightVal;
        max = Math.max(sum, max);

        return root.val + Math.max(leftVal, rightVal);
    }
}
