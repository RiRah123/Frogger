package com.example.s2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserTest {
    @Test
    public void testUsernameInput() {
        // Test for whitespace only username input
        String whitespaceUsername = "      ";
        assertFalse(isUsernameValid(whitespaceUsername));

        // Test for null username input
        String nullUsername = null;
        assertFalse(isUsernameValid(nullUsername));

        // Test for empty username input
        String emptyUsername = "";
        assertFalse(isUsernameValid(emptyUsername));

        // Test for valid username input
        String validUsername = "johndoe";
        assertTrue(isUsernameValid(validUsername));
    }

    public static boolean isUsernameValid(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
