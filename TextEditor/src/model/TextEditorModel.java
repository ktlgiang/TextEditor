package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextEditorModel {
    private List<String> lines;

    public TextEditorModel() {
        this.lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public void removeLine(int index) {
        if (index >= 0 && index < lines.size()) {
            lines.remove(index);
        }
    }

    public List<String> getLines() {
        return lines;
    }

    public void saveToFile(String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            lines.forEach(writer::println);
        }
    }

    public void loadFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            lines = reader.lines().collect(Collectors.toList());
        }
    }

    public void listFilesRecursive(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFilesRecursive(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
