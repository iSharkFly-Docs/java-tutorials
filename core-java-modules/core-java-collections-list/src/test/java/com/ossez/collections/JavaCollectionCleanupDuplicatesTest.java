package com.ossez.collections;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.PredicateUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test for list Clean up
 *
 * <p><a href="https://www.ossez.com/t/java-list/13942">https://www.ossez.com/t/java-list/13942</a></p>
 *
 * @author YuCheng
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JavaCollectionCleanupDuplicatesTest {

    // TESTS - REMOVE DUPLICATES

    @Test
    public void givenListContainsDuplicates_whenRemovingDuplicatesWithPlainJava_thenCorrect() {
        final List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);
        final List<Integer> listWithoutDuplicates = new ArrayList<>(new HashSet<>(listWithDuplicates));

        assertThat(listWithoutDuplicates, hasSize(5));
        assertThat(listWithoutDuplicates, containsInAnyOrder(5, 0, 3, 1, 2));
    }

    @Test
    public void givenListContainsDuplicates_whenRemovingDuplicatesPreservingOrderWithPlainJava_thenCorrect() {
        final List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);
        final List<Integer> listWithoutDuplicates = new ArrayList<>(new LinkedHashSet<>(listWithDuplicates));

        assertThat(listWithoutDuplicates, hasSize(5));
        assertThat(listWithoutDuplicates, containsInRelativeOrder(5, 0, 3, 1, 2));
    }

    @Test
    public void givenListContainsDuplicates_whenRemovingDuplicatesWithGuava_thenCorrect() {
        final List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);
        final List<Integer> listWithoutDuplicates = Lists.newArrayList(Sets.newHashSet(listWithDuplicates));

        assertThat(listWithoutDuplicates, hasSize(5));
        assertThat(listWithoutDuplicates, containsInAnyOrder(5, 0, 3, 1, 2));
    }

    @Test
    public void givenListContainsDuplicates_whenRemovingDuplicatesPreservingOrderWithGuava_thenCorrect() {
        final List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);
        final List<Integer> listWithoutDuplicates = Lists.newArrayList(Sets.newLinkedHashSet(listWithDuplicates));

        assertThat(listWithoutDuplicates, hasSize(5));
        assertThat(listWithoutDuplicates, containsInRelativeOrder(5, 0, 3, 1, 2));
    }
}
