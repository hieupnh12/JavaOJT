
package com.ojt.javaojt.controller;

import com.ojt.javaojt.data.StudentDAO;
import com.ojt.javaojt.model.CourseList;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.CourseView;
import com.ojt.javaojt.view.StudentView;
import java.io.IOException;
import java.sql.SQLException;


public class CourseController {
    private CourseView courseView;
    
   
  public CourseController(CourseView courseView) {
        this.courseView = courseView;
    }
 
    
    public void start() throws SQLException, IOException {
        int choice;
        Menu menu = courseView.displayMenuCouser();
        
        while (true) {            
            choice = courseView.getOptionCourse(menu);
            
            switch (choice) {
                case 1 -> addCourseFromFile();
                case 2 -> addCourseManual();
                case 3 -> listAllCourse();
                case 4 -> ExportCourseToExcel(); 
                case 5 -> deleteCourse();
                case 6 -> {
                    return;
                }
                default -> throw new AssertionError();
            }
        }
    }
    
    // add student
    public void addCourseFromFile() throws SQLException, IOException {
        CourseList cl = new CourseList();
        cl.readCourseFile();
        
    }
     public void addCourseManual() throws SQLException, IOException {
        CourseList cl = new CourseList();
        cl.insertCourseManual();
        
    }
   
    public void ExportCourseToExcel() throws SQLException {
         CourseList cl = new CourseList();
         cl.exportCourseTofile();
    }
    
   
    public void listAllCourse() throws SQLException {
         CourseList cl = new CourseList();
        CourseView sv = new CourseView(cl);
        sv.displayCourse();
    }
        public void deleteCourse() throws SQLException {
         CourseList cl = new CourseList();
        cl.deleteCourseById();
    }
 
} 
