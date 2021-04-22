package com.ossez.toolkits.codebank.common.model;

/**
 * 
 * @author YuCheng
 *
 */
public class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}
