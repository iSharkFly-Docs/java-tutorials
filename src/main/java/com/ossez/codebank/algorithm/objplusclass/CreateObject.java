package com.ossez.codebank.algorithm.objplusclass;

/**
 * 
 * @author YuCheng
 *
 */
public class CreateObject {
	public CreateObject(String name) {
		// This constructor has one parameter, name
		System.out.println("小狗的名字是: " + name);
	}

	public static void main(String[] args) {
		// Following statement would create an object myPuppy
		CreateObject myPuppy = new CreateObject("Tomcat");
	}
}
