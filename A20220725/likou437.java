package suanfa.likou.A20220725;

import suanfa.TreeNode;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class likou437 {
    /**
     * 思路: 深搜支点进行遍历
     */
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        dfs1(root, targetSum);

        if (root.left != null) {
            dfs(root.left, targetSum - root.val);
        }

        if (root.right != null) {
            dfs(root.right, targetSum - root.val);
        }
    }

    private void dfs1(TreeNode root, int targetSum) {
        if (targetSum == 0) {
            res++;
        }

        if (root.left != null) {
            dfs1(root.left, targetSum - root.left.val);
        }

        if (root.right != null) {
            dfs1(root.right, targetSum - root.right.val);
        }
    }
}
