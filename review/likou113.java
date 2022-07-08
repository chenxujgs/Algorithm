package suanfa.likou.review;

import suanfa.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class likou113 {
    List<List<Integer>> lists = new ArrayList<>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root, targetSum, new ArrayList<Integer>());
        return lists;
    }

    private void pathSum(TreeNode node, int targetSum, ArrayList<Integer> list) {

        if (node == null) return;
        int val = node.val;
        list.add(val);
        if (node.left == null && node.right == null) {
            if (val == targetSum) {
                lists.add(list);
                list = new ArrayList<>();
            }
        }
        pathSum(node.left, targetSum - val, new ArrayList<>(list));
        pathSum(node.right, targetSum - val, new ArrayList<>(list));
    }

    private void dfs(TreeNode node, int targetSum) {

        if (node == null) return;
        int val = node.val;
        path.offerFirst(val);
        if (node.left == null && node.right == null) {
            if (0== targetSum) {
                lists.add(new LinkedList<Integer>(path));
            }
        }
        dfs(node.left, targetSum - val);
        dfs(node.right, targetSum - val);
        path.pollLast();
    }
}
