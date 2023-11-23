package com.patterns.chainofresponsibility.validators;

import com.patterns.chainofresponsibility.contexts.ValidatorContext;
import com.patterns.chainofresponsibility.server.Server;

/**
 * The {@code UsernameValidator} class is a concrete implementation of a
 * validator that checks the existence of a user by username. It is part of the
 * Chain of Responsibility pattern and can be linked with other validators to
 * form a validation chain.
 *
 * <p>
 * This validator relies on a
 * {@link com.patterns.chainofresponsibility.server.Server} instance to check
 * for the existence of a user.
 * </p>
 *
 * <p>
 * <b>Usage:</b>
 * </p>
 *
 * <pre>{@code
 * Server server = new Server();
 * UsernameValidator usernameValidator = new UsernameValidator(server);
 * // Link with other validators if needed
 *
 * Validator validatorChain = Validator.link(usernameValidator, /*other validators/*);*}</pre>
 *
 * @author Luan Nadaletti
 */
public class UsernameValidator extends Validator {

	private Server server;

	/**
	 * Constructs a UsernameValidator with the specified server instance.
	 *
	 * @param server The server instance used for username validation.
	 */
	public UsernameValidator(Server server) {
		this.server = server;
	}

	/**
	 * Checks the existence of a user based on the provided username using the
	 * associated server. If the user is not found, it prints an error message.
	 *
	 * @param validatorContext The context containing parameters for validation.
	 * @return {@code true} if the user exists and the next validator (if any)
	 *         passes, {@code false} otherwise.
	 */
	@Override
	public boolean check(ValidatorContext validatorContext) {
		if (!server.hasUsername(validatorContext.getParameter("username").toString())) {
			System.out.println("User not found!");
			return false;
		}

		return checkNext(validatorContext);
	}
}
