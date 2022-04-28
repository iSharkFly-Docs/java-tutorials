package com.ossez.list.random;

import com.google.common.collect.Lists;
import com.ossez.list.RemoveFirstElementTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Test for Random remove item in listing
 *
 * <p><a href="https://www.ossez.com/t/java-list/13934">https://www.ossez.com/t/java-list/13934</a></p>
 *
 * @author YuCheng
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RandomListElementUnitTest {
    private final static Logger logger = LoggerFactory.getLogger(RemoveFirstElementTest.class);

    @Test
    public void givenList_whenRandomIndexChosen_shouldReturnARandomElementUsingRandom() {
        List<Integer> givenList = Lists.newArrayList(1, 2, 3);
        Random rand = new Random();

        givenList.get(rand.nextInt(givenList.size()));
    }

    @Test
    public void givenList_whenRandomIndexChosen_shouldReturnARandomElementUsingMathRandom() {
        List<Integer> givenList = Lists.newArrayList(1, 2, 3);

        System.out.println(Math.random());
        givenList.get((int) (Math.random() * givenList.size()));
    }

    @Test
    public void givenList_whenNumberElementsChosen_shouldReturnRandomElementsRepeat() {
        Random rand = new Random();
        List<String> givenList = Lists.newArrayList("one", "two", "three", "four");

        int numberOfElements = 2;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            givenList.get(randomIndex);
        }
    }

    @Test
    public void givenList_whenNumberElementsChosen_shouldReturnRandomElementsNoRepeat() {
        Random rand = new Random();
        List<String> givenList = Lists.newArrayList("one", "two", "three", "four");

        int numberOfElements = 2;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            givenList.get(randomIndex);
            givenList.remove(randomIndex);
        }
    }

    @Test
    public void givenList_whenSeriesLengthChosen_shouldReturnRandomSeries() {
        List<Integer> givenList = Lists.newArrayList(1, 2, 3, 4, 5, 6);

        Collections.shuffle(givenList);

        int randomSeriesLength = 3;

        givenList.subList(0, randomSeriesLength - 1);
    }

    @Test
    public void givenList_whenRandomIndexChosen_shouldReturnElementThreadSafely() {
        List<Integer> givenList = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        int randomIndex = ThreadLocalRandom.current().nextInt(10) % givenList.size();

        givenList.get(randomIndex);
    }

}
