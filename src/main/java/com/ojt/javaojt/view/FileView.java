package com.ojt.javaojt.view;

import com.ojt.javaojt.model.DataStore;
import com.ojt.javaojt.model.ListObject;
import com.ojt.javaojt.model.Student;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.validate_menu.Validation;

public class FileView {

    public Menu displayMenuFile() {
        Menu menu = new Menu();
        menu.addItem("Xem danh sach");
        menu.addItem("Save to file");
        menu.addItem("Load to file");
        return menu;
    }

    public int getOptionStudent(Menu menu) {
        return menu.getChoiceFromMenu("QUAN LI FILE");
    }

    public void displayAllObject() {
        ListObject listObject = new ListObject();
        System.out.println("DANH SACH");
        for (Object object : listObject.getListObject()) {
            System.out.println(object.toString());
        }
    }

    public void loadFileStudent() {
        try {
            System.out.print("Nhap vao file: ");
            String fileString = Validation.checkInputString();
            DataStore dataStore = new DataStore(fileString);
            dataStore.loadFromFile(fileString, Student::fromFileString);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
