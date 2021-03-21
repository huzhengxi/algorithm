package com.jason.week2.task;

import com.jason.utils.treeutil.TreeNode;
import com.jason.utils.treeutil.TreeUtil;
import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树 思路：递归 时间复杂度：O(n)，n为树中节点的个数 空间复杂度为 O(n）
 */
public class BuildTree {

  private Map<Integer, Integer> indexMap;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = preorder.length;
    indexMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      indexMap.put(inorder[i], i);
    }

    return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
  }

  private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeftIndex,
      int preorderRightIndex,
      int inorderLeftIndex, int inorderRightIndex) {
    if (preorderLeftIndex > preorderRightIndex) {
      return null;
    }

    int preorderRootIndex = preorderLeftIndex;
    int inorderRootIndex = indexMap.get(preorder[preorderRootIndex]);

    TreeNode root = new TreeNode(preorder[preorderRootIndex]);
    int leftSubTreeOfSize = inorderRootIndex - inorderLeftIndex;

    root.left = myBuildTree(preorder, inorder, preorderLeftIndex + 1,
        preorderLeftIndex + leftSubTreeOfSize, inorderLeftIndex, inorderRootIndex - 1);
    root.right = myBuildTree(preorder, inorder, preorderLeftIndex + leftSubTreeOfSize + 1,
        preorderRightIndex,
        inorderRootIndex + 1, inorderRightIndex);

    return root;
  }


  public static void main(String[] args) {
//    BuildTree obj = new BuildTree();
//    System.out.println();
  }

}
