package com.ossez.interview;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * Java toString null Check
 *
 * <p><a href="https://www.ossez.com/t/java-tostring/14000">https://www.ossez.com/t/java-tostring/14000</a></p>
 *
 * @author YuCheng Hu
 */
public class StringNullCheckUnitTest {
    @Test
    public void toString_null_safe() {
        String obj = null;

        ObjectUtils.toString(obj, StringUtils.EMPTY);
        ObjectUtils.toString(obj, () -> StringUtils.EMPTY);
        assertThat("null").isEqualTo(Objects.toString(obj));
        assertThat("").isEqualTo(Objects.toString(obj, StringUtils.EMPTY));

        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
            obj.toString();
        });

    }
}
