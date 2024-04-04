package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;

import model.TextEditorModel;
import view.TextEditorView;

public class TextEditorController {
    private TextEditorModel model;
    private TextEditorView view;

    public TextEditorController(TextEditorModel model, TextEditorView view) {
        this.model = model;
        this.view = view;
    }

    public void addLine(String line) {
        model.addLine(line);
    }

    public void removeLine(int index) {
        model.removeLine(index);
    }

    public List<String> getLines() {
        return model.getLines();
    }

    public void saveToFile(File file) {
        try {
            model.saveToFile(file.getAbsolutePath());
            view.showMessage("File saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            view.showMessage("Error occurred while saving file.");
        }
    }

    public void loadFromFile(File file) {
        try {
            model.loadFromFile(file.getAbsolutePath());
            view.displayLines(model.getLines());
            view.showMessage("File loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            view.showMessage("Error occurred while loading file.");
        }
    }

    public void listFiles(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            view.showMessage("Invalid directory path.");
            return;
        }
        model.listFilesRecursive(directory);
    }

}

