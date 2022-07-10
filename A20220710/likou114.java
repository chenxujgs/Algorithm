package suanfa.likou.A20220710;

import suanfa.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class likou114 {
    /**
     * 思路: O(1)复杂度,在原树上进行改动
     * 先定位根节点的左节点next和在找到next节点的最右子节点pre,将根节点的右节点连接到pre的右节点上,在将next连接到根节点的右节点
     * 在进行cur的往下遍历
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }


}
