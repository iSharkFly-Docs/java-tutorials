package com.ossez.java8;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

/**
 * Test for list Clean up
 *
 * <p><a href="https://www.ossez.com/t/java-list/13942">https://www.ossez.com/t/java-list/13942</a></p>
 *
 * @author YuCheng
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Java8CollectionCleanupUnitTest {

    // tests -

    @Test
    public void givenListContainsNulls_whenFilteringParallel_thenCorrect() {
        final List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
        final List<Integer> listWithoutNulls = list.parallelStream().filter(Objects::nonNull).collect(Collectors.toList());

        assertThat(listWithoutNulls, hasSize(3));
    }

    @Test
    public void givenListContainsNulls_whenFilteringSerial_thenCorrect() {
        final List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
        final List<Integer> listWithoutNulls = list.stream().filter(Objects::nonNull).collect(Collectors.toList());

        assertThat(listWithoutNulls, hasSize(3));
    }

    @Test
    public void givenListContainsNulls_whenRemovingNullsWithRemoveIf_thenCorrect() {
        final List<Integer> listWithoutNulls = Lists.newArrayList(null, 1, 2, null, 3, null);
        listWithoutNulls.removeIf(Objects::isNull);

        assertThat(listWithoutNulls, hasSize(3));
    }

    @Test
    public void givenListContainsDuplicates_whenRemovingDuplicatesWithJava8_thenCorrect() {
        final List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);
        final List<Integer> listWithoutDuplicates = listWithDuplicates.stream().distinct().collect(Collectors.toList());

        assertThat(listWithoutDuplicates, hasSize(5));
        assertThat(listWithoutDuplicates, containsInAnyOrder(5, 0, 3, 1, 2));
    }

}
