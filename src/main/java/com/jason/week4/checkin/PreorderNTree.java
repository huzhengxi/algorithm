package com.jason.week4.checkin;

import com.jason.utils.treeutil.NTreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 */

public class PreorderNTree {

  /**
   * 非递归
   *
   * @param root
   * @return
   */
  public List<Integer> preorder(NTreeNode root) {
    LinkedList<NTreeNode> stack = new LinkedList<>();
    List<Integer> res = new LinkedList<>();
    if (root == null) {
      return res;
    }

    stack.add(root);
    while (!stack.isEmpty()) {
      NTreeNode node = stack.pollLast();
      res.add(node.val);
      //栈后进先出，所以将子节点逆序
//      Collections.reverse(node.children);
      for (int i = node.children.size() - 1; i >= 0; i--) {
        stack.add(node.children.get(i));
      }
    }
    return res;
  }

  /**
   * 递归
   */
  public List<Integer> resList = new ArrayList<>();

  public List<Integer> preorderRecursive(NTreeNode root) {
    if (root == null) {
      return resList;
    }
    resList.add(root.val);
    for (NTreeNode node : root.children) {
      preorderRecursive(node);
    }
    return resList;
  }
}
