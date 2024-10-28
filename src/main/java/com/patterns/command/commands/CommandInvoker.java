package com.patterns.command.commands;

/**
 * The {@code CommandInvoker} class is responsible for executing commands and
 * managing the command history to enable undo functionality. It works as an
 * interface for triggering commands while tracking them for potential reversal.
 *
 * <p>
 * Each command executed through the {@code executeCommand} method is stored in
 * the {@link CommandHistory} object. The {@code undoLastCommand} method allows
 * for the most recent command to be undone by retrieving it from history and
 * calling its {@code undo()} method.
 * </p>
 *
 * <p>
 * This class is often used in applications that support redo/undo capabilities,
 * as it keeps track of executed commands in order to allow for sequential
 * undos.
 * </p>
 *
 * @see Command
 * @see CommandHistory
 * @author Luan Nadaletti
 * @since 1.0
 */
public class CommandInvoker {

	private CommandHistory history = new CommandHistory();

	/**
	 * Executes the specified command and stores it in the history.
	 *
	 * @param command the command to be executed and tracked
	 */
	public void executeCommand(Command command) {
		command.execute();
		history.push(command);
	}

	/**
	 * Undoes the most recently executed command by retrieving it from the history
	 * and invoking its {@code undo()} method. If no commands exist in the history,
	 * this method does nothing.
	 */
	public void undoLastCommand() {
		if (history.isEmpty()) {
			return;
		}

		Command lastCommand = history.pop();
		lastCommand.undo();
	}
}
