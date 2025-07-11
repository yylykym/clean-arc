package com.yylykym.user.domain.model;

import com.yylykym.user.domain.exception.InvalidPasswordException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PasswordHashTest {
    @Test
    void validHash_shouldCreateSuccessfully() {
        PasswordHash hash = new PasswordHash("somehashvalue123");
        assertThat(hash.value()).isEqualTo("somehashvalue123");
    }

    @Test
    void blankOrNullHash_shouldThrowException() {
        assertThatThrownBy(() -> new PasswordHash(""))
                .isInstanceOf(InvalidPasswordException.class);
        assertThatThrownBy(() -> new PasswordHash(null))
                .isInstanceOf(InvalidPasswordException.class);
    }
}
