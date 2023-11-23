package com.patterns.chainofresponsibility.validators;

import com.patterns.chainofresponsibility.contexts.ValidatorContext;

/**
 * The {@code Validator} class is an abstract class representing a link in the
 * chain of responsibility for validation. Subclasses are expected to implement
 * the validation logic in the {@link #check(ValidatorContext)} method.
 *
 * <p>
 * Validators can be linked together to form a chain using the
 * {@link #link(Validator, Validator...)} method.
 * </p>
 *
 * <p>
 * <b>Usage:</b>
 * </p>
 *
 * <pre>{@code
 * Validator validatorChain = Validator.link(new ConcreteValidator1(), new ConcreteValidator2(),
 *         new ConcreteValidator3());
 * }</pre>
 *
 * @author Luan Nadaletti
 */
public abstract class Validator {

    private Validator next;

    /**
     * Links multiple validators together to form a chain.
     *
     * @param first The first validator in the chain.
     * @param chain The subsequent validators in the chain.
     * @return The head of the validator chain.
     */
    public static Validator link(Validator first, Validator... chain) {
        Validator head = first;

        for (Validator nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }

        return first;
    }

    /**
     * Performs the validation logic for this validator. Subclasses must implement
     * this method.
     *
     * @param validatorContext The context containing parameters for validation.
     * @return {@code true} if the validation passes, {@code false} otherwise.
     */
    public abstract boolean check(ValidatorContext validatorContext);

    /**
     * Checks the next validator in the chain. If there is no next validator,
     * returns true.
     *
     * @param validatorContext The context containing parameters for validation.
     * @return {@code true} if the next validator (if any) passes, {@code false} if
     *         there is no next validator.
     */
    protected boolean checkNext(ValidatorContext validatorContext) {
        if (next == null) {
            return true;
        }

        return next.check(validatorContext);
    }
}
