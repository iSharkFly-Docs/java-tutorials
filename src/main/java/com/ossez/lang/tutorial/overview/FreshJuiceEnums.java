package com.ossez.lang.tutorial.overview;

/**
 * Java Tutorial
 * 
 * @author YuCheng
 *
 */
class FreshJuice {
	enum FreshJuiceSize {
		SMALL, MEDIUM, LARGE
	}

	FreshJuiceSize size;
}

public class FreshJuiceEnums {
	public static void main(String[] args) {
		FreshJuice juice = new FreshJuice();
		juice.size = FreshJuice.FreshJuiceSize.MEDIUM;
	}
}