package com.ossez.codebank.algorithml.utils;

import java.util.ArrayList;

import com.ossez.codebank.algorithm.models.TreeNode;

/**
 * 
 * @author YuCheng
 *
 */
public class TreeUtils {

	public static TreeNode initTree(String data) {
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
}
