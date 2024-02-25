package com.kbtg.bootcamp.posttest.admin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AdminTest {

    private MockMvc mockMvc;

    private Admin admin;

    @BeforeEach
    public void setUp() {
        admin = new Admin(1,"admin_user", "password");
    }

    @Test
    public void testGetAdminId() {
        // Arrange
        Admin admin = new Admin(1, "oldUser", "password");

        // Act
        int expect = admin.getId();

        // Assert
        assertEquals(expect, 1);
    }

    @Test
    public void testSetUsername() {
        // Arrange
        Admin admin = new Admin(1, "oldUser", "password");

        // Act
        admin.setUsername("newUser");

        // Assert
        assertEquals("newUser", admin.getUsername());
    }

    @Test
    public void testSetPassword() {
        // Arrange
        Admin admin = new Admin(1, "user", "oldPassword");

        // Act
        admin.setPassword("newPassword");

        // Assert
        assertEquals("newPassword", admin.getPassword());
    }

    @Test
    public void testGetUsernameInAdmin() {
        // Act
        String expect = admin.getUsername();

        // Assert
        assertEquals(expect, "admin_user");
    }

    @Test
    public void testGetPasswordInAdmin() {
        // Act
        String expect = admin.getPassword();

        // Assert
        assertEquals(expect, "password");
    }



}