package com.patterns.command.commands;

import java.util.Stack;

/**
 * The {@code CommandHistory} class manages a history of {@link Command}
 * objects, allowing for commands to be added, retrieved, and removed in a
 * Last-In-First-Out (LIFO) order. This class is particularly useful in
 * implementations where undo/redo functionality is required, enabling easy
 * access to the last executed command.
 *
 * <p>
 * This class leverages a {@link Stack} to store the command history. Each time
 * a command is executed, it should be added to the history using the
 * {@code push} method. When an undo operation is needed, the {@code pop} method
 * can retrieve and remove the last executed command.
 * </p>
 *
 * @see Command
 * @author Luan Nadaletti
 * @since 1.0
 */
public class CommandHistory {

	private Stack<Command> history = new Stack<>();

	/**
	 * Adds a {@link Command} to the command history.
	 *
	 * @param command the command to be added to the history
	 */
	public void push(Command command) {
		history.push(command);
	}

	/**
	 * Removes and returns the last {@link Command} from the history, typically used
	 * to undo the last action.
	 *
	 * @return the last command in the history
	 * @throws java.util.EmptyStackException if the history is empty
	 */
	public Command pop() {
		return history.pop();
	}

	/**
	 * Checks if the command history is empty.
	 *
	 * @return {@code true} if there are no commands in the history, {@code false}
	 *         otherwise
	 */
	public boolean isEmpty() {
		return history.isEmpty();
	}
}
