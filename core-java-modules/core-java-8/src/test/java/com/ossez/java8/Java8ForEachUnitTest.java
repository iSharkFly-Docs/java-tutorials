package com.ossez.java8;

import java.util.*;
import java.util.function.Consumer;


import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Java8ForEachUnitTest {

    private static final Logger logger = LoggerFactory.getLogger(Java8ForEachUnitTest.class);

    @Test
    public void compareForEachMethods_thenPrintResults() {

        List<String> names = new ArrayList<>();
        names.add("Larry");
        names.add("Steve");
        names.add("James");
        names.add("Conan");
        names.add("Ellen");

        // Java 5 - for-loop
        logger.debug("--- Enhanced for-loop ---");
        for (String name : names) {
            logger.debug(name);
        }

        // Java 8 - forEach
        names.forEach(name -> {
            System.out.println(name);
        });

        logger.debug("--- Print Consumer ---");
        Consumer<String> printConsumer = new Consumer<String>() {
            public void accept(String name) {
                System.out.println(name);
            }

            ;
        };

        names.forEach(printConsumer);

        // Anonymous inner class that implements Consumer interface
        logger.debug("--- Anonymous inner class ---");
        names.forEach(new Consumer<String>() {
            public void accept(String name) {
                logger.debug(name);
            }
        });

        // Java 8 - forEach - Lambda Syntax
        logger.debug("--- forEach method ---");
        names.forEach(name -> logger.debug(name));

        // Java 8 - forEach - Print elements using a Method Reference
        logger.debug("--- Method Reference ---");
        names.forEach(logger::debug);
    }

    @Test
    public void givenList_thenIterateAndPrintResults() {
        List<String> names = Arrays.asList("Larry", "Steve", "James");

        names.forEach(System.out::println);
    }

    @Test
    public void givenSet_thenIterateAndPrintResults() {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList("Larry", "Steve", "James"));

        uniqueNames.forEach(System.out::println);
    }

    @Test
    public void givenQueue_thenIterateAndPrintResults() {
        Queue<String> namesQueue = new ArrayDeque<>(Arrays.asList("Larry", "Steve", "James"));

        namesQueue.forEach(System.out::println);
    }

    @Test
    public void givenMap_thenIterateAndPrintResults() {
        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "Larry");
        namesMap.put(2, "Steve");
        namesMap.put(3, "James");

        namesMap.entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    @Test
    public void givenMap_whenUsingBiConsumer_thenIterateAndPrintResults2() {
        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "Larry");
        namesMap.put(2, "Steve");
        namesMap.put(3, "James");

        namesMap.forEach((key, value) -> System.out.println(key + " " + value));
    }

    @Test
    public void testIteratorAndFor() {
        List<String> testList = Arrays.asList("A", "B", "C");

        Iterator iterator = testList.iterator();
        while (iterator.hasNext()) {
            logger.debug((String) iterator.next());

        }
        
        logger.debug("--- FOR ---");
        for (int i = 0; i < testList.size(); i++) {
            logger.debug("{} > {}", i, testList.get(i));
        }

        logger.debug("--- FOR LOOP ---");
        for (String s : testList) {
            logger.debug(s);
        }

        logger.debug("--- FOR EACH ---");
        testList.forEach(s -> {
            logger.debug(s);
        });
    }

}
