package com.ossez.doublecolon.function;

import com.ossez.doublecolon.Computer;

@FunctionalInterface
public interface ComputerPredicate {

    boolean filter(Computer c);

}
