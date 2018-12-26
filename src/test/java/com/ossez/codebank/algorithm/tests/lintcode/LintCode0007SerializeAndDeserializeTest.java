package com.ossez.codebank.algorithm.tests.lintcode;

import java.util.ArrayList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ossez.codebank.algorithm.models.TreeNode;

/**
 * <p>
 * 7
 * <ul>
 * <li>@see <a href=
 * "https://www.cwiki.us/display/ITCLASSIFICATION/Serialize+and+Deserialize+Binary+Tree">https://www.cwiki.us/display/ITCLASSIFICATION/Serialize+and+Deserialize+Binary+Tree</a>
 * <li>@see<a href=
 * "https://www.lintcode.com/problem/serialize-and-deserialize-binary-tree">https://www.lintcode.com/problem/serialize-and-deserialize-binary-tree</a>
 * </ul>
 * </p>
 * 
 * @author YuCheng
 *
 */
public class LintCode0007SerializeAndDeserializeTest {

	private final static Logger logger = LoggerFactory.getLogger(LintCode0007SerializeAndDeserializeTest.class);

	/**
	 * 
	 */
	@Test
	public void testMain() {
		logger.debug("BEGIN");
		String data = "{3,9,20,#,#,15,7}";

		System.out.println(serialize(deserialize(data)));

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

	/**
	 * 
	 * @param root
	 * @return
	 */
	public String serialize(TreeNode root) {
		// write your code here
		if (root == null) {
			return "{}";
		}

		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);

		for (int i = 0; i < queue.size(); i++) {
			TreeNode node = queue.get(i);
			if (node == null) {
				continue;
			}
			queue.add(node.left);
			queue.add(node.right);
		}

		while (queue.get(queue.size() - 1) == null) {
			queue.remove(queue.size() - 1);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(queue.get(0).val);
		for (int i = 1; i < queue.size(); i++) {
			if (queue.get(i) == null) {
				sb.append(",#");
			} else {
				sb.append(",");
				sb.append(queue.get(i).val);
			}
		}
		sb.append("}");
		return sb.toString();
	}

}
