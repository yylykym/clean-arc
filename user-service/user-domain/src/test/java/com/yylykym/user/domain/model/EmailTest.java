package com.yylykym.user.domain.model;

import com.yylykym.user.domain.exception.InvalidEmailException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class EmailTest {
    @Test
    void validEmail_shouldCreateSuccessfully() {
        Email email = new Email("a@b.com");
        assertThat(email.value()).isEqualTo("a@b.com");
    }

    @Test
    void nullOrBlankEmail_shouldThrowException() {
        assertThatThrownBy(() -> new Email(null))
                .isInstanceOf(InvalidEmailException.class);
        assertThatThrownBy(() -> new Email("   "))
                .isInstanceOf(InvalidEmailException.class);
    }

    @Test
    void invalidEmail_shouldThrowException() {
        assertThatThrownBy(() -> new Email("bad-email"))
                .isInstanceOf(InvalidEmailException.class);
    }
}
