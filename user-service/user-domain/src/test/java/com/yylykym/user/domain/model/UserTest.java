package com.yylykym.user.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserTest {

    @Test
    void createUser_success() {
        UserId id = new UserId("1");
        Email email = new Email("a@b.com");
        Name name = new Name("张三");
        PasswordHash password = new PasswordHash("hash123");

        User user = new User(id, email, name, password);

        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPassword()).isEqualTo(password);
    }

    @Test
    void nullFields_shouldThrowException() {
        Email email = new Email("a@b.com");
        Name name = new Name("张三");
        PasswordHash password = new PasswordHash("hash123");

        assertThatThrownBy(() -> new User(null, email, name, password))
                .isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> new User(new UserId("1"), null, name, password))
                .isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> new User(new UserId("1"), email, null, password))
                .isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> new User(new UserId("1"), email, name, null))
                .isInstanceOf(NullPointerException.class);
    }

}
