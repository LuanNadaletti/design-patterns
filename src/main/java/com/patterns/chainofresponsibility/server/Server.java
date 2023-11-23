package com.patterns.chainofresponsibility.server;

import java.util.HashMap;
import java.util.Map;

import com.patterns.chainofresponsibility.contexts.ValidatorContext;
import com.patterns.chainofresponsibility.validators.Validator;

/**
 * The {@code Server} class represents a server with authentication
 * functionality using the Chain of Responsibility pattern. It manages user
 * registration, login, and employs a middleware for validation.
 *
 * <p>
 * Users are stored in a {@link java.util.HashMap}, and the authentication
 * process is facilitated by a
 * {@link com.patterns.chainofresponsibility.validators.Validator} middleware.
 * </p>
 *
 * @author Luan Nadaletti
 */
public class Server {

    private Map<String, String> users = new HashMap<>();
    private Validator middleware;

    /**
     * Attempts to log in a user based on the provided validation context.
     *
     * @param validatorContext The validation context containing user credentials.
     * @return {@code true} if the login is successful, {@code false} otherwise.
     */
    public boolean logIn(ValidatorContext validatorContext) {
        return middleware.check(validatorContext);
    }

    /**
     * Registers a new user with the specified username and password.
     *
     * @param username The username of the new user.
     * @param password The password of the new user.
     */
    public void register(String username, String password) {
        users.put(username, password);
    }

    /**
     * Checks if a username exists in the user database.
     *
     * @param username The username to check.
     * @return {@code true} if the username exists, {@code false} otherwise.
     */
    public boolean hasUsername(String username) {
        return users.containsKey(username);
    }

    /**
     * Validates if the provided password matches the stored password for a given
     * username.
     *
     * @param username The username for which to validate the password.
     * @param password The password to validate.
     * @return {@code true} if the password is valid, {@code false} otherwise.
     */
    public boolean isValidPassword(String username, String password) {
        return users.get(username).equals(password);
    }

    /**
     * Sets the middleware for validation during login.
     *
     * @param middleware The middleware to set.
     */
    public void setMiddleWare(Validator middleware) {
        this.middleware = middleware;
    }
}
