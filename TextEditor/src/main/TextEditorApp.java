package main;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

import controller.TextEditorController;
import model.TextEditorModel;
import view.TextEditorView;

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditorModel model = new TextEditorModel();
        TextEditorView view = new TextEditorView();
        TextEditorController controller = new TextEditorController(model, view);

        view.getTextArea().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    controller.addLine(view.getTextArea().getText());
                    view.getTextArea().setText("");
                }
            }
        });

        JFileChooser fileChooser = new JFileChooser();
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(e -> {
            int returnVal = fileChooser.showOpenDialog(view);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                controller.loadFromFile(file);
            }
        });

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> {
            int returnVal = fileChooser.showSaveDialog(view);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                controller.saveToFile(file);
            }
        });

        JMenuItem listFilesItem = new JMenuItem("List Files");
        listFilesItem.addActionListener(e -> {
            String directoryPath = JOptionPane.showInputDialog(view, "Enter directory path:");
            if (directoryPath != null && !directoryPath.isEmpty()) {
                controller.listFiles(directoryPath);
            }
        });

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(listFilesItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        view.setJMenuBar(menuBar);
    }
}

