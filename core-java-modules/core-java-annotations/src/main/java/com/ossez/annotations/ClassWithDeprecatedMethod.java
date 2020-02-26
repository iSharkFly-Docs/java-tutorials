package com.ossez.annotations;


class ClassWithDeprecatedMethod {

    /**
     * Calculate period between versions
     * * @deprecated
     * * This method is no longer acceptable to compute time between versions.
     * * <p> Use {@link ClassWithDeprecatedMethod#updatedMethod()} instead.
     */
    @Deprecated
    static void deprecatedMethod() {

    }

    /**
     * Updated Method instead of deprecatedMethod.
     */
    static void updatedMethod() {
    }

}
