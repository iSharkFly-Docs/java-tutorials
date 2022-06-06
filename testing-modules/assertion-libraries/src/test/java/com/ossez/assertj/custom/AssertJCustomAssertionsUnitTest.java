package com.ossez.assertj.custom;

import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssertJCustomAssertionsUnitTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void whenPersonNameMatches_thenCorrect() {
        Person person = new Person("John Doe", 20);
        Assertions.assertThat(person).hasFullName("John Doe");
    }

    @Test
    public void whenPersonAgeLessThanEighteen_thenNotAdult() {
        Person person = new Person("Jane Roe", 16);

        try {
            Assertions.assertThat(person).isAdult();
            fail();
        } catch (AssertionError e) {
            org.assertj.core.api.Assertions.assertThat(e).hasMessage("Expected person to be adult");
        }
    }

    @Test
    public void whenPersonDoesNotHaveAMatchingNickname_thenIncorrect() {
        Person person = new Person("John Doe", 20);
        person.addNickname("Nick");

        try {
            Assertions.assertThat(person).hasNickname("John");
            fail();
        } catch (AssertionError e) {
            org.assertj.core.api.Assertions.assertThat(e).hasMessage("Expected person to have nickname John");
        }
    }
}
