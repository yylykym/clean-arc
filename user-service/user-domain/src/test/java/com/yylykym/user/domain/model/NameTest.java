package com.yylykym.user.domain.model;

import com.yylykym.user.domain.exception.InvalidNameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {
    @Test
    void validName_shouldCreateSuccessfully() {
        Name name = new Name("张三");
        assertThat(name.value()).isEqualTo("张三");
    }

    @Test
    void blankOrNullName_shouldThrowException() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(InvalidNameException.class);
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(InvalidNameException.class);
    }

    @Test
    void tooLongName_shouldThrowException() {
        String longName = "a".repeat(51);
        assertThatThrownBy(() -> new Name(longName))
                .isInstanceOf(InvalidNameException.class);
    }
}
