package com.patterns.command.commands;

import javax.swing.JTextArea;

/**
 * The {@code AddTextCommand} class is a concrete implementation of the
 * {@link Command} abstract class. It represents an operation that appends a
 * specific string to a {@link JTextArea} component and provides a mechanism to
 * undo that action.
 *
 * <p>
 * This class encapsulates the action of adding text to a text area and can be
 * used to implement an undoable command, enabling text changes to be reversed
 * if needed. This is particularly useful in applications that support undo/redo
 * functionality in text editing contexts.
 * </p>
 *
 * @see Command
 * @author Luan Nadaletti
 * @since 1.0
 */
public class AddTextCommand extends Command {

	private JTextArea textArea;
	private String text;

	/**
	 * Constructs a new {@code AddTextCommand} with the specified {@code JTextArea}
	 * and text to append.
	 *
	 * @param textArea the {@link JTextArea} component where the text will be added
	 * @param text     the text to append to the {@code JTextArea}
	 */
	public AddTextCommand(JTextArea textArea, String text) {
		this.textArea = textArea;
		this.text = text;
	}

	/**
	 * Appends the specified text to the {@code JTextArea}.
	 */
	@Override
	public void execute() {
		textArea.append(text);
	}

	/**
	 * Removes the previously appended text from the {@code JTextArea}, effectively
	 * undoing the {@code execute()} operation.
	 */
	@Override
	public void undo() {
		String currentText = textArea.getText();
		textArea.setText(currentText.substring(0, currentText.length() - text.length()));
	}
}
