package com.ossez.chararraypassword;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Java Password by using String or Char array
 * <p>
 * <p><a href="https://www.ossez.com/t/java-char-array-string/14015">https://www.ossez.com/t/java-char-array-string/14015</a></p>
 */
public class PasswordStoreExamplesUnitTest {

    String stringPassword = "password";
    char[] charPassword = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

    @Test
    public void givenStringHashCode_WhenStringValueChanged_ThenHashCodesNotEqualAndValesNotEqual() {
        String originalHashCode = Integer.toHexString(stringPassword.hashCode());

        stringPassword = "********";
        String changedHashCode = Integer.toHexString(stringPassword.hashCode());

        assertThat(originalHashCode).isNotEqualTo(changedHashCode);
        assertThat(stringPassword).isNotEqualTo("password");
    }

    @Test
    public void givenStringHashCode_WhenStringValueChangedAndStringValueReassigned_ThenHashCodesEqualAndValesEqual() {
        String originalHashCode = Integer.toHexString(stringPassword.hashCode());

        stringPassword = "********";
        stringPassword = "password";
        String reassignedHashCode = Integer.toHexString(stringPassword.hashCode());

        assertThat(originalHashCode).isEqualTo(reassignedHashCode);
        assertThat(stringPassword).isEqualTo("password");
    }

    @Test
    public void givenStringHashCode_WhenStringValueReplaced_ThenHashCodesEqualAndValesEqual() {
        String originalHashCode = Integer.toHexString(stringPassword.hashCode());

        String newString = "********";
        stringPassword.replace(stringPassword, newString);

        String hashCodeAfterReplace = Integer.toHexString(stringPassword.hashCode());

        assertThat(originalHashCode).isEqualTo(hashCodeAfterReplace);
        assertThat(stringPassword).isEqualTo("password");
    }

    @Test
    public void givenCharArrayHashCode_WhenArrayElementsValueChanged_ThenHashCodesEqualAndValesNotEqual() {
        String originalHashCode = Integer.toHexString(charPassword.hashCode());

        Arrays.fill(charPassword, '*');
        String changedHashCode = Integer.toHexString(charPassword.hashCode());

        assertThat(originalHashCode).isEqualTo(changedHashCode);
        assertThat(charPassword).isNotEqualTo(new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'});
    }

    @Test
    public void whenCallingToStringOfString_ThenValuesEqual() {
        assertThat(stringPassword.toString()).isEqualTo("password");
    }

    @Test
    public void whenCallingToStringOfCharArray_ThenValuesNotEqual() {
        assertThat(charPassword.toString()).isNotEqualTo("password");
    }

    @Test
    public void immutableForString() {
        String stringPassword = "password";
        System.out.print("Original String password value: ");
        System.out.println(stringPassword);
        System.out.println("Original String password hashCode: " + Integer.toHexString(stringPassword.hashCode()));

        String newString = "********";
        stringPassword.replace(stringPassword, newString);

        System.out.print("String password value after trying to replace it: ");
        System.out.println(stringPassword);
        System.out.println("hashCode after trying to replace the original String: " + Integer.toHexString(stringPassword.hashCode()));
    }

    @Test
    public void immutableForCharArray() {
        char[] charPassword = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

        System.out.print("Original char password value: ");
        System.out.println(charPassword);
        System.out.println("Original char password hashCode: " + Integer.toHexString(charPassword.hashCode()));

        Arrays.fill(charPassword, '*');

        System.out.print("Changed char password value: ");
        System.out.println(charPassword);
        System.out.println("Changed char password hashCode: " + Integer.toHexString(charPassword.hashCode()));
    }

    @Test
    public void accidentallyPassword_print() {
        String passwordString = "password";
        char[] passwordArray = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        System.out.println("Printing String password -> " + passwordString);
        System.out.println("Printing char[] password -> " + passwordArray.toString());
    }
}
