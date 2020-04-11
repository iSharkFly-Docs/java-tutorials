**UPDATE**: The price of "Learn Spring Security OAuth" will permanently change on the 11th of December, along with the upcoming OAuth2 material: http://bit.ly/github-lss

The Courses
==============================


Here's the new "Learn Spring" course: <br/>
**[>> LEARN SPRING - THE MASTER CLASS](https://www.baeldung.com/learn-spring-course?utm_source=github&utm_medium=social&utm_content=tutorials&utm_campaign=ls#master-class)**

Here's the Master Class of "REST With Spring" (along with the new announced Boot 2 material): <br/>
**[>> THE REST WITH SPRING - MASTER CLASS](https://www.baeldung.com/rest-with-spring-course?utm_source=github&utm_medium=social&utm_content=tutorials&utm_campaign=rws#master-class)**

And here's the Master Class of "Learn Spring Security": <br/>
**[>> LEARN SPRING SECURITY - MASTER CLASS](https://www.baeldung.com/learn-spring-security-course?utm_source=github&utm_medium=social&utm_content=tutorials&utm_campaign=lss#master-class)**



Java and Spring Tutorials
================

This project is **a collection of small and focused tutorials** - each covering a single and well defined area of development in the Java ecosystem. 
A strong focus of these is, of course, the Spring Framework - Spring, Spring Boot and Spring Security. 
In additional to Spring, the modules here are covering a number of aspects in Java. 


构建（build）项目
====================
如果你希望运行一个完整的构建（build），请运行命令：`mvn clean install`


构建（Building）一个单独模块（module） 
====================
如果你希望构建一个特定的模块（module）的话，请在模块目录中运行命令：`mvn clean install`


运行一个 Spring Boot 模块
====================
如果你希望运行一个 Spring Boot 模块（module）请在模块目录中（module directory）运行命令: `mvn spring-boot:run` 


与 IDE 协同进行工作
====================
本仓库中包含有大量的模块。 
When you're working with an individual module, there's no need to import all of them (or build all of them) - you can simply import that particular module in either Eclipse or IntelliJ. 


运行测试
=============
运行 `mvn clean install` 将会在模块中运行单元测试（unit tests）。
如果你希望运行整合测试（integration tests），请使用命令 `mvn clean install -Pintegration-lite-first`




