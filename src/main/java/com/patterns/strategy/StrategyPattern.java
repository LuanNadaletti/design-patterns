package com.patterns.strategy;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.patterns.strategy.contexts.SortContext;
import com.patterns.strategy.strategies.BubbleSort;

/**
 * The <code>StrategyPattern</code> class is the main entry point to demonstrate
 * the strategy design pattern with sorting algorithms through a Swing GUI.
 *
 * @author Luan Nadaletti
 */
public class StrategyPattern {

    /**
     * The main entry point of the application.
     *
     * @param args Command line arguments. Not used in this application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new SortingFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}

/**
 * The <code>SortingFrame</code> class provides a Swing interface to select,
 * input and execute different sorting strategies.
 */
class SortingFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private final JComboBox<String> algorithmComboBox;
    private final JTextArea inputTextArea;
    private final JTextArea outputTextArea;
    private SortContext sortContext;

    /**
     * Constructs a new SortingFrame with all the necessary GUI components.
     */
    public SortingFrame() {
        setTitle("Sorting App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sortContext = new SortContext();

        algorithmComboBox = new JComboBox<>();
        initializeAlgorithmComboBox();

        inputTextArea = createTextArea(10, 20);
        outputTextArea = createOutputTextArea();

        JButton sortButton = createSortButton();
        JButton randomListButton = createRandomListButton();

        JPanel inputOutputPanel = createInputOutputPanel();
        JPanel algorithmPanel = createAlgorithmPanel();
        JPanel buttonPanel = createButtonPanel(sortButton, randomListButton);

        setLayout(new BorderLayout());
        add(algorithmPanel, BorderLayout.NORTH);
        add(inputOutputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Captures the input numbers from the text area, and converts them into an
     * int array. Displays a dialog if the input contains non-numeric
     * characters.
     *
     * @return an array of integers representing the user input or null if input
     *         is empty or invalid.
     */
    private int[] inputArrayUsingDialog() {
        String inputText = inputTextArea.getText().trim();

        if (!inputText.isEmpty()) {
            String[] inputArray = inputText.split("\\s+");
            int[] array = new int[inputArray.length];

            for (int i = 0; i < inputArray.length; i++) {
                try {
                    array[i] = Integer.parseInt(inputArray[i]);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this,
                            "Invalid input. Please enter valid numbers.");
                    return null;
                }
            }

            return array;
        }

        return null;
    }

    /**
     * Initializes the algorithm selection combo box with the available sorting
     * algorithm options.
     */
    private void initializeAlgorithmComboBox() {
        algorithmComboBox.addItem("Bubble Sort");
        algorithmComboBox.addItem("Insertion Sort");
        algorithmComboBox.addItem("Selection Sort");
        algorithmComboBox.setSelectedItem(BubbleSort.class);
    }

    /**
     * Creates and configures a JTextArea for user input with the specified
     * number of rows and columns.
     *
     * @param rows    The number of rows in the text area.
     * @param columns The number of columns in the text area.
     * @return The configured JTextArea for user input.
     */
    private JTextArea createTextArea(int rows, int columns) {
        JTextArea textArea = new JTextArea(rows, columns);
        textArea.setLineWrap(true);
        return textArea;
    }

    /**
     * Creates and configures a JTextArea for displaying output with a fixed
     * font and size.
     *
     * @return The configured JTextArea for displaying output.
     */
    private JTextArea createOutputTextArea() {
        JTextArea textArea = createTextArea(10, 20);
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        return textArea;
    }

    /**
     * Creates a JButton for initiating the sorting process and adds an
     * ActionListener to it.
     *
     * @return The configured JButton for sorting.
     */
    private JButton createSortButton() {
        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener(e -> {
            String selectedSort = (String) algorithmComboBox.getSelectedItem();

            int[] array = inputArrayUsingDialog();
            if (array != null) {
                sortContext.setSortStrategy(selectedSort);
                sortContext.sort(array);
                outputTextArea
                        .setText(sortContext.getSortStrategy().getSortInfo());
            }
        });
        return sortButton;
    }

    /**
     * Creates a JButton for generating random numbers and adds an
     * ActionListener to it.
     *
     * @return The configured JButton for generating random numbers.
     */
    private JButton createRandomListButton() {
        JButton randomListButton = new JButton("Random Numbers");
        randomListButton.addActionListener(e -> {
            StringBuilder randomNumbersListToString = new StringBuilder();
            for (Integer number : generateRandomList()) {
                randomNumbersListToString.append(number).append(" ");
            }
            inputTextArea.setText(randomNumbersListToString.toString());
        });
        return randomListButton;
    }

    /**
     * Creates a JPanel with a GridLayout containing input and output panels.
     *
     * @return The JPanel containing input and output panels.
     */
    private JPanel createInputOutputPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
        panel.add(createInputPanel());
        panel.add(createOutputPanel());
        return panel;
    }

    /**
     * Creates a JPanel for user input with a vertical BoxLayout.
     *
     * @return The JPanel for user input.
     */
    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Enter numbers separated by spaces:"));
        panel.add(new JScrollPane(inputTextArea));
        return panel;
    }

    /**
     * Creates a JPanel for displaying sorting output with a vertical BoxLayout.
     *
     * @return The JPanel for displaying sorting output.
     */
    private JPanel createOutputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Sort Information:"));
        panel.add(new JScrollPane(outputTextArea));
        return panel;
    }

    /**
     * Creates a JPanel for selecting sorting algorithms with a left-aligned
     * FlowLayout.
     *
     * @return The JPanel for selecting sorting algorithms.
     */
    private JPanel createAlgorithmPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel("Choose sorting algorithm:"));
        panel.add(algorithmComboBox);
        return panel;
    }

    /**
     * Creates a JPanel for grouping and aligning buttons horizontally.
     *
     * @param buttons The buttons to be added to the panel.
     * @return The JPanel containing the specified buttons.
     */
    private JPanel createButtonPanel(JButton... buttons) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        for (JButton button : buttons) {
            panel.add(button);
        }
        return panel;
    }

    /**
     * Generates a list of random integers.
     *
     * @return a list of random integers.
     */
    private List<Integer> generateRandomList() {
        Random random = new Random();

        int maxListSize = 10000;
        int listSize = random.nextInt(maxListSize);

        List<Integer> resultList = new ArrayList<>(listSize);

        for (int i = 0; i < listSize; i++) {
            resultList.add(random.nextInt(10000));
        }

        return resultList;
    }

}
