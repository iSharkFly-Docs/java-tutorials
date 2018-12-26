package com.ossez.codebank.algorithm.tests.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ossez.codebank.algorithm.models.TreeNode;

/**
 * <p>
 * 69
 * <ul>
 * <li>@see <a href=
 * "https://www.cwiki.us/display/ITCLASSIFICATION/Binary+Tree+Level+Order+Traversal">https://www.cwiki.us/display/ITCLASSIFICATION/Binary+Tree+Level+Order+Traversal</a>
 * <li>@see<a href=
 * "https://www.lintcode.com/problem/binary-tree-level-order-traversal">https://www.lintcode.com/problem/binary-tree-level-order-traversal</a>
 * </ul>
 * </p>
 * 
 * @author YuCheng
 *
 */
public class LintCode0069LevelOrderTest {

	private final static Logger logger = LoggerFactory.getLogger(LintCode0069LevelOrderTest.class);

	/**
	 * 
	 */
	@Test
	public void testMain() {
		logger.debug("BEGIN");
		String data = "{3,9,20,#,#,15,7}";

		TreeNode tn = deserialize(data);
		System.out.println(levelOrder(tn));

	}

	/**
	 * Deserialize from array to tree
	 * 
	 * @param data
	 * @return
	 */
	private TreeNode deserialize(String data) {
		// NULL CHECK
		if (data.equals("{}")) {
			return null;
		}

		ArrayList<TreeNode> treeList = new ArrayList<TreeNode>();

		data = data.replace("{", "");
		data = data.replace("}", "");
		String[] vals = data.split(",");

		// INSERT ROOT
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		treeList.add(root);

		int index = 0;
		boolean isLeftChild = true;
		for (int i = 1; i < vals.length; i++) {
			if (!vals[i].equals("#")) {
				TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
				if (isLeftChild) {
					treeList.get(index).left = node;
				} else {
					treeList.get(index).right = node;
				}
				treeList.add(node);
			}

			// LEVEL
			if (!isLeftChild) {
				index++;
			}

			// MOVE TO RIGHT OR NEXT LEVEL
			isLeftChild = !isLeftChild;
		}

		return root;

	}

	private List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> rs = new ArrayList<List<Integer>>();

		// NULL CHECK
		if (root == null) {
			return rs;
		}

		queue.offer(root);

		while (!queue.isEmpty()) {
			int length = queue.size();
			List<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < length; i++) {
				TreeNode curTN = queue.poll();
				list.add(curTN.val);
				if (curTN.left != null) {
					queue.offer(curTN.left);
				}
				if (curTN.right != null) {
					queue.offer(curTN.right);
				}
			}

			rs.add(list);
		}

		return rs;
	}
}
