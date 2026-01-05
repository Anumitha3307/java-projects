package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserRegistrationForm extends JFrame {
    JTextField nameField;
    Choice countryChoice;
    Checkbox termsCheck;
    TextArea commentsArea;
    JButton submitButton;

    public UserRegistrationForm() {
        setTitle("Registration Form");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("User Registration Form", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        JLabel countryLabel = new JLabel("Country:");
        countryChoice = new Choice();
        countryChoice.add("India");
        countryChoice.add("USA");
        countryChoice.add("UK");
        countryChoice.add("Canada");
        countryChoice.add("Australia");

        JLabel termsLabel = new JLabel("Accept Terms:");
        termsCheck = new Checkbox();

        JLabel commentsLabel = new JLabel("Comments:");
        commentsArea = new TextArea(3, 20);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitActionListener());

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(countryLabel);
        formPanel.add(countryChoice);
        formPanel.add(termsLabel);
        formPanel.add(termsCheck);
        formPanel.add(commentsLabel);
        formPanel.add(commentsArea);
        formPanel.add(new JLabel());
        formPanel.add(submitButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        setLayout(new BorderLayout(10, 10));
        add(titleLabel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    class SubmitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!termsCheck.getState()) {
                JOptionPane.showMessageDialog(UserRegistrationForm.this, "Please accept the terms and conditions.");
                return;
            }

            String name = nameField.getText();
            String country = countryChoice.getSelectedItem();
            String comments = commentsArea.getText();

            JOptionPane.showMessageDialog(UserRegistrationForm.this,
                "Name: " + name + "\nCountry: " + country + "\nComments: " + comments,
                "Form Submitted", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new UserRegistrationForm();
    }
}
