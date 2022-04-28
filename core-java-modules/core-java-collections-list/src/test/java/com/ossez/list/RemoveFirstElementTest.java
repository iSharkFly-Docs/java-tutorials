package com.ossez.list;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test for remove list
 *
 * <p><a href="https://www.ossez.com/t/java-list/13919">https://www.ossez.com/t/java-list/13919</a></p>
 *
 * @author YuCheng
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RemoveFirstElementTest {
    private final static Logger logger = LoggerFactory.getLogger(RemoveFirstElementTest.class);


    private ArrayList<String> list = new ArrayList();
    private LinkedList<String> linkedList = new LinkedList<>();


    @BeforeAll
    public void startup() {
        list.add("cat");
        list.add("dog");
        list.add("pig");
        list.add("cow");
        list.add("goat");

        linkedList.add("cat");
        linkedList.add("dog");
        linkedList.add("pig");
        linkedList.add("cow");
        linkedList.add("goat");
    }

    /**
     * ArrayList remove first
     */
    @Test
    public void testGivenList_whenRemoveFirst_thenRemoved() {
        logger.debug("Get Size of List - [{}]", list.size());

        list.remove(0);

        assertThat(list, hasSize(4));
        assertThat(list, not(contains("cat")));
    }

    /**
     * LinkedList remove first
     */
    @Test
    public void testGivenLinkedList_whenRemoveFirst_thenRemoved() {

        linkedList.removeFirst();


        assertThat(linkedList, hasSize(4));
        assertThat(linkedList, not(contains("cat")));
    }

}
