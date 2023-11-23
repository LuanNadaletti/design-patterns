package com.patterns.chainofresponsibility.validators;

import com.patterns.chainofresponsibility.contexts.ValidatorContext;
import com.patterns.chainofresponsibility.server.Server;

/**
 * The {@code PasswordValidator} class is a concrete implementation of a
 * validator that checks the validity of a user's password. It is part of the
 * Chain of Responsibility pattern and can be linked with other validators to
 * form a validation chain.
 *
 * <p>
 * This validator relies on a
 * {@link com.patterns.chainofresponsibility.server.Server} instance to validate
 * the user's password.
 * </p>
 *
 * <p>
 * <b>Usage:</b>
 * </p>
 *
 * <pre>{@code
 * Server server = new Server();
 * PasswordValidator passwordValidator = new PasswordValidator(server);
 * // Link with other validators if needed
 *
 * Validator validatorChain = Validator.link(passwordValidator, /* other validators /*);
 * }</pre>
 *
 * @author Luan Nadaletti
 */
public class PasswordValidator extends Validator {

    private Server server;

    /**
     * Constructs a PasswordValidator with the specified server instance.
     *
     * @param server The server instance used for password validation.
     */
    public PasswordValidator(Server server) {
        this.server = server;
    }

    /**
     * Checks the validity of the user's password using the associated server. If
     * the password is invalid, it prints an error message.
     *
     * @param validatorContext The context containing parameters for validation.
     * @return {@code true} if the password is valid and the next validator (if any)
     *         passes, {@code false} otherwise.
     */
    @Override
    public boolean check(ValidatorContext validatorContext) {
        String username = validatorContext.getParameter("username").toString();
        String password = validatorContext.getParameter("password").toString();

        if (!server.isValidPassword(username, password)) {
            System.out.println("Invalid password!");
            return false;
        }

        return checkNext(validatorContext);
    }
}
