
package com.ojt.javaojt;

import com.ojt.javaojt.controller.UniversityManagementController;
import com.ojt.javaojt.view.UniversityManagementView;

/**
 *
 * @author hieup
 */
public class JavaOJT {

    public static void main(String[] args) {
        UniversityManagementView v = new UniversityManagementView();
        UniversityManagementController c = new UniversityManagementController(v);
        c.start();
                
    }
}
