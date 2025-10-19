
package com.ojt.javaojt;

import com.ojt.javaojt.controller.UniversityManagementController;
import com.ojt.javaojt.view.UniversityManagementView;
import java.io.IOException;

import java.sql.SQLException;


/**
 *
 * @author hieup
 */
public class JavaOJT {


    public static void main(String[] args) throws SQLException, IOException {
        System.out.println("Hello World!");
        UniversityManagementView umv = new UniversityManagementView();
        UniversityManagementController umc = new UniversityManagementController(umv);
        
        umc.start();

    }
}
