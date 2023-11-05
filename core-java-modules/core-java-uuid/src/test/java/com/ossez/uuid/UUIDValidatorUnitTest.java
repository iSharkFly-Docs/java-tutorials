package com.ossez.uuid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UUIDValidatorUnitTest {

    @Test
    public void whenValidUUIDStringIsValidated_thenValidationSucceeds() {
        String validUUID = "26929514-237c-11ed-861d-0242ac120002";
        Assertions.assertEquals(UUID.fromString(validUUID).toString(), validUUID);
        assertThat(UUID.fromString(validUUID).toString()).isEqualTo(validUUID);

        String invalidUUID = "invalid-uuid";
        Assertions.assertThrows(IllegalArgumentException.class, () -> UUID.fromString(invalidUUID));
        assertThatThrownBy(() -> {
            UUID.fromString(invalidUUID);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void whenUUIDIsValidatedUsingRegex_thenValidationSucceeds() {
        Pattern UUID_REGEX = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

        Assertions.assertTrue(UUID_REGEX.matcher("26929514-237c-11ed-861d-0242ac120002").matches());

        Assertions.assertFalse(UUID_REGEX.matcher("invalid-uuid").matches());
    }
}
