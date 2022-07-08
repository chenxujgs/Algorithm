package suanfa.likou.review;

/**
 * @author cxj
 * @date 2022/2/12
 * @description 给定一个二叉搜索树的根节点 root 和一个值 key，
 * 删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）
 * 的根节点的引用。
 */
public class likou450 {
//    public TreeNode deleteNode(TreeNode root, int key) {
//        if (root == null) {
//            return null;
//        }
//        // 查找删除元素是否存在
//        if (binaryTreeSearch(root, key)==null) {
//            return root;
//        }
//
//        //根节点
//        if (key == root.val) {
//            // 左右子树非空
//            if (root.left != null && root.right != null) {
//                if (diff(root) > 0) { //左子树更高,往左边删除
//                    root.val = tree(root.left, 0); //以左子树最大值替换当前值
//                    root.left = deleteNode(root.left, root.val); //删除左子树已替换上的结点
//                } else { //右子树更高,往右边删
//                    root.val = tree(root.right, 1);
//                    root.right = deleteNode(root.right, root.val);
//                }
//                // 只有一个孩子/叶子节点得情况合并
//            } else {
//                root = root.left == null ? root.right : root.left;
//
//            }
//        } else if (key < root.val) { //左边删
//            root.left = deleteNode(root.left, key);
//            // 删除左边后,右子树变高
//            if (diff(root) < -1) {
//                if (diff(root.right) > 0) {
//                    root = RL_rotate(root);
//                } else {
//                    root = RR_rotate(root);
//                }
//            }
//        } else { //右边删
//            root.right = deleteNode(root.right, key);
//            // 删除左边后,右子树变高
//            if (diff(root) < -1) {
//                if (diff(root.left) > 0) {
//                    root = LR_rotate(root);
//                } else {
//                    root = LL_rotate(root);
//                }
//            }
//        }
//    }
//
//    private TreeNode LL_rotate(final TreeNode root) {
//    }
//
//    private TreeNode LR_rotate(final TreeNode root) {
//    }
//
//    private TreeNode RR_rotate(final TreeNode root) {
//    }
//
//    private TreeNode RL_rotate(final TreeNode root) {
//    }
//
//    //寻找子树最大值
//    private int tree(final TreeNode root, final int l) {
//        List<Integer> a = new ArrayList();
//        int i = 0;
//        searchTree(root, i, a);
//        if (l == 0) {
//            return a.get(0);
//        } else {
//            return a.get(i - 1);
//        }
//    }
//
//    private void searchTree(TreeNode root, int i, List<Integer> a) {
//        if (root == null) return;
//
//        if (root.left != null) {
//            searchTree(root.left, i, a);
//        }
//        a.add(root.val);
//        i++;
//        if (root.right != null) {
//            searchTree(root.right, i, a);
//        }
//
//    }
//
//    //求平衡因子
//    private int diff(final TreeNode root) {
//        return height(root.left) - height(root.right);
//    }
//
//    //树高
//    private int height(final TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(height(root.left), height(root.right) + 1);
//    }
//
//    //查找value
//    private TreeNode binaryTreeSearch(TreeNode root, int key) {
//        if (root.val == key) {
//            return root;
//        } else if (root.val > key) {
//            if (root.left != null) {
//                return binaryTreeSearch(root.left, key);
//            } else {
//                return null;
//            }
//        } else {
//            if (root.right != null) {
//                return binaryTreeSearch(root.right, key);
//            } else {
//                return null;
//            }
//        }
//    }
}
