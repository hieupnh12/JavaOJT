/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ojt.javaojt.controller;

import com.ojt.javaojt.data.LectureDAO;
import com.ojt.javaojt.data.Connect;
import com.ojt.javaojt.data.LectureDAO;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.LecturerView;
import com.ojt.javaojt.model.Lecturer;
import com.ojt.javaojt.validate_menu.Validation;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class LecturerController {
     private LecturerView uniView;

     
      LectureDAO lecture = new LectureDAO();
      Lecturer lec = new Lecturer();

     
    public LecturerController() {
    }

    public LecturerController(LecturerView uniView) {
        this.uniView = uniView;
    }
     
    public void start() throws SQLException {
        ListAllLecturer();
        int choice;
        Menu menu = this.uniView.displayMenuLecturer();

        while (true) {
            choice = this.uniView.getOptionLecturer(menu);

            switch (choice) {
                case 1:
                    addLecturer();
                    break;
                case 2:
                    updateLecturer();
                    break;
                case 3:
                    removeLecturer();
                    break;
                case 4:
                    this.uniView.register();
                    break;
                case 5:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }

      
      
      
    public void removeLecturer() throws SQLException {
        System.out.print("Enter id :");
        int id = Validation.checkInputInt();
        lecture.RemoveLecturer( id);
    }


     
     
     
     
    public void addLecturer() {    
        InputLecturer();
        lecture.AddLecturer(lec);
    }
     
    
    
    
    
     
    public void updateLecturer() throws SQLException {
        System.out.print("Enter id :");
        int id = Validation.checkInputInt();
        System.out.println();
        InputLecturer();     
        lecture.UpdateLecturer(lec,id);
    }

     
    
    
    
    
     public void ListAllLecturer() throws SQLException {
        LectureDAO lectureList = new LectureDAO();
        lectureList.ListAllLecturer();

        for (Lecturer lec : lectureList.getLecturers()) {
            System.out.println("" + lec.toString());
        }
    }
     
     
     
     public void InputLecturer(){
        System.out.print("Enter Name :");
        String name = Validation.checkInputString();
        System.out.println();

        System.out.print("Enter Email :");
        String emai = Validation.checkInputEmail2();
        System.out.println();

        System.out.print("Enter DepartMent :");
        String department = Validation.checkInputString();

        lec = new Lecturer( name, emai, department);
     }
     
     public static void main(String[] args) throws SQLException {
         LecturerView lecturerView = new LecturerView();
        LecturerController lec = new LecturerController(lecturerView);
        lec.start();
    }
}
