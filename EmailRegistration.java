import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EmailRegistration {
    private static ArrayList<String> registeredEmails = new ArrayList<>();
    private static JComboBox<String> emailBox; // Mailbox Dropdown

    public static void main(String[] args) {
        JFrame frame = new JFrame("Email Registration");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField(15);

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField(15);

        JLabel emailLabel = new JLabel("Email ID:");
        JTextField emailField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);

        JLabel mobileLabel = new JLabel("Mobile Number:");
        JTextField mobileField = new JTextField(15);

        JLabel referenceLabel = new JLabel("Reference Mail ID:");
        JTextField referenceField = new JTextField(15);

        JButton registerButton = new JButton("Register");
        JButton resetButton = new JButton("Reset");
        JButton cancelButton = new JButton("Cancel");
        JButton eraseButton = new JButton("Erase"); // New Erase Button

        // Mail Box (Dropdown)
        emailBox = new JComboBox<>();
        emailBox.addItem("Select Email"); // Default item
        JLabel mailBoxLabel = new JLabel("Mail Box:");

        // Register Button Action
        registerButton.addActionListener(e -> {
            String email = emailField.getText().trim();

            if (registeredEmails.contains(email)) {
                JOptionPane.showMessageDialog(frame, "Email already registered!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter an email!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                registeredEmails.add(email);
                emailBox.addItem(email); // Add email to the dropdown
                JOptionPane.showMessageDialog(frame, "You have successfully registered");
            }
        });

        // Reset Button Action
        resetButton.addActionListener(e -> {
            firstNameField.setText("");
            lastNameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            mobileField.setText("");
            referenceField.setText("");
        });

        // Cancel Button Action
        cancelButton.addActionListener(e -> frame.dispose());

        // Erase Button Action
        eraseButton.addActionListener(e -> {
            String selectedEmail = (String) emailBox.getSelectedItem();
            if (selectedEmail == null || selectedEmail.equals("Select Email")) {
                JOptionPane.showMessageDialog(frame, "Please select an email to erase", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                registeredEmails.remove(selectedEmail);
                emailBox.removeItem(selectedEmail);
                JOptionPane.showMessageDialog(frame, "Email removed: " + selectedEmail);
            }
        });

        // Layout Setup
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        frame.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(lastNameLabel, gbc);
        gbc.gridx = 1;
        frame.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(emailLabel, gbc);
        gbc.gridx = 1;
        frame.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(passwordLabel, gbc);
        gbc.gridx = 1;
        frame.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(mobileLabel, gbc);
        gbc.gridx = 1;
        frame.add(mobileField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(referenceLabel, gbc);
        gbc.gridx = 1;
        frame.add(referenceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        frame.add(registerButton, gbc);
        gbc.gridx = 1;
        frame.add(resetButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        frame.add(mailBoxLabel, gbc);
        gbc.gridx = 1;
        frame.add(emailBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        frame.add(eraseButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        frame.add(cancelButton, gbc);

        frame.setVisible(true);
    }
}
