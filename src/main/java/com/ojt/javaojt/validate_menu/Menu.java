
package com.ojt.javaojt.validate_menu;

import java.util.ArrayList;

public class Menu {

    private ArrayList<String> menu = new ArrayList<>();

    public Menu() {
    }

    public void addItem(String string) {
        this.menu.add(string);
    }

    public int getChoiceFromMenu(String nameMenu) {
        System.out.println("=================== " + nameMenu + " ====================");
        for (int i = 0; i < this.menu.size(); i++) {
            System.out.println((i + 1)+ ". " + this.menu.get(i));
            if ( i == this.menu.size()-1) {
                System.out.println((this.menu.size()+1) +". Exit!");
            }
        }
        
        System.out.print("Please choice one option: ");
        int options = Validation.checkInputIntLimit(1, (this.menu.size()+1));
        return options;
    }
}
