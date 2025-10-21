package com.ojt.javaojt.view;

import com.ojt.javaojt.model.DataStore;
import com.ojt.javaojt.model.ListObject;
import com.ojt.javaojt.model.Student;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.validate_menu.Validation;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public class FileView {

    private ListObject<Student> listStudent = new ListObject<>();

    public Menu displayMenuFile() {
        Menu menu = new Menu();
        menu.addItem("Xem danh sach");
        menu.addItem("Save to file can read");
        menu.addItem("Load to file can read");
        menu.addItem("Save file object");
        menu.addItem("Load file object");
        menu.addItem("Add a student");
        return menu;
    }

    public int getOptionStudent(Menu menu) {
        return menu.getChoiceFromMenu("QUAN LI FILE");
    }

    public void displayAllObject() {
        try {
            System.out.println("DANH SACH");
            if (!listStudent.getListObject().isEmpty()) {
                for (Object object : listStudent.getListObject()) {
                    System.out.println(object.toString());
                }
            } else {
                System.out.println("Empty!");
            }
        } catch (Exception e) {
            System.out.println(e);
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

            for (Student student : list) {
                System.out.println(student.printFile());
            }
        } catch (Exception e) {
            System.out.println("Loi " + e);
        }
    }

    public void addStudent() throws ParseException {
        while (Validation.checkInputYN()) {            
            listStudent.addObject(inputStudent());
        }
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

    public void saveFileStream() {
        try {
            String fileString = "src/main/java/com/ojt/javaojt/data/dataStudentStream.txt";
            DataStore dataStore = new DataStore(fileString);
            dataStore.saveAll(this.listStudent.getListObject());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void readFileStream() {
        try {
            String fileString = "src/main/java/com/ojt/javaojt/data/dataStudentStream.txt";
            DataStore dataStore = new DataStore(fileString);
            this.listStudent.setListObject(dataStore.loadAll());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // input student
    public Student inputStudent() throws ParseException {
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        System.out.print("Enter yob: ");
        Date date = Validation.checkInputDate();
        System.out.print("Enter email: ");
        String email = Validation.checkInputEmail();
        
        return new Student(name, date, email);
    }
}
