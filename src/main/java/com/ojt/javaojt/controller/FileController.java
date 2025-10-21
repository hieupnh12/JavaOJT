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
                case 4:
                    break;
                case 5:
                    break;
                case 6: {
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
        this.fileView.saveFileStudent();
    }
    
    private void loadFromFile() {
        this.fileView.loadFileStudent();
    }
    
    public static void main(String[] args) {
        FileView fv = new FileView();
        FileController fl = new FileController(fv);
        fl.start();
    }
}
