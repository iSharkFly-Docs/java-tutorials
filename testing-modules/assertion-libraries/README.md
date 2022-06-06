## 测试断言（Assert）
断言（Assertion）是一种调试程序的方式，很多开发语言中都支持这种机制。

在实现中，assertion 就是在程序中的一条语句，它对一个 boolean 表达式进行检查，一个正确程序必须保证这个 boolean表达式的值为true；如果该值为 false，说明程序已经处于不正确的状态下，assert 将给出警告或退出。

在 Java中，使用 assert 关键字来实现断言。 语句 assert x >= 0; 即为断言，断言条件 x >= 0 预期为 true 。

如果计算结果为 false ，则断言失败，抛出 AssertionError。

### 相关文章

- [AssertJ’s Java 8 Features](http://www.baeldung.com/assertJ-java-8-features)
- [AssertJ for Guava](http://www.baeldung.com/assertJ-for-guava)
- [Introduction to AssertJ](http://www.baeldung.com/introduction-to-assertj)
- [Testing with Google Truth](http://www.baeldung.com/google-truth)
- [Testing with JGoTesting](http://www.baeldung.com/jgotesting)
- [Guide to JSpec](http://www.baeldung.com/jspec)
- [Custom Assertions with AssertJ](http://www.baeldung.com/assertj-custom-assertion)
- [Using Conditions with AssertJ Assertions](http://www.baeldung.com/assertj-conditions)
- [AssertJ Exception Assertions](http://www.baeldung.com/assertj-exception-assertion)
