package com.patterns.command.commands;

/**
 * Abstract class representing a generic command in the Command design pattern.
 * The {@code Command} class defines a contract for actions that can be executed
 * and subsequently undone, allowing for flexible management of operations.
 *
 * <p>
 * Concrete subclasses should implement the {@code execute()} method to perform
 * a specific action, and the {@code undo()} method to revert that action, if
 * possible. This setup is particularly useful in scenarios requiring command
 * history, redo/undo operations, or deferred execution.
 * </p>
 *
 * @see #execute()
 * @see #undo()
 * @author Luan Nadaletti
 * @since 1.0
 */
public abstract class Command {

	/**
	 * Executes the main action of the command. This method is intended to be
	 * overridden by concrete subclasses to implement specific behavior.
	 */
	abstract void execute();

	/**
	 * Reverts the action performed by {@code execute()}. This method should be
	 * overridden to undo the command's effects.
	 */
	abstract void undo();
}
