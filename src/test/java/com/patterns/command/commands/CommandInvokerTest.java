package com.patterns.command.commands;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandInvokerTest {

	private CommandInvoker invoker;
	private Command mockCommand;

	@BeforeEach
	void setUp() {
		invoker = new CommandInvoker();
		mockCommand = mock();
	}

	@Test
	void testExecuteCommand() {
		invoker.executeCommand(mockCommand);
		verify(mockCommand).execute();
	}

	@Test
	void testUndoLastCommand() {
		invoker.executeCommand(mockCommand);
		invoker.undoLastCommand();

		verify(mockCommand).undo();
	}

	@Test
	void testUndoLastCommandWithNoCommands() {
		invoker.undoLastCommand();

		verify(mockCommand, never()).undo();
	}
}
