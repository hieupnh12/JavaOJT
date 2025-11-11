
package com.ojt.testjdbc;

import com.ojt.testjdbc.connect.LectureDAO;
import com.ojt.testjdbc.model.Lecture;
import java.util.ArrayList;


/**
 *
 * @author hieup
 */
public class TestJDBC {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Lecture l1 = new Lecture("Hoang tu", "banggiam@gmail.com", "Van phong pham");
        
        LectureDAO lectureDAO = new LectureDAO();
//        lectureDAO.createAStudent(l1);
        ArrayList<Lecture> ls = lectureDAO.allLecture();
        for (Lecture l : ls) {
            System.out.println(l.toString());
        }
    }
}
