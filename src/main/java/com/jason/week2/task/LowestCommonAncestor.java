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

  public static void main(String[] args) {
    BuildTree buildTree = new BuildTree();
    TreeNode root = buildTree
        .buildTree(new int[]{3, 5, 6, 2, 7, 4, 1, 0, 8}, new int[]{6, 5, 7, 2, 4, 3, 0, 1, 8});
    TreeNode p = root.left;
    TreeNode q = p.right.right;
    LowestCommonAncestor obj = new LowestCommonAncestor();
    TreeNode loweastNode = obj.lowestCommonAncestor(root, p, q);
    System.out.println(loweastNode.val);
  }
}
