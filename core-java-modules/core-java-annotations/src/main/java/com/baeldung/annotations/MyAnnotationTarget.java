package com.ossez.annotations;

class MyAnnotationTarget {

    // this is OK
    @MyAnnotation
    String someField;

    // @MyAnnotation <- this is invalid usage!
    void doSomething() {

        // this also works
        @MyAnnotation
        String localVariable;
    }
}
