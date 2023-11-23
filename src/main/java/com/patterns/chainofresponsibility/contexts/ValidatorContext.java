package com.patterns.chainofresponsibility.contexts;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code ValidatorContext} class represents a context for validating
 * parameters using the Chain of Responsibility pattern. It allows adding and
 * retrieving parameters in the form of key-value pairs.
 *
 * <p>
 * This class uses a {@link java.util.HashMap} to store parameters, providing a
 * simple and flexible way to manage the context.
 * </p>
 *
 * <p>
 * <b>Usage:</b>
 * </p>
 *
 * <pre>{@code
 * ValidatorContext validatorContext = new ValidatorContext();
 * validatorContext.addParameter("paramName", paramValue);
 * Object retrievedValue = validatorContext.getParameter("paramName");
 * }</pre>
 *
 * @author Luan Nadaletti
 */
public class ValidatorContext {

    private Map<String, Object> context = new HashMap<>();

    /**
     * Adds a parameter to the context.
     *
     * @param name  The name of the parameter.
     * @param value The value of the parameter.
     */
    public void addParameter(String name, Object value) {
        context.put(name, value);
    }

    /**
     * Retrieves the value of a parameter from the context.
     *
     * @param name The name of the parameter to retrieve.
     * @return The value associated with the specified parameter name, or
     *         {@code null} if the parameter is not found.
     */
    public Object getParameter(String name) {
        return context.get(name);
    }
}
