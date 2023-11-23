package com.patterns.chainofresponsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.patterns.chainofresponsibility.contexts.ValidatorContext;
import com.patterns.chainofresponsibility.server.Server;
import com.patterns.chainofresponsibility.validators.PasswordValidator;
import com.patterns.chainofresponsibility.validators.ThrottlingValidator;
import com.patterns.chainofresponsibility.validators.UsernameValidator;
import com.patterns.chainofresponsibility.validators.Validator;

/**
 * The {@code ChainOfResponsibility} class demonstrates the Chain of
 * Responsibility pattern for user authentication. It initializes a
 * {@link com.patterns.chainofresponsibility.server.Server} with various
 * validators, including throttling, username validation, and password
 * validation, linked together in a chain. It prompts the user to enter a
 * username and password until a successful login is achieved.
 *
 * @author Luan Nadaletti
 */
public class ChainOfResponsibility {

	private static Server server;
	private static ValidatorContext context;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * The main method that initializes the server and performs user authentication.
	 *
	 * @param args Command-line arguments (not used in this application).
	 * @throws IOException If an I/O error occurs while reading user input.
	 */
	public static void main(String[] args) throws IOException {
		init();

		boolean loggedIn = false;

		do {
			System.out.println("Enter the username: ");
			context.addParameter("username", br.readLine());

			System.out.println("Enter the password: ");
			context.addParameter("password", br.readLine());

			loggedIn = server.logIn(context);
		} while (!loggedIn);

		System.out.println("Logged in!");
	}

	/**
	 * Initializes the server, registers users, creates a validation middleware
	 * chain, and sets up the context for validation.
	 */
	private static void init() {
		server = new Server();
		server.register("admin", "admin");
		server.register("user", "user");

		Validator middleware = Validator.link(new ThrottlingValidator(2), new UsernameValidator(server),
				new PasswordValidator(server));

		server.setMiddleWare(middleware);

		context = new ValidatorContext();
	}
}
