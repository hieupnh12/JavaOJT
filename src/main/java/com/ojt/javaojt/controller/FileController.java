package com.ojt.javaojt.controller;

import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.FileView;

public class FileController {

    private FileView fileView;

    public FileController() {
    }

    public FileController(FileView fileView) {
        this.fileView = fileView;
    }

    public void start() {
        int choice;
        Menu menu = fileView.displayMenuFile();

        while (true) {
            choice = fileView.getOptionStudent(menu);

            switch (choice) {
                case 1:
                    viewList();
                    break;
                case 2:
                    saveToFile();
                    break;
                case 3: 
                    loadFromFile();
                    break;
                case 4: {
                    return;
                }
                default:
                    throw new AssertionError();
            }
        }
    }

    private void viewList() {
        this.fileView.displayAllObject();
    }

    private void saveToFile() {
        
    }
    
    private void loadFromFile() {
        this.fileView.loadFileStudent();
    }
}
