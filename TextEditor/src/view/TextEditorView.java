package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class TextEditorView extends JFrame {
    private JTextArea textArea;
    private JButton saveButton;

    public TextEditorView() {
        setTitle("Text Editor");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    
//        // Tạo button "Save"
//        saveButton = new JButton("Save");
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.add(saveButton);
//        add(buttonPanel, BorderLayout.SOUTH);
//
        setVisible(true);
    }
//    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public void displayLines(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line).append("\n");
        }
        setText(builder.toString());
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

   
}


