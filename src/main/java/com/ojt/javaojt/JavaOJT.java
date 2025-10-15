
package com.ojt.javaojt;

import com.ojt.javaojt.controller.UniversityManagementController;
import com.ojt.javaojt.view.UniversityManagementView;

/**
 *
 * @author hieup
 */
public class JavaOJT {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        UniversityManagementView umv = new UniversityManagementView();
        UniversityManagementController umc = new UniversityManagementController(umv);
        
        umc.start();
    }
}
