import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class UserInterface {
    public UserInterface() {
        // Create the main frame
        JFrame frame = new JFrame("Datastructure & Algorithms");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        frame.add(mainPanel);

        // Create the left panel with components
        JPanel leftPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.add(leftPanel);

        // Create the search panel with components using BoxLayout
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical stacking
        leftPanel.add(searchPanel);

        JTextField inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(Integer.MAX_VALUE, 30)); // Set preferred height
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30)); // Set maximum height
        searchPanel.add(inputField);

        JButton inputButton = new JButton("Press");
        inputButton.setAlignmentX(Component.LEFT_ALIGNMENT); // Align button to the left
        inputButton.setPreferredSize(new Dimension(Integer.MAX_VALUE, 30)); // Set preferred height
        inputButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30)); // Set maximum width
        searchPanel.add(inputButton);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        JButton button1 = new JButton("first algorithm");
        JButton button2 = new JButton("second algorithm");
        JButton button3 = new JButton("third algorithm");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        leftPanel.add(buttonPanel);

        // Create the right panel with text area
        JPanel rightPanel = new JPanel(new BorderLayout());
        mainPanel.add(rightPanel);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        // Set frame visibility
        frame.setVisible(true);
    }
}
