package com.kbtg.bootcamp.posttest.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("0123456789", "user");
    }

    @Test
    public void testCreateUser() {
        // Arrange
        String userId = "1234567890";
        String username = "testuser";

        // Act
        User user = new User(userId, username);

        // Assert
        assertNotNull(user);
        assertEquals(userId, user.getId());
        assertEquals(username, user.getUsername());
    }

    @Test
    public void testSetUsername() {
        // Arrange
        User user = new User("1234567890", "oldusername");

        // Act
        user.setUsername("newusername");

        // Assert
        assertEquals("newusername", user.getUsername());
    }

    @Test
    public void testGetId() {
        // Assert
        assertEquals("0123456789", user.getId());
    }

    @Test
    public void testGetUsername() {
        // Assert
        assertEquals("user", user.getUsername());
    }

    @Test
    public void testEmptyConstructor() {
        // Act
        User user = new User();

        // Assert
        assertNotNull(user);
    }

}