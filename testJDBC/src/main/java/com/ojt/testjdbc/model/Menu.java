
package com.ojt.testjdbc.model;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    private ArrayList listMenu = new ArrayList();

    public Menu() {
    }
    
    public void addMenu(String function) {
        this.listMenu.add(function);
    }
    
    public int printMenu(String outputString) {
        System.out.println(outputString);
        
        for (int i = 0; i < this.listMenu.size(); i++) {
            System.out.println(this.listMenu.get(i));
            
            if (this.listMenu.size()-1 == i) {
                System.out.println("Exit");
            }
        }
        
        System.out.print("Choose: ");
        int option = checkInput(0, this.listMenu.size());
        return option;
    }
    
    public int checkInput(int min, int max) {
                        Scanner sc = new Scanner(System.in);

        while (true) {            
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    throw new NumberFormatException();
                } else {
                    return number;
                }
            } catch (Exception e) {
                System.err.print("Nhap lai: ");
            }
        }
    }
        
}
