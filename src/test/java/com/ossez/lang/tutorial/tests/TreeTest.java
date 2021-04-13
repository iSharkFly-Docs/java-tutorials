package com.ossez.lang.tutorial.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ossez.lang.tutorial.models.TreeNode;
import com.ossez.lang.tutorial.utils.TreeUtils;

/**
 * 
 * @author YuCheng
 *
 */
public class TreeTest {
	private final static Logger logger = LoggerFactory.getLogger(TreeTest.class);
	private static List<Integer> loopList = new ArrayList<Integer>();

	@Test
	public void testMain() {
		logger.debug("TREE TEST");
		String data = "{1,2,3,4,5,#,6,#,#,7,8,#,#}";
		TreeNode treeNode = TreeUtils.initTree(data);

		// PRE
		loopList = new ArrayList<Integer>();
		preOrderTraverselRecursion(treeNode);
		System.out.println(loopList);

		// IN
		loopList = new ArrayList<Integer>();
		inOrderTraverselRecursion(treeNode);
		System.out.println(loopList);

		// POST
		loopList = new ArrayList<Integer>();
		postOrderTraversalRecursion(treeNode);
		System.out.println(loopList);
	}
	
	
	

	/**
	 * 
	 * @param root
	 */
	public void preOrderTraverselRecursion(TreeNode root) {
		if (root != null) {
			loopList.add(root.val);
			preOrderTraverselRecursion(root.left);
			preOrderTraverselRecursion(root.right);
		}
	}

	/**
	 * 
	 * @param root
	 */
	public void inOrderTraverselRecursion(TreeNode root) {
		if (root != null) {
			inOrderTraverselRecursion(root.left);
			loopList.add(root.val);
			inOrderTraverselRecursion(root.right);
		}

	}

	/**
	 * 
	 * @param root
	 */
	public void postOrderTraversalRecursion(TreeNode root) {
		if (root != null) {
			postOrderTraversalRecursion(root.left);
			postOrderTraversalRecursion(root.right);
			loopList.add(root.val);
		}

	}

}
