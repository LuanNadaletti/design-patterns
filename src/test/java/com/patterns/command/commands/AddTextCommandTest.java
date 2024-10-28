package com.patterns.command.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.JTextArea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTextCommandTest {

	private JTextArea textArea;
	private AddTextCommand command;

	@BeforeEach
	void setUp() {
		textArea = new JTextArea();
		command = new AddTextCommand(textArea, "Hello");
	}

	@Test
	void textExecute() {
		command.execute();

		assertEquals("Hello", textArea.getText(), "The text should be appended to JTextArea");
	}

    @Test
    void testUndo() {
    	command.execute();
    	command.undo();

        assertEquals("", textArea.getText(), "The appended text should be removed from JTextArea");
    }
}
