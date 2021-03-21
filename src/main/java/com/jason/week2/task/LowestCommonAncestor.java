package com.jason.week2.task;

import com.jason.utils.treeutil.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || q == root) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left == null) {
      return right;
    }

    if (right == null) {
      return left;
    }
    return root;
  }
}
