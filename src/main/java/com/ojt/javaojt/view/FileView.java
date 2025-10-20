package com.ojt.javaojt.view;

import com.ojt.javaojt.model.DataStore;
import com.ojt.javaojt.model.ListObject;
import com.ojt.javaojt.model.Student;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.validate_menu.Validation;
import java.util.List;

public class FileView {
    private ListObject<Student> listStudent = new ListObject<>();
    
    public Menu displayMenuFile() {
        Menu menu = new Menu();
        menu.addItem("Xem danh sach");
        menu.addItem("Save to file");
        menu.addItem("Load to file can read");
        return menu;
    }

    public int getOptionStudent(Menu menu) {
        return menu.getChoiceFromMenu("QUAN LI FILE");
    }

    public void displayAllObject() {
        System.out.println("DANH SACH");
        if (!listStudent.getListObject().isEmpty()) {
            for (Object object : listStudent.getListObject()) {
                System.out.println(object.toString());
            }
        }else {
            System.out.println("Empty!");
        }
    }

    public void loadFileStudent() {
        try {
//            System.out.print("Nhap vao file: ");
//            String fileString = Validation.checkInputString();
            String fileString = "src/main/java/com/ojt/javaojt/data/dataStudent.txt";
            DataStore dataStore = new DataStore(fileString);
            List<Student> list = dataStore.loadFromFile(fileString, Student::fromFileString);
            listStudent.setListObject(list);
            
            for (Student student : listStudent.getListObject()) {
                System.out.println(student.printFile());
            }
        } catch (Exception e) {
            System.out.println("Loi " + e);
        }
    }
    
    public void addStudent(Student st) {
        listStudent.addObject(st);
    }
    
    public void saveFileStudent() {
        try {
            String fileString = "src/main/java/com/ojt/javaojt/data/dataStudent.txt";
            DataStore dataStore = new DataStore(fileString);
            dataStore.saveToFile(fileString, listStudent.getListObject());
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
