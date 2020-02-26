package com.ossez.annotations;


public class ClassWithDeprecatedMethod {

    /**
     * Calculate period between versions
     * * @deprecated
     * * This method is no longer acceptable to compute time between versions.
     * * <p> Use {@link ClassWithDeprecatedMethod#updatedMethod()} instead.
     */
    @Deprecated
    public static void deprecatedMethod() {

    }

    /**
     * Updated Method instead of deprecatedMethod.
     */
    public static void updatedMethod() {
    }

}
