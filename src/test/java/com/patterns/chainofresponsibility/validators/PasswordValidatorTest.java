package com.patterns.chainofresponsibility.validators;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.patterns.chainofresponsibility.contexts.ValidatorContext;
import com.patterns.chainofresponsibility.server.Server;

public class PasswordValidatorTest {

    PasswordValidator passwordValidator;
    Server server;
    ValidatorContext validatorContext;

    @BeforeEach
    void setUp() {
        server = new Server();
        passwordValidator = new PasswordValidator(server);

        server.register("admin", "admin");

        validatorContext = new ValidatorContext();
        validatorContext.addParameter("username", "admin");
        validatorContext.addParameter("password", "admin");
    }

    @Test
    void testValidPassword() {
        assertTrue(passwordValidator.check(validatorContext));
    }
}
