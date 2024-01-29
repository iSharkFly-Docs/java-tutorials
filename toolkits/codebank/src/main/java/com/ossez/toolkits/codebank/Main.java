package com.ossez.toolkits.codebank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main Test Class
 *
 * @author YuCheng Hu
 */

interface TestInterface1 {
    // default method
    default void show() {
        System.out.println("Default TestInterface - 1 ");
    }
}

interface TestInterface2 {
    // Default method
    default void show() {
        System.out.println("Default TestInterface - 2");
    }
}


public class Main implements TestInterface1, TestInterface2 {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        new Main().show();

    }

    @Override
    public void show() {
        TestInterface1.super.show();
        TestInterface2.super.show();
    }
}
