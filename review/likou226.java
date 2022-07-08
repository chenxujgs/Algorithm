package suanfa.likou.review;

/**
 * @author cxj
 * @date 2022/6/5
 * @description
 */

import suanfa.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class likou226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 获取左右子节点
        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
