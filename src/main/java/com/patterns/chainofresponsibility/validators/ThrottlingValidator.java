package com.patterns.chainofresponsibility.validators;

import com.patterns.chainofresponsibility.contexts.ValidatorContext;

/**
 * The {@code ThrottlingValidator} class is a concrete implementation of a
 * validator that performs throttling by limiting the number of requests per
 * minute. It is part of the Chain of Responsibility pattern and can be linked
 * with other validators to form a validation chain.
 *
 * <p>
 * This validator tracks the number of requests and stops the thread if the
 * request limit is exceeded within a specified time frame.
 * </p>
 *
 * <p>
 * <b>Usage:</b>
 * </p>
 *
 * <pre>{@code
 * ThrottlingValidator throttlingValidator = new ThrottlingValidator(requestsPerMinute);
 * // Link with other validators if needed
 *
 * Validator validatorChain = Validator.link(throttlingValidator, /*other validators/*);*}</pre>
 *
 * @author Luan Nadaletti
 */
public class ThrottlingValidator extends Validator {

	private int requestsPerMinute;
	private int requests;
	private long currentTime;

	/**
	 * Constructs a ThrottlingValidator with the specified maximum requests per
	 * minute.
	 *
	 * @param requestsPerMinute The maximum number of requests allowed per minute.
	 */
	public ThrottlingValidator(int requestsPerMinute) {
		this.requestsPerMinute = requestsPerMinute;
		this.currentTime = System.currentTimeMillis();
	}

	/**
	 * Checks the number of requests made within the time window and stops the
	 * thread if the limit is exceeded.
	 *
	 * @param validatorContext The context containing parameters for validation.
	 * @return {@code true} if the number of requests is within the limit and the
	 *         next validator (if any) passes, {@code false} otherwise.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public boolean check(ValidatorContext validatorContext) {
		if (System.currentTimeMillis() > currentTime + 60_000) {
			requests = 0;
			currentTime = System.currentTimeMillis();
		}

		requests++;

		if (requests > requestsPerMinute) {
			System.out.println("Request limit exceeded!");
			Thread.currentThread().stop();
		}

		return checkNext(validatorContext);
	}
}
