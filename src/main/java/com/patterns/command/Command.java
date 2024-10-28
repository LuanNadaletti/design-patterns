package com.patterns.command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.patterns.command.commands.AddTextCommand;
import com.patterns.command.commands.CommandInvoker;

/**
 * The {@code Command} class provides a simple graphical user interface (GUI)
 * for demonstrating the Command design pattern. Users can execute and undo
 * commands that modify text within a {@link JTextArea}.
 *
 * <p>
 * This application features three main buttons:
 * </p>
 * <ul>
 * <li>"Adicionar 'Hello'": Appends the word "Hello" to the text area.</li>
 * <li>"Adicionar 'World!'": Appends the word "World!" to the text area.</li>
 * <li>"Desfazer Última Ação": Undoes the most recent command performed,
 * removing the last text addition.</li>
 * </ul>
 *
 * <p>
 * The {@link CommandInvoker} is used to manage the history of commands,
 * enabling undo functionality. Each command is an instance of
 * {@link com.patterns.command.commands.Command}, implemented as
 * {@link AddTextCommand} to perform the text modifications.
 * </p>
 *
 * @see com.patterns.command.commands.Command
 * @see CommandInvoker
 * @see AddTextCommand
 * @since 1.0
 */
public class Command {

	/**
	 * The main method initializes the GUI and sets up the commands and buttons.
	 *
	 * @param args the command-line arguments (not used)
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Padrão Command com Histórico de Comandos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 300);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(420, 240));

		CommandInvoker invoker = new CommandInvoker();

		com.patterns.command.commands.Command addHelloCommand = new AddTextCommand(textArea, "Hello ");
		com.patterns.command.commands.Command addWorldCommand = new AddTextCommand(textArea, "World! ");

		JButton addHelloButton = new JButton("Adicionar 'Hello'");
		addHelloButton.addActionListener(e -> invoker.executeCommand(addHelloCommand));

		JButton addWorldButton = new JButton("Adicionar 'World!'");
		addWorldButton.addActionListener(e -> invoker.executeCommand(addWorldCommand));

		JButton undoButton = new JButton("Desfazer Última Ação");
		undoButton.addActionListener(e -> invoker.undoLastCommand());

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(addHelloButton);
		panel.add(addWorldButton);
		panel.add(undoButton);

		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		frame.setVisible(true);
	}
}
